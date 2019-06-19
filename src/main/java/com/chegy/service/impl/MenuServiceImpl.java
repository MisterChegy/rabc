package com.chegy.service.impl;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chegy.dao.MenuDao;
import com.chegy.model.Menu;
import com.chegy.model.Role;
import com.chegy.model.User;
import com.chegy.service.MenuService;

@Service
@Transactional(readOnly = true)
public class MenuServiceImpl implements MenuService {

	@Resource
	private MenuDao menuDao;

	/**
	 * 获取当前登陆用户拥有的树形菜单 (admin 账户拥有所有权限.)
	 */
	public Set<Menu> selectCurrentUserMenuTree(User user) {
		
		Set<Menu> menus = new HashSet<Menu>();
		System.out.println("user = "+user);
		
		if(user.getRoles()==null) {
			return null;
		}
		//菜单列表
		for(Role r : user.getRoles()) {
			for(Menu m : r.getMenus()) {
				if(m.getParent()==null) {
					menus.add(m);
				}
			}
		}
		
		return menus;
	}

}
