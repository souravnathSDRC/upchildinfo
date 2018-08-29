<!DOCTYPE html>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="datatables" uri="http://github.com/dandelion/datatables"%>
<%@taglib prefix="serror" uri="/WEB-INF/ErrorDescripter.tld" %>

<html lang="en">

<jsp:include page="fragments/headTag.jsp" />
<head>

<style type="text/css">
.plus{
content:url("resources/images/plus.png");
}
.minus{
content:url("resources/images/minus.png");
}
.plus:after{
content:url("resources/images/plus.png");
}
.minus:after{
content:url("resources/images/minus.png");
}
</style>

</head>

<body>
  
<div id="wrapper">
		<jsp:include page="fragments/bodyHeader.jsp" />
		
		<div id="containerId" class="content">
			<div class="container-fluid">
				<h2 class="page-header">DCF List</h2>  
				<div align=center>
						<form method="GET" action="dcfMaster">
						<select name="time" onChange="checkTimePeriod(this)">
							<option value="-Time Period-">-Time Period-</option>
							<c:forEach items="${timePeriodList}" var="timePeriodList">
							<c:choose>
	    						<c:when test="${timePeriodList eq selectedTime}">
	    							<option value="${timePeriodList}" selected="selected">${timePeriodList}</option>
	    						</c:when>
	    						<c:otherwise>
	    							<option value="${timePeriodList}">${timePeriodList}</option>
	    						</c:otherwise>
	    					</c:choose>
							</c:forEach>
						</select>
						<input type="submit" id="timeButton"  style="visibility: hidden;"/>
						</form>
		</div>
<%-- 				<serror:Error errorList="${formError}" cssInfClass="alert alert-danger"> --%>
<%-- 				</serror:Error>	 --%>
				<datatables:table id="workspacePtc" data="${dcfList}" cdn="true" row="workspacePtc" 
									theme="bootstrap2" cssClass="table table-striped" export="pdf"
									paginate="true">
					
						<datatables:column>
							<img class="plus">
						</datatables:column>
						<datatables:column title="FORM NAME" >
							<c:out value="${workspacePtc.formName}"/>
	    				</datatables:column>
	    				<datatables:column title="AREA NAME">
	    					<c:out value="${workspacePtc.areaName}"/>
	    				</datatables:column>
	    				<datatables:column title="TIME PERIOD">
	    					<c:out value="${workspacePtc.timePeriod}"/>
	    				</datatables:column>
	    				<datatables:column title="STATUS">
	    					<c:out value="${workspacePtc.status}"/>
	    				</datatables:column>
	    				<datatables:column title="REMARK">
	    					<c:out value="${workspacePtc.remark}"/>
	    				</datatables:column>
	    				<datatables:column title="DOWNLOAD">
	    					 <c:choose>
	    						<c:when test="${workspacePtc.status eq 'Aggregated'}">
	    							<a href="${workspacePtc.downloadPath}" class="btn btn-info act"><i class="fa fa-lg fa-cloud-download"></i>Download</a>
	    						</c:when>
	    						<c:otherwise>
	    							<a href="#" class="btn btn-default act" style="color:gray;pointer-events: none;cursor: default;"><i class="fa fa-lg fa-cloud-download"></i>Download</a>
	    						</c:otherwise>
	    					</c:choose>
	    				</datatables:column>
	    				<datatables:column title="AGGREGATE">
	    					<input type="submit" name="aggregate" value="aggregate"/>
	    				</datatables:column>
	    				
    					<datatables:export type="pdf" cssClass="btn btn-small" />
				</datatables:table>
				
			</div>		</div>
		<div class="clearfooter"></div>
	</div>


<jsp:include page="fragments/footer.jsp" />
</body>

</html>