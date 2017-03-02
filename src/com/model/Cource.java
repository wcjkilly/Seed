package com.model;

/*
 * °à¼¶¿Î³Ì
 */
public class Cource {
	
	private int id;
	private int classid;
	private int weekday;
	private int daydivide;
	private String courcename;
	
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
