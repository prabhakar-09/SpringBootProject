package com.myspringproject.springbootproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myspringproject.springbootproject.model.User;

@RestController
public class HomeController {

//	@Autowired
//	private User user;
	
	@RequestMapping("/")
	public String home() {
		return "Hello Dinu sir! It's working..";
	}
	
	@GetMapping("/user")
	public User user() {
		User user = new User();
		user.setId("1");
		user.setName("PikuNiku");
		user.setEmail("piku@gmail.com");
		
		return user;
	}
	
	@GetMapping("/{id1}/{id2}")
	public String pathVariable(@PathVariable String id1, @PathVariable String id2) {
		return "The path variable id1 " + id1 + " and id2 is " + id2;
	}
	
	@GetMapping("/requestParam")
	public String requestParams(@RequestParam String name, @RequestParam(name="emailId", required = false, defaultValue = "") String emailId) {
		return "Your name is " + name + " and email is " +emailId;
	}
}
