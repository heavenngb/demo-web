package com.ngb.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ngb.project.demo.service.UserFunctionMenuService;
import com.ngb.project.demo.vo.UserFunctionMenuVO;

@Controller
@RequestMapping({ "/menu" })
public class UserFunctionMenuController {

	@Autowired
	private UserFunctionMenuService userService;

	@ResponseBody
	@RequestMapping(value = { "/findAll" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public List<UserFunctionMenuVO> findAll() {
		List<UserFunctionMenuVO> vos = this.userService.findAll();
		return vos;
	}
	
	@RequestMapping(value="main")
	public String mainPage() {
		return "menu/MenuMainPage";
	}
}