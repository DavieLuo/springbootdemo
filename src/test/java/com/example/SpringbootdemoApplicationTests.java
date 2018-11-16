package com.example;

import static org.junit.Assert.assertEquals;

import com.example.dao.RoleDao;
import com.example.entity.Role;
import com.example.service.RoleService;
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

	@Autowired
	private RoleService roleService;
	
	@Test
	public void getUserInfo() {
		User user = service.getUserInfo("a");
		System.out.println(user);
	
	}

	@Test
	public void getRoleInfo(){
		Role role = roleService.queryRoleInfoById(1);
		System.out.println(role);
	}
}
