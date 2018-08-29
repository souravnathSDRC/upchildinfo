// Angular app creation
var app = angular.module("esamapp",
		[ 'ngAnimate' ]);
app.currentStateUrl = function(scope) {
	var scope = angular.element($("#containerId")).scope();

	return rootURL + "/dashboard?" + "st=" + scope.selectedTimeperiod.key
			+ "%26ss=" + scope.selectedSector.key + "%26so="
			+  scope.selectedSource.key + "%26si="
			+ scope.selectedIndicator.description + "%26sg="
			+ scope.selectedGranularity.key + "%26sgn="
			+ scope.selectedGranularity.value + "%26sl="
			+ scope.selectedChildAreaLevel + "%26sd=" + scope.shouldDrilldown
			+ "%26smap=" + scope.selectedMapAreaType;
};

app.currentStateMailUrl = function(scope) {
	var scope = angular.element($("#containerId")).scope();

	// To be deleted
	// return "http://" + location.hostname
	// + (location.port ? ":" + location.port : "")
	return rootURL + "/dashboard?" + "st=" + scope.selectedTimeperiod.key
			+ "&ss=" + scope.selectedSector.key + "&so="
			+  scope.selectedSource.key + "&si="
			+ scope.selectedIndicator.description + "&sg="
			+ scope.selectedGranularity.key + "&sgn="
			+ scope.selectedGranularity.value + "&sl="
			+ scope.selectedChildAreaLevel + "&sd=" + scope.shouldDrilldown
			+ "&smap=" + scope.selectedMapAreaType;
};

