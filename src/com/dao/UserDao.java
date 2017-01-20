package com.dao;

public class UserDao {

	//TODO 实例化数据库连接或其他实例
	
	public Boolean login(String username, String password) {
		//TODO 数据库检查该用户名密码是否是合法用户登录
		if("admin".equals(username)	&& "admin".equals(password)){
			return true;
		}
		return false;
	}

	public Boolean register(String username, String password, int age) {
		// TODO 插入数据到数据库中,成功返回true，否则返回false
		
		if(username.startsWith("admin") && !password.isEmpty()){
			return false;
		}
		return true;
	}

}
