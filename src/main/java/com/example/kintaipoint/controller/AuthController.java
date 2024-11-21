package com.example.kintaipoint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
	@GetMapping("/login")
	public String login() {
		return "index";
	}
	
	@GetMapping("/loggedIn")
	public String index() {
		return "afterLoggedIn";
	}
}
