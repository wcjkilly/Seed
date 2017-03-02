<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
        班级中心 &gt; 小组</h2>
    <div class="morebt">
         <%@include file="../JspCommon/classCenterTagHead.jsp"%>
    </div>
    <div class="cztable">
       <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <th width="5%">序号</th>
            <th width="8%">小组类别</th>
            <th width="8%">小组组长</th>
            <th width="25%">小组成员</th>
            <th width="12%">成立时间</th>
            <th width="10%">备注</th>
        </tr>
        <c:forEach  var="group" items="${ classGroups }" varStatus="status">
		  	 <tr style="height: 28px" class="tdbg" align="left">
	            <td>${ status.index+1 }</td>
	            <td>${ group.type }</td>
	            <td>${ group.manager }</td>
	            <td>${ group.members }</td>
	            <td >${ group.setuptime }</td>
	            <td>${ group.comment }</td>
	        </tr>
		</c:forEach>
   	   </table>  
     <div class="btndeli" style="display: block;">
        <button class="deliverynew" id="deliverynew">添 加</button>
        <button class="deliverynew" id="deliveryadd" style="display: none;" onclick="postAddGroup()">确定</button>
        <button class="deliveryback">取 消</button>
    </div>
    <div class="newdetail" style="clear:both;display:none">
    	<h3>添加小组</h3>
        <form id="postform" action="${pageContext.request.contextPath}/addgroup.action" method="post">
        	<label>请输入小组类别： </label>
	        <input type="text" id="grouptype" name="grouptype"/><br />
	        <label>请输入小组组长： </label>
	        <input type="text" id="groupmanager" name="groupmanager"/><br />
	        <label>请输入小组成员： </label>
	        <input type="text" id="groupmembers" name="groupmembers"/><br />
	        <label>请选择成立时间： </label>
	        <input type="date" id="groupsetuptime" name="groupsetuptime"/><br />
	        <label>备注： </label>
	        <input type="text" id="groupcomment" name="groupcomment"/>
        </form>
    </div>
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
