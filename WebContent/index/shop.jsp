﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 页面初始化加载，判断session是否存在鲜花类别的值 -->
 <c:if test="${sessionScope.flowerType eq null }">
<script>location.href="/Rosemary/flower.do?op=queryFlowerType";</script>
</c:if> 
<!-- 页面初始化加载，判断session是否存在分页鲜花的值 -->
 <%-- <c:if test="${sessionScope.FlowerInfo eq null }">
<script>location.href="/Rosemary/flower.do?op=queryFlowerInfoByPage";</script>
</c:if>   --%>
<html>

<head>
<meta charset="utf-8">
<title>店铺</title>
<meta name="description" content="">
<meta name="author" content="">
<meta name="keywords" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Mobile Specific Meta  -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- Google Fonts -->
<link
	href='https://fonts.googleapis.com/css?family=Lato:400,300,700,900,100'
	rel='stylesheet' type='text/css'>

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/font-awesome.min.css" />
<!-- Custom CSS -->
<link href="style.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="layui/css/layui.css" />


</head>

<body>


	<!-- header-start -->
	<%@ include file="headhav.jsp"%>
	<!-- header-end -->
	<!-- heading-banner-start -->
	<div class="heading-banner">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-xs-12">
					<div class="breadcrumb">
						<a title="Return to Home" href="index.html"> <i
							class="icon-home"></i>
						</a> <span class="navigation-page"> <span
							class="navigation-pipe">></span> Shop
						</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- heading-banner-end -->
	<!-- shop-area-start -->
	<div class="shop-area">
		<div class="container">
			<div class="ro w">
				<div class="col-md-3 col-sm-3 col-xs-12">
					<div class="shop-left-col wow fadeIn" data-wow-duration=".5s"
						data-wow-delay=".5s">
						<div class="content-box">
							<h2>鲜花类别</h2>
							<ul>
								 <c:forEach var="flowerType" items="${sessionScope.flowerType }">
							
							<li ><label class="check-label"> <a href="javascript:void(0);" id="${flowerType.typeId}" class="flowerType">${flowerType.typeName}</a>
								</label></li>
							</c:forEach> 


							</ul>
						</div>
						<div class="content-box">
							<h2>价格</h2>
							<div class="info_widget">
								<div class="price_filter">
									<div id="slider-range"></div>
									<div class="price_slider_amount">
										<input type="text" id="amount" name="price"
											placeholder="Add Your Price"  /> <input type="submit"
											value="范围" >
									</div>
								</div>
							</div>
						</div>


						<div class="content-box">
							<h2>标签</h2>
							<ul class="tags">
								<li><a href="#">香槟玫瑰</a></li>
								<li><a href="#">粉色洋桔梗</a></li>
								<li><a href="#">戴安娜粉玫瑰</a></li>
								<li><a href="#">粉百合</a></li>
								<li><a href="#">紫色小雏菊</a></li>
								<li><a href="#">红色康乃馨</a></li>
								<li><a href="#">白色郁金香</a></li>
								<li><a href="#">白色多头香水百合</a></li>
								<li><a href="#">粉色满天星</a></li>
								<li><a href="#">红色扶郎</a></li>
								<li><a href="#">浅香槟玫瑰</a></li>
								<li><a href="#">金枝玉叶玫瑰</a></li>
								<li><a href="#">明亮向日葵</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<div class="shop-right-col wow fadeIn" data-wow-duration=".5s"
						data-wow-delay=".5s">
						<div class="category-products">
							<div class="topbar-category">
								<div class="pager-area">
									<div>
										<!-- Nav tabs -->
										<ul class="shop-tab">
											<li role="presentation" class="active"><a
												href="#gried_view" role="tab" data-toggle="tab"> <i
													class="fa fa-th-large"></i></a></li>
											<li role="presentation"><a href="#list_view" role="tab"
												data-toggle="tab"> <i class="fa fa-th-list"></i></a></li>
										</ul>
									</div>
								</div>
								<div class="sort-by hidden-xs">
									<label>排序方式</label> <select id="sort">
										<option value="#">最低价格</option>
										<option value="#">最高价格</option>
										<option value="#">鲜花名从A-Z</option>
										<option value="#">鲜花名从Z-A</option>
										<option selected="selected" value="#"></option>
									</select>
								</div>
								
								
							</div>
							<div class="shop-category-product">
								<div class="row">
									<div class="category-product">
										<!-- Tab panes -->
										<div class="tab-content">
											<div role="tabpanel"
												class="tab-pane active fade in flower-show" id="gried_view">
												<!-- 商品展示区域 -->

											</div>
											<!-- 分页区域 -->
										
										<!-- 分页结束 -->
  										</div>
  										
									</div>
									
								</div>
								<div id="pageDiv"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- shop-area-end -->

	<!-- footer-start -->
	<%@ include file="foot.jsp"%>
	<!-- footer-end -->
	<!-- Modal -->
	
	<!-- modal-end -->
	<!-- all js here -->
	<!-- jquery latest version -->
	<script src="js/vendor/jquery-1.12.0.min.js "></script>
	<!-- bootstrap js -->
	<script src="js/bootstrap.min.js "></script>
	<!-- owl.carousel js -->
	<script src="js/owl.carousel.min.js "></script>
	<!-- meanmenu js -->
	<script src="js/jquery.meanmenu.js "></script>
	<!-- countdown js -->
	<script src="js/countdown.js "></script>
	<!-- jquery.nivo.slider.pack js -->
	<script src="js/jquery.nivo.slider.pack.js "></script>
	<!-- jquery-ui.min.js -->
	<script src="js/jquery-ui.min.js "></script>
	<!-- wow js -->
	<script src="js/wow.min.js "></script>
	<!-- plugins js -->
	<script src="js/plugins.js "></script>
	<!-- main js -->
	<script src="js/main.js "></script>
	<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
		
	</script>
	 <script type="text/javascript" src="layui/layui.js">
			
		</script> 
 <script src="js/flowershow.js" type="text/javascript" charset="utf-8"><!--页面显示的JS文件（小谢） -->
		 
		
		
 </script> 
	<!-- 分页脚本 -->
	
</body>
</html>
















