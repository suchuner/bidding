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
    <script type="text/javascript" src="${pageContext.request.contextPath}/bidding-js/submit_score.js"></script>
    <script type="text/javascript">
        var columns = [[
            {field: 'projectnum', title: '项目编号', width: 260, formatter: function (value, row, index) {
                    return row.project.projectnum;
                }},
            {field: 'itemname', title: '项目名称', width: 200, formatter: function (value, row, index) {
                    return row.project.itemname;
                }},
            {
                field: 'isbegin', title: '是否第一轮招标', width: 100, formatter: function (value, row, index) {
                    if (0 === row.project.isbegin * 1) {
                        return '否';
                    }
                    if (1 === row.project.isbegin * 1) {
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
                field: '-', title: '招标书下载', width: 100, formatter: function (value, row, index) {
                    return '<a href="/download/downloadFile/' + row.project.id + '/0.do">招标书下载</a>';
                }
            },
            {
                field: '--', title: '采购清单与技术要求文件下载', width: 180, formatter: function (value, row, index) {
                    return '<a href="/download/downloadFile/' + row.project.id + '/1.do">采购清单与技术要求文件下载</a>';
                }
            },
            {
                field: '----',
                title: '操作',
                width: 150,
                formatter: function (value, row, index) {
                    if(row.project.status*1===4){
                    return '<a href="javascript:void(0)" onclick="goToCheckSupplier(' + row.project.id + ','+row.project.isbegin+')">查看供应商的投标</a>';}
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
                field: '-', title: '投标文件下载', width: 100, formatter: function (value, row, index) {
                    return '<a href="/download/downloadFiles/' + row.id + '/1.do">投标文件下载</a>';
                }
            },
            {
                field: '--', title: '采购清单报价文件下载', width: 100, formatter: function (value, row, index) {
                    return '<a href="/download/downloadFiles/' + row.id + '/2.do">采购清单报价文件下载</a>';
                }
            },
            {
                field: '---', title: '其他补充文件', width: 100, formatter: function (value, row, index) {
                    return '<a href="/download/downloadFiles/' + row.id + '/3.do">其他补充文件下载</a>';
                }
            },
            {
                field: '----',
                title: '操作',
                width: 150,
                formatter: function (value, row, index) {
                    return '<a href="javascript:void(0)" onclick="goToScore(' + row.project.id + ',' + row.supplier.id + ',\'' + row.supplier.companyname + '\')">去评分</a>';
                }
            }
        ]]
    </script>
    <script type="text/javascript">
        $(function () {
            $('#supplierDlg').dialog({
                title: "查看供应商投标",
                width: 1000,
                height: 400,
                closed: true,
                modal: true
            });
        });
        $(function () {
            $('#scoreDlg').dialog({
                title: "给供应商的投标评分",
                width: 300,
                height: 300,
                closed: true,
                modal: true,
                buttons: [{
                    text: '确定',
                    iconCls: 'icon-save',
                    handler: submitScore
                }]
            });
        });
    </script>
    <script type="text/javascript">
        function goToCheckSupplier(id,isBegin) {
            $.messager.confirm("警告", "确认查看该项目的所有供应商投标吗?", function (yes) {
                if (yes) {
                    $('#supplierDlg').dialog('open');
                    $('#grid_supplier_biddings').datagrid({
                        url: '/bidding/selectSupplierByPid/' + id + '/'+isBegin+'.do',
                        columns: _columns,
                        singleSelect: true,
                        pagination: true
                    });
                }
            })
        }

        function goToScore(pid, sid,name) {
            //解决小bug
            $('#price').val(null);
            $('#bussiness').val(null);
            $('#service').val(null);
            $('#technology').val(null);
            //---------
            $.ajax({
               url:'/score/getScoresByPidAndSid/'+pid+'/'+sid+'.do',
                type:'get',
                success:function(info){
                   var temp =eval('('+info+')');
                   if(temp.flag){
                       $.messager.confirm("警告", "你已经为该用户评分了,确认修改吗?", function (yes) {
                           if (yes) {
                               $('#scoreDlg').dialog('open');
                               $('#pid').val(pid);
                               $('#sid').val(sid);
                               $('#supplierName').html(name);
                               $('#price').val(temp.retMessage.price);
                               $('#bussiness').val(temp.retMessage.bussiness);
                               $('#service').val(temp.retMessage.service);
                               $('#technology').val(temp.retMessage.technology);
                           }
                       });
                   }else{
                       $('#scoreDlg').dialog('open');
                       $('#pid').val(pid);
                       $('#sid').val(sid);
                   }
                }
            });
        }
    </script>
</head>
<body>
<table id="grid_project_expert"></table>
<div id="supplierDlg">
    <table id="grid_supplier_biddings"></table>
</div>
<div id="scoreDlg">
    <form id="scoreForm" method="post" action="/score/addScore.do">
        <input type="hidden" id="pid" name="pid">
        <input type="hidden" id="sid" name="sid">
        <div>
            <em style="color: red">*注意:</em>
            <em style="color: red">评分规则为分数的区间在0~100之间,不能为小数,负数,字母等其他符号,否则数据校验不通过</em>
        </div><br>
        <div>
            <em style="color: red">供应商名称:</em>
            <em style="color: red" id="supplierName"></em>
        </div><br>
        <div>
            <em style="color: red">价格方面评分:</em>
            <input class="easyui-validatebox" type="text" name="price" id="price" data-options="required:true" maxlength="3"/>
        </div><br>
        <div>
            <em style="color: red">商业方面评分:</em>
            <input class="easyui-validatebox" type="text" name="bussiness" id="bussiness" data-options="required:true" maxlength="3"/>
        </div><br>
        <div>
            <em style="color: red">服务方面评分:</em>
            <input class="easyui-validatebox" type="text" name="service" id="service" data-options="required:true" maxlength="3"/>
        </div><br>
        <div>
            <em style="color: red">技术方面评分:</em>
            <input class="easyui-validatebox" type="text" name="technology" id="technology" data-options="required:true" maxlength="3"/>
        </div>
    </form>
</div>
</body>
</html>
