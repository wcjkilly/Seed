package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mapper.function.ClassCenterMapper;
import com.model.ClassGroup;
import com.model.Classfare;
import com.model.Cource;
import com.utils.DBHelper;

public class ClassCenterDao {

	//实例化数据库连接或其他实例
	private SqlSessionFactory sqlSessionFactory = DBHelper.getSqlSessionFactory();
	
	//获取该学生所在班级的所有小组
	public List<ClassGroup> getGroups(String username) {
		List<ClassGroup> list = new ArrayList<>();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			ClassCenterMapper mapper = session.getMapper(ClassCenterMapper.class);
			list = mapper.getGroups(username);
		} finally {
			session.close();
		}
		return list;
	}

	//添加班级小组
	public Boolean addGroup(ClassGroup group) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			ClassCenterMapper mapper = session.getMapper(ClassCenterMapper.class);
			mapper.addGroup(group);
			session.commit();
		} finally {
			session.close();
		}
		return group.getId()>0;
		
	}

	/**
	 * 获取班级班费情况
	 * @param classid 班级id
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return 开始时间到结束时间范围内的班级班费情况
	 */
	public List<Classfare> getClassfares(String classid, String startTime, String endTime) {
		List<Classfare> list = new ArrayList<>();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			ClassCenterMapper mapper = session.getMapper(ClassCenterMapper.class);
			list = mapper.getClassfares(classid, startTime, endTime);
		} finally {
			session.close();
		}
		return list;
	}

	//添加班级班费
	public Boolean addClassfare(Classfare classfare) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			ClassCenterMapper mapper = session.getMapper(ClassCenterMapper.class);
			mapper.addClassfare(classfare);
			session.commit();
		} finally {
			session.close();
		}
		return classfare.getId()>0;
	}

	//获取班级课程列表
	public List<Cource> getClassCources(String classid) {
		List<Cource> list = new ArrayList<>();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			ClassCenterMapper mapper = session.getMapper(ClassCenterMapper.class);
			list = mapper.getClassCources(classid);
		} finally {
			session.close();
		}
		return list;
	}

}
