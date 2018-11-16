package com.example.controller;


import com.example.units.BackResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserControler {
	
	@RequestMapping("/cs")
	public Object cs() {
		return "afa";
	}


	@RequestMapping("/oauth2login")
	public Object toOauthLogin(HttpServletRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println("用户密码："+username+password);
		if(username==null||password==null) {
			return BackResult.getFail("参数有误");
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
			return BackResult.getSuccess("OK",null);
		} catch(Exception e) {
			return BackResult.getFail("登录失败！");
		}



	}

}
