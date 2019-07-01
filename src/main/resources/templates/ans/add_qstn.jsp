<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN" xmlns:th="http://www.thymeleaf.org">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>添加页面</title>
		<!-- Tell the browser to be responsive to screen width -->
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<!-- Bootstrap 3.3.7 -->
		<link rel="stylesheet" href="<%=request.getContextPath() %>/static/bower_components/bootstrap/dist/css/bootstrap.min.css">
		<!-- Theme style -->
		<link rel="stylesheet" href="<%=request.getContextPath() %>/static/dist/css/AdminLTE.min.css">
		<!-- AdminLTE Skins. Choose a skin from the css/skins
	       folder instead of downloading all of them to reduce the load. -->
		<link rel="stylesheet" href="<%=request.getContextPath() %>/static/dist/css/skins/_all-skins.min.css">
		
		<link rel="stylesheet"  type="text/css"  href="<%=request.getContextPath() %>/simditor/styles/simditor.css">
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
		</style>
	</head>

	<body class="hold-transition skin-blue sidebar-mini">
		<div class="wrapper">

			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper">
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h1>
			          	试题添加
			        </h1>
			        <ol class="breadcrumb">
						<li>
							<a href="<%=request.getContextPath() %>/common/dashboard.html"><i class="glyphicon glyphicon-globe"></i>导航</a>
						</li>
						<li class="active">
							<a href="#">试题添加</a>
						</li>
					</ol>
				</section>

				<!-- Main content -->
				<section class="content">
					<div class="row">
						<form class="form form-horizontal" method="get"   onsubmit="contextTextOnblur()"  action="<%=request.getContextPath() %>/qstn/addSave.action">
							<!-- left column -->
							<div class="col-md-10 col-md-offset-1">
								<!-- general form elements -->
								<div class="box box-primary">
									<div class="box-header with-border">
										<h3 class="box-title">基本信息</h3>
									</div>
									<!-- /.box-header -->
									<!-- form start -->
									<div class="box-body">
										<div class="form-group">
											<label for="name" class="col-sm-2 control-label">试题内容:</label>
											<div class="col-sm-10">
											   <textarea id="editor" type="text/plain"   hidden="true" autofocus></textarea>
											   <input type="hidden"  id="titleContent" name="qstnTitle"   >
											</div>
										</div>

										<div class="form-group">
											<label for="birth" class="col-sm-2 control-label">试题类型</label>
											<div class="col-sm-4">
												<select class="form-control" name="qstnTypeId">
													<option value="">请选择</option>
													<c:forEach items="${qstnTypeList }" var="qstnType">
														<option value="${qstnType.qstnTypeId }">${qstnType.qstnTypeName }</option>
													</c:forEach>
												</select>
											</div>
											<label for="birth" class="col-sm-2 control-label">试题来源</label>
											<div class="col-sm-4">
												<select class="form-control" name="qstnFromTypeId">
													<option value="">请选择</option>
													<c:forEach items="${qstnFromList}" var="qstnFrom">
														<option value="${qstnFrom.qstnFromTypeId }">${qstnFrom.qstnFromTypeCode }</option>
													</c:forEach>
												</select>
											</div>
										</div>

										<div class="form-group">
											<label for="birth" class="col-sm-1 control-label">科目单元</label>
											<div class="col-sm-3">
												<select class="form-control"  onchange="selectSubj(this.value)" >
													<option value="">请选择</option>
													<c:forEach items="${subjList}" var="subj">
														<option value="${subj.subjId }">${subj.subjTitle }</option>
													</c:forEach>
												</select>
											</div>
											<label for="birth" class="col-sm-1 control-label">知识章</label>
											<div class="col-sm-3">
												<select class="form-control" onchange="selectUnit(this.value)"  id="unitSelect">
													<option value="">请选择</option>
													<c:forEach items="${subjUnitList}" var="unit">
														<option value="${unit.subjUnitId }">${unit.subjUnitTitle }</option>
													</c:forEach>
												</select>
											</div>
											<label for="birth" class="col-sm-1 control-label">知识节</label>
											<div class="col-sm-3">
												<select class="form-control" name="subjSctnId"  id="sctnSelect">
													<option value="">请选择</option>
													<c:forEach items="${subjSctnList}" var="subjSctn">
														<option value="${subjSctn.subjSctnId }">${subjSctn.subjSctnTitle }</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group">
											<label for="name" class="col-sm-2 control-label">试题说明:</label>
											<div class="col-sm-10">
											   	<textarea id="editor2" type="text/plain"   hidden="true" autofocus></textarea>
												<input type="hidden" id="pictextContent"  name="qstnPictext" >
											</div>
										</div>
									</div>
									<!-- /.box-body -->
									<div class="box-footer">
										<button type="button" class="btn btn-default" onclick="javascript:history.back()">返回</button>
										<button type="submit" class="btn btn-info pull-right">提交</button>
									</div>
									<!-- /.box-footer -->
								</div>
								<!-- /.box -->
								<!-- /.modal -->
							</div>
							<!--/.col (right) -->
						</form>
					</div>
					<!-- /.row -->
				</section>
				<!-- /.content -->
			</div>
			<!-- /.content-wrapper -->

		</div>
	</body>
	<!-- jQuery 3 -->
	<script src="<%=request.getContextPath() %>/static/bower_components/jquery/dist/jquery.min.js"></script>
	<!-- jQuery UI 1.11.4 -->
	<script src="<%=request.getContextPath() %>/static/plugins/jQueryUI/jquery-ui.min.js"></script>
	<!-- Bootstrap 3.3.7 -->
	<script src="<%=request.getContextPath() %>/static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

	<!-- FastClick -->
	<script src="<%=request.getContextPath() %>/static/bower_components/fastclick/lib/fastclick.js"></script>
	<!-- AdminLTE App -->
	<script src="<%=request.getContextPath() %>/static/dist/js/adminlte.min.js"></script>
	
	<script type="text/javascript" src="<%=request.getContextPath() %>/simditor/scripts/module.js"></script>
	  <script type="text/javascript" src="<%=request.getContextPath() %>/simditor/scripts/module.js"></script>
	  <script type="text/javascript" src="<%=request.getContextPath() %>/simditor/scripts/hotkeys.js"></script>
	  <script type="text/javascript" src="<%=request.getContextPath() %>/simditor/scripts/uploader.js"></script>
	  <script type="text/javascript" src="<%=request.getContextPath() %>/simditor/scripts/simditor.js"></script>

	<script type="text/javascript">
		$.widget.bridge('uibutton', $.ui.button);
		
		
		function selectSubj(subjId){
			var url = "<%=request.getContextPath()%>/subjUnit/selectSubj.action";
			$.post(url,{"subjId":subjId},function(resp){
				// unitSelect
				console.log(resp);
				$("#unitSelect").empty();
				$.each(resp, function(i, item){
					$("<option value='" + item.subjUnitId + "'>" + item.subjUnitNum + "." + item.subjUnitTitle + "</option>").appendTo("#unitSelect");
				});
				if(resp.length > 0){
					selectUnit(resp[0].subjUnitId);
				}
				
			});
		}
		
		function selectUnit(unitId){
			var url = "<%=request.getContextPath()%>/subjSctn/selectUnit.action";
			$.post(url,{"unitId":unitId},function(resp){
				// sctnSelect
				console.log(resp);
				$("#sctnSelect").empty();
				$.each(resp, function(i, item){
					$("<option value='" + item.subjSctnId + "'>" + item.subjSctnNum + "." + item.subjSctnTitle + "</option>").appendTo("#sctnSelect");
				});
			});
		}
		
		
	  	function contextTextOnblur() {
			
			var content = editor.getValue();
			$("#titleContent").val(content);
			
			var content2 = editor2.getValue();
			$("#pictextContent").val(content2);
			
		}
	  	
	  	
	 	$(function(){
	        Simditor.locale = 'zh-CN';//设置中文
	        editor = new Simditor({
	            textarea: $("#editor"),  //textarea的id
	            placeholder: '请输入试题内容',
	            toolbar:  ['title', 'bold', 'italic', 'underline', 'strikethrough', 'fontScale', 'color', '|', 'ol', 'ul', 'blockquote', 'code', 'table', '|', 'link', 'image', 'hr', '|', 'indent', 'outdent', 'alignment'], //工具条都包含哪些内容
	            pasteImage: true,//允许粘贴图片
	            defaultImage: '<%=request.getContextPath() %>/simditor/images/image.png',//编辑器插入的默认图片，此处可以删除
	            upload : {
	                url : '<%=request.getContextPath() %>/qstn/uploadSimditorImg.action', //文件上传的接口地址
	                params:  {"type":"title"}, //键值对,指定文件上传接口的额外参数,上传的时候随文件一起提交
	                fileKey:'file', //服务器端获取文件数据的参数名
	                connectionCount: 3,
	                leaveConfirm: '正在上传文件'
	            }
	        });
	        
	        editor2 = new Simditor({
	            textarea: $("#editor2"),  //textarea的id
	            placeholder: '请输入试题说明',
	            toolbar:  ['title', 'bold', 'italic', 'underline', 'strikethrough', 'fontScale', 'color', '|', 'ol', 'ul', 'blockquote', 'code', 'table', '|', 'link', 'image', 'hr', '|', 'indent', 'outdent', 'alignment'], //工具条都包含哪些内容
	            pasteImage: true,//允许粘贴图片
	            defaultImage: '<%=request.getContextPath() %>/simditor/images/image.png',//编辑器插入的默认图片，此处可以删除
	            upload : {
	                url : '<%=request.getContextPath() %>/qstn/uploadSimditorImg.action', //文件上传的接口地址
	                params: {"type":"pictext"}, //键值对,指定文件上传接口的额外参数,上传的时候随文件一起提交
	                fileKey:'file', //服务器端获取文件数据的参数名
	                connectionCount: 3,
	                leaveConfirm: '正在上传文件'
	            }
	        });
	      });
	 	
	 	
	</script>

</html>