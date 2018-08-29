<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="serror" uri="/WEB-INF/ErrorDescripter.tld"%>

<html lang="en" ng-app="esamapp">

<jsp:include page="fragments/headTag.jsp" />
<link rel="stylesheet" href="resources/css/customLoader.css">

<body>

	<div id="wrapper">
		<jsp:include page="fragments/bodyHeader.jsp" />
		<div id="containerId" class="content"
			ng-controller="DashboardController" ng-cloak>
			<div class="container-fluid">
				<div style="margin-top: 10px;">
					<serror:Error id="msgBox" errorList="${formError}"
						cssInfClass="${className}">
					</serror:Error>
				</div>
			</div>
			
			<div class="container-fluid">
				<div class="sectors" data-html2canvas-ignore="true">
					<nav class="sector" role="navigation">
						<div class="thumb">
<!-- 							<button class="navbar-toggle" data-toggsamikshaMaple="collapse" -->
<!-- 								data-target="#navsector"> -->
<!-- 								<span class="icon-bar"></span> <span class="icon-bar"></span> <span -->
<!-- 									class="icon-bar"></span> -->
<!-- 							</button> -->
							<div class="sector_wrap">
								<ul class="sectorlists">
									<li ng-repeat="sector in sectors" class="sectorlist"><a
										ng-class="{active:selectedSector.value == sector.value}"
										ng-click="selectSector(sector)" href="#"> {{sector.value}}</a></li>
								</ul>

							</div>
						</div>
					</nav>
					<div class="thumb_slide_ctrl">
						<a href="javascript:void(0)" class="left-arrow"><i
							class="fa fa-6 fa-caret-left" style="font-size: 2em"></i></a> <a
							href="javascript:void(0)" class="right-arrow"><i
							class="fa fa-6 fa-caret-right" style="font-size: 2em"></i></a>
					</div>
				</div>
			<div class="container">
			  <div class="row">
			    <div class="col-md-3">
			     <h3 style="line-height: 15px;">Dashboard</h3>
					<section class="mar-bot-15" data-html2canvas-ignore="true">
						<!-- left indicator section   -->
						<div class="btn-toolbar" role="toolbar">
							<div class="input-group samikshya-filter">

								<input type="text" placeholder="Select Subsector" readonly="" 
									class="form-control" ng-model="selectedSubsector.value"></input>
								<div class="input-group-btn" style="position: relative;">
									<button data-toggle="dropdown" id="ind-list"
										class="btn btn-primary dropdown-toggle" type="button" ng-click="clearList()">
										<i class="fa fa-list fa-lg"></i>
									</button>

									<ul class="dropdown-menu" role="menu"
										aria-labelledby="ind-list" id="ind_drop">
										<li	ng-repeat="subSector in subSectors | filter:query "
											title="{{subSector.value}}"><a
											ng-click="selectSubsectors(subSector)" href="#">
												{{subSector.value}}</a></li>
									</ul>
								</div>
								<!-- /btn-group -->
							</div>
							
						</div>
					</section>
					<section class="mar-bot-15" data-html2canvas-ignore="true">
						<!-- left indicator section   -->
						<div class="btn-toolbar" role="toolbar">
							<div class="input-group samikshya-filter">

								<input type="text" placeholder="Select indicator" readonly="" 
									class="form-control" ng-model="selectedIndicator.value"></input>
								<div class="input-group-btn" style="position: relative;">
									<button data-toggle="dropdown" id="ind-list"
										class="btn btn-primary dropdown-toggle" type="button" ng-click="clearList()">
										<i class="fa fa-list fa-lg"></i>
									</button>

									<ul class="dropdown-menu" role="menu"
										aria-labelledby="ind-list" id="ind_drop">
										<div>
											<form class="navbar-form navbar-left" role="search">
												<input class="form-control" ng-model="query" type="text"
													placeholder="search" autofocus
													onclick="event.cancelBubble=true;" id="searchText">
												<button class="btn btn-primary">
													<i class="fa fa-lg fa-search "></i>
												</button>
											</form>
										</div>
										<li
											ng-repeat="indicator in indicators | filter:query "
											title="{{indicator.value}}"><a
											ng-click="selectIndicator(indicator)" href="#">
												{{indicator.value}}</a></li>
									</ul>
								</div>
								<!-- /btn-group -->
							</div>
							
						</div>
					</section>
					<!-- left indicator section   -->
					<section class="mar-bot-15" data-html2canvas-ignore="true">
						<div class="btn-toolbar" role="toolbar">
							<div class="input-group samikshya-filter">

								<input type="text" placeholder="Select Source" readonly=""
									class="form-control" ng-model="selectedSource.value"></input>
								<div class="input-group-btn">
									<button data-toggle="dropdown" id="src-list"
										class="btn btn-primary dropdown-toggle pull-left"
										type="button">
										<i class="fa fa-book fa-lg "></i>

									</button>
									<ul class="dropdown-menu" role="menu"
										aria-labelledby="src-list" id="tp_drop">
										<li ng-repeat="source in sources"><a
											ng-click="selectSource(source)" href="#">
												{{source.value}}</a></li>
									</ul>
								</div>
								<!-- /btn-group -->
							</div>
						</div>
					</section>
					<section class="mar-bot-15" data-html2canvas-ignore="true">
						<div class="btn-toolbar" role="toolbar">
							<div class="input-group samikshya-filter">

								<input type="text" placeholder="" class="form-control" readonly=""
									ng-model="selectedTimeperiod.value"></input>
								<div class="input-group-btn">
									<button data-toggle="dropdown" id="tp-list"
										class="btn btn-primary dropdown-toggle pull-left"
										type="button">
										<i class="fa fa-lg fa-calendar"></i>
									</button>
									<ul class="dropdown-menu" role="menu" aria-labelledby="tp-list"
										id="tp_drop">
										<li ng-repeat="timeformat in timeformats"><a
											ng-click="selectTimeperiod(timeformat)" href="#">
												{{timeformat.value}}</a></li>
									</ul>
								</div>
								<!-- /btn-group -->
							</div>
						</div>
					</section>
					<section>
						<div>
							<button type="button" class="btn btn-default btn-sm btn_low"
								ng-class="{Division: 'active'}[selectedMapAreaType]"
								ng-click="selectMapAreaType('Division')">Tehsil</button>
							<button type="button" class="btn btn-default btn-sm btn_low"
								ng-class="{District: 'active'}[selectedMapAreaType]"
								ng-click="selectMapAreaType('District')">District</button>
							<button type="button" class="btn btn-default btn-sm btn_low"
								ng-class="{DivisionBlock: 'active'}[selectedMapAreaType]"
								ng-click="selectMapAreaType('DivisionBlock')">Block
							</button>	
							<button id="backBtn" type="button" 
								class="btn btn-default btn-sm backbtn hidden btn_low" >
								<i class="fa fa-lg fa-arrow-circle-o-up" ></i>Up
							</button>
						</div>
					</section>
					<section id="tbsection" class="topthree"  ng-show="legends.length > 0" ng-hide="legends.length == 0">
						<div class="mar-bot-5">
							<h4 class="top">Top 3</h4>
							<ul class="topperformers">
								<li ng-repeat="performer in topPerformers"><span>
										{{performer}}</span></li>
							</ul>
						</div>
						<div ng-show="bottomPerformers.length>0">
							<h4 class="bottom">Bottom 3</h4>
							<ul class="bottomperformers">
								<li ng-repeat="performer in bottomPerformers"><span>
										{{performer}}</span></li>
							</ul>
						</div>
				    </section>
			    </div>
			    <div class="col-md-6" id="mapdimenssion">
				    <div id="nodata" ng-class="{'show': utdata.dataCollection.length == 0}"	class="text-center nodata">
						<h3>
							<i class="fa fa-info-circle"></i>Info
						</h3>
						<h5 class="text-left">
							No data available for the selected indicator and time period.<br>Please
							modify your selection.
						</h5>
						<button type="button" class="btn btn-sm btn-primary" id="closepop">OK</button>
					</div>
					<div id="nodataForSelectedTime" 
						ng-class="{'show': utdata.dataCollection.length != 0 && utdata.topPerformers.length == 0}"
						class="text-center nodata">
						<h3>
							<i class="fa fa-info-circle"></i>Info
						</h3>
						<h5 class="text-left">
							No data available for the selected indicator for {{selectedTimeperiod.value}}.<br>Please
							select another time period.
						</h5>
						<button type="button" class="btn btn-sm btn-primary" id="closepop1">OK</button>
					</div>
				      <div class="map_popover">
						<div class="map_popover_close"></div>
						<div class="map_popover_content"></div>
					  </div>
					<!-- Map loading portion -->
					<div style="margin-bottom: 30px;">
						<upchildinfo-map ng-style="style()"
							style="display:block;margin-top: -15px; margin:auto"></upchildinfo-map>
					</div>
					<div data-html2canvas-ignore="true"	ng-show="shoulddisappear" style="text-align:center;margin-bottom:10px">
						<i>Double click on Uttar Pradesh {{parentViewDataMap}} to view {{viewDataMap}} data</i>
					</div>
			    </div>
			    <div class="col-md-3">
				    <div class="col-sm-3 pull-right" id="right_exportshare">
						<jsp:include page="fragments/exportandShare.jsp">
					     	<jsp:param value="Up_district" name="mapType" />
					     	<jsp:param value="{{utdata.dataCollection}}" name="utDataModelList" />
							<jsp:param value="containerId" name="exportcontainer" />
							<jsp:param value="{{selectedGranularity.key}}" name="areaId" />
							<jsp:param value="{{selectedIndicator.description}}" name="indicatorId" />
							<jsp:param value="{{selectedTimeperiod.key}}" name="timePeriodId" />
							<jsp:param value="{{selectedSource.key}}" name="sourceId" />
	
							<jsp:param value="{{selectedGranularity.value}}" name="area" />
							<jsp:param value="{{selectedIndicator.value}}" name="indicator" />
							<jsp:param value="{{selectedTimeperiod.value}}" name="timePeriod" />
							<jsp:param value="{{selectedSource.value}}" name="source" />
							<jsp:param value="{{selectedChildAreaLevel}}" name="childAreaLevel" />
						</jsp:include>
					</div>
			        <section class="selection-desc">
						<br>
   						  <div class="tooltips">
						   <span class=" glyphicon glyphicon-info-sign superscript" >
  								<span class="tooltiptexts">{{selectedIndicator.metadata.length!=0?selectedIndicator.metadata:'No Metadata available'}}</span>
							</span>
						  </div>
						  <span>{{selectedIndicator.value}}</span> 
					</section>
					<section id="legendsection" class="legends"	ng-show="legends.length > 0" ng-hide="legends.length == 0">
						<img alt="Responsive image"	src="resources/images/north_arrow_new.png">
						<h4>LEGEND</h4>
						<ul>
							<li ng-repeat="legend in legends" class="legend_list">
							<style>
							
							</style>
							<span class="legend_key">{{legend.key}}</span> <span
								class="{{legend.value}} legnedblock"> </span></li>
						</ul>
					</section>
			    </div>
			  </div>
			</div>

			</div>
			<div Style="height: 10px;"></div>
		</div>
	</div>
	<spring:url value="/webjars/angularjs/1.2.16/angular.min.js"
		var="angularmin" />
	<script src="${angularmin}" type="text/javascript"></script>
	<spring:url value="/webjars/angularjs/1.2.16/angular-animate.min.js"
		var="angularaAnimatemin" />
	<script src="${angularaAnimatemin}" type="text/javascript"></script>
	<script src="resources/js/loading-bar.js" type="text/javascript"></script>
	<script src="${loadingbarmin}" type="text/javascript"></script>

	<spring:url value="/webjars/d3js/3.4.6/d3.min.js" var="d3js" />
	<script src="${d3js}"></script>

	<jsp:include page="fragments/footer.jsp" />

	<script src="resources/js/sdrc.dashboard.js" type="text/javascript"></script>
	<script src="resources/js/angcontrollers/dashboardctrl.js"
		type="text/javascript"></script>
</body>

</html>
