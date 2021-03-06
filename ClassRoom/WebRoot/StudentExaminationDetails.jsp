<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@page import="com.dts.project.dao.ExamQuestionsMasterDao"%>
<%@page import="com.dts.core.util.CoreList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.yourcompany.struts.form.ExamQuestionMasterForm"%>
<%@page import="com.yourcompany.struts.form.StudentExaminationMasterForm"%>
<%@page import="com.dts.project.dao.StudentExaminationMasterDao"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
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
<meta name="location" content="Qu�bec, Canada">
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
        	 
        	<center><jsp:include page="StudentOptions.jsp"/></center> </td></tr>
    
    
    <td valign="top" width="617">
<table style="border-collapse: collapse; border-right-width: 0pt; border-top-width: 0pt; border-bottom-width: 0pt;" id="AutoNumber2" border="1" bordercolor="#dddddd" cellpadding="0" cellspacing="0" width="100%">
  <tbody><tr>
    <td style="border-style: none none none solid; border-width: medium medium medium 1px;" width="100%">

 	<p align="center">
 	</p>
      

  
</tbody></table>


<div align="right">
  <p>&nbsp;</p><% if(request.getParameter("status")!=null){%>
	<font color="#ffff00"><b><%=request.getParameter("status") %><%} %>
  <center><h3><font color="white">Student Examination Details </h3></center>
  <table width="357" height="260" border="0" style="width: 357px; height: 265px;">
    
 
   
       
	<form action="./studentExaminationDetails.do"><table align="center">
			<tr><td><b><font color="white">StudentExamId : </td><td><select name="studentExamId"/>
			<%StudentExaminationMasterDao dao=new StudentExaminationMasterDao();
			CoreList cl=dao.ViewStudentExaminationMaster();
			Enumeration en=cl.elements();
			while(en.hasMoreElements())
			{
			StudentExaminationMasterForm form=(StudentExaminationMasterForm)en.nextElement();
			%><option value="<%=form.getStudentExamId() %>"><%=form.getExamAggregade() %></option>
			<%} %></td></tr> 
			
			<%--<tr><td><b><font color="white">QuestionId : </td><td><select name="questionId"/> 
			<%
			ExamQuestionsMasterDao dao2=new ExamQuestionsMasterDao();
			CoreList cl2=dao2.ViewExamQuestionMaster();
			Enumeration en2=cl2.elements();
			while(en2.hasMoreElements())
			{
			ExamQuestionMasterForm form2=(ExamQuestionMasterForm)en2.nextElement(); 
			%>
			<option value="<%=form2.getQuestionId() %>"><%=form2.getCorrectAnswer() %></option>
			<%} %></select></td></tr>
			--%>
			<%
			int id1=0;
			int examid=0;
			ExamQuestionsMasterDao examQuestionsMasterDao=new ExamQuestionsMasterDao();
			CoreList examQuestionList=examQuestionsMasterDao.ViewExamQuestionMaster(examid);
			ExamQuestionMasterForm examQuestionMasterForm=null;
			for(int i=0;i<examQuestionList.size();i++){
			 examQuestionMasterForm=(ExamQuestionMasterForm)examQuestionList.get(i);
			 %>
			 <tr><td><font color="white">Qestion</font></td><td><font color="white"><%=examQuestionMasterForm.getQuestionText() %></font></td></tr>
			<tr>
			<td><b><font color="white">A1 :</font></b> </td><td><input type=radio name="<%=id1 %>" /><font color="white"><%=examQuestionMasterForm.getAnswer1() %></font> </td>
			<td><b><font color="white">A2 :</font></b> </td><td><input type=radio name="<%=id1 %>"  /> <font color="white"><%=examQuestionMasterForm.getAnswer2() %></font> </td>
			<td><b><font color="white">A3 :</font></b> </td><td><input type=radio name="<%=id1 %>" /><font color="white"><%=examQuestionMasterForm.getAnswer3() %> </font> </td>
			<td><b><font color="white">A4 : </font></b></td><td><input type=radio name="<%=id1 %>" /><font color="white"><%=examQuestionMasterForm.getAnswer4() %></font>  </td>
			<td><b><font color="white">A5 : </font></b></td><td><input type=radio name="<%=id1 %>" /><font color="white"><%=examQuestionMasterForm.getAnswer5() %></font>  </td>
			</tr>
			<%
			id1++;
			} %>
			<tr><td><b><font color="white">Correct_wrong : </font></b></td><td><input type=text name="correct_wrong"/></td></tr>
			
			<tr><td></td><td><input type=submit name="Register" value="Register"/> </td></tr></table>
		</form>
	 
      
      
      
      
   
     
  </table>
  <p>&nbsp;</p>
</div>









</td>   
     
    
 
</body></html> 
 
	
 
 
		
	 
