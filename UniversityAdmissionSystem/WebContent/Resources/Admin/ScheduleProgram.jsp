<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../../CSS/style.css" type="text/css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<SCRIPT type="text/javascript">
	function submitForm(form) {
		form.submit();
	}

	function setStartValue(id, date) {
		var picker = dojo.widget.byId(id);
		date = date.substring(0, 10);
		//string value
		picker.setValue(date);

	}
</SCRIPT>
<script type="text/javascript" src="../../SCRIPT/ScheduleProgram.js"></script>
<style type="text/css">
.errorMessage1 {
	color: rgb(255, 70, 0); /*red*/
	font-size: 20px;
}
</style>
</head>

<body>

<h1 class="header">Schedule Program</h1>

<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="do" uri="/struts-dojo-tags"%>

<do:head />

<s:actionmessage />
<s:actionerror cssClass="errorMessage1"/>

<s:form action="schedule">
	<table class="collegeForm" cellspacing="5px" width="100%">
		<tr class="tableRow">
			<td class="tableTitle">College Name :</td>
			<td><s:select list="#session.scheduledData"
				listKey="key.collegeId" listValue="key.collegeName" name="collegeId"
				onchange="submitForm(this.form)" headerKey="" headerValue="select"
				value="%{#parameters.collegeId}" cssClass="tableclass"
				onblur="isCollegeSelected(this,document.getElementById('errSelectCollege'))" /></td>
			<td><s:fielderror fieldName="collegeId" cssClass="errorMessage1"/><span
				id="errSelectCollege" class="errorMessage1"></span></td>
		</tr>

		<s:if test="%{#parameters.collegeId != null}">
			<tr class="tableRow">
				<s:set var="cid" value="%{#parameters.collegeId}" />
				<s:bean name="com.igate.uas.bean.CollegeBean" var="college">
					<s:param name="collegeId" value="#cid" />
				</s:bean>
				<s:if test="#session.scheduledData[#college]">
					<td class="tableTitle">Degree Name :</td>
					<td><s:select list="#session.scheduledData[#college]"
						listKey="key.degreeId" listValue="key.degreeName" name="degreeId"
						onchange="submitForm(this.form)" headerKey="" headerValue="select"
						value="%{#parameters.degreeId}" cssClass="tableclass"
						onblur="isDegreeSelected(this,document.getElementById('errSelectDegree'))" /></td>
					<td><s:fielderror fieldName="degreeId" cssClass="errorMessage1"/><span
						id="errSelectDegree" class="errorMessage1"></span></td>
				</s:if>
			</tr>
			<s:if test="%{#parameters.degreeId != null}">
				<s:set var="did" value="%{#parameters.degreeId}" />
				<s:bean name="com.igate.uas.bean.DegreeBean" var="degree">
					<s:param name="degreeId" value="#did" />
				</s:bean>
				<s:if test="#session.scheduledData[#college][#degree]">
					<tr class="tableRow">
						<td class="tableTitle">Program Name :</td>
						<td><s:select
							list="#session.scheduledData[#college][#degree]" name="programId"
							headerKey="" headerValue="select" listKey="programId"
							listValue="programName" label="Program" cssClass="tableclass"
							onblur="isProgramSelected(this,document.getElementById('errSelectProgram'))" /></td>
						<td><s:fielderror fieldName="programId" cssClass="errorMessage1"/><span
							id="errSelectProgram" class="errorMessage1"></span></td>
					</tr>
					<tr class="tableRow">
						<td class="tableTitle">Start Date :</td>
						<td><do:datetimepicker name="startDate"
							displayFormat="dd-MMM-yyyy" cssClass="tableclass"
							onblur="validateSessionPerWeek(this,document.getElementById('errStartDate'))" /></td>
						<td><s:fielderror fieldName="startDate" cssClass="errorMessage1"/><span
							id="errStartDate" class="errorMessage1"></span></td>
					</tr>
					<tr class="tableRow">
						<td class="tableTitle">End Date :</td>
						<td><do:datetimepicker name="endDate"
							displayFormat="dd-MMM-yyyy" cssClass="tableclass"
							onblur="validateSessionPerWeek(this,document.getElementById('errEndDate'))" /></td>
						<td><s:fielderror fieldName="endDate" cssClass="errorMessage1"/><span
							id="errEndDate" class="errorMessage1"></span></td>
					</tr>
					<tr class="tableRow">
						<td class="tableTitle">Session Per Week</td>
						<td><s:textfield name="sessionPerWeek"
							label="Session Per Week" value="%{#parameters.sessionPerWeek}"
							cssClass="tableclass"
							onblur="validateSessionPerWeek(this,document.getElementById('errSessionPerWeek'))" /></td>
						<td><s:fielderror fieldName="sessionPerWeek" cssClass="errorMessage1"/><span
							id="errSessionPerWeek" class="errorMessage1"></span></td>
					</tr>
					<tr class="tableRow">
						<td colspan="3" align="center"><s:submit
							action="ScheduleProgramAction" onclick="return validate(this.form)"
							cssClass="tableclassButton" /></td>
					</tr>
				</s:if>
			</s:if>
		</s:if>
	</table>
</s:form>

</body>
</html>