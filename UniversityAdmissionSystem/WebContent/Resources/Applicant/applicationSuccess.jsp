<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="../../CSS/style.css" type="text/css" rel="stylesheet" />
</head>
<body>

<table width="100%" class="collegeForm" cellpadding="5px">
	<tr class="tableRow">
		<td class="tableTitles">Application Id:</td>
		<td class="tableclasss" ><s:property value="applicationId" /></td>
	</tr >
	<tr class="tableRow">
		<td class="tableTitles">Name:</td>
		<td class="tableclasss" ><s:property value="fullName" /></td>
	</tr>
	<tr class="tableRow">
		<td class="tableTitles">Qualification:</td>
		<td class="tableclasss" ><s:property value="highestQualification" /></td>
	</tr>
	<tr class="tableRow">
		<td class="tableTitles">Goals:</td>
		<td class="tableclasss" ><s:property value="goals" /></td>
	</tr>
	<tr class="tableRow">
		<td class="tableTitles">Date of Birth:</td>
		<td class="tableclasss" ><s:property value="dateOfBirth" /></td>
	</tr>
	<tr class="tableRow">
		<td class="tableTitles">Marks:</td>
		<td class="tableclasss" ><s:property value="marks_obtained" /></td>
	</tr>
	<tr class="tableRow">
		<td class="tableTitles">Email:</td>
		<td class="tableclasss" ><s:property value="email_id" /></td>
	</tr>
	<tr class="tableRow">
		<td class="tableTitles">Program:</td>
		<td class="tableclasss" ><s:property value="scheduledProgramId" /></td>
	</tr>
</table>

</body>
</html>