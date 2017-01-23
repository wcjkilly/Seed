package com.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.model.ClassInfo;
import com.model.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;

public class UserAction extends ActionSupport {
	
	//���ڽ���form���Ĳ���
	private String username;
	private String password;
	//���ڽ���Ϣ���ص�jspҳ��
	private String msg;
	//���ڵ���ҵ���ķ���
	private UserService userService = new UserService();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Action(value = "userLogin", results = {
			@Result(name = "success", location = "/homepage.jsp"),
			@Result(name = "login", location = "/login.jsp") })
	
	public String login() {
		System.out.println("�û���¼��"+getUsername());
		//�жϵ�¼�Ƿ�Ϸ�
		Boolean result = userService.login(getUsername(), getPassword());
		if (result) {
			//sessionд������Ψһ��ʶ��ͨ������Ҫ����
			ActionContext.getContext().getSession().put("username",getUsername());
			return SUCCESS;
		} else {
			setMsg("�û��������벻��ȷ");
			return LOGIN;
		}
	}
	
	@Action(value = "userInfo", results = {
			@Result(name = "success", location = "/MyInfo/Index.jsp") })
	
	public String userInfo() {
		String username = (String) ActionContext.getContext().getSession().get("username");
		Student student = userService.getUserInfo(username);
		
		ActionContext.getContext().put("user",student);
		
		return SUCCESS;
		
	}
	
	@Action(value = "userClassInfo", results = {
			@Result(name = "success", location = "/MyInfo/ClassInfo.jsp") })
	
	public String userClassInfo() {
		String username = (String) ActionContext.getContext().getSession().get("username");
		ClassInfo classInfo = userService.searchClass(username);
		
		ActionContext.getContext().put("classInfo",classInfo);
		
		return SUCCESS;
		
	}
}
