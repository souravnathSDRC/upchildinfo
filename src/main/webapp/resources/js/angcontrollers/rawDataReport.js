
//@author Sourav Keshari Nath

var app = angular.module("rawDataReportGenerationApp", [ 'ui.bootstrap', 'ngMaterial',
		'ngMessages' ]);

app.controller('RawDataReportGenerationController', function($scope, $http, $timeout,$compile,$filter,templateGenerationService) {
		$scope.allTimeperiodList = [];
		$scope.selectedTimeperiod = {};
		$("#loader-mask").hide();
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
       
        $scope.selectTimeperiod = function(timeperiod){
        	$scope.selectedTimeperiod = timeperiod;
        }
        /**
         * This method will call for downloading the template
         * @author Sourav Keshari Nath
         * @since 1.1.0 * 
         */
        $scope.download = function(){
        	$("#loader-mask").show();
        	if($scope.selectedTimeperiod.nid != undefined){
        		$http({url : "getRawDataReport",data:JSON.stringify(JSON.parse(angular.toJson($scope.selectedTimeperiod))),
    					method : 'POST',
    					contentType : 'application/json',
    					responseType:'arraybuffer'
    				}).then(function(result) {
    				    jsonData = result.data;
    				    var fName ="rawdata.xlsx";
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
							$scope.errorMsg = "Data Not Available";
							$("#errorMessage").modal("show");
						}
    					
		    		}, function(error) {
		    			$("#loader-mask").fadeOut();
		    			jsonData = error;
		    			deferred.reject(error);
		    		});
             }else{
            	 $("#loader-mask").fadeOut();
        		$scope.errorMsg = "Please select timeperiod";
				$("#errorMessage").modal("show");
             }
        }
});
app.service("templateGenerationService",  function( $http, $q ) {
    return({
    	getTimePeriodList:getTimePeriodList,
    });
    function getTimePeriodList(urls) {
        var request = $http({
            method: "get",
            url: urls,
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