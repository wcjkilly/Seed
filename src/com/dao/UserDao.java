package com.dao;

public class UserDao {

	//TODO ʵ�������ݿ����ӻ�����ʵ��
	
	public Boolean login(String username, String password) {
		//TODO ���ݿ�����û��������Ƿ��ǺϷ��û���¼
		if("admin".equals(username)	&& "admin".equals(password)){
			return true;
		}
		return false;
	}

	public Boolean register(String username, String password, int age) {
		// TODO �������ݵ����ݿ���,�ɹ�����true�����򷵻�false
		
		if(username.startsWith("admin") && !password.isEmpty()){
			return false;
		}
		return true;
	}

}
