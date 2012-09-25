<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="../../CSS/style.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="../../SCRIPT/EditCollege.js"></script>
</head>
<body>

<%@taglib uri="/struts-tags" prefix="s"%>

<h1 class="header" align="center">Edit College</h1>

<s:set var="cid" value="%{#session.collegeId}" />
<s:bean name="com.igate.uas.bean.CollegeBean" var="clg">
	<s:param name="collegeId" value="#cid" />
</s:bean>
<s:set value="#session.colleges.get(#session.colleges.indexOf(#clg))"
	var="college" />

<table width="100%" class="collegeForm" cellpadding="5px">

	<s:form action="UpdateCollegeAction" validate="true">
	
	<s:hidden value="%{#college.collegeId}" name="collegeId"/>
	
		<tr class="tableRow">
			<td class="tableTitle">College Name :</td>
			<td><s:textfield name="collegeName" label="College Name"
				cssClass="tableclass" name="collegeName"
				value="%{#college.collegeName}" 
				onblur="validateCollegeName(this,document.getElementById('errCollegeName'))"/></td>
			<td><s:fielderror fieldName="collegeName" /></td>
			<td><span id="errCollegeName" ></span></td>
		</tr>
		<tr class="tableRow">
			<td class="tableTitle">Street :</td>
			<td><s:textfield name="street" label="Street"
				cssClass="tableclass" value="%{#college.street}" 
				onblur="validateStreet(this,document.getElementById('errStreet'))"/></td>
			<td><s:fielderror fieldName="street" /></td>
			<td><span id="errStreet" ></span></td>
		</tr>
		<tr class="tableRow">
			<td class="tableTitle">Land Mark :</td>
			<td><s:textfield name="landmark" label="Landmark"
				cssClass="tableclass" value="%{#college.landmark}" 
				onblur="validateLandmark(this,document.getElementById('errLandmark'))"/></td>
			<td><s:fielderror fieldName="landmark" /></td>
			<td><span id="errLandmark" ></span></td>
		</tr>
		<tr class="tableRow">
			<td class="tableTitle">City :</td>
			<td><s:textfield name="city" label="City" cssClass="tableclass"
				value="%{#college.city}" 
				onblur="validateCity(this,document.getElementById('errCity'))"/></td>
			<td><s:fielderror fieldName="city" /></td>
			<td><span id="errCity" ></span></td>
		</tr>
		<tr class="tableRow">
			<td class="tableTitle">State :</td>
			<td><s:textfield name="state" label="State"
				cssClass="tableclass" value="%{#college.state}" 
				onblur="validateState(this,document.getElementById('errState'))"/></td>
			<td><s:fielderror fieldName="state" /></td>
			<td><span id="errState" ></span></td>
		</tr>
		<tr class="tableRow">
			<td class="tableTitle">Pin Code :</td>
			<td><s:textfield name="pincode" label="Pincode"
				cssClass="tableclass" value="%{#college.pincode}" 
				onblur="validatePincode(this,document.getElementById('errPincode'))"/></td>
			<td><s:fielderror fieldName="pincode" /></td>
			<td><span id="errPincode" ></span></td>
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