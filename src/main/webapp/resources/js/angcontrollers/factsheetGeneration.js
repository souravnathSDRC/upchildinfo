
//@author Sourav Keshari Nath

var app = angular.module("factsheetGenerationApp", [ 'ui.bootstrap', 'ngMaterial',
		'ngMessages' ]);

app.controller('FactsheetGenerationController', function($scope, $http, $timeout,$filter,templateGenerationService) {
		$scope.allTimeperiodList = [];
		$scope.allAreaList = [];
		$scope.allSubsectorList = [];
		$scope.areas = [];
		$scope.errorMessage = "";
		$("#loader-mask").fadeOut();
		$scope.selectedTimeperiod = {};
		$scope.selectedArea = {};
		
        /**
         * This method will be fetching timeperiod list from server
         * @author Sourav Keshari Nath
         * @since 1.1.0 * 
         */
        $scope.getTimeperiodList = function(id){
        	var url = "getTimePeriod";
		       templateGenerationService.getTimePeriodList(url).then(
	            function(data) {
	            	$scope.allTimePeriodList = data;
				});
        }
        $scope.getTimeperiodList();
        /**
         * This method will be fetching area list from server
         * @author Sourav Keshari Nath
         * @since 1.1.0 * 
         */
        $scope.getAreaList = function(){
        	var url = "getArea";
		       templateGenerationService.getAreaList(url).then(
	            function( data ) {
	            	$scope.allAreaList = $filter('filter')(data, {arealevel : 3}
	        		,true);
				});
        }
        $scope.getAreaList();
        
        $scope.selectTimeperiod = function(timeperiod){
        	$scope.selectedTimeperiod = timeperiod;
        }
        /**
         * This method will call for selecting area list
         * @author Sourav Keshari Nath
         * @since 1.1.0 * 
         */
        $scope.selectArea = function(area){
        	$scope.selectedArea = area;
        }
        /**
         * This method will call for downloading the template
         * @author Sourav Keshari Nath
         * @since 1.1.0 * 
         */
        $scope.download = function(){
        	$("#loader-mask").show();
    		$scope.selectedIUSList = $filter('filter')($scope.allIUSList, {selected : true,iusName:"!All Select"},true);
        	if($scope.selectedTimeperiod.nid != undefined && $scope.selectedArea.areaCode != undefined){
        		$scope.filteredArea = JSON.parse(angular.toJson($scope.selectedArea));
        		$scope.filteredTimeperiod = JSON.parse(angular.toJson($scope.selectedTimeperiod));
        		var area = [$scope.filteredArea];
            	$scope.model={
            			timePeriod:$scope.filteredTimeperiod,
            			dataModel:area
            	}
    		   var url = "downloadFactsheet";
		       templateGenerationService.downloadTemplate(url,$scope.model).then(
	            function( resultData ){
	               	$http({url : "downloadSheet?fileName=" +resultData.key,
    					method : 'POST',
    					contentType : 'application/json',
    					responseType:'arraybuffer'
    				}).then(function(result) {
    				    jsonData = result.data;
    				    var fName = resultData.key;
    				    if(fName != 'sessionExpired'){
    				    	var file =new Blob([jsonData], {type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"});
        					if(file.size>0)
        					{
    	    					var fileURL = (window.URL || window.webkitURL).createObjectURL(file);
    	    					var downloadLink = document.createElement("a");
    	
    	    					document.body.appendChild(downloadLink);
    	    					downloadLink.style = "display: none";
    	    					$("#loader-mask").fadeOut();
    	    					downloadLink.href = fileURL;
    	    					downloadLink.download = fName;
    	    					downloadLink.click();
    						}
    						else
    						{
    							$("#loader-mask").fadeOut();
    							$scope.errorMsg = "Factsheet generation failed";
    							$("#errorMessage").modal("show");
    						}
    				    }else{
    				    	$("#loader-mask").fadeOut();
							$scope.errorMsg = "Your session has expired, please login again to download the factsheet.";
							$("#errorMessage").modal("show");
    				    }
		    		}, function(error) {
		    			$("#loader-mask").fadeOut();
		    			jsonData = error;
		    			//deferred.reject(error);
		    		});
				});
        	}else{
        		$("#loader-mask").hide();
        		$scope.errorMsg = "Please select all mandatory fields";
				$("#errorMessage").modal("show");
        	}
        
        }
});
app.service("templateGenerationService",  function( $http, $q ) {
    return({
    	getTimePeriodList:getTimePeriodList,
    	getAreaList:getAreaList,
    	downloadTemplate:downloadTemplate,
    });
    function getTimePeriodList(urls) {
        var request = $http({
            method: "get",
            url: urls,
        });
        return( request.then( handleSuccess, handleError ) );
    }
    function getAreaList(urls) {
        var request = $http({
            method: "get",
            url: urls,
        });
        return( request.then( handleSuccess, handleError ) );
    }
    function downloadTemplate(urls,model) {
        var request = $http({
            method: "post",
            url: urls,
            data:JSON.stringify(model),
        });
        return( request.then( handleSuccess, handleError ) );
    }
    // I transform the error response, unwrapping the application dta from
    function handleError( response ) {
        // The API response from the server should be returned in a
        // nomralized format. However, if the request was not handled by the
        // server (or what not handles properly - ex. server error), then we
        // may have to normalize it on our end, as best we can.
        if (
            ! angular.isObject( response.data ) ||
            ! response.data.message
            ) {
            return( $q.reject( "An unknown error occurred." ) );
        }
        // Otherwise, use expected error message.
        return( $q.reject( response.data.message ) );
    }
    // I transform the successful response, unwrapping the application data
    // from the API response payload.
    function handleSuccess( response ) {
        return( response.data );
    }
}
);