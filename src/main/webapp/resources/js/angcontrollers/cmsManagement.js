var app = angular.module("uploadApp", [ 'ui.bootstrap', 'ngMaterial',
		'ngMessages' ]);

app.controller('UploadController', function($scope, $http, $timeout) {
							$scope.sections = [];
							$scope.themes = [];
							$scope.allReportTypes = [];
							$scope.selectedReport = {};
							$scope.selectedReport.tags = [];
							$scope.errorMessage = "";
							// get section and theme

							$scope.setPathFileDoc = function(file, x, y) {
								document.getElementById(x).value = "";
								$scope.showValue = "";
								$scope.biggerSizeDoc = false;
								$scope.wrongType = false;

								$scope.totalFileSize = 0;
								for (var i = 0; i < document.getElementById(y).files.length; i++) {

									$scope.totalFileSize += document
											.getElementById(y).files[i].size;

								}
 {
									if ($scope.totalFileSize > 1000000) {
										$scope.biggerSizeDoc = true;
										$scope.errorClass="alert alert-danger";
										$("#errorValidation strong").text(
												"File Size must be below 1MB");
									

										$scope.$apply();
										document.getElementById(y).value = "";
									}
									$(".loader").css("display", "block");
									for (var i = 0; i < document
											.getElementById(y).files.length; i++) {
										$scope.ext = document.getElementById(y).files[i].name
												.split('.').pop();
										$scope.fileName = document
												.getElementById(y).files[i].name
												.split("\\").pop();

										if ($scope.ext.toLowerCase() != "jpg"
												&& $scope.ext.toLowerCase() != "jpeg"
												&& $scope.ext.toLowerCase() != "png"
												&& $scope.ext.toLowerCase() != "gif") {
											$scope.wrongType = true;
											$scope.errorClass="alert alert-danger";
											$("#errorValidation strong")
													.text("Please upload only images");
										
											document.getElementById(y).value = "";
										} else {

											$scope.showValue += $scope.fileName;
											if (i != document.getElementById(y).files.length - 1) {
												$scope.showValue += ",";
											}
										}
									}
									$(".loader").css("display", "none");
								}
								if (!$scope.biggerSizeDoc && !$scope.wrongType) {
									document.getElementById(x).value = $scope.showValue;
								} else {
									$("#errorValidation").show().delay(3000)
											.fadeOut();
								}

							};
							$scope.$watch("$viewContentLoaded", function() {
								$timeout(function() {
									$(".require").next().next("select").attr(
											"required", "required");
									$("input").change(function() {
										$(this).value = $.trim($(this).value);
									});
								}, 500);

							});
							$scope.resetOther = function(level) {
								if (level == 1) {
									$scope.selectedReport.themeId = undefined;
								}

							};
							$scope.saveReport = function(){

								console.log($scope.selectedReport);
								$(".loader").fadeOut();
							};

							/*
							 * chips suggestion
							 */

						});