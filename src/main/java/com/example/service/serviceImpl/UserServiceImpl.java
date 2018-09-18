package com.example.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.UserDao;
import com.example.entity.User;
import com.example.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao dao;

	@Override
	public User getUserInfo(String name) {
		// TODO Auto-generated method stub
		return dao.queryByName(name);
	}

	@Override
	public User getUserInfo(Integer id) {
		// TODO Auto-generated method stub
		return dao.queryById(id);
	}

}
