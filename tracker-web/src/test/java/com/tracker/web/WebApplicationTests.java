package com.tracker.web;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.tracker.web.entity.QUser;
import com.tracker.web.entity.User;
import com.tracker.web.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebApplicationTests {
	private Logger logger = LoggerFactory.getLogger(WebApplicationTests.class);
	@Autowired
	private UserServiceImpl userService;
	@Test
	public void contextLoads() {
		QUser quer = QUser.user;
		BooleanExpression expression = quer.name.eq("zhangsan");
		Iterator<User> userIterable = userService.findByUserExpression(expression).iterator();
		while(userIterable.hasNext()){
			User user = userIterable.next();
			logger.info("user name={},id={}",user.getName(),user.getId());

		}
	}

}
