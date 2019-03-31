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
            {
                field: 'projectnum', title: '项目编号', width: 100, formatter: function (value, row) {
                    return row.project.projectnum;
                }
            },
            {
                field: 'itemname', title: '项目名称', width: 100, formatter: function (value, row) {
                    return row.project.itemname;
                }
            },
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
                field: 'isenroll', title: '报名是否已审核', width: 150, formatter: function (value, row, index) {
                    if (0 === value * 1) {
                        return '是';
                    }
                    if (1 === value * 1) {
                        return '否';
                    }
                }
            },
            {
                field: '----',
                title: '操作',
                width: 150,
                formatter: function (value, row, index) {
                    return '<a href="javascript:void(0)" onclick="submitMargin(' + row.pjtId + ',' + row.supId + ')">提交保证金证明</a>';
                }
            }
        ]]
    </script>
    <script type="text/javascript">
        $(function () {
            $('#marginDlg').dialog({
                title: "添加供应商保证金证明文件",
                width: 300,
                height: 160,
                closed: true,
                modal: true,
                buttons: [{
                    text: "确定",
                    iconCls: 'icon-save',
                    handler: submitMessage
                }]
            });
        });
    </script>
    <script type="text/javascript">
        function submitMargin(pid, sid) {
            $('#pid').val(null);
            $('#sid').val(null);
            $('#marginDoc_').val(null);
            $.post("/bidding/getBiddingByPidAndSid/" + pid + "/" + sid + ".do", function (info) {
                var temp = eval('(' + info + ')').retMessage;
                if (temp != null && temp.ismargin * 1 === 1) {
                    $.messager.confirm('提示', "该项目的保证金文件已上传!是否更新?", function (yes) {
                        if (yes) {
                            $('#pid').val(pid);
                            $('#sid').val(sid);
                            $('#marginDlg').dialog('open');
                        }
                    });
                } else if (temp != null && temp.ismargin * 1 === 0) {
                    $.messager.alert('警告', '保证金文件已被审核通过,无需重新上传文件!', 'info');
                } else {
                    $('#pid').val(pid);
                    $('#sid').val(sid);
                    $('#marginDlg').dialog('open');
                }
            });
        }

        function submitMessage() {
            $.messager.confirm("警告", "确认提交保证金证明文件吗?", function (yes) {
                if (yes) {
                    if ($('#marginDoc_').val() === '') {
                        $.messager.alert('提示', '保证金证明文件未上传!', 'info');
                        return;
                    }
                    $('#marginForm').ajaxSubmit(function (info) {
                        $.messager.alert('提示', eval('(' + info + ')').retMessage, 'info', function () {
                            if (eval('(' + info + ')').flag) {
                                $('#grid_check_in_enrolls').datagrid('reload');
                            }
                            $('#marginDlg').dialog('close');
                        });
                    });
                }
            });
        }
    </script>
</head>
<body>
<table id="grid_check_in_enrolls"></table>
<div id='marginDlg'>
    <form id="marginForm" enctype="multipart/form-data" method="post" action="/bidding/doSupplierMarginSubmit.do">
        <input type="hidden" id="pid" name="pid">
        <input type="hidden" id="sid" name="sid">
        <em style="color: red;font-size: 16px">*保证金已交证明文件:</em><br>
        <input type="file" name="marginDoc_" id="marginDoc_"
               style="float: right; vertical-align:top;"/><br>
    </form>
</div>
</body>
</html>