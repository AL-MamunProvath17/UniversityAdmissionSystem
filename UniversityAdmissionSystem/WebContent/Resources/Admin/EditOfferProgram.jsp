<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../../CSS/style.css" type="text/css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="../../SCRIPT/EditOfferProgram.js"></script>
</head>
<body>
<h1 class="header">Edit Offer Program</h1>
<%@taglib uri="/struts-tags" prefix="s"%>

<s:set var="pid" value="%{#session.programId}" />
<s:bean name="com.igate.uas.bean.ProgramsOfferedBean" var="prg">
	<s:param name="programId" value="#pid" />
</s:bean>
<s:set value="#session.programs.get(#session.programs.indexOf(#prg))"
	var="program" />


<table width="100%" class="collegeForm" cellpadding="5px">
	<s:form action="UpdateOfferProgramAction">
	
	<s:hidden name="programId" value="%{#program.programId}"/>
	
		<tr class="tableRow">
			<td class="tableTitle">Program Name :</td>
			<td><s:textfield name="programName" label="Program Name"
				cssClass="tableclass" value="%{#program.programName}" 
				onblur="validateProgramName(this,document.getElementById('errProgramName'))"/></td>
			<td><s:fielderror fieldName="programName" /></td>
			<td><span id="errProgramName" ></span></td>
		</tr>
		<tr class="tableRow">
			<td class="tableTitle">Application Eligibility :</td>
			<td><s:textfield name="applicantEligibility"
				label="Applicant Eligibility" cssClass="tableclass"
				value="%{#program.applicantEligibility}" 
				onblur="validateApplicantEligibilty(this,document.getElementById('errApplicantEligibilty'))"/></td>
			<td><s:fielderror fieldName="applicantEligibility" /></td>
			<td><span id="errApplicantEligibilty" ></span></td>
		</tr>
		<tr class="tableRow">
			<td class="tableTitle">Duration :</td>
			<td><s:textfield name="duration" label="Duration"
				cssClass="tableclass" value="%{#program.duration}" 
				onblur="validateDuration(this,document.getElementById('errDuration'))"/></td>
			<td><s:fielderror fieldName="duration" /></td>
			<td><span id="errDuration" ></span></td>
		</tr>
		<tr class="tableRow">
			<td class="tableTitle">Degree Certificate :</td>
			<td><s:textfield name="degreeCertificateOffered"
				label="Degree Certificate Offered" cssClass="tableclass"
				value="%{#program.degreeCertificateOffered}" 
				onblur="validateDegreeCertificateOffered(this,document.getElementById('errDegreeCertificateOffered'))"/></td>
			<td><s:fielderror fieldName="degreeCertificateOffered" /></td>
			<td><span id="errDegreeCertificateOffered" ></span></td>
		</tr>
		<tr class="tableRow">
			<td class="tableTitle">Description :</td>
			<td><s:textarea name="description" cols="19" rows="5"
				label="Description" cssClass="tableclass"
				value="%{#program.description}" 
				onblur="validateDescription(this,document.getElementById('errDescription'))"/></td>
			<td><s:fielderror fieldName="description" /></td>
			<td><span id="errDescription" ></span> </td>
		</tr>
		<tr>
			<td colspan="3" align="center">
			<s:submit cssClass="tableclassButton" 
			onclick="return validate(this.form)"/></td>
		</tr>
	</s:form>
</table>
<s:actionmessage cssClass="actionMessage" />
</body>
</html>