package com.mapper.function;

import java.util.List;

import com.model.ClassGroup;

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

}
