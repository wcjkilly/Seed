package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mapper.function.StudyCenterMapper;
import com.model.Document;
import com.utils.DBHelper;

public class StudyCenterDao {
	// 实例化数据库连接或其他实例
	SqlSessionFactory sqlSessionFactory = DBHelper.getSqlSessionFactory();
	
	//获取资料类型列表
	public List<String> getDocType() {
		List<String> list = new ArrayList<>();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			StudyCenterMapper mapper = session.getMapper(StudyCenterMapper.class);
			list = mapper.getDocType();
		} finally {
			session.close();
		}
		return list;
	}
	
	//获取资料科目列表
	public List<String> getDocSub() {
		List<String> list = new ArrayList<>();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			StudyCenterMapper mapper = session.getMapper(StudyCenterMapper.class);
			list = mapper.getDocSub();
		} finally {
			session.close();
		}
		return list;
	}

	//保存资料文件记录到数据库
	public Boolean saveDocument(Document upDocTemp) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			StudyCenterMapper mapper = session.getMapper(StudyCenterMapper.class);
			mapper.saveDocument(upDocTemp);
			session.commit();
		} finally {
			session.close();
		}
		return upDocTemp.getId()>0;
	}
	
	//获取资料列表
	public List<Document> getAllDoc(String docSub,String docType) {
		List<Document> list = new ArrayList<>();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			StudyCenterMapper mapper = session.getMapper(StudyCenterMapper.class);
			list = mapper.getAllDoc(docSub, docType);
		} finally {
			session.close();
		}
		return list;
	}
	
}
