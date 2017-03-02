package com.service;

import java.util.List;

import com.dao.ClassCenterDao;
import com.model.ClassGroup;

public class ClassCenterService {
	
	private ClassCenterDao classCenterDao = new ClassCenterDao();

	public List<ClassGroup> getGroups(String username) {
		return classCenterDao.getGroups(username);
	}

	public Boolean addGroup(ClassGroup group) {
		return classCenterDao.addGroup(group);
	}

}
