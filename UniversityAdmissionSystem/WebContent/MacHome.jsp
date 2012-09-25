<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="do" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="CSS/style.css" type="text/css" rel="stylesheet" />

<script src="SCRIPT/UAS.js" type="text/javascript"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Mac</title>

</head>

<body>

<s:if test="#session.user == null">
You are not Authorized to view this page, Kindly Login
<jsp:forward page="HomePage.jsp"></jsp:forward>
</s:if>

<!-- site wrapper starts here-->
<div class="site-wrapper"><!--  includes header--> <s:include
	value="Resources/General/Header.html" /> <!--   includes menu bar--> <s:include
	value="Resources/General/MenuBar.html" /> <!--    body wrapper starts here-->
<div class="body-wrapper"><!--  MAC navigator-->
<div class="navigationMAC">

<div class="notification">Welcome: <s:property
	value="#session.user.loginId" /> <br />
<br />
<a href="logout.action" Class="tableclassButton">Log Out</a>
</div>

<div class="mactools">
<p align="center">MANAGE APPLICATIONS</p>
<ul>
	<s:url action="getApplied.action?page=applied" var="applied" />
	<li><s:a href="%{#applied}">Applied</s:a></li>
	<s:url action="getAccepted.action?page=accepted" var="accepted" />
	<li><s:a href="%{#accepted}">Accepted</s:a></li>
	<s:url action="getConfirmed.action?page=confirmed" var="confirmed" />
	<li><s:a href="%{#confirmed}">Confirmed</s:a></li>
	<s:url action="getRejected.action?page=rejected" var="rejected" />
	<li><s:a href="%{#rejected}">Rejected</s:a></li>
</ul>
</div>

</div>

<!-- main content-->


<div id="mainIdMAC"><s:if
	test="#session.filteredApplications == null">

	<h1 class="header">Welcome MAC !!!</h1>

</s:if> <do:head /> <s:if
	test="#session.filteredApplications != null && #session.filteredApplications.size>0">
	<s:form action="filter" method="post">
		<h1 class="header"><s:property
			value="#session.filteredApplications[0].status" /> Candidates</h1>

		<table border="2" class="macTable">
			<tr>
				<th>ApplicationId</th>
				<th>Name</th>
				<th>DOB</th>
				<th>Qualification</th>
				<th>Marks <s:if
					test="{#session.newStatus[#session.status.indexOf(#session.filteredApplications[0].status)],'rejected'}">
					<input type="text" onkeydown="filter(this, this.form);" name="filterMarks" size="6">
				</s:if></th>
				<s:if
					test="{#session.newStatus[#session.status.indexOf(#session.filteredApplications[0].status)],'rejected'}">
					<th>Status <s:select
						list="{#session.newStatus[#session.status.indexOf(#session.filteredApplications[0].status)],'rejected'}"
						headerKey="%{#session.filteredApplications[0].status}"
						headerValue="%{#session.filteredApplications[0].status}"
						name="allStatus" onchange="changeStatus(this);" /></th>
					<th id='doi' style="visibility: hidden">Date of Interview <do:datetimepicker
						id="date" name='date' displayFormat='dd-MMM-yyyy' /></th>

				</s:if>
				<s:elseif
					test="#session.filteredApplications[0].status.equals('accepted')">
					<th>Status</th>
					<th>Date Of Interview</th>
				</s:elseif>
				<s:else>
					<th>Status</th>
				</s:else>
			</tr>

			<s:hidden name="page"
				value="%{#session.filteredApplications[0].status}" />
			<s:submit action="filter" cssClass="filterButton" />
			<s:iterator value="#session.filteredApplications" var="applicant"
				status="st">
				<tr>
					<td class="tableData"><s:property
						value="#applicant.applicationId" /></td>
					<s:hidden value="%{#applicant.applicationId}"
						name="applicationIds[%{#st.index}]" />
					<td class="tableData"><s:property value="#applicant.fullName" /></td>
					<td class="tableData"><s:property
						value="#applicant.dateOfBirth" /></td>
					<td class="tableData"><s:property
						value="#applicant.highestQualification" /></td>
					<td class="tableData"><s:property
						value="#applicant.marks_obtained" /></td>

					<s:if test="#applicant.status.equals('rejected')">
						<td><s:label value="Rejected" /></td>
					</s:if>
					<s:elseif test="#applicant.status.equals('confirmed')">
						<td class="tableData"><s:label value="Confirmed" /></td>
					</s:elseif>
					<s:if
						test="{#session.newStatus[#session.status.indexOf(#session.filteredApplications[0].status)],'rejected'}">
						<td class="tableData"><s:select
							list="{#session.newStatus[#session.status.indexOf(#applicant.status)],'rejected'}"
							headerKey="%{#applicant.status}"
							headerValue="%{#applicant.status}" name="statuss[%{#st.index}]"
							onchange="enableDOI('%{#applicant.applicationId}',this);" /></td>
						<s:if test="%{#applicant.status.equals('applied')}">
							<td class="tableData"
								id='<s:property value='%{#applicant.applicationId}'/>'
								style="visibility: hidden"><do:datetimepicker
								cssClass="dateTime" name='dates[%{#st.index}]'
								displayFormat='dd-MMM-yyyy' id='dates[%{#st.index}]' /></td>
						</s:if>
						<s:else>
							<td><s:property value="#applicant.dateOfInterview" /> <s:hidden
								name='dates[%{#st.index}]' id='dates[%{#st.index}]' /></td>
						</s:else>
					</s:if>
				</tr>
			</s:iterator>
			<tr>
				<s:if
					test="#applicant.status.equals('applied')||#applicant.status.equals('accepted')">
					<td><s:submit action="setStatus" cssClass="tableclassButton" /></td>
				</s:if>
			</tr>
		</table>
	</s:form>
</s:if> <s:if test="#session.filteredApplications.size=0">
	<h3>No Application in this category</h3>
</s:if> <s:actionmessage /> <s:actionerror /></div>
</div>

<!--    includes footer--> <s:include
	value="Resources/General/Footer.html" /></div>
</body>
</html>