app.directive("upchildinfoMap",
				function($window) {
					function link(scope, el) {
						var el = el[0];
						var DELAY = 300, clicks = 0, timer = null;

						// this is to clear map popover if it's visible.
						d3.select(".trend-viz").on("mouseover", function() {
							d3.select(".map_popover").style("display", "none");
						});

						$(".backbtn").click(function() {
							console.log("map area type"+ scope.selectedMapAreaType);
							//scope.selectMapAreaType(scope.selectedMapAreaType);
							if(scope.dataSection == "Secondary"){
								if(scope.typeofMap == "Tehsil"){
									scope.parentViewDataMap = "Districts";
									scope.typeofMap = "Districts";
									scope.selectMapAreaType(scope.typeofMap);
									scope.selectedGranularity = new ValueObject(
											scope.firstDrilDownGranularity.key, scope.firstDrilDownGranularity.value);
									
								}else{
									scope.typeofMap = "Division";
									scope.selectMapAreaType(scope.typeofMap);
									scope.shoulddisappear = "true";
								}
							}else{
								if(scope.typeofMap == "Block"){
									scope.typeofMap = "DistrictsBlock";
									scope.selectMapAreaType(scope.typeofMap);
									scope.selectedGranularity = new ValueObject(
											scope.firstDrilDownGranularity.key, scope.firstDrilDownGranularity.value);
									
								}else{
									scope.typeofMap = "DivisionBlock";
									scope.selectMapAreaType(scope.typeofMap);
									scope.shoulddisappear = "true";
								}
							}
							
						});

						function onmousemove(d) {
							d3.select(".map_popover")
									.style("display", "block")
									.style("left", (d3.event.layerX-80) + "px")// TODO:
									// make it dynamic so that position would be according to the text length
									.style("top", (d3.event.layerY-100) + "px")
									.style("opacity", "1");

						}

						function onover(d) {
							d3.selectAll(".activehover").classed("activehover",
									false);
							var rank,datavalue;
							d3.select(".map_popover_content").html(
									"<strong>Area Name:</strong> <span style='color:white'>"
											+ d.properties.NAME1_ + "</span>");

							if (d.properties.utdata && d.properties.utdata.rank) {
								rank = d.properties.utdata.rank;
								datavalue=d.properties.utdata.value;
							}else{
								rank = "Not Available";
								datavalue = "Not Available";
							}
							d3.select(".map_popover_close").html(
									"<strong>Rank:</strong> <span style='color:white'>"
									+ rank + "</span>"
									+ "<br><strong>Value:</strong> <span style='color:white'>"
											+ datavalue + "</span>");
							
							d3.select(this.parentNode.appendChild(this))
									.classed("activehover", true);
						}
						
						function drilldown(d) {
							var scope= angular.element($("#containerId")).scope();
							if (d.properties.NAME1_ && scope.shouldDrilldown) {
								d3.select(".map_popover").style("display",
										"none");
								scope.selectedGranularity = new ValueObject(
										d.properties.ID_, d.properties.NAME1_);
								scope.selectedChildAreaLevel = scope.selectedChildAreaLevel + 1;
								
								
								var url = "";
								if(scope.dataSection == "Secondary"){
									if(scope.selectedChildAreaLevel == 3){
										url = "resources/geomaps/UP_By_Tehsils/Division_Composite_District/"
										+ d.properties.NAME1_ + ".json";
										scope.shouldDrilldown = true;
										scope.firstDrilDownGranularity = new ValueObject(d.properties.ID_, d.properties.NAME1_);
										scope.parentViewDataMap = "Districts";
										scope.typeofMap = "Districts";
										scope.selectedMapAreaType = "Districts";
										$(".backbtn").toggleClass("hidden");
									}else{
										scope.shoulddisappear = false;
										url = "resources/geomaps/UP_By_Tehsils/District_Composite_Tehsil/"
											+ d.properties.NAME1_ + ".json";
										scope.shouldDrilldown = false;
										scope.typeofMap = "Tehsil";
										scope.selectedMapAreaType = "Tehsil";
										$(".backbtn").toggleClass("show");
									}
								}else{
									if(scope.selectedChildAreaLevel == 3){
										url = "resources/geomaps/UP_By_Blocks/Division_Wise_District_topoJSON/"
										+ d.properties.NAME1_ + ".json";
										scope.shouldDrilldown = true;
										scope.firstDrilDownGranularity = new ValueObject(d.properties.ID_, d.properties.NAME1_);
										scope.parentViewDataMap = "Districts";
										scope.typeofMap = "DistrictsBlock";
										scope.selectedMapAreaType = "DistrictsBlock";
										$(".backbtn").toggleClass("hidden");
									}else{
										scope.shoulddisappear = false;
										url = "resources/geomaps/UP_By_Blocks/District_Wise_Block_topoJSON/"
											+ d.properties.NAME1_ + ".json";
										scope.shouldDrilldown = false;
										scope.typeofMap = "Block";
										scope.selectedMapAreaType = "Block";
										$(".backbtn").toggleClass("show");
									}
								}
								scope.mapSetup(url, function() {
									scope.getutdata();
								});
							}

						}
						scope.isIndiaMap=true;
						scope.mapSetup = function(url, callbackMethod) {
							// console.log(url);
							// alert(result);
							d3.select(el).selectAll("*").remove();
							var w = scope.getWindowDimensions();
							var feature = "";
							//var width = w.w, height = w.h - 190, centered;
							var width = w.w, height = w.h - 190, centered;
							var projection = d3.geo.mercator().scale(1);
							var path = d3.geo.path().projection(projection);

							var svg = d3.select(el).append("svg").attr("id","mapsvg").attr("width", width).attr("height", height);
							svg.append("rect").attr({style : "fill:none;pointer-events:all;"})
							.attr("width", width)
							.attr("height", height)
							.on("click", clicked)
							.on("mouseover",function() {
										d3.select(".map_popover").style("display", "none");
										d3.selectAll(".activehover").classed("activehover", false);
							});

							var g = svg.append("g").attr("id", "mapg");

							d3.json(url,function(error, us) {
								var result = url.match(/UP_District/i);

										feature = topojson.feature(us,us.objects[scope.selectedGranularity.value]);

										var b = path.bounds(feature), s = 0.95 / Math.max((b[1][0] - b[0][0])/ width,(b[1][1] - b[0][1])/ height);
										projection.scale(s);
										b = d3.geo.bounds(feature);
										projection.center([(b[1][0] + b[0][0]) / 2,(b[1][1] + b[0][1]) / 2 ]);
										projection.translate([ width / 2,height / 2 ]);

										g.append("g").attr("id", "districts")
												.selectAll("path")
												.data(topojson.feature(us,us.objects[scope.selectedGranularity.value]).features)
												.enter()
												.append("path")
												.attr("d", path)
												.on("mousedown",clickHandler)
												.on("mouseover", onover);

										g.on("mousemove", onmousemove);
								if (callbackMethod)
									callbackMethod();
							});

							function clickHandler(d) {
								clicks++; // count clicks

								if (clicks === 1) {
									timer = setTimeout(function() {
										// action
										clicks = 0; // after action performed,
										// reset counter
									}, DELAY);

								} else {
									clearTimeout(timer); // prevent
									// single-click
									// action

									drilldown(d); // perform
									// double-click
									// action
									clicks = 0; // after action performed, reset
									// counter
								}
							}

							function clicked(d) {

								var x, y, k;
								if (d && centered !== d) {
									var centroid = path.centroid(d);
									x = centroid[0];
									y = centroid[1];
									k = 2.5;
									centered = d;
								} else {
									x = (width / 2) - 36;// this is to fix
									// the movement of
									// map when clicked.
									y = height / 2;
									k = 1;
									centered = null;
								}

								g.selectAll("path").classed("active",
										centered && function(d) {
											return d === centered;
										});

								g.transition().duration(750).attr(
										"transform",
										"translate(" + width / 2 + "," + height
												/ 2 + ")scale(" + k
												+ ")translate("
												+ (-x - width * 3 / 100) + ","
												+ -y + ")").style(
										"stroke-width", 1.5 / k + "px");

								scope.disablePdf = (d == null) ? false
										: scope.selectedArea == null ? true
												: d == scope.selectedArea ? false
														: true;
								//scope.showViz(d);
							}

						};

						scope.$watch("utdata",function() {
							
							var insertLinebreaks = function (d) {
								if(d.properties.utdata){
									 var el = d3.select(this);
									    if(scope.isIndiaMap){
									    	if(d.properties.NAME1_ == "Assam"){
									    		el.selectAll("*").remove();
									    		el.append('tspan').style("text-anchor","middle").text(d.properties.NAME1_);
											    el.append('tspan').style("text-anchor","middle").text(parseFloat(d.properties.utdata.value)).attr('x', el.attr("x")).attr('dy', '15');
									    	}
									    }else{
									    	el.selectAll("*").remove();
									    	el.append('tspan').style("text-anchor","middle").text(d.properties.SHORTNAME1_);
										    el.append('tspan').style("text-anchor","middle").text(parseFloat(d.properties.utdata.value)).attr('x', el.attr("x")).attr('dy', '15');
									    }
								}
							};
							d3.select("#mapsvg").selectAll("text").selectAll("*").remove();				
							d3.select("#mapsvg").selectAll("path")
							.attr("class",function(d) {
								if (!(scope.utdata && scope.utdata.dataCollection)) {
									d.properties.utdata = null;
									return;
								}
								for (var i = 0; i < scope.utdata.dataCollection.length; i++) {
									if (d.properties && d.properties.ID_ == scope.utdata.dataCollection[i].areaCode) {
										d.properties.utdata = scope.utdata.dataCollection[i];
										return scope.utdata.dataCollection[i].cssClass;
									} else {
										if (d.properties) {
											d.properties.utdata = null;
										}
									}
								}
							});
							d3.select("#mapsvg").selectAll("text").each(insertLinebreaks);
							
						}, true);	
				
						scope.$watch(scope.getWindowDimensions, function(
								newValue, oldValue) {
							scope.svgHeight = (newValue.h - 190);
							scope.svgWidth = (newValue.w);
							scope.style = function() {
								return {
									'height' : (newValue.h - 190) + 'px',
									'width' : (newValue.w) + 'px'
								};
							};
							w = scope.getWindowDimensions();
							width = w.w, height = w.h;
							d3.select("#mapsvg").attr({
								width : width,
								height : height - 190
							});
							d3.select("#mapsvg").selectAll("rect").attr({
								width : width,
								height : height - 190
							});

						}, true);
					}
					return {
						link : link,
						restrict : "E"
					};
				});

