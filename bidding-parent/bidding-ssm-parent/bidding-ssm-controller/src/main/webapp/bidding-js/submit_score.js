function submitScore() {
var _price = $('#price').val().trim();
var _bussiness =$('#bussiness').val().trim();
var _service =$('#service').val().trim();
var _technology =$('#technology').val().trim();

/*--------------做非空校验------------*/
    if(_price===''){
        $.messager.alert('提示','价格方面评分不能为空!','info');
        return;
    }
    if(_bussiness===''){
        $.messager.alert('提示','商业方面评分不能为空!','info');
        return;
    }
    if(_service===''){
        $.messager.alert('提示','服务方面评分不能为空!','info');
        return;
    }
    if(_technology==='') {
        $.messager.alert('提示', '技术方面评分不能为空!', 'info');
        return;
    }

    /*-------做整数型数字格式校验-------*/
    var reg_score = /^[0-9]{0,3}$/;
    if(!reg_score.test(_price)){
        $.messager.alert('提示','价格方面评分格式不正确,只能为整数!','info');
        return;
    }
    if(!reg_score.test(_bussiness)){
        $.messager.alert('提示','商业方面评分格式不正确,只能为整数!','info');
        return;
    }
    if(!reg_score.test(_service)){
        $.messager.alert('提示','服务方面评分格式不正确,只能为整数!','info');
        return;
    }
    if(!reg_score.test(_technology)) {
        $.messager.alert('提示', '技术方面评分格式不正确,只能为整数!', 'info');
        return;
    }
    /*-------做数据的大小校验---------*/
    if(_price*1<0||_price*1>100){
        $.messager.alert('提示','价格方面评分区间为0~100!','info');
        return;
    }
    if(_bussiness*1<0||_bussiness*1>100){
        $.messager.alert('提示','商业方面评分区间为0~100!','info');
        return;
    }
    if(_service*1<0||_service*1>100){
        $.messager.alert('提示','服务方面评分区间为0~100!','info');
        return;
    }
    if(_technology*1<0||_technology*1>100) {
        $.messager.alert('提示', '技术方面评分区间为0~100!', 'info');
        return;
    }
    /*------做数据的提交-----------*/
    $('#scoreForm').ajaxSubmit(function(info){
        $.messager.alert('提示', eval('('+info+')').retMessage, 'info',function(){
            $('#grid_supplier_biddings').datagrid('reload');
            $('#scoreDlg').dialog('close');
        });
    })
}