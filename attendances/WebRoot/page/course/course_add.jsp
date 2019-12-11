<%@page import="java.sql.ResultSet"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/base/base.jsp"%>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
<script>
	
	function checkid() 
	{
	var courseId = document.getElementById("courseId").value;
   $.ajax({
       type: "POST",      //请求方式
        url: "course_check.action",//验证的路径    
         data: "courseId="+courseId,   //参数
        success: function(data){  //返回值
       if(data=="true"){
           $('#nameLabe').text("通过验证").css("color","green").css("font-size","10px");
       }else{//不存在就显示labe，并用css样式修饰一下
           $('#nameLabe').text("已存在").css("color","red").css("font-size","10px");
           }   
       }            
  });
	} 
</script>
</head>

<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>发布活动</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="course_add.action">  
         <div class="form-group">
	        <div class="label">
	          <label>课程编号</label>
	        </div>
	        <div class="field">
	          <input type="text" class="input w50"  value="" id="courseId" data-validate="required:数据必填项" onblur="checkid()" />
	          <label id="nameLabe"></label>
	          <div class="tips"></div>
	        </div>
       </div>
      
       <div class="form-group">
	        <div class="label">
	          <label>课程名称：</label>
	        </div>
	        <div class="field">
	          <input type="text" class="input w50"  value="" name="courseName" data-validate="required:数据必填项" />
	          <div class="tips"></div>
	        </div>
       </div>
      

      
       <div class="form-group">
	        <div class="label">
	          <label>教室</label>
	        </div>
	        <div class="field">
 <input type="text" class="input w50"  value="" name="room" />
	          <div class="tips"></div>
	        </div>
      </div>
      
      
       <div class="form-group">
	        <div class="label">
	          <label>上课时间</label>
	        </div>
	        <div class="field">	       
              <input type="text" class="input w50"  value="" name="courseTime" >
            </div>
      </div>
      
      <div class="form-group">
	        <div class="label">
	          <label>人数</label>
	        </div>
	        <div class="field">	       
              <input type="text" class="input w50"  value="" name="num" >
            </div>
      </div>
      
      
      <div class="form-group">
	        <div class="label">
	          <label>学分</label>
	        </div>
	        <div class="field">	       
              <input type="text" class="input w50"  value="" name="credit" >
            </div>
      </div>
      
      
      
      <div class="form-group">
	        <div class="label">
	          <label>学时</label>
	        </div>
	        <div class="field">	       
             <input type="text" class="input w50"  value="" name="period" >
            </div>
      </div>
      



        <div class="field" >
          <button class="button bg-main icon-check-square-o" type="submit"> 添加-</button>
        </div>
      </div>
  
          </div>
          </form>
      </div>
    
  </div>
  
</div>


</body>
</html>
