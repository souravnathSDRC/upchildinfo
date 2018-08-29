<!DOCTYPE html>

<%@page import="org.sdrc.childinfo.util.Constants"%>
<%@page import="org.sdrc.childinfo.model.UserDetailsModel"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="serror" uri="/WEB-INF/ErrorDescripter.tld"%>
<%
	UserDetailsModel user = null;
%>
<%
	user = (UserDetailsModel) request.getSession().getAttribute(Constants.USER_PRINCIPAL);
%>

<html lang="en">
<jsp:include page="fragments/headTag.jsp" />
<link rel="stylesheet" href="resources/css/customLoader.css">
<body ng-app="templateUploadApp" ng-controller="TemplateUploadController" ng-cloak>
	<div id="wrapper">
	<jsp:include page="fragments/bodyHeader.jsp" />
	<div id="spinner" class="loader" style="display: none;"></div>
	<div id="loader-mask" class="loader" style="display: none;"></div>
		<%if (user != null) {%>
		<div class="content">
		<div class="container" style="text-align: center;">
			<div id="main-row" class="col-sm-12">
				<div class="col-sm-12 filter-options">
					<div class="col-sm-12">
						<h3>Template Upload</h3>
					</div>
				</div>
				<div class="col-sm-6 col-sm-offset-3 filter-options">
		        <div class="drag_content">
		              <div class="form-group">
		                <input type = "file" id="uploadfile" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" file-model = "myFile" />
		              </div>
		          <!-- Drop Zone -->
		          <div class="upload-drop-zone" id="drop-zone">
		            Drag and drop files here
		          </div>
		          <md-button type="submit" style="background-color: #415684; color: #FFF;" ng-click="uploadFile()">Upload</md-button>
		        </div>

				</div>
			</div>
           </div>
		</div>
		<%} else{%>
		<div class="errorpage-div">
			<spring:url value="/resources/images/exception.png" var="petsImage"/>
		    <img src="${petsImage}"/>
		    <h2>Unauthorized access.</h2>
            <h3 class="access">Please <span style="color:#4a7196"><a onclick="javascript:login();">Log in</a></span> to access this page.
            </h3>
	    </div>
		<%} %>
		  <!--Success Modal -->
		  <div class="modal fade"  id="successModal" role="dialog">
		    <div class="modal-dialog">
		      <div class="modal-content">
		        <div class="modal-header" style="background-color: green !important;">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">Success</h4>
		        </div>
		        <div class="modal-body">
		          <p>File uploaded and data inserted successfully.</p>
		        </div>
		      </div>
		    </div>
		  </div>
		</div>
		<div id="pop" class="modal fade" role="dialog" data-backdrop="static" data-keyboard="false">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-body text-center">
					<div class="successhead"><img alt="" src="resources/images/Messages_success_icon.svg" style="width: 25px; margin-top: -5px;">&nbsp;SUCCESS</div>
					<div class="successbody">{{errorMsg}}</div>
					<button type="button" class="btn errorOk" data-dismiss="modal" ng-click="closeModal()">Close</button>
				</div>
			</div>
		</div>
		</div>
		 <!--Error Modal -->
		<div id="errorMessage" class="modal fade" role="dialog" data-backdrop="static" data-keyboard="false">
		<div class="modal-dialog">
			<!-- Modal content -->
			<div class="modal-content">
				<div class="modal-body text-center">
					<div class="errorhead"><img alt="" src="resources/images/Messages_warning_caution_icon.svg" style="width: 25px; margin-top: -5px;">&nbsp;ERROR</div>
					<div class="errorbody">{{errorMsg}}</div>
					<button type="button" class="btn errorOk" data-dismiss="modal" ng-click="closeModal()">Close</button>
				</div>
			</div>
		</div>
	    </div>
		</div>
	</div>
	
	
	<jsp:include page="fragments/footer.jsp" />
	<script src="resources/js/angular.min.js"></script>
	<script src="resources/js/ui-bootstrap-tpls-1.3.2.min.js"></script>
	<script src="resources/js/angular-animate.min.js"></script>
	<script src="resources/js/angular-aria.min.js"></script>
	<script src="resources/js/angular-messages.min.js"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/angular_material/1.1.0-rc2/angular-material.min.js"></script>
	<script type="text/javascript" src="resources/js/angcontrollers/templateUpload.js"></script>
</body>

</html>