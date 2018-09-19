package com.example.entity;

import org.springframework.stereotype.Component;

@Component
public class Permission {
	
	private Integer id;
	private String permission;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	@Override
	public String toString() {
		return "Permission [id=" + id + ", permission=" + permission + "]";
	}
	
	

}
