
<%@page import="com.dts.project.dao.StudentExaminationMasterDao"%>
<%@page import="com.yourcompany.struts.form.StudentExaminationMasterForm"%>
<%@page import="com.dts.project.dao.StudentMasterDao"%>
<%@page import="com.dts.core.util.CoreList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.yourcompany.struts.form.StudentMasterForm"%>
<%@page import="com.dts.project.dao.ExaminationScheduleDao"%>
<%@page import="com.yourcompany.struts.form.ExaminationScheduleForm"%> <%
 int id=Integer.parseInt(request.getParameter("Id"));
 StudentExaminationMasterDao dao=new StudentExaminationMasterDao();
 StudentExaminationMasterForm form=dao.ViewStudentExaminationMasterById(id);%>
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
        	 
        	<center><jsp:include page="Adminoptions.jsp"/></center> </td></tr>
    
    
    <td valign="top" width="617">
<table style="border-collapse: collapse; border-right-width: 0pt; border-top-width: 0pt; border-bottom-width: 0pt;" id="AutoNumber2" border="1" bordercolor="#dddddd" cellpadding="0" cellspacing="0" width="100%">
  <tbody><tr>
    <td style="border-style: none none none solid; border-width: medium medium medium 1px;" width="100%">

 	<p align="center">
 	</p>
      

  
</tbody></table>


<div align="right">
  <p>&nbsp;</p> 
  <center><h3><b><font color="white">Update Student Examinations </h3></center>
  <table width="357" height="260" border="0" style="width: 357px; height: 265px;">
    
  
   <form action="UpdtaeStudentExaminationMasterAction.jsp"><table align="center">
 			<tr><td><b><font color="white">StudentExamId:</td><td><input type=text name="studentExamId" value="<%=id %>"></td></tr>
			<tr><td><b><font color="white">StudentId : </td><td><select name="studentId"/> 
			<%
			String storepath=request.getRealPath("/images");
			StudentMasterDao dao2=new StudentMasterDao();
			CoreList cl2=dao2.ViewStudentMaster(storepath); 
			Enumeration en2=cl2.elements();
			while(en2.hasMoreElements())
			{
			StudentMasterForm form2=(StudentMasterForm)en2.nextElement();
			%><option value="<%=form2.getStudentid() %>"><%=form2.getStudentfirstname() %></option>
			<%} %></select></td></tr>
			<tr><td><b><font color="white">EexamAggregade : </td><td><input type=text name="examAggregade" value="<%=form.getExamAggregade() %>"/> </td></tr>
			<tr><td><b><font color="white">ExamAttendedDateTime : </td><td><input type=text name="examAttendedDateTime" value="<%=form.getExamAttendedDateTime() %>"/><a href="javascript:show_calendar('document.register.examAttendedDateTime',document.register.examAttendedDateTime.value);"><img src="images/cal.gif" alt="a" width="18" height="18" border="0"/></a></td></tr> 
			<tr><td><b><font color="white">ExamResult : </td><td><input type=text name="examResult" value="<%=form.getExamResult()%>"/> </td></tr>
 
			<tr><td><b><font color="white">ExaminationId : </td><td><select name="examinationId" value="<%=form.getExaminationId() %>"/>
			<%ExaminationScheduleDao dao1=new ExaminationScheduleDao();
			CoreList cl1=dao1.ViewExaminationSchedule();
			Enumeration en1=cl1.elements();
			while(en1.hasMoreElements())
			{
			ExaminationScheduleForm form1=(ExaminationScheduleForm)en1.nextElement();
			  %><option value="<%=form1.getExaminationId() %>"><%=form1.getExaminationDate() %></option>
			  <%} %></select></td></tr> 
			<tr><td></td><td><input type=submit name="Update" value="Update"/> </td></tr></table>
		</form>
       
	
		 
	 
      
      
      
      
   
     
  </table>
  <p>&nbsp;</p>
</div>









</td>   
     
    
 
</body></html> 
 
	
 
 