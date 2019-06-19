package com.chegy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chegy.dao.RoleDao;
import com.chegy.model.Role;
import com.chegy.service.RoleService;
@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService{

	@Resource
	private RoleDao roleDao;
	
	@Override
	public List<Role> selectAll() {
		// TODO Auto-generated method stub
		return roleDao.findAll();
	}

}
