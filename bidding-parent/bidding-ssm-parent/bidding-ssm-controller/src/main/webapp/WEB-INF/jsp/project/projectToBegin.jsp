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
            {field: 'checker', title: '项目审核人', width: 100},
            {
                field: 'checkerdate', title: '项目审核日期', width: 100, formatter: function (value) {
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
            {
                field: '-', title: '招标书下载', width: 100, formatter: function (value, row, index) {
                    return '<a href="/download/downloadFile/' + row.id + '/0.do">招标书下载</a>';
                }
            },
            {
                field: '--', title: '采购清单与技术要求文件下载', width: 180, formatter: function (value, row, index) {
                    return '<a href="/download/downloadFile/' + row.id + '/1.do">采购清单与技术要求文件下载</a>';
                }
            },
            {field: 'notice', title: '招标公告', width: 100},
            {
                field: '----',
                title: '操作',
                width: 150,
                formatter: function (value, row, index) {
                    var rtn = '<a href="javascript:void(0)" onclick="addNotice(' + row.id +',\''+row.notice+'\')">添加招标公告</a>';
                    rtn += '   <a href="javascript:void(0)" onclick="beginTender(' + row.id + ',\''+row.notice+'\')">发布招标</a>';
                    return rtn;
                }
            }
        ]]
    </script>
    <script type="text/javascript">
        function addNotice(id,_notice){
            if(_notice!=='null'&&_notice!==""){
                $.messager.confirm('警告','你已经添加了项目公告了,是否要进行修改?',function (yes) {
                    if(yes){
                        $('#id').val(id);
                        $('#noticeDlg').dialog('open');
                    }
                });
            }else{
            $('#id').val(id);
            $('#noticeDlg').dialog('open');
            }
        }
        function beginTender(id,_notice) {
            if(_notice!=='null'&&_notice!==""){
            $.messager.confirm("警告", "该项目确认发布招标吗?", function (yes) {
                if(yes){
                    $.ajax({
                        url:'/project/beginTender/'+id+'.do',
                        type:'post',
                        success:function(info){
                            $.messager.alert('提示',eval('('+info+')').retMessage,'info',function(){
                                if(eval('('+info+')').flag){
                                    $('#grid_project_to_begin').datagrid('reload');
                                }
                            });
                        }
                    });
                }
            });
            }else{
                $.messager.alert('提示','招标公告还未填写,无法实现发布招标的请求!','info');
            }
        }
        function submitNotice(){
            if($("[name='deadline']").val()===""){
                $.messager.alert('提示','项目报名截止日期还未填入!','info');
                return;
            }
            if($("[name='noticeMessage']").val()===""){
                $.messager.alert('提示','项目公告还未填入!','info');
                return;
            }
            $('#_noticeForm').ajaxSubmit(function(info){
                $.messager.alert("提示",eval("("+info+")").retMessage,"info",function () {
                    $('#noticeDlg').dialog('close');
                    $('#grid_project_to_begin').datagrid('reload');
                });
            });
        }
    </script>
    <script type="text/javascript">
        $(function (){$('#noticeDlg').dialog({
            title: "添加招标项目公告与报名截止日期",
            width: 600,
            height: 400,
            closed: true,
            modal: true,
            buttons:[{
                text:"确定",
                iconCls:'icon-save',
                handler: submitNotice
                }]
        });});
    </script>
</head>
<body>
<table id="grid_project_to_begin"></table>
<div id='noticeDlg'>
    <form id='_noticeForm' action="/project/addBiddingNotice.do" method="post">
        <input type='hidden' id='id' name="id"/>
        <em style="color: red;">*</em>  项目报名截止时间:
        <input id="_deadline" type="text" class="easyui-datebox" required="required" id="_deadline" name="deadline"/><br>
        <textarea class="easyui-validatebox" name="noticeMessage" id="notice"
                  data-options="required:true"
                  style="width: 560px;height: 260px"></textarea>
    </form>
</div>
</body>
</html>
