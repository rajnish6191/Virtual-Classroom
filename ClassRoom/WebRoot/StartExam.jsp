<%@page import="com.dts.project.dao.ExamQuestionsMasterDao"%>
<%@page import="com.dts.core.util.CoreList"%>
<%@page import="com.yourcompany.struts.form.ExamQuestionMasterForm"%>
<%@page import="com.yourcompany.struts.form.StudentExaminationMasterForm"%>
<%@page import="com.dts.project.dao.StudentExaminationMasterDao"%>
<%@page import="com.dts.core.dao.AbstractDataAccessObject"%>
<%@page import="com.dts.project.dao.StudentExaminationDetailsDao"%>
<%@page import="java.util.Enumeration"%>
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
        	 
        	<center><jsp:include page="StudentOptions.jsp"/></center> </td></tr>
    
    
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
    <tr><td><%

int examid=Integer.parseInt(request.getParameter("examid")); 
int noofquestions=Integer.parseInt(request.getParameter("noofquestions")); 
String date=request.getParameter("date"); 
int i=1;

StudentExaminationMasterForm aform1=new StudentExaminationMasterForm();
aform1.setExamAttendedDateTime(date);
aform1.setExaminationId(examid);
int studentid=((Integer)session.getAttribute("userid")).intValue();
aform1.setStudentId(studentid);


int studentexamid=new AbstractDataAccessObject().getSequenceID("StudentExaminationMaster","STUDENTEXAMID");
aform1.setStudentExamId(studentexamid);

StudentExaminationMasterDao adao1=new StudentExaminationMasterDao();

boolean flag1=adao1.insertStudentExaminationMaster(aform1);



System.out.println("result");
%>
 <%ExamQuestionsMasterDao adao=new ExamQuestionsMasterDao();
 CoreList acorelist=adao.ViewExamQuestionsMaster(examid);
   Enumeration aenumeration=acorelist.elements();
   while(aenumeration.hasMoreElements())
   {
   ExamQuestionMasterForm aform=(ExamQuestionMasterForm)aenumeration.nextElement();
   %>
   <form action="StartExamAction.jsp">
   <table><tr><td><font color="White"><b>Question <%=aform.getQuestionId() %></b></font></td><td><font color="white"><b><%=aform.getQuestionText() %></b></font></td></tr>
   <input type="hidden" name="questionid" value="<%=aform.getQuestionId() %>"/> 
   <input type="hidden" name="examid" value="<%=examid %>"/>
  <input type="hidden" name="studentexmid" value="<%=studentexamid %>"/>
    <input type="hidden" name="noofquestions" value="<%=noofquestions %>"/>
   <input type="hidden" name="q1" value="<%=i %>"/>
   <tr><td><input type="radio" name="<%=i %>" value="<%=aform.getAnswer1() %>"><font color="White"><b><%=aform.getAnswer1() %></b></font></td>
   <td><input type="radio" name="<%=i %>" value="<%=aform.getAnswer2() %>"><font color="White"><b><%=aform.getAnswer2() %></b></font></td>
   <td><input type="radio" name="<%=i %>" value="<%=aform.getAnswer3() %>"><font color="White"><b><%=aform.getAnswer3() %></b></font></td>
   <td><input type="radio" name="<%=i %>" value="<%=aform.getAnswer4() %>"><font color="White"><b><%=aform.getAnswer4() %></b></font></td>
   <td><input type="radio" name="<%=i %>" value="<%=aform.getAnswer5() %>"><font color="White"><b><%=aform.getAnswer5() %></b></font></td>
</tr><tr></tr><tr></tr><% i++;}%>
<tr><td></td><td><input type="submit" name="Send" value="Send"></td></tr>
</table></form><%--<%}else { --%>
<%--StudentExaminationMasterDao adao1=new StudentExaminationMasterDao();--%>
<%--aform1.setStudentExamId(studentexamid);--%>
<%--int n1=new StudentExaminationDetailsDao().getcount(studentexamid);--%>
<%--float percentage=(n1/noofquestions)*100;--%>
<%--aform1.setExamAggregade(n1);--%>
<%--int result=new ExamQuestionsMasterDao().getResult(examid);--%>
<%----%>
<%--if(result<percentage)--%>
<%--{--%>
<%--aform1.setResult("pass");--%>
<%--}--%>
<%--aform1.setResult("Fail");--%>
<%--boolean flag1=adao1.UpdateStudentExaminationMaster(aform1);--%>
<%--System.out.println("flag1"+flag1);--%>
<%--}--%>
<%----%>
<%--%>--%>
 <p>&nbsp;</p>
</td></tr></table></div></td></table></body>
 </html>