<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>初始主界面</title>
</head>
<body>
<%@include file="/WEB-INF/Demo.jsp" %> 
<div id="mainPanle" data-options="region:'center'" border="false" > 
  <!--右部分 start-->
  <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
    <div  class="Iright">
      <div class="mainindex">
        <div class="welinfo"> <span><img src="/assets/images/sun.png" alt="天气" /></span> <b>Admin早上好，欢迎使用信息管理系统</b>(admin@uimaker.com) <a href="#">帐号设置</a> </div>
        <div class="welinfo"> <span><img src="/assets/images/time.png" alt="时间" /></span> <i>您上次登录的时间：2013-10-09 15:22</i> （不是您登录的？<a href="#">请点这里</a>） </div>
        <div class="xline"></div>
        <ul class="iconlist">
          <li><img src="/assets/images/main_manage.png" />
            <p><a href="#">管理设置</a></p>
          </li>
          <li><img src="/assets/images/main_issue.png" />
            <p><a href="#">发布文章</a></p>
          </li>
          <li><img src="/assets/images/main_statistic.png" />
            <p><a href="#">数据统计</a></p>
          </li>
          <li><img src="/assets/images/main_upload.png" />
            <p><a href="#">文件上传</a></p>
          </li>
          <li><img src="/assets/images/main_catalog.png" />
            <p><a href="#">目录管理</a></p>
          </li>
          <li><img src="/assets/images/main_search.png" />
            <p><a href="#">查询</a></p>
          </li>
          <li><img src="/assets/images/main_ shortcut.png" />
            <p><a href="#">添加新的快捷功能</a></p>
          </li>
        </ul>
        <div class="xline"></div>
        <div class="box"></div>
        <div class="page_div">
          <h4><a href="#">通知</a></h4>
          <ul class="infolist">
            <li><a href="#none"><span>2016-10-22</span>公司软件部培训通知</a></li>
            <li><a href="#none"><span>2016-10-22</span>公司软件部培训通知</a></li>
            <li><a href="#none"><span>2016-10-22</span>公司软件部培训通知</a></li>
            <li><a href="#none"><span>2016-10-22</span>公司软件部培训通知</a></li>
            <li><a href="#none"><span>2016-10-22</span>公司软件部培训通知</a></li>
            <li><a href="#none"><span>2016-10-22</span>公司软件部培训通知</a></li>
            <li><a href="#none"><span>2016-10-22</span>公司软件部培训通知</a></li>
            <li><a href="#none"><span>2016-10-22</span>公司软件部培训通知</a></li>
            <li><a href="#none"><span>2016-10-22</span>公司软件部培训通知</a></li>
            <li><a href="#none"><span>2016-10-22</span>公司软件部培训通知</a></li>
          </ul>
        </div>
        <div class="page_div">
          <h4><a href="#">任务处理</a></h4>
          <div class="infolist">
            <table width="100%" class="border_b">
              <tr>
                <th height="30" align="left">任务名称</th>
                <th height="30" align="left">处理人</th>
                <th height="30" align="left">处理状态</th>
              </tr>
              <tr >
                <td ><a class="font_blue" href="#">任务名称任务名称</a></td>
                <td>李某某</td>
                <td><a href="#" class="task_button">处理</a></td>
              </tr>
              <tr >
                <td ><a class="font_blue" href="#">任务名称任务名称</a></td>
                <td>李某某</td>
                <td><a href="#" class="task_button">处理</a></td>
              </tr>
              <tr >
                <td ><a class="font_blue" href="#">任务名称任务名称</a></td>
                <td>李某某</td>
                <td><a href="#" class="task_button">处理</a></td>
              </tr>
              <tr >
                <td ><a class="font_blue" href="#">任务名称任务名称</a></td>
                <td>李某某</td>
                <td><a href="#" class="task_button">处理</a></td>
              </tr>
              <tr >
                <td ><a class="font_blue" href="#">任务名称任务名称</a></td>
                <td>李某某</td>
                <td><a href="#" class="task_button">处理</a></td>
              </tr>
              <tr >
                <td ><a class="font_blue" href="#">任务名称任务名称</a></td>
                <td>李某某</td>
                <td><a href="#" class="task_button">处理</a></td>
              </tr>
              <tr >
                <td ><a class="font_blue" href="#">任务名称任务名称</a></td>
                <td>李某某</td>
                <td><a href="#" class="task_button">处理</a></td>
              </tr>
              <tr >
                <td ><a class="font_blue" href="#">任务名称任务名称</a></td>
                <td>李某某</td>
                <td><a href="#" class="task_button">处理</a></td>
              </tr>
              <tr >
                <td ><a class="font_blue" href="#">任务名称任务名称</a></td>
                <td>李某某</td>
                <td>完成</td>
              </tr>
            </table>
          </div>
        </div>
        <div class="page_div">
          <h4><a href="#">审批项</a></h4>
          <div class="infolist">
            <table width="100%" class="border_b">
              <tr>
                <th height="30" align="left">审批项</th>
                <th height="30" align="left">发起人</th>
                <th height="30" align="left">审批状态</th>
              </tr>
              <tr >
                <td ><a class="font_blue" href="#">任务名称任务名称</a></td>
                <td>李某某</td>
                <td><a href="#" class="task_button">待审批</a></td>
              </tr>
              <tr >
                <td ><a class="font_blue" href="#">任务名称任务名称</a></td>
                <td>李某某</td>
                <td><a href="#" class="task_button">待审批</a></td>
              </tr>
              <tr >
                <td ><a class="font_blue" href="#">任务名称任务名称</a></td>
                <td>李某某</td>
                <td><a href="#" class="task_button">待审批</a></td>
              </tr>
              <tr >
                <td ><a class="font_blue" href="#">任务名称任务名称</a></td>
                <td>李某某</td>
                <td><a href="#" class="task_button">待审批</a></td>
              </tr>
              <tr >
                <td ><a class="font_blue" href="#">任务名称任务名称</a></td>
                <td>李某某</td>
                <td><a href="#" class="task_button">待审批</a></td>
              </tr>
              <tr >
                <td ><a class="font_blue" href="#">任务名称任务名称</a></td>
                <td>李某某</td>
                <td><a href="#" class="task_button">待审批</a></td>
              </tr>
              <tr >
                <td ><a class="font_blue" href="#">任务名称任务名称</a></td>
                <td>李某某</td>
                <td><a href="#" class="task_button">待审批</a></td>
              </tr>
              <tr >
                <td ><a class="font_blue" href="#">任务名称任务名称</a></td>
                <td>李某某</td>
                <td><a href="#" class="task_button">待审批</a></td>
              </tr>
              <tr >
                <td ><a class="font_blue" href="#">任务名称任务名称</a></td>
                <td>李某某</td>
                <td>待审批</td>
              </tr>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
<script type="text/javascript" src="/assets/js/menu.js"></script>