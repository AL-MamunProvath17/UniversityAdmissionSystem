<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../../CSS/style.css" type="text/css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript" src="../../SCRIPT/AddProgramToDegree.js"></script>
</head>
<body>

<%@taglib uri="/struts-tags" prefix="s"%>

<h1 class="header">Add Program To Degree</h1>

<s:form action="offer">
	<table class="collegeForm" cellspacing="5px" width="100%">
		<tr class="tableRow">
			<td class="tableTitle">College Name :</td>
			<td><s:select list="#session.colleges" listKey="collegeId"
				listValue="collegeName" name="collegeId"
				onchange="submitForm(this.form)" headerKey="" headerValue="select"
				value="%{#parameters.collegeId}" label="Collge"
				onblur="isCollegeSelected(this,document.getElementById('errSelectCollege'))"
				cssClass="tableclass" /></td>
			<td><s:fielderror fieldName="collegeId" /><span
				id="errSelectCollege" class="errorMessage"></span></td>
		</tr>
		<!--

	<s:select list="#session.scheduledData" listKey="key.collegeId"
		listValue="key.collegeName" name="collegeId"
		onchange="submitForm(this.form)" headerKey="" headerValue="select"
		value="%{#parameters.collegeId}" label="Collge" />

	-->

		<s:if test="%{#parameters.collegeId != null}">
			<s:set var="cid" value="%{#parameters.collegeId}" />
			<s:bean name="com.igate.uas.bean.CollegeBean" var="college">
				<s:param name="collegeId" value="#cid" />
			</s:bean>
			<s:if test="#session.colleges.contains(#college)">
				<tr class="tableRow">
					<td class="tableTitle">Degree Name :</td>
					<td><s:select list="#session.degrees" listKey="degreeId"
						listValue="degreeName" name="degreeId"
						onchange="submitForm(this.form)" headerKey="" headerValue="select"
						value="%{#parameters.degreeId}" label="Degree"
						onblur="isDegreeSelected(this,document.getElementById('errSelectDegree'))"
						cssClass="tableclass" /></td>
					<td><s:fielderror fieldName="degreeId" /><span
						id="errSelectDegree" class="errorMessage"></span></td>
				</tr>

				<s:if test="%{#parameters.degreeId != null}">
					<s:set var="did" value="%{#parameters.degreeId}" />
					<s:bean name="com.igate.uas.bean.DegreeBean" var="degree">
						<s:param name="degreeId" value="#did" />
					</s:bean>
					<s:if test="%{#session.degrees.contains(#degree)}">
						<tr class="tableRow">
							<td class="tableTitle">Degree Name :</td>
							<td><s:select list="#session.offeredPrograms"
								name="programId" headerKey="" headerValue="select"
								listKey="programId" listValue="programName" label="Program"
								onblur="isProgramSelected(this,document.getElementById('errSelectProgram'))"
								cssClass="tableclass" /></td>
							<td><s:fielderror fieldName="programId" /><span
								id="errSelectProgram" class="errorMessage"></span></td>
						</tr>

						<tr class="tableRow">
							<td colspan="3" align="center"><s:submit action="addProgramToDegree"
								onclick="return validate(this.form)" cssClass="tableclassButton" /></td>
					</s:if>
				</s:if>
			</s:if>
		</s:if>
	</table>
</s:form>

<s:actionmessage />

</body>
</html>