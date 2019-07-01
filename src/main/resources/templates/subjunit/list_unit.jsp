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
         	知识章查询
        </h1>
        <ol class="breadcrumb">
          <li><a href="#"><i class="fa fa-dashboard"></i> 知识章</a></li>
          <li class="active"><a href="#">知识章查询</a></li>
        </ol>
      </section>
  
      <!-- Main content -->
     
     	 <section class="content">
        <div class="box">
         <form name="infoForm" id="queryForm" method="post" >
        	<div class="box-header clearfix">
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
        				<th>知识章名称</th>     				
        				<th>所属科目</th>
        				<th>知识章序号</th>
        				<th>知识章代号</th>
        				<th>知识章说明</th>
						<th>操作</th>
        			</tr>
        			<form name="delForm"  method="post"  action="<%=request.getContextPath()%>/subjUnit/dels.action" >
        		
        			<c:forEach items="${list }" var="unit" varStatus="i">
        			<tr >
        			  <td >${i.count }</td>
        			  <td ><input type="checkbox" name="ids" value="1" value="${unit.subjUnitId }"></td>
        				<td >${unit.subjUnitTitle }</td>
        				<td >${unit.subjTitle }</td>
        				<td >${unit.subjUnitNum }</td>
        				<td >${unit.subjUnitCode }</td>
        				<td >${unit.subjUnitInfo }</td>
						<td>
							<button type="button" class="btn btn-primary btn-sm" onclick="javascript:editpage('${unit.subjUnitId }')">修改</button>
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
		location.href = "<%=request.getContextPath()%>/subjUnit/addPage.action"; 
	}

	function editpage(id){
		location.href = "<%=request.getContextPath()%>/subjSctn/editPage.action?subjSctnId=" + id; 
	}
	
	function dels(){
		var ids = $("[name=ids]:checked");
		if(ids.length==0){
			alert("请选择要删除记录!");
			return;
		}
		
		if(window.confirm("确定要删除吗?")){
			document.delForm.submit();
		}
	}

</script>

</html>