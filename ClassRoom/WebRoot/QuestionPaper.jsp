<%@page import="com.dts.project.dao.ExaminationScheduleDao"%>
<%@page import="com.dts.project.dao.ExaminationScheduleDao"%>
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
<SCRIPT type="text/javascript" src="scripts/general.js"> </SCRIPT>
<SCRIPT type="text/javascript" src="scripts/project.js"> </SCRIPT>
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


<div align="right">
  <p>&nbsp;</p>
  
  <table width="357" height="260" border="0" style="width: 357px; height: 265px;">
    <center><font color="white"><b>Add Question Paper</b></font></center><tr><td>
    <%
int examid=Integer.parseInt(request.getParameter("examid"));
//int noofquestions=Integer.parseInt(request.getParameter("noofquestions")); 
int id=new ExaminationScheduleDao().noofquestiong(examid);
int id1=new ExaminationScheduleDao().countquestions(examid);
System.out.println("this is id"+id);
System.out.println("this is id1"+id1);
%>

<%if(id==id1)
{%>
<font color="white"><b>Questions Added Successfully</b></font>
 <%}else{%>
<form action ="QuestionPaperAction.jsp" method="post" onsubmit="return validateFields()">
<table>
<input type="hidden" name="examid" value="<%=examid %>"/>

<tr><td><font color="white"><b>Question Text</b></font></td><td><input type="text" name="questiontext"></td></tr>
<tr><td><font color="white"><b>Answer1</b></font></td><td><input type="text" name="answer1"></td></tr>
<tr><td><font color="white"><b>Answer2</b></font></td><td><input type="text" name="answer2"></td></tr>
<tr><td><font color="white"><b>Answer3</b></font></td><td><input type="text" name="answer3"></td></tr>
<tr><td><font color="white"><b>Answer4</b></font></td><td><input type="text" name="answer4"></td></tr>
<tr><td><font color="white"><b>Answer5</b></font></td><td><input type="text" name="answer5"></td></tr>
<tr><td><font color="white"><b>Correct Answer</b></font></td><td><input type="text" name="correctanswer"></td></tr>
<tr><td></td><td><input type="hidden" name="marks" value="1">
</td></tr>
<tr><td></td><td><input type="submit" name="send" value="register"/></td></tr>
</table>
</form><%}%>
  
   
 

</table>
 
 
   </body>
 

 








 
     
    
 
 </html>