package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {
	private static DBHelper dbHelper = null;
	private static Connection conn = null;
	private DBHelper(){}
	public static DBHelper getInitJDBCUtil() {
        if (dbHelper == null) {
            // ������� ��ֹ�̲߳���
            synchronized (DBHelper.class) {
                if (dbHelper == null) {
                	dbHelper = new DBHelper();
                }
            }
        }
        return dbHelper;
    }

	 static {
	        try {
	            // ע�����������·�ʽ��
	            // 1.ͨ������������ע������������ע�����Σ����һ�������������������಻�����Ǿͱ����ˡ�
	            // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	            // 2.��3����
	            // System.setProperty("jdbc.drivers","com.mysql.jdbc.Driver");
	            Class.forName("com.mysql.jdbc.Driver");// �Ƽ�ʹ�÷�ʽ
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	 
	    // �������
	    public Connection getConnection() {
	       if(conn==null){
	    	   try {
		            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/seed","root", "margin");
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
	       }
	        return conn;
	 
	    }

}
