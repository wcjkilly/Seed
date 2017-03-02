package com.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.model.ClassInfo;
import com.model.ClassGroup;
import com.model.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ClassCenterService;
import com.service.UserService;

public class ClassAction extends ActionSupport {

	//���ڵ���ҵ���ķ���
	private ClassCenterService classCenterService  = new ClassCenterService();
	private UserService userService  = new UserService();
	
	//���ڽ������С��ʱ����Ϣ
	private String grouptype;
	private String groupmanager;
	private String groupmembers;
	private String groupsetuptime;
	private String groupcomment;
	
	public String getGrouptype() {
		return grouptype;
	}

	public void setGrouptype(String grouptype) {
		this.grouptype = grouptype;
	}

	public String getGroupmanager() {
		return groupmanager;
	}

	public void setGroupmanager(String groupmanager) {
		this.groupmanager = groupmanager;
	}

	public String getGroupmembers() {
		return groupmembers;
	}

	public void setGroupmembers(String groupmembers) {
		this.groupmembers = groupmembers;
	}

	public String getGroupsetuptime() {
		return groupsetuptime;
	}

	public void setGroupsetuptime(String groupsetuptime) {
		this.groupsetuptime = groupsetuptime;
	}

	public String getGroupcomment() {
		return groupcomment;
	}

	public void setGroupcomment(String groupcomment) {
		this.groupcomment = groupcomment;
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
		String username = (String) ActionContext.getContext().getSession().get("username");
		
		List<ClassGroup> classGroups = classCenterService.getGroups(username);
		ActionContext.getContext().put("classGroups",classGroups);
		
		return SUCCESS;
	}
	
	@Action(value = "addgroup", results = {
			@Result(name = "success", location = "/EducationCenter/group.jsp") })
	
	public String addGroup() {
		String username = (String) ActionContext.getContext().getSession().get("username");
		
		Student student = userService.getUserInfo(username);
		ClassGroup group = new ClassGroup(Integer.parseInt(student.getClassid()), getGrouptype(), getGroupmanager(), getGroupmembers(), getGroupsetuptime(), getGroupcomment());
		
		//System.out.println(group);
		
		Boolean result = classCenterService.addGroup(group);
		//���С��ɹ�����ʾˢ���б�������ʾ���б�
		if(result){
			List<ClassGroup> classGroups = classCenterService.getGroups(username);
			ActionContext.getContext().put("classGroups",classGroups);
		}
		
		return SUCCESS;
	}
	
	@Action(value = "vote", results = {
			@Result(name = "success", location = "/EducationCenter/vote.jsp") })
	
	public String vote() {
		
		
		
		return SUCCESS;
		
	}
	
	
	
}
