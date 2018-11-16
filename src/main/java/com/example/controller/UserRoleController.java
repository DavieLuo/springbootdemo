package com.example.controller;

import com.example.conf.ShiroService;
import com.example.units.BackResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRoleController {

    @Autowired
    private ShiroService shiroService;

    @RequestMapping("/updatePermission")
    public Object updatePermission(){
        shiroService.updatePermission();
        return BackResult.getSuccess("更新成功",null);
    }

    @RequestMapping("/update")
    public Object updateCs(){

        return BackResult.getSuccess("更新",null);
    }

}
