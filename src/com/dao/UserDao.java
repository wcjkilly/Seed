 package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mapper.function.StudentMapper;
import com.model.Attendance;
import com.model.ClassInfo;
import com.model.ScoreView;
import com.model.Student;
import com.utils.DBHelper;

public class UserDao {

	//实例化数据库连接或其他实例
	private SqlSessionFactory sqlSessionFactory = DBHelper.getSqlSessionFactory();
	
	//登录验证
	public Boolean login(String username, String password) {
		Boolean result = false;
		//数据库检查该用户名密码是否是合法用户登录
		SqlSession session = sqlSessionFactory.openSession();
		try {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			result = (mapper.login(username, password) != null);
		} finally {
			session.close();
		}
		return result;
	}
	
	//获取个人信息
	public Student getUserInfo(String username) {
		Student student = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			student = mapper.getUserInfo(username);
		} finally {
			session.close();
		}
		return student;
	}

	//获取班级信息
	public ClassInfo searchClass(String username) {
		ClassInfo classInfo = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			classInfo = mapper.searchClass(username);
		} finally {
			session.close();
		}
		return classInfo;
	}
	
	//获取个人成绩
	public List<ScoreView> getUserScores(String username, String subStartTime, String subEndTime) {
		List<ScoreView> list = new ArrayList<>();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			list = mapper.getUserScores(username, subStartTime, subEndTime);
		} finally {
			session.close();
		}
		return list;
	}
	
	//获取用户列表
	public List<Student> getAllUsers() {
		List<Student> list = new ArrayList<>();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			list = mapper.getAllUsers();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Attendance> getUserAttendances(String username,	String attStart, String attEnd, String attWeek) {
		List<Attendance> list = new ArrayList<>();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			list = mapper.getUserAttendances(username, attStart, attEnd, attWeek);
		} finally {
			session.close();
		}
		return list;
	}
	
}
