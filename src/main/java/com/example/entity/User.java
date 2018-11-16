package com.example.entity;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class User {
	
	private Integer id;
    private String userName;
    private String userPass;
    private Timestamp createTime;
    
    private List<Role> roles;
    
    
    
    
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public User(Integer id, String userName, String userPass, Timestamp createTime, List<Role> roles) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPass = userPass;
		this.createTime = createTime;
		this.roles = roles;
	}




	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userPass=" + userPass + ", createTime=" + createTime
				+ ", roles=" + roles + "]";
	}
    
    

}
