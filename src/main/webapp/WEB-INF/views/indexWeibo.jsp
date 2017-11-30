<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>我的首页-微博 随时随地发现新鲜事</title>
	<link rel="shortcut icon" type="image/x-icon" href="http://weibo.com/favicon.ico" />
	<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/1.6.4/jquery.min.js"></script>
	<script type="text/javascript" src="/assets/javascript/index.js"></script>
	<link rel="stylesheet" type="text/css" href="/assets/css/reset.css"/>
	<link rel="stylesheet" type="text/css" href="/assets/css/index.css"/>
	<link rel="stylesheet" type="text/css" href="/assets/css/Font-Awesome-3.2.1/css/font-awesome.min.css"/>
</head>
<body>
	<div class="wrapper">
		<div class="content-center clearfix">
			<div style="visibility: hidden;width:140px;height: 1px;float:left;">&nbsp;</div>
			<div class="menu">
				<ul>
					<li><a href="">首页</a></li>
					<li><a href="">我的收藏</a></li>
					<li><a href="">我的赞</a></li>
				</ul>
				<ul class="hot">
					<li><a href=""><i class="icon-fire"></i>&nbsp;热门微博</a><em></em></li>
					<li class="cog"><i class="icon-cog"></i></li>
				</ul>
				<ul>
					<li><a href=""><i class="icon-heart-empty"></i>&nbsp;好友圈</a></li>
					<li><a href="">群微博</a></li>
					<li><a href="">特别关注</a></li>
					<li><a href="">小学</a></li>
					<li><a href="">校友</a></li>
					
				</ul>

			</div>
			<div class="m-list">
				<div class="send">
					<textarea class="content"></textarea>
					<input class="btn" type="button" />
				</div>
				<div class="w-list">
					
					
				</div>
				<div class="page-info">
					<span>当前第${pi.current }页/共${pi.count }条/${pi.total }页</span>
					
					<c:if test="${pi.current gt 1 }">
						<a href="?current=1"">首页</a>
						<a href="?current=${pi.current - 1 }">上一页</a>
					</c:if>
					
					<c:if test="${pi.current lt pi.total }">
						<a href="?current=${pi.current + 1 }">下一页</a>
						<a href="?current=${pi.total }">尾页</a>
					</c:if>
				</div>
			</div>
			<div class="nav">
				<c:set var="account" value="${sessionScope.account }" />
				<div class="myinfo">
					<div class="person-info">
						
						<img src="/assets/image/${account.pic }">
					</div>
					<div class="innerwrap">
						<h3><a>${account.nickName }</a></h3>
						<ul class="clearfix">
							<li>
								<a href="/u/follow">
								<strong>${account.follow }</strong>
								<span>关注</span>
								</a>
							</li>
							<li>
								<a href="">
									<strong>
										${account.fans }
									</strong>
									<span>
										粉丝
									</span>
								</a>
							</li>
							<li class="last">
							<a href="">
							<strong>${account.weibo }</strong>
							<span>微博</span>
							</a>
							</li>
						</ul>

					</div>
				</div>
			</div>
			
		</div>
	</div>
	<script type="text/javascript">

		WEIBO.init({
			aid:${account.aid},
			current:1
		});

	
	</script>
</body>
</html>