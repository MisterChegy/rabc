package com.chegy.service.impl;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chegy.dao.UserDao;
import com.chegy.model.User;
import com.chegy.service.UserService;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{
	@Resource
    private UserDao userDao;
	
    @Override
    public User findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userDao.findByUsername(username);
    }

	@Override
	public Page<User> selectAllWithDept(int page, int limit) {
		Sort sort = new Sort(Direction.DESC, "id");
		PageRequest pageable = PageRequest.of(page-1, limit, sort);
	    Page<User> pusers = userDao.findAll(pageable);
		
	    System.out.println("pusers = "+pusers.getContent());
	    return pusers;
	}
}