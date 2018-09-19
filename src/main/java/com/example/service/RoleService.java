package com.example.service;

import com.example.entity.Permission;
import com.example.entity.Role;

import java.util.List;

public interface RoleService {
    //添加角色
    public void addRole(Role role);
    //删除角色
    public void deleteRole(Integer  roleId);

    //查询角色下的权限信息
    public Role queryRoleInfoById(Integer id);

    //修改角色权限信息
    public void updateRoleInfo(Integer roleId, List<Permission> pers);

}
