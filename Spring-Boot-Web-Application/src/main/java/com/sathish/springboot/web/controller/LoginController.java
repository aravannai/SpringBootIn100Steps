package com.sathish.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sathish.springboot.web.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	LoginService loginService;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginPage(ModelMap model ) {
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String showWelcome(@RequestParam String name, @RequestParam String password, ModelMap model ) {
		
		boolean isValid = loginService.validateUser(name, password);
		if(!isValid) {
			model.put("errorMessage" ,"Invalid Credentials");
			return "login";
		}
		model.put("name", name);
		return "welcome";
	}
}
