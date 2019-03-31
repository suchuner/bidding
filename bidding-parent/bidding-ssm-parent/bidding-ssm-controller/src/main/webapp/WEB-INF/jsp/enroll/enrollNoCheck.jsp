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
                width: 150,
                formatter: function (value, row, index) {
                    return '<a href="javascript:void(0)" onclick="checkEnroll(' + row.id + ')">去审核供应商报名</a>';
                }
            }
        ]]
        var _columns = [[
            {field: 'id', title: '编号', width: 100},
            {field: 'companyname', title: '供应商', width: 100,formatter:function (value,row,index) {
                    return row.supplier.companyname;
                }},
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
            },
            {
                field: '----',
                title: '操作',
                width: 150,
                formatter: function (value, row, index) {
                    var rtn = '<a href="javascript:void(0)" onclick="pass_yes_no(' + row.pjtId +',' + row.supId +',0)">审核通过</a>';
                    rtn += '   <a href="javascript:void(0)" onclick="pass_yes_no(' + row.pjtId + ',' + row.supId +',1)">审核不通过</a>';
                    return rtn;
                }
            }
        ]]
    </script>
    <script type="text/javascript">
        $(function (){$('#enrollDlg').dialog({
            title: "审核供应商报名",
            width: 1000,
            height: 400,
            closed: true,
            modal: true
        });});
        $(function (){$('#messageDlg').dialog({
            title: "添加供应商项目报名审核不通过的原因",
            width: 600,
            height: 400,
            closed: true,
            modal: true,
            buttons:[{
                text:"确定",
                iconCls:'icon-save',
                handler: submitMessage
            }]
        });});
    </script>
    <script type="text/javascript">
        function checkEnroll(id){
            $.messager.confirm('警告','确认要该项目的所有供应商报名信息吗?',function(yes){
                if(yes){
                    $('#enrollDlg').dialog('open');
                    $('#grid_check_enrolls').datagrid({
                        url:'/enroll/selectProjectToCheckByPid/'+id+'.do',
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
                    var url;
                    if (0 === code * 1) {
                        $.ajax({
                            url:  "/enroll/doCheckProjectEnrollByPidAndSidToSuccess.do?pid="+pid+"&sid="+sid,
                            type: 'get',
                            success: function (info) {
                                $.messager.alert("提示", eval('(' + info + ')').retMessage, "info", function () {
                                    $('#grid_check_enrolls').datagrid('reload');
                                });
                            }
                        });
                    }
                    if (1 === code * 1) {
                        $('#messageDlg').dialog('open');
                        $('#pid').val(pid);
                        $('#sid').val(sid);
                    }

                }
            })
        }
        function submitMessage(){
            $.messager.confirm("警告","确认提交审核不通过请求吗?",function(yes) {
                if(yes){
                    var messInfo= $('[name="message"]').val();
                    if(messInfo===""){
                        $.messager.alert('提示','审核不通过原因不能为空!','info');
                        return;
                    }
                    $.ajax({
                        url: "/enroll/doCheckProjectEnrollByPidAndSidToFailure.do?pid="+$('#pid').val()+"&sid="+$('#sid').val()+"&message="+messInfo,
                        type: 'post',
                        success: function (info) {
                            $.messager.alert("提示", eval('(' + info + ')').retMessage, "info", function () {
                                $('#messageDlg').dialog('close');
                                $('#grid_check_enrolls').datagrid('reload');
                            });
                        }
                    });}
            });}
    </script>
</head>
<body>
<table id="grid_select_project_is_tendering"></table>
<div id='enrollDlg'>
    <table id="grid_check_enrolls"></table>
</div>
<div id='messageDlg'>
    <input type="hidden" id="pid">
    <input type="hidden" id="sid">
    <em style="color: red;">*</em>  审核不通过原因:
    <textarea class="easyui-validatebox" name="message" id="notice"
              data-options="required:true"
              style="width: 560px;height: 260px"></textarea>
</div>
</body>
</html>