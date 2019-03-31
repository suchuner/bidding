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
            {field: 'projectnum', title: '项目编号', width: 100, formatter: function (value, row, index) {
                    return row.project.projectnum;
                }},
            {field: 'itemname', title: '项目名称', width: 100, formatter: function (value, row, index) {
                    return row.project.itemname;
                }},
            {field: 'shortname', title: '供应商', width: 100, formatter: function (value, row, index) {
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
                field: 'status', title: '项目状态', width: 100, formatter: function (value, row, index) {
                    if (0 === row.project.status * 1) {
                        return '项目未审核';
                    }
                    if (1 === row.project.status * 1) {
                        return '项目已审核但未通过';
                    }
                    if (2 === row.project.status * 1) {
                        return '项目已审核且已通过';
                    }
                    if (3 === row.project.status * 1) {
                        return '项目招标中';
                    }
                    if (4 === row.project.status * 1) {
                        return '项目竞标中';
                    }
                    if (5 === row.project.status * 1) {
                        return '项目招标成功';
                    }
                    if (6 === row.project.status * 1) {
                        return '项目流标';
                    }
                }
            },
            {
                field: '----',
                title: '操作',
                width: 150,
                formatter: function (value, row, index) {
                    if(row.project.status*1===4){
                    return '<a href="javascript:void(0)" onclick="goToSubmitBiddingDoc('+row.project.id+','+row.supplier.id+',\''+row.biddoc+'\')">提交我的投标文件</a>';
                    }else{
                        if(row.iswinner*1===1) return '是否中标:中标';
                        else return '是否中标:未中标';
                    }
                }
            }
        ]]
    </script>
    <script type="text/javascript">
        $(function () {
            $('#biddingDlg').dialog({
                title: "提交我的投标文件",
                width: 400,
                height: 260,
                closed: true,
                modal: true,
                buttons:[{
                    text:"确定",
                    iconCls:'icon-save',
                    handler: submitBiddingDoc
                }
                ]
            });
        });
    </script>
    <script type="text/javascript">
        function goToSubmitBiddingDoc(pid,sid,biddocPath) {
            if(biddocPath!=="null"){
                $.messager.confirm('提示','你已经提交了投标文件,是否更改?',function(yes){
                    if (yes) {
                        $('#pid').val(pid);
                        $('#sid').val(sid);
                        $('#biddingDlg').dialog('open');
                    }
                });
            }else {
                $.messager.confirm("警告", "确认打开投标书提交框吗?", function (yes) {
                    if (yes) {
                        $('#pid').val(pid);
                        $('#sid').val(sid);
                        $('#biddingDlg').dialog('open');
                    }
                })
            }
        }

        function submitBiddingDoc() {
            if($('#bidDoc_').val()===""){
                $.messager.alert('提示', '投标书未上传!', 'info');
                return;
            }
            $.messager.confirm('警告', '确认要提交吗?', function (yes) {
                if (yes) {
                    $('#biddingForm').ajaxSubmit(function (info) {
                        $.messager.alert('提示', eval('(' + info + ')').retMessage, 'info',function(){
                            if(eval('(' + info + ')').flag){
                                $('#biddingDlg').dialog('close');
                                $('#grid_select_mybidding_is_begin_no').datagrid('reload');
                            }
                        });
                    });
                }
            });
        }
    </script>
</head>
<body>
<table id="grid_select_mybidding_is_begin_no"></table>
<div id='biddingDlg'>
    <form id="biddingForm" enctype="multipart/form-data" method="post"
          action="/bidding/doSupplierBidDocSubmit.do">
        <input type="hidden" id="pid" name="pid">
        <input type="hidden" id="sid" name="sid">
        <em style="color: red;font-size: 16px">*投标书:</em><br>
        <input type="file" name="bidDoc_" id="bidDoc_"
               style="float: right; vertical-align:top;"/><br>
        <em style="font-size: 16px">采购报价文件(投标书中含有该内容,可选):</em><br>
        <input type="file" name="listPriceDoc_" id="listPriceDoc_"
               style="float: right; vertical-align:top;"/><br>
        <em style="font-size: 16px">其他补充文件(用于补充的不足的内容文件,可选):</em><br>
        <input type="file" name="otherDoc_" id="otherDoc_"
               style="float: right; vertical-align:top;"/><br>
    </form>
</div>
</body>
</html>