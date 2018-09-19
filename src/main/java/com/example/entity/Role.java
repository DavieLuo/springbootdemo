package com.example.entity;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class Role {
	
	private Integer id;
	private String roleName;
	private String roleDesc;
	
	private Set<Permission> permissions;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	
	public Set<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", roleDesc=" + roleDesc + ", permissions=" + permissions
				+ "]";
	}
	
	
	
	
	
	
	

}
