package com.actions;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.model.Student;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;

//ajaxҪʹ��json�������ݣ�����̳������  
@ParentPackage(value="json-default")
public class AjaxAction extends ActionSupport{
	
	//���ڵ���ҵ���ķ���
	private UserService userService = new UserService();
	
	private List<Student> list;

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

	@Action(value="chatAllUsers",results={
			@Result(name="allusers", type="json")
	})
	public String chatAllUsersAjax(){
		list = userService.getAllUsers();
		return "allusers";
	} 

}
