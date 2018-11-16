package com.example.service.serviceImpl;

import com.example.dao.PermissionDao;
import com.example.entity.Permission;
import com.example.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao dao;

    @Override
    public List<Permission> findAll() {
        return dao.findAll();
    }
}
