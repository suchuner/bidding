<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script>
        function importUserToPage(){
           window.location.href="http://localhost:8090/user_importUserPage.action";
        }
        function importExpertToPage(){
            window.location.href="http://localhost:8090/expert_importExpertPage.action";
        }
    </script>
</head>
<body>
<h2>Hello World!</h2>
<button style="width:230px;height: 20px"  onclick="importUserToPage()" >用户信息添加页面跳转</button>
<button  style="width:230px;height: 20px"  onclick="importExpertToPage()" >专家信息添加页面跳转</button>
</body>
</html>
