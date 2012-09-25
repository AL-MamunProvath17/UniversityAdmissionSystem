<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../../CSS/style.css" type="text/css" rel="stylesheet" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<script type="text/javascript" src="../../SCRIPT/AddDegreeToCollege.js"></script>

</head>
<body>

<%@taglib uri="/struts-tags" prefix="s"%>
<h1 class="header">Add Degree To College</h1>
<table width="100%" border="2">
	<s:form action="degreeToCollege">
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

			<!--<s:select list="#session.scheduledData" listKey="key.collegeId"
		listValue="key.collegeName" name="collegeId"
		onchange="submitForm(this.form)" headerKey="adsdas"
		headerValue="select" value="%{#parameters.collegeId}" label="Collge" />

	-->
			<s:set var="cid" value="%{#parameters.collegeId}" />
			<s:if test="%{#parameters.collegeId != null}">
				<s:bean name="com.igate.uas.bean.CollegeBean" var="college">
					<s:param name="collegeId" value="#cid" />
				</s:bean>

				<s:set
					value="#session.degrees.removeAll(#session.scheduledData[#college].keySet())" />
				<tr class="tableRow">
					<td class="tableTitle">Degree Name :</td>
					<td><s:select list="#session.degrees" listKey="degreeId"
						label="Degree" listValue="degreeName" name="degreeId"
						headerKey="" headerValue="select"
						onblur="isDegreeSelected(this,document.getElementById('errSelectDegree'))"
						cssClass="tableclass" /></td>
					<td><s:fielderror fieldName="degreeId" /><span
						id="errSelectDegree" class="errorMessage"></span></td>
				</tr>

				<tr class="tableRow">
					<td colspan="3" align="center"><s:submit
						action="addDegreeToCollege" onclick="return validate(this.form)"
						cssClass="tableclassButton" /></td>
			</s:if>
		</table>
	</s:form>
</table>
<s:actionerror />
<s:actionmessage />

</body>
</html>