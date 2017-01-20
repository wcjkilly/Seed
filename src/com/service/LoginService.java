package com.service;

import com.dao.LoginDao;;

public class LoginService {
	private LoginDao loginDao = new LoginDao();
	
	public Boolean login(String name,String passwd){
		return loginDao.login(name, passwd);
	}
}
