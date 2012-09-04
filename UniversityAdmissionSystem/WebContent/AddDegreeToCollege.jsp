<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@taglib uri="/struts-tags" prefix="s"%>
<s:property value="#session.degrees[0].degreeName"/>
<s:form action="addDegreeToCollege">

	<s:select list="#session.colleges" listKey="collegeId"
		listValue="collegeName" name="college.collegeId"/>
	<s:select list="#session.degrees" listKey="degreeId"
		listValue="degreeName" name="degree.degreeId"/>
	<s:submit/>
</s:form>

<s:actionmessage/>

</body>
</html>