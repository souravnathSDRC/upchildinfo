<!DOCTYPE html>
<%@page import="org.sdrc.childinfo.model.User"%>
<%@page import="org.sdrc.childinfo.model.UserRoleSchemeMapping"%>
<%@page import="java.util.List"%>
<%@page import="org.sdrc.childinfo.util.Constants"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="en">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<jsp:include page="fragments/headTag.jsp" />
<body>
	<%
		User user = null;
		String role = "";
		List<String> features = new ArrayList<String>();
		List<String> permissions = new ArrayList<String>();
	%>
	<%
	/* 	user = (User) request.getSession().getAttribute(Constants.USER_PRINCIPAL);
		
		List<UserRoleSchemeMapping> ursMappings = new ArrayList<UserRoleSchemeMapping>();
		ursMappings = user != null ? user.getUserRoleSchemeMappings()
				: null;
		if (ursMappings != null && !ursMappings.isEmpty()) {
			for (UserRoleSchemeMapping ursm : ursMappings) {

				role = ursm.getRoleScheme().getSamikshyaRole()
						.getRoleName();
				features.add(ursm.getRoleScheme()
						.getFeaturePermissionMapping().getFeature()
						.getFeatureName());
				permissions.add(ursm.getRoleScheme()
						.getFeaturePermissionMapping().getPermission()
						.getPermissionName());
			}
		} */
	%>
	<div id="wrapper" ng-app="wellcomeApp">
	
		<jsp:include page="fragments/bodyHeader.jsp" />

		<div class="content" id="mymain" ng-controller="wellcomeController">
		<div class="container contain-box">
		  <div class="row">
		  <div class="col-md-12">
			<section id="banner" style="margin-top:25px;">
				<div id="carousel-banner-slide" class="carousel slide"
					data-ride="carousel">

					<div class="carousel-inner">
						<div class="item active">
							<img alt="slide_1" src="resources/images/slide-1.jpg"
								class="img-responsive" width="100%;" height="250px" >
						</div>
						<div class="item">
							<img alt="slide_2" src="resources/images/slide-2.jpg"
								class="img-responsive" width="100%" >
						</div>
						<div class="item">
							<img alt="slide_3" src="resources/images/slide-3.jpg"
								class="img-responsive" width="100%" >
						</div>
					</div>

					<!-- Controls -->
					<a class="left carousel-control" href="#carousel-banner-slide"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span>
					</a> <a class="right carousel-control" href="#carousel-banner-slide"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span>
					</a>
				</div>
			</section>
			</div>
			
			</div>
			</div>
			
			
			<div class="content">
				<section id="devinfo_section">
					 <div class="container carousel">
					  <div class="row">
					    <div class="col-lg-3 col-md-3 col-sm-6 four-col-box">
					 <div class="ca-hover">
					        <div class="carousel-img"> <img src="resources/images/childinfo.jpg" alt="DevInfo" class="img-responsive"> </div>
					        <div class="carousel-content">
					          <h3 class="footer-item">About Child Info</h3>
					          <p>Child info is an online data dissemination system which consolidates various
secondary and primary data sets in a single platform and presents the
consolidated current status to diverse range of stakeholders for facilitating
evidence based decision making. <br>
					            <br>
					            <a href="about_us"  class="btn btn-common">View more &rarr;</a></p>
					        </div>
					      </div>
					    </div>
					    <div class="col-lg-3 col-md-3 col-sm-6 four-col-box">
					      <div class="ca-hover">
					        <div class="carousel-img"> <img src="resources/images/dashboard.jpg" alt="Dashboard"  class="img-responsive"> </div>
					        <div class="carousel-content">
					          <h3 class="footer-item">Dashboard</h3>
					          <p>Click to view sector wise data for multiple time period and resources disaggregated at state, district, tehsil and block level. <br>
					            <br>
					            <a class="<%=request.getRequestURI().contains("dashboard") ? "menu-active"	: ""%> btn btn-common"
								href="<spring:url value="dashboard" htmlEscape="true" />">View more &rarr;</a></p>
					        </div>
					      </div>
					    </div>
					    <div class="col-lg-3 col-md-3 col-sm-6 four-col-box">
					      <div class="ca-hover">
					        <div class="carousel-img"> <img src="resources/images/devinfo.jpg" alt="DevInfo" class="img-responsive"> </div>
					        <div class="carousel-content">
					          <h3 class="footer-item">Child Info</h3>
					          <p>Click to query and access data on 480 indicators from several sectors like
Demographic particulars, social and economic status of families and children, status on Nutrition, Health, Child Protection and more.<br>
					            <br>
					            <a href="http://data.etathya.org/childinfo/libraries/aspx/Home.aspx" target="_blank" class="btn btn-common">View more &rarr;</a></p>
					            <p> <a href="source" class="btn btn-common" style="text-align:left;" >Download ChildInfo Offline<br>Adaptation <i class="fa fa-download" aria-hidden="true"></i> </a>
					            </p>
					            
					        </div>
					      </div>
					    </div>
					    <div class="col-lg-3 col-md-3 col-sm-6 four-col-box">
					      <div class="ca-hover">
					        <div class="carousel-img"> <img src="resources/images/resource.jpg" alt="Resources" class="img-responsive"> </div>
					        <div class="carousel-content">
					          <h3 class="footer-item">Resources</h3>
					          <p>Click to view resources feature to download ready to use PDF formats which provide a snapshot of the development profile of Uttar Pradesh. <br>
					            <br>
					            <a href="<spring:url value="source" htmlEscape="true" />" class="<%=request.getRequestURI().contains("factsheet") ? "menu-active"	: ""%> btn btn-common">View more &rarr;</a></p>
					        </div>
					      </div>
					    </div>
					  </div>
					</div>
			 </section>

				</div>
			</div>
		</div>
	
	<script>
	var app = angular.module('wellcomeApp', []);
	app.controller('wellcomeController', function($scope,$http) {

	});
	</script>
	<script type="text/javascript">
function changemysize(myvalue) {
$('#mymain *').css('font-size', myvalue + "px");
}
</script>
	<jsp:include page="fragments/footer.jsp" />
	<script src="resources/js/welcome.js"
	type="text/javascript"></script>
	
</body>

</html>
