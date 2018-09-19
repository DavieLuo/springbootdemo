package com.example.conf;

import com.example.entity.Permission;
import com.example.entity.Role;
import com.example.entity.User;
import com.example.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService service;
    
    

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String username = (String) principalCollection.getPrimaryPrincipal();

        User user = service.getUserInfo(username);
        System.out.println(user);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for(Role role:user.getRoles()){
            simpleAuthorizationInfo.addRole(role.getRoleName());
            if(role.getPermissions()!=null){
                /* for(Permission permission:role.getPermissions()){
                 simpleAuthorizationInfo.addStringPermission(permission.getPermission());
                 }*/
                 role.getPermissions().forEach(permission -> {
                     simpleAuthorizationInfo.addStringPermission(permission.getPermission());
                 });
             }
        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if(authenticationToken.getPrincipal()==null){
            return null;
        }
        //获取用户信息
        String name = authenticationToken.getPrincipal().toString();
        User user = service.getUserInfo(name);
        System.out.println("1:"+user);
        if (user == null) {
            //这里返回后会报出对应异常
            return null;
        } else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, user.getUserPass(), getName());
            return simpleAuthenticationInfo;
        }

    }
}
