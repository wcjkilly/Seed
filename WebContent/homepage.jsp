<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生信息管理系统模板</title>
<link href="Style/StudentStyle.css" rel="stylesheet" type="text/css" />
<link href="Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
<link href="Style/ks.css" rel="stylesheet" type="text/css" />
<link href="Style/animate.min.css" rel="stylesheet" type="text/css" />
    <script src="Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="Script/Common.js" type="text/javascript"></script>
    <script src="Script/Data.js" type="text/javascript"></script>
    <script type="text/javascript">
        $().ready(function () {
            setStudMsgHeadTabCheck();
            showUnreadSysMsgCount();
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

        //显示未读系统信息
        function showUnreadSysMsgCount() {
            var unreadSysMsgCount = "0";
            if (Number(unreadSysMsgCount) > 0) {
                $("#unreadSysMsgCount").html("(" + unreadSysMsgCount + ")");
            }
        }

        //退出
        function loginOut() {
            if (confirm("确定退出吗？")) {
                StudentLogin.loginOut(function (data) {
                    if (data == "true") {
                        window.location = "login.jsp";
                    }
                    else {                 
						return false;
                    }
                });
            }
        }
        //更改报考类别
        function changeCateory(thisObj, id) {
            var oldCateoryId = $("#cateoryId").val();
            var cateoryId = "";
            if (id != null) {
                cateoryId = id;
            }
            else {
                cateoryId = thisObj.val();
            }
            var studentId = $("#studentId").val();
            if (cateoryId.length <= 0) {
                jBox.tip("报考类别不能为空！");
                if (id == null) {
                    thisObj.val(oldCateoryId);
                }
            }
            else {
                studentInfo.changeStudentCateory(cateoryId, function (data) {
                    var result = $.parseJSON(data);
                    if ((String(result.ok) == "true")) {
                        window.location.href = "/Index";
                    }
                    else {
                        jBox.tip(result.message);
                    }
                });
            }
        }
    </script>  
    <script src="Script/changeOption.js" type="text/javascript"></script>
    <script src="Script/rl.js" type="text/javascript"></script>
</head>
<body>
<div class="banner">
        <div class="bgh">
            <div class="page">
                <div id="logo">
                    <a href="Index.jsp">
                        <img src="Images/Student/logo.gif" alt="" width="165" height="48" />
                    </a>
                </div>
                <div class="topxx">
                    910513201419学员：${user}，欢迎您！ <a href="MyInfo/Index.jsp" target="contentshow">我的信息</a> <a href="User/StudentInfor/systemMsge.jsp" target="contentshow">
                        通知</a> <a href="User/Account/ChangePasswd.jsp" target="contentshow">密码修改</a> <a onclick="loginOut()"
                            href="login.jsp">安全退出</a>
                </div>
                <div id="time"></div>
            </div>
        </div>
    </div>
    <div class="page">
        <div class="box mtop">
            <div class="leftbox animated fadeInLeft">
                <div class="l_nav2">
                    <div class="ta1">
                        <strong>个人中心</strong>
                        <div class="leftbgbt">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div><a href="MyInfo/Index.jsp" target="contentshow">我的信息</a></div>
                        <div><a href="MyInfo/ClassInfo.jsp" target="contentshow">班级信息 </a>
                        </div>
                        <div><a href="EducationCenter/Score.jsp" target="contentshow">个人成绩</a></div>
                        <div><a href="MyInfo/attendence.jsp" target="contentshow">个人考勤</a></div>
                        <div><a href="User/StudentInfor/systemMsge.jsp" target="contentshow">我的通知</a></div>
                        <div><a href="User/StudentInfor/Letter.jsp" target="contentshow">在线提问</a></div>
                    </div>
                    <div class="ta1">
                        <strong>班级中心</strong>
                        <div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div>
                            <a href="EducationCenter/Book.jsp" target="contentshow">班级课程表</a></div>
                        <div>
                            <a href="EducationCenter/classfare.jsp" target="contentshow">班级班费</a></div>
                        <div>
                            <a href="EducationCenter/vote.jsp" target="contentshow">投票</a></div>
                        <div>
                            <a href="EducationCenter/group.jsp" target="contentshow">小组</a></div>
                    </div>
                    <div class="ta1">
                        <strong>学习中心</strong><div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div>
                            <a href="OnlineTeaching/StudentMaterial.jsp" target="contentshow">资料下载</a></div>
                        <div>
                            <a href="OnlineTeaching/StudentStudyRecordList.jsp" target="contentshow">资料上传</a></div>
                    </div> 
                </div>
            </div>
            <div class="rightbox animated zoomIn">
                <iframe src="MyInfo/Index.jsp" id="contentshow" name="contentshow" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" style="width:100%;height:100%">	
        </iframe>
            </div>
        </div>
    </div>
    <script> 
function currentTime(){ 
	var d=new Date(),str=''; 
	var weekday=new Array(7);
	weekday[0]="星期日";
	weekday[1]="星期一";
	weekday[2]="星期二";
	weekday[3]="星期三";
	weekday[4]="星期四";
	weekday[5]="星期五";
	weekday[6]="星期六";
	str+=d.getFullYear()+'年'; 
	str+=d.getMonth() + 1+'月'; 
	str+=d.getDate()+'日 '; 
	str+=weekday[d.getDay()]; 
	return str; 
} 
setInterval(function(){$('#time').html(currentTime)},1000);
$(function(){
	$(".page .box .leftbox .l_nav2 .cdlist div a").hover(function(){
		$(this).addClass("swing animated");
	},function(){
		$(this).removeClass("swing animated");
	})
})
</script>
</body>
</html>