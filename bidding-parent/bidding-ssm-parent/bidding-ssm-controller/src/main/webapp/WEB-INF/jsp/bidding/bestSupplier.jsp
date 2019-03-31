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
                    return '<a href="javascript:void(0)" onclick="chooseBestSupplier(' + row.id + ',' + row.isbegin + ')">选出最优供应商</a>';
                }
            }
        ]];
        var _columns = [[
            {field:'companyname',title:'公司名称',width:200},
            {field:'shortname',title:'公司简称',width:100},
            {field:'address',title:'公司地址',width:200},
            {field:'introduction',title:'公司简介',width:260},
            {field:'companyemail',title:'公司邮箱',width:160},
            {field:'lawperson',title:'公司法人',width:100},
            {field:'frame',title:'公司经营范围',width:100},
            {field:'callnum',title:'公司电话',width:100},
            {field:'website',title:'公司网址',width:150}
        ]]
    </script>
    <script type="text/javascript">
        function chooseBestSupplier(id,isbegin){
            if(isbegin*1===1){
                selectBest(id,isbegin);
            }else{
                    $.messager.confirm('警告','第一轮竞标未产生最优供应商,是否已经进行了二轮竞标流程?',function(yes){
                        if(yes){
                            selectBest(id,isbegin);
                        }
                    })
            }
        }

        function selectBest(id,isbegin){
            $('#bestSupplierDlg').dialog('open');
            $('#grid_best_supplier').datagrid({
                url:'/bidding/selectTheBestWinnerOrReBidding/'+id+'/'+isbegin+'.do',
                columns:_columns,
                singleSelect : true,
                onLoadSuccess:function(){
                    $('#grid_select_project_is_bidding').datagrid('reload');
                }
            });
        }
    </script>
    <script type="text/javascript">
        $(function () {
            $('#bestSupplierDlg').dialog({
                title: "最优供应商",
                width: 1000,
                height: 400,
                closed: true,
                modal: true
            });
        });
    </script>
</head>
<body>
<table id="grid_select_project_is_bidding"></table>
<div id='bestSupplierDlg'>
    <table id="grid_best_supplier"></table>
</div>
</body>
</html>