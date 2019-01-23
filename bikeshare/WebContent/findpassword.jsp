<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>找回密码</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Visitors Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap-css -->
<link rel="stylesheet" href="css/bootstrap.min.css" >
<!-- //bootstrap-css -->
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/style-responsive.css" rel="stylesheet"/>
<!-- font CSS -->
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<!-- font-awesome icons -->
<link rel="stylesheet" href="css/font.css" type="text/css"/>
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons -->
<script src="js/jquery2.0.3.min.js"></script>
<script src="<%=request.getContextPath()%>/layer/layer.js"></script>
<script type="text/javascript">
	/* jQuery入口函数 */
	$(function() {

	});
	/* 进行登录类型的校验 */
	function checkButton() {
		/* 获得单选按钮选中的值 */
		var user = $('input[name="radioUser"]:checked').val();
		var admin = $('input[name="radioAdmin"]:checked').val();
		if (user == undefined && admin == undefined) {
			layer.alert('请选择找回类型！');
			return false;
		}else {
				return true;
			}
	}
</script>
</head>
<body>
<div class="reg-w3">
<div class="w3layouts-main">
	<h2>立即找回</h2>
		<form action="<%=request.getContextPath() %>/findPassword.do" method="post">
		<input type="radio" name="radioUser" id="radioUser" value="1">用户类型
				<script type="text/javascript">
					document.getElementById('radioUser').onclick = function doDisabled(
							checked) {
						if ($("#radioUser[checked]")) {
							$("#radioAdmin").attr("checked", false);
						}
					}
				</script>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
					name="radioAdmin" id="radioAdmin" value="2">管理员类型
				<script type="text/javascript">
					document.getElementById('radioAdmin').onclick = function doDisabled(
							checked) {
						if ($("#radioAdmin[checked]")) {
							$("#radioUser").attr("checked", false);
						}
					}
				</script>
			<input type="text" class="ggg" name="Name" placeholder="姓名" required="">
			<input type="email" class="ggg" name="Email" placeholder="邮箱" required="">
			<input type="text" class="ggg" name="Phone" placeholder="手机号码" required="">
			<input type="text" class="ggg" name="IdCard" placeholder="身份证号码" required="">
			<h4>密码将以邮件的方式发送至你发邮箱！请注意查收！</h4>
				<div class="clearfix"></div>
				<input type="submit" value="提交" name="register" onclick="return checkButton()">
		</form>
		<p>找回成功<a href="login.jsp">开启登录</a></p>
</div>
</div>
<script src="<%=request.getContextPath() %>/js/bootstrap.js"></script>
<script src="js/jquery.dcjqaccordion.2.7.js"></script>
<script src="js/scripts.js"></script>
<script src="js/jquery.slimscroll.js"></script>
<script src="js/jquery.nicescroll.js"></script>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
<script src="js/jquery.scrollTo.js"></script>
</body>
</html>