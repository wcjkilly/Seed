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

	//ʵ�������ݿ����ӻ�����ʵ��
	private SqlSessionFactory sqlSessionFactory = DBHelper.getSqlSessionFactory();
	
	//��¼��֤
	public Boolean login(String username, String password) {
		Boolean result = false;
		//���ݿ�����û��������Ƿ��ǺϷ��û���¼
		SqlSession session = sqlSessionFactory.openSession();
		try {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			result = (mapper.login(username, password) != null);
		} finally {
			session.close();
		}
		return result;
	}
	
	//�޸�����
	public void changePwd(String username, String newPwd) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			mapper.changePwd(username, newPwd);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	//��ȡ������Ϣ
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

	//��ȡ�༶��Ϣ
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
	
	//��ȡ���˳ɼ�
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
	
	//��ȡ�û��б�
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

	/**
	 * ��ȡѧ��������Ϣ
	 * @param username �û���
	 * @param attStart ��ʼʱ��
	 * @param attEnd ����ʱ��
	 * @param attWeek ��X��ĵ�Y��
	 * @return
	 */
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
