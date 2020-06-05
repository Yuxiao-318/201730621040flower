<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page autoFlush="true" buffer="1200kb"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>type</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<%-- ${pageContext.request.contextPath}/ --%>
<!-- Bootstrap Core CSS -->
<link href="${pageContext.request.contextPath}/admin/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/admin/css/style.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/morris.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/layui/css/layui.css" />
<link rel="stylesheet" type="text/css" href="layui/css/layui.css" />
<!-- Graph CSS -->
<link href="${pageContext.request.contextPath}/admin/css/font-awesome.css" rel="stylesheet">
<!-- jQuery -->
<script src="${pageContext.request.contextPath}/admin/js/jquery-2.1.4.min.js"></script>
<!-- //jQuery -->
<!-- tables -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/css/table-style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/css/basictable.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery.basictable.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#table').basictable(); 

		$('#table-breakpoint').basictable({
			breakpoint : 768
		});

		$('#table-swap-axis').basictable({
			swapAxis : true
		});

		$('#table-force-off').basictable({
			forceResponsive : false
		});

		$('#table-no-resize').basictable({
			noResize : true
		});

		$('#table-two-axis').basictable();

		$('#table-max-height').basictable({
			tableWrapper : true
		});
	});
</script>
<!-- //tables -->
<link
	href='http://fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400'
	rel='stylesheet' type='text/css' />
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>
<!-- lined-icons -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/icon-font.min.css" type='text/css' />
<!-- //lined-icons -->
</head>

<body>
	<div class="page-container">
		<!--/content-inner-->
		<div class="left-content">
			<div class="mother-grid-inner">
				<!--header start here-->
				<%@ include file="headnav.jsp"%>
				<!--heder end here-->
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="index.html">后台首页</a><i
						class="fa fa-angle-right"></i>商品管理<i class="fa fa-angle-right"></i>商品类型管理</li>
				</ol>
				<div class="agile-grids">
					<!-- tables -->

					<div class="agile-tables">
						<div class="w3l-table-info">
							<h2>鲜花类型</h2>
							<table class="layui-table ">
									<tr>
										<th>编号</th>
										<th>类型名</th>
										<th>创建时间</th>
										<th>更新时间</th>
										<th>操作</th>
									</tr>
									<tbody>
						<c:if test="${sessionScope.pdt==null }">
				             <jsp:forward page="../type.do?op=queryTypes"></jsp:forward>
			              </c:if>
											<c:forEach items="${sessionScope.pdt.data}" var="type"> 

												<tr class="table-row">													
													<td class="table-text"><h6>${type.typeId}</h6></td>
													<td class="table-text"><h6>${type.typeName}</h6></td>
													<td><span class="fam">${type.createTime}</span></td>
													<td><span class="fam">${type.updateTime}</span></td>

													<td>
													<button class="layui-btn layui-btn-radius layui-btn-normal" id="update" name="update"
															style="margin-left: 20%;">编辑</button>
														
														<button class="layui-btn layui-btn-radius layui-btn-danger" id="delete" name="delete">删除</button>
													</td>
												</tr>
											 </c:forEach>
									</tbody>
								</table>
								
						</div>

						<!---728x90--->

						<div id="pageDiv" style="text-align: center"></div>

					</div>
					<!-- //tables -->

				</div>
				<!-- script-for sticky-nav -->
				<script>
					$(document).ready(function() {
						var navoffeset = $(".header-main").offset().top;
						$(window).scroll(function() {
							var scrollpos = $(window).scrollTop();
							if (scrollpos >= navoffeset) {
								$(".header-main").addClass("fixed");
							} else {
								$(".header-main").removeClass("fixed");
							}
						});

					});
				</script>
				<!-- /script-for sticky-nav -->
				<!--inner block start here-->
				<div class="inner-block"></div>
				<!--inner block end here-->
				<!--copy rights start here-->
				<%@ include file="foot.jsp"%>
				<!--COPY rights end here-->
			</div>
		</div>
		<!--//content-inner-->
		<!--/sidebar-menu-->
		<%@ include file="left.jsp"%>
		<div class="clearfix"></div>
	</div>
	<!-- script-for sticky-nav -->
	<script>
		$(document).ready(function() {
			var navoffeset = $(".header-main").offset().top;
			$(window).scroll(function() {
				var scrollpos = $(window).scrollTop();
				if (scrollpos >= navoffeset) {
					$(".header-main").addClass("fixed");
				} else {
					$(".header-main").removeClass("fixed");
				}
			});

		});
	</script>
	
	<div class="clearfix"></div>
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/admin/js/jquery.nicescroll.js"></script>
	<script src="${pageContext.request.contextPath}/admin/js/scripts.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="${pageContext.request.contextPath}/admin/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/admin/layui/layui.js" charset="utf-8"></script>
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script type="text/javascript" src="layui/layui.js" charset="utf-8"></script>

	<!-- /Bootstrap Core JavaScript -->
	<script>
	/* 分页 */
		 layui.use([ 'laypage', 'layer' ], function() {
			var laypage = layui.laypage, layer = layui.layer;
			//完整功能 
			laypage.render({
			    elem: 'pageDiv'
			    ,count:${pdt.total} ,
			    curr:${pdt.page}
			   ,limit:${pdt.pageSize}
			    ,layout: ['count', 'prev', 'page','limit','next', 'skip']
			    ,jump: function(obj,first){
					//首次不执行
					if (!first) {
						//do something
						location.href = "/Rosemary/type.do?op=queryTypes&page="
								+ obj.curr + "&pageSize=" + obj.limit
								+ "&keywords="
								+ document.getElementById("keywords").value;
					}
				}
			});
		}); 	
	
			<!-- 点击搜索框旁的搜索按钮的单击 -->
			$("#search").click(function(){
				 location.href = "/Rosemary/type.do?op=queryTypes&page="
						+ ${pdt.total}+ "&pageSize=" + ${pdt.total}
						+ "&keywords="
						+ document.getElementById("keywords").value;
						document.getElementById("keywords").text("");
			});
			
	</script>
	
	<script type="text/javascript">

	layui.use([ 'laypage', 'layer' ], function() {
			var laypage = layui.laypage, layer = layui.layer;});
	/* 编辑按钮事件 */
