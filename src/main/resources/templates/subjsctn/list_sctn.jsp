<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN" xmlns:th="http://www.thymeleaf.org">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>查询页面</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<!-- Bootstrap 3.3.7 -->
		<link rel="stylesheet" href="../static/bower_components/bootstrap/dist/css/bootstrap.min.css">

		<!-- Theme style -->
		<link rel="stylesheet" href="../static/dist/css/AdminLTE.min.css">
		<!-- AdminLTE Skins. Choose a skin from the css/skins
	       folder instead of downloading all of them to reduce the load. -->
		<link rel="stylesheet" href="../static/dist/css/skins/_all-skins.min.css">

		<style>
			/*表格条件查询的样式  */
			
			.box-header {
				display: flex;
			}
			
			.box-header .box-search {
				max-width: 300px;
				padding-right: 10px;
			}
			
			.box-header .box-search:last-child {
				margin-left: auto;
			}
			/*表格中td的样式 */
			
			.box-body table th {
				text-align: center;
			}
			
			.box-body table td {
				text-align: center;
			}
			
			.modal-body .form-group {
				display: flex;
			}
			
			.modal-body .form-group>input {
				display: block;
				width: 100%;
				height: 34px;
				padding: 6px 12px;
				font-size: 14px;
				line-height: 1.42857143;
				color: #555;
				background-color: #fff;
				background-image: none;
				border: 1px solid #ccc;
				border-radius: 4px;
				-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
				box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
				-webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow ease-in-out .15s;
				-o-transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
				transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
			}
			
			.modal-body .form-group>input:focus {
				border-color: #66afe9;
				outline: 0;
				-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px rgba(102, 175, 233, .6);
				box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px rgba(102, 175, 233, .6);
			}
			
			.modal-body .form-group>label {
				padding-right: 5px;
			}
			
			.content-wrapper {
				margin-left: 0px;
			}
			
			.qstnTitle img{display: none;}
			
			@media only screen and (max-width: 768px) {
				.box-header{
					flex-direction: column;
				}
				.box-header .box-search{
					margin: 10px auto;
				}
			}
		</style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <h1>
         	知识节查询
        </h1>
        <ol class="breadcrumb">
          <li><a href="#"><i class="fa fa-dashboard"></i> 知识节</a></li>
          <li class="active"><a href="#">知识节查询</a></li>
        </ol>
      </section>
  
      <!-- Main content -->
     
     	 <section class="content">
        <div class="box">
         <form name="infoForm" id="queryForm" method="post" >
        	<div class="box-header clearfix">
				<div class="box-search">
					<div class="input-group">
						<span class="input-group-addon" style="background: #EEEEEE;">客户姓名</span>
						<input type="text" class="form-control"   value="" name="cusName" placeholder="请输入客户姓名">
					</div>
				</div>
				<div class="box-search">
					<div class="input-group">
						<span class="input-group-addon" style="background: #EEEEEE;">身份证号</span>
						<input type="text" class="form-control" value="" name="cusCardId" placeholder="请输入身份证号">
					</div>
				</div>
				<div class="box-search">
					<div class="input-group">
						<span class="input-group-addon" style="background: #EEEEEE;">客户编号</span>
						<input type="text" class="form-control" value="" name="cusNo" placeholder="请输入客户编号">
					</div>
				</div>
				<div class="box-search btn-group">
					<button class="btn btn-info" name="queryInfo">查询</button>
					<button class="btn btn-primary" name="queryInfo">清空</button>
					<button class="btn btn-success"  type="button" name="queryInfo"  onclick="addPage()" >添加</button>
					<button class="btn btn-warning" name="queryInfo"  onclick="dels()">删除</button>
				</div>
        	</div>
        	</form>
        	<!-- /.box-header -->
        	<div class="box-body no-padding">
        		<table class="table table-striped">
        			<tr>
        				<th>序号</th>
        				<th>全选</th>
        				<th>知识节名称</th>
        				<th>知识节序号</th>
        				<th>知识节代号</th>
						<th>总时长</th>
						<th>操作</th>
        			</tr>
        			<form name="delForm"  method="post"  action="<%=request.getContextPath()%>/subjSctn/dels.action">
        			<button>删除</button>
        			<c:forEach items="${list }" var="scth" varStatus="i">
        			<tr >
        			  <td >${i.count }</td>
        			  <td ><input type="checkbox" name="ids" value="1" value="${scth.subjSctnId }"></td>
        				<td >${scth.subjSctnTitle }</td>
        				<td >${scth.subjSctnNum }</td>
        				<td >${scth.subjSctnCode }</td>
        				<td >${scth.subjSctnVideoLen }</td>
						<td>
							<button type="button" class="btn btn-primary btn-sm" onclick="javascript:editpage('${scth.subjSctnId }')">修改</button>
							<button type="button" class="btn btn-info btn-sm" onclick="javascript:playpage('${scth.subjSctnTitle }','${scth.subjSctnId }')">播放视频</button>
						</td>
        			</tr>
        			</c:forEach>
        			</form>
        		</table>
        	</div>
<!--         	/.box-body -->
			
<!-- 		/. box-footer -->
        </div>
        <!-- /.row -->
      </section>
      <!-- /.content -->
    </div>

</div>
<!-- ./wrapper -->
</body>
	<!-- jQuery 3 -->
	<script src="../static/bower_components/jquery/dist/jquery.min.js"></script>
	<!-- jQuery UI 1.11.4 -->
	<script src="../static/plugins/jQueryUI/jquery-ui.min.js"></script>
	<!-- Bootstrap 3.3.7 -->
	<script src="../static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- AdminLTE App -->
	<script src="../static/dist/js/adminlte.min.js"></script>

	<!-- bootbox -->
	<script src="../static/bower_components/bootbox/js/bootbox.js"></script>
	
	<script type="text/javascript">
	  $.widget.bridge('uibutton', $.ui.button);

	  
	function addPage(){
		location.href = "<%=request.getContextPath()%>/subjSctn/addPage.action"; 
	}

	function editpage(id){
		location.href = "<%=request.getContextPath()%>/subjSctn/editPage.action?subjSctnId=" + id; 
	}
	
	function dels(){

		if(window.confirm("确定要删除吗?")){
			document.delForm.submit();
		}
	}
	
	function playpage(title, id){
		 bootbox.dialog({
			  // dialog的内容
			  message: "<iframe src='<%=request.getContextPath()%>/subjSctn/videoPlay.action?subjSctnId=" + id + "' style='width:100%;height:369px;border:0 solid;'></iframe>",
			   
			  // dialog的标题
			  title: title,
			   
			  // 是否显示此dialog，默认true
			  show: true,

			     // 显示尺寸，可选 small  /large
			 size: "large",

			  // 是否显示body的遮罩，默认true
			  backdrop: true,
			   
			  // 是否显示关闭按钮，默认true
			  closeButton: true,
			   
			  // 是否动画弹出dialog，IE10以下版本不支持
			  animate: true,
			   
			  // dialog的类名
			  className: "my-modal",
			   
			});
	}

</script>

</html>