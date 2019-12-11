<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/base/base.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>用户信息列表</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script language="javascript">
			//json传数据
			var result = [];
		$(document).ready(function() {
			$("#btnSubmit").click(function() {
				result = get_table_data();
				$("#hidTD").val(JSON.stringify(result));
				$("#form").submit();
			});
		});
		
		function get_table_data() {
		 	var tr = $("#table tr");
			for (var i = 1; i < tr.length; i++) {
				var tds = $(tr[i]).find("td");
				if (tds.length > 0) {
					result.push({
						"课程名字" : $(tds[0]).html(),
						"学生ID" : $(tds[1]).html(),
						"学生名字" : $(tds[2]).html(),
						"时间" : $(tds[3]).html(),
						"状态" : $(tds[4]).html()
					});
				}
			}
			return (result);
		}
	</script>
</head>

<body>
<form method="post" action="xml_out.action" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 用户列表</strong> </div>
    <div class="padding border-bottom" align="center">
		<div class="panel admin-panel">
			<div class="padding border-bottom">
				<div class="button-group">
		
	    		</div>
			</div>
		</div>
     
    </div>
    <table class="table table-hover text-center"  id="table">
      <tr>  				
			<th>课程名字</th>
			<th>学生ID</th>
			<th>学生名字</th>
			<th>时间</th>
			<th>状态</th>
       </tr>
       <s:iterator value="attendancelist" >
			    <tr>
			    	<td>${course.courseName}</td>
		          	<td>${studentId}</td>
		          	<td>${student.stuName}</td>
		          	<td>${time}</td>
		         	<td><s:if test="stats==0">正常</s:if><s:if test="stats==1">迟到</s:if><s:if test="stats==2">早退</s:if><s:if test="stats==3">旷课</s:if><s:if test="stats==4">请假</s:if></td>
		         	<%-- <c:set var="salary" scope="session" value="${stats}"/>
		         	<td><c:if test="${salary==0}">正常</c:if><c:if test="${salary==1}">早退</c:if><c:if test="${salary==2}">旷课</c:if><c:if test="${salary==3}">请假</c:if></td>  --%>
			</tr>
	 </s:iterator>
    </table>
  </div>
  <div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> </div>
</form>
	<form method="post" action="attendance_out.action" id="form">
	  <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="pagelist"  style="float:right;">
        <input type="hidden" name="table_data" value="" id="hidTD">
          <button class="button bg-main icon-check-square-o" id="btnSubmit" type="submit">导出</button>
        </div>
        </div>
	
	</form>
</body>
</html>
