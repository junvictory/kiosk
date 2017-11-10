<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<%@include file="../include/header.jsp"%>
<!-- Main content -->
<section class="wrapper">
	<div class="container">
		<!-- Page-Title -->
		<div class="row">
			<div class="col-sm-12">
				<div class="page-title-box">
					<div class="btn-group pull-right">
						<ol class="breadcrumb hide-phone p-0 m-0">
							<li><a href="#">디지털 조직도</a></li>
							<li><a href="#">갤러리</a></li>
							<li class="active">갤러리수정</li>
						</ol>
					</div>
					<h4 class="page-title">
						갤러리등록 <small>갤러리를 <code>수정</code> 할 수 있습니다.
						</small>
					</h4>
				</div>
			</div>
		</div>
		<!-- end page title end breadcrumb -->

		<div class="row">
			<div class="col-lg-12">
				<div class="card-box">
					<div class="row">
						<form method="post" role="form">
							<input type='hidden' name='page' value="${cri.page}"> <input
								type='hidden' name='perPageNum' value="${cri.perPageNum}">
							<div class="col-md-7">
								<div class="form-horizontal" role="form">
									<!-- img_title -->
									<div class="form-group">
										<label class="col-md-2 control-label">제목</label>
										<div class="col-md-10">
											<input type="text" class="form-control" placeholder="Name"
												id="img_title" name="img_title"
												value="${com_imageVO.img_title}">
										</div>
									</div>
									<!-- img_filenm -->
									<div class="form-group clearfix">
										<div class="col-sm-12 padding-left-0 padding-right-0">
											<input type="file" name="files[]" id="filer_input2"
												multiple="multiple">
										</div>
									</div>
									<!-- img_gallery  노출 여부   -->
									<div class="form-group">
										<label class="col-md-2 control-label">표시여부</label>
										<!-- checkbox checked 일경우 활성화 -->
										<div style="padding: 5px">
											<input type="checkbox" name="img_gallery" id="img_gallery"
												switch="none" value="1" /> <label for="img_gallery"
												data-on-label="On" data-off-label="Off"></label>
										</div>
									</div>
								</div>
								<div class="form-group" style="text-align: center">
									<button type="submit"
										class="btn btn-primary waves-effect w-md waves-light m-b-5"
										id="change">수정</button>
									<button type="button"
										class="btn btn-warning waves-effect w-md waves-light m-b-5"
										id="back" onclick="history.go(-1)">돌아가기</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- end col -->
		</div>
		<!-- end row -->
		<script>

		if(${com_imageVO.img_gallery}==1){
			$('input:checkbox[id="img_gallery"]').attr("checked", true);
		}

		</script>
	</div>
	<!-- end container -->
</section>
<!-- end wrapper -->


<%@include file="../include/footer.jsp"%>