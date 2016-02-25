<%@page import="com.dts.project.dao.StudentExaminationMasterDao"%>
<%@page import="com.dts.core.util.CoreHash"%>
<%@page import="com.dts.core.util.CoreList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.yourcompany.struts.form.StudentExaminationMasterForm"%>
<html><head>
<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">

<title>VirtualClassRoom</title>
<meta name="DESCRIPTION" content="The Municipal Suppliers Directory is the most complete reference tool available to the Canadian Municipalities.">
<meta name="KEYWORDS" content="Government,Purchasing,Municipal,city,heavy machinerie,water,pump,snow,Fire,environment,street,bus,batterie,cable,concrete,pipe,snowplow,waste management,police,lighting,sign,suppliers,tender,engine,generator,tools,meter,pole,security,traffic,valve,suppliers, parking">
<meta name="subject" content="The Municipal Suppliers Directory is the most complete reference tool available to the Canadian Municipalities.">
<meta name="robots" content="index, follow">
<meta name="revisit-after" content="1 days">
<meta name="reply-to" content="info@jaguar-media.com">
<meta name="author" content="Jaguar Media">
<meta name="location" content="Québec, Canada">
<meta name="Identifier-URL" content="http://www.municipalsuppliers.com/">
<meta name="Publisher" content="Jaguar Media Inc">

<link rel="stylesheet" href="images/style_municipal1.css">
<link rel="stylesheet" href="images/style_municipal2.css">
<link rel="stylesheet" href="images/style_municipal3.css">
<link rel="stylesheet" href="images/style_municipal1.css">
<script src="images/include.js"></script>
<style type="text/css">
<!--
.style1 {
	color: #000000;
	font-weight: bold;
}
-->
</style>
</head><center><body topmargin="0" bgcolor="#234244" marginwidth="">
<table border=1><tr><td colspan="2" bordercolor="white"><img alt="" src="images/classroom.JPG"></td></tr></table>  

<!-- ========================== HAUT ====================================== --><!-- ============================ CENTRE TOP ============================================= -->

<table border=1 bordercolor="white" width="695" height="450" cellpadding="0" cellspacing="0"  bgcolor="#525678">
  <tr><td bgcolor="white" height="10" width="750">
        	 
        	<center><jsp:include page="FacultyOptions.jsp"/></center> </td></tr>
    
    
    <td valign="top" width="617">
<table style="border-collapse: collapse; border-right-width: 0pt; border-top-width: 0pt; border-bottom-width: 0pt;" id="AutoNumber2" border="1" bordercolor="#dddddd" cellpadding="0" cellspacing="0" width="100%">
  <tbody><tr>
    <td style="border-style: none none none solid; border-width: medium medium medium 1px;" width="100%">

 	<p align="center">
 	</p>
      

  
</tbody></table>
 <center><h2><font color="white"><b>View Exam Results</b></font></h2></center>
  

<div align="right">
  <p>&nbsp;</p>
  
  <table width="357" height="260" border="0" style="width: 357px; height: 265px;">
   
   
    <tr><center><font size="4" color="white"><%  
int userid=((Integer)session.getAttribute("facultyid")).intValue();
StudentExaminationMasterDao adao=new StudentExaminationMasterDao(); 
CoreList acorelist=adao.ViewStudentExaminationDetails(userid); 
Enumeration aEnumeration=acorelist.elements(); 
%>
<table><tr bgcolor="white"><td><b>Student Name</b></td><td><b>Exam  Date</b></td><td><b>EXAM AGGREGADE</b></td><td><b>Result</b></td></tr>
<%while(aEnumeration.hasMoreElements()) 
{ 
StudentExaminationMasterForm aform=(StudentExaminationMasterForm)aEnumeration.nextElement();
  %>

<tr bgcolor="skyblue"><td><%=aform.getStudentName() %></td><td><%=aform.getExaminatiodate() %></td><td><%=aform.getExamAggregade() %></td><td><%=aform.getExamResult() %></td></tr>
<%} %>

  </body>
 

      
      
      
      
   
   
   
  <p>&nbsp;</p>










 
     
    
 
 </html>