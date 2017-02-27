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

import com.model.ClassInfo;
import com.model.ScoreView;
import com.model.Student;
import com.utils.DBHelper;

public class UserDao {

	//实例化数据库连接或其他实例
	private Connection conn = DBHelper.getInitJDBCUtil().getConnection();
	
	//登录验证
	public Boolean login(String username, String password) {
		//数据库检查该用户名密码是否是合法用户登录
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM UserInfo where username='"+username+"' "
					+ "and passwd='"+password+"'");
			if (rs.next()) {				
				return true;
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//获取个人信息
	public Student getUserInfo(String username) {
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM UserInfo where username='"+username+"'");
			while (rs.next()) {				
				return setStuInfo(rs);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//将个人信息数据库查询结果集转成javabean对象
	private Student setStuInfo(ResultSet rs){
		try {
			Student student = new Student();
			student.setUsername(rs.getString("username"));
			student.setAddress(rs.getString("address"));
			student.setCardid(rs.getString("cardid"));
			student.setClass_(rs.getString("class_"));
			student.setMajor(rs.getString("major"));
			student.setSex(rs.getString("sex"));
			student.setQq(rs.getString("qq"));
			student.setPosition(rs.getString("position"));
			student.setTimeToSch(rs.getString("time"));
			student.setTel(rs.getString("tel"));
			student.setSid(rs.getString("sid"));
			return student;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	//获取班级信息
	public ClassInfo searchClass(String username) {
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
			e.printStackTrace();
		}

	    return null;
	}
	//将班级信息数据库查询结果集转成javabean对象
	private ClassInfo setClassInfo(ResultSet rs) throws NumberFormatException, SQLException {
		ClassInfo classinfo = new ClassInfo();
		classinfo.setClass_(rs.getString("class"));
		classinfo.setClassflag(rs.getString("classflag"));
		classinfo.setClassid(Integer.valueOf(rs.getString("classid")));
		classinfo.setClassqq(rs.getString("classqq"));
		classinfo.setEvaluate(Integer.valueOf(rs.getString("evaluate")));
		classinfo.setFteacher(rs.getString("fteacher"));
		classinfo.setSchool(rs.getString("school"));
		classinfo.setTalktime(rs.getString("talktime"));
		classinfo.setTel(rs.getString("tel"));
		return classinfo;
	}
	
	//获取个人成绩
	public List<ScoreView> getUserScores(String username, String subStartTime, String subEndTime) {
		Statement st;
		List<ScoreView> list = new ArrayList<>();
		try {
			st = conn.createStatement();
			String sql = "SELECT score.username,score.subid,subinfo.sub,subinfo.starttime,subinfo.subscore,score.score "
					+ "FROM score INNER JOIN subinfo ON score.subid=subinfo.subid  "
					+ "WHERE score.username = '"+username+"' ";
			if(subStartTime!=null && subEndTime!=null){
				if("".equals(subStartTime) && (!"".equals(subEndTime))){
					sql += "AND subinfo.starttime<='"+subEndTime+"'";
				}else if("".equals(subEndTime) && (!"".equals(subStartTime))){
					sql += "AND subinfo.starttime>='"+subStartTime+"'";
				}else if((!"".equals(subStartTime)) && (!"".equals(subEndTime))){
					sql += "AND subinfo.starttime>='"+subStartTime+"' AND subinfo.starttime<='"+subEndTime+"'";
				}
			}
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {				
				setScoreView(rs, list);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	private void setScoreView(ResultSet rs,List<ScoreView> list){
		ScoreView scoreView = new ScoreView();
		try {
			scoreView.setUsername(rs.getString("username"));
			scoreView.setSubid(rs.getInt("subid"));
			scoreView.setSub(rs.getString("sub"));
			scoreView.setStarttime(rs.getString("starttime"));
			scoreView.setSubscore(rs.getDouble("subscore"));
			scoreView.setScore(rs.getDouble("score"));
			list.add(scoreView);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//获取用户列表
	public List<Student> getAllUsers() {
		List<Student> list = new ArrayList();
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM UserInfo");
			while (rs.next()) {				
				list.add(setStuInfo(rs));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	

}
