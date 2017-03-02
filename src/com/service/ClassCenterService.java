package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.ClassCenterDao;
import com.model.ClassGroup;
import com.model.Classfare;
import com.model.Cource;

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

	public List<Cource> getClassCources(String classid) {
		List<Cource> list_old = classCenterDao.getClassCources(classid);
		//重组生成包含每天每个时间段的课程，如果某时间段不存在课程则用空格"&nbsp;"代替
		List<Cource> list_new = new ArrayList<>();
		for(int dayDiv=0; dayDiv<6; dayDiv++){
			for(int weekDiv=0; weekDiv<7; weekDiv++){
				boolean findRS = false;
				for(Cource c:list_old){
					if(c.getDaydivide()==dayDiv && c.getWeekday()==weekDiv){
						findRS = true;
						list_new.add(c);
						break;
					}
				}
				if(!findRS){
					list_new.add(new Cource(weekDiv,dayDiv,"&nbsp;"));
				}
				
			}
		}
		return list_new;
	}

}
