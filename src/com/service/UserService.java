package com.service;

import com.dao.UserDao;
import com.model.Student;

public class UserService {
	
	private UserDao userDao = new UserDao();
	
	public Student login(String username,String password){
		return userDao.login(username,password);
	}
	
}
