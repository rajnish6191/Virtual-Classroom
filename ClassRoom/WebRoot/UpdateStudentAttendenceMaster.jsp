
<%@page import="com.dts.project.dao.StudentAttendenceMasterDao"%>
<%@page import="com.yourcompany.struts.form.StudentAttendanceMasterForm"%>
<%@page import="com.dts.project.dao.StudentMasterDao"%>
<%@page import="com.dts.core.util.CoreList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.yourcompany.struts.form.StudentMasterForm"%>
<%@page import="com.dts.project.dao.CourseMasterDao"%>
<%@page import="com.yourcompany.struts.form.CourseMasterForm"%>
<%@page import="com.dts.project.dao.CourseLecturerMasterDao"%>
<%@page import="com.yourcompany.struts.form.CourseLecturerMasterForm"%> 
<script type="text/javascript" src="scripts/ts_picker.js"> </script>
<%
 int id=Integer.parseInt(request.getParameter("Id"));
 StudentAttendenceMasterDao dao=new StudentAttendenceMasterDao();
 StudentAttendanceMasterForm form=dao.ViewStudentAttendenceMasterById(id);%><html><head>
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
        	 
        	<%System.out.println(session.getAttribute("role").toString());%>
        	 <%if(session.getAttribute("role").toString()=="admin"){ %>
        	<center><jsp:include page="Adminoptions.jsp"/></center> 
        	<%}else if(session.getAttribute("role").toString()=="faculty"){  %>
        	<center><jsp:include page="FacultyOptions.jsp"/></center> 
    <% }%>
   </td></tr> 
    
    
    <td valign="top" width="617">
<table style="border-collapse: collapse; border-right-width: 0pt; border-top-width: 0pt; border-bottom-width: 0pt;" id="AutoNumber2" border="1" bordercolor="#dddddd" cellpadding="0" cellspacing="0" width="100%">
  <tbody><tr>
    <td style="border-style: none none none solid; border-width: medium medium medium 1px;" width="100%">

 	<p align="center">
 	</p>
      

  
</tbody></table>


<div align="right">
  <p>&nbsp;</p> 
  <center><h3><b><font color="white">Update Student Assignment Details </h3></center>
  <table width="357" height="260" border="0" style="width: 357px; height: 265px;">
    
  
   
       <form action="UpdateStudentAttendanceMasterAction.jsp" name="register"><table align="center">
 			<tr><td><b><font color="white">AttendenceId:</td><td><input type=text name="attendenceId" value="<%=id %>"></td></tr>
			<tr><td><b><font color="white">StudentId : </td><td><select name="studentId"/> 
			<%
			String storepath=request.getRealPath("/images");
			StudentMasterDao dao1=new StudentMasterDao();
			CoreList cl1=dao1.ViewStudentMaster(storepath); 
			Enumeration en1=cl1.elements();
			while(en1.hasMoreElements())
			{
			StudentMasterForm form1=(StudentMasterForm)en1.nextElement();
			%><option value="<%=form1.getStudentid() %>"><%=form1.getStudentfirstname() %></option>
			<%} %></select></td></tr>
			<tr><td><b><font color="white">AttendanceDateTime : </td><td><input type=text name="attendenceDateTime" value="<%=form.getAttendanceDateTime() %>3"/><a href="javascript:show_calendar('document.register.attendenceDateTime',document.register.attendenceDateTime.value);"><img src="images/cal.gif" alt="a" width="18" height="18" border="0"/></a></td></tr> 
			 
			<tr><td><b><font color="white">CourseId : </td><td><select name="courseId"/>
			<%CourseMasterDao dao3=new CourseMasterDao();
			CoreList cl3=dao3.ViewCourseMaster(storepath);
			Enumeration en3=cl3.elements();
			while(en3.hasMoreElements())
			{
			CourseMasterForm form3=(CourseMasterForm)en3.nextElement();
			 %><option value="<%=form3.getCourseId() %>"><%=form3.getCourseName() %></option>
			 <%} %></select> </td></tr>
			<tr><td><b><font color="white">DisconnectedDateTime : </td><td><input type=text name="disconnectedDateTime" value="<%=form.getDisconnectedDateTime() %>"/><a href="javascript:show_calendar('document.register.disconnectedDateTime',document.register.disconnectedDateTime.value);"><img src="images/cal.gif" alt="a" width="18" height="18" border="0"/></a></td></tr> 
			<tr><td><b><font color="white">LecturerId : </td><td><select name="lecturerId"/> 
			<%CourseLecturerMasterDao dao2=new CourseLecturerMasterDao();
			CoreList cl2=dao2.ViewCourseLecturerMaster(storepath);
			Enumeration en2=cl2.elements();
			while(en2.hasMoreElements())
			{
			CourseLecturerMasterForm form2=(CourseLecturerMasterForm)en2.nextElement();
			 %>
			 <option value="<%=form2.getLecturerId()%>"><%=form2.getLecturerId()%></option>
			 <%} %></select></td></tr>
			<tr><td></td><td><input type=submit name="Update" value="Update"/> </td></tr></table>
		</form>
	
		 
	 
      
      
      
      
   
     
  </table>
  <p>&nbsp;</p>
</div>









</td>   
     
    
 
</body></html> 
 
	
 
 