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
<link rel="stylesheet" type="text/css" href="Style/chat.css" />
<script type="text/javascript" src="Script/chat.js"></script>
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
<!--[if lt IE 7]>
<script src="js/IE7.js" type="text/javascript"></script>
<![endif]-->
<!--[if IE 6]>
<script src="js/iepng.js" type="text/javascript"></script>
<script type="text/javascript">
EvPNG.fix('body, div, ul, img, li, input, a, span ,label'); 
</script>
<![endif]-->
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
                    	学员：${ sessionScope.username }，欢迎您！ <a href="userInfo.action" target="contentshow">我的信息</a> <a href="systemMsge.action" target="contentshow">
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
                        <div><a href="userInfo.action" target="contentshow">我的信息</a></div>
                        <div><a href="userClassInfo.action" target="contentshow">班级信息 </a></div>
                        <div><a href="educationCenter.action" target="contentshow">个人成绩</a></div>
                        <div><a href="attendence.action" target="contentshow">个人考勤</a></div>
                        <div><a href="systemMsge.action" target="contentshow">我的通知</a></div>
                        <div><a href="letter.action" target="contentshow">在线提问</a></div>
                    </div>
                    <div class="ta1">
                        <strong>班级中心</strong>
                        <div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div>
                            <a href="book.action" target="contentshow">班级课程表</a></div>
                        <div>
                            <a href="classfare.action" target="contentshow">班级班费</a></div>
                        <div>
                            <a href="vote.action" target="contentshow">投票</a></div>
                        <div>
                            <a href="group.action" target="contentshow">小组</a></div>
                    </div>
                    <div class="ta1">
                        <strong>学习中心</strong><div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div>
                            <a href="studentMaterial.action" target="contentshow">资料下载</a></div>
                        <div>
                            <a href="studentStudyRecordList.action" target="contentshow">资料上传</a></div>
                    </div> 
                </div>
            </div>
            <div class="rightbox animated zoomIn">
                <iframe src="userInfo.action" id="contentshow" name="contentshow" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" style="width:100%;height:100%">	
        </iframe>
            </div>
        </div>
    </div>
    
    <img src="Images/contact.jpg" id="inlinecontact">
