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
                    return '<a href="javascript:void(0)" onclick="chooseJudgeMan(' + row.id +','+row.judgenums+')">为该项目抽取评标人</a>';
                }
            }
        ]];
        var _columns=[[
            {field: 'id', title: '编号', width: 30},
            {field: 'name', title: '姓名', width: 100},
            {field: 'gender', title: '性别', width: 50,formatter: function(value){
                    if (0 === value * 1) {
                        return '女';
                    }
                    if (1 === value * 1) {
                        return '男';
                    }
                }},
            {field: 'phone', title: '手机', width: 100},
            {field: 'email', title: '邮箱', width: 200},
            {
                field: 'education', title: '学历', width: 50, formatter: function (value, row, index) {
                    if (0 === value * 1) {
                        return '专科';
                    }
                    if (1 === value * 1) {
                        return '本科';
                    }
                    if (2 === value * 1) {
                        return '硕士';
                    }
                    if (3 === value * 1) {
                        return '博士';
                    }
                }
            },
            {field: 'address', title: '联系地址', width: 300},
            {
                field: '----',
                title: '操作',
                width: 100,
                formatter: function (value, row, index) {
                    return '<a href="javascript:void(0)" onclick="tellHer(' + row.id +')">告诉他</a>';
                }
            }
        ]];
    </script>
    <script type="text/javascript">
        $(function (){$('#chooseJudgeManDlg').dialog({
            title: "添加需要抽取的评标人的数量",
            width: 300,
            height: 120,
            closed: true,
            modal: true,
            buttons:[{
                text:"确定",
                iconCls:'icon-save',
                handler: submitIt
            }]
        });});
        $(function (){$('#JudgeManDlg').dialog({
            title: "随机抽取的评标人的详细信息",
            width: 1000,
            height: 400,
            closed: true,
            modal: true
        });});
    </script>
    <script type="text/javascript">
        function chooseJudgeMan(id,nums){
            if(nums==null){
                $('#id').val(id);
                $('#flag').val(0);
                $('#chooseJudgeManDlg').dialog('open');
            }else{
                $.messager.confirm('提示','你已经为该项目随机抽取了,是否要覆盖之前的抽取?',function(yes){
                    if(yes){
                        $('#id').val(id);
                        $('#flag').val(1);
                        $('#chooseJudgeManDlg').dialog('open');
                    }
                });
            }
        }
        function submitIt(){
            $.ajax({
                url:'/project/doSelectJudgeForRandomByPidAndNums/'+$('#flag').val()+'.do?pid='+$('#id').val()+'&nums='+$('[name="chooseJudgeMan_"]').val(),
                type:'get',
                success:function(info){
                    if(eval('('+info+')').retMessage!==undefined){
                        $.messager.alert('提示',eval('('+info+')').retMessage,'info',function(){
                            $('#chooseJudgeManDlg').dialog('close');
                        });
                    }else{
                        $('#grid_select_project_is_bidding').datagrid('reload');
                        $('#chooseJudgeManDlg').dialog('close');
                        $('#JudgeManDlg').dialog('open');
                        $('#grid_select_judge_man').datagrid({
                            data:eval('('+info+')'),
                            columns:_columns,
                            singleSelect : true
                        })
                    }

                }
            });
        }
        function tellHer(id){
            $.ajax({
                url:'http://localhost:8090/expert_tellHerIsSelected.action?id='+id,
                type:'get',
                dataType:'jsonp',
                jsonp: "callback",
                jsonpCallback:"success_jsonpCallback",
                success:function(info){
                    $.messager.alert('提示',info.retMessage,'info');
                }
            });
        }
    </script>
</head>
<body>
<table id="grid_select_project_is_bidding"></table>
<div id="chooseJudgeManDlg">
    <input type="hidden" id="id">
    <input type="hidden" id="flag">
    <em style="color: red">*默认选择为3个评标人</em>
    <input id="chooseJudgeMan_" name="chooseJudgeMan_" class="easyui-combobox"
           data-options="valueField:'value',textField:'value',url:'${pageContext.request.contextPath}/bidding-json/judgeManNums.json'" />
</div>
<div id="JudgeManDlg">
    <table id="grid_select_judge_man"></table>
</div>
</body>
</html>
