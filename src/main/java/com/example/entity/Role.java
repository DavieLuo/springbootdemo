package com.example.entity;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class Role {
	
	private Integer roleId;
	private String roleName;
	private String roleDesc;
	
	private List<Permission> permissions;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
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
	
	public List<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	@Override
	public String toString() {
		return "Role{" +
				"roleId=" + roleId +
				", roleName='" + roleName + '\'' +
				", roleDesc='" + roleDesc + '\'' +
				", permissions=" + permissions +
				'}';
	}
}
