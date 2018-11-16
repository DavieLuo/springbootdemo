package com.example.filter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.util.WebUtils;


import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class URLPathMatchingFilter extends PathMatchingFilter {

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        String requestURL = getPathWithinApplication(request);
        System.out.println("requestUrl:"+requestURL);
        Subject subject = SecurityUtils.getSubject();

        if(subject.isPermitted(requestURL)){
            return true;
        }
        UnauthorizedException ex = new UnauthorizedException("当前用户没有访问路径" + requestURL + "的权限");
        subject.getSession().setAttribute("ex",ex);
        WebUtils.issueRedirect(request, response, "/403");
        return false;
    }
}
