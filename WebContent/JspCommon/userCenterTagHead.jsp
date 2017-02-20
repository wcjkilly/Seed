<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<ul id="ulStudMsgHeadTab">
    <li><a class="tab2" onclick="" href="userInfo.action">我的信息</a> </li>
    <li><a class="tab2" onclick="" href="userClassInfo.action">班级信息</a></li>
    <li><a class="tab2" onclick="" href="educationCenter.action">个人成绩</a></li>
    <li><a class="tab2" onclick="" href="attendence.action">个人考勤</a></li>
    <li><a class="tab2" onclick="" href="systemMsge.action">我的通知<span style="color:#ff0000; padding-left:5px;" id="unreadSysMsgCount"></span></a></li>
    <li><a class="tab2" onclick="" href="letter.action">在线提问</a></li>
</ul>