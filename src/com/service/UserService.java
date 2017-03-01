package com.service;

import java.util.List;

import com.dao.UserDao;
import com.model.Attendance;
import com.model.ClassInfo;
import com.model.ScoreView;
import com.model.Student;

public class UserService {
	
	private UserDao userDao = new UserDao();
	
	public Boolean login(String username,String password){
		return userDao.login(username,password);
	}
	public Student getUserInfo(String username){
		return userDao.getUserInfo(username);
	}
	public List<Student> getAllUsers() {
		return userDao.getAllUsers();
	}
	public ClassInfo searchClass(String name){
		return userDao.searchClass(name);
	}
	
	public List<ScoreView> getUserScores(String username, String subStartTime, String subEndTime) {
		return userDao.getUserScores(username, subStartTime, subEndTime);
	}
	public List<Attendance> getUserAttendances(String username,	String attStart, String attEnd, String attWeek) {
		return userDao.getUserAttendances(username, attStart, attEnd,attWeek);
	}
	
}
