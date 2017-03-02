package com.mapper.function;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.ClassGroup;
import com.model.Classfare;

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

	/**
	 * ��ѯ�û����ڰ༶�İ�����
	 * @param classid �༶ID
	 * @param startTime ��ʼʱ��
	 * @param endTime ��ֹʱ��
	 * @return ����б�
	 */
	public List<Classfare> getClassfares(@Param("classid") String classid, @Param("startTime") String startTime, @Param("endTime") String endTime);

	/**
	 * ��Ӱ༶�����Ϣ
	 * @param classfare �༶���ʵ��
	 */
	public void addClassfare(Classfare classfare);

}
