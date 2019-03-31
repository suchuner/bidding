<%@page language="java" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>供应商登录</title>
    <link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/global.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/tpl.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/icon.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/user.css" rel="stylesheet" type="text/css">
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
        function doLogin() {
            if ($('#companyemail').val().trim() === '') {
                $.messager.alert("提示","用户名未填写!","info");
            }
            else if ($('#password').val().trim()=== '') {
                $.messager.alert("提示","密码不能为空!","info");
            }
            else {
                $("#msgForm").ajaxSubmit(function(info){
                    $.messager.alert("提示",eval("("+info+")").retMessage,"info",function(){
                        if(eval("("+info+")").flag){
                            window.location.href="/supplier_toMyInfoPage.action";
                        }
                    });
                });
            }
        }
    </script>
</head>
<body>
<div id="wrapper">
    <div id="top"></div>
    <div id="header" class="fn-clear sl-hvalign-cnt">
        <div class="sl-valign-cnt-inner">
            <div id="logo" class="fn-left">
                <a href="javascript:void(0);"></a>
            </div>
            <div class="fn-right" id="headernav">
                <div class="headernav-item">
                    <a href="/website/login.jsp" class="headernav-item-btn"><span
                            class="icon-16 icon-16-login"></span>登录</a>
                    <a href="/website/reg.jsp" class="headernav-item-btn"><span
                            class="icon-16 icon-16-register"></span>注册</a>
                </div>
            </div>
        </div>
    </div>
    <div id="content" class="main-content fn-clear">
        <div class="wp cl mt50">
            <div class="r" style="margin-top:30px;">
                <div class="bg_f2 lgform_wrap xs2">
                    <h3 class="xs3 pt20 pl20">供应商登录</h3>
                    <div class="lgform">
                        <form action="/supplier_login.action" method="post" id="msgForm"
                              name="msgForm" style="height:100%" autocomplete="off">
                            <p class="mt30">
                                <input type="text" class="lgform_input uname" maxlength="20"
                                       name="supplier.companyemail" id="companyemail" placeholder="账户名">
                            </p>
                            <p class="mt30">
                                <input type="password" class="lgform_input pwd" name="supplier.password" id="password"
                                       placeholder="密码">
                            </p>
                            <p class="mt20">
                                <a class="btn-red-left block"><span class="btn-red-right">
											<input type="button" class="btn-red-center" value="登　录" name="login_submit"
                                                   onClick="doLogin();"></span></a>
                            </p>
                            <div class="mt20 ac">
                                <a href=""
                                   class="c_blue password-retake1">忘记登录密码？</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="l pt30"></div>
        </div>
    </div>
    <div id="footer">
        <div class="foot fn-clear">
            <div class="foot-logo fn-left">
                <a href="javascript:void(0);"></a>
            </div>
        </div>
    </div>
</div>
</body>
</html>