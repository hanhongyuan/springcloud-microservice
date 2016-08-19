package com.cloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.web.client.RestTemplate;

import com.cloud.dao.UserDao;
import com.cloud.model.User;
import com.cloud.service.IUserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
public class UserServiceImpl implements IUserService {

	@Autowired
	RestTemplate restTemplate;

	@Override
	public List<User> searchAll() {
		List<User> list = userMapper.findAll();
		return list;
	}

	@Autowired
	private UserDao userMapper;
	
	@HystrixCommand(fallbackMethod = "addFallback")
	@Override
	public String add(Integer a, Integer b) {
		
		return restTemplate.getForEntity("http://BOOK-SERVICE/add?a=" + a +"&b=" + b, String.class).getBody();
	}

	public String addFallback(Integer a, Integer b) {
		return "error";
	}

}
