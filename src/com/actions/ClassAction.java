package com.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.model.ClassInfo;
import com.model.ClassGroup;
import com.model.Classfare;
import com.model.Cource;
import com.model.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ClassCenterService;
import com.service.UserService;

public class ClassAction extends ActionSupport {
	//���ڵ���ҵ���ķ���������
	private ClassCenterService classCenterService  = new ClassCenterService();
	private UserService userService  = new UserService();
	
	//���ڽ��ղ�ѯ�༶��ѵ�ʱ�����
	private String classfarestarttime;
	private String classfareendtime;
	
	//���ڽ������С��ʱ����Ϣ
	private String grouptype;
	private String groupmanager;
	private String groupmembers;
	private String groupsetuptime;
	private String groupcomment;
	
	//���ڽ�����Ӱ��ʱ����Ϣ
	private String classfaretime;
	private String classfareactivity;
	private String classfareexpend;
	private String classfareincome;
	private String classfarecomment;
	
	public String getClassfarestarttime() {
		return classfarestarttime;
	}
	public void setClassfarestarttime(String classfarestarttime) {
		this.classfarestarttime = classfarestarttime;
	}
	public String getClassfareendtime() {
		return classfareendtime;
	}
	public void setClassfareendtime(String classfareendtime) {
		this.classfareendtime = classfareendtime;
	}
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
	public String getClassfaretime() {
		return classfaretime;
	}
	public void setClassfaretime(String classfaretime) {
		this.classfaretime = classfaretime;
	}
	public String getClassfareactivity() {
		return classfareactivity;
	}
	public void setClassfareactivity(String classfareactivity) {
		this.classfareactivity = classfareactivity;
	}
	public String getClassfareexpend() {
		return classfareexpend;
	}
	public void setClassfareexpend(String classfareexpend) {
		this.classfareexpend = classfareexpend;
	}
	public String getClassfareincome() {
		return classfareincome;
	}
	public void setClassfareincome(String classfareincome) {
		this.classfareincome = classfareincome;
	}
	public String getClassfarecomment() {
		return classfarecomment;
	}
	public void setClassfarecomment(String classfarecomment) {
		this.classfarecomment = classfarecomment;
	}
	
	//�༶����-->�鿴�༶�γ̱�
	@Action(value = "course", results = {
			@Result(name = "success", location = "/EducationCenter/Course.jsp") })
	
	public String course() {
		String username = (String) ActionContext.getContext().getSession().get("username");
		
		Student student = userService.getUserInfo(username);
		List<Cource> cources = classCenterService.getClassCources(student.getClassid());
		/*for(Cource c:cources){
			System.out.println(c);
		}*/
		ActionContext.getContext().put("cources",cources);
		return SUCCESS;
	}
	
	//�༶����-->�鿴�༶���
	@Action(value = "classfare", results = {
			@Result(name = "success", location = "/EducationCenter/classfare.jsp") })
	
	public String classfare() {
		String username = (String) ActionContext.getContext().getSession().get("username");
		String startTime = getClassfarestarttime()==null ? "" : getClassfarestarttime();
		String endTime = getClassfareendtime()==null ? "" : getClassfareendtime();
		
		Student student = userService.getUserInfo(username);
		List<Classfare> classfares = classCenterService.getClassfares(student.getClassid(), startTime, endTime);
		ActionContext.getContext().put("classfares",classfares);
		return SUCCESS;
	}
	
	//�༶����-->��Ӱ༶���
	@Action(value = "addclassfare", results = {
			@Result(name = "success", location = "/EducationCenter/classfare.jsp") })
	
	public String addClassfare() {
		String username = (String) ActionContext.getContext().getSession().get("username");
		
		Student student = userService.getUserInfo(username);
		Classfare classfare = new Classfare(Integer.parseInt(student.getClassid()), getClassfaretime(), getClassfareactivity(), Integer.parseInt(getClassfareexpend()), Integer.parseInt(getClassfareincome()), getClassfarecomment());
		
		Boolean result = classCenterService.addClassfare(classfare);
		//��Ӱ�ѳɹ�����ʾˢ���б�������ʾ���б�
		if(result){
			List<Classfare> classfares = classCenterService.getClassfares(student.getClassid(), "", "");
			ActionContext.getContext().put("classfares",classfares);
		}
		
		return SUCCESS;
	}
	
	//�༶����-->�鿴�༶С��
	@Action(value = "group", results = {
			@Result(name = "success", location = "/EducationCenter/group.jsp") })
	
	public String group() {
		String username = (String) ActionContext.getContext().getSession().get("username");
		
		List<ClassGroup> classGroups = classCenterService.getGroups(username);
		ActionContext.getContext().put("classGroups",classGroups);
		
		return SUCCESS;
	}
	
	//�༶����-->��Ӱ༶С��
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
	
	//�༶����-->ͶƱ
	@Action(value = "vote", results = {
			@Result(name = "success", location = "/EducationCenter/vote.jsp") })
	
	public String vote() {
		
		
		
		return SUCCESS;
		
	}
	
	
	
}
