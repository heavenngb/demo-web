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
	
	public UserDetailVO findByID(String id) {
		return this.userDao.findByID(id);
	}

	public boolean checkLogin(String name, String password) {
		UserDetailVO vo = this.userDao.checkLogin(name, password);

		return vo != null;
	}
	
	public String insert(UserDetailVO vo) {
		this.userDao.insert(vo);
		return vo.getUserID();
	}
	
	public int updata(UserDetailVO vo) {
		return this.userDao.update(vo);
	}
	
	public int remove(List<String> ids) {
		return this.userDao.remove(ids);
	}
}