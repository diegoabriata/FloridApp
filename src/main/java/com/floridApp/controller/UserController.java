package com.floridApp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.floridApp.model.User;
import com.floridApp.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	 private UserService userService;
	 
	@RequestMapping(value= {"/","/login"}, method=RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
		    // The user is logged in
			model.setViewName("redirect:/home");
		}else {
			model.setViewName("user/login");
		}
		
		return model;
	 }
	 
	 @RequestMapping(value= {"/signup"}, method=RequestMethod.GET)
	 public ModelAndView signup() {
		 ModelAndView model = new ModelAndView();
		 User user = new User();
		 model.addObject("user", user);
		 model.setViewName("user/signup");
	  
		 return model;
	 }
	 
	 
	 @RequestMapping(value= {"/signup"}, method=RequestMethod.POST)
	 public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {
	  ModelAndView model = new ModelAndView();
	  User userExists = userService.findUserByEmail(user.getEmail());
	  
	  if(userExists != null) {
	   bindingResult.rejectValue("email", "error.user", "Ya existe una cuenta con el email ingresado, por favor ingrese otro email.");
	  }
	  if(bindingResult.hasErrors()) {
	   model.setViewName("user/signup");
	  } else {
	   userService.saveUser(user);
	   model.addObject("msg", "El usuario ha sido registrado exitosamente!!");
	   model.addObject("user", new User());
	   model.setViewName("user/signup");
	  }
	  
	  return model;
	 }
	 
	 @RequestMapping(value= {"/home"}, method=RequestMethod.GET)
	 public ModelAndView home(HttpServletRequest httpServletRequest) {
	  ModelAndView model = new ModelAndView();
	  //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  User user = userService.findUserByEmail(httpServletRequest.getUserPrincipal().getName());
	  
	  model.addObject("userName", user.getFirstname() + " " + user.getLastname());
	  model.setViewName("home/home");
	  return model;
	 }
	 
	 @RequestMapping(value= {"/access_denied"}, method=RequestMethod.GET)
	 public ModelAndView accessDenied() {
	  ModelAndView model = new ModelAndView();
	  model.setViewName("errors/access_denied");
	  return model;
	 }
}
