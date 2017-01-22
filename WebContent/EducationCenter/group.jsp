<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
</head>
<body>    
    <h2 class="mbx">
        班级中心 &gt; 班级班费</h2>
    <div class="morebt">
        <ul>
            <li><a class="tab2" href="Book.jsp">班级课程表</a></li>
            <li><a class="tab2" href="classfare.jsp">班级班费</a></li>
            <li><a class="tab2" href="vote.jsp">投票</a></li>
            <li><a class="tab1" href="group.jsp">小组</a></li>
        </ul>
    </div>
    <div class="cztable">
       <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <th width="5%">序号</th>
            <th width="12%">小组类别</th>
            <th width="8%">小组组长</th>
            <th width="25%">小组成员</th>
            <th width="8%">成立时间</th>
            <th width="10%">备注</th>
        </tr>
        
        <tr style="height: 28px" class="tdbg" align="left">
            <td>1</td>
            <td>班会</td>
            <td>幸福</td>
            <td>发布个可交付电脑成</td>
            <td >2015-01-10</td>
            <td>+++</td>
        </tr>
    </table>  
     <div class="btndeli" style="display: block;">
        <button class="deliverynew">添 加</button>
        <button class="deliveryback">取 消</button>
    </div>
    <div class="newdetail" style="clear:both;display:none">
    	<h3>添加班费信息</h3>
        <label>请输入小组类别： </label>
        <input type="text" /><br />
        <label>请输入小组组长： </label>
        <input type="text" /><br />
        <label>请输入小组成员： </label>
        <input type="text" /><br />
        <label>请选择成立时间： </label>
        <input type="date" /><br /><label>
        备注： </label>
        <input type="text" />
    </div>
    </div>
</body>
<script>
$(".deliverynew").click(function(){
	$(".newdetail").css("display","block");
	$(this).text("确 定");
});
$(".deliveryback").click(function(){
	$(".newdetail").css("display","none");
	$(".deliverynew").text("添 加");
})
</script>
</html>
