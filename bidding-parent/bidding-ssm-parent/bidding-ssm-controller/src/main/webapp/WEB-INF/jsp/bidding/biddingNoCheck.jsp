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
            {field: 'projectnum', title: '项目编号', width: 200},
            {field: 'itemname', title: '项目名称', width: 150},
            {field: 'introduction', title: '项目简介', width: 200},
            {
                field: 'status', title: '项目状态', width: 150, formatter: function (value, row, index) {
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
                field: '----',
                title: '操作',
                width: 220,
                formatter: function (value, row, index) {
                    return '<a href="javascript:void(0)" onclick="checkMargin(' + row.id + ')">去审核供应商是否提交保证金证明文件</a>';
                }
            }
        ]];
        var _columns = [[
            {field: 'projectnum', title: '项目编号', width: 260, formatter: function (value, row, index) {
                    return row.project.projectnum;
                }},
            {field: 'itemname', title: '项目名称', width: 200, formatter: function (value, row, index) {
                    return row.project.itemname;
                }},
            {field: 'shortname', title: '供应商', width: 160, formatter: function (value, row, index) {
                    return row.supplier.shortname;
                }},
            {
                field: '-', title: '保证金缴纳证明文件', width: 100, formatter: function (value, row, index) {
                    return '<a href="/download/downloadFiles/' + row.id + '/0.do">保证金缴纳证明文件下载</a>';
                }
            },
            {
                field: '----',
                title: '操作',
                width: 150,
                formatter: function (value, row, index) {
                    var rtn = '<a href="javascript:void(0)" onclick="pass_yes_no(' + row.project.id +',' + row.supplier.id +',0)">审核通过</a>';
                    rtn += '   <a href="javascript:void(0)" onclick="pass_yes_no(' + row.project.id + ',' + row.supplier.id +',1)">审核不通过</a>';
                    return rtn;
                }
            }
        ]]
    </script>
    <script type="text/javascript">
        $(function (){$('#marginDlg').dialog({
            title: "审核供应商保证金文件",
            width: 1000,
            height: 400,
            closed: true,
            modal: true
        });});
    </script>
    <script type="text/javascript">
        function checkMargin(id){
            $.messager.confirm('警告','确认要查询该项目的供应商保证金提交信息吗?',function(yes){
                if(yes){
                    $('#marginDlg').dialog('open');
                    $('#grid_check_margin').datagrid({
                        url:'/bidding/selectSupplierMarginsToCheckByPid/'+id+'.do',
                        columns:_columns,
                        singleSelect : true,
                        pagination : true
                    });
                }
            })
        }
        function pass_yes_no(pid,sid, code) {
            $.messager.confirm("警告", "确认审核吗?", function (yes) {
                if (yes) {
                        $.ajax({
                            url:  "/bidding/doCheckSupplierMarginByPidAndSid/"+pid+"/"+sid+"/"+code+".do",
                            type: 'get',
                            success: function (info) {
                                $.messager.alert("提示", eval('(' + info + ')').retMessage, "info", function () {
                                    $('#grid_check_margin').datagrid('reload');
                                });
                            }
                        });
                }
            })
        }
    </script>
</head>
<body>
<table id="grid_select_project_is_tendering"></table>
<div id='marginDlg'>
    <table id="grid_check_margin"></table>
</div>
</body>
</html>