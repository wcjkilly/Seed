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
	 * ѧ���û���¼
	 * @param username �û���
	 * @param password ����
	 * @return ѧ���û����������¼ʧ���򷵻�null
	 */
	public Student login(@Param("username") String username, @Param("password") String password);
	
	/**
	 * ��ȡѧ���û���Ϣ
	 * @param username �û���
	 * @return ����ѧ���û�����ʵ����ʧ��ʱ����null
	 */
	public Student getUserInfo(String username);
	
	/**
	 * ��ȡѧ���û����ڰ༶����Ϣ
	 * @param username �û���
	 * @return �û����ڰ༶�Ķ���ʵ��
	 */
	public ClassInfo searchClass(String username);
	
	/**
	 * ��ȡѧ�����˳ɼ�
	 * @param username �û���
	 * @param subStartTime ��ʼʱ��
	 * @param subEndTime ����ʱ��
	 * @return �ӿ�ʼʱ�䵽����ʱ�����û����п�Ŀ�ĳɼ���Ϣ
	 */
	public List<ScoreView> getUserScores(@Param("username") String username, @Param("subStartTime") String subStartTime, @Param("subEndTime") String subEndTime);
	
	/**
	 * ��ȡ����ѧ����Ϣ
	 * @return ѧ�������б�
	 */
	public List<Student> getAllUsers();
	
	/**
	 * ��ȡ���˿��ڼ�¼
	 * @param username �û���
	 * @param attStart ��ʼʱ��
	 * @param attEnd ����ʱ��
	 * @param attWeek ������
	 * @return
	 */
	public List<Attendance> getUserAttendances(@Param("username") String username, @Param("attStart")	String attStart, @Param("attEnd") String attEnd, @Param("attWeek") String attWeek);

	/**
	 * �޸��û�����
	 * @param username �û���
	 * @param newPwd ������
	 */
	public void changePwd(@Param("username")String username, @Param("newPwd") String newPwd);
	
}
