package com.ngb.project.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngb.project.demo.dao.IUserFunctionMenuDao;
import com.ngb.project.demo.vo.UserFunctionMenuVO;

@Service
public class UserFunctionMenuService {

	@Autowired
	private IUserFunctionMenuDao menuDao;

	public List<UserFunctionMenuVO> findAll() {
		List<UserFunctionMenuVO> vos = this.menuDao.findAll();
		for (UserFunctionMenuVO vo : vos) {
			treeChildrenNode(vo);
		}
		return vos;
	}

	private void treeChildrenNode(UserFunctionMenuVO vo) {
		String id = vo.getId();
		List<UserFunctionMenuVO> childrenVOs = this.menuDao.findByPID(id);
		for (UserFunctionMenuVO tmp : childrenVOs) {
			treeChildrenNode(tmp);
		}
		vo.setChildren(childrenVOs);
	}
	
	public String insert(UserFunctionMenuVO vo) {
		if("0".equals(vo.getUfmPID())) {
			vo.setUfmPID("");
		}
		this.menuDao.insert(vo);
		return vo.getUfmID();
	}
}