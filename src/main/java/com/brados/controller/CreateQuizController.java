package com.brados.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.brados.model.User;
import com.brados.service.UserService;

@Controller
public class CreateQuizController {
	
//	UserService userService;
//	private void setDataSource(UserService userService) {
//		this.userService = userService;
//	}
	
//	@RequestMapping(value = "/createQuiz", method = RequestMethod.GET)
//	public String getCreateQuiz(Model model, @RequestParam("name") String name) {
//		User user = new User();
//		user.setUser_name(name);
//		//userService.save(user);
//		model.addAttribute("user", user);
//		return "createQuiz";
//	}
//	
//	@RequestMapping(value = "/createQuiz", method =RequestMethod.POST)
//	public String postCreateQuiz(Model model) {
//		return  "redirect:createQuiz";
//	}

}
