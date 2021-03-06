﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>
	学生信息管理平台
</title><link href="Style/StudentStyle.css" rel="stylesheet" type="text/css" /><link href="../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" /><link href="../Style/ks.css" rel="stylesheet" type="text/css" />
    <script src="Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="Script/Common.js" type="text/javascript"></script>
    <script src="Script/Data.js" type="text/javascript"></script>
    <script src="../Script/Base.js" type="text/javascript"></script>
</head>
<body>    
    <h2 class="mbx">
        教务中心 &gt; 班级课程表</h2>
    <div class="morebt">
        <%@include file="../JspCommon/classCenterTagHead.jsp"%>
    </div>
    <div class="cztable">
        <div class="tis red">
            注：请仔细核对自己的课程情况，如正确请点击“确定无误”，如不正确请点击“有异议”。
        </div>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tbody>
                <tr style="height: 25px" align="center">
                    <th width="9%">时间</th>
                    <th width="13%">星期一</th>
                    <th width="13%">星期二</th>
                    <th width="13%">星期三</th>
                    <th width="13%">星期四</th>
                    <th width="13%">星期五</th>
                    <th width="13%">星期六</th>
                    <th width="13%">星期日</th>
                </tr>
                <c:forEach  var="item" items="${ cources }" varStatus="status">
				  	<c:if test="${ status.index%7==0 }">
				  		<tr align="center"><td>第${item.daydivide+1}节课</td>
				  	</c:if>
				  	<td>${ item.courcename }</td>
				  	<c:if test="${ status.index%7==6 }">
				  		</tr>
				  	</c:if>
				</c:forEach>
            </tbody>
        </table>
    </div>

    </div>
</body>
</html>
