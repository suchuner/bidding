<%@page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>project</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/bidding-js/jquery-easyui-1.3.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/bidding-js/jquery-easyui-1.3.5/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.form.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/bidding-js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/bidding-js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/bidding-js/jquery-easyui-1.3.5/jquery.serializejson.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bidding-js/date.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bidding-js/list.js"></script>
    <script type="text/javascript">
        var columns = [[
            {field: 'id', title: '编号', width: 100},
            {field: 'pjtId', title: '项目id', width: 100},
            {
                field: 'enrolldate', title: '报名时间', width: 100, formatter: function (value) {
                    return new Date(value).Format("yyyy-MM-dd");
                }
            },
            {
                field: 'isnormal', title: '供应商报名状态', width: 150, formatter: function (value, row, index) {
                    if (0 === value * 1) {
                        return '正常';
                    }
                    if (1 === value * 1) {
                        return '未通过报名审核';
                    }
                    if (2 === value * 1) {
                        return '第一次报名';
                    }
                }
            },
            {
                field: '-', title: '无重大违法证明文件', width: 100, formatter: function (value, row, index) {
                    return '<a href="/download/download/' + row.id + '/0.do">无重大违法证明文件下载</a>';
                }
            },
            {
                field: '--', title: '纳税证明文件', width: 100, formatter: function (value, row, index) {
                    return '<a href="/download/download/' + row.id + '/1.do">纳税证明文件下载</a>';
                }
            },
            {
                field: '---', title: '给员工缴纳社保证明文件', width: 100, formatter: function (value, row, index) {
                    return '<a href="/download/download/' + row.id + '/2.do">社保证明文件下载</a>';
                }
            }
        ]]
    </script>
</head>
<body>
<table id="grid_check_out_enrolls"></table>
</body>
</html>