package com.sathish.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sathish.springboot.web.service.WelcomeService;

@RestController
public class WelcomeNewController {

	//Auto wiring
	@Autowired
	private WelcomeService service;
	@Value("${welome.message}")
	private String welcomeMessage;

	@RequestMapping("/welcome")
	public String welcome() {
		return service.retrieveWelcomeMessage();
	}
}