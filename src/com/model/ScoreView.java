package com.model;

/*
 * ѧ���ɼ���ͼ(��Ŀ��Ϣ��ѧ���ɼ����ϲ�ѯ���)
 */
public class ScoreView {
	
	private String username; //ѧ������
	private int subid;//��Ŀid
	private String sub;//��Ŀ����
	private String starttime;//����ʱ��
	private double subscore;//ѧ��
	private double score;//�ɼ�����
	
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
