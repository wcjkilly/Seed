package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mapper.function.ClassCenterMapper;
import com.model.ClassGroup;
import com.utils.DBHelper;

public class ClassCenterDao {

	//实例化数据库连接或其他实例
	private SqlSessionFactory sqlSessionFactory = DBHelper.getSqlSessionFactory();
	
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

}
