package com.model;

/*
 * 学生成绩视图(科目信息和学生成绩联合查询结果)
 */
public class ScoreView {
	
	private String username; //学生名字
	private int subid;//科目id
	private String sub;//科目名称
	private String starttime;//开课时间
	private double subscore;//学分
	private double score;//成绩分数
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
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
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
}
