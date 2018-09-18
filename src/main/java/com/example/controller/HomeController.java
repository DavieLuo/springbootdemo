package com.example.controller;



import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "index";
	}
	
	@RequestMapping("login-error")
	public String login_error(Model model) {
		
		model.addAttribute("errorcode", "登陆失败");
		return "index";
		
	}
	@RequestMapping("/403")
	public String to403() {
		return "403";
	}
	
	
	@RequestMapping("/loginUser")
	public String loginUser(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("用户密码："+username+password);
		if(username==null||password==null) {
			return null;
		}
		UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,password);
	        System.out.println(usernamePasswordToken);
	        Subject subject = SecurityUtils.getSubject();
	        System.out.println(subject);
	        try {
	            subject.login(usernamePasswordToken);   //完成登录
	            System.out.println(subject.getPrincipal());
	        //    User user = (User) subject.getPrincipals();

	        //    session.setAttribute("user", username);
	            return "main";
	        } catch(Exception e) {
	            return "index";//返回登录页面
	        }
		
		
	}

}
