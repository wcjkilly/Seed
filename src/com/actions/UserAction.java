package com.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

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
		//TODO 判断登录是否合法
		Student student = userService.login(getUsername(), getPassword());
		if (student!=null) {
			ActionContext.getContext().getSession().put("user",getUsername());
			ActionContext.getContext().getSession().put("cardid",student.getCardid());
			ActionContext.getContext().getSession().put("sid",student.getSid());
			ActionContext.getContext().getSession().put("major",student.getMajor());
			ActionContext.getContext().getSession().put("sex",student.getSex());
			ActionContext.getContext().getSession().put("class_",student.getClass_());
			ActionContext.getContext().getSession().put("position",student.getPosition());
			ActionContext.getContext().getSession().put("timeToSch",student.getTimeToSch());
			ActionContext.getContext().getSession().put("address",student.getAddress());
			ActionContext.getContext().getSession().put("tel",student.getTel());
			ActionContext.getContext().getSession().put("qq",student.getQq());
			return SUCCESS;
		} else {
			setMsg("用户名或密码不正确");
			return LOGIN;
		}
	}
}
