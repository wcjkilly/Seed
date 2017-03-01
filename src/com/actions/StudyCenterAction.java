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

    private String docsub;//资料所属科目
    private String doctype; //文件类型
    private String docname; //文件名称
    
    private String msg;//返回上传结果信息

    private File upload; //Struts2封装的上传源文件
    private String uploadFileName;//Struts2封装的上传源文件的文件名
    private String uploadContentType;//Struts2封装的上传源文件的文件类型
    
    //用于调用业务层的方法
  	private StudyCenterService studyCenterService = new StudyCenterService();
  	//用于转换时间格式
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
		
		//获取资料科目和类型信息
		List<String> docSubs = studyCenterService.getDocSub();
		List<String> docTypes = studyCenterService.getDocType();
		ActionContext.getContext().put("docSubs",docSubs);
		ActionContext.getContext().put("docTypes",docTypes);
		
		//获取满足条件的所有资料
		String docSubString = (getDocsub()==null || "".equals(getDocsub())) ? "" : getDocsub();
		String docTypeString = (getDoctype()==null || "".equals(getDoctype())) ? "" : getDoctype();
		//对查询字符串进行解码，因为URL中的中文字符可能是乱码
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
		//获取资料科目和类型信息
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
		//验证上传表单字段是否合法
		if( getUpload()==null 
				|| getDocsub()==null || "".equals(getDocsub()) 
				|| getDocname()==null || "".equals(getDocname()) 
				|| getDoctype()==null || "".equals(getDoctype()) ){
			setMsg("请填写所有必填项并选择合法的文件后上传");
			return SUCCESS;
		}
		String realpath = ServletActionContext.getServletContext().getRealPath("/uploadfiles");
        if (getUpload() != null) {
        	//获取文件后缀
        	String extension = "";
        	if(getUploadFileName().indexOf(".") > -1){
        		String[] temps = getUploadFileName().split("[.]");
        		extension = "." +temps[temps.length-1];
        	}
        	//为了防止文件重名覆盖，重命名文件名为文件名+时间戳
            File savefile = new File(new File(realpath), getDocname()+"_"+System.currentTimeMillis()+extension);
            if (!savefile.getParentFile().exists()){
                savefile.getParentFile().mkdirs();
            }
            try {
				FileUtils.copyFile(getUpload(), savefile);
			} catch (IOException e) {
				setMsg("文件上传出错");
				return SUCCESS;
			}
            setMsg("上传成功");
            
            //获取上传的资料相对项目目录的路径
            String absolutePath = savefile.getAbsolutePath();
            String prePath = ServletActionContext.getServletContext().getRealPath("/");
            String relativePath = absolutePath.substring(prePath.length());
            relativePath = relativePath.replaceAll("\\\\", "/");
            String nowTime = sdf.format(new Date());
            System.out.println("文件成功上传到："+absolutePath);
            //资料上传成功后将文件记录插入数据库中
            Document upDocTemp = new Document(getDocsub(),getDoctype(),getDocname(),nowTime,relativePath);
            Boolean result = studyCenterService.saveDocument(upDocTemp);
            if(!result){
            	setMsg("文件上传成功，但将文件记录插入数据库失败");
            }
        }
        
        //获取资料科目和类型信息
		List<String> docSubs = studyCenterService.getDocSub();
		List<String> docTypes = studyCenterService.getDocType();
		ActionContext.getContext().put("docSubs",docSubs);
		ActionContext.getContext().put("docTypes",docTypes);
		return SUCCESS;
	}
	
}
