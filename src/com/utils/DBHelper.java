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
 * 数据库辅助类
 * 用于管理Mybatis的SQLSessionFactory，创建唯一的实例并对外提供访问
 */
public class DBHelper {
	/*private static DBHelper dbHelper = null;
	private static Connection conn = null;
	private DBHelper(){}
	public static DBHelper getInitJDBCUtil() {
        if (dbHelper == null) {
            // 给类加锁 防止线程并发
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
	            // 注册驱动有如下方式：
	            // 1.通过驱动管理器注册驱动，但会注册两次，并且会对类产生依赖。如果该类不存在那就报错了。
	            // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	            // 2.与3类似
	            // System.setProperty("jdbc.drivers","com.mysql.jdbc.Driver");
	            Class.forName("com.mysql.jdbc.Driver");// 推荐使用方式
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	 
    // 获得连接
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
            // 给类加锁 防止线程并发
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
