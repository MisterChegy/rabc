package com.chegy.controller;

import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chegy.model.Menu;
import com.chegy.model.User;
import com.chegy.service.MenuService;

@Controller
public class IndexController {
	
	@Resource
	private MenuService menuService;
	
	@RequestMapping({ "/", "/index" })
	public String index(Model model,HttpSession session) {

		User user = (User) session.getAttribute("user");
		System.out.println("user = "+user);
		
		if(user == null) {
			return "login";
		}
		//菜单列表
		Set<Menu> menuTreeVOS = menuService.selectCurrentUserMenuTree(user);
        model.addAttribute("menus", menuTreeVOS);
        
        System.out.println("menus = "+menuTreeVOS);
		return "index";
	}
}
