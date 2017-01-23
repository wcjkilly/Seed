package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.model.ClassInfo;
import com.model.Student;
import com.utils.DBHelper;

public class UserDao {

	//TODO 实例化数据库连接或其他实例
	private Connection conn = DBHelper.getInitJDBCUtil().getConnection();
	private Student student = new Student();
	private ClassInfo classinfo = new ClassInfo();
	public Student login(String username, String password) {
		//TODO 数据库检查该用户名密码是否是合法用户登录
		Statement st;
		//String username_ = "";
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM UserInfo where username='"+username+"' "
					+ "and passwd='"+password+"'");
			while (rs.next()) {				
				return setStuInfo(rs);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	public Boolean register(String username, String password, int age) {
		// TODO 插入数据到数据库中,成功返回true，否则返回false
		
		if(username.startsWith("admin") && !password.isEmpty()){
			return false;
		}
		return true;
	}
	
	private Student setStuInfo(ResultSet rs){
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return null;
	}

	public ClassInfo searchClass(String username) {
		// TODO Auto-generated method stub
		Statement st;
		ResultSet rs;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from classinfo where classid "
					+ "=(select classid from userinfo where userinfo.username='"+username+"')");
			while (rs.next()) {				
				return setClassInfo(rs);				
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    return null;
	}

	private ClassInfo setClassInfo(ResultSet rs) throws NumberFormatException, SQLException {
		// TODO Auto-generated method stub
		classinfo.setClass_(rs.getString("class"));
		classinfo.setClassflag(rs.getString("classflag"));
		classinfo.setClassid(Integer.valueOf(rs.getString("clasid")));
		classinfo.setClassqq(rs.getString("classqq"));
		classinfo.setEvaluate(Integer.valueOf(rs.getString("evaluate")));
		classinfo.setFteacher(rs.getString("fteacher"));
		classinfo.setSchool(rs.getString("school"));
		classinfo.setTalktime(rs.getString("talktime"));
		classinfo.setTel(rs.getString("tel"));
		return classinfo;
	}

}
