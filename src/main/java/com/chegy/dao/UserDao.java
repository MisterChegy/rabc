package com.chegy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chegy.model.User;

public interface UserDao extends JpaRepository<User,Integer>{

	User findByUsername(String username);

}
