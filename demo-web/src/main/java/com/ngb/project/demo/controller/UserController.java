package com.ngb.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ngb.project.demo.service.UserService;
import com.ngb.project.demo.vo.UserDetailVO;

@Controller
@RequestMapping({ "/user" })
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/findAll" })
	@ResponseBody
	public List<UserDetailVO> findAll() {
		List<UserDetailVO> vos = this.userService.findAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/login");
		mv.addObject("userVOs", vos);
		return vos;
	}
	
	@RequestMapping(value = { "/findByID/{id}" })
	@ResponseBody
	public UserDetailVO findByID(@PathVariable("id") String id) {
		return this.userService.findByID(id);
	}
	
	@RequestMapping(value="main")
	public String mainPage() {
		return "user/UserMainPage";
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public String addPage(UserDetailVO vo) {
		return this.userService.insert(vo);
	}
	
	@RequestMapping(value="edit",method=RequestMethod.POST)
	@ResponseBody
	public int editPage(UserDetailVO vo) {
		return this.userService.updata(vo);
	}
	
	@RequestMapping(value="remove",method=RequestMethod.POST)
	@ResponseBody
	public int removePage(@RequestParam("ids[]") List<String> ids) {
		return this.userService.remove(ids);
	}
}