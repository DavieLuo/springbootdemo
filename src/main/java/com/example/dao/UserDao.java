package com.example.dao;

import com.example.entity.User;

public interface UserDao {
	
	
	public User queryById(Integer id);
	
	public User queryByName(String name);

}
