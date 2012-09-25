<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="../../CSS/style.css" type="text/css" rel="stylesheet" />
</head>
<body>

<%@taglib uri="/struts-tags" prefix="s"%>
<h1 class="header" align="center">Manage College</h1>
<table class="macTable" align="center">
	<tr>
		<th>Program Name</th>
		<th>Delete</th>
	</tr>

	<s:iterator value="#session.programs" var="program">
		<s:form action="deleteProgram">
			<tr>
				<s:hidden value="%{#program.programId}" name="programId" />
				<td class="tableData"><a href="editProgram.action?programId=<s:property value="%{#program.programId}"/>"><s:property value="#program.programName" /></a>
				</td>
				<td class="tableData"><s:submit value="Delete"
					cssClass="tableclassButton" /></td>
			</tr>

		</s:form>


	</s:iterator>

</table>
</body>
</html>