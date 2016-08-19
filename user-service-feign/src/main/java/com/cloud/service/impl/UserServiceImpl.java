package com.cloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.client.BookServiceClient;
import com.cloud.dao.UserDao;
import com.cloud.model.User;
import com.cloud.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	BookServiceClient bookClient;

	@Override
	public List<User> searchAll() {
		List<User> list = userMapper.findAll();
		return list;
	}

	@Autowired
	private UserDao userMapper;
	
	@Override
	public String add(Integer a, Integer b) {
		 return bookClient.add(a, b);
	}

}
