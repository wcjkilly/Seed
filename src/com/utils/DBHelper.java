package com.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * ���ݿ⸨����
 * ���ڹ���Mybatis��SQLSessionFactory������Ψһ��ʵ���������ṩ����
 */
public class DBHelper {
	/*private static DBHelper dbHelper = null;
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
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/public","root", "root33##");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
       }
        return conn;
 
    }*/
	
	
	
	private DBHelper(){}
	private static SqlSessionFactory sqlSessionFactory = null;
	
	public static SqlSessionFactory getSqlSessionFactory() {
        if (sqlSessionFactory == null) {
            // ������� ��ֹ�̲߳���
            synchronized (DBHelper.class) {
                if (sqlSessionFactory == null) {
					try {
						System.out.println("begin to init mybatis,reading config file.");
						String resource = "mybatis-config.xml";
						InputStream inputStream = Resources.getResourceAsStream(resource);
						sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("init mybatis failed");
					}
                }
            }
        }
        return sqlSessionFactory;
    }
	
}
