<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html lang="en">

<jsp:include page="fragments/headTag.jsp" />
<body>
<div id="wrapper">
		<jsp:include page="fragments/bodyHeader.jsp" />
		
		<div class="content" id="mymain">
			<div class="container-fluid">
				<h2 class="page-header evm-font-blue">About</h2>
				<div class="row">

					<div class="col-md-6 about">
							<p>Bihar Info is an online data dissemination system that seeks
						to address the emergent need of UNICEF Patna to share the progress
						of key social sector indicators for the state of Bihar. 
						
						<p>It is a
						part of the larger road map to usher in a behavioural change in
						terms of promoting use of credible statistics to track development
						outcomes as well as to have a system for improving the quality of
						official statistics.</p>
						
						
						Majority of the indicators are in the mandate
						of UNICEF and the dashboard is designed to be relevant to the
						policy makers, senior executive, and UN agencies and to the
						citizens.</p><br>
						<p class="mar-top-10 mar-bot-10">The salient features of the
						dashboards can be listed as follows:</p>
					<ol class="list-unstyled">
						<li>1. Easy access to key information with minimal
							navigations and clicks.</li></br>
						<li>2. Data is made available at various levels of
							disaggregation by geography, gender, and social classes
							(disaggregation by religion and wealth status will be included
							wherever the data is available)</li></br>
						<li>3. Feature to generate &#39;ready to use&#39; presentation
							outputs from the dashboards/adaptation in various formats
							including Microsoft Excel and Portable Document Format (PDF).</li></br>
						<li>4. Make available updated datasets, organized by theme,
							place of residence, sex, social and religious background, and
							geography (administrative units), which can be presented using
							different tools e.g., graphs, charts, tables etc.</li>
					</ol>
					</div>
				</div>

			</div>
		</div>
		
		
		<div class="clearfooter"></div>
	</div>
	
	<jsp:include page="fragments/footer.jsp" />
<!-- 	<script type="text/javascript"> -->
		
<!-- 	</script> -->
	
</body>

</html>
