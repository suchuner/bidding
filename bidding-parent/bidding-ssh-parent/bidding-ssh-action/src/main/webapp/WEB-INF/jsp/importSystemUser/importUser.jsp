<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018-12-21
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>用户信息的导入</title>
</head>
<body>
<s:form action="user_doImportUserByExcel.action" enctype="multipart/form-data" theme="simple" method="POST">
<s:file name="userInfo" ></s:file>
    <s:submit value="提交"></s:submit>
</s:form>
</body>
</html>
