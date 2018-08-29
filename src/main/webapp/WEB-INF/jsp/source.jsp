<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%@ page import="org.sdrc.biharinfo.model.Mail"%> --%>

<html lang="en">

<jsp:include page="fragments/headTag.jsp" />

<body>

	<div id="wrapper">
		<jsp:include page="fragments/bodyHeader.jsp" />
		<div class="content">
			<div class="container-fluid">

				<h3>Resources</h3>
				<div class="row">

					<div class="col-md-8">
						The items below provide link to the web sites of the Publishing
						agencies whose data have been imported to ChildInfo database.
						Please click "Open Site" to access web pages of an external
						website


						<table class="table table-striped mar-top-5">
							<tr>
								<th>Source</th>
								<th>Report Name</th>
								<th>External Link</th>
							</tr>
							<tr>
								<td>ASER</td>
								<td>ASER_Annual Status of Education Report (Rural)</td>
								<td><a href="http://www.asercentre.org" target="_blank">Open
										Site </a></td>
							</tr>
							<tr>
								<td>DISE</td>
								<td>DISE_District Information System for Education_DRC</td>
								<td><a href="http://udise.in/drc.htm" target="_blank">
										Open Site </a></td>
							</tr>
							<tr>
								<td>DISE</td>
								<td>DISE_District Information System for Education_SRC</td>
								<td><a href="http://udise.in/src.htm"
									target="_blank"> Open Site </a></td>
							</tr>
							<tr>
								<td>NCRB</td>
								<td>MoHA_National Crime Records Bureau Crime Statistics (NCRB)</td>
								<td><a href="http://ncrb.nic.in/"
									target="_blank"> Open Site </a></td>
							</tr>

							<tr>
								<td>DLHS</td>
								<td>MoHFW_District Level Household and Facility Survey (DLHS)</td>
								<td><a href="http://rchiips.org"
									target="_blank"> Open Site </a></td>
							</tr>

							<tr>
								<td>NFHS</td>
								<td>MoHFW_National Family Health Survey (NFHS)</td>
								<td><a href="http://rchiips.org/nfhs/" target="_blank"> Open Site </a></td>
							</tr>

							<tr>
								<td>AISHE</td>
								<td>MoHRD_All India Survey on Higher Education</td>
								<td><a href="http://aishe.nic.in/aishe/reports" target="_blank"> Open Site </a></td>
							</tr>

							<tr>
								<td>SES</td>
								<td>MoHRD_Selected Educational Statistics (SES)</td>
								<td><a href="http://www.educationforallinindia.com/ses.html" target="_blank"> Open Site </a></td>
							</tr>
							<tr>
								<td>SHTE</td>
								<td>MoHRD_Statistics of Higher & Technical Education</td>
								<td><a href="http://mhrd.gov.in/sites/upload_files/mhrd/files/statistics/Abstract2009-10_0.pdf" target="_blank"> Open Site </a></td>
							</tr>
							<tr>
								<td>SSE</td>
								<td>MoHRD_Statistics of School Education (SSE)</td>
								<td><a href="http://mhrd.gov.in/statist?field_statistics_category_tid=33" target="_blank"> Open Site </a></td>
							</tr>
							<tr>
								<td>NSS</td>
								<td>MoSPI_NSS Report</td>
								<td><a href="http://mospi.nic.in/download-reports?main_cat=NzIy&cat=All&sub_category=All" target="_blank"> Open Site </a></td>
							</tr>
							<tr>
								<td>GHDI</td>
								<td>MoWCD_Gendering Human Development Indices: Recasting the Gender Development Index and Gender Empowerment Measure for India</td>
								<td><a href="http://www.undp.org/content/dam/india/docs/gendering_human_development_indices_summary_report.pdf" target="_blank"> Open Site </a></td>
							</tr>
							<tr>
								<td>MICS</td>
								<td>MoWCD_Multiple Indicator Cluster Survey, India Summary Report</td>
								<td><a href="https://mics-surveys-prod.s3.amazonaws.com/MICS2/South%20Asia/India/2000/Final/India%202000%20MICS%20Summary_English.pdf" target="_blank"> Open Site </a></td>
							</tr>
							<tr>
								<td>AHS</td>
								<td>ORGI_Annual Health Survey (AHS)</td>
								<td><a href="http://censusindia.gov.in/2011-common/AHSurvey.html" target="_blank"> Open Site </a></td>
							</tr>
							<tr>
								<td>CENSUS</td>
								<td>ORGI_Census</td>
								<td><a href="http://www.censusindia.gov.in/" target="_blank"> Open Site </a></td>
							</tr>
							<tr>
								<td>CENSUS</td>
								<td>ORGI_Population Projections Report for India and States</td>
								<td><a href="https://www.educationforallinindia.com/Population_Projection_Report_2006.pdf" target="_blank"> Open Site </a></td>
							</tr>
							<tr>
								<td>SRS</td>
								<td>ORGI_Sample Registration System (SRS)</td>
								<td><a href="http://www.censusindia.gov.in/2011-Common/Sample_Registration_System.html" target="_blank"> Open Site </a></td>
							</tr>
							<tr>
								<td>PLCM</td>
								<td>PLCM_Poverty estimates press release</td>
								<td><a href="http://planningcommission.nic.in/news/pre_pov2307.pdf" target="_blank"> Open Site </a></td>
							</tr>
							<tr>
								<td>RSOC</td>
								<td>RSOC_Rapid Survey on Children</td>
								<td><a href="http://wcd.nic.in/sites/default/files/RSOC%20FACT%20SHEETS%20Final.pdf" target="_blank"> Open Site </a></td>
							</tr>
						</table>
					</div>
					
					<div class="col-md-4">
					<div>
 						<a href="download" 	title="Click to Download Offline Adaptation">
 						<img alt="di" class="img-rounded" src="resources/images/adaptaion.jpg"></a> 
 						<a href="download" > 
							<div class="text-center">Click to Download Offline Adaptation (135 MB)&nbsp&nbsp&nbsp<i class="fa fa-download evm-font-blue  "></i></>
						</a> 
					</div>
					
				</div>	
				<hr>
				
				<div>
				<div class="col-md-12">
					<form role="form" method="post" id="mailform" >
						<p>
							<span>Please provide your details below to receive offline adaptation CD</span>
						</p>
						<div id="mandatory_field"></div>
						<div id="mail_success"></div>
						<div class="well well-sm">
							<strong>*</strong> represents required field
						</div>
						<div class="form-group">
							<div class="input-group">
								<input type="text" required placeholder="NAME*"
									id="fromUserName" name="fromUserName" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<div class="input-group">
								<input type="email" required placeholder="EMAIL*"
									name="mail" id="toEmailId" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<div class="input-group">
								<textarea required rows="3" class="form-control"
									id="subject" name="subject" placeholder="ADDRESS*"></textarea>
							</div>
						</div>
						<div class="form-group">
							<div class="input-group">
								<textarea required="required" rows="4" class="form-control"
									id="msg" name="msg" placeholder="MESSAGE*"></textarea>
							</div>
						</div>

						<input type="button" name="submit" id="mailsend" class="btn btn-primary btn-sm"
							value="SEND" />
						<div id="loader" class="col-sm-1"></div>
					</form>
				</div>
				</div>			
			
			</div>
					
					
					
					
				</div>
			</div>
		</div>
		<div class="clearfooter"></div>
	</div>
	<jsp:include page="fragments/footer.jsp" />
</body>

</html>
