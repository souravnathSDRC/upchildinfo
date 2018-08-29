<!DOCTYPE html>

<%@page import="org.sdrc.childinfo.util.Constants"%>
<%@ page import="org.sdrc.childinfo.model.UserDetailsModel"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="serror" uri="/WEB-INF/ErrorDescripter.tld"%>
<%
	UserDetailsModel user = null;
%>
<%
	user = (UserDetailsModel) request.getSession().getAttribute(Constants.USER_PRINCIPAL);
%>

<html lang="en">
<jsp:include page="fragments/headTag.jsp" />
<link rel="stylesheet" href="resources/css/customLoader.css">
<style>
	   .holder {
			position: absolute;
			margin: 7px 8px;
			color: #A3A3A3;
			cursor: auto;
			font-family: Helvetica;
			font-size: 11pt;
			z-index: 1;
		}
		
		.red{
		    color: red;
		}
		
		input {
		    padding:5px;
		    font-size:11pt;
		}
    </style>
<body ng-app="templateGenerationApp" ng-controller="TemplateGenerationController" ng-cloak>
	<div id="wrapper">
	<jsp:include page="fragments/bodyHeader.jsp" />
	<div id="spinner" class="loader" style="display: none;"></div>
	<div id="loader-mask" class="loader" style="display: none;"></div>
	
	<%if (user != null) {%>
	<div class="content">
		<div class="container" style="text-align: center;">
			<div id="main-row" class="col-sm-12">
				<div class="col-sm-12 filter-options">
					<div class="col-sm-12">
						<h3>Template Generation</h3>
					</div>
				</div>
				<div class="row mar-bot-15 mar-top-15" style="margin-top:80px">
				  <div class="col-sm-2 col-sm-offset-2 template-generation-lavel">Timeperiod <span class="star">*</span> </div>
				  <div class="col-sm-5">					 
						<div class="btn-toolbar" role="toolbar">
							<div class="input-group samikshya-filter">
								<input type="text" placeholder="Select Timeperiod" class="form-control" readonly=""
									ng-model="selectedTimeperiod.description"></input>
								<div class="input-group-btn">
									<button data-toggle="dropdown" id="tp-list"
										class="btn btn-primary dropdown-toggle pull-left"
										type="button">
										<i class="fa fa-lg fa-calendar"></i>
									</button>
									<ul class="dropdown-menu" role="menu" aria-labelledby="tp-list"
										id="tp_drop">
										<li ng-repeat="timeperiod in allTimePeriodList"><a
											ng-click="selectTimeperiod(timeperiod)" href="">
												{{timeperiod.description}}</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row mar-bot-15">
				  <div class="col-sm-2 col-sm-offset-2 template-generation-lavel">Subsector <span class="star">*</span></div>
				  <div class="col-sm-5">					 
						<div class="btn-toolbar" role="toolbar">
							<div class="input-group samikshya-filter">
								<input type="text" placeholder="Select Subsector" readonly=""
									class="form-control" ng-model="selectedSubsector.description"></input>
								<div class="input-group-btn" style="position: relative;">
									<button data-toggle="dropdown" id="ind-list"
										class="btn btn-primary dropdown-toggle" type="button" ng-click="clearList()">
										<i class="fa fa-list fa-lg"></i>
									</button>
									<div class="dropdown-menu checkbox-list" role="menu">
										<div ng-repeat="subSector in allSubsectorList">
												<label class="radio-btn dropdownlist-label" ng-click="selectSubsectors(subSector)">
										            {{subSector.description}}
								              	</label>
											</div>
									</div>
								</div>
							</div>
							
						</div>
					</div>
				</div>
				<div class="row mar-bot-15">
				  <div class="col-sm-2 col-sm-offset-2 float-sm-right  template-generation-lavel">IUS <span class="star">*</span></div>
				  <div class="col-sm-5">					 
						<div class="btn-toolbar" role="toolbar">
							<div class="input-group samikshya-filter" >
								<input type="text" placeholder="Select Multiple IUS" readonly=""
									class="form-control" ng-model="selectedIUS" title="{{titleforIUS}}"></input>
								<div class="input-group-btn">
									<button data-toggle="dropdown" id="ind-list"
										class="btn btn-primary dropdown-toggle" type="button" ng-click="clearList()">
										<i class="fa fa-list fa-lg"></i>
									</button>
									<div class="stop-propogation dropdown-menu checkbox-list" role="menu"
										aria-labelledby="src-list" id="tp_drop">
											<input class="form-control" ng-model="query" type="text"
												placeholder="Search" autofocus id="search-box">
											<button class="btn btn-primary" ng-click="query=''">
												<i class="glyphicon glyphicon-remove"></i>
											</button>
										<div style="margin-top:10px">
										<div ng-repeat="ius in allIUSList | filter:query | orderBy:'iusNId'">
											<label class="radio-btn dropdownlist-label" ng-click="selectIUS(ius)">
									            <input type="checkbox" ng-model="ius.selected"></input>
														{{ius.iusName}}
							              	</label>
										</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row mar-bot-15">
				  <div class="col-sm-2 col-sm-offset-2 template-generation-lavel">Area Level <span class="star">*</span></div>
				  <div class="col-sm-5">					 
						<div class="btn-toolbar" role="toolbar">
							<div class="input-group samikshya-filter">
								<input type="text" placeholder="Select Area Level" readonly="false" 
									class="form-control" ng-model="selectedAreaLevel.areaName" title="{{titleforArea}}"></input>
								<div class="input-group-btn">
									<button data-toggle="dropdown" id="src-list"
										class="btn btn-primary dropdown-toggle pull-left"
										type="button">
										<i class="fa fa-list fa-lg"></i>
									</button>
									<div class="dropdown-menu checkbox-list" role="menu"
										aria-labelledby="src-list" id="tp_drop">
										<div ng-repeat="area in arealevel">
											<label class="radio-btn dropdownlist-label" ng-model="area.isSelected" ng-click="selectAreaLevel(area)">
<!-- 									            <input type="checkbox" ng-model="area.isSelected" ></input> -->
														{{area.areaName}}
							              	</label>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row mar-bot-15">
				  <div class="col-sm-2 col-sm-offset-2 template-generation-lavel">Area <span class="star">*</span></div>
				  <div class="col-sm-5">					 
						<div class="btn-toolbar" role="toolbar">
							<div class="input-group samikshya-filter" id="myform">
							<input type="text" placeholder="Select Multiple Area" readonly="false" 
									class="form-control" ng-model="selectedArea" title=""></input>
								<div class="input-group-btn">
									<button data-toggle="dropdown" id="src-list"
										class="btn btn-primary dropdown-toggle pull-left"
										type="button">
										<i class="fa fa-list fa-lg"></i>
									</button>
									<div class="stop-propogation dropdown-menu checkbox-list" role="menu"
										aria-labelledby="src-list" >
											<input class="form-control" ng-model="query1" type="text"
												placeholder="Search" autofocus id="search-box2">
											<button class="btn btn-primary" ng-click="query=''">
												<i class="glyphicon glyphicon-remove "></i>
											</button>
											<label style="display: flow-root;margin-top:10px" class="radio-btn dropdownlist-label"  ng-if="allAreaList.isVisible">
												<input type="checkbox" ng-model="selectAllObj.isSelected" ng-click="selectAll(selectAllObj)"></input>
												{{selectAllObj.areaName}}<br>
											</label>
											<label style="display: flow-root" class="radio-btn dropdownlist-label"  ng-if="allAreaList.isVisible">
									            <input type="checkbox" ng-model="allAreaList.isSelected" ng-click="selectArea(allAreaList)" ></input>
													{{allAreaList.areaName}}
														<div ng-repeat="level2 in allAreaList.items| filter:query1" style="margin-left:5px">
															<label class="radio-btn dropdownlist-label" ng-if="level2.isVisible">
													            <input type="checkbox" ng-model="level2.isSelected" ng-click="selectArea(level2)" ></input>
																		{{level2.areaName}}
																		<div ng-repeat="level3 in level2.items| filter:query1" style="margin-left:10px">
																			<label class="radio-btn dropdownlist-label"  ng-if="level3.isVisible">
																	            <input type="checkbox" ng-model="level3.isSelected" ng-click="selectArea(level3)"></input>
																						{{level3.areaName}}
																						<div ng-repeat="level4 in level3.items| filter:query1" style="margin-left:15px">
																							<label class="radio-btn dropdownlist-label" ng-if="level4.isVisible">
																					            <input type="checkbox" ng-model="level4.isSelected" ng-click="selectArea(level4,level3,level2)"></input>
																										{{level4.areaName}}
																										
																			              	</label>
																						</div>
															              	</label>
																		</div>
											              	</label>
														</div>
							              	</label>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div>
				<div class="clearfix"></div>
				<md-button type="submit" style="background-color: #415684; color: #FFF;" ng-click="download()">Download</md-button>
				</div>
			</div>
           </div>
		</div>
		
		<div id="errorMessage" class="modal fade" role="dialog"	data-backdrop="static" data-keyboard="false">
			<div class="modal-dialog">
				<!-- Modal content -->
				<div class="modal-content">
					<div class="modal-body text-center">
						<div class="errorhead"><img alt="" src="resources/images/Messages_warning_caution_icon.svg" style="width: 25px; margin-top: -5px;">&nbsp;ERROR</div>
						<div class="errorbody">{{errorMsg}}</div>
						<button type="button" class="btn errorOk" data-dismiss="modal" ng-click="closeModal()">Close</button>
					</div>
				</div>
			</div>
	    </div>
	    <div id="sesionExpiredErrorMessage" class="modal fade" role="dialog"	data-backdrop="static" data-keyboard="false">
			<div class="modal-dialog">
				<!-- Modal content -->
				<div class="modal-content">
					<div class="modal-body text-center" style="padding: 0 0 20px;">
						<div class="errorhead"><img alt="" src="resources/images/Messages_warning_caution_icon.svg" style="width: 25px; margin-top: -5px;">&nbsp;ERROR</div>
						<div class="errorbody">{{errorMsg}}</div>
						<form action="logout" method="post">
							<button type="submit" class="btn errorOk" class="close" aria-hidden="true">Close</button>
						</form>
					</div>
				</div>
			</div>
	    </div>
		<%} else{%>
		<div class="errorpage-div">
			<spring:url value="/resources/images/exception.png" var="petsImage"/>
		    <img src="${petsImage}"/>
		    <h2>Unauthorized access.</h2>
            <h3 class="access">Please <span style="color:#4a7196"><a onclick="javascript:login();">Log in</a></span> to access this page.
            </h3>
	    </div>
		<%}%>
		
	</div>

		<script type="text/javascript">
		$(document).ready(function() {
			$(document).on('click', '.stop-propogation', function (e) {
				  e.stopPropagation(); // it will not propagate the action to parent for closing
				});
			 $('#multi-select').multiselect();
			$("#msgBox").delay(2000).fadeOut(2000);
			$("#msgBoxlogin").delay(2000).fadeOut(2000);
			$("#upload-report").submit(function() {
				$(".loader").css("display", "block");
			})
		
		});
		(function($) {
		    $(document).ready(function() {
		        $('input').blur(function() {
		            var value = $.trim( $(this).val() );
		            $(this).val( value );
		        });
		    });
		})(jQuery);
	</script>
	<jsp:include page="fragments/footer.jsp" />
	<script src="resources/js/angular.min.js"></script>
	<script src="resources/js/ui-bootstrap-tpls-1.3.2.min.js"></script>
	<script src="resources/js/angular-animate.min.js"></script>
	<script src="resources/js/angular-aria.min.js"></script>
	<script src="resources/js/angular-messages.min.js"></script>
	<script src="resources/js/bootstrap-multiselect.js"></script>
	<link rel="stylesheet" href="resources/css/bootstrap-multiselect.css">
	<script
		src="http://ajax.googleapis.com/ajax/libs/angular_material/1.1.0-rc2/angular-material.min.js"></script>
	<script type="text/javascript"
		src="resources/js/angcontrollers/templateGeneration.js"></script>
</body>

</html>