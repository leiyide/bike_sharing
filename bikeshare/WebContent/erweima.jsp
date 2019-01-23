<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title> 
<script src="js/jquery2.0.3.min.js"></script>
<script type="text/javascript" src="js/jquery.qrcode.min.js"></script>
<script type="text/javascript">
  	$(function(){
  	//生成100*100(宽度100，高度100)的二维码
  	})
  	function test() {
  	  	alert("123");
 		var a= $('#qrcode').qrcode({
  		    render: "canvas", //也可以替换为table
  		    width: 50,
  		    height: 50,
  		    text: "哈哈"
		});
		alert(a);
  	}
</script>
</head>
<body>

	<button id="qrcode" onclick="test()">htmlOnClick</button>

</body>
</html>