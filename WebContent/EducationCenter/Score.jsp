﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>
	学生信息管理平台
</title><link href="../Style/StudentStyle.css" rel="stylesheet" type="text/css" /><link href="../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" /><link href="../Style/ks.css" rel="stylesheet" type="text/css" />
    <script src="../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="../Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="../Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="../Script/Common.js" type="text/javascript"></script>
    <script src="../Script/Data.js" type="text/javascript"></script>
    <script type="text/javascript">
        $().ready(function () {
            setStudMsgHeadTabCheck();
        });

        //我的信息头部选项卡
        function setStudMsgHeadTabCheck() {
            var currentUrl = window.location.href;
            currentUrl = currentUrl.toLowerCase();
            var asmhm = "";
            $("#ulStudMsgHeadTab li").each(function () {
                asmhm = $(this).find('a').attr("href").toLowerCase();
                if (currentUrl.indexOf(asmhm) > 0) {
                    $(this).find('a').attr("class", "tab1");
                    return;
                }
            });
        }
    </script>   
    <script src="../Script/Base.js" type="text/javascript"></script>
    <style>
	table td{
		text-align:center;
	}
	</style>
</head>
<body>
    <h2 class="mbx">
        个人中心 &gt; 我的成绩</h2>
    <div class="morebt">
       <ul id="ulStudMsgHeadTab">
    <li><a class="tab2" onclick="" href="../MyInfo/Index.jsp">我的信息</a> </li>
    <li><a class="tab2" onclick="" href="../MyInfo/ClassInfo.jsp">班级信息</a></li>
    <li><a class="tab2" onclick="" href="Score.jsp">个人成绩</a></li>
    <li><a class="tab2" onclick="" href="../MyInfo/attendence.jsp">个人考勤</a></li>
    <li><a class="tab2" onclick="" href="../User/StudentInfor/systemMsge.jsp">我的通知<span style="color:#ff0000; padding-left:5px;" id="unreadSysMsgCount"></span></a></li>
    <li><a class="tab2" onclick="" href="../User/StudentInfor/Letter.jsp">在线提问</a></li>
</ul>
    </div>
    <div class="cztable">
    	<div style="margin-bottom:20px">
       		 <label>请选择开课时间: </label><input type="month" > - <input type="month">
         	<button style="height:28px;width: 50px;background-color: #39aa8e;margin: 0px 20px 0 30px;color:#FFF;border:none;border-radius:3px;cursor:pointer">确定</button>
        </div>
        <div class="tis red">
            注：请仔细核对自己的考试成绩，如不正确请点击联系相关老师。</div>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <th width="5%">序号</th>
            <th width="12%">开课时间</th>
            <th width="15%">课程编号</th>
            <th width="20%">课程名称</th>
            <th width="8%">成绩</th>
            <th width="8%">学分</th>
        </tr>
        
        <tr style="height: 28px" class="tdbg" align="left">
            <td width="5%">1</td>
            <td width="12%">2015-01-15</td>
            <td width="15%">00015</td>
            <td width="20%">英语（二）</td>
            <td width="8%">88</td>
            <td width="8%">4</td>
        </tr>
        <tr style="height: 28px" class="tdbg" align="left">
            <td width="5%">1</td>
            <td width="12%">2015-01-15</td>
            <td width="15%">00046</td>
            <td width="20%">中国近现代史纲要</td>
            <td width="8%">95</td>
            <td width="8%">3</td>
        </tr>
        
    </table>
    </div>
</body>
</html>