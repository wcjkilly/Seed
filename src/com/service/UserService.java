package com.service;

import com.dao.UserDao;

public class UserService {
	
	private UserDao userDao = new UserDao();
	
	public Boolean login(String username,String password){
		return userDao.login(username,password);
	}
	
}
