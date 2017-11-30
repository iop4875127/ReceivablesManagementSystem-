<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>装修管理系统主界面</title>
<link rel="stylesheet" type="text/css" href="/assets/css/easyui.css"/>
<link rel="stylesheet" type="text/css" href="/assets/css/index.css"/>
<link rel="stylesheet" type="text/css" href="/assets/css/home.css"/>
<script type="text/javascript" src="/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="/assets/js/jquery.easyui.min.js"></script>
<style>
.tabs-header-noborder, .tabs-header, .tabs-wrap {
	display: block;
	font-size: 0;
	height: 0;
	padding: 0;
}
</style>
</head>
<body class="easyui-layout">
<div data-options="region:'north'" border="false" class="cs-north">
  <div id="head">
    <div class="logo"><img src="/assets/images/logo.png" class="img-responsive left-block"/></div>
    <div class="head-right">
      <div class="plane-tool"> <a href="#"><img src="/assets/images/main_close .png"></a> <a href="#"><img src="/assets/images/fangda.png"></a> <a href="#"><img src="/assets/images/huanyran.png"></a>
        <div class="clearfix"></div>
      </div>
      <div class="top-menu">
        <div class="top-menu-page pull-right">
          <div class="top-menu-left pull-left">&nbsp;</div>
          <div class="top-menu-right pull-right">&nbsp;</div>
          <div class="top-menu-center pull-left"> <a href="#none" title="快捷方式" ><img src="/assets/images/icon/main_shortcut.png"/></a> <a href="#none" title="个人空间"><img src="/assets/images/icon/main_indiv.png"/></a> <a href="#none" title="集团空间"><img src="/assets/images/icon/main_zone.png"/></a> <a href="#none" title="相关链接"><img src="/assets/images/icon/main_link.png"/></a> <a href="#none" title="帮助中心"><img src="/assets/images/icon/main_help.png"/></a> <a href="#none" title="退出"><img src="/assets/images/icon/main_logout.png"/></a> </div>
          <div class="clearfix"></div>
        </div>
        <div class="pull-right">欢迎，<font color="#FF0000">admin</font>&nbsp;访问</div>
        <div class="clearfix"></div>
      </div>
    </div>
    <div class="clearfix"></div>
  </div>
  <!--菜单-->
  <nav class="navbar navbar-blue " >
    <ul class="nav navbar-nav nav-justified ">
      <li class="active"><a id="kehufuwu_top" href="#">客户服务</a></li>
      <li><a id="wuliaoguanli_top" href="#">物料管理</a></li>
      <li><a id="yewuguanli_top" href="#">业务管理</a></li>
      <li><a id="gongchengguanli_top" href="#">工程管理</a></li>
      <li><a id="renliziyuan_top" href="#">人力资源</a></li>
      <li><a id="caiwuguanli_top" href="#">财务管理</a></li>
      <li><a id="xitongshezhi_top" href="#">系统设置</a></li>
    </ul>
  </nav>
</div>

