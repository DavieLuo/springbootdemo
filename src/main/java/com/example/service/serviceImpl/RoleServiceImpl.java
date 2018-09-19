package com.example.service.serviceImpl;

import com.example.dao.RoleDao;
import com.example.entity.Permission;
import com.example.entity.Role;
import com.example.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao dao;

    @Override
    public void addRole(Role role) {

    }

    @Override
    public void deleteRole(Integer roleId) {

    }

    @Override
    public Role queryRoleInfoById(Integer id) {
        return dao.getRoleById(id);
    }

    @Override
    public void updateRoleInfo(Integer roleId, List<Permission> pers) {

    }
}
