package com.example.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserControler {
	
	@RequestMapping("/cs")
	public Object cs() {
		return "afa";
	}
}