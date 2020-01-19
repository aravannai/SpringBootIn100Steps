package com.sathish.springboot.web.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sathish.springboot.web.model.Todo;
import com.sathish.springboot.web.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	TodoService todoService;

	@RequestMapping(value="/list-todos", method=RequestMethod.GET)
	public String showTodos(ModelMap model ) {
		String name = (String)model.get("name");
		model.put("todos", todoService.retrieveTodos(name));
		return "list-todos";
	}
	
	@RequestMapping(value="/add-todo", method=RequestMethod.GET)
	public String showAddTodos(ModelMap model ) {
		model.addAttribute("todo", new Todo(0, (String)model.get("name"), "", new Date(), false));
		return "todo";
	}
	
	@RequestMapping(value="/add-todo", method=RequestMethod.POST)
	public String addTodos(ModelMap model, @Valid Todo todo, BindingResult result ) {
		if(result.hasErrors()) {
			return "todo";
		}
		todoService.addTodo((String)model.get("name"), todo.getDesc(), new Date(), true);
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value="/delete-todo", method=RequestMethod.GET)
	public String deleteTodo(@RequestParam int id ) {
		todoService.deleteTodo(id);
		return "redirect:/list-todos";
	}

}
