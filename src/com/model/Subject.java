package com.model;

public class Subject {
	private int subid;//科目id
	private String sub;//科目名称
	private String starttime;//开课时间
	private double subscore;//学分
	public int getSubid() {
		return subid;
	}
	public void setSubid(int subid) {
		this.subid = subid;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public double getSubscore() {
		return subscore;
	}
	public void setSubscore(double subscore) {
		this.subscore = subscore;
	}
}
