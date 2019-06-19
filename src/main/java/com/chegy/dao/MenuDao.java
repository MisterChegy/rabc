package com.chegy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chegy.model.Menu;

public interface MenuDao extends JpaRepository<Menu,Long>{

//	List<Menu> findByUsername(String username);

	List<Menu> findAll();

}
