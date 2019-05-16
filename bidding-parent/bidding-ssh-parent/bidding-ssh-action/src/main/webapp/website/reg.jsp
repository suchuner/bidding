<%@page language="java" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>供应商注册</title>
<%--    <LINK href="${pageContext.request.contextPath}/css/table.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/global.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/tpl.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/icon.css" rel="stylesheet" type="text/css">--%>
    <link href="${pageContext.request.contextPath}/css/user.css" rel="stylesheet" type="text/css">
    <!-- 日期插件，使用jquery -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.form.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jquery/jquery.datepick.css" type="text/css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/bidding-js/jquery-easyui-1.3.5/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/bidding-js/jquery-easyui-1.3.5/themes/icon.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.datepick.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.datepick-zh-CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bidding-js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bidding-js/reg_validation.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/bidding-js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bidding-js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/bidding-js/jquery-easyui-1.3.5/jquery.serializejson.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $('#comp_date').datepick({dateFormat: "yy-mm-dd"});
            $('#business_license_date').datepick({dateFormat: 'yy-mm-dd'});
            $('#organization_date').datepick({dateFormat: 'yy-mm-dd'});
            $('#tax_reg_date').datepick({dateFormat: 'yy-mm-dd'});
        })</script>
</head>
<body>
<div id="wrapper">
    <div id="top"></div>
    <div id="header" class="fn-clear sl-hvalign-cnt">
        <div class="sl-valign-cnt-inner">
            <div id="logo" class="fn-left">
                <a href="javascript:void(0);"></a>
            </div>
            <div id="content" class="fn-clear">
                <div class="ui-user-form" style="padding: 1px">
                    <h3 class="">
                        <span><b>非常欢迎您注册为企业用户</b></span>
                    </h3>
                    <br>
                    <b style="color: red;font-size: 22px">*注意:此表单带*都为必填项!*</b>
                    <form id="dForm" method="post" name="dForm" enctype="multipart/form-data"
                          action="/supplier_addSupplier.action">
                        <div class="ui-user-information">
                        </div>
                        <div class="ui-user-information">
                            <h4 class="ui-form-title"><span><b>联系人信息</b></span></h4>
                            <table style="width: 780px;">
                                <tbody>
                                <tr class="tr_style">
                                    <td class="key"><em style="color: red;">*</em>联系人:</td>
                                    <td class="value">
                                        <input class=" input_public" data-options="required:true"
                                               type="text" id="link_man" name="supplier.linkman" style="width: 250px"
                                               value="">
                                    </td>
                                </tr>
                                <tr class="tr_style">
                                    <td class="key"><em style="color: red;">*</em>手 机:</td>
                                    <td class="value">
                                        <input class=" input_public"
                                               data-options="required:true" type="text"
                                               id="link_tel" name="supplier.phone" style="width: 250px" maxlength="11"
                                               value="">
                                    </td>
                                </tr>
                                <tr>
                                </tr>
                                <tr class="tr_style">
                                    <td class="key"><em style="color: red;">*</em>电子邮箱:</td>
                                    <td class="value">
                                        <input class=" input_public" data-options="required:true"
                                               type="text" id="link_email" validType="email" name="supplier.linkmanemail"
                                               style="width: 250px" value="">
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="ui-user-information">
                            <h4 class="ui-form-title"><span><b>公司信息</b></span></h4>
                            <table style="width: 780px;">
                                <tbody>
                                <tr class="tr_style">
                                    <td class="key"><em style="color: red;">*</em>公司名称:</td>
                                    <td class="value">
                                        <input class=" input_public" data-options="required:true"
                                               type="text" id="comp_name" name="supplier.companyname"
                                               style="width: 250px" value="">
                                    </td>
                                </tr>
                                <tr class="tr_style">
                                    <td class="key"><em style="color: red;">*</em>公司简称:</td>
                                    <td class="value">
                                        <input class=" input_public" data-options="required:true"
                                               type="text" id="comp_shortname" name="supplier.shortname"
                                               style="width: 250px" value="">
                                    </td>
                                </tr>
                                <tr class="tr_style">
                                    <td class="key"><em style="color: red;">*</em>公司地址:</td>
                                    <td class="value">
                                        <input class=" input_public" data-options="required:true"
                                               type="text" id="comp_addr" name="supplier.address" style="width: 250px"
                                               value="">
                                    </td>
                                </tr>
                                <tr class="tr_style" style="vertical-align: top;">
                                    <td class="key"><em style="color: red;">*</em>公司简介:<br/>
                                    </td>
                                    <td class="value">
                                        <textarea class="" name="supplier.introduction"
                                                  id="comp_intro" data-options="required:true"
                                                  style="width: 250px;height: 100px"></textarea>
                                    </td>
                                </tr>
                                <tr class="tr_style">
                                    <td class="key"><em style="color: red;">*</em>注册资金(万元):</td>
                                    <td class="value">
                                        <input class=" input_public" data-options="required:true"
                                               type="number" id="regist_money" name="supplier.regfund"
                                               validType="intOrFloat" style="width: 250px" value="">
                                    </td>
                                </tr>
                                <tr class="tr_style">
                                    <td class="key"><em style="color: red;">*</em>法人代表:</td>
                                    <td class="value">
                                        <input class=" input_public" data-options="required:true"
                                               type="text" id="comp_boss" name="supplier.lawperson" style="width: 250px"
                                               value="">
                                    </td>
                                </tr>
                                <tr class="tr_style">
                                    <td class="key"><em style="color: red;">*</em>成立时间:</td>
                                    <td class="value">
                                        <input class="input_public " data-options="editable:false,required:true"
                                               style="width: 250px;" id="comp_date" type="text"
                                               name="supplier.startdate" value="">
                                    </td>
                                </tr>
                                <tr class="tr_style">
                                    <td class="key"><em style="color: red;">*</em>电 话:</td>
                                    <td class="value">
                                        <input class=" input_public" data-options="required:true"
                                               type="text" id="phone" name="supplier.callnum" style="width: 250px"
                                               value="" maxlength="11">
                                    </td>
                                </tr>
                                <tr class="tr_style">
                                    <td class="key"><em style="color: red;">*</em>公司邮箱:</td>
                                    <td class="value">
                                        <input class=" input_public" data-options="required:true"
                                               type="text" id="comp_email" validType="email"
                                               name="supplier.companyemail" style="width: 250px" value="">
                                        <br/><label style="color: red">（注：邮箱要填写正确，帐号及密码等后续相关通知类信息是通过邮箱发送）</label>
                                    </td>
                                </tr>
                                <tr class="tr_style">
                                    <td class="key">公司网址:</td>
                                    <td class="value">
                                        <input class=" input_public" data-options="required:false"
                                               type="text" id="comp_website" name="supplier.website"
                                               style="width: 250px" value="">
                                    </td>
                                </tr>
                                <tr class="tr_style">
                                    <td class="key"><em style="color: red;">*</em>企业性质:</td>
                                    <td class="value">
                                        <input class="easyui-combobox" data-options="editable:false,required:true,valueField:'_comp_nature_value',textField:'_comp_nature',url:'/bidding_json/comp_nature.json'"
                                               id="comp_nature" name="supplier.typeid"
                                               style="height:25px;line-height:25px;width: 250px"/>
                                    </td>
                                </tr>
                                <tr class="tr_style">
                                    <td class="key"><em style="color: red;">*</em>雇员人数:</td>
                                    <td class="value">
                                        <input class="easyui-combobox" data-options="editable:false,required:true,valueField:'_employee_num_value',textField:'_employee_num',url:'/bidding_json/employee_num.json'"
                                               id="employee_num" name="supplier.empnums" value=""
                                               style="height:25px;line-height:25px;width: 250px"/>
                                    </td>
                                </tr>
                                <tr class="tr_style">
                                    <td class="key" style="vertical-align: top;"><em style="color: red;">*</em>经营范围:
                                    </td>
                                    <td class="value">
                                        <textarea class=" " data-options="required:true"
                                                  name="supplier.frame" id="business_scope"
                                                  style="width: 250px; height: 100px;"></textarea>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="ui-company-info">
                            <h4 class="ui-form-title"><span><b>基本资质信息</b></span></h4>
                            <table style="width: 780px;">
                                <tbody>
                                <tr class="tr_style">
                                    <td class="key"><em style="color: red;">*</em>营业执照注册号:</td>
                                    <td class="value">
                                        <input class=" input_public" data-options="required:true"
                                               type="text" id="business_license" validType="validYyzz"
                                               style="width: 250px;" name="supplier.bizlicregnum" value="">
                                    </td>
                                </tr>
                                <tr class="tr_style">
                                    <td class="key" style="vertical-align: top;"><em style="color: red;">*</em>营业执照有效截止日期:
                                    </td>
                                    <td class="value">
                                        <input class=" input_public"
                                               data-options="editable:false,required:true"  id="business_license_date"
                                               type="text" style="width: 250px;" name="supplier.bizlicenddate" value="">
                                    </td>
                                </tr>
                                <tr class="tr_style">
                                    <td class="key"><em style="color: red;">*</em>营业执照附件:</td>
                                    <td class="value">
                                        <input type="file" name="bizLicDoc" id="file_business_license_file"
                                               style="float: left; vertical-align:middle;"/>&nbsp;
                                        <div id="imgName_business_license_file"
                                             style="float: left; vertical-align:middle;"></div>
                                    </td>
                                </tr>
                                <tr class="tr_style">
                                    <td class="key"><em style="color: red;">*</em>税务登记证号:</td>
                                    <td class="value">
                                        <input class=" input_public" data-options="required:true"
                                               type="text" id="tax_reg" style="width: 250px;" name="supplier.taxregnum"
                                               value="">
                                    </td>
                                </tr>
                                <tr class="tr_style">
                                    <td class="key" style="vertical-align: top;"><em style="color: red;">*</em>税务登记证有效截止日期:
                                    </td>
                                    <td class="value">
                                        <input class=" input_public"
                                               data-options="editable:false,required:true" style="width: 250px;"
                                               type="text" id="tax_reg_date" name="supplier.taxregenddate" value="">
                                    </td>
                                </tr>
                                <tr class="tr_style">
                                    <td class="key"><em style="color: red;">*</em>税务登记证附件:</td>
                                    <td class="value">
                                        <input type="file" name="taxRegDoc" id="file_tax_reg_file"
                                               style="float: left; vertical-align:middle;"/>&nbsp;
                                        <div id="imgName_tax_reg_file"
                                             style="float: left; vertical-align:middle;"></div>
                                    </td>
                                </tr>
                                <tr class="tr_style">
                                    <td class="key"><em style="color: red;">*</em>组织机构代码:</td>
                                    <td class="value">
                                        <input class=" input_public" data-options="required:true"
                                               type="text" id="organization" style="width: 250px;"
                                               name="supplier.orgcode" value="">
                                    </td>
                                <tr class="tr_style">
                                    <td class="key"><em style="color: red;">*</em>组织机构代码有效截止日期:</td>
                                    <td class="value">
                                        <input class=" input_public" data-options="editable:false,required:true"
                                               style="width: 250px;" id="organization_date" type="text"
                                               name="supplier.orgcodeenddate" value="">
                                    </td>
                                </tr>
                                <tr class="tr_style">
                                    <td class="key"><em style="color: red;">*</em>组织机构代码证附件:</td>
                                    <td class="value">
                                        <input type="file" name="orgCodeDoc" id="file_organization_file"
                                               style="float: left; vertical-align:middle;"/>&nbsp;
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <span class="ui-user-btn">
				<input type="button"  id="form_submit" value="提交注册信息" onclick="submitForm()">
				<input type="reset"  value="重置注册信息">
			</span>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>