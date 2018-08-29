<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="datatables"
	uri="http://github.com/dandelion/datatables"%>

<html lang="en">

<jsp:include page="fragments/headTag.jsp" />
<body>

	<div id="wrapper">
		<jsp:include page="fragments/bodyHeader.jsp" />

		<div class="content">
			<div class="container-fluid">
				<section>
					<h1 class="page-header">Logs</h1>

					<div class="well well-sm">
						<div class="row">
							<div class="hero-unit">
								<form:form id="admintable" action="adminauditform" method="POST"
									modelAttribute="adminLog">
									<div class="col-md-5">
										<div class="input-daterange" id="datepicker">
											<div class="text-right">
												<span>From</span> <input type="text" class="input-small"
													name="start" required="required" placeholder="-- Choose Date --"/> <span>To</span>
												<input type="text" class="input-small" name="end" required="required" placeholder="-- Choose Date --"/>
											</div>
										</div>
									</div>
									<div class="col-md-2">
										<input id="search" class="btn btn-primary" type="submit"
											name="submit" value="Search"></input>
									</div>
								</form:form>
								<div class="col-md-5">
									<div class="text-right">
										<!-- <a href="javascript:void(0)">
								<button id="download" class="btn btn-primary" type="button">
								<i class="fa fa-md fa-cloud-download"></i>Download</button>
								</a> -->
									</div>
								</div>
							</div>
						</div>
					</div>


					<div class="row">
						<div class="col-md-12">
							<datatables:table id="vets" data="${auditList}" cdn="true"
								row="listValue" theme="bootstrap2"
								cssClass="table table-striped" paginate="true" info="true"
								export="pdf">
								<datatables:column title="FORM NAME">
									<%-- 						<c:out value="${listValue.getStart()}"/> --%>
									<c:out
										value="${listValue.getSamikshyaMonitoringForm().getFormCode()}" />
								</datatables:column>
								<datatables:column title="DATE">
									<fmt:formatDate value="${listValue.getLastUpdatedDate()}"
										pattern="dd-MM-yyyy" type="date" />
									<%-- 							<c:out value="${listValue.getLastUpdatedDate().split(' ')[0]}"/> --%>
								</datatables:column>
								<datatables:column title="LEVEL">
									<c:out
										value="${listValue.getSamikshyaMonitoringForm().getSamikshyaBlock()!=null?'BLOCK':'DISTRICT'}" />
								</datatables:column>
								<datatables:column title="USER">
									<c:out
										value="${listValue.getSamikshyaMonitoringForm().getLastUpdatedBy()}" />
								</datatables:column>
								<datatables:column title="BLOCK">
									<c:out
										value="${listValue.getSamikshyaMonitoringForm().getSamikshyaBlock().getBlockName()}"
										default="_ _ _ _" />
								</datatables:column>
								<datatables:column title="DISTRICT">
									<c:out
										value="${listValue.getSamikshyaMonitoringForm().getSamikshyaDistrict().getDistrictName()}" />
								</datatables:column>
								<datatables:column title="STATUS">
									<c:out value="${listValue.getStatus()}"></c:out>
								</datatables:column>
								<c:choose>
									<c:when test="${listValue!=null}">
										<datatables:export type="pdf" fileName="AuditLogs"
											autoSize="true" cssClass="btn btn-primary"
											cssStyle="position:absolute;top:-53.2px;right:30px;padding:1px 8px;color:#fff;border-radius:0px !important" />
									</c:when>
									<c:otherwise>
										<datatables:export type="pdf" cssClass="btn btn-primary"
											cssStyle="visibility:hidden" includeHeader="true"/>
									</c:otherwise>
								</c:choose>
							</datatables:table>
						</div>
					</div>

				</section>
			</div>
		</div>
	</div>
	<div class="clearfooter"></div>
	<jsp:include page="fragments/footer.jsp" />
</body>
</html>