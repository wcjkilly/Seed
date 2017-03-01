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
	
	/*
	 * 获取资料类型列表
	 */
	public List<String> getDocType();
	
	/*
	 * 获取资料科目列表
	 */
	public List<String> getDocSub();
	
	/*
	 * 保存资料文件记录到数据库
	 */
	public void saveDocument(Document document);
	
	/*
	 * 获取资料列表
	 */
	public List<Document> getAllDoc(@Param("docSub") String docSub, @Param("docType") String docType);
	
}
