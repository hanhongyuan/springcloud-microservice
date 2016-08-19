package com.cloud.dao;

import java.util.List;

import com.cloud.model.User;

public interface UserDao {

	List<User> findAll();
}
