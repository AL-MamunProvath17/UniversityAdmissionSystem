<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<SCRIPT type="text/javascript">
	function submitForm(form) {
		form.submit();
	}

	function setStartValue(id, date) {
		var picker = dojo.widget.byId(id);
		date = date.substring(0, 10);
		//string value
		picker.setValue(date);

	}
</SCRIPT>
</head>



<body>

<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="do" uri="/struts-dojo-tags"%>

<do:head />



<s:form action="temp">

<s:actionmessage />

	<s:select list="#session.scheduledData" listKey="key.collegeId"
		listValue="key.collegeName" name="collegeId"
		onchange="submitForm(this.form)" headerKey="" headerValue="select"
		value="%{#parameters.collegeId}" label="Collge"/>


	<s:if test="%{#parameters.collegeId != null}">

		<s:set var="cid" value="%{#parameters.collegeId}" />
		<s:bean name="com.igate.uas.bean.CollegeBean" var="college">
			<s:param name="collegeId" value="#cid" />
		</s:bean>

		<s:select list="#session.scheduledData[#college]"
			listKey="key.degreeId" listValue="key.degreeName" name="degreeId"
			onchange="submitForm(this.form)" headerKey="" headerValue="select"
			value="%{#parameters.degreeId}" label="Degree"/>

		<s:if test="%{#parameters.degreeId != null}">
			<s:set var="did" value="%{#parameters.degreeId}" />
			<s:bean name="com.igate.uas.bean.DegreeBean" var="degree">
				<s:param name="degreeId" value="#did" />
			</s:bean>

			<s:select list="#session.scheduledData[#college][#degree]"
				name="programId" headerKey="" headerValue="select"
				listKey="programId" listValue="programName" label="Program"/>

			<do:datetimepicker name="startDate" label="Start Date"
				displayFormat="dd-MMM-yyyy" />
			<do:datetimepicker name="endDate" label="End Date"
				displayFormat="dd-MMM-yyyy" />
			<s:textfield name="sessionPerWeek" label="Session Per Week"
				value="%{#parameters.sessionPerWeek}" />

			<s:submit action="ScheduleProgramAction"></s:submit>
		</s:if>
	</s:if>

</s:form>

</body>
</html>