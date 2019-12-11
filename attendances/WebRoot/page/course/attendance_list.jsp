<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/base/base.jsp"%>
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
<script>
	//下拉框联动
	function select() 
	{	
		var courseId = document.getElementById("coursename").value;
   $.ajax({
         type: "GET",      //请求方式
         contentType: "application/json;charset=UTF-8",
         url: "json_gettime.action",//验证的路径    
         data: "courseId="+courseId,  //参数
         success: function(data){  //返回值
        		 courseTime.remove(0)//删除第一个
                $.each(JSON.parse(data.courses), function (index, item) {//遍历数据
                //填充下拉框
                $("#courseTime").append("<option value='" + item.courseTime+ "'>" + item.courseTime + "</option>")
            })
       }            
  });
	}
	
	
	//随机抽取
	function check() {
		var courseId = document.getElementById("coursename").value;
		var courseTime = document.getElementById("courseTime").value;
		var number = document.getElementById("number").value;
		$.ajax({
			type : "GET", //请求方式
			contentType : "application/json;charset=UTF-8",
			url : "attendance_list.action", //验证的路径    
			data : {
				number : number,
				courseId : courseId,
			}, //参数           
		});
		}
		
	var message = "${message}";
	if(message){
	alert(message); 
	window.history.back(-1); 
}

</script>
</head>

<body>
<form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 用户列表</strong> </div>
   <%--  <form method="post" action="<%=path%>/BuildServlet?action=seach" > --%>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
            <li>课程名称：</li> 
            <li>
            <select  id="coursename" onchange="select()"  >
             <option value="0">--请选择课程--</option>
			 <s:iterator value="courselist">   
	        <option value="${courseId}">${courseName}</option> 
	        </s:iterator>
	          </select>
		</li>
		
		   <li>时间: </li><li>         
            <select  id="courseTime" ">
            <option value="">--请选择时间--</option>
            </select> 
           </li>
           <li>
           <li>抽取人数：</li><li>        
          <select   id="number"  >
            <option value="0">--全班--</option>
            <option value="3">3</option>
            <option value="10">10</option>
            <option value="15">15</option>
            </select></li>
         <li>
   		   <button type=“button” class="button border-main" onclick="check()" ><span>确定</span></button>		
		</li> 
      </ul>


    </div>
    <!-- </form>  -->
    <table class="table table-hover text-center"  id="table">
      <tr>  			
      		<th>序号</th>	
      		<th>课程 ID</th>
			<th>学生ID</th>
			<th>学生名称</th>
			<th>班级</th> 
			<th>操作</th>
       </tr>

	 				<%Integer index=1; %>
			 <s:iterator value="#session.sheetlist" status="indexValue" var="sheet" >
				<tr>
					<td>
					<%= index++ %>
					</td>
					<td>${courseId}</td>
					<td>${studentId}</td>
					<td>${student.stuName}</td>
					<td>${student.classesId}</td>
					
					<td>
					<div style="color:#333333;font-size:16px;font-weight:bold">
					    <label>正常</label><input type="radio" checked="checked" name="status${studentId}" value="0" />
                        <label>迟到</label><input type="radio"  name="status${studentId}" value="1" />
                        <label>早退</label><input type="radio" name="status${studentId}" value="2" />
                        <label>旷课</label><input type="radio" name="status${studentId}" value="3" />
                        <label>请假</label><input type="radio" name="status${studentId}" value="4" />
                   </div>
					</td>
				
				</tr>
				</s:iterator>
    </table>
  </div>
  <div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> </div>
</form>
	<form method="post" action="attendance_add.action" id="form">
	  <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="pagelist"  style="float:right;">
        <input type="hidden" name="table_data" value="" id="hidTD">
          <button class="button bg-main icon-check-square-o" id="btnSubmit" type="submit"> 提交</button>
        </div>
        </div>
	
	</form>
	
</body>
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
					let state = $("input[name= status" + $(tds[2]).html() + "]:checked").val();
					result.push({
						"学号" : $(tds[2]).html(),
						"考勤状态" : state,
						"课程id" : $(tds[1]).html()
					});
				}
			}
			return (result);
		}
	</script>
</html>
