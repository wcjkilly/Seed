package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.utils.DBHelper;

public class HelloDao {
	
	private Connection conn = DBHelper.getInitJDBCUtil().getConnection();

	public Boolean hello(String name) {
		Statement st;
		String username = "";
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM test");
			while (rs.next()) {
				System.out.print(rs.getString(1));
				System.out.print("  ");
				System.out.println(rs.getString(2));
				username = rs.getString(2);
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
