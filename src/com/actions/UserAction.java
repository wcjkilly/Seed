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
		//TODO �жϵ�¼�Ƿ�Ϸ�
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
			setMsg("�û��������벻��ȷ");
			return LOGIN;
		}
	}
}
