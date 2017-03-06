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

	//ʵ�������ݿ����ӻ�����ʵ��
	private SqlSessionFactory sqlSessionFactory = DBHelper.getSqlSessionFactory();
	
	//��ȡ��ѧ�����ڰ༶������С��
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

	//��Ӱ༶С��
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
	 * ��ȡ�༶������
	 * @param classid �༶id
	 * @param startTime ��ʼʱ��
	 * @param endTime ����ʱ��
	 * @return ��ʼʱ�䵽����ʱ�䷶Χ�ڵİ༶������
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

	//��Ӱ༶���
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

	//��ȡ�༶�γ��б�
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
