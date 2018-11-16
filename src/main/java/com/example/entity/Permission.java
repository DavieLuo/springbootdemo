package com.example.entity;

import org.springframework.stereotype.Component;

@Component
public class Permission {
	
	private Integer permId;
	private String permission;
	private String url;


	public Integer getPermId() {
		return permId;
	}

	public void setPermId(Integer permId) {
		this.permId = permId;
	}

	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Permission{" +
				"permId=" + permId +
				", permission='" + permission + '\'' +
				", url='" + url + '\'' +
				'}';
	}
}
