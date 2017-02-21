<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>学生信息管理平台</title>
	<link href="Style/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
	<link href="Style/ks.css" rel="stylesheet" type="text/css" />
    <script src="Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="Script/Common.js" type="text/javascript"></script>
    <script src="Script/Data.js" type="text/javascript"></script>
    <script src="Script/jquery-1.4.1.js" type="text/javascript"></script>
    <link href="Style/history.css" rel="stylesheet" type="text/css" />
</head>
<body>     
    <h2 class="mbx">学习中心 &gt; 资料上传</h2>
    <div>
        <form action="${pageContext.request.contextPath}/studentUploadFile.action" method="post" enctype="multipart/form-data">
		    <label for="docsub">资料所属科目： </label>
		    <select id="docsub" name="docsub">
		    	<option value="">请选择</option>
		    	<c:forEach  var="sub" items="${ docSubs }" varStatus="status">
		    		<option value="${ sub }">${ sub }</option>
		    	</c:forEach>
		    </select>
		    <br/>
		    <label for="doctype">资料类型： </label>
		    <select id="doctype" name="doctype">
		    	<option value="">请选择</option>
		    	<c:forEach  var="type" items="${ docTypes }" varStatus="status">
		    		<option value="${ type }">${ type }</option>
		    	</c:forEach>
		    </select>
		    <br/>
			<label for="docname">资料名称： </label>
		    <input type="text" id="docname" name="docname"/>
		    <span style="color:red;">${ msg }</span>
		    <br/>
		    <label class="tdupload" for="upload">选择文件： </label>
		    <input type="file" id="upload" name="upload"/><br/>
		    <div class="btncrm">
		    	<input type="submit" class="submit" value="提交"/>
		    	<input type="reset" class="cancel" value="取消"/>
		    </div>
		</form>
    </div>
</body>
</html>
