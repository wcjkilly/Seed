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
    <script type="text/javascript">
	    function searchScore() {
            var subStartTimeBegin = $("#subStartTimeBegin").val();
            var subStartTimeEnd = $("#subStartTimeEnd").val();
            //alert(subStartTimeBegin + "----" + subStartTimeEnd);
            window.location = 'educationCenter.action?subStartTimeBegin=' + subStartTimeBegin + "&subStartTimeEnd=" + subStartTimeEnd;
	    }
    </script>
    <style>
	table td{
		text-align:center;
	}
	</style>
</head>
<body>
    <h2 class="mbx">个人中心 &gt; 我的成绩</h2>
    <div class="morebt">
       <%@include file="../JspCommon/userCenterTagHead.jsp"%>
    </div>
    <div class="cztable">
		<div style="margin-bottom:20px">
			<label>请选择开课时间: </label>
			<input type="month" id="subStartTimeBegin" name="subStartTimeBegin" value="${ subStartTimeBegin }"> - <input type="month" id="subStartTimeEnd" name="subStartTimeEnd" value="${ subStartTimeEnd }">
			<button id="subStartTimeQuery" onclick="searchScore()" style="height:28px;width: 50px;background-color: #39aa8e;margin: 0px 20px 0 30px;color:#FFF;border:none;border-radius:3px;cursor:pointer">确定</button>
		</div>
		<div class="tis red">注：请仔细核对自己的考试成绩，如不正确请点击联系相关老师。</div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		  <tr>
		      <th width="5%">序号</th>
		      <th width="15%">课程编号</th>
		      <th width="20%">课程名称</th>
		      <th width="12%">开课时间</th>
		      <th width="8%">学分</th>
		      <th width="8%">成绩</th>
		  </tr>
		  <!-- 遍历输入list中的数据 -->
		  <c:forEach  var="score" items="${ scoreViews }" varStatus="status">
		  	<tr style="height: 28px" class="tdbg" align="left">
		       <td width="5%"> ${ status.index+1} </td>
		       <td width="15%">${ score.subid }</td>
		       <td width="20%">${ score.sub }</td>
		       <td width="12%">${ score.starttime }</td>
		       <td width="8%">${ score.subscore }</td>
		       <td width="8%">${ score.score }</td>
		   </tr>
		  </c:forEach>
		</table>			
    </div>
</body>
</html>
