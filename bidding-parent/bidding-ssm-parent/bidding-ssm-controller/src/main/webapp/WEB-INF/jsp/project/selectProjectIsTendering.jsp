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
            {field: 'notice', title: '招标公告', width: 200},
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
                field: '-', title: '招标书下载', width: 100, formatter: function (value, row, index) {
                    return '<a href="/download/downloadFile/' + row.id + '/0.do">招标书下载</a>';
                }
            },
            {
                field: '--', title: '采购清单与技术要求文件下载', width: 180, formatter: function (value, row, index) {
                    return '<a href="/download/downloadFile/' + row.id + '/1.do">采购清单与技术要求文件下载</a>';
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
                    return '<a href="javascript:void(0)" onclick="addEnroll(' + row.id + ')">项目报名</a>';
                }
            }
        ]]
    </script>
    <script type="text/javascript">
        $(function (){$('#enrollDlg').dialog({
            title: "招标项目报名",
            width: 400,
            height: 220,
            closed: true,
            modal: true,
            buttons:[{
                text:"确定",
                iconCls:'icon-save',
                handler: submitEnroll
            }]
        });});
    </script>
    <script type="text/javascript">
        function addEnroll(id){
            $('#legaldoc_').val(null);
            $('#taxdoc_').val(null);
            $('#sidoc_').val(null);
            $('#id').val(null);
            $.messager.confirm('警告','确认要报名该招标项目吗?',function(yes){
                if(yes){
                $('#id').val(id);
                $('#enrollDlg').dialog('open');
                }
            })
        }
        function submitEnroll(){
            if($('#legaldoc_').val()===""){
                $.messager.alert("提示","无重大违法文件未上传!","info");
                return;
            }
            if($('#taxdoc_').val()===""){
                $.messager.alert("提示","纳税文件未上传!","info");
                return;
            }
            if($('#sidoc_').val()===""){
                $.messager.alert("提示","员工社保缴纳文件未上传!","info");
                return;
            }
            $('#_enrollForm').ajaxSubmit(function(info){
                $.messager.alert("提示",eval('('+info+')').retMessage,"info",function(){
                    $('#enrollDlg').dialog('close');
                });
            });
        }
    </script>
</head>
<body>
<table id="grid_select_project_is_tendering"></table>
<div id='enrollDlg'>
    <form id='_enrollForm' action="/enroll/addEnroll.do" method="post" enctype="multipart/form-data">
        <input type='hidden' id='id' name="pjtId"/>
        <em style="color: red;font-size: 16px">*无重大违法行为证明文件:</em><br>
            <input type="file" name="legaldoc_" id="legaldoc_"
                   style="float: right; vertical-align:top;"
                   /><br>
        <em style="color: red;font-size: 16px">*公司纳税证明文件:</em><br>
        <input type="file" name="taxdoc_" id="taxdoc_"
               style="float: right; vertical-align:top;"
               /><br>
        <em style="color: red;font-size: 16px">*给员工缴纳社保证明文件:</em><br>
        <input type="file" name="sidoc_" id="sidoc_"
               style="float: right; vertical-align:top;"/><br>
    </form>
</div>
</body>
</html>
