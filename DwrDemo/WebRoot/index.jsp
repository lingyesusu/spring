<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="Content-Type" charset="UTF-8" content="text/html">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/DwrDemo/dwr/engine.js"></script>
	<script type="text/javascript" src="/DwrDemo/dwr/util.js"></script>
	<script type='text/javascript' src='/DwrDemo/dwr/interface/SendPushService.js'></script>
	<script type="text/javascript">
	$(document).ready(function(){
	    // 页面加载的时候进行反转的激活
	    dwr.engine.setActiveReverseAjax(true) ;
		$("#button").click(function(){
			// 此类即为根据java文件生成的js文件
	        var data = document.getElementById("data").value;
	        SendPushService.send(data);
		});
	});
		
	function dwrtest(data){
		$("#ul").html($("#ul").html()+"<br />"+data);
	}
	</script>
  </head>
  
  <body>
  <ul id="ul">

</ul>

<br/>
<hr>
	<input type="text" id="data" name='data' />&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="button" name="button" value="测试" id="button">
  </body>
</html>
