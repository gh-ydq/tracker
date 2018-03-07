package com.iot.tracker.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 
 * @author cxl
 *
 */
public class BizUtil {

	private static final String numberChar = "0123456789";
	
	private static final String BANK_AUTH_FREFIX = "BA_";  //银行鉴权流水号前缀
	private static final String BANK_AUTH_REQ_FREFIX = "APP_";  //鉴权申请接口流水号前缀
	private static final String REQ_LOG_FREFIX = "LOG_";
	private static final String ACC_LIMIT_FREFIX = "ACL_"; //账户额度流水号
	
	private static final String ACC_ACCOUNT_INFO = "ACC_"; //账户额度流水号
	
	private static final String USER_VERIFY_SCHEDULE_CODE = "VS_"; //用户认证信息表流水号
	
	public static final String USER_CODE_FREFIX = "TS_"; //用户编码前缀
	
	public static final String ID_VERIFY_CODE = "ID_"; //用戶认证编码前缀

	public static final String ID_CONTACTS_CODE = "LXR_"; //联系人流水号

	private static final String MQ_AUTH_FREFIX = "MQ_";  //MQ流水号前缀

	/**
	 * 生成6位随机数
	 * 
	 * @return
	 */
	public static String generateRandomNum() {
		// 生成6位随机数
		StringBuffer sb = new StringBuffer(); 
        Random random = new Random(); 
        for (int i = 0; i < 6; i++) { 
        	sb.append(numberChar.charAt(random.nextInt(numberChar.length()))); 
        } 
		return sb.toString();
	}
	
	
	/**
	 * 生成请求批次号
	 * 
	 * @return yyyyMMddHHmmssSSS + 随机6位数
	 */
	public static String generateReqBatchNo() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String time = dateFormat.format(new Date(System.currentTimeMillis()));
		String reqBatchNo = time + generateRandomNum();
		return reqBatchNo;
	}
	
	/**
	 * 银行鉴权流水号
	 */
	public static String generateBankAuthNo(){
		String code = generateReqBatchNo();
		return BANK_AUTH_FREFIX + code;
	}
	
	/**
	 * 鉴权申请接口流水号
	 */
	public static String generateBankAuthReqNo(){
		String code = generateReqBatchNo();
		return BANK_AUTH_REQ_FREFIX + code;
	}
	
	public static String generateReqLogNo(){
		String code = generateReqBatchNo();
		return REQ_LOG_FREFIX + code;
	}
	
	
	public static String generateAccLimitSn(){
		return ACC_LIMIT_FREFIX + generateReqBatchNo();
	}
	
	public static String generateAccAccountInfoCode(){
		return ACC_ACCOUNT_INFO + generateReqBatchNo();
	}
	
	public static String generateUserVerifyScheduleCode(){
		return USER_VERIFY_SCHEDULE_CODE + generateReqBatchNo();
	}
	
	
	public static String generateUserCode(){
		return USER_CODE_FREFIX + generateReqBatchNo();
	}
	
	public static String generateIdCode(){
		return ID_VERIFY_CODE + generateReqBatchNo();
	}
	
	public static String generateContactsCode(){
		return ID_CONTACTS_CODE + generateReqBatchNo();
	}
	
	/**
	 * MQ流水号
	 */
	public static String generateMQAuthNo(){
		String code = generateReqBatchNo();
		return MQ_AUTH_FREFIX + code;
	}
}
