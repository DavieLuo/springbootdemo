package com.example.service;

import com.example.entity.User;

public interface UserService {
	
	public User getUserInfo(String name);
	
	
	public User getUserInfo(Integer id);

}
