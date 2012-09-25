<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="../../CSS/style.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="../../SCRIPT/AddCollege.js">
</script>
</head>
<body>

<%@taglib uri="/struts-tags" prefix="s" %>

<h1 class="header" align="center">Add College</h1>

<table width="100%" class="collegeForm" cellpadding="5px">

	<s:form action="AddCollegeAction" validate="true">
		<tr class="tableRow">
			<td class="tableTitle">College Name :</td>
			<td><s:textfield name="collegeName" label="College Name"
				cssClass="tableclass" 
				onblur="validateCollegeName(this,document.getElementById('errCollegeName'))"/></td>
			<td><s:fielderror fieldName="collegeName" /><span id="errCollegeName" ></span></td>
		</tr>
		<tr class="tableRow">
			<td class="tableTitle">Street :</td>
			<td><s:textfield name="street" label="Street"
				cssClass="tableclass" 
				onblur="validateStreet(this,document.getElementById('errStreet'))"/></td>
			<td><s:fielderror fieldName="street" /></td>
			<td><span id="errStreet" ></span></td>
		</tr>
		<tr class="tableRow">
			<td class="tableTitle">Land Mark :</td>
			<td><s:textfield name="landmark" label="Landmark"
				cssClass="tableclass" 
				onblur="validateLandmark(this,document.getElementById('errLandmark'))"/></td>
			<td><s:fielderror fieldName="landmark" /></td>
			<td><span id="errLandmark" ></span></td>
		</tr>
		<tr class="tableRow">
			<td class="tableTitle">City :</td>
			<td><s:textfield name="city" label="City" cssClass="tableclass" 
			onblur="validateCity(this,document.getElementById('errCity'))"/></td>
			<td><s:fielderror fieldName="city" /></td>
			<td><span id="errCity" ></span></td>
		</tr>
		<tr class="tableRow">
			<td class="tableTitle">State :</td>
			<td><s:textfield name="state" label="State"
				cssClass="tableclass" 
				onblur="validateState(this,document.getElementById('errState'))"/></td>
			<td><s:fielderror fieldName="state" /></td>
			<td><span id="errState" ></span></td>
		</tr>
		<tr class="tableRow">
			<td class="tableTitle">Pin Code :</td>
			<td><s:textfield name="pincode" label="Pincode"
				cssClass="tableclass" 
				onblur="validatePincode(this,document.getElementById('errPincode'))"/></td>
			<td><s:fielderror fieldName="pincode" /></td>
			<td><span id="errPincode" ></span></td>
		</tr>
		<tr>
			<td colspan="3" align="center"><s:submit cssClass="tableclassButton"
				onclick="return validate(this.form)"/></td>
		</tr>

	</s:form>
</table>
<s:actionmessage  cssClass="actionMessage"/>

</body>
</html>