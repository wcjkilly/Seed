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

public class ClassAction extends ActionSupport {
	
	//用于接收form表单的参数
	private String username;
	private String password;
	//用于将信息返回到jsp页面
	private String msg;
	//用于调用业务层的方法
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


	@Action(value = "book", results = {
			@Result(name = "success", location = "/EducationCenter/Book.jsp") })
	
	public String book() {
		
		
		
		return SUCCESS;
		
	}
	
	@Action(value = "classfare", results = {
			@Result(name = "success", location = "/EducationCenter/classfare.jsp") })
	
	public String classfare() {
		
		
		
		return SUCCESS;
		
	}
	
	
	@Action(value = "group", results = {
			@Result(name = "success", location = "/EducationCenter/group.jsp") })
	
	public String group() {
		
		
		
		return SUCCESS;
		
	}
	
	@Action(value = "vote", results = {
			@Result(name = "success", location = "/EducationCenter/vote.jsp") })
	
	public String vote() {
		
		
		
		return SUCCESS;
		
	}
	
	
	
}
