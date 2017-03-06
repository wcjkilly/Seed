package com.mapper.function;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.model.ClassInfo;
import com.model.Document;
import com.model.ScoreView;
import com.model.Student;

public interface StudyCenterMapper {
	
	/**
	 * ��ȡ���������б�
	 * @return ���������б�
	 */
	public List<String> getDocType();
	
	/**
	 * ��ȡ���Ͽ�Ŀ�б�
	 * @return ���Ͽ�Ŀ�б�
	 */
	public List<String> getDocSub();
	
	/**
	 * ���������ļ���¼�����ݿ�
	 * @param documentʵ��
	 */
	public void saveDocument(Document document);
	
	/**
	 * ��ȡ�����б�
	 * @param docSub ���Ͽ�Ŀ
	 * @param docType ��������
	 * @return ���������������б�
	 */
	public List<Document> getAllDoc(@Param("docSub") String docSub, @Param("docType") String docType);
	
}
