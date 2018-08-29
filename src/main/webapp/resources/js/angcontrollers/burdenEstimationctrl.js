function ValueObject(key, value) {
	this.key = key;
	this.value = value;
}
function BurdenEstimationController($scope, $http, $window, $timeout, cfpLoadingBar) {

	var w = angular.element($window);
	$scope.getWindowDimensions = function() {
		return {
			"h" : w.height(),
			"w" : (w.width() * 90 / 100)
		};
	};
	// this is to make sure that scope gets changes as window get resized.
	w.on("resize", function() {
		$scope.$apply();
	});
	$('#memberModals').modal({
	    backdrop: 'static',
	    keyboard: false
	})

	$scope.activeBurdenStatus={};
	$scope.activeAreaStatus={};
	
	$scope.hideShareBtn=true;
	$scope.disablePdfBtn=false;
	$scope.welcomebody=true;
	$scope.burdenbody=false;
	$scope.timeperiodbody=false;
	$scope.levelbody=false;
	$scope.sourcebody=false;
	$scope.finishBtn=true;
	$scope.backBtn=false;
	$scope.backDisableBtn=true;
	$scope.nextDisableBtn=false;
	$scope.timeperiodValidation=true;
	$scope.currentStatus=0;
	var id=0;
	$scope.selectedBurdenId=0;
	$scope.next=function(slno){
		switch (slno) {
        case 1:
            $scope.welcomebody=false;
            $scope.burdenbody=true;
			$scope.currentStatus=1;
			$scope.finishBtn=true;
			$scope.nextDisableBtn=true;
			$scope.nextBtn=false;
			
			$scope.backDisableBtn=false;
            break;
        case 2:
            $scope.welcomebody=false;
            $scope.burdenbody=false;
			$scope.levelbody=true;
			$scope.currentStatus=2;
			$scope.nextDisableBtn=true;
			$scope.backDisableBtn=false;
            break;
        case 3:
        	$scope.getsources();
            $scope.multipleselectedsource=$("#sourceMultipleSelect").val();
			$scope.multipleselectedsourcename=$("#sourceMultipleSelect option:selected").text();
            $scope.welcomebody=false;
			$scope.levelbody=false;
			$scope.sourcebody=true;
			$scope.currentStatus=3;
			$scope.nextDisableBtn=true;
			$scope.backDisableBtn=false;
			$scope.finishBtn=true;	
			$scope.gettimeperiods();
			if($scope.sourcearray.length>0){
				$scope.finishBtn=true;	
				$scope.nextDisableBtn=false;
			}
			
            break;
        case 4:
        	$scope.selectedtimeperiodText=$("#timeperiodMultipleSelect option:selected").text();
        	$scope.multipleselectedtimeperiod=$("#timeperiodMultipleSelect option:selected").text();
        	$scope.welcomebody=false;
			$scope.levelbody=false;
			$scope.sourcebody=false;
			$scope.timeperiodbody=true;
			$scope.finishBtn=false;
			$scope.finishDisableBtn=true;
			$scope.nextBtn=true;
			$scope.currentStatus=4;
			$scope.finishDisableBtn=false;
            break;
        default:

       }
	}
	$scope.back=function(slno){
		switch (slno) {
        case 0:
            $scope.welcomebody=true;
            $scope.burdenbody=false;
			$scope.levelbody=false;
			$scope.currentStatus=0;
			$scope.finishBtn=true;
			$scope.nextBtn=false;
			$scope.nextDisableBtn=false;
			$scope.backDisableBtn=true;
			$scope.activeBurdenStatus={};
            break;
        case 1:
            $scope.welcomebody=false;
            $scope.burdenbody=true;
        	$scope.sourcebody=false;
			$scope.levelbody=false;
			$scope.currentStatus=1;
			$scope.finishBtn=true;
			$scope.nextBtn=false;
			$scope.nextDisableBtn=false;
			$scope.activeAreaStatus={};
            break;
        case 2:
            $scope.welcomebody=false;
            $scope.burdenbody=false;
        	$scope.sourcebody=false;
			$scope.levelbody=true;
			$scope.currentStatus=2;
			$scope.finishBtn=true;
			$scope.nextBtn=false;
			$scope.nextDisableBtn=false;
            break;
        case 3:
        	$scope.getsources();
            $scope.multipleselectedsource=$("#sourceMultipleSelect").val();
			$scope.multipleselectedsourcename=$("#sourceMultipleSelect option:selected").text();
            $scope.welcomebody=false;
			$scope.levelbody=false;
			$scope.timeperiodbody=false;
			$scope.sourcebody=true;
			$scope.currentStatus=3;
			$scope.finishBtn=true;
			$scope.nextBtn=false;
			$scope.nextDisableBtn=false;
			$scope.gettimeperiods();
            break;
        case 4:
			$scope.welcomebody=false;
			$scope.levelbody=false;
			$scope.sourcebody=false;
			$scope.timeperiodbody=true;
			$scope.finishDisableBtn=true;
			$scope.nextBtn=true;
			$scope.currentStatus=4;
            break;
        default:

       }
	}
	
//	$('#sourceMultipleSelect').multiselect({
//	    selectAllValue: 'multiselect-all',
//	    enableCaseInsensitiveFiltering: true,
//	    enableFiltering: true,
//	    maxHeight: '300',
//

	$scope.indicators = [];
	$scope.timeformats = [];
	$scope.burdens = [{id:264,name:"Number of Births",description:"Number of Births, Total (Number)",indicator:"Crude birth rate"},
	                  {id:271,name:"Number of Deaths",description:"Number of Deaths, Total (Number)",indicator:"Crude death rate"},
	                  {id:410,name:"Number of Infant Deaths",description:"Number of Infant Deaths, Total (Number)",indicator:"Infant Mortality Rate"},
	                  {id:844,name:"Number of Under Five Deaths",description:"Number of Under Five Deaths, Total (Number)",indicator:"Under-five Mortality Rate (U5MR)"}];
	$scope.computeutdata = [];
	$scope.legends = [];
	$scope.topPerformers = [];
	$scope.bottomPerformers = [];
	$scope.sources = [];
	$scope.ldata = [];
	$scope.PCldata = "";
	$scope.cldata = [];

	// select the first user of the list
	$scope.selectedMapAreaType = "";
	$scope.selectedTimeperiod = $scope.timeformats[0];
	
	
	$scope.iusNIdForProjection=754;
	$scope.sourceNIdForProjection=15;
	
	$scope.selectedIndicator = "10";//$scope.indicators[0];
	$scope.selectedBurden = $scope.burdens[0].name;
	$scope.selectedBurdenDescription=$scope.burdens[0].description;
	$scope.selectedBurdenId=$scope.burdens[0].id;
	$scope.selectedSource = $scope.sources[0];
	$scope.multipleselectedsource="";
	$scope.selectedGranularity = new ValueObject("IND018", "Assam");
	$scope.selectedChildAreaLevel = 3;
	$scope.selectedUnit=3;
	$scope.selectedSubGroup=1;
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
	// Scope methods
	// expose a callable method to the burden
	$scope.selectBurden = function(burden) {
		$scope.selectedBurden = burden.name;
		$scope.selectedBurdenIndicator = burden.indicator;
		$scope.selectedBurdenDescription=burden.description;
		$scope.selectedBurdenId=burden.id;
		$scope.nextDisableBtn=false;
		$scope.burdens = [{id:264,name:"Number of Births",description:"Number of Births, Total (Number)",indicator:"Crude birth rate"},
		                  {id:271,name:"Number of Deaths",description:"Number of Deaths, Total (Number)",indicator:"Crude death rate"},
		                  {id:410,name:"Number of Infant Deaths",description:"Number of Infant Deaths, Total (Number)",indicator:"Infant Mortality Rate"},
		                  {id:844,name:"Number of Under Five Deaths",description:"Number of Under Five Deaths, Total (Number)",indicator:"Under-five Mortality Rate (U5MR)"}];
	};
	
	$scope.selectMapAreaType = function(mapAreaType){
		$scope.selectedMapAreaType = mapAreaType;
		if(mapAreaType=="State"){
			$scope.activeAreaStatus.activeItem=mapAreaType;
			$scope.selectedChildAreaLevel=2;
			$scope.selectedGranularity = new ValueObject("IND", "India");
		}else{
			$scope.activeAreaStatus.activeItem=mapAreaType;
			$scope.selectedChildAreaLevel=3;
			$scope.selectedGranularity = new ValueObject("IND018", "Assam");
		}
		$scope.nextDisableBtn=false;
		$scope.getsources();
	}

	// expose a callable method to the source
	$("#timeperiodMultipleSelect").change(function(){
		$scope.selectedSource = $(this).val();
		if($scope.selectedSource>0){
			//$scope.finishBtn=false;	
			//$scope.finishDisableBtn=false;
		}
	});

	// expose a callable method for time period
	$scope.selectTimeperiod = function(timeformat) {
		//cfpLoadingBar.start();
		$scope.selectedTimeperiod = timeformat;
		//$scope.getutdata();
	};
	
	$scope.clearList = function(){
		$("#searchText")[0].value = "";
		$scope.query = "";
		
//		$scope.$apply();
	};
	 //	multiple select drop down
	 $('#sourceMultipleSelect').multiselect({
	    // includeSelectAllOption: true
		 maxHeight: '300'
	 }); 
	 $('#timeperiodMultipleSelect').multiselect({
	     //includeSelectAllOption: true
		 maxHeight: '300'
	 });

	 
	// expose a callable method Map areaType
	$scope.selectMapAreaType_Load = function(mapAreaType, sg, sl, sd) {

		$scope.closeViz();
		$scope.selectedMapAreaType = mapAreaType;
		var mapUrl = "";
		switch (mapAreaType) {
		case "State":
			mapUrl = "resources/geomaps/India.json";
			$scope.selectedChildAreaLevel = 2;
			$scope.shouldDrilldown = true;
			$scope.shoulddisappear=true;
			$scope.selectedGranularity = new ValueObject("IND", "India");
			break;
		case "District":
			mapUrl = "resources/geomaps/Assam.json";
			$scope.selectedChildAreaLevel = 3;
			$scope.shouldDrilldown = true;
			$scope.shoulddisappear=false;
			$scope.selectedGranularity = new ValueObject("IND018", "Assam");
			break;
		default:
			mapUrl = "resources/geomaps/Assam.json";
			$scope.selectedChildAreaLevel = 3;
			$scope.shouldDrilldown = true;
			$scope.shoulddisappear=false;
			$scope.selectedGranularity = new ValueObject("IND018", "Assam");
			break;
		}
		$(".backbtn").toggleClass("hidden", true);

		$scope.primary_url = mapUrl;

		if (sg && sl) {

			$scope.selectedChildAreaLevel = sl;
			$scope.shouldDrilldown = sd;
			$scope.selectedGranularity = sg;
			$scope.primary_url = "resources/geomaps/"
					+ $scope.selectedGranularity.value + ".json";
		}
		$scope.mapSetup($scope.primary_url, function() {
			cfpLoadingBar.start();
			$scope.getutdata();
		});
	};

	$scope.closeViz = function() {
		$scope.isTrendVisible = false;
		$scope.cldata = [];
		$scope.ldata = [];
		$scope.PCldata ="";
	};
	$scope.showViz = function(areacode) {
		if (areacode && $scope.selectedArea != areacode) {
			$scope.selectedArea = areacode;
		} else {
			$scope.selectedArea = [];
		}
		$scope.$apply();
	};
	$scope.start = function() {
		//cfpLoadingBar.start();
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
	   $('#memberModals').modal('show');
	   $scope.finish=function(){
			var smap = $.urlParam("smap") != 0 ? $.urlParam("smap"): $scope.selectedMapAreaType;
			
			var sg = $.urlParam("sg") != 0 ? new ValueObject($.urlParam("sg"),$.urlParam("sgn"))
					: $scope.selectedGranularity;
			var sl = $.urlParam("sl") != 0 ? $.urlParam("sl"): $scope.selectedChildAreaLevel;
		
			$scope.selectMapAreaType_Load(smap,sg,sl,false);
			$scope.multipleselectedtimeperiod=$scope.selectedtimeperiodText;
			$('#memberModals').modal('hide');
	   }
  
		$scope.getsources = function() {
			var url= "getsourcesbylevel";
			var query = "";
			if ($scope.selectedBurdenId)
				query += "iusnid=" + $scope.selectedBurdenId+ "&";
			if ($scope.selectedBurdenId)
				query += "childLevel=" + $scope.selectedChildAreaLevel+ "&";
			if (query != "")
				url += "?" + query.trim("&");
			       $http.get(url).success(function(data) {
						$scope.sources = data;
						$scope.sourcearray=[];
						 angular.forEach($scope.sources, function(value, key) {
							 $scope.sourcearray.push({label:value.value,value:value.key});
						 });
						 $("#sourceMultipleSelect").multiselect('dataprovider', $scope.sourcearray);
						 $scope.$watch('sourcearray', function () {
							if($scope.sourcearray.length>0){
								//$scope.finishBtn=true;	
								$scope.nextDisableBtn=false;
				
							}
						 });
					});
		}
 	$scope.gettimeperiods = function() {
		var url= "timeperiod";
		var query = "";
		if ($scope.selectedBurdenId)
			query += "iusnid=" + $scope.selectedBurdenId+ "&";
		if ($scope.multipleselectedsource)
			query += "sourceNid=" +$scope.multipleselectedsource+ "&";
		if (query != "")
			url += "?" + query.trim("&");
		    $http.get(url).success(function(data) {
					$scope.timeformats = data;
					$scope.timeperiod=[];
					var d = new Date().getFullYear();
					var year=[];
					$http.get("timeperiod?iusnid="+$scope.iusNIdForProjection+"&sourceNid="+$scope.sourceNIdForProjection).success(function(data){
						 var firstIndexValue=parseInt(data[0].value);
							angular.forEach($scope.timeformats, function(value, key) {
								var splitVal=value.value.split("-")[0];
								var indexVal=firstIndexValue+11;
								if(indexVal<=splitVal){
									$scope.timeperiod.push({label:value.value,value:value.key});
							    }
							});
							 $("#timeperiodMultipleSelect").multiselect('dataprovider', $scope.timeperiod);
					});
					
				
					if ($scope.timeformats) {
						$scope.selectedTimeperiod = $scope.timeformats[0];
						//$scope.getutdata();
					}else{
						//$scope.getutdata();
					}
				});

	};
	$scope.getutdata = function() {
		
		// resetting all the data
		cfpLoadingBar.start();
		$scope.computeutdata = [];
		$scope.legends = [];
		$scope.topPerformers = [];
		$scope.bottomPerformers = [];
		var url = "burdendata";

		var query = "";
		if ($scope.iusNIdForProjection)
			query += "iusNIdForProjection="+$scope.iusNIdForProjection+ "&";
		if($scope.selectedBurdenId==410 || $scope.selectedBurdenId==844){
			if ($scope.selectedBurdenId)
				query += "iusNId="+264+ "&";
			if ($scope.selectedBurdenId)
				query += "iusNIdForIMRorU5MR="+$scope.selectedBurdenId+ "&";
		}else{
			if ($scope.selectedBurdenId)
				query += "iusNId="+$scope.selectedBurdenId+ "&";
			if ($scope.selectedBurdenId)
				query += "iusNIdForIMRorU5MR=0&";
		}
		if ($scope.selectedGranularity)
			query += "areaId=" + $scope.selectedGranularity.key + "&";
		if ($scope.multipleselectedtimeperiod)
			query += "timeperiodId=" + $scope.multipleselectedtimeperiod + "&";
		if ($scope.selectedChildAreaLevel)
			query += "childLevel=" + $scope.selectedChildAreaLevel + "&";
		if ($scope.sourceNIdForProjection)
			query += "sourceNIdForProjection=" + $scope.sourceNIdForProjection + "&";
		if ($scope.multipleselectedsource)
			query += "sourceNId=" + $scope.multipleselectedsource + "&";
		if ($scope.multipleselectedsource)
			query += "sourceNIdForIMRorU5MR="+$scope.multipleselectedsource+ "&";
		if (query != "")
			url += "?" + query.trim("&");
		$http.get(url).success(function(data) {
			$scope.computeutdata = data;
			$scope.legends = data.legends ? data.legends : [];
			
			if ($scope.legends && $scope.legends.length > 0) {
				for (var i = 0; i < data.legends.length; i++) {
					$scope.legends[i].key = data.legends[i].key == 'Not Available' ? data.legends[i].key
							: parseFloat(data.legends[i].key
									.split(' - ')[0])
									+ ' - '
									+ parseFloat(data.legends[i].key
											.split(' - ')[1]);
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
			
			cfpLoadingBar.complete();
		});
	};
	


	$scope.columnChartdataValue = function() {
		$http.get(

				'ColData?iusNid=' + $scope.selectedIndicator.description
						+ '&areaNid=' + $scope.selectedArea.properties.utdata.areaNid)

				.success(function(data) {
					$scope.ldata = [];
					$scope.cldata = data;
					$scope.PCldata ="";
					$scope.isColumnVisible = true;
					if(data.length == 0){
						$scope.closeViz();
					}
				});
	};

	$scope.complete = function() {
		cfpLoadingBar.complete();
	};

	// fake the initial load so first time users can see the bar right away:
//	/$scope.start();
//	$scope.fakeIntro = true;
//	$timeout(function() {
//		$scope.complete();
//		$scope.fakeIntro = false;
//	}, 30000);
	$scope.style = function() {

	};
}
