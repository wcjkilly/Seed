

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>
	学生信息管理平台
</title><link href="Style/StudentStyle.css" rel="stylesheet" type="text/css" /><link href="Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" /><link href="Style/ks.css" rel="stylesheet" type="text/css" />
    <script src="Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="Script/Common.js" type="text/javascript"></script>
    <script src="Script/Data.js" type="text/javascript"></script>
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
    
    <script type="text/javascript">
        function submitMail() {
            var mtitle = "联系方式有修改";
            var html = "<div style='padding:10px;'><div style='width:65px; height:120px; float:left;'>修改的地方：</div><div style='width:250px; height:120px; float:left;'><textarea id='objeCont' name='objeCont' style='width:250px; height:105px;'></textarea></div></div>";

            var submit = function (v, h, f) {
                if (f.objeCont == '' || f.objeCont.length > 80) {
                    $.jBox.tip("请您输入有修改的地方，且不超过80个字！", 'error', { focusId: "objeCont" }); // 关闭设置 objeCont 为焦点
                    return false;
                }

                StudentCompain.insertCompain('', mtitle, 5, f.objeCont, function (data) {
                    var obj = $.parseJSON(data);
                    var resultObj = false;
                    if (obj.ok) {
                        $.jBox.tip("成功提交联系方式的修改邮件！");
                    }
                });
            };

            $.jBox(html, { title: "联系方式修改的邮件", submit: submit });
        }
    </script>
</head>
<body>                
<h2 class="mbx">我的信息 &gt; 个人资料 &nbsp;&nbsp;&nbsp;</h2>       
<div class="morebt">
<ul id="ulStudMsgHeadTab">
    <li><a class="tab2" onclick="" href="userInfo.action">我的信息</a> </li>
    <li><a class="tab2" onclick="" href="userClassInfo.action">班级信息</a></li>
    <li><a class="tab2" onclick="" href="../EducationCenter/Score.jsp">个人成绩</a></li>
    <li><a class="tab2" onclick="" href="attendence.jsp">个人考勤</a></li>
    <li><a class="tab2" onclick="" href="../User/StudentInfor/systemMsge.jsp">我的通知<span style="color:#ff0000; padding-left:5px;" id="unreadSysMsgCount"></span></a></li>
    <li><a class="tab2" onclick="" href="../User/StudentInfor/Letter.jsp">在线提问</a></li>
</ul>

</div>
<div class="cztable">
    <table width="100%" cellpadding="0" cellspacing="0">
        <tr>
            <td align="right" width="80">姓名：</td>
            <td>${user.username}&nbsp;</td>
            <td align="right" width="90">身份证号码：</td>
            <td>${user.cardid} &nbsp;</td>
            
            <td rowspan="9"><div align="center"><img id="pic_face"  height="160" width="120" src="Images/Student/photo.jpg"/ style="padding:2px 2px 5px; border:1px #ddd solid;"></div>&nbsp;</td>
        </tr>
        <tr>
            <td align="right">性别：</td>
            <td>${user.sex}&nbsp;</td>
            <td align="right">学号：</td>
            <td>${user.sid}&nbsp;</td>
        </tr>
        <tr>
            <td align="right">担任职务：</td>
            <td>${user.position}&nbsp;</td>
            <td align="right">所属专业：</td>
            <td>${user.major}&nbsp;</td>
        </tr>
        <tr>
            <td align="right">所在班级：</td>
            <td>${user.class_}&nbsp;</td>
            <td align="right">入校时间：</td>
            <td>${user.timeToSch}</td>
        </tr>
        <tr>
            <td align="right">联系地址：</td>
            <td>${user.address}&nbsp;</td>
            
            <td align="right">手机号：</td>
            <td>${user.tel}&nbsp;</td>
        </tr>
        <tr>
            <td align="right">QQ号：</td>
            <td>${user.qq}&nbsp;</td>           
            <td></td>
            <td>
                    <input type="button" id="button2" value="修改" onclick="submitMail()" class="input2" />
            </td>
        </tr>
    </table>
	</div>
</div>
</body>
</html>
