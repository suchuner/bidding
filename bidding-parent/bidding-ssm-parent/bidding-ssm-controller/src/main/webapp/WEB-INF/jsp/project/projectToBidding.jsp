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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jquery/jquery.datepick.css" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.form.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.datepick.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.datepick-zh-CN.js"></script>
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
            {field: 'id', title: '编号', width: 30},
            {field: 'projectnum', title: '项目编号', width: 200},
            {field: 'itemname', title: '项目名称', width: 150},
            {field: 'introduction', title: '项目简介', width: 200},
            {field: 'starter', title: '项目申请人', width: 100},
            {
                field: 'startdate', title: '项目申请日期', width: 100, formatter: function (value) {
                    return new Date(value).Format("yyyy-MM-dd");
                }
            },
            {
                field: 'isbegin', title: '是否第一轮招标', width: 100, formatter: function (value, row, index) {
                    if (0 === value * 1) {
                        return '否';
                    }
                    if (1 === value * 1) {
                        return '是';
                    }
                }
            },

            {
                field: 'status', title: '项目状态', width: 100, formatter: function (value, row, index) {
                    if (0 === value * 1) {
                        return '项目未审核';
                    }
                    if (1 === value * 1) {
                        return '项目已审核但未通过';
                    }
                    if (2 === value * 1) {
                        return '项目已审核且已通过';
                    }
                    if (3 === value * 1) {
                        return '项目招标中';
                    }
                    if (4 === value * 1) {
                        return '项目竞标中';
                    }
                    if (5 === value * 1) {
                        return '项目招标成功';
                    }
                    if (6 === value * 1) {
                        return '项目流标';
                    }
                }
            },
            {field: 'notice', title: '招标公告', width: 100},
            {
                field: '----',
                title: '操作',
                width: 200,
                formatter: function (value, row, index) {
                    return '<a href="javascript:void(0)" onclick="judgeNums(' + row.id +')">判断供应商数量是否符合规定</a>';

                }
            }
        ]]
    </script>
    <script type="text/javascript">
        function judgeNums(id){
                $.ajax({
                    url:'/project/doJudgeIsRebiddingOrContinue/'+id+'.do',
                    type:'get',
                    success:function(info){
                        $.messager.alert('提示',eval('('+info+')').retMessage,'info',function(){
                            $('#grid_select_project_is_tendering').datagrid('reload');
                        });
                    }
                });
        }
    </script>
</head>
<body>
<table id="grid_select_project_is_tendering"></table>
</body>
</html>
