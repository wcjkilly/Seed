package com.model;

import java.util.Date;

public class Document {
	
	//���Ͽ�Ŀ
	private String documentSub;
	//��������
	private String documentType;
	//��������
	private String documentName;
	//�ϴ�ʱ��
	private String uploadTime;
	//���ϱ���·��
	private String path;
	
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

}
