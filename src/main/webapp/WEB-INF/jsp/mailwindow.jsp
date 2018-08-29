<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="serror" uri="/WEB-INF/ErrorDescripter.tld" %>
<html lang="en">
<jsp:include page="fragments/headTag.jsp" />
<body>
	<!-- Button trigger modal -->

<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  Launch demo modal
</button>
<serror:Error id="emailMsg" cssInfClass="alert alert-success">
</serror:Error>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Compose Mail</h4>
      </div>
      <div class="modal-body">
        		<form:form id="mailForm" method="POST" commandName="mailModel" action="/assaminfo/submitMail">
					  
<!-- 					  <div class="form-group"> -->
<!-- 							<label for="InputName">From Name</label> -->
<!-- 							<div class="input-group"> -->
<%-- 								<form:input type="text" required="required"  --%>
<%-- 									 path="fromUserName" class="form-control"/> <span --%>
<!-- 									class="input-group-addon"></span> -->
<!-- 							</div> -->
<!-- 						</div> -->
						<div class="form-group">
							<label for="InputName">To</label>
							<div class="input-group">
								<form:input type="text" required="required" 
									 path="toEmailId" class="form-control" readonly="true" /> <span
									class="input-group-addon"></span>
							</div>
						</div>
<!-- 						<div class="form-group"> -->
<!-- 							<label for="InputName">Recipient Name</label> -->
<!-- 							<div class="input-group"> -->
<%-- 								<form:input type="text" required="required"  --%>
<%-- 									 path="toUserName" class="form-control"/> <span --%>
<!-- 									class="input-group-addon"></span> -->
<!-- 							</div> -->
<!-- 						</div> -->
						<div class="form-group">
							<label for="InputName">CC</label>
							<div class="input-group">
								<form:input type="text" required="required" 
									 path="cc" class="form-control"/> <span
									class="input-group-addon"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="InputName">Subject</label>
							<div class="input-group">
								<form:input type="text" required="required" 
									 path="subject" class="form-control"/> <span
									class="input-group-addon"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="InputMessage">Message</label>
							<div class="input-group">
								<form:textarea required="required" rows="5" class="form-control" path="msg"/>
								<span class="input-group-addon"></span>
							</div>
						</div>
				</form:form>
      </div>
      <div class="modal-footer">
        <button id="sendMailBtn" type="button" class="btn btn-primary" data-dismiss="modal">Send Mail</button>
      </div>
    </div>
  </div>
</div>
<jsp:include page="fragments/footer.jsp" />
</body>
</html>