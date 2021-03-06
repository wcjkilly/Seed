package com.model;

/*
 * 班级小组
 */
public class ClassGroup {
	
	private int id;//id
	private int classid;//所属班级id
	private String type;//小组类型
	private String manager;//组长
	private String members;//小组成员
	private String setuptime;//成立时间
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getMembers() {
		return members;
	}
	public void setMembers(String members) {
		this.members = members;
	}
	public String getSetuptime() {
		return setuptime;
	}
	public void setSetuptime(String setuptime) {
		this.setuptime = setuptime;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public ClassGroup() {
		super();
	}
	public ClassGroup(int classid, String type, String manager, String members,
			String setuptime, String comment) {
		super();
		this.classid = classid;
		this.type = type;
		this.manager = manager;
		this.members = members;
		this.setuptime = setuptime;
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "ClassGroup [id=" + id + ", classid=" + classid + ", type="
				+ type + ", manager=" + manager + ", members=" + members
				+ ", setuptime=" + setuptime + ", comment=" + comment + "]";
	}
	
	

}
