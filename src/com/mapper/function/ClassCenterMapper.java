package com.mapper.function;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.ClassGroup;
import com.model.Classfare;

public interface ClassCenterMapper {

	/**
	 * 获取用户所在班级的所有小组信息
	 * @param username 学生用户名
	 * @return 小组列表
	 */
	public List<ClassGroup> getGroups(String username);

	/**
	 * 添加班级小组
	 * @param group 小组实例
	 */
	public void addGroup(ClassGroup group);

	/**
	 * 查询用户所在班级的班费情况
	 * @param classid 班级ID
	 * @param startTime 开始时间
	 * @param endTime 终止时间
	 * @return 班费列表
	 */
	public List<Classfare> getClassfares(@Param("classid") String classid, @Param("startTime") String startTime, @Param("endTime") String endTime);

	/**
	 * 添加班级班费信息
	 * @param classfare 班级班费实例
	 */
	public void addClassfare(Classfare classfare);

}
