<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>
	学生信息管理平台
</title><link href="../../Style/StudentStyle.css" rel="stylesheet" type="text/css" /><link href="../../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" /><link href="../../Style/ks.css" rel="stylesheet" type="text/css" />
    <script src="../../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="../../Script/Common.js" type="text/javascript"></script>
    <script src="../../Script/Data.js" type="text/javascript"></script>
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
    </script>
    
<script type="text/javascript">
    function returnIndex() {
        window.location = "/Index.aspx";
    }
    function showMsg(msg, obj) {
        jBox.tip(msg);
        $("#" + obj).focus();
    }
    function saveClick(studentId) {
        var Ctitle = $("#Ctitle").val();   //消息标题
        if (Ctitle == "" || Ctitle.length>20) {
            showMsg("请您输入消息标题,且不超过20个字！", "Ctitle");
            return false;
        }
        var Ctype = $("#Ctype").val();  //消息类型
        if (Ctype == ("Unselected")) {
            showMsg("请您选择投诉类型！", "Ctype");
            return false;
        }
        var Ccontent = $("#Ccontent").val(); //消息内容
        if (Ccontent == "" || Ccontent.length>80) {
            showMsg("请您输入消息内容，且不超过80个字！", "Ccontent");
            return false;
        }
        StudentCompain.insertCompain(studentId, Ctitle, Ctype, Ccontent, function (data) {
            var obj = $.parseJSON(data);
            if (obj.ok == true) {
                jBox.alert(obj.message, "提示");
                setTimeout(function () {
                    window.location.reload();
                }, 1500);
            }
            else {
                jBox.tip(obj.message);
            }
        });
    }
</script>
</head>
<body>
<h2 class="mbx">我的信息 &gt; 在线提问</h2>
<div class="morebt">
    

<ul id="ulStudMsgHeadTab">
    <li><a class="tab2" onclick="" href="../../MyInfo/Index.jsp">我的信息</a> </li>
    <li><a class="tab2" onclick="" href="../../MyInfo/ClassInfo.jsp">班级信息</a></li>
    <li><a class="tab2" onclick="" href="../../EducationCenter/Score.jsp">个人成绩</a></li>
    <li><a class="tab2" onclick="" href="../../MyInfo/attendence.jsp">个人考勤</a></li>
    <li><a class="tab2" onclick="" href="systemMsge.jsp">我的通知<span style="color:#ff0000; padding-left:5px;" id="unreadSysMsgCount"></span></a></li>
    <li><a class="tab2" onclick="" href="Letter.jsp">在线提问</a></li>
</ul>

</div>
<div class="cztable">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <th style="text-align:center;" width="5%">序号</th>
            <th style="text-align:center;" width="10%">类型</th>
            <th width="15%">标题</th>
            <th width="20%">内容</th>
            <th style="text-align:center;" width="18%">添加时间</th>
            <th style="text-align:center;" width="13%">状态</th>
        </tr>
        
        <tr style="height: 28px" class="tdbg" align="center">
            <td colspan="13" align="left" style="color: Red; font-weight:bold;">暂无信息!</td>
        </tr>
        
    </table>
</div>

<div class="cztable">
<h2 class="mbx">我的信息 &gt; 给班主任发短信</h2>

    <table width="100%" cellpadding="0" cellspacing="0">
        <tr>
            <td width="15%" align="right"><div align="right">信息主题： </div></td>
            <td style="text-align:left"><input id="Ctitle" size="20" name="Ctitle" class="input_2"/></td>
        </tr>
        <tr>
            <td width="15%" align="right"><div align="right">信息类型： </div></td>
            <td style="text-align:left">
                <select id="Ctype" name="Ctype">
                    <option value="Unselected">请选择</option>
                    <option value="1">Java课程</option>
                    <option value="3">Web实训</option>
                    <option value="4">高等数学</option>
                </select>
            </td>
        </tr>
        <tr>
            <td width="15%" align="right"><div align="right">信息内容： </div></td>
            <td style="text-align:left"><textarea name="Ccontent" cols="80" rows="5" id="Ccontent" class="input_2"></textarea></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <div align="center" >
                    <input type="submit" value="提交" onclick="saveClick('7c50f70a-775b-4aef-8bf2-5010ec612c0d')" class="input2" />
                    <input type="submit" value="返回" onclick="returnIndex()" class="input2" />
                </div>
            </td>
        </tr>
    </table>
</div>
    </div>
</body>
</html>
