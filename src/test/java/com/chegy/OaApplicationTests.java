package com.chegy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;

import com.chegy.dao.UserDao;
import com.chegy.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OaApplicationTests {

	@Autowired
	private UserDao userDao;
	
	//测试dao的分页方法
	@Test
	public void contextLoads() {
	
		Sort sort = new Sort(Direction.DESC, "id");
		PageRequest pageable = PageRequest.of(0, 10, sort);
	    Page<User> pusers = userDao.findAll(pageable);
		
	    System.out.println("pusers = "+pusers.getContent());
	}

}
