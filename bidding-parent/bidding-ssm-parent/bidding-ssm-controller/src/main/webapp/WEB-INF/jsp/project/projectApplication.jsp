<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <head>
        <title>招标项目申请</title>
      <link href="${pageContext.request.contextPath}/css/table.css" rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/css/global.css" rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/css/tpl.css" rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/css/icon.css" rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/css/user.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css"
              href="${pageContext.request.contextPath}/bidding-js/jquery-easyui-1.3.5/themes/default/easyui.css"/>
        <link rel="stylesheet" type="text/css"
              href="${pageContext.request.contextPath}/bidding-js/jquery-easyui-1.3.5/themes/icon.css"/>
        <script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.form.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/bidding-js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/bidding-js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
        <script type="text/javascript">
            function submitForm() {
                if($('#itemname').val().trim()===""){
                    $.messager.alert('提示','项目名称不能为空!','info');
                    return;
                }
                if($('#introduction').val().trim()===""){
                    $.messager.alert('提示','项目简介不能为空!','info');
                    return;
                }
                if($('#file_business_license_file').val()===""){
                    $.messager.alert('提示','请上传招标文件!','info');
                    return;
                }
                $('#dForm').ajaxSubmit(function (info) {
                    $.messager.alert('提示',eval('('+info+')').retMessage,'info',function(){
                        if(eval('('+info+')').flag){
                           $('#itemname').val("");
                            $('#introduction').val("");
                            $('#file_business_license_file').val("");
                            $('#buylistandreqdoc_').val("");
                        }
                    });
                });
            }
        </script>
    </head>
<body>
    <div id="content" class="fn-clear">
        <div class="ui-user-form" style="padding: 1px">
            <h3 class="ui-user-type"><span><b>招标项目申请</b></span>
            </h3>
            <form id="dForm" method="post" name="dForm" enctype="multipart/form-data"
                  action="/project/addProject.do">
                <div class="ui-user-information">
                    <h4 class="ui-form-title"><span><b>招标项目申请</b></span></h4>
                    <table style="width: 780px;">
                        <tbody>
                        <tr class="tr_style">
                            <td class="key"><em style="color: red;">*</em>项目名称:</td>
                            <td class="value">
                                <input class="easyui-validatebox input_public" data-options="required:true"
                                       type="text" style="width: 250px" name="itemname" id="itemname" value="">
                            </td>
                        </tr>
                        <tr class="tr_style" style="vertical-align: top;">
                            <td class="key"><em style="color: red;">*</em>项目简介:<br/><em style="color: red;">(注：项目简介不能超过500个字数)</em>
                            </td>
                            <td class="value">
                                        <textarea class="easyui-validatebox" name="introduction" id="introduction"
                                                  data-options="required:true"
                                                  style="width: 250px;height: 100px"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td><br/><br/></td>
                        </tr>
                        <tr class="tr_style">
                            <td class="key"><em style="color: red;">*</em>招标书:</td>
                            <td class="value">
                                <input type="file" name="biddingdoc_" id="file_business_license_file"
                                       style="float: left; vertical-align:middle;"
                                       onchange="uploadColorImg('business_license_file');"/>&nbsp;
                            </td>
                        </tr>
                        <tr>
                            <td><br/><br/></td>
                        </tr>
                        <tr class="tr_style">
                            <td class="key"><em style="color: red;"></em>采购清单与技术要求文件:</td>
                            <td class="value">
                                <input type="file" name="buylistandreqdoc_" id="buylistandreqdoc_"
                                       style="float: left; vertical-align:middle;"
                                       onchange="uploadColorImg('business_license_file');"/>&nbsp;
                                <br/><br/><label style="color: red">（注：如果招标书中存在采购清单与技术要求文件,则该选项可忽略）</label>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <span class="ui-user-btn">
				<input type="button" value="" id="form_submit" class="sub" onclick="submitForm()">
			</span>
            </form>
        </div>
    </div>
</body>
</html>
