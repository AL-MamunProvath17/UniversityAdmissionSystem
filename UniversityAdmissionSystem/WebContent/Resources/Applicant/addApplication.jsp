<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="do" uri="/struts-dojo-tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript" language="JavaScript"
	src="../../SCRIPT/addApplication.js"></script>
<link href="../../CSS/style.css" type="text/css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Application Form</title>

<style type="text/css">
.errorMessage1 {
	color: rgb(255, 70, 0); /*red*/
	font-size: 20px;
}
</style>

</head>
<body>
<do:head />
<h1 align="center" class="line3">APPLICATION FORM</h1>
<hr class="line3" />
<s:form action="addApplication" method="post"
	namespace="/Resources/Applicant">
	<table width="100%" class="collegeForm" cellpadding="5px" >

		<tr class="tableRow">
			<td class="tableTitle">Name :</td>
			<td><s:textfield name="fullName" size="20" cssClass="tableclass"
				onblur="validateFullName(this,document.getElementById('errFullName'))" /></td>
			<td><s:fielderror fieldName="fullName" cssClass="errorMessage1" />
			<span id="errFullName" class="errorMessage1"></span></td>
		</tr>
		<tr class="tableRow">
			<td class="tableTitle">Date Of Birth :</td>
			<td><do:datetimepicker name="dateOfBirth"
				displayFormat="dd-MMM-yyyy" cssClass="tableclass"
				onblur="validateDateOfBirht(this,document.getElementById('errDateOfBirth'))" /></td>
			<td><s:fielderror fieldName="dateOfBirth"
				cssClass="errorMessage1" /><span id="errDateOfBirth"
				class="errorMessage1"></span></td>
		</tr>
		<tr class="tableRow">
			<td class="tableTitle">Highest Qualification</td>
			<td><s:textfield name="highestQualification" 
				cssClass="tableclass"
				onblur="validateHighestQualification(this,document.getElementById('errHighestQualification'))"></s:textfield> </td>
			<td><s:fielderror fieldName="highestQualification"
				cssClass="errorMessage1" /><span id="errHighestQualification" class="errorMessage1"></span></td>
		</tr>
		<tr class="tableRow">
			<td class="tableTitle">Marks Obtained :</td>
			<td><s:textfield name="marks_obtained" size="20"
				cssClass="tableclass"
				onblur="validateMarks(this,document.getElementById('errMarks'))" /></td>
			<td><s:fielderror fieldName="marks_obtained"
				cssClass="errorMessage1" /><span id="errMarks" class="errorMessage1"></span></td>
		</tr>
		<tr class="tableRow">
			<td class="tableTitle">Goals</td>
			<td><s:textarea name="goals" cols="19" rows="4"
				cssClass="tableclass"
				onblur="validateGoals(this,document.getElementById('errGoals'))"></s:textarea></td>
			<td><s:fielderror fieldName="goals" cssClass="errorMessage1" /><span id="errGoals" class="errorMessage1"></span></td>
		</tr>
		<tr class="tableRow">
			<td class="tableTitle">Email :</td>
			<td><s:textfield name="email_id" label="EMAIL:" size="20"
				cssClass="tableclass"
				onblur="validateEmail(this,document.getElementById('errEmail'))" /></td>
			<td><s:fielderror fieldName="email_id" cssClass="errorMessage1" /><span id="errEmail" class="errorMessage1"></span></td>
		</tr>

		<tr class="tableRow">
			<td class="tableTitle">College :</td>
			<td colspan="2"><s:property value="%{#parameters.college}" /></td>
		</tr>
		<s:hidden value="%{#parameters.college}" name="college" />
		<tr class="tableRow">
			<td class="tableTitle">Degree :</td>
			<td colspan="2"><s:property value="%{#parameters.degree}" /></td>
		</tr>
		<s:hidden value="%{#parameters.degree}" name="degree" />
		<tr class="tableRow">
			<td class="tableTitle">Program :</td>
			<td colspan="2"><s:property value="%{#parameters.program}" /></td>
		</tr>
		<s:hidden value="%{#parameters.program}" name="program" />
		<tr class="tableRow">
			<td colspan="3" align="center"><s:hidden
				name="scheduledProgramId" value="%{#parameters.programId}"></s:hidden>
			<s:submit align="center" onclick="return validate(this.form)" /></td>
		</tr>
	</table>
</s:form>
<s:actionerror cssClass="errorMessage1" />

</body>
</html>