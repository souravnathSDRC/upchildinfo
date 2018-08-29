<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="en">

<jsp:include page="fragments/headTag.jsp" />
<body>
	<div id="wrapper" ng-app="newsApp">
		<jsp:include page="fragments/bodyHeader.jsp" />


		<div class="container contain-box" ng-controller="newsController">
		  <div class="row">
		    <div class="col-md-12">
		      <h3>Recent News</h3>
		      	<table id="example" class="table table-striped table-bordered"
						width="100%" cellspacing="0" style="margin-top:30px">
<!-- 						<thead> -->
<!-- 							<tr class="headingCLR"> -->
<!-- 								<th class="borderRight"><h3></h3></th> -->
<!-- 							</tr> -->
<!-- 						</thead> -->

						<tbody>
							<tr dir-paginate="item in newDataObj |itemsPerPage: pageSize" >
								<td >&bull; {{item.newsMessage}}</td>
							</tr>
						</tbody>
					</table>
				  <!--Pagination -->
				    <div ng-controller="PaginationController" style="margin-bottom:40px">
			          <div class="text-right">
			          <dir-pagination-controls boundary-links="true" on-page-change="pageChangeHandler(newPageNumber)" template-url="resources/html/pagination.html"></dir-pagination-controls>
			          </div>
			        </div>
			       <!--End Pagination -->
		    </div>
		  </div>
			</div>
			<br><br><br><br><br>
		</div>
	<jsp:include page="fragments/footer.jsp" />
	<script src="resources/js/welcome.js"
	type="text/javascript"></script>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>

<script>
var newsApp = angular.module('newsApp', ['angularUtils.directives.dirPagination']);
newsApp.controller('newsController', function($scope,$http) {
	    $scope.currentPage = 1;
	    $scope.pageSize = 5;

	    $scope.pageChangeHandler = function(num) {
	       console.log('Pagination call ' + num);
	    };
	$http.get('getNewsLetters').success(function(data) {
      $scope.newDataObj=data;
	});
	
	/*
	 * Pagination code started here @Author - Sourav ke nath
	 * */
});
</script>
<script type="text/javascript" src="resources/js/pagination.js"></script>
<script type="text/javascript" src="resources/js/angcontrollers/paginationController.js"></script>
</html>
