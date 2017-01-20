package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.model.DBHelper;

public class LoginDao {

	private Connection conn = DBHelper.getInitJDBCUtil().getConnection();

	public Boolean login(String name,String passwd) {
		Statement st;
		String username = "";
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM UserInfo where username='"+name+"' "
					+ "and passwd='"+passwd+"'");
			while (rs.next()) {
				username = rs.getString("username");
			}
			rs.close();
			st.close();
			if(name.equals(username)){
				return true;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;

	}
}
