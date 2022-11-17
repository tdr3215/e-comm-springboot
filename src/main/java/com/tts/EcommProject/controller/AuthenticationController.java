package com.tts.EcommProject.controller;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tts.EcommProject.model.User;
import com.tts.EcommProject.service.UserService;

@Controller
public class AuthenticationController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/signin")
	public String login(Model model) {
	model.addAttribute("user",new User());
		return "signin";
	}
	
	@GetMapping("/signup")
	public String registration(Model model) {
		model.addAttribute("user",new User());
		return "registration";
	}
	
	
	
	@PostMapping("/signup")
	public String createNewUser(@Valid User user, BindingResult bindingResult, Model model) {
		User userExists = userService.findByUsername(user.getUsername());
		if(userExists != null) {
			bindingResult.rejectValue("username","error.user","Username is already taken");
			bindingResult.rejectValue("password", "error.password","Invalid Password");
		}
		
		
		
		if(!bindingResult.hasErrors()) {
			
			userService.saveNew(user);
			model.addAttribute("success","Sign up successful!");
			model.addAttribute("user", new User());
		} 
		
		return "registration";
		
	}
	
	@PostMapping("/signin")
	public String signin(@Valid User user, 
			BindingResult bindingResult,
			HttpServletRequest request) throws ServletException {
		
		if(userService.findByUsername(user.getUsername())==null) {
			bindingResult.rejectValue("user","error.user","Could not find user");
		}
	
		if(bindingResult.hasErrors()) {
			List<ObjectError> errors = bindingResult.getAllErrors();
			
			for(ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
			
			
		}
			if(!bindingResult.hasErrors()) {
				request.login(user.getUsername(), user.getPassword());
				return "redirect:/";
			} 
			
		
		return "signin";
	
	} 
	
	
}
