<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.demo.com/ELUrlHelper" prefix="el"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>学生信息管理平台</title>
	<link href="Style/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
	<link href="Style/ks.css" rel="stylesheet" type="text/css" />
    <script src="Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="Script/Common.js" type="text/javascript"></script>
    <script src="Script/Data.js" type="text/javascript"></script>
    
    <script src="Script/Common.js" type="text/javascript"></script>
    <script type="text/javascript">
    	/* 查询资料，type：按科目还是类型进行查询，docsub：科目，doctype:类型 */
        function searchData(type, docsub, doctype) {
            if (type == "docsub") {
                var doctypeV = $("#doctypeValue").val();
                window.location = 'studentMaterial.action?docsub=' + docsub + "&doctype=" + doctypeV;
            } else if (type == "doctype") {
                var docsubV = $("#docsubValue").val();
                window.location = 'studentMaterial.action?docsub=' + docsubV + "&doctype=" + doctype;
            }
        }
        /* 查询的填充 ，显示当前查询的科目和类型信息 */
        $().ready(function () {
            var docsub = Request.QueryString("docsub");
            var doctype = Request.QueryString("doctype");
            if (docsub != null && docsub != "" && docsub != "all") {
                $("#docsubValue").val(docsub);
                /* 正则表达式去除jQuery无法识别的特殊字符 */
                var docsubId = docsub.replace(/[%~`,@#&=:;<>/]/g, "");
                $("#" + docsubId).addClass("hover");
            } else {
                $("#docsubAll").addClass("hover");
            }
            if (doctype != null && doctype != "" && doctype != "all") {
                $("#doctypeValue").val(doctype);
                /* 正则表达式去除jQuery无法识别的特殊字符 */
                var doctypeId = doctype.replace(/[%~`,@#&=:;<>/]/g, "");
                $("#" + doctypeId).addClass("hover");
            } else {
                $("#doctypeAll").addClass("hover");
            }
        });
    </script>
</head>
<body>
    <h2 class="mbx">学习中心 &gt; 资料下载</h2>
    <div class="feilei">
        <a href="#"><strong>资料中心</strong></a>
    </div>
    <input type="hidden" id="docsubValue" value="" />
    <input type="hidden" id="doctypeValue" value="" />
    <div class="fllist">
        <ul>
            <li>
	            <strong>科目：</strong>
	            <a href="#" id="docsubAll" onclick="searchData('docsub','all','')">全部</a>
	            <c:forEach  var="docsub" items="${ docSubs }" varStatus="status">
		            <a href="#" id="${ el:urlEncodeToId(docsub) }" onclick="searchData('docsub','${ el:urlEncode(docsub) }','')">${ docsub }</a>
		        </c:forEach>
            </li>
            <li>
	            <strong>类型：</strong>
	            <a href="#" id="doctypeAll" onclick="searchData('doctype','','all')">全部</a>
	            <c:forEach  var="doctype" items="${ docTypes }" varStatus="status">
		            <a href="#" id="${ el:urlEncodeToId(doctype) }" onclick="searchData('doctype','','${ el:urlEncode(doctype) }')">${ doctype }</a>
		        </c:forEach>
            </li>
        </ul>
        <div class="cztable">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" style="text-align:center;">
                <tr>
                	<th width="6%">格式</th>
                    <th style="padding-left: 20px;">资料名称</th>
                    <th style="width: 15%; text-align: center;">科目</th>
                    <th style="width: 15%; text-align: center;">资料类型</th>
                    <th style="width: 20%; text-align: center;">更新时间</th>
                    <th style="width: 15%; text-align: center;">操作</th>
                </tr>
                
                <c:forEach  var="doc" items="${ docList }" varStatus="status">
		    		<tr>
	               		<td><img src='Images/FileIco/doc.gif' /></td>
	                    <td class="xxleft">${ doc.documentName }</td>
	                    <td>${ doc.documentSub }</td>
	                    <td>${ doc.documentType }</td>
	                    <td>${ doc.uploadTime }</td>
	                    <td>
	                    	<a href="${ doc.path }" target="_blank">
	                        	<img src="Images/down.gif" alt="点击下载" /></a>
	                    </td>
	                </tr>
		    	</c:forEach>
            </table>
            
            <!-- TODO 分页 -->
            <!-- <div class='MainStyle'>
	            <div class=''>
	            	<a href='http://sm.zk0731.com/OnlineTeaching/StudentMaterial.aspx?page=1' target='_self'>首页</a>
	            </div>
	            <div class=''>
	            	<a href='javascript:void(0)' target='_self'>上一页</a>
	            </div>
	            <div class='NowItemStyle'>
	            	<a href='javascript:void(0)' target='_self'>1</a>
	            </div>
	            <div class=''>
	            	<a href='http://sm.zk0731.com/OnlineTeaching/StudentMaterial.aspx?page=2' target='_self'>2</a>
	            </div>
	            <div class=''>
	            	<a href='http://sm.zk0731.com/OnlineTeaching/StudentMaterial.aspx?page=3' target='_self'>3</a>
	            </div>
	            <div class=''>
	            	<a href='http://sm.zk0731.com/OnlineTeaching/StudentMaterial.aspx?page=2' target='_self'>下一页</a>
	            </div>
	            <div class=''>
	            	<a href='http://sm.zk0731.com/OnlineTeaching/StudentMaterial.aspx?page=3' target='_self'>尾页</a>
	            </div>
	            <div class=''>总共<b>44</b>条数据</div>
	            <div class=''>每页<b>20</b>条数据</div>
	            <div class=''><b>1</b>/3</div>
	            <div class='SearchStyle'>
	            	<input type='text' id='john_Page_Search' onkeydown="if(event.keyCode == 13){page_searchIndex();}"/>
	            </div>
	            <div class=''>
	            	<input type='button' value='Go' onclick="page_searchIndex()"/>
	            </div>
            </div>
            <script type="text/javascript">    
	            function page_searchIndex(){
	            	var searchText = document.getElementById('john_Page_Search');
	            	var searchIndex = searchText != null && searchText.value != '' ? parseInt(searchText.value) : 0;    
	            	if(searchIndex > 0 && searchIndex <= 3) {       
	            		window.location='StudentMaterial.aspx?page=' + searchIndex;      
	            	}else{
	            		alert('需要跳转的页码不能超出范围！');       
	            	}  
	            }
            </script> -->
        </div>
    </div>
</body>
</html>
