package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entity.User;
import com.example.service.UserService;

@RunWith(SpringRunner.class)
@MapperScan("com.example.dao")
@SpringBootTest
public class SpringbootdemoApplicationTests {

	@Test
	public void contextLoads() {
	}

	
	@Autowired
	UserService service;
	
	@Test
	public void getUserInfo() {
		User user = service.getUserInfo("ad");
		System.out.println(user);
	
	}
}
