<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>
	学生信息管理平台
</title><link href="Style/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
	<link href="../Style/ks.css" rel="stylesheet" type="text/css" />
    <script src="Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="Script/Common.js" type="text/javascript"></script>
    <script src="Script/Data.js" type="text/javascript"></script>
    <script src="../Script/Base.js" type="text/javascript"></script>
</head>
<body>    
    <h2 class="mbx">
        班级中心 &gt; 班级班费</h2>
    <div class="morebt">
         <%@include file="../JspCommon/classCenterTagHead.jsp"%>
    </div>
    <div class="cztable">
    	<form action="${pageContext.request.contextPath}/classfare.action" method="post">
	        <div style="margin-bottom:20px">
	       		 <label style="margin-right:30px">请选择时间</label><input type="date" id="classfarestarttime" name="classfarestarttime" value="${ classfarestarttime }"> - <input type="date" id="classfareendtime" name="classfareendtime" value="${ classfareendtime }">
	         	<button style="height:28px;width: 50px;background-color: #39aa8e;margin: 0px 20px 0 30px;color:#FFF;border:none;border-radius:3px;cursor:pointer">确定</button>
	        </div>
        </form>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <th width="5%">序号</th>
            <th width="12%">时间</th>
            <th width="15%">事件</th>
            <th width="8%">支出</th>
            <th width="8%">收入</th>
            <th width="20%">备注</th>
        </tr>
        <c:forEach  var="item" items="${ classfares }" varStatus="status">
		  	<tr style="height: 28px" class="tdbg" align="left">
	            <td width="5%">${ status.index+1 }</td>
	            <td width="15%">${ item.time }</td>
	            <td width="15%">${ item.activity }</td>
	            <td width="20%">${ item.expend }</td>
	            <td width="8%">${ item.income }</td>
	            <td width="8%">${ item.comment }</td>
	        </tr>
		</c:forEach>
    </table>
    <div class="btndeli" style="display: block;">
        <button class="deliverynew" id="deliverynew">添 加</button>
        <button class="deliverynew" id="deliveryadd" style="display: none;" onclick="postAddGroup()">确定</button>
        <button class="deliveryback">取 消</button>
    </div>
    <div class="newdetail" style="clear:both;display:none">
    	<h3>添加班费信息</h3>
    	<form id="postform" action="${pageContext.request.contextPath}/addclassfare.action" method="post">
	        <label>请选择时间： </label>
	        <input type="date" id="classfaretime" name="classfaretime"/><br />
	        <label>请输入事件： </label>
	        <input type="text" id="classfareactivity" name="classfareactivity"/><br />
	        <label>支出： </label>
	        <input type="number" id="classfareexpend" name="classfareexpend"/><br />
	        <label>收入： </label>
	        <input type="number" id="classfareincome" name="classfareincome"/><br />
	        <label>备注： </label>
	        <input type="text" id="classfarecomment" name="classfarecomment"/>
	    </form>
    </div>
</body>
<script>
	$("#deliverynew").click(function(){
		$(".newdetail").css("display","block");
		$("#deliveryadd").css("display","inline");
		$(this).css("display","none");
	});
	$(".deliveryback").click(function(){
		$(".newdetail").css("display","none");
		$("#deliveryadd").css("display","none");
		$("#deliverynew").css("display","inline");
	});
	function postAddGroup(){
		$("#postform").submit();
	}
</script>
</html>
