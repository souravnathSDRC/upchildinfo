<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html lang="en">

<jsp:include page="fragments/headTag.jsp" />

<body>
<div id="wrapper">
		<jsp:include page="fragments/bodyHeader.jsp" />
		<div class="content">
			<div class="container-fluid">
    <spring:url value="/resources/images/exception.png" var="petsImage"/>
	<div align="center">
	<br><br>
    <h2>Everything good takes its own sweet time...</h2>
    <h4>This feature is Work In Progress.</h4>
	</div>

    <!-- Exception: ${exception.message}.
		  	<c:forEach items="${exception.stackTrace}" var="stackTrace"> 
				${stackTrace} 
			</c:forEach>
	  	-->
</div>

    <jsp:include page="fragments/footer.jsp"/>

</div></div>
</body>

</html>
