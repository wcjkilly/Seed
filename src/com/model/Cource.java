package com.model;

/*
 * 班级课程
 */
public class Cource {
	
	private int id;//id
	private int classid;//班级id
	private int weekday;//周几，用0~6表示周一到周日
	private int daydivide;//第几节课，用0~5表示第一节课到第六节课
	private String courcename;//课程名称
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public int getWeekday() {
		return weekday;
	}
	public void setWeekday(int weekday) {
		this.weekday = weekday;
	}
	public int getDaydivide() {
		return daydivide;
	}
	public void setDaydivide(int daydivide) {
		this.daydivide = daydivide;
	}
	public String getCourcename() {
		return courcename;
	}
	public void setCourcename(String courcename) {
		this.courcename = courcename;
	}
	
	public Cource() {
		super();
	}
	public Cource(int weekday, int daydivide, String courcename) {
		super();
		this.weekday = weekday;
		this.daydivide = daydivide;
		this.courcename = courcename;
	}
	@Override
	public String toString() {
		return "Cource [id=" + id + ", classid=" + classid + ", weekday="
				+ weekday + ", daydivide=" + daydivide + ", courcename="
				+ courcename + "]";
	}
	
	
}
