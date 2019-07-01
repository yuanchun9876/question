<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN" xmlns:th="http://www.thymeleaf.org">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>修改页面</title>
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
          				知识节修改
			        </h1>
			        <ol class="breadcrumb">
			          <li><a href="#"><i class="fa fa-dashboard"></i> 知识节</a></li>
			          <li class="active"><a href="#">知识节修改</a></li>
			        </ol>
				</section>

				<!-- Main content -->
				<section class="content">
					<div class="row">
						<form class="form form-horizontal" method="post"   enctype="multipart/form-data"  action="<%=request.getContextPath() %>/subjSctn/addSave.action"  >
							<!-- left column -->
							<div class="col-md-8 col-md-offset-2">
								<!-- general form elements -->
								<div class="box box-primary">
									<div class="box-header with-border">
										<h3 class="box-title">基本信息</h3>
									</div>
									<!-- /.box-header -->
									<!-- form start -->
									<div class="box-body">
										<div class="form-group">
											<label for="name" class="col-sm-2 control-label">知识节名称</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" name="subjSctnTitle" value="${sctn.subjSctnTitle }"  placeholder="请输入知识节名称" required="required">
											</div>
										</div>
										<div class="form-group">
											<label for="birth" class="col-sm-2 control-label">所属科目</label>
											<div class="col-sm-10">
												<select class="form-control" name="subjUnitId">
													<option  value = "" >请选择</option>
													<c:forEach items="${unitList }" var="unit" >
														<option  value = "${unit.subjUnitId }" 
															${unit.subjUnitId==sctn.subjUnitId?"selected":"" }
														>${unit.subjUnitTitle }</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group">
											<label for="cardid" class="col-sm-2 control-label">知识节序号</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" name='subjSctnNum'  value="${sctn.subjSctnNum }"  placeholder="请您输入身份证号" onblur="validUid(this)" required="required">
											</div>
										</div>
										<div class="form-group">
											<label for="cardid" class="col-sm-2 control-label">知识节代号</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" name='subjSctnCode'  value="${sctn.subjSctnCode }"  placeholder="请您输入身份证号" onblur="validUid(this)" required="required">
											</div>
										</div>
										<div class="form-group">
											<label for="cardid" class="col-sm-2 control-label">图片上传</label>
											<div class="col-sm-10">
												<input type="text" class="form-control"  value="${sctn.subjSctnLogoUrl==null?"没有文件":sctn.subjSctnLogoUrl }" disabled="disabled"> <br/>
												<input type="file" class="form-control" name='sctnPicUrl' placeholder="请您输入图片上传"  required="required">
											</div>
										</div>
										<div class="form-group">
											<label for="birth" class="col-sm-2 control-label">视频上传</label>
											<div class="col-sm-10">
												<input type="text" class="form-control"  value="${sctn.subjSctnVideoUrl==null?"没有文件":sctn.subjSctnVideoUrl }" disabled="disabled"  > <br/>
												<input type="file" name="sctnVideoUrl" class="form-control"   placeholder="请您输入视频上传"  required="required">
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label">知识节说明</label>
											<div class="col-sm-10">
												<textarea rows="3" class="form-control" name="subjSctnInfo"  placeholder="请您输入知识节说明"  required="required">${sctn.subjSctnInfo }</textarea>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label">知识节图文</label>
											<div class="col-sm-10">
												<textarea rows="3" class="form-control" name="subjSctnPicText"  placeholder="请您输入知识节图文"  required="required">${sctn.subjSctnPicText }</textarea>
											</div>
										</div>
									</div>
									<!-- /.box-body -->
									<div class="box-footer">
										<button type="button" class="btn btn-default" onclick="cleanUp(this)">清空</button>
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


	<script type="text/javascript">
		

		//清空
		function cleanUp(btn) {
			parDiv = $(btn).parent().parent();
			parDiv.find("input").val("");
			parDiv.find("textarea").html("");
			parDiv.find("select").each(function(i, j) {
				$(j).find("option:selected").prop("selected", false);
				$(j).find("option").first().prop("selected", true);
			});
		}
	</script>

</html>