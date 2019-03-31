<%@page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/normalize.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" type="text/css">
	<script src="${pageContext.request.contextPath}/bidding-js/demo-1.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.form.js"></script>
	<link rel="stylesheet" type="text/css"
		  href="${pageContext.request.contextPath}/bidding-js/jquery-easyui-1.3.5/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css"
		  href="${pageContext.request.contextPath}/bidding-js/jquery-easyui-1.3.5/themes/icon.css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/bidding-js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript"
			src="${pageContext.request.contextPath}/bidding-js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
	<script type="text/javascript">
        function doLogin(){
            if ($('#username').val().trim() === '') {
                $.messager.alert("提示","用户名未填写!","info");
            }
            else if ($('#password').val().trim()=== '') {
                $.messager.alert("提示","密码不能为空!","info");
            }
            else {
                $("#msgForm").ajaxSubmit(function(info){
                    $.messager.alert("提示",eval("("+info+")").retMessage,"info",function(){
                        if(eval("("+info+")").flag){
                            window.location.href="/_index.jsp";
						}
					});
                });
            }
        }
	</script>
<title>系统用户登录</title>
</head>
<body class="logobg_style">
	<div id="large-header" class="large-header login-page">
		<canvas id="demo-canvas" width="1590" height="711"></canvas>
		<div class="login-form">
			<div class="login-content">
				<h1 class="title_name">系统账户登录</h1>
				<form action="/user_login.action" method="post" role="form" id="msgForm"
					class="login_padding">
					<div class="form-group clearfix">
						<div class="input-group">
							<div class="input-group-addon">
								<i class="icon_user"></i>
							</div>
							<input type="text" class="form-control" name="username"
								id="username" placeholder="账号" autocomplete="off">
						</div>
					</div>
					<div class="form-group clearfix">
						<div class="input-group">
							<div class="input-group-addon">
								<i class="icon_password"></i>
							</div>
							<input type="password" class="form-control" name="password"
								id="password" placeholder="密码" autocomplete="off">
						</div>
					</div>
					<div class=" textright">
						<a href="" class="forget">忘记密码？</a>
					</div>
					<div class="tishi"></div>
					<div class="form-group">
						<a  type="submit" id="submit"
							class="btn btn-danger btn-block btn-login" onClick="doLogin()">
							<i class="fa fa-sign-in"></i> 登录
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
