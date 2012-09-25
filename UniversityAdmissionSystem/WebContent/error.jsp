<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%--

File Name      : error.jsp
Description    : Error page for the Matrimony System
Author         : jb804412 (Jimish Bhayani)
Last Edited By : jb804412 (Jimish Bhayani)
Created on     : Aug 28, 2012

--%>
	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>
<link href="CSS/style.css" type="text/css" rel="stylesheet" />
</head>
<body>
<%@taglib uri="/struts-tags" prefix="s"%>
<h1><br />
Exception Message &nbsp; : &nbsp; <s:property value="exception.message" /></h1>

<br />
Exception Name &nbsp; : &nbsp;
<s:property value="exception" />

<br />
<a href="HomePage.jsp">Go To HomePage</a>
</body>
</html>