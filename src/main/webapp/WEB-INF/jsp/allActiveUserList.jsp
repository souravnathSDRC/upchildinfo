<!DOCTYPE html>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="datatables"
	uri="http://github.com/dandelion/datatables"%>
<%@taglib prefix="serror" uri="/WEB-INF/ErrorDescripter.tld"%>



<html lang="en">

<jsp:include page="fragments/headTag.jsp" />

<body>

	<div id="wrapper">
		<jsp:include page="fragments/bodyHeader.jsp" />
		<div id="containerId" class="content">
			<div class="container-fluid">
				<h2 class="page-header">Manage User Roles</h2>
				<serror:Error id="msgBox" errorList="${formError}" cssInfClass="${className}">
				</serror:Error>
				<datatables:table id="workspace" data="${userList}" cdn="true"
					row="workspace" theme="bootstrap2" cssClass="table table-striped"
					export="pdf" paginate="true">

					<datatables:column title="USER NAME">
						<c:out value="${workspace.userName}" />
					</datatables:column>
					<datatables:column title="ROLE">
						<c:out value="${workspace.role}" />
					</datatables:column>
					<datatables:column title="EMAIL">
						<c:out value="${workspace.email}" />
					</datatables:column>
					<datatables:column title="PHONE">
						<c:out value="${workspace.phone}" />
					</datatables:column>
					<datatables:column title="ATTACH / DETACH" display="html">
						<c:set var="status" value="${workspace.email}" />
						<c:choose>

							<c:when test="${empty status}">
								<form:form method="POST" action="roleAttachAction">
									<input type="hidden" name="roleSchemeId"
										value="${workspace.roleSchemeId}" />
									<input type="hidden" name="roleSchemeName"
										value="${workspace.roleSchemeName}" />
									<input type="hidden" name="roleId" value="${workspace.roleId}" />
									<input type="hidden" name="userId" value="${workspace.userId}" />
									<input type="hidden" name="areaCode"
										value="${workspace.areaCode}" />
									<input type="hidden" name="areaName"
										value="${workspace.areaName}" />
									<input type="hidden" name="roleName" value="${workspace.role}" />
									<input type="submit" value="Attach" name="activeStatus"
										class="btn btn-success btn-sm" />
								</form:form>
							</c:when>

							<c:otherwise>
								<form:form method="POST" action="roleDetachAction">
									<input type="hidden" name="roleSchemeId"
										value="${workspace.roleSchemeId}" />
									<input type="hidden" name="roleId" value="${workspace.roleId}" />
									<input type="hidden" name="userId" value="${workspace.userId}" />
									<input type="hidden" name="areaCode"
										value="${workspace.areaCode}" />
									<input type="hidden" name="email" value="${workspace.email}" />
									<input type="hidden" name="areaName"
										value="${workspace.areaName}" />
									<input type="hidden" name="roleName" value="${workspace.role}" />
									<input type="hidden" name="nameOfUser"
										value="${workspace.userName}" />
									<input type="submit" value="Detach" name="activeStatus"
										class="btn btn-primary btn-sm" />
								</form:form>
							</c:otherwise>

						</c:choose>

					</datatables:column>
					<datatables:column title="BLOCK">
						<c:out value="${workspace.block}" />
					</datatables:column>
					<datatables:column title="DISTRICT">
						<c:out value="${workspace.district}" />
					</datatables:column>

					<datatables:export type="pdf" cssClass="btn btn-primary"
						cssStyle="color:#fff;border-radius:0px;padding:1px 8px" />
				</datatables:table>

			</div>
		</div>
		<div class="clearfooter"></div>
	</div>


	<jsp:include page="fragments/footer.jsp" />
</body>

</html>