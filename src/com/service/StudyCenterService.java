package com.service;

import java.util.List;

import com.dao.StudyCenterDao;
import com.model.Document;

public class StudyCenterService {
	
	private StudyCenterDao studyCenterDao = new StudyCenterDao();
	
	public  List<String> getDocType() {
		return studyCenterDao.getDocType();
	}
	
	public  List<String> getDocSub() {
		return studyCenterDao.getDocSub();
	}

	public Boolean saveDocument(Document upDocTemp) {
		return studyCenterDao.saveDocument(upDocTemp);
	}
	
	public List<Document> getAllDoc(String docSub,String docType) {
		return studyCenterDao.getAllDoc(docSub, docType);
	}

}
