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
    <li><a class="tab2" href="course.action">班级课程表</a></li>
    <li><a class="tab2" href="classfare.action">班级班费</a></li>
    <li><a class="tab2" href="vote.action">投票</a></li>
    <li><a class="tab2" href="group.action">小组</a></li>
</ul>