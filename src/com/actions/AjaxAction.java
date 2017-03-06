package com.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.model.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;

//ajax要使用json传递数据，必须继承这个包  
@ParentPackage(value="json-default")
public class AjaxAction extends ActionSupport{
	
	//用于调用业务层的方法
	private UserService userService = new UserService();
	
	private List<Student> list;
	
	private String changePwdRS;

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

	public String getChangePwdRS() {
		return changePwdRS;
	}

	public void setChangePwdRS(String changePwdRS) {
		this.changePwdRS = changePwdRS;
	}

	/**
	 * 获取所有用户列表
	 * @return 所有用户的列表，以json格式返回
	 */
	@Action(value="chatAllUsers",results={
			@Result(name="allusers", type="json")
	})
	public String chatAllUsersAjax(){
		list = userService.getAllUsers();
		return "allusers";
	} 
	
	/**
	 * 修改用户密码
	 * @return 如果修改成功则返回true，否则返回false
	 */
	@Action(value="userChangePwd",results={
			@Result(name="result", type="json")
	})
	public String userChangePwd(){
		String username = (String) ActionContext.getContext().getSession().get("username");
		Map<String, Object> map = ActionContext.getContext().getParameters();
		String oldPwd = ServletActionContext.getRequest().getParameter("oldPwd");
		String newPwd = ServletActionContext.getRequest().getParameter("newPwd");
		
		/*System.out.println(username);
		System.out.println(oldPwd);
		System.out.println(newPwd);*/
		
		changePwdRS = userService.userChangePwd(username, oldPwd, newPwd) ? "true" : "false";
		return "result";
	} 
	

}
