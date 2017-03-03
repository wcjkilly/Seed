package com.mapper.function;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.model.Attendance;
import com.model.ClassInfo;
import com.model.ScoreView;
import com.model.Student;

public interface StudentMapper {
	
	/**
	 * 学生用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return 学生用户对象，如果登录失败则返回null
	 */
	public Student login(@Param("username") String username, @Param("password") String password);
	
	/**
	 * 获取学生用户信息
	 * @param username 用户名
	 * @return 返回学生用户对象实例，失败时返回null
	 */
	public Student getUserInfo(String username);
	
	/**
	 * 获取学生用户所在班级的信息
	 * @param username 用户名
	 * @return 用户所在班级的对象实例
	 */
	public ClassInfo searchClass(String username);
	
	/**
	 * 获取学生个人成绩
	 * @param username 用户名
	 * @param subStartTime 开始时间
	 * @param subEndTime 结束时间
	 * @return 从开始时间到结束时间内用户所有科目的成绩信息
	 */
	public List<ScoreView> getUserScores(@Param("username") String username, @Param("subStartTime") String subStartTime, @Param("subEndTime") String subEndTime);
	
	/**
	 * 获取所有学生信息
	 * @return 学生对象列表
	 */
	public List<Student> getAllUsers();
	
	/**
	 * 获取个人考勤记录
	 * @param username 用户名
	 * @param attStart 开始时间
	 * @param attEnd 结束时间
	 * @param attWeek 年周数
	 * @return
	 */
	public List<Attendance> getUserAttendances(@Param("username") String username, @Param("attStart")	String attStart, @Param("attEnd") String attEnd, @Param("attWeek") String attWeek);

	/**
	 * 修改用户密码
	 * @param username 用户名
	 * @param newPwd 新密码
	 */
	public void changePwd(@Param("username")String username, @Param("newPwd") String newPwd);
	
}
