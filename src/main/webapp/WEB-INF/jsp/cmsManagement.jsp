<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="serror" uri="/WEB-INF/ErrorDescripter.tld"%>


<html lang="en">

<jsp:include page="fragments/headTag.jsp" />
<spring:url value="/webjars/jquery/2.0.3/jquery.min.js" var="jQuery" />
<script src="${jQuery}"></script>

<spring:url value="/webjars/bootstrap/3.1.1/js/bootstrap.min.js"
	var="bootstrapjs" />
<script src="${bootstrapjs}"></script>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<body ng-app="uploadApp" ng-controller="UploadController" ng-cloak>
	<jsp:include page="fragments/bodyHeader.jsp" />
	<div id="wrapper" class="container" align="left">
		<serror:Error id="msgBoxlogin" errorList="${formError}"
			cssInfClass="${className}">
							${formError}
							</serror:Error>
		<div style="text-align: center;" class={{errorClass}} id="errorValidation">
			<strong>{{errorMessage}}</strong>
		</div>
		<div class="content">
			<div class="container-fluid">
				<div id="main-row" class="col-sm-12">
					<div class="col-sm-12 filter-options">
						<div class="col-sm-12">
							<h3>Upload Image</h3>
						</div>
					</div>
					<div class="col-sm-12 filter-options">
						<form id="upload-report" enctype="multipart/form-data"
							name="documentForm" method="post" action="saveReport">
							<div class="col-sm-12">
								<md-input-container flex="50"> <label>
									Title *</label> <input required md-maxlength="150" maxlength="150"
									name="reportTitle" ng-model="selectedReport.title">
								<div ng-messages="documentForm.reportTitle.$error">
									<div ng-message="required">This is required.</div>
								</div>
								</md-input-container>
							</div>

							<div class="col-sm-12">
								<md-input-container class="md-block"> <label
									class="md-mandatory">Message *</label> <input
									md-maxlength="250" required maxlength="250" md-no-asterisk
									name="desc" ng-model="selectedReport.description"
									ng-trim="true">
								<div ng-messages="documentForm.desc.$error">
									<div ng-message="required">This is required.</div>
									<div ng-message="md-maxlength">The description must be
										less than 250 characters long.</div>
								</div>
								</md-input-container>
							</div>
							<div class="col-sm-12" style="margin-top: 15px;">
								<md-input-container flex="50"> <label>Upload
									Photographs(.jpg, .png, .gif) [Max-size : 1MB]</label> <input required
									id="uploadFileImg" placeholder="Click Browse"
									disabled="disabled" name="uploadFileImg"
									ng-model="Report.uploadFileImgName"
									style="color: #000; min-width: 400px;">
								<div ng-messages="documentForm.uploadFileImgName.$error">
									<div ng-message="required">This is required.</div>
								</div>
								</md-input-container>
								<div class="fileUpload btn">
									<span>Browse</span> <input id="uploadBtnImg" type="file"
										name="file" ng-model="Report.uploadFileImg" class="upload"
										onchange="angular.element(this).scope().setPathFileDoc(this, 'uploadFileImg', 'uploadBtnImg')"
										required />

								</div>
							</div>
							<div class="clearfix"></div>
							<md-button type="submit"
								style="background-color: #415684; color: #FFF;">Submit</md-button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="fragments/footer.jsp" />
	<script type="text/javascript">
		$(document).ready(function() {
			$("#msgBox").delay(2000).fadeOut(2000);
			$("#msgBoxlogin").delay(2000).fadeOut(2000);
			$("#upload-report").submit(function() {
				$(".loader").css("display", "block");
			})
		});
		(function($) {
			$(document).ready(function() {
				$('input').blur(function() {
					var value = $.trim($(this).val());
					$(this).val(value);
				});
			});
		})(jQuery);
	</script>
	<script src="resources/js/angular.min.js"></script>
	<script src="resources/js/ui-bootstrap-tpls-1.3.2.min.js"></script>
	<script src="resources/js/angular-animate.min.js"></script>
	<script src="resources/js/angular-aria.min.js"></script>
	<script src="resources/js/angular-messages.min.js"></script>
	<script
		src="http://ajax.googleapis.com/ajax/libs/angular_material/1.1.0-rc2/angular-material.min.js"></script>
	<script type="text/javascript"
		src="resources/js/angcontrollers/cmsManagement.js"></script>
</body>

</html>