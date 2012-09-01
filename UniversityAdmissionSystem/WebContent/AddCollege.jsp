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

<s:form action="AddCollegeAction">
	<s:textfield name="collegeName" label="Degree Name" />
	<s:textfield name="street" label="Street" />
	<s:textfield name="landmark" label="Landmark" />
	<s:textfield name="city" label="City" />
	<s:textfield name="state" label="State" />
	<s:textfield name="pincode" label="Pincode" />
</s:form>

</body>
</html>