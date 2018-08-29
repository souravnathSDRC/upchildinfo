//@author Sourav Keshari Nath

var app = angular.module("templateUploadApp", [ 'ui.bootstrap', 'ngMaterial','ngMessages' ]);
app.directive('fileModel', ['$parse', function ($parse) {
    return {
       restrict: 'A',
       link: function(scope, element, attrs) {
          var model = $parse(attrs.fileModel);
          var modelSetter = model.assign;
          
          element.bind('change', function(){
             scope.$apply(function(){
            	 var extension = element[0].files[0].name.split('.')[element[0].files[0].name.split('.').length-1];
            	 if(extension == "xlsx"){
            		 modelSetter(scope, element[0].files[0]);
            	 }else{
            		 scope.errorMsg = "Please select valid file";
            		 document.getElementById("uploadfile").value = "";
 	        		 $('#errorMessage').modal(); 
            	 }
            	 
             });
          });
       }
    };
 }]);


app.controller('TemplateUploadController', function($scope,fileUpload) {
	$scope.msg = "";
	$("#loader-mask").fadeOut();
	 var dropZone = document.getElementById('drop-zone');
	 	if(dropZone != null){
		    dropZone.ondrop = function(e) {
		        e.preventDefault();
		        this.className = 'upload-drop-zone';
		        document.getElementById("uploadfile").files = e.dataTransfer.files;
		    }
	 	
		    dropZone.ondragover = function() {
		        this.className = 'upload-drop-zone drop';
		        return false;
		    }

		    dropZone.ondragleave = function() {
		        this.className = 'upload-drop-zone';
		        return false;
		    }
	 	}    
	 $scope.uploadFile = function(){
		 $("#loader-mask").show();
		if(document.getElementById("uploadfile").value != ""){
			var file = $scope.myFile;
	        var uploadUrl = "excelFileUpload";
	        fileUpload.uploadFileToUrl(file, uploadUrl).then(
	        function( data ) {
	        	if(data.statusCode == 200){
	        		$("#loader-mask").fadeOut();
	        		document.getElementById("uploadfile").value = "";
	        		$scope.errorMsg = "File uploaded and data inserted successfully.";
	        		$('#pop').modal();
	        	}else{
	        		$("#loader-mask").fadeOut();
	        		$scope.errorMsg = data.message;
	        		$('#errorMessage').modal();
	        	}
	        	
			});
		}else{
			$("#loader-mask").fadeOut();
			$scope.errorMsg = "Please select template";
			$("#errorMessage").modal("show");
		}
   
     };
      
});
app.service("fileUpload",  function( $http, $q ) {
    return({
    	uploadFileToUrl:uploadFileToUrl
    });
    function uploadFileToUrl(file,urls) {
    	var fd = new FormData();
        fd.append('file', file);
       var request=  $http.post(urls, fd,{
            transformRequest : angular.identity,
            headers : {
                'Content-Type' : undefined
            }})
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