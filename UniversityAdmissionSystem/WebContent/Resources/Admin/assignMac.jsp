<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="SCRIPT/UAS.js" type="text/javascript">
	
</script>
<link href="../../CSS/style.css" type="text/css" rel="stylesheet" />
</head>
<body>
<%@taglib uri="/struts-tags" prefix="s"%>

<h1 class="header">Manage Mac</h1>

<table width="100%" class="collegeForm" cellpadding="5px">
	<s:form action="assignMac" validate="true">
		<tr class="tableRow">
			<td class="tableTitle">MAC Member</td>
			<td><s:select list="#session.macMembers" name="loginId"
				headerKey="" headerValue="select" cssClass="tableclass" /></td>
			<td><s:fielderror fieldName="loginId" /></td>
		</tr>
		<tr class="tableRow">
			<td class="tableTitle">Programs</td>
			<td><s:select list="#session.scheduledPrograms"
				name="scheduledProgramId" headerKey="" headerValue="select"
				cssClass="tableclass" /></td>
			<td><s:fielderror fieldName="scheduledProgramId" /></td>
		</tr>
		<tr class="tableRow">
			<td colspan="3" align="center"><s:submit cssClass="tableclass"/></td>
		</tr>
	</s:form>
</table>

<s:actionmessage />

<table class="macTable" align="center">

	<tr>
		<th>Mac</th>
		<th>Program</th>
		<th>Delete</th>
	</tr>

	<s:iterator value="#session.assignedMac.keySet()" var="mac">
		<s:iterator value="#session.assignedMac[#mac].keySet()" var="program">
			<s:form action="removeMac">
				<tr>
					<td class="tableData"><s:property value="#mac" /></td>
					<s:hidden value="%{#mac}" name="loginId" />
					<td class="tableData"><s:property
						value="#session.assignedMac[#mac][#program]" /></td>
					<s:hidden value="%{#program}" name="scheduledProgramId" />
					<td class="tableData"><s:submit value="Delete" cssClass="tableclass"/></td>
				</tr>
			</s:form>
		</s:iterator>
	</s:iterator>
</table>
</body>
</html>