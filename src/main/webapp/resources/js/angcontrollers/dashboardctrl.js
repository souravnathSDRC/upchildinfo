function ValueObject(key, value) {
	this.key = key;
	this.value = value;
}
app.controller("DashboardController",function($scope, $http, $window, $timeout,  $filter, dashBoardService ) {
	
	var w = angular.element($window);
	$scope.getWindowDimensions = function() {
		return {
			"h" : w.height(),
			"w" : (document.getElementById("mapdimenssion").clientWidth)
		};
	};
	// this is to make sure that scope gets changes as window get resized.
	w.on("resize", function() {
		$scope.$apply();
	});
	// Scope properties
	// $scope.indicators = [ new ValueObject("1", "Select Indicator") ];---
	$scope.indicators = [];
	$scope.timeformats = [];
	$scope.sectors = [];// [ new ValueObject("1", "Basic Info") ];
	$scope.sectorsDetails = [];
	$scope.utdata = [];
	$scope.legends = [];
	$scope.topPerformers = [];
	$scope.bottomPerformers = [];
	$scope.sources = [];
	$scope.ldata = [];
	$scope.PCldata = "";
	$scope.cldata = [];
	//$("#loader-mask").show();
	// select the first user of the list
	$scope.selectedMapAreaType = "Division";
	$scope.selectedTimeperiod = $scope.timeformats[0];
	$scope.selectedSector = $scope.sectors[0];
	$scope.selectedIndicator = $scope.indicators[0];
	$scope.selectedSource = $scope.sources[0];
	$scope.selectedGranularity = new ValueObject("IND009T", "UP_Division");
	$scope.selectedChildAreaLevel = 2;
	$scope.isTrendVisible = true;
	$scope.selectedArea = [];
	$scope.show = false;
	$scope.shouldDrilldown = true;
	$scope.disablePdf = false;
	$scope.shoulddisappear=false;
	$scope.isColumnVisible = false;
	$scope.isLineVisible = false;
	$scope.primary_url = "";
	$scope.query = "";
	$scope.dataSection = "Secondary";
	$scope.getDefaultIndicatorList1 = function(){
		var url= "indicators";
		var query = "indicatorType=Uttar Pradesh by Districts/Tehsil";
		if (query != "")
		url += "?" + query.trim("&");
	    dashBoardService.getIndicatorData(url).then(
        function( data ) {
			$scope.indicatorsData1 = data;
		});
	}
	$scope.getDefaultIndicatorList2 = function(){
		var url= "indicators";
		var query = "indicatorType=District/Block";
		if (query != "")
		url += "?" + query.trim("&");
	    dashBoardService.getIndicatorData(url).then(
        function( data ) {
			$scope.indicatorsData2 = data;
		});
	}
	$scope.getDefaultIndicatorList3 = function(){
		var url= "indicators";
		var query = "indicatorType=District/Tehsil";
		if (query != "")
		url += "?" + query.trim("&");
	    dashBoardService.getIndicatorData(url).then(
        function( data ) {
			$scope.indicatorsData3 = data;
		});
	}
	$scope.getDefaultIndicatorList1();
	$scope.getDefaultIndicatorList2();
	$scope.getDefaultIndicatorList3();
	
	$scope.maptype = [
		{selectedMap:'District',mapName:'UP_District',dataSearch:'District',isSelected:false},
		{selectedMap:'Division',mapName:'UP_Division',dataSearch:'Tehsil',isSelected:false},
		{selectedMap:'Districts',mapName:'UP_Division',dataSearch:'Tehsil',isSelected:false},
		{selectedMap:'Tehsil',mapName:'UP_Division',dataSearch:'Tehsil',isSelected:false},
		{selectedMap:'Division',mapName:'UP_Division',dataSearch:'Block',isSelected:false},
		{selectedMap:'Districts',mapName:'UP_Division',dataSearch:'Block',isSelected:false},
		{selectedMap:'Block',mapName:'UP_Division',dataSearch:'Block',isSelected:false}
	];
	$scope.mapSelection = function(map){
		angular.forEach($scope.maptype, function(value, key){
		      if(value.selectedMap == map){
		    	  value.isSelected = true;
		    	  $scope.selectedMapAreaType = value.dataSearch;
		      }else{
		    	  value.isSelected = false;
		      }
		    	  
		});
	};
	$scope.getSelectedMap = function(){
		angular.forEach($scope.maptype, function(value, key){
		      if(value.isSelected == true){
		    	  $scope.typeofMap = value.selectedMap;
		      }
		});
	};
	$scope.firstDrilDownGranularity = new ValueObject("IND009D", "UP_District");
	
	$scope.maptypeName = "";
	// Scope methods
	// expose a callable method for sectors
	$scope.selectSector = function(sector) {
		//cfpLoadingBar.start();
		$scope.selectedSector = sector;
		$scope.subSectors = $filter('filter')($scope.sectorsDetails, {
			nid : parseInt(sector.key)
		}, true);
		$scope.selectedSubsector = $scope.subSectors[0];
		$scope.defultSelector();
		//$scope.mapSelection($scope.typeofMap);
		//$scope.getindicators();
	};
	$scope.selectSubsectors = function(subsector) {
		$scope.selectedSubsector = subsector;
		$scope.defultSelector();
		//$scope.mapSelection($scope.typeofMap);
		//$scope.getindicators();
	}
	// expose a callable method to the view
	$scope.selectIndicator = function(indicator) {
		$scope.selectedIndicator = indicator;
		//$scope.mapSelection($scope.typeofMap);
		$("#loader-mask").show();
		$scope.getsource();
	};

	// expose a callable method to the source
	$scope.selectSource = function(source) {
		$scope.selectedSource = source;
		$scope.gettimeperiod();
	};
	// expose a callable method for time period
	$scope.selectTimeperiod = function(timeformat) {
		$scope.selectedTimeperiod = timeformat;
		$scope.getutdata();
	};

	$scope.getsectorsAndIndicatorData = function() {
		if($scope.selectedMapAreaType == "District"){
			$scope.selectedType = "District";
		}else if($scope.selectedMapAreaType == "DivisionBlock"){
			$scope.selectedType = "Block";
		}else if($scope.selectedMapAreaType == "DistrictsBlock"){
			$scope.selectedType = "Block";
		}else{
			$scope.selectedType = "Tehsil";
		}
		var url= "sectors?indicatorType="+$scope.selectedType;
		dashBoardService.getSectorData(url).then(
	        function( data ) {
            	$scope.sectorsDetails = data;
            	
				$scope.sectors = $filter('filter')($scope.sectorsDetails, {
					nid : -1
				}, true);
				$scope.selectedSector = $scope.sectors[0];
				$scope.subSectors = $filter('filter')($scope.sectorsDetails, {
					nid : parseInt($scope.sectors[0].key)
				}, true);
				$scope.selectedSubsector = $scope.subSectors[0];
					var url= "indicators";
					var query = "indicatorType="+$scope.selectedType;
					if (query != "")
					url += "?" + query.trim("&");
				    dashBoardService.getIndicatorData(url).then(
			            function( data ) {
			            	if($scope.selectedType == "District"){
			            		$scope.mergeData = $scope.indicatorsData1.concat($scope.indicatorsData3);
			            		$scope.indicatorsData = data.concat($scope.mergeData);
			            	}else if($scope.selectedType == "Tehsil"){
			            		$scope.mergeData = $scope.indicatorsData1.concat($scope.indicatorsData3);
			            		$scope.indicatorsData = data.concat($scope.mergeData);
			            	}else if($scope.selectedType == "Block"){
			            		$scope.indicatorsData = data.concat($scope.indicatorsData2);
			            	}
							if ($scope.indicators) {
								$scope.defultSelector();
								//$("#loader-mask").hide()
							}
						});
	      })
	};
	
	//********************* Feching part *****************/////////////
	$scope.indicatorsData = [];
	$scope.getindicators = function() {
		if($scope.selectedMapAreaType == "District"){
			$scope.selectedType = "District";
		}else if($scope.selectedMapAreaType == "DivisionBlock"){
			$scope.selectedType = "Block";
		}else if($scope.selectedMapAreaType == "DistrictsBlock"){
			$scope.selectedType = "Block";
		}else{
			$scope.selectedType = "Tehsil";
		}
		var url= "indicators";
		var query = "indicatorType="+$scope.selectedType;
		if (query != "")
			url += "?" + query.trim("&");
		    dashBoardService.getIndicatorData(url).then(
	            function( data ) {
	            	if($scope.selectedType == "District"){
	            		$scope.mergeData = $scope.indicatorsData1.concat($scope.indicatorsData3);
	            		$scope.indicatorsData = data.concat($scope.mergeData);
	            	}else if($scope.selectedType == "Tehsil"){
	            		$scope.mergeData = $scope.indicatorsData1.concat($scope.indicatorsData3);
	            		$scope.indicatorsData = data.concat($scope.mergeData);
	            	}else if($scope.selectedType == "Block"){
	            		$scope.indicatorsData = data.concat($scope.indicatorsData2);
	            	}
					if ($scope.indicators) {
						$scope.defultSelector();
						//$("#loader-mask").hide()
					}
				});
	};
	$scope.getindicators();
	$scope.getsectors = function() {
		if($scope.selectedMapAreaType == "District"){
			$scope.selectedType = "District";
		}else if($scope.selectedMapAreaType == "DivisionBlock"){
			$scope.selectedType = "Block";
		}else if($scope.selectedMapAreaType == "DistrictsBlock"){
			$scope.selectedType = "Block";
		}else{
			$scope.selectedType = "Tehsil";
		}
		var url= "sectors?indicatorType="+$scope.selectedType;
		dashBoardService.getSectorData(url).then(
	            function( data ) {
	            	$scope.sectorsDetails = data;
					$scope.sectors = $filter('filter')($scope.sectorsDetails, {
						nid : -1
					}, true);
					$scope.subSectors = $filter('filter')($scope.sectorsDetails, {
						nid : parseInt($scope.sectors[0].key)
					}, true);
					$scope.selectedSubsector = $scope.subSectors[0];
					//$("#loader-mask").hide()
	            })
	};
	$scope.getsectors();
	$scope.defultSelector = function(){
		$("#loader-mask").show();
		$scope.defaultselectedSector = {};
		if($scope.selectedSector){
			$scope.defaultselectedSector = $scope.selectedSector;
		}else{
			$scope.defaultselectedSector = $scope.sectors[0];
			$scope.selectedSector = $scope.sectors[0];
		}
		$scope.filteredsector = $filter('filter')($scope.sectorsDetails, {
			nid : parseInt($scope.defaultselectedSector.key)
		}, true);
		if($scope.filteredsector.length > 0){
			$scope.indicators = $filter('filter')($scope.indicatorsData, {
				nid : parseInt($scope.selectedSubsector.key)
			}, true);
		}else{
			$scope.indicators = $filter('filter')($scope.indicatorsData, {
				nid : parseInt($scope.defaultselectedSector.key)
			}, true);
		}
		$scope.selectedIndicator = $scope.indicators[0];
		$scope.getsource();
		
	};
	$scope.getsource = function(){
		var url= "sources";
		var query = "";
		if ($scope.selectedIndicator)
			query += "iusnid="+ $scope.selectedIndicator.description;
		if (query != "")
			url += "?" + query.trim("&");
		    dashBoardService.getSourceData(url).then(
	            function( data ) {
	            	$scope.sources = data;
	            	if ($scope.sources) {
						$scope.selectedSource = $scope.sources[0];
						$scope.gettimeperiod();
					}
					//$("#loader-mask").hide()
	            });
	};
	$scope.gettimeperiod = function(){
		var url= "timeperiod";
		var query = "";
		if ($scope.selectedIndicator)
			query += "iusnid=" + $scope.selectedIndicator.description+ "&";
		if ($scope.selectedSource)
			query += "sourceNid=" + $scope.selectedSource.key+ "&";
		if (query != "")
			url += "?" + query.trim("&");
		    dashBoardService.getTimeperiodData(url).then(
	            function( data ) {
	            	$scope.timeformats = data;
					if ($scope.timeformats) {
						$scope.selectedTimeperiod = $scope.timeformats[0];
					}
					$scope.getMapLoad($scope.selectedMapAreaType);
					$("#loader-mask").hide();
	            });
	};
	
	//********************* End Feching part *****************/////////////
	
	$scope.clearList = function(){
		$("#searchText")[0].value = "";
		$scope.query = "";
	};
	$scope.selectNewDropsownData=function(mapType){

	}
	$scope.parentViewDataMap = "Division";
	$scope.viewDataMap = "Tehsil";
	// expose a callable method Map areaType
	$scope.selectMapAreaType = function(mapAreaType) {
		//$scope.mapSelection(mapAreaType);
		$scope.selectedMapAreaType = mapAreaType;
        if(mapAreaType == "DivisionBlock"){
        	$scope.parentViewDataMap = "Division";
        	$scope.viewDataMap = "Block";
        	$scope.dataSection = "Primary";
        }else if(mapAreaType == "DistrictsBlock"){
        	$scope.parentViewDataMap = "District";
        	$scope.viewDataMap = "Block";
        	$scope.dataSection = "Primary";
        }else{
        	$scope.parentViewDataMap = $scope.selectedMapAreaType;
        	$scope.viewDataMap = "Tehsil";
        	$scope.dataSection = "Secondary";
        }
        if(mapAreaType != " "){
        	$("#loader-mask").show();
        	$scope.getsectorsAndIndicatorData();
        };
	};
	// expose a callable method Map areaType
	$scope.getMapLoad = function(mapAreaType) {
		var mapUrl = "";
		switch (mapAreaType) {
		case "District":
			mapUrl = "resources/geomaps/UP_By_Districts/UP_District.json";
			$scope.selectedChildAreaLevel = 3;
			$scope.shouldDrilldown = false;
			$scope.shoulddisappear=false;
			$scope.selectedGranularity = new ValueObject("IND009D", "UP_District");
			$scope.maptypeName = "";
			$(".backbtn").toggleClass("hidden", true);
			break;
		case "Division":
			mapUrl = "resources/geomaps/UP_By_Tehsils/UP_Division.json";
			$scope.selectedChildAreaLevel = 2;
			$scope.shouldDrilldown = true;
			$scope.shoulddisappear=true;
			$scope.selectedGranularity = new ValueObject("IND009T", "UP_Division");
			$(".backbtn").toggleClass("hidden", true);
			break;
		case "Districts":
			mapUrl = "resources/geomaps/UP_By_Tehsils/Division_Composite_District/"+ $scope.selectedGranularity.value + ".json";
			$scope.selectedChildAreaLevel = 3;
			$scope.shouldDrilldown = true;
			$scope.shoulddisappear=true;
			//$scope.selectedGranularity = new ValueObject("IND009T", "UP_Districts");
			break;
		case "Tehsil":
			mapUrl = "resources/geomaps/UP_By_Tehsils/District_Composite_Tehsil/"+ $scope.selectedGranularity.value + ".json";
			$scope.selectedChildAreaLevel = 4;
			$scope.shouldDrilldown = false;
			$scope.shoulddisappear=false;
			//$scope.selectedGranularity = new ValueObject("IND009T", "UP_Tehsil");
			break;
		case "DivisionBlock":
			mapUrl = "resources/geomaps/UP_By_Blocks/UP_Division.json";
			$scope.selectedChildAreaLevel = 2;
			$scope.shouldDrilldown = true;
			$scope.shoulddisappear=true;
			$scope.selectedGranularity = new ValueObject("IND009B", "UP_Division");
			$(".backbtn").toggleClass("hidden", true);
			break;	
		case "DistrictsBlock":
			mapUrl = "resources/geomaps/UP_By_Blocks/Division_Wise_District_topoJSON/"+ $scope.selectedGranularity.value + ".json";
			$scope.selectedChildAreaLevel = 3;
			$scope.shouldDrilldown = true;
			$scope.shoulddisappear=true;
			//$scope.selectedGranularity = new ValueObject("IND009B0", "UP_Division");
			//$(".backbtn").toggleClass("hidden", true);
			break;
		case "Block":
			mapUrl = "resources/geomaps/UP_By_Blocks/District_Wise_Block_topoJSON/"+ $scope.selectedGranularity.value + ".json";
			$scope.selectedChildAreaLevel = 4;
			$scope.shouldDrilldown = false;
			$scope.shoulddisappear=false;
			//$scope.selectedGranularity = new ValueObject("IND009B0", "UP_Division");
			//$(".backbtn").toggleClass("hidden", true);
			break;
		default:
			mapUrl = "resources/geomaps/UP_By_Tehsils/UP_Division.json";
			$scope.selectedChildAreaLevel = 2;
			$scope.shouldDrilldown = true;
			$scope.shoulddisappear=true;
			$scope.selectedGranularity = new ValueObject("IND009T", "UP_Division");
			$(".backbtn").toggleClass("hidden", true);
		}

		$scope.primary_url = mapUrl;

		$scope.mapSetup($scope.primary_url, function() {
			$scope.getutdata();
		});
	};
	$scope.start = function() {
		$(".right-arrow").click(function() {
			if (processStatus.requestRunning) {
				return;
			}
			processStatus.startProcess();
			if ($(".active-sector").length == 0) {
				$(".sectorlist").first().addClass("active-sector");
			}
			var activeElement = $(".active-sector");
			$visiblesec_width = $(".sector_wrap").outerWidth(true);

			$prevWidth = 0;
			activeElement.prevAll().each(function() {
				$prevWidth += parseInt($(this).outerWidth(true), 10);
			});

			$ulwidth = 0;
			$(".sectorlist").each(function(index) {
				$ulwidth += parseInt($(this).outerWidth(true), 10);
			});

			// get length of all lists present before active lists
			if ($visiblesec_width + $prevWidth < $ulwidth) {
				$(".sectorlists").animate({
					"left" : "-=" + activeElement.outerWidth(true)
				}, 300, function() {
					activeElement.removeClass("active-sector");
					activeElement.next().addClass("active-sector");
					processStatus.endProcess();
				});
			} else {
//				$(".right-arrow").addClass("disable");
				processStatus.endProcess();
			}
		});
		$(".left-arrow").click(function() {

			if (processStatus.requestRunning) {
				return;
			}
			processStatus.startProcess();

			var activeElement = $(".active-sector");
			if (activeElement.prev()) {
				$prevWidth = 0;
				activeElement.prevAll().each(function() {
					$prevWidth += parseInt($(this).outerWidth(true), 10);
				});

				if ($prevWidth > 0) {
					$(".sectorlists").animate({
						"left" : "+=" + activeElement.prev().outerWidth(true)
					}, 300, function() {
						activeElement.removeClass("active-sector");
						activeElement.prev().addClass("active-sector");
						processStatus.endProcess();
					});
				} else {
//					$(".left-arrow").addClass("disable");
					processStatus.endProcess();
				}
			} else {
//				$(".left-arrow").addClass("disable");
				processStatus.endProcess();
			}

		});


	};
	//******** @Author: Sourav Keshari Nath **********************//
	//******** css class implementing rank wise in utdata ********//
	$scope.cssDataSetting = function(legendsData,value,index){
			for (var i = 0; i < legendsData.length; i++) {
				if(legendsData[i].key != 'Not Available'){
					var firstVal = legendsData[i].key.split(' - ')[0];
					var secondVal = legendsData[i].key.split(' - ')[1];
					
					if($scope.isInt(value)){
						var val= parseInt(value);
						if(val >= parseInt(firstVal) && val <= parseInt(secondVal)){
							$scope.utdata.dataCollection[index].cssClass = legendsData[i].value;
						}
					}else{
						var val= parseFloat(value);
						if(val >= parseFloat(firstVal) && val <= parseFloat(secondVal)){
							$scope.utdata.dataCollection[index].cssClass = legendsData[i].value;
						}
					}
					
				}
				
			}
	};
	$scope.isInt = function(n){
	    return Number(n) === n && n % 1 === 0;
	}

	$scope.isFloat = function(n){
	    return Number(n) === n && n % 1 !== 0;
	}
	$scope.datamsgShow=false;
	$scope.getutdata = function() {
		// resetting all the data
		$("#loader-mask").show();
		$scope.utdata = [];
		$scope.legends = [];
		$scope.topPerformers = [];
		$scope.bottomPerformers = [];
		var url = "data";

		var query = "";
		if ($scope.selectedIndicator)
			query += "indicatorId=" + $scope.selectedIndicator.description
					+ "&";
		if ($scope.selectedGranularity)
			query += "areaId=" + $scope.selectedGranularity.key + "&";
		if ($scope.selectedSource)
			query += "sourceNid=" + $scope.selectedSource.key+ "&";
		if ($scope.selectedTimeperiod)
			query += "timeperiodId=" + $scope.selectedTimeperiod.key + "&";
		
		if ($scope.selectedChildAreaLevel)
			query += "childLevel=" + $scope.selectedChildAreaLevel + "&";
		if (query != "")
			url += "?" + query.trim("&");
		
		//Written by sourav k nath
		dashBoardService.getUtData(url) .then(
            function( data ) {
            	$scope.utdata = data;
            	if (data.dataCollection && data.dataCollection.length > 0) {
            		for (var i = 0; i < data.dataCollection.length; i++) {
            			$scope.cssDataSetting(data.legends,data.dataCollection[i].value,i);
            		}
            	}
            	$scope.utdata = $scope.utdata;
    			$scope.legends = data.legends ? data.legends : [];
    			
    			if ($scope.legends && $scope.legends.length > 0) {
    				for (var i = 0; i < data.legends.length; i++) {
    					$scope.legends[i].key = data.legends[i].key == 'Not Available' ? data.legends[i].key
    							: data.legends[i].key
    									.split(' - ')[0]
    									+ ' - '
    									+ data.legends[i].key
    											.split(' - ')[1];
    				}
    			}
    			$scope.topPerformers = data.topPerformers;
    			if($scope.topPerformers ){
    				for (var i = 0; i < data.topPerformers.length; i++) {
    					$scope.topPerformers[i] = data.topPerformers[i].split(' - ')[0] + ' - ' + parseFloat(data.topPerformers[i].split(' - ')[1]);
    				}
    			}
    			$scope.bottomPerformers = data.bottomPerformers;
    			if($scope.bottomPerformers){
    				for (var i = 0; i < data.bottomPerformers.length; i++) {
    					$scope.bottomPerformers[i] = data.bottomPerformers[i].split(' - ')[0] + ' - ' + parseFloat(data.bottomPerformers[i].split(' - ')[1]);
    				}
    			}
    			
    			document.getElementById("legendsection").style.display = $scope.legends.length > 0 ? 'block' : 'none'; 
    			document.getElementById("tbsection").style.display = $scope.legends.length > 0 ? 'block' : 'none'; 
    			$("#loader-mask").hide();
    			//cfpLoadingBar.complete();
            }
        );
	
	};
	
	$scope.lineChartValue = function() {
		$http.get(

				'lineData?iusNid=' + $scope.selectedIndicator.description
						+ '&areaNid=' + $scope.selectedArea.properties.utdata.areaNid)

				.success(function(data) {
					if(data.length <=100){
//					 $scope.isnodata = false;
					$scope.cldata = [];
					$scope.ldata = data;
					$scope.PCldata = data[0][0];
					if($scope.PCldata.percentageChange == 0.00){
						$scope.PCldata ="";
					}
					$scope.isColumnVisible = false;
//					$scope.lineChartValue();
					if(data.length == 0){
						$scope.closeViz();
					}
					}
					// console.log(data);
				});
	};

	$scope.columnChartdataValue = function() {
		$http.get(

				'ColData?iusNid=' + $scope.selectedIndicator.description
						+ '&areaNid=' + $scope.selectedArea.properties.utdata.areaNid)

				.success(function(data) {
//					 $scope.isnodata = false;
					$scope.ldata = [];
					$scope.cldata = data;
					$scope.PCldata ="";
					$scope.isColumnVisible = true;
//					$scope.columnChartdataValue();
					if(data.length == 0){
						$scope.closeViz();
					}
					// console.log(data);
				});
	};

	$scope.complete = function() {
		//cfpLoadingBar.complete();
	};

	// fake the initial load so first time users can see the bar right away:
	$scope.start();

	$scope.style = function() {

	};
});
app.service("dashBoardService",  function( $http, $q ) {
            return({
            	getUtData: getUtData,
            	getIndicatorData:getIndicatorData,
            	getSectorData:getSectorData,
            	getSourceData:getSourceData,
            	getTimeperiodData:getTimeperiodData
            });
            function getIndicatorData(urls) {
                var request = $http({
                    method: "get",
                    url: urls,
                });
                return( request.then( handleSuccess, handleError ) );
            }
            function getSectorData(urls) {
                var request = $http({
                    method: "get",
                    url: urls,
                });
                return( request.then( handleSuccess, handleError ) );
            }
            function getSourceData(urls) {
                var request = $http({
                    method: "get",
                    url: urls,
                });
                return( request.then( handleSuccess, handleError ) );
            }
            function getTimeperiodData(urls) {
                var request = $http({
                    method: "get",
                    url: urls,
                });
                return( request.then( handleSuccess, handleError ) );
            }
            function getUtData(urls) {
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