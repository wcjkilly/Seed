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

//ajaxҪʹ��json�������ݣ�����̳������  
@ParentPackage(value="json-default")
public class AjaxAction extends ActionSupport{
	
	//���ڵ���ҵ���ķ���
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
	 * ��ȡ�����û��б�
	 * @return �����û����б���json��ʽ����
	 */
	@Action(value="chatAllUsers",results={
			@Result(name="allusers", type="json")
	})
	public String chatAllUsersAjax(){
		list = userService.getAllUsers();
		return "allusers";
	} 
	
	/**
	 * �޸��û�����
	 * @return ����޸ĳɹ��򷵻�true�����򷵻�false
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