<!---在线聊天---->

    <div class="chatBox">
        <div class="chatLeft">
            <div class="chat01">
                <div class="chat01_title">
                    <ul class="talkTo">
                        <li><a href="javascript:;">王旭</a></li></ul>
                    <a class="close_btn" href="javascript:;"></a>
                </div>
                <div class="chat01_content">
                    <div class="message_box mes1">
                    </div>
                    <div class="message_box mes2">
                    </div>
                    <div class="message_box mes3" style="display: block;">
                    </div>
                    <div class="message_box mes4">
                    </div>
                    <div class="message_box mes5">
                    </div>
                    <div class="message_box mes6">
                    </div>
                    <div class="message_box mes7">
                    </div>
                    <div class="message_box mes8">
                    </div>
                    <div class="message_box mes9">
                    </div>
                    <div class="message_box mes10">
                    </div>
                </div>
            </div>
            <div class="chat02">
                <div class="chat02_title">
                    <a class="chat02_title_btn ctb01" href="javascript:;"></a><a class="chat02_title_btn ctb02"
                        href="javascript:;" title="选择文件">
                        <embed width="15" height="16" flashvars="swfid=2556975203&amp;maxSumSize=50&amp;maxFileSize=50&amp;maxFileNum=1&amp;multiSelect=0&amp;uploadAPI=http%3A%2F%2Fupload.api.weibo.com%2F2%2Fmss%2Fupload.json%3Fsource%3D209678993%26tuid%3D1887188824&amp;initFun=STK.webim.ui.chatWindow.msgToolBar.upload.initFun&amp;sucFun=STK.webim.ui.chatWindow.msgToolBar.upload.sucFun&amp;errFun=STK.webim.ui.chatWindow.msgToolBar.upload.errFun&amp;beginFun=STK.webim.ui.chatWindow.msgToolBar.upload.beginFun&amp;showTipFun=STK.webim.ui.chatWindow.msgToolBar.upload.showTipFun&amp;hiddenTipFun=STK.webim.ui.chatWindow.msgToolBar.upload.hiddenTipFun&amp;areaInfo=0-16|12-16&amp;fExt=*.jpg;*.gif;*.jpeg;*.png|*&amp;fExtDec=选择图片|选择文件"
                            data="upload.swf" wmode="transparent" bgcolor="" allowscriptaccess="always" allowfullscreen="true"
                            scale="noScale" menu="false" type="application/x-shockwave-flash" src="http://service.weibo.com/staticjs/tools/upload.swf?v=36c9997f1313d1c4"
                            id="swf_3140">
                    </a><a class="chat02_title_btn ctb03" href="javascript:;" title="选择附件">
                        <embed width="15" height="16" flashvars="swfid=2556975203&amp;maxSumSize=50&amp;maxFileSize=50&amp;maxFileNum=1&amp;multiSelect=0&amp;uploadAPI=http%3A%2F%2Fupload.api.weibo.com%2F2%2Fmss%2Fupload.json%3Fsource%3D209678993%26tuid%3D1887188824&amp;initFun=STK.webim.ui.chatWindow.msgToolBar.upload.initFun&amp;sucFun=STK.webim.ui.chatWindow.msgToolBar.upload.sucFun&amp;errFun=STK.webim.ui.chatWindow.msgToolBar.upload.errFun&amp;beginFun=STK.webim.ui.chatWindow.msgToolBar.upload.beginFun&amp;showTipFun=STK.webim.ui.chatWindow.msgToolBar.upload.showTipFun&amp;hiddenTipFun=STK.webim.ui.chatWindow.msgToolBar.upload.hiddenTipFun&amp;areaInfo=0-16|12-16&amp;fExt=*.jpg;*.gif;*.jpeg;*.png|*&amp;fExtDec=选择图片|选择文件"
                            data="upload.swf" wmode="transparent" bgcolor="" allowscriptaccess="always" allowfullscreen="true"
                            scale="noScale" menu="false" type="application/x-shockwave-flash" src="http://service.weibo.com/staticjs/tools/upload.swf?v=36c9997f1313d1c4"
                            id="swf_3140">
                    </a>
                    <label class="chat02_title_t">
                        <a href="chat.htm" target="_blank">聊天记录</a></label>
                    <div class="wl_faces_box">
                        <div class="wl_faces_content">
                            <div class="title">
                                <ul>
                                    <li class="title_name">常用表情</li><li class="wl_faces_close"><span>&nbsp;</span></li></ul>
                            </div>
                            <div class="wl_faces_main">
                                <ul>
                                    <li><a href="javascript:;">
                                        <img src="img/emo_01.gif" /></a></li><li><a href="javascript:;">
                                            <img src="img/emo_02.gif" /></a></li><li><a href="javascript:;">
                                                <img src="img/emo_03.gif" /></a></li>
                                    <li><a href="javascript:;">
                                        <img src="img/emo_04.gif" /></a></li><li><a href="javascript:;">
                                            <img src="img/emo_05.gif" /></a></li><li><a href="javascript:;">
                                                <img src="img/emo_06.gif" /></a></li>
                                    <li><a href="javascript:;">
                                        <img src="img/emo_07.gif" /></a></li><li><a href="javascript:;">
                                            <img src="img/emo_08.gif" /></a></li><li><a href="javascript:;">
                                                <img src="img/emo_09.gif" /></a></li>
                                    <li><a href="javascript:;">
                                        <img src="img/emo_10.gif" /></a></li><li><a href="javascript:;">
                                            <img src="img/emo_11.gif" /></a></li><li><a href="javascript:;">
                                                <img src="img/emo_12.gif" /></a></li>
                                    <li><a href="javascript:;">
                                        <img src="img/emo_13.gif" /></a></li><li><a href="javascript:;">
                                            <img src="img/emo_14.gif" /></a></li><li><a href="javascript:;">
                                                <img src="img/emo_15.gif" /></a></li>
                                    <li><a href="javascript:;">
                                        <img src="img/emo_16.gif" /></a></li><li><a href="javascript:;">
                                            <img src="img/emo_17.gif" /></a></li><li><a href="javascript:;">
                                                <img src="img/emo_18.gif" /></a></li>
                                    <li><a href="javascript:;">
                                        <img src="img/emo_19.gif" /></a></li><li><a href="javascript:;">
                                            <img src="img/emo_20.gif" /></a></li><li><a href="javascript:;">
                                                <img src="img/emo_21.gif" /></a></li>
                                    <li><a href="javascript:;">
                                        <img src="img/emo_22.gif" /></a></li><li><a href="javascript:;">
                                            <img src="img/emo_23.gif" /></a></li><li><a href="javascript:;">
                                                <img src="img/emo_24.gif" /></a></li>
                                    <li><a href="javascript:;">
                                        <img src="img/emo_25.gif" /></a></li><li><a href="javascript:;">
                                            <img src="img/emo_26.gif" /></a></li><li><a href="javascript:;">
                                                <img src="img/emo_27.gif" /></a></li>
                                    <li><a href="javascript:;">
                                        <img src="img/emo_28.gif" /></a></li><li><a href="javascript:;">
                                            <img src="img/emo_29.gif" /></a></li><li><a href="javascript:;">
                                                <img src="img/emo_30.gif" /></a></li>
                                    <li><a href="javascript:;">
                                        <img src="img/emo_31.gif" /></a></li><li><a href="javascript:;">
                                            <img src="img/emo_32.gif" /></a></li><li><a href="javascript:;">
                                                <img src="img/emo_33.gif" /></a></li>
                                    <li><a href="javascript:;">
                                        <img src="img/emo_34.gif" /></a></li><li><a href="javascript:;">
                                            <img src="img/emo_35.gif" /></a></li><li><a href="javascript:;">
                                                <img src="img/emo_36.gif" /></a></li>
                                    <li><a href="javascript:;">
                                        <img src="img/emo_37.gif" /></a></li><li><a href="javascript:;">
                                            <img src="img/emo_38.gif" /></a></li><li><a href="javascript:;">
                                                <img src="img/emo_39.gif" /></a></li>
                                    <li><a href="javascript:;">
                                        <img src="img/emo_40.gif" /></a></li><li><a href="javascript:;">
                                            <img src="img/emo_41.gif" /></a></li><li><a href="javascript:;">
                                                <img src="img/emo_42.gif" /></a></li>
                                    <li><a href="javascript:;">
                                        <img src="img/emo_43.gif" /></a></li><li><a href="javascript:;">
                                            <img src="img/emo_44.gif" /></a></li><li><a href="javascript:;">
                                                <img src="img/emo_45.gif" /></a></li>
                                    <li><a href="javascript:;">
                                        <img src="img/emo_46.gif" /></a></li><li><a href="javascript:;">
                                            <img src="img/emo_47.gif" /></a></li><li><a href="javascript:;">
                                                <img src="img/emo_48.gif" /></a></li>
                                    <li><a href="javascript:;">
                                        <img src="img/emo_49.gif" /></a></li><li><a href="javascript:;">
                                            <img src="img/emo_50.gif" /></a></li><li><a href="javascript:;">
                                                <img src="img/emo_51.gif" /></a></li>
                                    <li><a href="javascript:;">
                                        <img src="img/emo_52.gif" /></a></li><li><a href="javascript:;">
                                            <img src="img/emo_53.gif" /></a></li><li><a href="javascript:;">
                                                <img src="img/emo_54.gif" /></a></li>
                                    <li><a href="javascript:;">
                                        <img src="img/emo_55.gif" /></a></li><li><a href="javascript:;">
                                            <img src="img/emo_56.gif" /></a></li><li><a href="javascript:;">
                                                <img src="img/emo_57.gif" /></a></li>
                                    <li><a href="javascript:;">
                                        <img src="img/emo_58.gif" /></a></li><li><a href="javascript:;">
                                            <img src="img/emo_59.gif" /></a></li><li><a href="javascript:;">
                                                <img src="img/emo_60.gif" /></a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="wlf_icon">
                        </div>
                    </div>
                </div>
                <div class="chat02_content">
                    <textarea id="textarea"></textarea>
                </div>
                <div class="chat02_bar">
                    <ul>
                        <li style="right: 5px; top: 5px;"><a href="javascript:;">
                            <img src="img/send_btn.jpg"></a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="chatRight">
            <div class="chat03">
                <div class="chat03_title">
                    <label class="chat03_title_t">
                        成员列表</label>
                </div>
                <div class="chat03_content">
                    <ul>
                        <li>
                            <label class="online">
                            </label>
                            <a href="javascript:;">
                                <img src="img/head/2013.jpg"></a><a href="javascript:;" class="chat03_name">刘秀</a>
                        </li>
                        <li>
                            <label class="offline">
                            </label>
                            <a href="javascript:;">
                                <img src="img/head/2014.jpg"></a><a href="javascript:;" class="chat03_name">陈诚</a>
                        </li>
                        <li class="choosed">
                            <label class="offline">
                            </label>
                            <a href="javascript:;">
                                <img src="img/head/2015.jpg"></a><a href="javascript:;" class="chat03_name">王旭</a>
                        </li>
                        <li>
                            <label class="offline">
                            </label>
                            <a href="javascript:;">
                                <img src="img/head/2016.jpg"></a><a href="javascript:;" class="chat03_name">张灵</a>
                        </li>
                        <li>
                            <label class="online">
                            </label>
                            <a href="javascript:;">
                                <img src="img/head/2017.jpg"></a><a href="javascript:;" class="chat03_name">吴敬</a>
                        </li>
                        <li>
                            <label class="offline">
                            </label>
                            <a href="javascript:;">
                                <img src="img/head/2018.jpg"></a><a href="javascript:;" class="chat03_name">王海东</a>
                        </li>
                        <li>
                            <label class="offline">
                            </label>
                            <a href="javascript:;">
                                <img src="img/head/2019.jpg"></a><a href="javascript:;" class="chat03_name">郑小勇</a>
                        </li>
                        <li>
                            <label class="online">
                            </label>
                            <a href="javascript:;">
                                <img src="img/head/2020.jpg"></a><a href="javascript:;" class="chat03_name">张珊珊</a>
                        </li>
                        <li>
                            <label class="offline">
                            </label>
                            <a href="javascript:;">
                                <img src="img/head/2021.jpg"></a><a href="javascript:;" class="chat03_name">刘强</a>
                        </li>
                        <li>
                            <label class="offline">
                            </label>
                            <a href="javascript:;">
                                <img src="img/head/2022.jpg"></a><a href="javascript:;" class="chat03_name">程海斌</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div style="clear: both;">
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
});

$("#inlinecontact").click(function(){
	$(".chatBox").show(500);
})
</script>
</body>
</html>