$(".layui-btn-normal").click(
	function() {
	var msg="";
	//获取当前行的第一个td
    var typeId = $(this).parents("tr").find("td").eq(0).text();
	var typeName = $(this).parents("tr").find("td").eq(1).text();
	var createTime = $(this).parents("tr").find("td").eq(2).text();
	var updateTime = $(this).parents("tr").find("td").eq(3).text();

					layer.open({
								type : 1,
								title : "更改类型",
								anim : 1,
								area : [ '400px', '370px' ],
								offset : "auto",
								shadeClose : true,
								closeBtn : 1,
								content : "<div class='modal-body'> 编号： <input type='text' disabled='disabled' name='typeId' id='typeId' style='width:230px;height:30px; margin-left:40px;margin-bottom:20px;' value=''></div>"
								+"<div class='modal-body'> 类名: <input type='text' name='typeName' id='typeName' style='width:230px;height:30px;margin-left:50px;margin-bottom:30px;' value=''> </br>" 									
								+"<button class='layui-btn layui-btn-lg layui-btn-radius layui-btn-normal' style='margin-left:20%;margin-right:20px;' id='uptype' name='uptype'>更新</button>"
								+"<button class='layui-btn layui-btn-lg layui-btn-radius layui-btn-normal' margin-top:100px; id='close'>取消</div>"
							});
					//用jq代码信息显示在content元素中
					$("#typeId").val(typeId);
					$("#typeName").val(typeName);
					
		$("#uptype").click(function name() {																
					//获取当前类型编号
					var typeId = $("#typeId").val();
					//获取输入的用户名
					var typeName = $("#typeName").val();						
					$.get("/Rosemary/type.do",
							"op=updType&typeId=" + typeId + "&typeName="
									+ typeName, function(data, status) {										
								layer.open({
									title : "温馨提醒",
									skin : "layui-layer-molv",
									content : "<span style='color:black;'>" + data+ "</span>",
									anim : 0,
									btn : [ 'OK' ],
									yes : function(index, layero) {
										layer.closeAll();
										location.href = "/Rosemary/type.do?op=queryTypes";
									}
								}); 
							}); 														
					});								
				});	
	</script>
	
	<script type="text/javascript">
	/* 删除 */
	 layui.use([ 'laypage', 'layer' ], function() {
			var laypage = layui.laypage, layer = layui.layer;});	
	$("#delete").click(function () {
			//获取当前行的第一个tr的td
			var typeId = $(this).parents("tr").find("td").eq(0).text();
            layer.open({
				title: "温馨提示",
				skin: "layui-layer-molv",
				content: "<span style='color:black;'>删除后将无法恢复数据，您确定要删除吗？</span>",
				anim: 0,
				btn: ['OK','NOT'],
				yes: function(index, layero) {
					$.get("/Rosemary/type.do","op=delType&typeId="+typeId,function(data,status){
						if(data="类型删除成功"){
						layer.open({
								title: "友情提醒",
								skin: "layui-layer-molv",
								content: "<span style='color:black;'>"+data+"</span>",
								anim: 0,
								btn: ['OK'],
								yes: function(index, layero) {
									location.href="/Rosemary/type.do?op=queryTypes";
								}
								
							});
						}
					});
				},
				btn2:function(index,layero){
					location.href="/Rosemary/type.do?op=queryTypes";
				}
			}); 		
	});
	</script>
		
	
</body>

</html>