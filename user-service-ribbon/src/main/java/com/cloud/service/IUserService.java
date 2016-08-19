package com.cloud.service;

import java.util.List;

import com.cloud.model.User;

public interface IUserService {

	public String add(Integer a, Integer b);
	public List<User> searchAll(); 
}
