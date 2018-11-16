package com.example.conf;

import com.example.entity.Permission;
import com.example.service.PermissionService;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class ShiroService {

    @Autowired
    private ShiroFilterFactoryBean shiroFilterFactoryBean;

    @Autowired
    private PermissionService permissionService;

    /**
     * 初始化权限
     * @return
     */
    public Map<String,String> InitPermissionFilter(){
        Map<String,String> map = new LinkedHashMap<>();
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
        map.put("/**","authc");
        return map;
    }


    public void updatePermission() {
        synchronized (shiroFilterFactoryBean) {
            AbstractShiroFilter shiroFilter;
            try {
                shiroFilter = (AbstractShiroFilter) shiroFilterFactoryBean.getObject();
            } catch (Exception e) {
                throw new RuntimeException("get ShiroFilter from shiroFilterFactoryBean error!");
            }

            PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();
            DefaultFilterChainManager manager = (DefaultFilterChainManager) filterChainResolver.getFilterChainManager();

            // 清空老的权限控制
            manager.getFilterChains().clear();

            shiroFilterFactoryBean.getFilterChainDefinitionMap().clear();
            shiroFilterFactoryBean.setFilterChainDefinitionMap(InitPermissionFilter());
            // 重新构建生成
            Map<String, String> chains = shiroFilterFactoryBean.getFilterChainDefinitionMap();
            for (Map.Entry<String, String> entry : chains.entrySet()) {
                String url = entry.getKey();
                String chainDefinition = entry.getValue().trim()
                        .replace(" ", "");
                manager.createChain(url, chainDefinition);
            }
        }
    }

}
