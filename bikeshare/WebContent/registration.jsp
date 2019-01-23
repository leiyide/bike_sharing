<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>欢迎您的注册</title>
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
	$(function(){
	
	});
	function validate(){
		var selected=$('input[name="clause"]:checked').val();
		var password=$('#Password').val();
		var IdCard=$('#IdCard').val();
		var phoneNum=$('#Phone').val();
		var repeatpwd=$('#ResPassword').val();
		/* 定义控制标签 */
		var flag='on'; 
		 $.ajax({
			url: "<%=request.getContextPath()%>/checkIdCard.do",
			type:"POST",
			/* 此处注意:需要将ajax默认的异步提交改为同步!否则不能正常阻止表单提交！ */
			async: false,
			data:{"IdCard":IdCard},
			success:function(data){
				if(data.checkIdCard!=null){
					flag='off';
				}
			},
			error:function(){
				flag='off';
			},
				dataType:"json"
			}); 
		// 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X  
		var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;  
		//不少于6位 必须有数字和字母 不超过6位,此处的/w相当于[A-Za-z0-9_]
		var pwd=/^[\w]{6,6}$/;
		//限定手机号位数以及号码组成
		var mobile=/^[1][3,4,5,7,8][0-9]{9}$/;
		if(reg.test(IdCard)===false){
			layer.alert('身份证输入错误！请重新进行输入！');
			return false;
		}else if(pwd.test(password)===false){
			layer.alert('密码由数字和字母组成！密码长度为六位');
			return false;
		}else if(mobile.test(phoneNum)===false){
			layer.alert('您输入的号码有误！请重新输入！');
			return false;
		}else if(password!=repeatpwd){   
			layer.alert('密码输入不一致！请重新输入！');
			return false;
		}else if(selected==undefined){
			layer.alert('是否同意服务和隐私政策的条款！');
			return false;
		}else if(flag=='off'){
			flag=1;
			layer.alert('该身份证已注册！请重新注册！');
			return false;
		}else{
			return true;
		}
	}	
</script>
</head>
<body>
	<div class="reg-w3">
		<div class="w3layouts-main">
			<h2>立即注册</h2>
			<form action="<%=request.getContextPath()%>/regist.do" method="post">
				<input type="text" class="ggg" name="Name" placeholder="姓名"   required="">
				<input type="email" class="ggg" name="Email" placeholder="邮箱"  required=""> 
				<input type="text" class="ggg" name="Phone" id="Phone" placeholder="手机号码" required=""> 
				<input type="text" class="ggg" name="IdCard" id="IdCard" placeholder="身份证号码" required=""> 
				<input type="password" class="ggg" name="Password" id="Password" placeholder="密码" required="">
				<input type="password" class="ggg" name="ResPassword" id="ResPassword" placeholder="确认密码" required="">
				<h4>
				<input type="checkbox" name="clause" id="clause" value="1" />
				<a href="clause.html">我同意服务和隐私政策的条款</a>
				</h4>
				<div class="clearfix"></div>
				<input type="submit" value="提交" name="register" onclick="return validate();">
		</form>
			<p>
				完成注册<a href="login.jsp">开启登录</a>
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