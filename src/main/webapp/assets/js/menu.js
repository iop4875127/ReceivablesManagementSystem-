//主菜单
$(".navbar-blue li").click(function () {
	$(".navbar-blue li").removeClass("top_menu_click");
	$(this).addClass("active").siblings().removeClass("active");
});
//左侧菜单
$(".left_menu > li > a").click(function(){
	$(this).addClass("xz").parents().siblings().find("a").removeClass("xz");
	 $(this).parents().siblings().find(".er").hide(300);
	 $(this).siblings(".er").toggle(300);

	if($(this).parent().prev('li')){
			$(this).parent().siblings('li').find("a").removeClass("nLien");
			$(this).removeClass("nLien");
			$(this).parent().prev('li').find("a").addClass("nLien");
		}else{
			$(this).parent().siblings('li').find("a").removeClass("nLien");

		}
})
$(".left_menu .er li a").click(function(){
	$(".left_menu .er li a").removeAttr("style");
	$(this).parent().addClass("Li_bg").siblings().removeClass("Li_bg");
	$(this).css("background","url(images/jiantuo_white.png) no-repeat 40px 15px");
	$(this).css("color","#fff");
})

// JavaScript Document
function addTab(title, url){
	if ($('#tabs').tabs('exists', title)){
		$('#tabs').tabs('select', title);//选中并刷新
		var currTab = $('#tabs').tabs('getSelected');
		var url = $(currTab.panel('options').content).attr('src');
		if(url != undefined && currTab.panel('options').title != 'Home') {
			$('#tabs').tabs('update',{
				tab:currTab,
				options:{
					content:createFrame(url)
				}
			})
		}
	} else {
		var content = createFrame(url);
		$('#tabs').tabs('add',{
			title:title,
			content:content,
			closable:true
		});
	}
	//tabClose();
}
function createFrame(url) {
	var s = '<iframe scrolling="no" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
	return s;
}
		
	
//绑定右键菜单事件
function tabCloseEven() {
	$('#mm-tabupdate').click(function(){
		var currTab = $('#tabs').tabs('getSelected');
		var url = $(currTab.panel('options').content).attr('src');
		if(url != undefined && currTab.panel('options').title != 'Home') {
			$('#tabs').tabs('update',{
				tab:currTab,
				options:{
					content:createFrame(url)
				}
			})
		}
	})
}

$(function() {
	tabCloseEven();
	$('.cs-navi-tab').click(function() {
		var $this = $(this);
		var href = $this.attr('src');
		var title = $this.text();
		addTab(title, href);
	});
});
//日期
function myformatter(date){
	var y = date.getFullYear();
	var m = date.getMonth()+1;
	var d = date.getDate();
	return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
}
function myparser(s){
	if (!s) return new Date();
	var ss = (s.split('-'));
	var y = parseInt(ss[0],10);
	var m = parseInt(ss[1],10);
	var d = parseInt(ss[2],10);
	if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
		return new Date(y,m-1,d);
	} else {
		return new Date();
	}
}

// $("#kehufuwu_left").hide();
$("#wuliaoguanli_left").hide();
$("#gongchengguanli_left").hide();
$("#yewuguanli_left").hide();
$("#renliziyuan_left").hide();
$("#caiwuguanli_left").hide();
$("#xitongguanli_left").hide();


	
	$("#wuliaoguanli_top").click(function(){
			
			$("#kehufuwu_left").hide();					
			$("#wuliaoguanli_left").hide();
			$("#gongchengguanli_left").hide();
			$("#yewuguanli_left").hide();
			$("#renliziyuan_left").hide();
			$("#caiwuguanli_left").hide();
			$("#xitongguanli_left").hide();
		$("#wuliaoguanli_left").show();
	});
	$("#caiwuguanli_top").click(function(){		
			
			$("#kehufuwu_left").hide();					
			$("#wuliaoguanli_left").hide();
			$("#gongchengguanli_left").hide();
			$("#yewuguanli_left").hide();
			$("#renliziyuan_left").hide();
			$("#caiwuguanli_left").hide();
			$("#xitongguanli_left").hide();
		$("#caiwuguanli_left").show();
	});
	$("#kehufuwu_top").click(function(){		
		
			
			$("#kehufuwu_left").hide();					
			$("#wuliaoguanli_left").hide();
			$("#gongchengguanli_left").hide();
			$("#yewuguanli_left").hide();
			$("#renliziyuan_left").hide();
			$("#caiwuguanli_left").hide();
			$("#xitongguanli_left").hide();
		$("#kehufuwu_left").show();
	});
	$("#gongchengguanli_top").click(function(){		
		
			
			$("#kehufuwu_left").hide();					
			$("#wuliaoguanli_left").hide();
			$("#gongchengguanli_left").hide();
			$("#yewuguanli_left").hide();
			$("#renliziyuan_left").hide();
			$("#caiwuguanli_left").hide();
			$("#xitongguanli_left").hide();
		$("#gongchengguanli_left").show();
	});
	$("#yewuguanli_top").click(function(){		
		// debugger;
			$("#kehufuwu_left").hide();					
			$("#wuliaoguanli_left").hide();
			$("#gongchengguanli_left").hide();
			$("#yewuguanli_left").hide();
			$("#renliziyuan_left").hide();
			$("#caiwuguanli_left").hide();
			$("#xitongguanli_left").hide();

		$("#yewuguanli_left").show();
		
	});
	$("#renliziyuan_top").click(function(){		
		
			
			$("#kehufuwu_left").hide();					
			$("#wuliaoguanli_left").hide();
			$("#gongchengguanli_left").hide();
			$("#yewuguanli_left").hide();
			$("#renliziyuan_left").hide();
			$("#caiwuguanli_left").hide();
			$("#xitongguanli_left").hide();
		$("#renliziyuan_left").show();
	});
	
	$("#xitongguanli_top").click(function(){		

			$("#kehufuwu_left").hide();					
			$("#wuliaoguanli_left").hide();
			$("#gongchengguanli_left").hide();
			$("#yewuguanli_left").hide();
			$("#renliziyuan_left").hide();
			$("#caiwuguanli_left").hide();
			$("#xitongguanli_left").hide();
		$("#xitongguanli_left").show();
	});



