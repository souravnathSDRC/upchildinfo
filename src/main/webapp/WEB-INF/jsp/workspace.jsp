<!DOCTYPE html>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="datatables"
	uri="http://github.com/dandelion/datatables"%>
<%@taglib prefix="serror" uri="/WEB-INF/ErrorDescripter.tld"%>

<html lang="en">
<head>

</head>
<jsp:include page="fragments/headTag.jsp" />
<body>

	<div id="wrapper">
		<jsp:include page="fragments/bodyHeader.jsp" />
		<div class="content">
			<section id="gse">
				<div class="container-fluid">
					<div class="pull-left">
						<h3 class="page_header">Workspace</h3>
					</div>
				</div>
			</section>
			<section>
				<div class="container-fluid  mar-top-15">
					<%-- 				<serror:Error errorList="${formError}" --%>
					<%-- 					cssInfClass="alert alert-danger"> --%>
					<%-- 				</serror:Error> --%>



					<datatables:table id="ripas_workspace" data="${xformList}"
						cdn="true" row="workspace" theme="bootstrap2"
						cssClass="table table-striped" export="pdf" paginate="true" >

						<datatables:column title="NO." property="count" />
						<datatables:column title="STATE" property="state" />
						<datatables:column title="Form Name" property="form_title" />
						<datatables:column title="FORM ID" property="form_id" />
						<datatables:column title="VIEW">
								<button class="logs" onclick="javascript:initWorkshopView(this,
								'${workspace.count}',
								'${workspace.state}',
								'${workspace.district}',
								'${workspace.form_id}'
								);">Logs</button>
						</datatables:column>

						<datatables:column title="Enketo">
							<c:if test="${not empty workspace.enketo_url}">
								<a href=" ${workspace.enketo_url}" target="_blank"><i class="fa fa-file-text-o fa-2x ripas_blue"></i></a>
							</c:if>
							<c:if test="${empty workspace.enketo_url}">
    							<a href="javascript:void(0)"><i class="fa fa-file-text-o fa-2x ripas_blue"></i></a>
							</c:if>
						</datatables:column>

					</datatables:table>

				</div>
			</section>
		</div>
		<div class="clearfooter"></div>
	</div>

	<jsp:include page="fragments/footer.jsp" />
</body>

</html>
