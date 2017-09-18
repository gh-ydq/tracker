package com.tracker.admin;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iot.tracker.controller.upstream.PGController;
import com.iot.tracker.dto.upstream.pg.PGPacketDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml","classpath:spring/spring-mvc.xml"})
public class UserInfoTest {
	@Autowired
	private PGController pgController;
	@Test
	public void testUserInfo(){
		pgController.savePGMsg(buildPgDto());
	}
	
	private PGPacketDto buildPgDto(){
		PGPacketDto pg = new PGPacketDto();
		pg.setImei(16909060);
		pg.setLat(12345678.67f);
		pg.setLng(45674567.7f);
		return pg;
	}
	
	public static void main(String[] args) {
		try {
			String ip = InetAddress.getLocalHost().getHostAddress();
			System.out.println(ip);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
