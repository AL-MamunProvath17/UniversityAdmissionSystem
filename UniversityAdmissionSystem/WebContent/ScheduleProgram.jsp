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

<s:form action="ScheduleProgramAction">
	<s:textfield name="startDate" label="Start Date" />
	<s:textfield name="endDate" label="End Date" />
	<s:textfield name="sessionPerWeek" label="Session Per Week" />
	<s:textfield name="collegeId" label="Degree Certificate Offered" />
</s:form>

</body>
</html>