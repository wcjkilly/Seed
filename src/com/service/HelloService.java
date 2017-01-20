package com.service;

import com.dao.HelloDao;

public class HelloService {
	
	private HelloDao helloDao = new HelloDao();
	
	public Boolean hello(String name){
		return helloDao.hello(name);
	}

}
