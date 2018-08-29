<%@page import="java.util.ArrayList"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page import="org.sdrc.childinfo.util.Constants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="org.sdrc.childinfo.model.User"%>
<%@page import="org.sdrc.childinfo.model.UserRoleSchemeMapping"%>
<%@ page import="org.sdrc.childinfo.model.UserDetailsModel"%>
<%@page import="java.util.List"%>

<%
	UserDetailsModel user = null;
	String role = "";
	List<String> features = new ArrayList<String>();
	List<String> permissions = new ArrayList<String>();
%>
<%
    user = (UserDetailsModel) request.getSession().getAttribute(Constants.USER_PRINCIPAL);
%>
   <!-- menu row starts -->
      <div class="container">
        <div class="header" id="home">
          <div class="content white">
<!--             <nav class="navbar" role="navigation"> -->
<!--               <div class="container"> -->
                <div class="navbar-header">
                  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                </div>
                <!--/.navbar-header-->
                <div class="collapse navbar-collapse menu-gap" id="bs-example-navbar-collapse-1">
                  <ul class="nav navbar-nav">
                    <li><a class="<%=request.getRequestURI().contains("welcome") ? "menu-active": ""%>"
						href="<spring:url value="/" htmlEscape="true" />"> Home 
					</a></li>
                    <li><a class="<%=request.getRequestURI().contains("about_us") ? "menu-active"	: ""%>"
						href="<spring:url value="about_us" htmlEscape="true" />"> About Us
					</a></li>
                    <li><a class="<%=request.getRequestURI().contains("source") ? "menu-active"	: ""%>"
						href="<spring:url value="source" htmlEscape="true" />"> Resources 
                    </a></li>
                    <li><a class=""> Factsheet</a>
                        <ul class="dropdown-nav">
	 						<li><a href="<spring:url value="factsheet" htmlEscape="true" />">Nationalized Survey Data</a></li> 
	 						<li><a href="<spring:url value="factsheetGeneration" htmlEscape="true" />">Program Monitoring Data</a></li> 
 						</ul>
                    </li>
                    <li> <a class="<%=request.getRequestURI().contains("dashboard") ? "menu-active"	: ""%>" href="<spring:url value="dashboard" htmlEscape="true" />" >Dashboard </a> </li>
                    <%if(user != null){ %>
 					<li><a class="<%=request.getRequestURI().contains("template") ? "menu-active"	: ""%>">DataEntry</a>
                         <ul class="dropdown-nav">
	 						<li><a href="<spring:url value="templateGeneration" htmlEscape="true" />">Template Generation</a></li> 
	 						<li><a href="<spring:url value="templateUpload" htmlEscape="true" />">Template Upload</a></li> 
 						</ul>
 					</li>
                    <li><a class="<%=request.getRequestURI().contains("rawDataReport") ? "menu-active"	: ""%>" href="<spring:url value="rawDataReport" htmlEscape="true" />">Raw Data Report</a></li> 
 					<%} %>
  				  </ul>
                </div>
<!--               </div> -->
<!--             </nav> -->
          </div>
        </div>
      </div>
    
 