package com.ngb.project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ngb.project.demo.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/login" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String login() {
		return "/login";
	}

	@RequestMapping(value = { "/check" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
	public ModelAndView check(String name, String password) {
		boolean checkLogin = this.userService.checkLogin(name, password);
		ModelAndView mv = new ModelAndView();
		if (checkLogin)
			mv.setViewName("/main");
		else {
			mv.setViewName("/loginErr");
		}
		mv.addObject("name", name);
		mv.addObject("password", password);
		return mv;
	}
}
