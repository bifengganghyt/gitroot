package com.kedacom.tz.birdie.web.backend.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "admin")
public class AdminController {
	
	@RequestMapping(value="/login")
	public String adminLogin(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("test springmvc...");
		return "test";
	}
}
