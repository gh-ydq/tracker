package com.tracker.admin;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocTest {
	private final String configLocation= "spring-mybatis.xml";
	private final String mvcConfig = "spring/spring-mvc.xml";
	
	@Test
	public void testIoc(){
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
		String[] beanNames = context.getBeanDefinitionNames();
		
		for(int i=0;i<beanNames.length;i++){
			System.out.println("父容器 第  "+i+"个"+beanNames[i]);
		}
		
		ApplicationContext mvccontext = new ClassPathXmlApplicationContext(mvcConfig);
		String[] mvcbeanNames = mvccontext.getBeanDefinitionNames();
		
		for(int i=0;i<mvcbeanNames.length;i++){
			System.out.println("子容器 第  "+i+"个"+mvcbeanNames[i]);
		}
	}
}
