package com.model;

/*
 * 班级班费
 */
public class Classfare {
	
	private int id;//id
	private int classid;//所属班级id
	private String time;//时间
	private String activity;//活动
	private int expend;//支出
	private int income;//收入
	private String comment;//备注
	
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public int getExpend() {
		return expend;
	}
	public void setExpend(int expend) {
		this.expend = expend;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	public Classfare() {
		super();
	}
	public Classfare(int classid, String time, String activity, int expend,
			int income, String comment) {
		super();
		this.classid = classid;
		this.time = time;
		this.activity = activity;
		this.expend = expend;
		this.income = income;
		this.comment = comment;
	}
	
	
	@Override
	public String toString() {
		return "Classfare [id=" + id + ", classid=" + classid + ", time="
				+ time + ", activity=" + activity + ", expend=" + expend
				+ ", income=" + income + ", comment=" + comment + "]";
	}
	
}
