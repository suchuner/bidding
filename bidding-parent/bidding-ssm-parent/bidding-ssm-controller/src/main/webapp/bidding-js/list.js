$(function () {
    $('#grid_project_no_check').datagrid({
        url:'/project/selectProjectsByStatus/0.do',
        columns:columns,
        singleSelect : true,
        pagination : true
    });
    $('#grid_select_project_no_check').datagrid({
        url:'/project/selectProjectsByStatus/1.do',
        columns:columns,
        singleSelect : true,
        pagination : true
    });
    $('#grid_project_to_begin').datagrid({
        url:'/project/selectProjectsByStatus/2.do',
        columns:columns,
        singleSelect : true,
        pagination : true
    });
    $('#grid_select_project_is_tendering').datagrid({
        url:'/project/selectProjectsByStatus/3.do',
        columns:columns,
        singleSelect : true,
        pagination : true
    });
    $('#grid_select_project_is_bidding').datagrid({
        url:'/project/selectProjectsByStatus/4.do',
        columns:columns,
        singleSelect : true,
        pagination : true
    });

    $('#grid_check_in_enrolls').datagrid({
        url:'/enroll/selectSupplierEnrollsInfoByLoginSupplier/0.do',
        columns:columns,
        singleSelect : true,
        pagination : true
    });
    $('#grid_check_out_enrolls').datagrid({
        url:'/enroll/selectSupplierEnrollsInfoByLoginSupplier/1.do',
        columns:columns,
        singleSelect : true,
        pagination : true
    });
    $('#grid_select_mybidding_is_begin_yes').datagrid({
        url:'/bidding/selectMyBiddingsBysid/1.do',
        columns:columns,
        singleSelect : true,
        pagination : true
    });
    $('#grid_project_expert').datagrid({
        url:'/projectExpert/getProjectExperts.do',
        columns:columns,
        singleSelect : true,
        pagination : true
    });
    $('#grid_select_mybidding_is_begin_no').datagrid({
        url:'/bidding/selectMyBiddingsBysid/0.do',
        columns:columns,
        singleSelect : true,
        pagination : true
    });
});