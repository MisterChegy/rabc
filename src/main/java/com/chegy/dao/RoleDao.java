package com.chegy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chegy.model.Role;

public interface RoleDao extends JpaRepository<Role,Integer>{
	
}
