<!DOCTYPE html>
<%@page import="org.sdrc.childinfo.model.User"%>
<%@page import="org.sdrc.childinfo.model.UserRoleSchemeMapping"%>
<%@page import="java.util.List"%>
<%@page import="org.sdrc.childinfo.util.Constants"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="en">

<jsp:include page="fragments/headTag.jsp" />
<body>
	<%
		User user = null;
		String role = "";
		List<String> features = new ArrayList<String>();
		List<String> permissions = new ArrayList<String>();
	%>
	<%
		user = (User) request.getSession().getAttribute(
				Constants.USER_PRINCIPAL);
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
		}
	%>
	<div id="wrapper">
		<jsp:include page="fragments/bodyHeader.jsp" />
		<spring:url value="/resources/images/homepage_banner.jpg"
			htmlEscape="true" var="BannerImage3" />
		<spring:url value="/resources/images/dashboard_icon.jpg"
			htmlEscape="true" var="dashboardicon" />
		<spring:url value="/resources/images/pic1.png" htmlEscape="true"
			var="CM" />
		<spring:url value="/resources/images/pic2.png" htmlEscape="true"
			var="Minister" />
		<spring:url value="/resources/images/pic3.png" htmlEscape="true"
			var="Secretary" />
		<section id="banner">
			<div id="carousel-example-generic"
				class="carousel slide banner mar-top-5" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#carousel-example-generic" data-slide-to="0"
						class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					<li data-target="#carousel-example-generic" data-slide-to="2"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner">
					<div class="item active">
						<img src="${BannerImage3}" alt="first-banner-image" height="255px">
					</div>
					<div class="item">
						<img src="${BannerImage3}" alt="second-banner-image"
							height="255px">
					</div>
					<div class="item">
						<img src="${BannerImage3}" alt="third-banner-image" height="255px">
					</div>
				</div>

				<!-- Controls -->
				<a class="left carousel-control" href="#carousel-example-generic"
					role="button" data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left"></span>
				</a> <a class="right carousel-control" href="#carousel-example-generic"
					role="button" data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right"></span>
				</a>
			</div>
		</section>
		<div class="content ">

			<section class="mid-sec-bg">
				<div class="container-fluid ">
					<div class="row">
						<div class="col-md-3 text-center">
							<div class="mid_sec_icon ">
								<i class="fa fa-tasks fa-2x "></i>
							</div>
							<h4>Best practices</h4>
						</div>

						<div class="col-md-3 text-center">
							<div class="mid_sec_icon ">
								<i class="fa fa-book fa-2x "></i>
							</div>
							<h4>E-Learning</h4>
						</div>

						<div class="col-md-3 text-center">
							<div class="mid_sec_icon ">
								<i class="fa fa-file-text-o fa-2x "></i>
							</div>
							<h4>Schedule an Assessment</h4>
						</div>

						<div class="col-md-3 text-center">
							<div class="mid_sec_icon ">
								<i class="fa fa-table fa-2x "></i>
							</div>
							<h4>Assement Training</h4>
						</div>
					</div>
				</div>
			</section>
			<section>
				<div class="row">
					<div class="col-md-3 ">
						<a href="#"> <img alt="evm_img"
							src="resources/images/vac1.jpg"></a>
					</div>
					<div class="col-md-3 ">

						<a href="#"> <img alt="evm_img"
							src="resources/images/vac2.png"></a>
					</div>
					<div class="col-md-3">

						<a href="#"> <img alt="evm_img"
							src="resources/images/vac3.jpg"></a>
					</div>
					<div class="col-md-3 ">

						<a href="#"> <img alt="evm_img"
							src="resources/images/vac4.jpg"></a>
					</div>
				</div>
			</section>
			<section>
				<div class="container-fluid ">
					<div class="row mar-bot-15 mar-top-15">
						<div class="col-md-6">
							<h2 class="model_style">
								<span class="model_colr">Model</span>&nbsp;&nbsp;&nbsp;facility

							</h2>
						</div>
						<div class="col-md-6">
							<p ><a class="button large_button pull-right" target="_blank" href=""> <i
								class="fa fa-lg fa-info-circle"></i> CHECK DETAILS
							</a></p>
						</div>
					</div>
				</div>
			</section>

		</div>

	</div>
	<jsp:include page="fragments/footer.jsp" />
</body>

</html>
