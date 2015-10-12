<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html lang="en"
	class="app">
<head>
<%@include file="/common/common.jspf"%>
<script type="text/javascript" src="${ctx}/js/system/user/updatePassword.js"></script>
<script type="text/javascript">
	$(function() {
		var tb = $("#loadhtml");
		tb.html(CommnUtil.loadingImg());
		tb.load(rootPath+"/monitor/monitor.shtml");
		$("[nav-n]").each(function () {
				$(this).bind("click",function(){
						var nav = $(this).attr("nav-n");
						var sn = nav.split(",");
						var html = '<li><i class="fa fa-home"></i>';
						html+='<a href="index.shtml">Home</a></li>';
						for(var i=0;i<2;i++){
							html+='<li><a href="javascript:void(0)">'+sn[i]+'</a></li>';
						}
						$("#topli").html(html);
						var tb = $("#loadhtml");
						tb.html(CommnUtil.loadingImg());
						tb.load(rootPath+sn[2]);
				});
			});
		});
</script>
</head>
<body class="" style="">
	<section class="vbox">
		<header class="bg-dark dk header navbar navbar-fixed-top-xs">
			<div class="navbar-header aside-md" >
				<a class="btn btn-link visible-xs"
					data-toggle="class:nav-off-screen,open" data-target="#nav,html">
					<i class="fa fa-bars"></i>
				</a> <a href="index.shtml#" class="navbar-brand"
					data-toggle="fullscreen"><img
					src="${ctx}/notebook/notebook_files/logo.png" class="m-r-sm">MENU</a>
				<a class="btn btn-link visible-xs" data-toggle="dropdown"
					data-target=".nav-user"> <i class="fa fa-cog"></i>
				</a>
			</div>
			
			<ul class="nav navbar-nav navbar-right m-n hidden-xs nav-user">
				<li class="hidden-xs"><a href="index.html#"
					class="dropdown-toggle dk" data-toggle="dropdown"> <i
						class="fa fa-bell"></i> <span
						class="badge badge-sm up bg-danger m-l-n-sm count"
						style="display: inline-block;">3</span>
				</a>
					<section class="dropdown-menu aside-xl">
						<section class="panel bg-white">
							<header class="panel-heading b-light bg-light">
								<strong>您有 <span class="count" style="display: inline;"></span> 条消息</strong>
							</header>
							<div class="list-group list-group-alt animated fadeInRight">
								<a href="index.html#" class="media list-group-item" style="display: block;">
									<span class="pull-left thumb-sm text-center">
										<i class="fa fa-envelope-o fa-2x text-success"></i>
									</span>
									<span class="media-body block m-b-none">
										Sophi sent you a email<br>
										<small class="text-muted">1 minutes ago</small>
									</span>
								</a>
								<a href="index.html#" class="media list-group-item"> 
									<span class="pull-left thumb-sm">
										<img src="${ctx}/notebook/notebook_files/avatar.jpg" alt="John said" class="img-circle">
									</span> 
									<span class="media-body block m-b-none"> 
										Use awesome animate.css<br> 
										<small class="text-muted">10 minutes ago</small>
									</span>
								</a> 
								<a href="index.html#" class="media list-group-item"> 
									<span class="media-body block m-b-none"> 
										1.0 initial released<br>
										<small class="text-muted">1 hour ago</small>
									</span>
								</a>
							</div>
							<footer class="panel-footer text-sm">
								<a href="index.html#notes" data-toggle="class:show animated fadeInRight">所有消息</a>
							</footer>
						</section>
					</section>
				</li>
				<li class="dropdown"><a href="index.html#"
					class="dropdown-toggle" data-toggle="dropdown"> <span
						class="thumb-sm avatar pull-left"> <img
							src="${ctx}/notebook/notebook_files/avatar.jpg">
					</span> ${userFormMap.accountName} <b class="caret"></b>
				</a>
					<ul class="dropdown-menu animated fadeInRight">
						<span class="arrow top"></span>
						<li><a href="#" onclick="javascript:updatePasswordLayer();">密码修改</a></li>
						<li><a href="#"> 
						<span class="count badge bg-danger pull-right" style="display: inline;"></span> 消息
						</a></li>
						<li class="divider"></li>
						<li><a href="logout.shtml">退出</a></li>
					</ul></li>
			</ul>
		</header>
		<section>
			<section class="hbox stretch">
				<!-- .aside -->
				<aside class="bg-dark lter aside-md hidden-print hidden-xs" id="nav">
					<section class="vbox">
						<section class="w-f scrollable">
							<div class="slim-scroll" data-height="auto"
								data-disable-fade-out="true" data-distance="0" data-size="5px"
								data-color="#333333">
								<!-- nav -->
								<nav class="nav-primary hidden-xs">
									<ul class="nav">
										<c:forEach var="key" items="${list}" varStatus="s">
											<!-- <li class="active"> 某一项展开-->
											<li <c:if test="${s.index==0}">class="active"</c:if>><a
												href="javascript:void(0)"
												<c:if test="${s.index==0}">class="active"</c:if>> <c:if
														test="${s.index==0}">
														<i class="fa fa-dashboard icon"> <b class="bg-danger"></b>
														</i>
													</c:if> <c:if test="${s.index==1}">
														<i class="fa fa-pencil-square icon"> <b
															class="bg-warning"></b>
														</i>
													</c:if> <c:if test="${s.index==2}">
														<i class="fa fa-columns icon"> <b class="bg-primary"></b>
														</i>
													</c:if> <c:if test="${s.index==3}">
														<i class="fa fa-book icon"> <b class="bg-info"></b>
														</i>
													</c:if> <c:if test="${s.index==4}">
														<i class="fa fa-th-list icon"> <b class="bg-success"></b>
														</i>
													</c:if> <span class="pull-right"> <i
														class="fa fa-angle-down text"></i> <i
														class="fa fa-angle-up text-active"></i>
												</span> <span>${key.name}</span>
											</a>

												<ul class="nav lt">
													<c:forEach var="kc" items="${key.children}">
														<li class="active"><a
															href="javascript:void(0)"
															class="active" nav-n="${key.name},${kc.name},${kc.resUrl}?id=${kc.id}"> <i class="fa fa-angle-right"></i> <span>${kc.name}</span>
														</a></li>
													</c:forEach>
												</ul></li>
										</c:forEach>
									</ul>
								</nav>
								<!-- / nav -->
							</div>
						</section>
						<footer class="footer lt hidden-xs b-t b-dark">
							<a href="#nav" data-toggle="class:nav-xs"
								class="pull-right btn btn-sm btn-dark btn-icon"> <i
								class="fa fa-angle-left text"></i> <i
								class="fa fa-angle-right text-active"></i>
							</a>
						</footer>
					</section>
				</aside>
				<!-- /.aside -->
				 <section id="content">
					<section id="id_vbox" class="vbox">
						<ul class="breadcrumb no-border no-radius b-b b-light" id="topli">
						</ul>
						<section class="scrollable" style="margin-top: 35px;">
						<div id="loadhtml"></div>
						</section>
					</section>
				</section>
			</section>
		</section>
	</section>
	<!-- Bootstrap -->
</body>
</html>