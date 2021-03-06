
window.onload = function(){
	$('#loading-mask').fadeOut();
}
var onlyOpenTitle="欢迎使用";//不允许关闭的标签的标题
var _menus={
		"icon":"icon-sys",
		"menuid":"0",
		"menuname":"我的功能菜单",
		"menus":
			[
			 	{
			 		"icon":"icon-sys","menuid":"100","menuname":"主菜单","menus":
					[
						{"icon":"icon-sys","menuid":"101","menuname":"查看正在招标的项目","url":"http://localhost:8080/project/toProjectPage/4.do"},
						{"icon":"icon-sys","menuid":"102","menuname":"查询报名未通过审核的项目","url":"http://localhost:8080/enroll/toCheckEnrollPage/1.do"},
						{"icon":"icon-sys","menuid":"103","menuname":"查询报名通过审核的项目","url":"http://localhost:8080/enroll/toCheckEnrollPage/2.do"},
						{"icon":"icon-sys","menuid":"104","menuname":"我的第一轮竞标项目","url":"http://localhost:8080/bidding/toBiddingPage/1.do"},
						{"icon":"icon-sys","menuid":"105","menuname":"我的第二轮竞标项目","url":"http://localhost:8080/bidding/toBiddingPage/4.do"}
					]
			 	}
			 ]
		};
$(function(){
    InitLeftMenu();
    tabClose();
    tabCloseEven();
});
function showMenus(){
	$.ajax({
		url:'',
		type:'post',
		dataType:'json',
		success:function(rtn){
			_menus=rtn;
			InitLeftMenu();
		}
	});
}
$(function(){	
	
	showName();
	showMenus();
	tabClose();
	tabCloseEven();
    $('#supplier_loginOut').bind('click',function(){
        $.ajax({
            url:'supplier_logout.action',
            success:function(){
                window.location.href="/website/login.jsp";
            }
        });
    });
})
function showName(){
	$.ajax({
		url:'login_showName',
		dataType:'json',
		type:'post',
		success:function(rtn){
			if(rtn.success){
				$('#username').html(rtn.message);
			}else{
				location.href="login.html";
			}
			
		}
		
	});
}



//初始化左侧
function InitLeftMenu() {
	$("#nav").accordion({animate:false,fit:true,border:false});
	var selectedPanelname = '';
	    $.each(_menus.menus, function(i, n) {
			var menulist ='';
			menulist +='<ul class="navlist">';
	        $.each(n.menus, function(j, o) {
				menulist += '<li><div ><a ref="'+o.menuid+'" href="#" rel="' + o.url + '" ><span class="icon '+o.icon+'" >&nbsp;</span><span class="nav">' + o.menuname + '</span></a></div> ';
				/*
				if(o.child && o.child.length>0)
				{
					//li.find('div').addClass('icon-arrow');
	
					menulist += '<ul class="third_ul">';
					$.each(o.child,function(k,p){
						menulist += '<li><div><a ref="'+p.menuid+'" href="#" rel="' + p.url + '" ><span class="icon '+p.icon+'" >&nbsp;</span><span class="nav">' + p.menuname + '</span></a></div> </li>'
					});
					menulist += '</ul>';
				}
				*/
				menulist+='</li>';
	        })
			menulist += '</ul>';
	
			$('#nav').accordion('add', {
	            title: n.menuname,
	            content: menulist,
					border:false,
	            iconCls: 'icon ' + n.icon
	        });
	
			if(i==0)
				selectedPanelname =n.menuname;
	
	    });
	
	$('#nav').accordion('select',selectedPanelname);



	$('.navlist li a').click(function(){
		var tabTitle = $(this).children('.nav').text();

		var url = $(this).attr("rel");
		var menuid = $(this).attr("ref");
		var icon = $(this).find('.icon').attr('class');

		var third = find(menuid);
		if(third && third.child && third.child.length>0)
		{
			$('.third_ul').slideUp();

			var ul =$(this).parent().next();
			if(ul.is(":hidden"))
				ul.slideDown();
			else
				ul.slideUp();
		}
		else{
			addTab(tabTitle,url,icon);
			$('.navlist li div').removeClass("selected");
			$(this).parent().addClass("selected");
		}
	}).hover(function(){
		$(this).parent().addClass("hover");
	},function(){
		$(this).parent().removeClass("hover");
	});





	//选中第一个
	//var panels = $('#nav').accordion('panels');
	//var t = panels[0].panel('options').title;
    //$('#nav').accordion('select', t);
}
//获取左侧导航的图标
function getIcon(menuid){
	var icon = 'icon ';
	$.each(_menus.menus, function(i, n) {
		 $.each(n.menus, function(j, o) {
		 	if(o.menuid==menuid){
				icon += o.icon;
			}
		 })
	})

	return icon;
}

function find(menuid){
	var obj=null;
	$.each(_menus.menus, function(i, n) {
		 $.each(n.menus, function(j, o) {
		 	if(o.menuid==menuid){
				obj = o;
			}
		 });
	});

	return obj;
}

