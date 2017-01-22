package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.model.Student;
import com.utils.DBHelper;

public class UserDao {

	//TODO ʵ�������ݿ����ӻ�����ʵ��
	private Connection conn = DBHelper.getInitJDBCUtil().getConnection();
	private Student student = new Student();
	public Student login(String username, String password) {
		//TODO ���ݿ�����û��������Ƿ��ǺϷ��û���¼
		Statement st;
		//String username_ = "";
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM UserInfo where username='"+username+"' "
					+ "and passwd='"+password+"'");
			while (rs.next()) {				
				return getInfo(rs);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return null;
	}

	public Boolean register(String username, String password, int age) {
		// TODO �������ݵ����ݿ���,�ɹ�����true�����򷵻�false
		
		if(username.startsWith("admin") && !password.isEmpty()){
			return false;
		}
		return true;
	}
	
	public Student getInfo(ResultSet rs){
		//Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			student.setUsername(rs.getString("username"));
			student.setAddress(rs.getString("address"));
			student.setCardid(rs.getString("cardid"));
			student.setClass_(rs.getString("class_"));
			student.setMajor(rs.getString("major"));
			student.setSex(rs.getString("sex"));
			student.setQq(rs.getString("qq"));
			student.setPosition(rs.getString("position"));
			student.setTimeToSch(sdf.parse(rs.getString("time")));
			student.setTel(rs.getString("tel"));
			student.setSid(rs.getString("sid"));
			return student;
		} catch (SQLException | ParseException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return null;
	}

}
