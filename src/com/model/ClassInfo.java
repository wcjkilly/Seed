package com.model;

/*
 * 学生所在班级信息
 */
public class ClassInfo {

	private String class_;//班级名字
	private String classqq;//班级qq群号
	private String classflag;//班级口号
	private String school;//所在学校
	private String fteacher;//辅导员
	private String tel;//电话
	private String talktime;//时间
	private int evaluate;//评价
	private int classid;//班级ID
	public String getClass_() {
		return class_;
	}
	public void setClass_(String class_) {
		this.class_ = class_;
	}
	public String getClassqq() {
		return classqq;
	}
	public void setClassqq(String classqq) {
		this.classqq = classqq;
	}
	public String getClassflag() {
		return classflag;
	}
	public void setClassflag(String classflag) {
		this.classflag = classflag;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getFteacher() {
		return fteacher;
	}
	public void setFteacher(String fteacher) {
		this.fteacher = fteacher;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getTalktime() {
		return talktime;
	}
	public void setTalktime(String talktime) {
		this.talktime = talktime;
	}
	public int getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(int evaluate) {
		this.evaluate = evaluate;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	
}
