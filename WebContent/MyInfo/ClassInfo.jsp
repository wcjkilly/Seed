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
        //学生投诉异议
        function onSaveProblem() {
            var studentId = $("#studentId").val();
            var workAssess = $('input[name="workAssess"]:checked').val();
            var problemContent = $("#problemContent").val();
            var problemType = $('input[name="problemType"]:checked').val();
            var problemTypeStr = "学生";
            switch (problemType) { 
                case "4": problemTypeStr+="提问"; break;
                case "3": problemTypeStr += "意见"; break;
                case "1": problemTypeStr += "投诉"; break;
                default: break;
            }

            if (problemContent.length <= 0) {
                jBox.tip("请填写问题反馈的内容！");
                return false;
            }
            else {
                problemContent = "工作评价：" + workAssess + "，" + problemContent;
                StudentCompain.insertCompain(studentId, problemTypeStr, problemType, problemContent, function (data) {
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
        }
    </script>
</head>
<body>
<h2 class="mbx">个人中心 &gt; 班级信息</h2>  
<div class="morebt">
    
<%@include file="../JspCommon/userCenterTagHead.jsp"%>

</div>
<div class="cztable">
    <table border="0" cellspacing="0" cellpadding="0" width="100%" >
        <tr>
            <td width="91" align="right">班级名称：</td>
            <td colspan="5">${classInfo.class_}&nbsp;</td>
        </tr>
        <tr>
            <td align="right">班级QQ群：</td>
            <td colspan="5">${classInfo.classqq}&nbsp;</td>
        </tr>
        <tr>
            <td align="right">班级宣传语：</td>
            <td colspan="5">${classInfo.classflag}&nbsp;</td>
        </tr>
        <tr>
            <td align="right">学校名称：</td>
            <td colspan="5">${classInfo.school}&nbsp;</td>
        </tr>
            
            <tr>
                    <td align="right"><div align="right">辅导员老师：</div>&nbsp;</td>
                    <td><div align="left">${classInfo.fteacher}</div></td>
                    <td><div align="right">电话：</div>&nbsp;</td>
                    <td><div align="left">${classInfo.tel}</div>&nbsp;</td>
                    <td align="right"><div align="right">在线交流：</div>&nbsp;</td>
                    <td align="right"><div align="left"><a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2::41" alt="点击这里给我发消息" /></a></div>&nbsp;</td>
                  </tr>
            
        <tr>
            <td align="right">工作评价：</td>
            <td colspan="5">
                <input value="满意" checked="checked" type="radio" name="workAssess" />满意
                <input value="一般" type="radio" name="workAssess" />一般
                <input value="差" type="radio" name="workAssess" />差
            </td>
        </tr>
        <tr>
            <td rowspan="3" align="right">问题反馈：</td>
            <td colspan="5">
                <input value="4" checked="checked" type="radio" name="problemType" />提问
                
                <input value="1" type="radio" name="problemType" />投诉
            </td>
        </tr>
        <tr>
            <td colspan="5">
                <textarea name="problemContent" id="problemContent" cols="80" rows="6" class="input_2"></textarea>
            </td>
        </tr>
        <tr>
            <td colspan="5" align="left" valign="middle">
                <input type="button" name="button2" id="button2" value="点击提交" class="input2" onclick="onSaveProblem()" />
            </td>
        </tr>
    </table>
</div>
    </div>
</body>
</html>
