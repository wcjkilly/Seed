package com.actions;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.model.Attendance;
import com.model.ClassInfo;
import com.model.Score;
import com.model.ScoreView;
import com.model.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;

public class UserAction extends ActionSupport {
	
	//���ڵ���ҵ���ķ���
	private UserService userService = new UserService();

	//���ڽ��յ�¼ʱ���Ĳ���
	private String username;
	private String password;
	
	//���ڽ���Ϣ���ص�jspҳ��
	private String msg;
	
	//���ڽ��ղ�ѯ���˳ɼ�ʱ�ı�����
	private String subStartTimeBegin;
	private String subStartTimeEnd;
	
	//���ڽ��տ��ڲ�ѯ����
	private String attendanceStartTime;
	private String attendanceEndTime;
	private String attendanceWeek;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

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

	public String getSubStartTimeBegin() {
		return subStartTimeBegin;
	}

	public void setSubStartTimeBegin(String subStartTimeBegin) {
		this.subStartTimeBegin = subStartTimeBegin;
	}

	public String getSubStartTimeEnd() {
		return subStartTimeEnd;
	}

	public void setSubStartTimeEnd(String subStartTimeEnd) {
		this.subStartTimeEnd = subStartTimeEnd;
	}

	public String getAttendanceStartTime() {
		return attendanceStartTime;
	}

	public void setAttendanceStartTime(String attendanceStartTime) {
		this.attendanceStartTime = attendanceStartTime;
	}

	public String getAttendanceEndTime() {
		return attendanceEndTime;
	}

	public void setAttendanceEndTime(String attendanceEndTime) {
		this.attendanceEndTime = attendanceEndTime;
	}

	public String getAttendanceWeek() {
		return attendanceWeek;
	}

	public void setAttendanceWeek(String attendanceWeek) {
		this.attendanceWeek = attendanceWeek;
	}

	@Action(value = "userLogin", results = {
			@Result(name = "success", location = "/homepage.jsp"),
			@Result(name = "login", location = "/login.jsp") })
	
	public String login() {
		System.out.println("�û���¼��"+getUsername());
		//�жϵ�¼�Ƿ�Ϸ�
		Boolean result = userService.login(getUsername(), getPassword());
		if (result) {
			//sessionд������Ψһ��ʶ��ͨ������Ҫ����
			ActionContext.getContext().getSession().put("username",getUsername());
			return SUCCESS;
		} else {
			setMsg("�û��������벻��ȷ");
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
	
	
	@Action(value = "educationCenter", results = {
			@Result(name = "success", location = "/EducationCenter/Score.jsp") })
	
	public String educationCenter() {
		
		String username = (String) ActionContext.getContext().getSession().get("username");
		String subStartTime = getSubStartTimeBegin()==null ? "" : getSubStartTimeBegin();
		String subEndTime = getSubStartTimeEnd()==null ? "" : getSubStartTimeEnd();
		
		List<ScoreView> scoreViews = userService.getUserScores(username, subStartTime, subEndTime);
		ActionContext.getContext().put("scoreViews",scoreViews);
		return SUCCESS;
		
	}
	
	@Action(value = "attendence", results = {
			@Result(name = "success", location = "/MyInfo/attendence.jsp") })
	
	public String attendence() {
		String username = (String) ActionContext.getContext().getSession().get("username");
		String attStart = getAttendanceStartTime()==null ? "" : getAttendanceStartTime();
		String attEnd = getAttendanceEndTime()==null ? "" : getAttendanceEndTime();
		String attWeek = getAttendanceWeek()==null ? "" : getAttendanceWeek();
		//ԭʼ���ܸ�ʽ��2017-W02����ʾ2017���2�ܣ�ת����ֻ�������ֵĸ�ʽ��201702
		attWeek = attWeek.replaceAll("\\D", "");
		
		List<Attendance> attendanceViews = userService.getUserAttendances(username, attStart, attEnd,attWeek);
		ActionContext.getContext().put("attendanceViews",attendanceViews);
		
		return SUCCESS;
		
	}
	
	@Action(value = "systemMsge", results = {
			@Result(name = "success", location = "/User/StudentInfor/systemMsge.jsp") })
	
	public String systemMsge() {
		
		
		
		return SUCCESS;
		
	}
	@Action(value = "letter", results = {
			@Result(name = "success", location = "/User/StudentInfor/Letter.jsp") })
	
	public String Letter() {
		
		
		
		return SUCCESS;
		
	}
	
	
}
