package com.model;

import java.util.Date;

/*
 * 资料
 */
public class Document {
	
	//id
	private int id;
	//资料科目
	private String documentSub;
	//资料类型
	private String documentType;
	//资料名字
	private String documentName;
	//上传时间
	private String uploadTime;
	//资料保存路径
	private String path;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDocumentSub() {
		return documentSub;
	}
	public void setDocumentSub(String documentSub) {
		this.documentSub = documentSub;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public String getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	public Document() {
		super();
	}
	public Document(String documentSub, String documentType,
			String documentName, String uploadTime, String path) {
		super();
		this.documentSub = documentSub;
		this.documentType = documentType;
		this.documentName = documentName;
		this.uploadTime = uploadTime;
		this.path = path;
	}
}