function addTab(subtitle,url,icon){
	if(!$('#tabs').tabs('exists',subtitle)){
		$('#tabs').tabs('add',{
			title:subtitle,
			content:createFrame(url),
			closable:true,
			icon:icon
		});
	}else{
		$('#tabs').tabs('select',subtitle);
		$('#mm-tabupdate').click();
	}
	tabClose();
}

function createFrame(url)
{
	var s = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
	return s;
}

function tabClose()
{
	/*双击关闭TAB选项卡*/
	$(".tabs-inner").dblclick(function(){
		var subtitle = $(this).children(".tabs-closable").text();
		$('#tabs').tabs('close',subtitle);
	})
	/*为选项卡绑定右键*/
	$(".tabs-inner").bind('contextmenu',function(e){
		$('#mm').menu('show', {
			left: e.pageX,
			top: e.pageY
		});

		var subtitle =$(this).children(".tabs-closable").text();

		$('#mm').data("currtab",subtitle);
		$('#tabs').tabs('select',subtitle);
		return false;
	});
}


//绑定右键菜单事件
function tabCloseEven() {
    $('#mm').menu({
        onClick: function (item) {
            closeTab(item.id);
        }
    });
    return false;
}

function closeTab(action)
{
    var alltabs = $('#tabs').tabs('tabs');
    var currentTab =$('#tabs').tabs('getSelected');
	var allTabtitle = [];
	$.each(alltabs,function(i,n){
		allTabtitle.push($(n).panel('options').title);
	})
    switch (action) {
        case "refresh":
            var iframe = $(currentTab.panel('options').content);
            var src = iframe.attr('src');
            $('#tabs').tabs('update', {
                tab: currentTab,
                options: {
                    content: createFrame(src)
                }
            })
            break;
        case "close":
            var currtab_title = currentTab.panel('options').title;
            $('#tabs').tabs('close', currtab_title);
            break;
        case "closeall":
            $.each(allTabtitle, function (i, n) {
                if (n != onlyOpenTitle){
                    $('#tabs').tabs('close', n);
				}
            });
            break;
        case "closeother":
            var currtab_title = currentTab.panel('options').title;
            $.each(allTabtitle, function (i, n) {
                if (n != currtab_title && n != onlyOpenTitle)
				{
                    $('#tabs').tabs('close', n);
				}
            });
            break;
        case "closeright":
            var tabIndex = $('#tabs').tabs('getTabIndex', currentTab);

            if (tabIndex == alltabs.length - 1){
                alert('亲，后边没有啦 ^@^!!');
                return false;
            }
            $.each(allTabtitle, function (i, n) {
                if (i > tabIndex) {
                    if (n != onlyOpenTitle){
                        $('#tabs').tabs('close', n);
					}
                }
            });

            break;
        case "closeleft":
            var tabIndex = $('#tabs').tabs('getTabIndex', currentTab);
            if (tabIndex == 1) {
                alert('亲，前边那个上头有人，咱惹不起哦。 ^@^!!');
                return false;
            }
            $.each(allTabtitle, function (i, n) {
                if (i < tabIndex) {
                    if (n != onlyOpenTitle){
                        $('#tabs').tabs('close', n);
					}
                }
            });

            break;
        case "exit":
            $('#closeMenu').menu('hide');
            break;
    }
}


//弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]
function msgShow(title, msgString, msgType) {
	$.messager.alert(title, msgString, msgType);
}




//设置登录窗口
function openPwd() {
    $('#w').dialog({
        title: '修改密码',
        width: 300,
        modal: true,
        closed: true,
        height: 180,
        buttons:[{
			text:'保存',
			iconCls:'icon_save',
			handler:function(){
				var oldpwd = $('#txtOldPass').val();
				var newpwd=$('#txtNewPass').val();
				var repwd = $('#txtRePass').val();
				if(!oldpwd){
					$.messager.alert('提示','旧密码未输入值','info');
					return;
				}
				if(!newpwd){
					$.messager.alert('提示','新密码未输入值','info');
					return;
				}
				if(newpwd!==repwd){
					$.messager.alert('提示','每次密码不一致','info');
					return;
				}
				$.ajax({
					url:'supplier_updatePwd.action',
					data:{"oldPwd":oldpwd,"newPwd":newpwd },
					dataType:'json',
					type:'post',
					success:function(info){
						$.messager.alert('提示',info.retMessage,'info',function(){
                            if(info.flag){
                                $('#txtOldPass').val('');
                                $('#txtNewPass').val('');
                                $('#txtRePass').val('');
                                $('#w').dialog('close');
                                window.location.href="/website/login.jsp";
                            }
						});
					}
				});
			}
		},{
			text:'关闭',
			iconCls:'icon_cancel',
			handler:function(){
				$('#w').dialog('close');
			}
		}]
    });
}
//关闭登录窗口


$(function() {

    openPwd();

    $('#editpass').click(function() {
        $('#w').dialog('open');
    });
   
});


