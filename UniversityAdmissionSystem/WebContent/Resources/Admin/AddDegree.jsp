<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../../CSS/style.css" type="text/css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<SCRIPT type="text/javascript" src="../../SCRIPT/AddDegree.js">
</SCRIPT>
</head>
<body>

<%@taglib uri="/struts-tags" prefix="s"%>
<h1 class="header">Add Degree</h1>
<table border="0" class="collegeForm" width="100%" cellpadding="5px">
	<s:form action="AddDegreeAction">
		<tr class="tableRow">
			<td class="tableTitle">DEGREE NAME :</td>
			<td><s:textfield name="degreeName" label="Degree Name" cssClass="tableclass" 
			onblur="isValidDegreeName(this,document.getElementById('errDegreeName'))"/></td>
			<td><s:fielderror fieldName="degreeName" /></td>
			<td><span id="errDegreeName"></span></td>
		</tr>
		<tr>
			<td colspan="3" align="center"><s:submit cssClass="tableclassButton" onclick="return validate(this.form)"/></td>
		</tr>
	</s:form>
</table>
<s:actionmessage cssClass="actionMessage" />
</body>
</html>