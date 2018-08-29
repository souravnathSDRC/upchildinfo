<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="serror" uri="/WEB-INF/ErrorDescripter.tld" %>

<html lang="en">

<jsp:include page="fragments/headTag.jsp" />

<body>

	<div id="wrapper">
		<jsp:include page="fragments/bodyHeader.jsp" />
		<div class="content">
			<div class="container-fluid">
				<h2 class="page-header">Add New User</h2>
				<serror:Error id="msgBox" errorList="${formError}" cssInfClass="${className}">
				</serror:Error>
				<form method="post" action="addNewUserAction" >
					<div class="col-lg-6">
					<p><span>Please provide your details below:</span></p>
						<div class="well well-sm">
							<i class="glyphicon glyphicon-ok form-control-feedback"></i>
								Required Field
						</div>
						<div class="form-group">
							<label for="InputName">Name</label>
							<div class="input-group">
								<input type="text" required="required" placeholder="Enter Name"
									id="InputName" name="userName" class="form-control"> <span
									class="input-group-addon"><i
									class="glyphicon glyphicon-ok form-control-feedback"></i></span>
							</div>
						</div>
						<div class="form-group">
							<label for="InputEmail">Email Id</label>
							<div class="input-group">
								<input type="email" required="required" placeholder="Enter Email"
									name="userEmailId" id="InputEmail" class="form-control">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-ok form-control-feedback"></i></span>
							</div>
						</div>
						<div class="form-group">
							<label for="InputName">Contact Number</label>
							<div class="input-group">
								<input type="text" required="required" placeholder="Enter Contact Number"
									id="InputContactNumber" name="userContactNo" class="form-control"> <span
									class="input-group-addon"><i
									class="glyphicon glyphicon-ok form-control-feedback"></i></span>
							</div>
						</div>
					
<!-- 						<img id="captcha" -->
<!-- 							src="library/vender/securimage/securimage_show.php" -->
<!-- 							alt="CAPTCHA Image" /> <a href="#" -->
<!-- 							onclick="document.getElementById('captcha').src = 'library/vender/securimage/securimage_show.php?' + Math.random(); return false" -->
<!-- 							class="btn btn-info btn-sm">Show a Different Image</a><br /> -->
<!-- 						<div class="form-group" style="margin-top: 10px;"> -->
<!-- 							<input type="text" class="form-control" name="captcha_code" -->
<!-- 								id="captcha_code" -->
<!-- 								placeholder="For security, please enter the code displayed in the box." /> -->
<!-- 							<span class="help-block" style="display: none;">Please -->
<!-- 								enter the code displayed within the image.</span> -->
<!-- 						</div> -->

<!-- 						<span class="help-block" style="display: none;">Please -->
<!-- 							enter a the security code.</span>  -->
							
							<input type="submit" class="btn btn-primary" value="Add" id="submit" name="submit">

					</div>
					<div class="col-md-4 pull-right">
						<section class="text-left">
						<c:set var="msg"  value="${msg}"/>
							<c:choose>
							
							<c:when test="${empty msg}">
      		 				
    						</c:when>
    						
    						<c:otherwise>
    							${msg}
	    					</c:otherwise>
	    					
						</c:choose>
						</section>
					
					</div>
					
				</form>
			</div>
		</div>
		<div class="clearfooter"></div>
	</div>
	<jsp:include page="fragments/footer.jsp" />
</body>

</html>
