<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>
	学生信息管理平台
</title>
	<link href="../../Style/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
	<link href="../../Style/ks.css" rel="stylesheet" type="text/css" />
    <script src="../../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="../../Script/Common.js" type="text/javascript"></script>
    <script src="../../Script/Data.js" type="text/javascript"></script>
    
<script type="text/javascript" language="javascript">
    function changePassword() {
        var oldPwd = $("#txtOldPwd").val();
        var newPwd = $("#txtNewPwd").val();
        var confirmNewPwd = $("#txtConfirmNewPwd").val();

        if (oldPwd == "" || newPwd == "" || confirmNewPwd=="") {
            $.jBox.tip("旧密码或新密码或确认新密码不能为空！", 'error');
            return false;
        }
        if (oldPwd.length < 3 || oldPwd.length > 16) {
            $.jBox.tip("旧密码为3~16个字符，区分大小写！", 'error');
            return false;
        }
        if (newPwd.length < 3 || newPwd.length > 16) {
            $.jBox.tip("新密码为3~16个字符，区分大小写！", 'error');
            return false;
        }
        if (newPwd != confirmNewPwd) {
            $.jBox.tip("新密码两次输入不一致！", 'error');
            return false;
        }
		
      //ajax提交修改密码请求
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath}/userChangePwd.action',
			data:{oldPwd:oldPwd, newPwd:newPwd},
			dataType: 'json',
			success:function(data){
				if(data.changePwdRS == "true"){
					$.jBox.tip("修改密码成功，请重新登录", 'success');
					window.parent.location ="${pageContext.request.contextPath}/userLogout.action";
				}else{
					$.jBox.tip("修改密码失败，请保证旧密码正确", 'error');
				}
			}
		});
       
    }
</script>
<style type="text/css">
    .txtinput1{width:180px;}
</style>
</head>
<body>
<h2 class="mbx">我的信息 &gt; 密码修改</h2>
<div class="cztable">
<table border="0" cellspacing="0" cellpadding="0" width="500px" style="margin:30px auto 0px auto;">
    <tr align="center">
        <th style="width:20%; text-align:left;">旧密码：</th>
        <td style="width:70%; text-align:left;">
        	<input id="txtOldPwd" value="" type="password" class="input_2 txtinput1" />
        </td>
    </tr>
    <tr align="center">
        <th style="width:20%; text-align:left;">新密码：</th>
        <td style="width:70%; text-align:left;">
        	<input id="txtNewPwd" value="" type="password" class="input_2 txtinput1" />
        	&nbsp;&nbsp;6~16个字符，区分大小写
        </td>
    </tr>
    <tr align="center">
        <th style="width:20%; text-align:left;">确认新密码：</th>
        <td style="width:70%; text-align:left;">
        	<input id="txtConfirmNewPwd" value="" type="password" class="input_2 txtinput1" />
        </td>
    </tr>
    <tr>
    	<td colspan="2" style="text-align:center;">
    		<input type="submit" id="btnSubmit" value="确认修改" onclick="changePassword()" class="input2" />
    	</td>
    </tr>
</table>
</div>
    </div>
</body>
</html>
