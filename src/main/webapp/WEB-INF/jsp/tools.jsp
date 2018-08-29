<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="serror" uri="/WEB-INF/ErrorDescripter.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="org.sdrc.childinfo.util.Constants"%>
<%@ page import="org.sdrc.childinfo.model.User"%>

<html lang="en">

<jsp:include page="fragments/headTag.jsp" />
<%!User user = null;
	String role = "";%>
<body>

	<div id="wrapper">
		<jsp:include page="fragments/bodyHeader.jsp" />
		<div class="content">
			<div class="container-fluid">
				<h2 class="page-header evm-font-blue">Tools</h2>
				<serror:Error errorList="${formSuccess}"
					cssInfClass="alert alert-success">
				</serror:Error>
				<serror:Error errorList="${formErrors}"
					cssInfClass="alert alert-danger">
				</serror:Error>
				<div class="col-md-6">
					<h4 class="evm-gray">
						<i class="fa fa-lg fa fa-android evm-font-blue"></i>EVM APK
					</h4>
					<i class="fa fa-lg icon-android evm-font-blue"></i> <a
						href="resources/applications/EVM Collect.apk"
						download="resources/applications/EVM Collect.apk"
						title="click to download EVM Collect.apk">EVM Collection
						Android APK</a>
				</div>

				<div class="col-md-6">
					<div class="col-md-8">
						<h4 class="evm-gray">
							<i class="fa fa-file evm-font-blue"></i>EVM XML Forms
						</h4>
						<ul>
							<li><a href="resources/applications/EVM DVS 22082014.xml"
								download="resources/applications/EVM DVS 22082014.xml"
								title="click to download EVM DVS 22082014.xml">EVM DVS XML
									Form</a></li>
							<li><a
								href="resources/applications/EVM HealthFacility 22082014.xml"
								download="resources/applications/EVM HealthFacility 22082014.xml"
								title="click to download EVM HealthFacility 22082014.xml">EVM
									Health Facility XML Form</a></li>
							<li><a href="resources/applications/EVM SVSRVS 22082014.xml"
								download="resources/applications/EVM SVSRVS 22082014.xml"
								title="click to download EVM SVSRVS 22082014.xml">EVM SVS
									RVS XML Form</a></li>
						</ul>
					</div>
					<%
						User user = (User) request.getSession().getAttribute(
								Constants.USER_PRINCIPAL);
						role = user != null ? user.getUserRoleSchemeMappings() != null
								&& !user.getUserRoleSchemeMappings().isEmpty() ? user
								.getUserRoleSchemeMappings().get(0).getRoleScheme()
								.getSamikshyaRole().getRoleName() : null : null;
						System.out.println(role);
						if (role != null && role.equals("Admin")) {
					%>
					<div class="col-md-4">
						<div class="pull-right">
							<div class="btn-group">
								<button type="button" class="btn btn-primary"
									data-toggle="dropdown">
									<i class="fa fa-lg fa-cloud-upload"></i>Upload New
								</button>
								<button type="button" class="btn btn btn-primary"
									data-toggle="dropdown">
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu" role="menu" id="selectfolder">
									<li data-toggle="modal" data-target=".modal"
										id="upload-assessment-tools"><a href="#">Assessment
											Tools</a></li>
									<li data-toggle="modal" data-target=".modal"
										id="upload-userguides"><a href="#">User Guides</a></li>
								</ul>
							</div>


							<div class="modal fade" tabindex="-1" role="dialog"
								aria-labelledby="mySmallModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button class="close" aria-hidden="true" data-dismiss="modal"
												type="button">×</button>
											<h4 id="mySmallModalLabel" class="modal-title">Select
												File(s)</h4>
										</div>
										<form:form method="POST" commandName="uploadedFile"
											enctype="multipart/form-data" action="toolsUpload">
											<input type="file" name="file" multiple="multiple"
												required="required" />
											<input type="hidden" name="tools" id="uploadhidden">
											<input type="submit" value="Upload" class="btn btn-primary"
												id="upload" />
										</form:form>
									</div>
								</div>
							</div>
						</div>
					</div>
					<%
						}
					%>
				</div>
				<div class="col-md-6 mar-top-15">
					<h4 class="evm-gray">EVM assessment tools</h4>
					<table class="table table-condensed">
						<tr>
							<th>Tool Details</th>
							<th>Description</th>
							<th>Download</th>
						</tr>
						<tr>
							<td>The EVM site selection tool xls, 3.13Mb</td>
							<td>The EVM Site Selection Tool is an Excel-based tool used
								to conduct the site selection process in a standardized way to
								ensure that the assessment results within and across countries
								can be interpreted and compared in a consistent way.</td>
							<td><a
								href="www.who.int/entity/immunization/programmes_systems/supply_chain/EVM_Site_Selection_Tool_v1.7.xls?ua=1"><h3>
										<i class="fa fa-download evm-font-blue  "></i>
									</h3></a></td>
						</tr>
						<tr>
							<td>The EVM site selection tool userguide pdf, 846kb</td>
							<td>N/A</td>
							<td><a
								href="www.who.int/entity/immunization/programmes_systems/supply_chain/EVM-site-selection-userguide-V1.7.pdf?ua=1"
								target="_blank"><h3>
										<i class="fa fa-download evm-font-blue  "></i>
									</h3></a></td>
						</tr>
						<tr>
							<td>The EVM assistant tool xls, 1.55Mb</td>
							<td>The EVM Assistant Tool is an Excel tool used to collect
								and process the numerical data required for scoring certain EVM
								indicators in a standardized way, so as to ensure that assessors
								score in a consistent manner.</td>
							<td><a
								href="www.who.int/entity/immunization/programmes_systems/supply_chain/EVM_Assistant_Tool_v1.7.xls?ua=1"><h3>
										<i class="fa fa-download evm-font-blue  "></i>
									</h3></a></td>
						</tr>
						<tr>
							<td>The EVM assistant tool userguide pdf, 1.57Mb</td>
							<td>N/A</td>
							<td><a
								href="http://www.who.int/immunization/programmes_systems/supply_chain/EVM-assistant-tool.pdf?ua=1"
								target="_blank"><h3>
										<i class="fa fa-download evm-font-blue  "></i>
									</h3></a></td>
						</tr>
						<tr>
							<td>The EVM report template (version 2.0) doc, 195kb</td>
							<td>This Word template outlines the standard format and
								minimum content required for an EVM assessment report.</td>
							<td><a
								href="www.who.int/entity/immunization/programmes_systems/supply_chain/EVM_report_template_v2.doc?ua=1"><h3>
										<i class="fa fa-download evm-font-blue  "></i>
									</h3></a></td>
						</tr>
						<tr>
							<td>EVM improvement plan template (version 2.0) xls, 196kb</td>
							<td>This Excel template provides the standard structure and
								outlines the minimum content required for an EVM improvement
								plan.</td>
							<td><a
								href="www.who.int/entity/immunization/programmes_systems/supply_chain/EVM_improvement_plan_template_v2.xls?ua=1"><h3>
										<i class="fa fa-download evm-font-blue  "></i>
									</h3></a></td>
						</tr>
						<c:forEach items="${assessmentToolsList}" var="assessmentTools">
							<tr>
								<td>${assessmentTools}</td>
								<td>N/A</td>
								<td><c:set var="name" value="${assessmentTools}" /> <c:if
										test="${fn:endsWith(name,'pdf') || fn:endsWith(name,'PDF')}">
									</c:if> <c:set var="name" value="${factsheet}" /> <c:if
										test="${fn:endsWith(name,'xls') || fn:endsWith(name,'XLS') || fn:endsWith(name,'xlsx') || fn:endsWith(name,'XLSX')}">
									</c:if> <c:set var="name" value="${factsheet}" /> <c:if
										test="${fn:endsWith(name,'docx') || fn:endsWith(name,'DOCX') || fn:endsWith(name,'doc') || fn:endsWith(name,'DOC')}">
									</c:if> <a title="click to download ${resources}"
									download="${assessmentTools}"
									href="resources/TOOLS/ASSESSMENT TOOLS/${assessmentTools}"><h3>
											<i class="fa fa-download evm-font-blue"></i>
										</h3></a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div class="col-md-6 mar-top-15">
					<h4 class="evm-gray">EVM user guides</h4>
					<table class="table table-condensed">
						<tr>
							<th>Guide Details</th>
							<th>Description</th>
							<th>Download</th>
						</tr>
						<tr>
							<td>EVM assessment tool user guide version 1.0.9 in English
								pdf, 1.31Mb</td>
							<td>N/A</td>
							<td><a
								href="http://www.who.int/immunization/programmes_systems/supply_chain/EVM_Assessment_Tool_1_0_9_User_Guide_(EN).pdf?ua=1"
								target="_blank"><h3>
										<i class="fa fa-download evm-font-blue  "></i>
									</h3></a></td>
						</tr>
						<c:forEach items="${userGuidesList}" var="userGuides">

							<tr>
								<td>${userGuides}</td>
								<td>N/A</td>
								<td><c:set var="name" value="${userGuides}" /> <c:if
										test="${fn:endsWith(name,'pdf') || fn:endsWith(name,'PDF')}">
									</c:if> <c:set var="name" value="${factsheet}" /> <c:if
										test="${fn:endsWith(name,'xls') || fn:endsWith(name,'XLS') || fn:endsWith(name,'xlsx') || fn:endsWith(name,'XLSX')}">
									</c:if> <c:set var="name" value="${factsheet}" /> <c:if
										test="${fn:endsWith(name,'docx') || fn:endsWith(name,'DOCX') || fn:endsWith(name,'doc') || fn:endsWith(name,'DOC')}">
									</c:if> <a title="click to download ${resources}"
									download="${userGuides}"
									href="resources/TOOLS/USER GUIDES/${userGuides}"><h3>
											<i class="fa fa-download evm-font-blue"></i>
										</h3></a></td>
							</tr>
						</c:forEach>
					</table>


				</div>
			</div>
		</div>
		<div class="clearfooter"></div>
	</div>
	<jsp:include page="fragments/footer.jsp" />
</body>

</html>