<!-- <div data-options="region:'south'" border="false" class="cs-south">&nbsp;</div> -->
<div data-options="region:'west'" border="false" class="cs-west">
  <div id="mainnav-menu-wrap">
    <div class="nano has-scrollbar">
      <div id="left_menu" class="nano-content" tabindex="0" style="right: -17px;">
        <ul id="kehufuwu_left" class="left_menu">
          <li> <a href="#" class="xz">客户资料</a>
            <ul class="er" style="display:block">
            	 <li><a href="/CustomBaseInfo/listCustomBaseInfo"  class="cs-navi-tab">客户基本信息</a></li>
            	 <li><a href="/aa">test</a></li>
            </ul>
          </li>
          
          <li> <a href="#">公用模块</a>
            <ul class="er">
              <li><a href="javascript:void(0);"  src="/assets/demo/公用模块.html" class="cs-navi-tab">公用模块</a></li>
            </ul>
          </li>
        </ul>
          <!-- --------------------------------------------------------------------------------------- -->
          <ul id="wuliaoguanli_left" class="left_menu">
          <li> <a href="#" class="xz">物料信息</a>
            <ul class="er" style="display:block">
             
              <li><a href="/StoreHouseInfo/listStoreHouseInfo"  class="cs-navi-tab">物料基本信息</a></li>
            </ul>
          </li>
          </ul>
        <!-- ------------------------------------------------------------------------------------ -->
         <ul id="gongchengguanli_left" class="left_menu">
          <li> <a href="#" class="xz">工程物料管理</a>
            <ul class="er" style="display:block">
              <li><a href="javascript:void(0);" src="/assets/demo/选项卡上下表格.html" class="cs-navi-tab">工程物料</a></li>
              <li><a href="javascript:void(0);" src="/assets/demo/选项卡上下表格.html" class="cs-navi-tab">物料审批</a></li>
              <li><a href="javascript:void(0);" src="/assets/demo/选项卡上下表格.html" class="cs-navi-tab">物料通告</a></li>
            </ul>
          </li>
          <li> <a href="#">工程进度管理</a>
            <ul class="er">
              <li><a href="javascript:void(0);" src="/assets/demo/树形菜单添加.html" class="cs-navi-tab">工程接收任务</a></li>
              <li><a href="/ProjectInfo/listProjectInfo"  class="cs-navi-tab">工程进度</a></li>
              <li><a href="javascript:void(0);" src="/assets/demo/树形菜单选项卡.html" class="cs-navi-tab">进度通告</a></li>
            </ul>
          </li>
          <li> <a href="#">工程款增减管理</a>
            <ul class="er">
              <li><a href="/PlusOrMinusInfo/listPlusOrMinusInfo"  class="cs-navi-tab">工程进度</a></li>
              
              <li><a href="javascript:void(0);" src="/assets/demo/树形菜单选项卡.html" class="cs-navi-tab">进度通告</a></li>
            </ul>
          </li>         
          </li>
          <li> <a href="#">公用模块</a>
            <ul class="er">
              <li><a href="javascript:void(0);"  src="/assets/demo/公用模块.html" class="cs-navi-tab">公用模块</a></li>
            </ul>
          </li>
        </ul>
        <!-- ------------------------------------------------------------------------------------ -->
        <ul id="yewuguanli_left" class="left_menu">
          <li> <a href="#" class="xz">量房定金管理</a>
            <ul class="er" style="display:block">
            <li><a href="/DepositInfo/listDepositInfo"  class="cs-navi-tab">量房定金</a></li>
              <li><a href="javascript:void(0);" src="/assets/demo/树形菜单选项卡.html" class="cs-navi-tab">量方定金审批</a></li>
              <li><a href="javascript:void(0);" src="/assets/demo/树形菜单选项卡.html" class="cs-navi-tab">通告 </a></li>
            </ul>
          </li>
          <li> <a href="#">分期管理</a>
            <ul class="er">
              <li><a href="/PeriodInfo/listPeriodInfo"  class="cs-navi-tab">分期基本信息</a></li>
            	 
            </ul>
          </li>

          <li> <a href="#">合同管理</a>
            <ul class="er">
            <li><a href="/ContractInfo/listContractInfo"  class="cs-navi-tab">合同基本信息</a></li>
              <li><a href="javascript:void(0);" src="/assets/demo/薪资信息.html" class="cs-navi-tab">合同审批</a></li>
               <li><a href="javascript:void(0);" src="/assets/demo/薪资项配置.html" class="cs-navi-tab">通告</a></li>
            </ul>
          </li>

          <li> <a href="#">公用模块</a>
            <ul class="er">
              <li><a href="javascript:void(0);"  src="/assets/demo/公用模块.html" class="cs-navi-tab">公用模块</a></li>
            </ul>
          </li>
        </ul>
        <!-- ------------------------------------------------------------------------------------ -->
         <ul id="renliziyuan_left" class="left_menu">
          <li> <a href="#" class="xz">组织机构</a>
            <ul class="er" style="display:block">
              <li><a href="javascript:void(0);" src="/assets/demo/选项卡上下表格.html" class="cs-navi-tab">组织机构设置</a></li>
            </ul>
          </li>
          <li> <a href="#">员工管理</a>
            <ul class="er">
              <li><a href="/EmployeeInfo/listEmployeeInfo"  class="cs-navi-tab">员工基本信息</a></li>
              <li><a href="javascript:void(0);" src="/assets/demo/树形菜单选项卡.html" class="cs-navi-tab">员工调动</a></li>
            </ul>
          </li>

          <li> <a href="#">角色管理</a>
            <ul class="er">
              <li><a href="javascript:void(0);" src="/assets/demo/薪资信息.html" class="cs-navi-tab">角色管理</a></li>
              <li><a href="javascript:void(0);" src="/assets/demo/薪资信息.html" class="cs-navi-tab">角色功能</a></li>
               <li><a href="javascript:void(0);" src="/assets/demo/薪资项配置.html" class="cs-navi-tab">角色分配</a></li>
            </ul>
          </li>
          <li> <a href="#">公用模块</a>
            <ul class="er">
              <li><a href="javascript:void(0);"  src="/assets/demo/公用模块.html" class="cs-navi-tab">公用模块</a></li>
            </ul>
          </li>
        </ul>
        <!-- ------------------------------------------------------------------------------------ -->
        <ul id="caiwuguanli_left" class="left_menu">
          <li> <a href="#" class="xz">支出明细</a>
            <ul class="er" style="display:block">
              <li><a href="javascript:void(0);" src="/assets/demo/选项卡上下表格.html" class="cs-navi-tab">物料支出</a></li>
              <li><a href="javascript:void(0);" src="/assets/demo/选项卡上下表格.html" class="cs-navi-tab">后勤支出</a></li>
              <li><a href="javascript:void(0);" src="/assets/demo/选项卡上下表格.html" class="cs-navi-tab">薪资发放</a></li>
            </ul>
          </li>
          <li> <a href="#">收入明细</a>
            <ul class="er">
            	<li><a href="/ReceiptInfo/listReceiptInfo"  class="cs-navi-tab">工程结款</a></li>
            
              <li><a href="javascript:void(0);" src="/assets/demo/树形菜单选项卡.html" class="cs-navi-tab">其他结款</a></li>
            </ul>
          </li>

          <li> <a href="#">财务核算</a>
            <ul class="er">
            <li><a href="/CheckMoneyInfo/listCheckMoneyInfo"  class="cs-navi-tab">核算基本信息</a></li>
            
              
            </ul>
          </li>
          <li> <a href="#">公用模块</a>
            <ul class="er">
              <li><a href="javascript:void(0);"  src="/assets/demo/公用模块.html" class="cs-navi-tab">公用模块</a></li>
            </ul>
          </li>
        </ul>
     <!-- ------------------------------------------------------------------------------------ -->
		<ul id="xitongguanli_left" class="left_menu">
          <li> <a href="#" class="xz">系统管理</a>
            <ul class="er" style="display:block">
              <li><a href="javascript:void(0);" src="/assets/demo/选项卡上下表格.html" class="cs-navi-tab">系统管理</a></li>
            </ul>
          </li>        
    </ul>
        <!-- ------------------------------------------------------------------------- -->
      </div>
    </div>
  </div>
</div>


</body>
</html>
<script type="text/javascript" src="/assets/js/menu.js"></script>