package com.chegy.service;

import java.util.Set;

import com.chegy.model.Menu;
import com.chegy.model.User;

public interface MenuService {

	Set<Menu> selectCurrentUserMenuTree(User user);

}
