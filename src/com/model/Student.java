package com.model;

import java.util.Date;



public class Student {
	private String username;//用户名
	private String cardid; //身份证号
	private String sid; //学号
	private String major; //专业
	private String sex;//性别
	private String class_;//所在班级
	private String position;//担任职务
	private Date timeToSch;//入校时间
	private String address;//联系地址
	private String tel;//手机号
	private String qq;//qq号
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getClass_() {
		return class_;
	}
	public void setClass_(String class_) {
		this.class_ = class_;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Date getTimeToSch() {
		return timeToSch;
	}
	public void setTimeToSch(Date timeToSch) {
		this.timeToSch = timeToSch;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	
}
