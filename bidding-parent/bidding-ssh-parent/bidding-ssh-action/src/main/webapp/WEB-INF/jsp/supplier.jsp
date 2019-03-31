<%@page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>supplier</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bidding-js/jquery-easyui-1.3.5/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bidding-js/jquery-easyui-1.3.5/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bidding-js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bidding-js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bidding-js/jquery-easyui-1.3.5/jquery.serializejson.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bidding-js/date.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bidding-js/list.js"></script>
	<script type="text/javascript">
	var columns=[ [
				{field:'id',title:'编号',width:30},
	  		    {field:'companyname',title:'公司名称',width:100},
	  		    {field:'shortname',title:'公司简称',width:100},
	  		    {field:'address',title:'公司地址',width:100},
	  		    {field:'introduction',title:'公司简介',width:100},
	  		    {field:'companyemail',title:'公司邮箱',width:100},
	  		    {field:'lawperson',title:'公司法人',width:100},
	  		    {field:'frame',title:'公司经营范围',width:100},
	  		    {field:'callnum',title:'公司电话',width:100},
	  		    {field:'website',title:'公司网址',width:100},
	  		    {field:'regfund',title:'注册资金',width:100},
	  		    {field:'startdate',title:'公司成立日期',width:100,formatter:function(value){
                        return new Date(value).Format("yyyy-MM-dd");
                    }},

	  		    {field:'typeid',title:'公司性质',width:100,formatter:function(value,row,index){
	  		        if(0 === value*1){
                            return '国有企业';
					}
	  		        if(1 === value*1){
	  		    		return '中外合作企业';
	  		    	}
                    if(2 === value*1){
                        return '中外合资企业';
                    }
                    if(3 === value*1){
                        return '外商独资企业';
                    }
                    if(4 === value*1){
                        return '集体企业';
                    }
                    if(5 === value*1){
                        return '私人企业';
                    }
                    if(6 === value*1){
                        return '个体工商户';
                    }
                    if(7 === value*1){
                        return '其他企业';
                    }
                }},
        		{field:'empnums',title:'公司雇员人数',width:100,formatter:function(value,row,index){
                        if(0 === value*1){
                            return '1-9人';
                        }
                        if(1 === value*1){
                            return '10-49人';
                        }
                        if(2 === value*1){
                            return '50-99人';
                        }
                        if(3 === value*1){
                            return '100-499人';
                        }
                        if(4 === value*1){
                            return '500-999人';
                        }
                        if(5 === value*1){
                            return '1000人以上';
                        }
                    }},
	  		    {field:'bizlicregnum',title:'营业执照注册号',width:100},
   				{field:'bizlicenddate',title:'营业执照有效期',width:100,formatter:function(value){
    			    return new Date(value).Format("yyyy-MM-dd");
   				 }},
	  		    {field:'-',title:'营业执照附件下载',width:100,formatter: function(value,row,index){
                        return '<a href="download_execute.action?id='+row.id+'&flag=0">营业执照附件下载</a>';
                    }},
	  		    {field:'taxregnum',title:'税务登记证号',width:100},
	  		    {field:'taxregenddate',title:'税务登记证有效期',width:100,formatter:function(value){
	  		    	return new Date(value).Format("yyyy-MM-dd");
	  		    }},
	  		    {field:'--',title:'税务登记证附件下载',width:100,formatter: function(value,row,index){
                        return '<a href="download_execute.action?id='+row.id+'&flag=1">税务登记证附件下载</a>';
                    }},
	  		    {field:'orgcode',title:'组织机构代码',width:100},
    			{field:'orgcodeenddate',title:'组织机构代码有效期',width:100,formatter:function(value){
    			    return new Date(value).Format("yyyy-MM-dd");
    			}},
	  		    {field:'---',title:'组织机构代码证附件下载',width:100,formatter: function(value,row,index){
                        return '<a href="download_execute.action?id='+row.id+'&flag=2">组织机构代码证附件下载</a>';
                    }},
	  		    {field:'linkman',title:'联系人',width:100},
	  		    {field:'linkmanemail',title:'联系人邮箱',width:100},
	  		    {field:'phone',title:'联系人电话',width:100},
	{
		field : '----',
		title : '操作',
		width : 100,
		formatter: function(value,row,index){
			var rtn='<a href="javascript:void(0)" onclick="pass_yes_no('+row.id+',0)">通过审核</a>';
			rtn+='   <a href="javascript:void(0)" onclick="pass_yes_no('+row.id+',1)">不通过审核</a>';
			return rtn;
	}}
	]]
</script>
	<script type="text/javascript">
        $(function (){$('#messageDlg').dialog({
            title: "添加供应商审核不通过的原因",
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
		function pass_yes_no(id,code){
		    $.messager.confirm("警告","确认审核吗?",function(yes){
				if(yes){
				    if(0===code*1){
                        $.ajax({
                            url:"supplier_doCheckSupplierToAlive.action?id="+id,
                            type:'post',
                            success:function(info){
                                $.messager.alert("提示",eval('('+info+')').retMessage,"info",function(){
                                    $('#grid_supplier').datagrid('reload');
                                });
                            }
                        });
					}
					if(1===code*1){
                        $('#messageDlg').dialog('open');
                        $('#id').val(id);
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
                    url: "supplier_doCheckSupplierToNotAlive.action?id=" +$('#id').val() + "&message=" + messInfo,
                    type: 'post',
                    success: function (info) {
                        $.messager.alert("提示", eval('(' + info + ')').retMessage, "info", function () {
                            $('#messageDlg').dialog('close');
                            $('#grid_supplier').datagrid('reload');
                        });
                    }
                });}
            });}
	</script>
</head>
<body>
	<table id="grid_supplier"></table>
	<div id='messageDlg'>
		<input type="hidden" id="id">
		<em style="color: red;">*</em>  审核不通过原因:
		<textarea class="easyui-validatebox" name="message" id="notice"
				  data-options="required:true"
				  style="width: 560px;height: 260px"></textarea>
	</div>
</body>
</html>
