package com.ngb.project.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngb.project.demo.dao.IUserDao;
import com.ngb.project.demo.vo.UserDetailVO;

@Service
public class UserService {

	@Autowired
	private IUserDao userDao;

	public List<UserDetailVO> findAll() {
		return this.userDao.findAll();
	}

	public boolean checkLogin(String name, String password) {
		UserDetailVO vo = this.userDao.checkLogin(name, password);

		return vo != null;
	}
	
	
	public String insertOrUpdata(UserDetailVO vo) {
		int insert = this.userDao.insert(vo);
		return vo.getUserID();
	}
}