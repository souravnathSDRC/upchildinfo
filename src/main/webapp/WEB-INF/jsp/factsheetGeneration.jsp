<!DOCTYPE html>

<%@page import="org.sdrc.childinfo.util.Constants"%>
<%@page import="org.sdrc.childinfo.model.UserDetailsModel"%>
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
<body ng-app="factsheetGenerationApp" ng-controller="FactsheetGenerationController" ng-cloak>
	<div id="wrapper">
	<jsp:include page="fragments/bodyHeader.jsp" />
	<div id="spinner" class="loader" style="display: none;"></div>
	<div id="loader-mask" class="loader" style="display: none;"></div>
	<div class="content">
		<div class="container" style="text-align: center;">
			<div id="main-row" class="col-sm-12">
				<div class="col-sm-12 filter-options">
					<div class="col-sm-12">
						<h3>Factsheet Generation</h3>
					</div>
				</div>
				<div class="row mar-bot-15 mar-top-15" style="margin-top:80px">
				  <div class="col-sm-2 col-sm-offset-2 template-generation-lavel">Timeperiod <span class="star">*</span></div>
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
											ng-click="selectTimeperiod(timeperiod)">
												{{timeperiod.description}}</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row mar-bot-15">
				  <div class="col-sm-2 col-sm-offset-2 template-generation-lavel">District <span class="star">*</span></div>
				  <div class="col-sm-5">					 
                      <div class="btn-toolbar" role="toolbar">
							<div class="input-group samikshya-filter" id="myform">
							<input type="text" placeholder="Select District" readonly="false" 
									class="form-control" ng-model="selectedArea.areaName"></input>
								<div class="input-group-btn">
									<button data-toggle="dropdown" id="src-list"
										class="btn btn-primary dropdown-toggle pull-left"
										type="button">
										<i class="fa fa-list fa-lg"></i>
									</button>
									<div class="dropdown-menu checkbox-list" role="menu"
										aria-labelledby="src-list" >
                                      
											<input class="form-control" ng-model="query" type="text"
												placeholder="Search" autofocus onclick="event.cancelBubble=true;" id="search-box2">
											<button class="btn btn-primary" ng-click="query=''">
												<i class="glyphicon glyphicon-remove "></i>
											</button>
											<label style="display: flow-root;margin-top:10px" class="radio-btn dropdownlist-label">
												<div ng-repeat="level2 in allAreaList| filter:query" style="margin-left:5px">
													<label class="radio-btn dropdownlist-label" ng-click="selectArea(level2)">
																{{level2.areaName}}
									              	</label>
												</div>
							              	</label>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-6 col-sm-offset-3 filter-options">
						<div class="clearfix"></div>
						<md-button type="submit" style="background-color: #415684; color: #FFF;" ng-click="download()">Download</md-button>
				</div>
			</div>
           </div>
		</div>
		<div id="errorMessage" class="modal fade" role="dialog" data-backdrop="static" data-keyboard="false">
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
		src="resources/js/angcontrollers/factsheetGeneration.js"></script>
</body>

</html>