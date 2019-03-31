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
            {
                field: '----',
                title: '操作',
                width: 150,
                formatter: function (value, row, index) {
                    return '<a href="javascript:void(0)" onclick="goTodoScoreJudgePage(' + row.id + ',' + row.isbegin + ')">为该项目的投标供应商进行分值判断</a>';
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
                field: 'isBegin', title: '是否第一轮招标', width: 100, formatter: function (value, row, index) {
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
                width: 150,
                formatter: function (value, row, index) {
                    return '<a href="javascript:void(0)" onclick="doScoreJudge(' + row.project.id + ',' + row.supplier.id + ',' + row.isBegin + ')">计算评标总得分</a>';
                }
            }
        ]]
    </script>
    <script type="text/javascript">
        function goTodoScoreJudgePage(id,isbegin) {
            $.messager.confirm('警告', '是否打开供应商分值判断窗口?', function (yes) {
                if (yes) {
                    $('#doScoreJudgeDlg').dialog('open');
                    $('#grid_score_judge').datagrid({
                        url: '/bidding/selectSupplierByPid/' + id + '/'+isbegin+'.do',
                        columns: _columns,
                        singleSelect: true,
                        pagination: true
                    })
                }
            });
        }

        function doScoreJudge(pid, sid) {
            $.ajax({
                url: '/bidding/getBiddingByPidAndSid/' + pid + '/' + sid + '.do',
                type: 'get',
                success: function (info) {
                    if (eval('(' + info + ')').retMessage.totalscore !== null&&eval('(' + info + ')').retMessage.totalscore !== '') {
                        $.messager.confirm('警告', '该供应商竞标总分已被计算,是否重新计算?', function (yes) {
                            if (yes) {
                                dojudge(pid,sid);
                            }
                        });
                    } else {
                        $.messager.confirm('警告', '是否计算供应商竞标总分?', function (yes) {
                            if (yes) {
                                dojudge(pid,sid);
                            }
                        });
                    }
                }
            });
        }

        function dojudge(pid,sid,isbegin) {
            $.ajax({
                url: '/bidding/doScoreAVGByPidAndSid/' + pid + '/' + sid +'.do',
                type: 'get',
                success: function (info) {
                    $.messager.alert('提示', eval('(' + info + ')').retMessage, 'info', function () {
                        $('#grid_score_judge').datagrid('reload');
                    });
                }
            });
        }
    </script>
    <script type="text/javascript">
        $(function () {
            $('#doScoreJudgeDlg').dialog({
                title: "供应商评分判断",
                width: 600,
                height: 400,
                closed: true,
                modal: true
            });
        });
    </script>
</head>
<body>
<table id="grid_select_project_is_bidding"></table>
<div id='doScoreJudgeDlg'>
    <table id="grid_score_judge"></table>
</div>
</body>
</html>