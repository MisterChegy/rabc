package com.chegy.service;

import org.springframework.data.domain.Page;

import com.chegy.model.User;

public interface UserService {

	User findByUsername(String username);

	Page<User> selectAllWithDept(int page, int limit);

}
