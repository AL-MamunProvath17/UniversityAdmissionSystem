<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../../CSS/style.css" type="text/css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" language="JavaScript" src="../../SCRIPT/checkStatus.js"></script>
</head>
<body>
<table width="100%" class="collegeForm" cellpadding="5px" border="0px">
	<tr class="tableRow">
		<td align="center" colspan="3">
		<h1 align="center">Check Status</h1>
		</td>
	</tr>

	<s:form action="checkStatus" method="post">
		<tr class="tableRow">
			<td class="tableTitle">Enter Application Id :</td>
			<td><s:textfield name="applicationId" cssClass="tableclass"
				onblur="validateApplicationId(this,document.getElementById('errApplicationId'))" /></td>
			<td><span id="errApplicationId" class="errorMessage"></span></td>
		</tr>
		<tr class="tableRow">
			<td colspan="3" align="center"><s:submit align="center"
				label="SUBMIT" onclick="return validate(this.form)"></s:submit></td>
		</tr>

	</s:form>

</table>

<s:if test="#session.applicant">
	<h1 align="center" class="header">Status</h1>
	<table border="2" width="100%" class="tableclass">
		<tr >
			<th>Application Id</th>
			<th>Name</th>
			<th>Date Of Birth</th>
			<th>Qualification</th>
			<th>EmailId</th>
			<th>Status</th>
			<s:if test="#session.applicant.dateOfInterview">
				<th>Date Of InterView</th>
			</s:if>
		</tr>
		<tr >

			<td><s:property value="#session.applicant.applicationId" /></td>
			<td><s:property value="#session.applicant.fullName" /></td>
			<td><s:property value="#session.applicant.dateOfBirth" /></td>
			<td><s:property value="#session.applicant.highestQualification" /></td>
			<td><s:property value="#session.applicant.email_id" /></td>
			<td><s:property value="#session.applicant.status" /></td>

			<s:if test="#session.applicant.dateOfInterview">
				<td><s:property value="#session.applicant.dateOfInterview" /></td>
			</s:if>

		</tr>
	</table>
</s:if>


</body>
</html>