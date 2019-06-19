package com.chegy.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chegy.model.User;
import com.chegy.service.RoleService;
import com.chegy.service.UserService;
import com.chegy.util.PageResultBean;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
    private UserService userService;
	
	@Resource
	private RoleService roleService;
	
	@GetMapping("/index")
    public String index() {
        return "user/user-list";
    }

	//用户列表
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public PageResultBean<User> getList(@RequestParam(value = "page", defaultValue = "1") int page,
                                          @RequestParam(value = "limit", defaultValue = "10")int limit) {
        Page<User> users = userService.selectAllWithDept(page, limit);
        List<User> lusers = users.getContent();
        
        for(int i=0;i<lusers.size();i++) {
        	lusers.get(i).setRoles(null);
        }
        return new PageResultBean<User>(users.getTotalElements(), lusers);

    }
    
    //用户添加或修改页面
    @GetMapping
    public String add(Model model) {
    	
    	System.out.println("roles = "+roleService.selectAll());
        model.addAttribute("roles", roleService.selectAll());
        
        return "user/user-add";
    }
    
    
}
