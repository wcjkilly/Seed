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

	@Action(value = "userLogin", results = {
			@Result(name = "success", location = "/homepage.jsp"),
			@Result(name = "login", location = "/login.jsp") })
	
	public String login() {
		System.out.println("用户登录："+getUsername());
		//判断登录是否合法
		Boolean result = userService.login(getUsername(), getPassword());
		if (result) {
			//session写入用于唯一标识，通常还需要加密
			ActionContext.getContext().getSession().put("username",getUsername());
			return SUCCESS;
		} else {
			setMsg("用户名或密码不正确");
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
