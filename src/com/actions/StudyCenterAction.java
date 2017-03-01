package com.actions;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.model.ClassInfo;
import com.model.Document;
import com.model.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.StudyCenterService;
import com.service.UserService;

public class StudyCenterAction extends ActionSupport {

    private String docsub;//����������Ŀ
    private String doctype; //�ļ�����
    private String docname; //�ļ�����
    
    private String msg;//�����ϴ������Ϣ

    private File upload; //Struts2��װ���ϴ�Դ�ļ�
    private String uploadFileName;//Struts2��װ���ϴ�Դ�ļ����ļ���
    private String uploadContentType;//Struts2��װ���ϴ�Դ�ļ����ļ�����
    
    //���ڵ���ҵ���ķ���
  	private StudyCenterService studyCenterService = new StudyCenterService();
  	//����ת��ʱ���ʽ
  	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
	public String getDocsub() {
		return docsub;
	}

	public void setDocsub(String docsub) {
		this.docsub = docsub;
	}

	public String getDoctype() {
		return doctype;
	}

	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}

	public String getDocname() {
		return docname;
	}

	public void setDocname(String docname) {
		this.docname = docname;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	@Action(value = "studentMaterial", results = {
			@Result(name = "success", location = "/OnlineTeaching/StudentMaterial.jsp") })
	
	public String studentMaterial() throws UnsupportedEncodingException {
		
		//��ȡ���Ͽ�Ŀ��������Ϣ
		List<String> docSubs = studyCenterService.getDocSub();
		List<String> docTypes = studyCenterService.getDocType();
		ActionContext.getContext().put("docSubs",docSubs);
		ActionContext.getContext().put("docTypes",docTypes);
		
		//��ȡ������������������
		String docSubString = (getDocsub()==null || "".equals(getDocsub())) ? "" : getDocsub();
		String docTypeString = (getDoctype()==null || "".equals(getDoctype())) ? "" : getDoctype();
		//�Բ�ѯ�ַ������н��룬��ΪURL�е������ַ�����������
		docSubString = URLDecoder.decode(docSubString, "utf-8");
		docTypeString = URLDecoder.decode(docTypeString, "utf-8");
		System.out.println(docSubString);
		System.out.println(docTypeString);
		List<Document> docList = studyCenterService.getAllDoc(docSubString, docTypeString);
		ActionContext.getContext().put("docList",docList);
		
		return SUCCESS;
	}
	
	@Action(value = "studentStudyRecordList", results = {
			@Result(name = "success", location = "/OnlineTeaching/StudentStudyRecordList.jsp") })
	
	public String studentStudyRecordList() {
		//��ȡ���Ͽ�Ŀ��������Ϣ
		List<String> docSubs = studyCenterService.getDocSub();
		List<String> docTypes = studyCenterService.getDocType();
		ActionContext.getContext().put("docSubs",docSubs);
		ActionContext.getContext().put("docTypes",docTypes);
		return SUCCESS;
		
	}
	
	@Action(value = "studentUploadFile", results = {
			@Result(name = "success", location = "/OnlineTeaching/StudentStudyRecordList.jsp") })
	
	public String studentUploadFile() {
//		System.out.println(getDocname());
//		System.out.println(getDocsub());
//		System.out.println(getDoctype());
		//��֤�ϴ����ֶ��Ƿ�Ϸ�
		if( getUpload()==null 
				|| getDocsub()==null || "".equals(getDocsub()) 
				|| getDocname()==null || "".equals(getDocname()) 
				|| getDoctype()==null || "".equals(getDoctype()) ){
			setMsg("����д���б����ѡ��Ϸ����ļ����ϴ�");
			return SUCCESS;
		}
		String realpath = ServletActionContext.getServletContext().getRealPath("/uploadfiles");
        if (getUpload() != null) {
        	//��ȡ�ļ���׺
        	String extension = "";
        	if(getUploadFileName().indexOf(".") > -1){
        		String[] temps = getUploadFileName().split("[.]");
        		extension = "." +temps[temps.length-1];
        	}
        	//Ϊ�˷�ֹ�ļ��������ǣ��������ļ���Ϊ�ļ���+ʱ���
            File savefile = new File(new File(realpath), getDocname()+"_"+System.currentTimeMillis()+extension);
            if (!savefile.getParentFile().exists()){
                savefile.getParentFile().mkdirs();
            }
            try {
				FileUtils.copyFile(getUpload(), savefile);
			} catch (IOException e) {
				setMsg("�ļ��ϴ�����");
				return SUCCESS;
			}
            setMsg("�ϴ��ɹ�");
            
            //��ȡ�ϴ������������ĿĿ¼��·��
            String absolutePath = savefile.getAbsolutePath();
            String prePath = ServletActionContext.getServletContext().getRealPath("/");
            String relativePath = absolutePath.substring(prePath.length());
            relativePath = relativePath.replaceAll("\\\\", "/");
            String nowTime = sdf.format(new Date());
            System.out.println("�ļ��ɹ��ϴ�����"+absolutePath);
            //�����ϴ��ɹ����ļ���¼�������ݿ���
            Document upDocTemp = new Document(getDocsub(),getDoctype(),getDocname(),nowTime,relativePath);
            Boolean result = studyCenterService.saveDocument(upDocTemp);
            if(!result){
            	setMsg("�ļ��ϴ��ɹ��������ļ���¼�������ݿ�ʧ��");
            }
        }
        
        //��ȡ���Ͽ�Ŀ��������Ϣ
		List<String> docSubs = studyCenterService.getDocSub();
		List<String> docTypes = studyCenterService.getDocType();
		ActionContext.getContext().put("docSubs",docSubs);
		ActionContext.getContext().put("docTypes",docTypes);
		return SUCCESS;
	}
	
}
