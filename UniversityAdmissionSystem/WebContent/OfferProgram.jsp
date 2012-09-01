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

<s:form action="OfferProgramAction">
	<s:textfield name="programName" label="Program Name" />
	<s:textfield name="applicantEligibility" label="Applicant Eligibility" />
	<s:textfield name="duration" label="Duration" />
	<s:textfield name="degreeCertificateOffered" label="Degree Certificate Offered" />
	<s:textfield name="description" label="Description" />
</s:form>

</body>
</html>