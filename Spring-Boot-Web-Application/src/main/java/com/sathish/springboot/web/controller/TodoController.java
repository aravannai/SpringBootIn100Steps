package com.sathish.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sathish.springboot.web.service.TodoService;

@Controller
public class TodoController {
	
	@Autowired
	TodoService todoService;

	@RequestMapping(value="/list-todos", method=RequestMethod.GET)
	public String showTodos(ModelMap model ) {
		model.put("todos", todoService.retrieveTodos("Sathish"));
		return "list-todos";
	}
	
//	@RequestMapping(value="/login", method=RequestMethod.POST)
//	public String showWelcome(@RequestParam String name, @RequestParam String password, ModelMap model ) {
//		
//		boolean isValid = loginService.validateUser(name, password);
//		if(!isValid) {
//			model.put("errorMessage" ,"Invalid Credentials");
//			return "login";
//		}
//		return "welcome";
//	}
}
