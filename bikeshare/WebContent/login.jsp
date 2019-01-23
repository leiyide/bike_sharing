<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>欢迎进入登录页面</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Visitors Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<!-- bootstrap-css -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- //bootstrap-css -->
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/style-responsive.css" rel="stylesheet" />
<!-- font CSS -->
<link
	href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
<!-- font-awesome icons -->
<link rel="stylesheet" href="css/font.css" type="text/css" />
<link href="css/font-awesome.css" rel="stylesheet">
<!-- //font-awesome icons -->
<script src="js/jquery2.0.3.min.js"></script>
<script src="<%=request.getContextPath()%>/layer/layer.js"></script>
<script type="text/javascript">
	/* jQuery入口函数 */
	$(function() {
		/* var viewHref=document.getElementById("regist");
		viewHref.setAttribute( "href",viewHref.rel); */
	});
	/* 进行登录类型的校验 */
	function checkButton() {
		/* 获得单选按钮选中的值 */
		var user = $('input[name="radioUser"]:checked').val();
		var admin = $('input[name="radioAdmin"]:checked').val();
		if (user == undefined && admin == undefined) {
			layer.alert('请选择登录的类型');
			return false;
		}else {
				return true;
			}
	}
</script>

</head>
<body>
	<div class="log-w3">
		<div class="w3layouts-main">
			<h2>欢迎使用共享单车</h2>
			<br>
			<form action="<%=request.getContextPath()%>/login.do" method="post"
				id="form">
				<input type="radio" name="radioUser" id="radioUser" value="1">用户登录
				<script type="text/javascript">
					document.getElementById('radioUser').onclick = function doDisabled(
							checked) {
						if ($("#radioUser[checked]")) {
							$("#radioAdmin").attr("checked", false);
						}
						var user = $('input[name="radioUser"]:checked').val();
						var viewHref=document.getElementById("regist");
						if(user!=undefined){
							viewHref.removeAttribute( "href");
							viewHref.setAttribute( "href",viewHref.rel);
						}
					}
				</script>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
					name="radioAdmin" id="radioAdmin" value="2">管理员登录
				<script type="text/javascript">
					document.getElementById('radioAdmin').onclick = function doDisabled(
							checked) {
						if ($("#radioAdmin[checked]")) {
							$("#radioUser").attr("checked", false);
						}
						var admin = $('input[name="radioAdmin"]:checked').val();
						var viewHref=document.getElementById("regist");
						if(admin!=undefined){
							viewHref.setAttribute("rel",viewHref.href);
							viewHref.removeAttribute( "href");
						}else{
							viewHref.setAttribute( "href",viewHref.rel);
						}
					}
				</script>
				<input type="email" class="ggg" name="UserName" placeholder="邮箱"
					id="UserName" required=""> <input type="password"
					class="ggg" name="UserPassword" placeholder="密码" id="UserPassword"
					required="UserPassword"> <span><input
					type="checkbox" id="remember" />记住密码</span>
				<h6>
					<a href="findpassword.jsp">忘记密码?</a>
				</h6>
				<div class="clearfix"></div>
				<input type="submit" value="登录" name="login"
					onclick="return checkButton()">;
			</form>
			<script type="text/javascript">
				window.onload = function() {
					var oForm = document.getElementById('form');
					var oUser = document.getElementById('UserName');
					var oPswd = document.getElementById('UserPassword');
					var oRemember = document.getElementById('remember');	
					//页面初始化时，如果帐号密码cookie存在则填充
					if (getCookie('UserName')!=null &&getCookie('UserPassword')!=null) {
						oUser.value = getCookie('UserName');
						oPswd.value = getCookie('UserPassword');
						oRemember.checked = true;
					}
					//复选框勾选状态发生改变时，如果未勾选则清除cookie
					oRemember.onchange = function() {
						if (!this.checked) {
							delCookie('UserName');
							delCookie('UserPassword');
						}
					};
					//表单提交事件触发时，如果复选框是勾选状态则保存cookie
					oForm.onsubmit = function() {
						if (remember.checked) {
							setCookie('UserName', oUser.value, 7); //保存帐号到cookie，有效期7天
							setCookie('UserPassword', oPswd.value, 7); //保存密码到cookie，有效期7天
						}
					};
				};
				//设置cookie
				 function setCookie(name, value, day) {
					var date = new Date();
					date.setDate(date.getDate() + day);
					document.cookie = name + '=' + value + ';expires=' + date;
				}; 
				//获取cookie
				 function getCookie(name) {
					var reg = RegExp(name + '=([^;]+)');
					var arr = document.cookie.match(reg);
					if (arr) {
						return arr[1];
					} else {
						return null;
					}
				};
				/* 此方法与上面的方法实现功能的效果一样 */
				/*  function getCookie(name) {
					var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
					if (arr = document.cookie.match(reg))
						return unescape(arr[2]);
					else
						return null;
				}; */
				//删除cookie
				function delCookie(name) {
					setCookie(name, null, -1);
				};
			</script>
			<p>
				优质服务！期待你的体验！<a href="registration.jsp" id="regist">注册新用户</a>
			</p>
		</div>
	</div>
	<script src="js/bootstrap.js"></script>
	<script src="js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="js/scripts.js"></script>
	<script src="js/jquery.slimscroll.js"></script>
	<script src="js/jquery.nicescroll.js"></script>
	<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
	<script src="js/jquery.scrollTo.js"></script>
</body>
</html>