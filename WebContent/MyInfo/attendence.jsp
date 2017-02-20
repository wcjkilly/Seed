<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>
	学生信息管理平台
</title><link href="Style/StudentStyle.css" rel="stylesheet" type="text/css" /><link href="../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" /><link href="../Style/ks.css" rel="stylesheet" type="text/css" />
    <script src="Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="Script/Common.js" type="text/javascript"></script>
    <script src="Script/Data.js" type="text/javascript"></script>
 	<style>
	table td{
		text-align:center;
	}
	</style>
</head>
<body>
<h2 class="mbx">个人中心 &gt; 个人考勤</h2>  
<div class="morebt">
<%@include file="../JspCommon/userCenterTagHead.jsp"%>
</div>
<div class="cztable">
    	<div style="margin-bottom:20px">
       		 <label>请选择日期 ： </label><input type="date"> - <input type="date">
             <label for="week">请选择周数 ： </label><input type="week" id="week">
         	<button style="height:28px;width: 50px;background-color: #39aa8e;margin: 0px 20px 0 30px;color:#FFF;border:none;border-radius:3px;cursor:pointer">确定</button>
        </div>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <th width="5%">序号</th>
            <th width="12%">上课时间</th>
            <th width="15%">周数</th>
            <th width="20%">考勤情况</th>
            <th width="16%">备注</th>
        </tr>
        
        <tr style="height: 28px" class="tdbg" align="left">
            <td width="5%">1</td>
            <td width="12%">2015-01-15</td>
            <td width="15%">2</td>
            <td width="20%">正常</td>
            <td width="16%">88</td>
        </tr>
        <tr style="height: 28px" class="tdbg" align="left">
            <td width="5%">2</td>
            <td width="12%">2015-01-15</td>
            <td width="15%">3</td>
            <td width="20%">正常</td>
            <td width="16%">95</td>
        </tr>
        
    </table>
    </div>
</body>
</html>
