
//@author Sourav Keshari Nath

var app = angular.module("templateGenerationApp", [ 'ui.bootstrap', 'ngMaterial',
		'ngMessages' ]);

app.controller('TemplateGenerationController', function($scope, $http, $timeout,$filter,templateGenerationService) {
		$scope.allTimeperiodList = [];
		$scope.subSectors = [];
		$scope.allAreaList = [];
		$scope.allSubsectorList = [];
		$scope.areas = [];
		$scope.themes = [];
		$scope.errorMessage = "";
		$("#loader-mask").fadeOut();
		$scope.selectedTimeperiod = {};
		$scope.selectedSubsector = {};
		$scope.selectedIUS = "";
		$scope.selectedAreaLevel = "";
		$scope.selectedArea = "";
        var count = 0;
        $scope.areaCout = [];

        $scope.arealevel = [
        	{level:1,areaName:"State",isSelected:false},
        	{level:2,areaName:"Division",isSelected:false},
        	{level:3,areaName:"District",isSelected:false},
        	{level:4,areaName:"Block",isSelected:false}
        ]
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
         * This method will be fetching ius list from server
         * @author Sourav Keshari Nath
         * @since 1.1.0 * 
         */
        $scope.getIUSList = function(id){
        	var url = "getIUS?id="+id;
		       templateGenerationService.getIUSList(url).then(
	            function(data) {
	            	$scope.allIUSList = data;
	            	$scope.allIUSList.push({indicatorId:0,
	            	indicatorName:"",
	            	iusNId:0,
	            	iusName:"All Select",
	            	selected:false,
	            	subgroupId:0,
	            	subgroupName:"",
	            	unitId:2,
	            	unitName:""})
				});
        }
        /**
         * This method will be fetching subsector list from server
         * @author Sourav Keshari Nath
         * @since 1.1.0 * 
         */
        $scope.getSubsectorList = function(){
        	var url = "getSubsector";
		       templateGenerationService.getSubsectorList(url).then(
	            function(data) {
	            	$scope.allSubsectorList = data;
				});
        }
        $scope.getSubsectorList();
        /**
         * This method will convert to an array to parent child wise
         * @author Sourav Keshari Nath
         * @since 1.1.0 * 
         */
        function convert(array){ 
        	var map = {};
        	for(var i = 0; i < array.length; i++){
        		var obj = array[i];
        		obj.items= [];
        		map[obj.areaNId] = obj;
        		var parent = obj.areaParentNId || '-'; 
        		if(!map[parent]){
        			map[parent] = {
        				items: [] 
        		};
        		}
        		map[parent].items.push(obj);
        		} 
        	return map["2397"]; 
        	}
        /**
         * This method will be fetching area list from server
         * @author Sourav Keshari Nath
         * @since 1.1.0 * 
         */
        $scope.getAreaList = function(){
        	var url = "getArea";
		       templateGenerationService.getAreaList(url).then(
	            function( data ) {
	            	$scope.allAreaList = data;
	            	$scope.allAreaList = convert($scope.allAreaList)
	            	$scope.allAreaList.areaName = "Uttar Pradesh";
				});
        }
        $scope.getAreaList();
        
        $scope.selectTimeperiod = function(timeperiod){
        	$scope.selectedTimeperiod = timeperiod;
        }
        $scope.selectSubsectors = function(subsector){
        	$scope.selectedSubsector = subsector;
        	$scope.selectedIUS = '';
        	$scope.getIUSList(subsector.nid);
        }
        /**
         * This method will call for selecting IusList
         * @author Sourav Keshari Nath
         * @since 1.1.0 * 
         */
        $scope.selectIUS = function(ius){
    		$scope.selectedIUSList = $filter('filter')($scope.allIUSList, {
    			selected : true
    		}, true);
    		var count=0;
    		for(var i=0;i<$scope.allIUSList.length;i++) {
				if($scope.allIUSList[i].selected == true){
					count++;
				}
    			
    		}
    		if($scope.allIUSList.length-1 == count){
    			for(var i=0;i<$scope.allIUSList.length;i++) {
    				if(ius.iusNId != 0){
    					if($scope.allIUSList[i].iusNId == 0 && $scope.allIUSList[i].selected ==false){
        					$scope.allIUSList[i].selected = true
        				}
    				}
        		}
    		}
        	if(ius.iusNId == 0){
        		if(ius.selected == true){
        			for(var i=0;i<$scope.allIUSList.length;i++) {
            			$scope.allIUSList[i].selected = true;
            		}
        		}else{
        			for(var i=0;i<$scope.allIUSList.length;i++) {
            			$scope.allIUSList[i].selected = false;
            		}
        		}
        		
        	}
        	if(ius.iusNId != 0){
        		if(ius.selected == false){
        			for(var i=0;i<$scope.allIUSList.length;i++) {
        				if($scope.allIUSList[i].iusNId ==0){
        					$scope.allIUSList[i].selected = false;
        				}
            			
            		}
        		}
        	}
    		$scope.titleforIUS = "";
    		var countforlevel = 0;
    		if($scope.selectedIUSList.length > 0){
        		for(var i=0;i<$scope.allIUSList.length;i++) {
    				if($scope.allIUSList[i].selected ==true && $scope.allIUSList[i].iusNId != 0){
    					$scope.titleforIUS = $scope.titleforIUS+"\n"+$scope.allIUSList[i].iusName;
    					countforlevel++;
    				}
        		}
        		if(countforlevel == 0){
        			$scope.selectedIUS = '';
        		}else{
        			$scope.selectedIUS = "Selected IUS - Count "+countforlevel;
        		}
    		}
        }
        /**
         * This method will call for selecting area level list
         * @author Sourav Keshari Nath
         * @since 1.1.0 * 
         */
        $scope.selectAreaLevel = function(arealevel){
        	$scope.selectAllObj.isSelected = false;
        	$scope.selectedAreaLevel = arealevel;

        	count=0;
        	$scope.selectedArea = "";
        	$scope.allAreaList.isVisible = true;
        	$scope.allAreaList.isSelected = false;
        	for (var i=0; i<$scope.allAreaList.items.length; i++) 
        	{
    			$scope.allAreaList.items[i].isSelected = false;
    			$scope.allAreaList.items[i].isVisible = false;
    			for (var j=0; j<$scope.allAreaList.items[i].items.length; j++) 
            	{
    				$scope.allAreaList.items[i].items[j].isSelected = false;
    				$scope.allAreaList.items[i].items[j].isVisible = false;
        				
    				for (var k=0; k<$scope.allAreaList.items[i].items[j].items.length; k++) 
                    	{
                			$scope.allAreaList.items[i].items[j].items[k].isSelected = false;
                			$scope.allAreaList.items[i].items[j].items[k].isVisible = false;
                    	}
    				
            	}
        	}
        	
        }
        /**
         * This method will call for selecting area list
         * @author Sourav Keshari Nath
         * @since 1.1.0 * 
         */
        $scope.selectArea = function(area){
        	// selected option will count
        	if(area.isSelected == true){
        		count++;
        	}else{
        		 $scope.selectAllObj.isSelected = false;
        		if(area.isSelected == false && area.arealevel == 1){
        			if(count!=0)count--;
        		}
        		if(area.items.length > 0){
        			for (var i=0; i<$scope.allAreaList.items.length; i++) 
    	        	{
        				var parentnid= 0;
            			  if(area.areaNId == $scope.allAreaList.items[i].areaParentNId){
            				if($scope.allAreaList.items[i].isSelected == true){
            					parentnid = $scope.allAreaList.items[i].areaNId;
            					if(count!=0)count--;
            				}
    					  }
            			  if($scope.allAreaList.items[i].areaNId == area.areaNId){
            				  parentnid = $scope.allAreaList.items[i].areaNId;
          					   if(count!=0)count--;
  	    				  }
                        if(area.arealevel == 1){
                        	for (var j=0; j<$scope.allAreaList.items[i].items.length; j++) 
        	            	{
	    	    				  if($scope.allAreaList.items[i].areaNId == $scope.allAreaList.items[i].items[j].areaParentNId){
	                				if($scope.allAreaList.items[i].items[j].isSelected == true){
	                					if(count!=0)count--;
	                				}
	        					  }
	    	    				  if($scope.allAreaList.items[i].items[j].areaNId == area.areaNId){
	                					if(count!=0)count--;
	    	    				  }
        	    				for (var k=0; k<$scope.allAreaList.items[i].items[j].items.length; k++) 
    	                    	{
        	    				  if($scope.allAreaList.items[i].items[j].areaNId == $scope.allAreaList.items[i].items[j].items[k].areaParentNId){
                    				if($scope.allAreaList.items[i].items[j].items[k].isSelected == true){
                    					if(count!=0)count--;
                    				}
            					  }
    	                    	}
        	    				
        	            	}
                        }else if(area.arealevel == 2){
                        	for (var j=0; j<$scope.allAreaList.items[i].items.length; j++) 
        	            	{
                        		var areanid= 0;
        	    				  if(parentnid == $scope.allAreaList.items[i].items[j].areaParentNId){
                    				if($scope.allAreaList.items[i].items[j].isSelected == true){
                    					areanid = $scope.allAreaList.items[i].items[j].areaNId;
                    					if(count!=0)count--;
                    				}
            					  }
        	    				  if($scope.allAreaList.items[i].items[j].areaNId == area.areaNId){
        	    					  areanid = $scope.allAreaList.items[i].items[j].areaNId;
                    				  if(count!=0)count--;
        	    				  }
        	    				for (var k=0; k<$scope.allAreaList.items[i].items[j].items.length; k++) 
    	                    	{
        	    				  if(areanid == $scope.allAreaList.items[i].items[j].items[k].areaParentNId){
                    				if($scope.allAreaList.items[i].items[j].items[k].isSelected == true){
                    					if(count!=0)count--;
                    				}
            					  }
    	                    	}
        	            	}
                        }else if(area.arealevel == 3){
                        	for (var j=0; j<$scope.allAreaList.items[i].items.length; j++) 
        	            	{
                        		var areanid= 0;
        	    				  if(parentnid == $scope.allAreaList.items[i].items[j].areaParentNId){
                    				if($scope.allAreaList.items[i].items[j].isSelected == true){
                    					areanid = $scope.allAreaList.items[i].items[j].areaNId;
                    					if(count!=0)count--;
                    				}
            					  }
        	    				  if($scope.allAreaList.items[i].items[j].areaNId == area.areaNId){
        	    					  areanid = $scope.allAreaList.items[i].items[j].areaNId;
                    					if(count!=0)count--;
        	    				  }
        	    				  for (var k=0; k<$scope.allAreaList.items[i].items[j].items.length; k++) 
    	                    	   {
	        	    				  if(areanid == $scope.allAreaList.items[i].items[j].items[k].areaParentNId){
	                    				if($scope.allAreaList.items[i].items[j].items[k].isSelected == true){
	                    					if(count!=0)count--;
	                    				}
	            					  }
    	                    	   }
        	            	}
                        }
    	        	}
        		}else{
        			if(count!=0)count--;
        		}
        	}
        	if(count>0){
        	    $scope.selectedArea = "Selected Area - Count "+count;
        	}else{
        		$scope.selectedArea = "";
        	}
        	if(area.arealevel == 1 && area.isSelected == false){
	        	for (var i=0; i<$scope.allAreaList.items.length; i++) 
	        	{
	    			$scope.allAreaList.items[i].isSelected = false;
	    			$scope.allAreaList.items[i].isVisible = false;
	    			for (var j=0; j<$scope.allAreaList.items[i].items.length; j++) 
	            	{
	    				$scope.allAreaList.items[i].items[j].isSelected = false;
	    				$scope.allAreaList.items[i].items[j].isVisible = false;
	        				
	    				for (var k=0; k<$scope.allAreaList.items[i].items[j].items.length; k++) 
	                    	{
	                			$scope.allAreaList.items[i].items[j].items[k].isSelected = false;
	                			$scope.allAreaList.items[i].items[j].items[k].isVisible = false;
	                    	}
	    				
	            	}
	        	}
        	}
        	if(area.arealevel == 2 && area.isSelected == false){
        		var index = $scope.allAreaList.items.indexOf(area);
    			for (var j=0; j<$scope.allAreaList.items[index].items.length; j++) 
            	{
    				$scope.allAreaList.items[index].items[j].isSelected = false;
    				$scope.allAreaList.items[index].items[j].isVisible = false;
        				
    				for (var k=0; k<$scope.allAreaList.items[index].items[j].items.length; k++) 
                	{
            			$scope.allAreaList.items[index].items[j].items[k].isSelected = false;
            			$scope.allAreaList.items[index].items[j].items[k].isVisible = false;
                	}
            	}
        	}
        	////Area level wise area selection//////
        	//$scope.selectedAreaLevel
            if(area.arealevel == 1 && $scope.selectedAreaLevel.level > area.arealevel){
        		for (var i=0; i<$scope.allAreaList.items.length; i++) 
            	{
					if($scope.allAreaList.isSelected == true){
		    	        $scope.allAreaList.items[i].isVisible = true;
					}else{
						$scope.allAreaList.items[i].isVisible = false;
						$scope.allAreaList.items[i].isSelected = false;
					}
            	}
        	}else if(area.arealevel == 2 && $scope.selectedAreaLevel.level > area.arealevel){
        		var index = $scope.allAreaList.items.indexOf(area);
    			for (var j=0; j<$scope.allAreaList.items[index].items.length; j++) 
            	{
    				if($scope.allAreaList.items[index].isSelected == true){
    					$scope.allAreaList.items[index].items[j].isVisible = true;
    				}else{
        				$scope.allAreaList.items[index].items[j].isVisible = false;
        				$scope.allAreaList.items[index].items[j].isSelected = false;
        				for (var k=0; k<$scope.allAreaList.items[index].items[j].items.length; k++) 
                    	{
        					if($scope.allAreaList.items[index].items[j].isSelected == true){
		            		    $scope.allAreaList.items[index].items[j].items[k].isVisible = true;
        					}else{
                				$scope.allAreaList.items[index].items[j].items[k].isVisible = false;
                				$scope.allAreaList.items[index].items[j].items[k].isSelected = false;
                			}
                    	}
        			}
            	}
        	}else if(area.arealevel == 3 && $scope.selectedAreaLevel.level > area.arealevel){
        		for (var i=0; i<$scope.allAreaList.items.length; i++) 
            	{
        			for (var j=0; j<$scope.allAreaList.items[i].items.length; j++) 
                	{
        				if($scope.allAreaList.items[i].isSelected == true){
	        				for (var k=0; k<$scope.allAreaList.items[i].items[j].items.length; k++) 
	                    	{
	        					if($scope.allAreaList.items[i].items[j].isSelected == true){
			            		    $scope.allAreaList.items[i].items[j].items[k].isVisible = true;
	        					}else{
	                				$scope.allAreaList.items[i].items[j].items[k].isVisible = false;
	                				$scope.allAreaList.items[i].items[j].items[k].isSelected = false;
	                			}
	                    	}
        				}
                	}
            	}
        	}
        }
        
        /**
         * select all button functionality
         * @author Pratyush
         */
        $scope.selectAllObj = {
        		areaCode:"SELECTALL",
        		areaNId:0,
        		areaName:"Select All",
        		areaParentNId:null,
        		arealevel:null,
        		isSelected:false,
        		isVisible:true,
        		items:[],
        		level:null
        };
        $scope.selectAll = function(selectAllObj){
        	count=0;
        	$("#loader-mask").show();
        	$timeout(function(){
        		if(selectAllObj.isSelected){
        			$scope.allAreaList.isSelected = true;
        			if($scope.selectedAreaLevel.level === 1){
        				$scope.selectArea($scope.allAreaList);
        			}else{
	            		for (var i=0; i<$scope.allAreaList.items.length; i++){
	            			if($scope.allAreaList.items[i].arealevel <= $scope.selectedAreaLevel.level){
	            				$scope.allAreaList.items[i].isSelected = true;
	                			$scope.allAreaList.items[i].isVisible = true;
	                			$scope.selectArea($scope.allAreaList.items[i]);
	                			for (var j=0; j<$scope.allAreaList.items[i].items.length; j++){
	                				if($scope.allAreaList.items[i].items[j].arealevel <= $scope.selectedAreaLevel.level){
	                					$scope.allAreaList.items[i].items[j].isSelected = true;
	                        			$scope.allAreaList.items[i].items[j].isVisible = true;
	                        			$scope.selectArea($scope.allAreaList.items[i].items[j]);
	                        			for (var k=0; k<$scope.allAreaList.items[i].items[j].items.length; k++){
	                        				if($scope.allAreaList.items[i].items[j].items[k].arealevel <= $scope.selectedAreaLevel.level){
	                        					$scope.allAreaList.items[i].items[j].items[k].isSelected = true;
	                                			$scope.allAreaList.items[i].items[j].items[k].isVisible = true;
	                                			$scope.selectArea($scope.allAreaList.items[i].items[j].items[k]);
	                        				}
	                        			}
	                				}
	                			}
	            			}
	            		}
        			}
            		
            	}else{
            		$scope.allAreaList.isSelected = false;
            		for (var i=0; i<$scope.allAreaList.items.length; i++){
        				$scope.allAreaList.items[i].isSelected = false;
            			$scope.allAreaList.items[i].isVisible = false;
            			$scope.selectArea($scope.allAreaList.items[i]);
            			for (var j=0; j<$scope.allAreaList.items[i].items.length; j++){
        					$scope.allAreaList.items[i].items[j].isSelected = false;
                			$scope.allAreaList.items[i].items[j].isVisible = false;
                			$scope.selectArea($scope.allAreaList.items[i].items[j]);
                			for (var k=0; k<$scope.allAreaList.items[i].items[j].items.length; k++){
            					$scope.allAreaList.items[i].items[j].items[k].isSelected = false;
                    			$scope.allAreaList.items[i].items[j].items[k].isVisible = false;
                			}
            			}
            		}

            	}
        		$("#loader-mask").hide();
        	},1000);
        };
        
        /**
         * This method will call for downloading the template
         * @author Sourav Keshari Nath
         * @since 1.1.0 * 
         */
        $scope.download = function(){
        	$("#loader-mask").show();
    		$scope.selectedIUSList = $filter('filter')($scope.allIUSList, {selected : true,iusName:"!All Select"}
    		,true);
    		$scope.arealists = [];
    		$scope.arealists.push({areaCode:$scope.allAreaList.areaCode,
				areaNId:$scope.allAreaList.areaNId,
				areaName:$scope.allAreaList.areaName,
				arealevel:$scope.allAreaList.arealevel,
				level:$scope.allAreaList.level});
    		for (var i=0; i<$scope.allAreaList.items.length; i++) 
        	{
    			if($scope.allAreaList.items[i].isSelected == true){
    			$scope.arealists.push({areaCode:$scope.allAreaList.items[i].areaCode,
    				areaNId:$scope.allAreaList.items[i].areaNId,
    				areaName:$scope.allAreaList.items[i].areaName,
    				arealevel:$scope.allAreaList.items[i].arealevel,
    				level:$scope.allAreaList.items[i].level});
    			for (var j=0; j<$scope.allAreaList.items[i].items.length; j++) 
            	{
    				if($scope.allAreaList.items[i].items[j].isSelected == true){
    		  			$scope.arealists.push({areaCode:$scope.allAreaList.items[i].items[j].areaCode,
    	    				areaNId:$scope.allAreaList.items[i].items[j].areaNId,
    	    				areaName:$scope.allAreaList.items[i].items[j].areaName,
    	    				arealevel:$scope.allAreaList.items[i].items[j].arealevel,
    	    				level:$scope.allAreaList.items[i].items[j].level});
        				for (var k=0; k<$scope.allAreaList.items[i].items[j].items.length; k++) 
                    	{
        					if($scope.allAreaList.items[i].items[j].items[k].isSelected == true){
            		  			$scope.arealists.push({areaCode:$scope.allAreaList.items[i].items[j].items[k].areaCode,
            	    				areaNId:$scope.allAreaList.items[i].items[j].items[k].areaNId,
            	    				areaName:$scope.allAreaList.items[i].items[j].items[k].areaName,
            	    				arealevel:$scope.allAreaList.items[i].items[j].items[k].arealevel,
            	    				level:$scope.allAreaList.items[i].items[j].items[k].level});
        					}
                    	}
    				}
            	}
    		  }
        	}
    		
        	if( $scope.selectedIUSList != undefined && $scope.selectedIUSList.length >0 && 
        			$scope.selectedSubsector != undefined && 
        			$scope.selectedTimeperiod.description != undefined &&
        			$scope.selectedArea !=""){
        		
        		$scope.filteredIUSList = JSON.parse(angular.toJson($scope.selectedIUSList)); //;
        		$scope.filteredSubsectorList = JSON.parse(angular.toJson($scope.selectedSubsector));
        		$scope.filteredTimeperiod = JSON.parse(angular.toJson($scope.selectedTimeperiod));
            	$scope.model={
            			timePeriod:$scope.filteredTimeperiod,
            			program:$scope.filteredSubsectorList,
            			iusModel:$scope.filteredIUSList,
            			dataModel:$scope.arealists
            	}
        		
    		   var url = "downloadExcelFile";
		       templateGenerationService.downloadTemplate(url,$scope.model).then(
	            function( result ){
	            	if(result.key === "sessionExpired"){
						$scope.errorMsg = "Your session has expired. Please login again to generate template.";
						$("#sesionExpiredErrorMessage").modal("show");
						$("#loader-mask").fadeOut();
	            	}else{
		               	$http({url : "downloadSheet?fileName=" +result.key,
	    					method : 'POST',
	    					contentType : 'application/json',
	    					responseType:'arraybuffer'
	    				}).then(function(result) {
	    					
	    				    jsonData = result.data;
	
	    				    var fName = result.config.url.substring(result.config.url.lastIndexOf("/") + 1, result.config.url.length);;
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
		    					$scope.refresh();
							}
							else
							{
								$("#loader-mask").fadeOut();
								$scope.errorMsg = "Template generation failed";
								$("#errorMessage").modal("show");
							}
			    		}, function(error) {
			    			$("#loader-mask").fadeOut();
			    			jsonData = error;
			    			//deferred.reject(error);
			    		});///
	            	}  	
				});
        	}else{
        		$("#loader-mask").hide();
        		$scope.errorMsg = "Please select all mandatory fields";
				$("#errorMessage").modal("show");
        	}
        }
        $scope.refresh=function(){
			$scope.selectedTimeperiod = {};
			$scope.selectedSubsector = {};
			$scope.selectedAreaLevel = {};
			count = 0;
			$scope.selectedArea = "";
			$scope.selectedIUS = "";
			$scope.allAreaList.isSelected = false;
			$scope.allIUSList = [];
    		for (var i=0; i<$scope.allAreaList.items.length; i++){
				$scope.allAreaList.items[i].isSelected = false;
    			$scope.allAreaList.items[i].isVisible = false;
    			$scope.selectArea($scope.allAreaList.items[i]);
    			for (var j=0; j<$scope.allAreaList.items[i].items.length; j++){
					$scope.allAreaList.items[i].items[j].isSelected = false;
        			$scope.allAreaList.items[i].items[j].isVisible = false;
        			$scope.selectArea($scope.allAreaList.items[i].items[j]);
        			for (var k=0; k<$scope.allAreaList.items[i].items[j].items.length; k++){
    					$scope.allAreaList.items[i].items[j].items[k].isSelected = false;
            			$scope.allAreaList.items[i].items[j].items[k].isVisible = false;
        			}
    			}
    		}

        }
});
app.service("templateGenerationService",  function( $http, $q ) {
    return({
    	getTimePeriodList:getTimePeriodList,
    	getAreaList:getAreaList,
    	getSubsectorList:getSubsectorList,
    	getIUSList:getIUSList,
    	downloadTemplate:downloadTemplate
    });
    function getTimePeriodList(urls) {
        var request = $http({
            method: "get",
            url: urls,
        });
        return( request.then( handleSuccess, handleError ) );
    }
    function getIUSList(urls) {
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
    function getSubsectorList(urls) {
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