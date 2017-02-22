package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.model.Document;
import com.utils.DBHelper;

public class StudyCenterDao {
	// ʵ�������ݿ����ӻ�����ʵ��
	private Connection conn = DBHelper.getInitJDBCUtil().getConnection();
	//ʵ�������ڸ�ʽ����
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	//��ȡ���������б�
	public List<String> getDocType() {
		List<String> list = new ArrayList<>();
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM DocumentType");
			while (rs.next()) {				
				list.add(rs.getString("documenttype"));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//��ȡ���Ͽ�Ŀ�б�
	public List<String> getDocSub() {
		List<String> list = new ArrayList<>();
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM DocumentSub");
			while (rs.next()) {				
				list.add(rs.getString("documentsub"));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	//���������ļ���¼�����ݿ�
	public Boolean saveDocument(String docsub, String doctype, String docname,
			String nowTime, String relativePath) {
		Statement st;
		try {
			st = conn.createStatement();
			String sql = "INSERT INTO document(documentsub,documenttype,documentname,uploadtime,path) "
					+ "VALUES('"+docsub+"','"+doctype+"','"+docname+"','"+nowTime+"','"+relativePath+"')";
			int rs = st.executeUpdate(sql);
			st.close();
			return rs>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//��ȡ�����б�
	public List<Document> getAllDoc(String docSub,String docType) {
		List<Document> list = new ArrayList<>();
		Statement st;
		try {
			st = conn.createStatement();
			String sql = "SELECT * FROM Document ";
			if(docSub!=null && docType!=null){
				if("all".equals(docSub) && (!"all".equals(docType))){
					sql += "Where documenttype = '"+docType+"'";
				}else if("all".equals(docType) && (!"all".equals(docSub))){
					sql += "Where documentsub = '"+docSub+"'";
				}else if((!"all".equals(docType)) && (!"all".equals(docSub))){
					sql += "Where documentsub = '"+docSub+"' and documenttype = '"+docType+"'";
				}
			}
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {				
				setDocument(rs, list);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	private void setDocument(ResultSet rs,List<Document> list){
		Document document = new Document();
		try {
			document.setDocumentSub(rs.getString("documentsub"));
			document.setDocumentType(rs.getString("documenttype"));
			document.setDocumentName(rs.getString("documentname"));
			document.setPath(rs.getString("path"));
			document.setUploadTime(rs.getString("uploadtime"));
			list.add(document);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
