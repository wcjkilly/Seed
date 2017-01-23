package com.model;

public class Score {

	private String username; //学生名字
	private int subid;//科目id
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
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
}
