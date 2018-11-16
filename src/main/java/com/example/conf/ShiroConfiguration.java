package com.example.conf;



import com.example.entity.Permission;
import com.example.filter.URLPathMatchingFilter;
import com.example.service.PermissionService;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;

import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

import javax.servlet.Filter;
import java.util.*;

@Configuration
public class ShiroConfiguration {


    @Autowired
    private PermissionService permissionService;

    public URLPathMatchingFilter getURLPathMatchingFilter(){return new URLPathMatchingFilter();}


    @Bean
    public MyShiroRealm myShiroRealm(){
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        return myShiroRealm;
    }

    @Bean
    public SecurityManager securityManager(MyShiroRealm myShiroRealm) {
        DefaultWebSecurityManager  securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager( securityManager);
        Map<String,String> map = new LinkedHashMap<>();

        Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("rolefilter",getURLPathMatchingFilter());

        shiroFilterFactoryBean.setFilters(filterMap);
        //登录
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        //首页
        shiroFilterFactoryBean.setSuccessUrl("/main");

        //错误页面，认证不通过跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        //登出
        map.put("/logout","logout");
        map.put("/layui/**","anon");
        map.put("/js/**","anon");
        map.put("/css/**","anon");
        map.put("/img/**","anon");
        map.put("/static/**","anon");
        map.put("/authorize","anon");
        map.put("/accessToken","anon");
        map.put("/user/oauth2login","anon");
        map.put("/userInfo","anon");
        map.put("/loginUser","anon");

        List<Permission> permissions = permissionService.findAll();
        if(permissions!=null){
            permissions.forEach(pm->map.put(pm.getUrl(),"perms["+pm.getPermission()+"]"));

        }


      /*  map.put("/user/**","authc");*/
        //对所有用户认证
        map.put("/**","authc");

      /*  map.put("/user/**","rolefilter");*/




        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
