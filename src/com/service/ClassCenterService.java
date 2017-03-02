package com.service;

import java.util.List;

import com.dao.ClassCenterDao;
import com.model.ClassGroup;
import com.model.Classfare;

public class ClassCenterService {
	
	private ClassCenterDao classCenterDao = new ClassCenterDao();

	public List<ClassGroup> getGroups(String username) {
		return classCenterDao.getGroups(username);
	}

	public Boolean addGroup(ClassGroup group) {
		return classCenterDao.addGroup(group);
	}

	public List<Classfare> getClassfares(String classid, String startTime,
			String endTime) {
		return classCenterDao.getClassfares(classid, startTime, endTime);
	}

	public Boolean addClassfare(Classfare classfare) {
		return classCenterDao.addClassfare(classfare);
	}

}
