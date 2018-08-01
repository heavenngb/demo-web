package com.ngb.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ngb.project.demo.service.UserService;
import com.ngb.project.demo.vo.UserDetailVO;

@Controller
@RequestMapping({ "/user" })
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/findAll" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	@ResponseBody
	public List<UserDetailVO> findAll() {
		List<UserDetailVO> vos = this.userService.findAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/login");
		mv.addObject("userVOs", vos);
		return vos;
	}
	
	@RequestMapping(value="main")
	public String mainPage() {
		return "user/UserMainPage";
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public String addPage(UserDetailVO vo) {
		return this.userService.insertOrUpdata(vo);
	}
}