<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<link href="CSS/style.css" type="text/css" rel="stylesheet" />

<script src="SCRIPT/UAS.js" type="text/javascript">
    </script>
<script src="HomePage.js" type="text/javascript">
    </script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>Alliant University</title>

</head>

<body onload="loadmain()">

<!-- site wrapper starts here-->
<div class="site-wrapper"><!--  includes header--> <s:include
	value="Resources/General/Header.html" /> <!--   includes menu bar--> <s:include
	value="Resources/General/MenuBar.html" /> <!--    body wrapper starts here-->
<div class="body-wrapper"><!--      includes navigator--> <%-- <s:include  value="Resources/General/Navigator.html" /> --%>
<div class="navigation" id="nav"></div>

<!-- includes content dynamically-->



<div id="mainId"></div>

<div class="rightSideBar" id="rightSideBar">

<div class="right-sub1"><s:form action="login" method="post">
	<table class="right-sub12">
		<tr>
			<td>USER NAME:</td>
		</tr>
		<tr>
			<td><input type="text" name="loginId" class="tableclass"
				onblur="validateLoginId(this,document.getElementById('errFullName'))" /></td>
		</tr>

		<tr>
			<td>PASSWORD:</td>
		</tr>
		<tr>
			<td><input type="password" name="password" class="tableclass"
				onblur="validatePassword(this,document.getElementById('errPassword'))" /></td>
		</tr>

		<tr>
			<td align="left" class="loginbutton"><input type="submit" value="Login"
				class="tableclass" /></td>
		</tr>
	</table>

	<div>
	<span id="errFullName" class="errorMessage"></span>
	<span id="errPassword" class="errorMessage"></span>
	</div>

	<s:actionerror />
</s:form></div>
<div class="status">
<p class="links"><span
	onclick="loadApplication('Resources/Applicant/checkStatus.jsp')">Check
Application Status</span></p>
</div>
<div class="right-sub2">

<h4 align="center">NEWS&amp;EVENTS</h4>
<p><marquee scrollamount="3" direction="up" onmouseover="stop();"
	onmouseout="start();" class="marquee"> &gt;&gt;FRESHERS DAY
CELEBRATIONS <br />
<br />
&gt;&gt;NOTIFICATION FOR SEMESTER EXAMS <br />
<br />
&gt;&gt;SPORTS DAY </marquee></p>
</div>
</div>

</div>
<!--    body wrapper ends here--> <!--    includes footer--> <s:include
	value="Resources/General/Footer.html" /></div>
<!-- site wrapper ends here-->

</body>

</html>