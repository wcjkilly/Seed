package com.mapper.function;

import java.util.List;

import com.model.ClassGroup;

public interface ClassCenterMapper {

	/**
	 * ��ȡ�û����ڰ༶������С����Ϣ
	 * @param username ѧ���û���
	 * @return С���б�
	 */
	public List<ClassGroup> getGroups(String username);

	/**
	 * ��Ӱ༶С��
	 * @param group С��ʵ��
	 */
	public void addGroup(ClassGroup group);

}
