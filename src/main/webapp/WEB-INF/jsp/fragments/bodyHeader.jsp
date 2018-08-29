<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@taglib prefix="serror" uri="/WEB-INF/ErrorDescripter.tld"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="org.sdrc.childinfo.util.Constants"%>
<%@page import="org.sdrc.childinfo.model.UserRoleSchemeMapping"%>
<%@ page import="org.sdrc.childinfo.model.UserDetailsModel"%>
<%@ page import="org.sdrc.childinfo.model.Role"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<spring:url value="/resources/images/bilogo.png" var="bilogo" />
<spring:url value="/resources/images/gov_logo.png" var="gov_logo" />
<!-- Top bar -->
<%
	UserDetailsModel user = null;
	user = (UserDetailsModel) request.getSession().getAttribute(
			Constants.USER_PRINCIPAL);
%>

<div class="text-center">
  <serror:Error id="msgBoxlogin" errorList="${formError}" cssInfClass="${className}">
</serror:Error>
</div>
						
<div class="navbar-static-top bar font_selector" style="background-color: #7b7c7f;">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12  text-right">
					<ul class="header-links navbar-right">
						<label>Font Size:&nbsp;</label>
						<li><a href="javascript:void(0);" onClick="changemysize(12);"><small>-A</small></a></li>
						<li><a href="javascript:void(0);" onClick="changemysize(13);">A</a></li>
						<li><a href="javascript:void(0);" onClick="changemysize(16);"><big>A+</big></a></li>
							<%if(user == null){ %>
						<li style="color: #999;">&nbsp; | &nbsp;<i class="fa fa-sign-in logintxt" aria-hidden="true"></i></li>
						<li class="logintxt" onclick="javascript:login();"><a>Log in</a></li>
						<%}else{ %>
						<li style="color: #999;">&nbsp; | &nbsp;<i class="fa fa-sign-out logintxt" aria-hidden="true"></i></li>
						<li class="logintxt" onclick="javascript:logout();"><a>Logout</a></li>
						<%} %>
						
					</ul>
				</div>
						<div class="modal fade" id="loginModal" tabindex="-1" role="dialog">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">Login</h4>
							</div>

							<!-- Modal for login -->
							<div class="modal-body">
								<input type="hidden" id="loginStatus" value="${formError}">
								<input type="hidden" id="userId" value="${userId}">
								<!-- 					<p style="text-align: center"> -->
								<form action="validateLogin" method="post">
									<div class="input-group" style="margin-bottom: 20px;">
										<input class="form-control" name="username" id="username"
											type="text" required placeholder="username"> <span
											class="input-group-addon" style="border: 0 !important;">
											<i class="fa fa-user" aria-hidden="true"></i>
										</span>
									</div>
									<div class="input-group" style="margin-bottom: 20px;">
										<input class="form-control" name="password" type="password"
											id="password" placeholder="password" required> <span
											class="input-group-addon" style="border: 0 !important;">
											<i class="fa fa-key" aria-hidden="true"></i>
										</span>
									</div>
									<button id="button3id" name="button3id"
										class="btn btn-info bigbutton" type="submit" class="close"
										aria-hidden="true" style="background-color: #254e71;">Submit</button>
								</form>
							</div>
						</div>
					</div>
				</div>

				<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">Are you sure you
									want to logout</h4>
							</div>
							<div class="modal-body">
								<form action="logout" method="post" style="text-align: center;">
									<button class="btn btn-info bigbutton" type="submit"
										class="close" aria-hidden="true"
										style="background-color: #254e71;">Yes</button>
									<button class="btn btn-info bigbutton" type="button"
										class="close" aria-hidden="true" data-dismiss="modal"
										style="background-color: #254e71;">No</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>

<header class="navbar-static-top bar header_bg" id="head1">

	<div class="container-fluid">
		<div class="col-md-12" style="padding-left: 0px; padding-right: 0px;">
			<div class="col-md-8 col-sm-8 col-xs-12">
				<div class="govlogo_holder col-md-2 col-sm-2 col-xs-6">
					<a href="./"><img style="margin-left: 65px;" src="resources/images/bilogo.png"
						alt="UpChildInfo"></a>
				</div>
			</div>
			<div class="col-md-4 col-sm-4 col-xs-12  content-externallink">
<!-- 			<div class="box-externallink"> -->
<!-- 				<div class="externallink"> -->
<!-- 					<a target="_blank" href="https://datastudio.google.com/embed/reporting/1y9_Cz9K-cYjNq9ltETm0jjhagVyKCkq7/page/UPbW">Naya Sawera</a> -->
<!-- 				</div> -->
<!-- 				<div class="externallink"> -->
<!-- 					<a target="_blank" href="https://datastudio.google.com/embed/reporting/1QNWndKrOGRwa67QX0bMPwg35v0MG6v_s/page/iStW">ABRCC</a> -->
<!-- 				</div> -->
<!-- 				<div class="externallink"> -->
<!-- 					<a target="_blank" href="https://datastudio.google.com/embed/reporting/11DdMG3KycS0LgSnoiORyb745qxvRHUqS/page/3nCX">OOSC</a> -->
<!-- 				</div> -->
<!-- 			</div> -->
			</div>
		</div>

	</div>

</header>
<!-- END Top Bar	 -->
<div class="navbar navbar-default navbar-static-top bar menu" id="head2">
	<div class="container-fluid">
		<jsp:include page="menu.jsp" />
	</div>
</div>
<script type="text/javascript"> 
 function changemysize(myvalue) {
 $("#wrapper:not('.font_selector')").css('font-size', myvalue + "px");
}
</script> 

<script type="text/javascript">
		function login() {
			$('#loginModal').modal('show');
		}
		function logout() {
			$('#logoutModal').modal('show');
		}
</script>

