package com.iot.tracker.core.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class RedisUtil {
	private static Logger logger = LoggerFactory.getLogger(RedisUtil.class);
	private volatile static JedisPool jedisPool;// 非切片连接池
	private static int defautlDb = 0;// 默认数据库
	private static final Object lockObj = new Object();
	public static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();// gson的格式化

	private static String serverHost;
	private static int serverPort;
	private static int serverMaxWait;
	private static int serverMaxTotal;
	private static int serverMaxIdle;
	private static boolean serverTestOnBorrow;
	private static int serverDefaultDb;
	private static String serverPassword = "";

	@Value("${redis.server.host}")
	public void setServerHost(String serverHost) {
		RedisUtil.serverHost = serverHost;
	}

	@Value("${redis.server.port}")
	public void setServerPort(int serverPort) {
		RedisUtil.serverPort = serverPort;
	}

	@Value("${redis.server.maxWaitMillis}")
	public void setServerMaxWait(int serverMaxWait) {
		RedisUtil.serverMaxWait = serverMaxWait;
	}

	@Value("${redis.server.maxTotal}")
	public void setServerMaxTotal(int serverMaxTotal) {
		RedisUtil.serverMaxTotal = serverMaxTotal;
	}

	@Value("${redis.server.maxIdle}")
	public void setServerMaxIdle(int serverMaxIdle) {
		RedisUtil.serverMaxIdle = serverMaxIdle;
	}

	@Value("${redis.server.testOnBorrow}")
	public void setServerTestOnBorrow(boolean serverTestOnBorrow) {
		RedisUtil.serverTestOnBorrow = serverTestOnBorrow;
	}

	@Value("${redis.server.defaultDb}")
	public void setServerDefaultDb(int serverDefaultDb) {
		RedisUtil.serverDefaultDb = serverDefaultDb;
	}

	/****
	 * 通过配置得到 Jedis
	 * 
	 * @return Jedis实例
	 */
	public static final Jedis getConnection() {
		Jedis jedis = null;
		try {// 双重检查
			if (jedisPool == null) {
				synchronized (lockObj) {
					if (jedisPool == null) {
						JedisPoolConfig config = new JedisPoolConfig();
						config.setMaxTotal(serverMaxTotal);
						config.setMaxIdle(serverMaxIdle);
						config.setMaxWaitMillis(serverMaxWait);
						config.setTestOnBorrow(serverTestOnBorrow);
						defautlDb = (serverDefaultDb > 15 || serverDefaultDb < 0) ? 0 : serverDefaultDb;
						String password = serverPassword;
						if (StringUtils.isBlank(password)) {// 没有设置密码
							jedisPool = new JedisPool(config, serverHost, serverPort);
						} else {// 设置密码
							jedisPool = new JedisPool(config, serverHost, serverPort, serverMaxWait, password);
						}
						logger.info("初始化池成功，连接信息：{}:{}?defautlDb={}", serverHost, serverPort, defautlDb);
					}
				}
			}
			jedis = jedisPool.getResource();
			jedis.select(defautlDb);
		} catch (Exception e) {
			logger.error("获取redis连接池失败", e);
			throw new RuntimeException(e);
		}
		return jedis;
	}

	/***
	 * 释放资源
	 *
	 * @param jedis
	 */
	public static final void returnResource(Jedis jedis) {
		try {
			if (jedis != null) {
				jedis.close();
			}
		} catch (Exception e) {
			logger.error("jedis释放连接失败", e);
			throw new RuntimeException(e);
		}
	}

	public static final void set(String key, String value, Integer expire) {
		Jedis jedis = null;
		try {
			jedis = getConnection();
			jedis.set(key, value);
			if (null != expire) {
				jedis.expire(key, expire);
			}
		} catch (Exception e) {
			logger.error("set设值失败", e);
			throw new RuntimeException(e);
		} finally {
			if (jedis != null) {
				returnResource(jedis);
			}
		}

	}

	/**
	 * 如果存在返回ture 不存在则set则返回false
	 * 
	 * 提示：如果宕机，这里相关的key数据不需要恢复，因为后续补偿订单会去补偿
	 * 
	 * @param key
	 * @param value
	 * @param expire
	 * @return
	 * 
	 * 		----------------------------- JedisConnectionException
	 *         这里的释放链接为测试类代码，先在这一个方法中使用，如果没有问题，再合关到全局的releaseResource中去
	 * 
	 * 
	 *         ----------------------------
	 */
	public static final boolean setNotExists(String key, String value, Integer expire) {
		Jedis jedis = null;
		try {
			jedis = getConnection();
			String oldValue = jedis.get(key);
			if (StringUtils.isEmpty(oldValue)) {
				jedis.set(key, value);
				if (null != expire) {
					jedis.expire(key, expire);
				}
			}
			if (StringUtils.isNotEmpty(oldValue)) {
				return true;
			}
			return false;
			/*
			 * } catch (Exception e) { logger.error("set设值失败", e); // throw new
			 * RuntimeException(e); } finally { if (jedis != null) {
			 * returnResource(jedis); } }
			 */
		} catch (JedisConnectionException e) {
			jedisPool.returnBrokenResource(jedis);
			logger.error("", e);
			// throw e;
		} catch (Exception e) {
			logger.error("set设值失败", e);
			// throw e;
		} finally {
			jedisPool.returnResource(jedis);
		}
		return true;

	}

	public static final String get(String key) {
		Jedis jedis = null;
		try {
			jedis = getConnection();
			String value = jedis.get(key);
			return value;
		} catch (Exception e) {
			logger.error("get取值失败", e);
			throw new RuntimeException(e);
		} finally {
			if (jedis != null) {
				returnResource(jedis);
			}
		}
	}

	public static final void set(String key, String value) {
		set(key, value, null);
	}

	/**
	 * incr a=1 ,incr a=2,incr a=3 根据key 做一个计数器
	 * 
	 * @param key
	 * @return 返回增加1后的值(第一次调用就是0+1)
	 */
	public static final long incr(String key) {
		Jedis jedis = null;
		long result = 0l;
		try {
			jedis = getConnection();
			result = jedis.incr(key);
		} catch (Exception e) {
			logger.error("incr失败", e);
			throw new RuntimeException(e);
		} finally {
			if (jedis != null) {
				returnResource(jedis);
			}
		}
		return result;
	}

	 public static long incr(String key,int expire){
	        Jedis jedis = null;
	        long result = 0l;
	        try{
	            jedis = getConnection();
	            result = jedis.incr(key);
	            expire(key,expire);
	        }catch(Exception ex){
	            throw new RuntimeException(ex);
	        }finally{
	            if(jedis != null){
	            	returnResource(jedis);
	            }
	        }
	        return result;
	    }
	 
	 
	/**
	 * 为一个已经存在的KEY 设置有效期
	 * 
	 * @param key
	 *            需要设置有效期的key
	 * @param seconds
	 *            有效期时间 秒(推荐写法 1*60 表示1分钟 容易看懂)
	 */
	public static final void expire(String key, int seconds) {
		Jedis jedis = null;
		try {
			jedis = getConnection();
			Long isSet = jedis.expire(key, seconds);
			if (isSet != 1l) {
				throw new RuntimeException("未设置有效的key值或key已经存在一个过期时间");
			}
		} catch (Exception e) {
			logger.error("expire失败", e);
			throw new RuntimeException(e);
		} finally {
			if (jedis != null) {
				returnResource(jedis);
			}
		}
	}
	
	public static boolean validateKey(String prefix,String key, int expireTime) {
		long i = incr(prefix + key, expireTime);
		if (i > 4) {
			del(key);
		} else if (i == 1) {
			return true;
		}
		return false;
	}
	

	/**
	 * 用来检测某个Key 还有多少有效时间（秒）
	 * 
	 * @param key
	 *            需要查看有效期的key
	 * @return 正数表示剩余的有效期 -1表示参数已经过期， -2表示没有存在的Key
	 */
	public static final Long ttl(String key) {
		Jedis jedis = null;
		Long seconds = null;
		try {
			jedis = getConnection();
			seconds = jedis.ttl(key);
		} catch (Exception e) {
			logger.error("ttl失败", e);
			throw new RuntimeException(e);
		} finally {
			if (jedis != null) {
				returnResource(jedis);
			}
		}
		return seconds;
	}

	/**
	 * 删除key
	 * 
	 * @param key
	 *            需要删除的key
	 * @return true:删除成功 ,false:其他失败
	 */
	public static final boolean del(String key) {
		Jedis jedis = null;
		Long ret = 0L;
		try {
			jedis = getConnection();
			ret = jedis.del(key);
			if (ret == 1L) {
				return true;
			}
			return false;
		} catch (Exception e) {
			logger.error("del失败", e);
			throw new RuntimeException(e);
		} finally {
			if (jedis != null) {
				returnResource(jedis);
			}
		}
	}

	/**
	 * 想一个List尾部插入缓存内容
	 * 
	 * @param key
	 *            list名字
	 * @param value
	 *            插入的内容
	 */
	public static final void lpushList(String key, List<String> value) {
		lpushArray(key, value.toArray(new String[] {}));
	}

	/**
	 * 想一个List尾部插入缓存内容
	 * 
	 * @param key
	 *            list名字
	 * @param value
	 *            插入的内容
	 */
	public static final void lpushArray(String key, String... value) {
		Jedis jedis = null;
		try {
			jedis = getConnection();
			jedis.lpush(key, value);
		} catch (Exception e) {
			logger.error("lpushArray失败", e);
			throw new RuntimeException(e);
		} finally {
			if (jedis != null) {
				returnResource(jedis);
			}
		}
	}

	/*****
	 * 把对象做为Map存放到Redis
	 * 
	 * @param jedis
	 *            连接的引用，外部传入
	 * @param key
	 *            要放入的key值
	 * @param obj
	 *            要放入的对象
	 * @param expire
	 *            超时时间，单位（秒）
	 */
	public static final <T extends Serializable> void putObjByMap(String key, T obj, Integer expire) {
		Jedis jedis = null;
		try {
			jedis = getConnection();
			Map<String, String> inpumap = ReflectAssist.convertMapFromBean(obj);
			jedis.hmset(key, inpumap);
			if (expire != null) {
				jedis.expire(key, expire);
			}
		} catch (Exception e) {
			logger.error("把对象做为Map存放到Redis失败", e);
			throw new RuntimeException(e);
		} finally {
			if (jedis != null) {
				returnResource(jedis);
			}
		}
	}

	/***
	 * 把对象做为Map存放到Redis，没有超时时间，永久性放入
	 * 
	 * @param jedis
	 *            连接的引用，外部传入
	 * @param key
	 *            要放入的key值
	 * @param obj
	 *            要放入的对象
	 */
	public static final <T extends Serializable> void putObjByMap(String key, T obj) {
		putObjByMap(key, obj, null);
	}

	/***
	 * 取Map指定列的值
	 * 
	 * @param jedis
	 *            连接的引用，外部传入
	 * @param key
	 *            要放入的key值
	 * @param fields
	 *            要取的列名
	 * @return
	 */
	public static final Map<String, String> getMapByField(String key, String... fields) {
		Jedis jedis = null;
		Map<String, String> retobj = new HashMap<String,String>();
		try {
			jedis = getConnection();
			if (jedis == null || StringUtils.isBlank(key) || ArrayUtils.isEmpty(fields)) {
				return retobj;
			}
			List<String> values = jedis.hmget(key, fields);
			for (String string : values) {
				if (StringUtils.isEmpty(string)) {
					return retobj;
				}
			}
			if (ArrayUtils.isNotEmpty(fields) && CollectionUtils.isNotEmpty(values)) {
				for (int i = 0; i < fields.length; i++) {
					retobj.put(fields[i], values.get(i));
				}
			}
		} catch (Exception e) {
			logger.error("取Map指定列的值失败", e);
			throw new RuntimeException(e);
		} finally {
			if (jedis != null) {
				returnResource(jedis);
			}
		}
		return retobj;
	}

	/**
	 * 获取map中所有列的值
	 * 
	 * @param key
	 * @return
	 */
	public static final Map<String, String> hgetAll(String key) {
		Jedis jedis = null;
		Map<String, String> retobj = new HashMap<String, String>();
		try {
			jedis = getConnection();
			if (jedis == null || StringUtils.isEmpty(key)) {
				return retobj;
			}
			Map<String, String> values = jedis.hgetAll(key);
			if (!values.isEmpty() && values.size() > 0) {
				return values;
			}
		} catch (Exception e) {
			logger.error("取Map所有列的值失败", e);
			throw new RuntimeException(e);
		} finally {
			if (jedis != null) {
				returnResource(jedis);
			}
		}
		return retobj;
	}

	/**
	 * @method lpushObjByJson 把object转为json存入list
	 * @return void
	 * @author llq
	 * @date 2016年1月19日 下午3:22:49
	 */
	public static final <T extends Serializable> void lpushObjByJson(String key, T obj, Integer expire) {
		Jedis jedis = null;
		try {
			jedis = getConnection();
			String json = gson.toJson(obj);
			jedis.lpush(key, json);
			if (expire != null) {
				jedis.expire(key, expire);
			}
		} catch (Exception e) {
			logger.error("把object转为json存入list失败", e);
			throw new RuntimeException(e);
		} finally {
			if (jedis != null) {
				returnResource(jedis);
			}
		}
	}

	/**
	 * @method lpushObjByJson 把object列表转为json存入list
	 * @param key
	 * @param objList
	 * @param expire
	 */
	public static final <T extends Serializable> void lpushObjListByJson(String key, List<T> objList, Integer expire) {
		Jedis jedis = null;
		try {
			jedis = getConnection();
			for (T t : objList) {
				String json = gson.toJson(t);
				jedis.lpush(key, json);
			}
			if (expire != null) {
				jedis.expire(key, expire);
			}
		} catch (Exception e) {
			logger.error("把对象集合转为json存入redis失败", e);
			throw new RuntimeException(e);
		} finally {
			if (jedis != null) {
				returnResource(jedis);
			}
		}
	}

	/**
	 * @method getObjListByJsonValue 把list中的json取出为object的list
	 * @return List<T> 如果key不存在，返回null；如果list为空，返回空list
	 * @author llq
	 * @date 2016年1月14日 上午11:09:39
	 */
	public static final <T extends Serializable> List<T> getObjListByJsonValue( String key , Class<T> clazz ) {
		Jedis jedis = null;
		List<T> tList = new ArrayList();
		try {
			jedis = getConnection();
			if (!jedis.exists(key)) {
				return null;
			}
			List<String> jsonstrList = jedis.lrange(key, 0, -1);
			for (String jsonstr : jsonstrList) {
				T retobj = gson.fromJson(jsonstr, clazz);
				tList.add(retobj);
			}
		} catch (Exception e) {
			logger.error("把list中的json取出为object的list失败", e);
			throw new RuntimeException(e);
		} finally {
			if (jedis != null) {
				returnResource(jedis);
			}
		}
		return tList;
	}

	/**
	 * @method saddObjByJson 把object转为json存入set
	 * @return void
	 * @author llq
	 * @date 2016年1月19日 下午3:25:09
	 */
	public static final <T extends Serializable> void saddObjByJson(String key, T obj, Integer expire) {
		Jedis jedis = null;
		try {
			jedis = getConnection();
			String json = gson.toJson(obj);
			jedis.sadd(key, json);
			if (expire != null) {
				jedis.expire(key, expire);
			}
		} catch (Exception e) {
			logger.error("把object转为json存入set失败", e);
			throw new RuntimeException(e);
		} finally {
			if (jedis != null) {
				returnResource(jedis);
			}
		}

	}

	/**
	 * @method getObjSetByJsonValue 把set中的json取出为object的set
	 * @return Set<T>
	 * @author llq
	 * @date 2016年1月19日 下午3:26:00
	 */
	public static final <T extends Serializable> Set<T> getObjSetByJsonValue( String key,Class<T> clazz ) {
		Jedis jedis = null;
		Set<T> tSet = new HashSet<T>();
		try {
			jedis = getConnection();
			if (!jedis.exists(key)) {
				return null;
			}
			Set<String> jsonstrSet = jedis.smembers(key);

			for (Iterator<String> iterator = jsonstrSet.iterator(); iterator.hasNext();) {
				String string = iterator.next();
				T retobj = gson.fromJson(string, clazz);
				tSet.add(retobj);
			}
		} catch (Exception e) {
			logger.error("把set中的json取出为object的set失败", e);
			throw new RuntimeException(e);
		} finally {
			if (jedis != null) {
				returnResource(jedis);
			}
		}
		return tSet;
	}

	/***
	 * 把对象做为Json存放到Redis
	 * 
	 * @param jedis
	 *            连接的引用，外部传入
	 * @param obj
	 *            要放入的对象
	 * @param key
	 *            要放入的key值
	 * @param expire
	 *            超时时间，单位（秒）
	 */
	public static final <T extends Serializable> void putObjByJson(String key, T obj, Integer expire) {
		Jedis jedis = null;
		try {
			jedis = getConnection();
			String json = gson.toJson(obj);
			jedis.set(key, json);
			if (expire != null) {
				jedis.expire(key, expire);
			}
		} catch (Exception e) {
			logger.error("把对象做为Json存入失败", e);
			throw new RuntimeException(e);
		} finally {
			if (jedis != null) {
				returnResource(jedis);
			}
		}
	}

	/****
	 * 把对象做为Json存放到Redis
	 * 
	 * @param jedis
	 *            连接的引用，外部传入
	 * @param obj
	 *            要放入的对象
	 * @param key
	 *            要放入的key值
	 */
	public static final <T extends Serializable> void putObjByJson(String key, T obj) {
		putObjByJson(key, obj, null);
	}

	/***
	 * Redis上的值为Json,取对象的值
	 * 
	 * @param clazz
	 *            要返回的对象的类
	 * @param jedis
	 *            连接的引用，外部传入
	 * @param key
	 *            要放入的key值
	 * @return
	 */
	public static final <T extends Serializable> T getObjByJsonValue(  String key , Class<T> clazz) {
		Jedis jedis = null;
		try {
			jedis = getConnection();
			String jsonstr = jedis.get(String.valueOf(key));
			T retobj = gson.fromJson(jsonstr, clazz);
			return retobj;
		} catch (Exception e) {
			logger.error("取出json对象失败", e);
			throw new RuntimeException(e);
		} finally {
			if (jedis != null) {
				returnResource(jedis);
			}
		}
	}

}
