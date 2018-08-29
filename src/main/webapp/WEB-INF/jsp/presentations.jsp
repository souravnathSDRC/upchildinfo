<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="serror" uri="/WEB-INF/ErrorDescripter.tld"%>
<%@ page import="org.sdrc.childinfo.util.Constants"%>
<%@ page import="org.sdrc.childinfo.model.User"%>
<html lang="en">

<jsp:include page="fragments/headTag.jsp" />
<%!String role ; %>
<body>

	<div id="wrapper">
		<jsp:include page="fragments/bodyHeader.jsp" />
		<div id="fixed-thumb-size-demo" class="default-skin scrollable"
			tabindex="-1">
			<div class="scroll-bar vertical">
				<div class="thumb"></div>
			</div>
			<div class="viewport">

				<div class="overview">

					<div class="container-fluid">
						<h2 class="page-header">Presentations</h2>
						<serror:Error errorList="${formSuccess}"
							cssInfClass="alert alert-success">
						</serror:Error>
						<serror:Error errorList="${formErrors}"
							cssInfClass="alert alert-danger">
						</serror:Error>
						<div class="ppts">
							<div class="modal fade bs-example-modal-sm" tabindex="-1"
								role="dialog" aria-labelledby="mySmallModalLabel"
								aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button class="close" aria-hidden="true" data-dismiss="modal"
												type="button">�</button>
											<h4 id="mySmallModalLabel" class="modal-title">Upload
												PPT</h4>
										</div>
										<form:form method="POST" commandName="uploadedFile"
											enctype="multipart/form-data" action="fileUpload">
											<input type="file" name="file" multiple="multiple"
												required="required" />
											<input type="submit" value="Upload" class="btn btn-primary"
												id="upload" />
										</form:form>
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-md-10">

									<ul class="list-inline">
										<c:forEach items="${allfiles}" var="filename">
											<li><a
												href="<c:out value="uploaded_files/PPT/${filename.getName()}"/>"
												download="${filename.getName()}"> <img
													src="resources/images/powerpoint_logo2.jpg" title="Click to download"></a><br /> <span>${filename.getName()}</span></li>

										</c:forEach>
									</ul>
								</div>
							<% 
									User user = (User)request.getSession().getAttribute(Constants.USER_PRINCIPAL);
									role = user != null ? user.getUserRoleSchemeMappings() != null 
																&& !user.getUserRoleSchemeMappings().isEmpty()? 
																user.getUserRoleSchemeMappings().get(0).getRoleScheme()
																.getSamikshyaRole().getRoleName() : null : null ;
								System.out.println(role);
								if(role!= null && role.equals("PTC")){
								%>
								<div class="col-md-2">
									<div class="pull-right">
										<button class="btn btn-primary" data-toggle="modal"
											data-target=".bs-example-modal-sm" id="uploadppt">
											<i class="fa fa-lg fa-cloud-upload"></i>Upload New
										</button>
									</div>
								</div>
								<%}
								%>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="clearfooter"></div>
	</div>
	<jsp:include page="fragments/footer.jsp" />
</body>
</html>
