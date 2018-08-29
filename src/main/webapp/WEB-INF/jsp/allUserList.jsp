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
				<h2 class="page-header">User List</h2>
				<serror:Error id="msgBox" errorList="${formError}" cssInfClass="${className}">
				</serror:Error>
				<div class="pull-right mar-bot-15">
					<button class="btn btn-primary"
						onclick="location.href='addNewUser';">+ Add New User</button>
				</div>
				<%-- 				<serror:Error errorList="${formError}" cssInfClass="alert alert-danger"> --%>
				<%-- 				</serror:Error>	 --%>
				<datatables:table id="workspace" data="${userList}" cdn="true"
					row="workspace" theme="bootstrap2" cssClass="table table-striped"
					export="pdf" paginate="true">

					<datatables:column title="USER NAME">
						<c:out value="${workspace.userName}" />
					</datatables:column>
					<datatables:column title="EMAIL">
						<c:out value="${workspace.userEmailId}" />
					</datatables:column>
					<datatables:column title="PHONE">
						<c:out value="${workspace.userContactNo}" />
					</datatables:column>
					<datatables:column title="ACTIVE / DEACTIVE" display="html">
						<c:set var="status" value="${workspace.active}" />
						<form:form method="POST" action="userActiveAction">
							<input type="hidden" name="userId" value="${workspace.userId}" />
							<input type="hidden" name="email"
								value="${workspace.userEmailId}" />
							<input type="hidden" name="nameOfUser"
								value="${workspace.userName}" />
							<c:choose>
								<c:when test="${status eq true}">
									<input type="submit" value="Deactivate" name="activeStatus"
										class="btn btn-primary btn-sm" />
								</c:when>
								<c:otherwise>
									<input type="submit" value="Activate" name="activeStatus"
										class="btn btn-success btn-sm" />
								</c:otherwise>
							</c:choose>
						</form:form>
					</datatables:column>
					<datatables:export type="pdf" cssClass="btn btn-primary"
						cssStyle="color:#fff;border-radius:0;padding:1px 8px" />
				</datatables:table>

			</div>
		</div>
		<div class="clearfooter"></div>
	</div>


	<jsp:include page="fragments/footer.jsp" />
</body>

</html>