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
