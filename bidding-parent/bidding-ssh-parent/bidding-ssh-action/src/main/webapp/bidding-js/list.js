$(function () {
    $('#grid_supplier').datagrid({
        url:'supplier_selectSupplierByIsAliveAndIsNormal.action',
        columns:columns,
        singleSelect : true,
        pagination:true
    });
});