
<%@page import="com.dts.project.dao.CourseLecturerMasterDao"%>
<%@page import="com.yourcompany.struts.form.CourseLecturerMasterForm"%>
<%@page import="com.dts.project.dao.FacultyMasterDao"%>
<%@page import="com.dts.core.util.CoreList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.yourcompany.struts.form.FacultyMasterForm"%>
<%@page import="com.dts.project.dao.CourseMasterDao"%>
<%@page import="com.yourcompany.struts.form.CourseMasterForm"%>
<script type="text/javascript" src="scripts/ts_picker.js"> </script>
<%
String storepath=request.getRealPath("/images");
int id=Integer.parseInt(request.getParameter("Id"));
CourseLecturerMasterDao dao=new CourseLecturerMasterDao();
CourseLecturerMasterForm form=dao.ViewCourseLecturerMasterById(storepath,id);%>
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
  <center><h3><b><font color="white">Update CourseLecturer Details </h3></center>
  <table width="357" height="260" border="0" style="width: 357px; height: 265px;">
    
  
   
<form action="UpdateCourseLecturerMasterAction.jsp" name="register"><table align="center">
			<tr><td><b><font color="white">LecturerId:</td><td><input type=text name="lecturerId" value="<%=id %>"></td></tr>
			 
			<tr><td><b><font color="white">FacultyId : </td><td><select name="facultyId"/>
			<%
			 
			FacultyMasterDao dao2=new FacultyMasterDao();
			CoreList cl2=dao2.ViewFacultyMaster(storepath);
			Enumeration en2=cl2.elements();
			 while(en2.hasMoreElements())
			 {
			 FacultyMasterForm form2=(FacultyMasterForm)en2.nextElement();
			 %>
			 <option value="<%=form2.getFacultyId() %>"><%=form2.getFacultyfirstname() %></option>
			 <%} %></select>
			<tr><td><b><font color="white">CourseId : </td><td><select name="courseId"/>
			<%CourseMasterDao dao3=new CourseMasterDao();
			CoreList cl3=dao3.ViewCourseMaster(storepath);
			Enumeration en3=cl3.elements();
			while(en3.hasMoreElements())
			{
			CourseMasterForm form3=(CourseMasterForm)en3.nextElement();
			 %><option value="<%=form3.getCourseId() %>"><%=form3.getCourseName() %></option>
			 <%} %></select> </td></tr>
			<tr><td><b><font color="white">LecturerDate : </td><td><input type=text name="lecturerDate" value="<%=form.getLecturerDate() %>"/><a href="javascript:show_calendar('document.register.lecturerDate',document.register.lecturerDate.value);"><img src="images/cal.gif" alt="a" width="18" height="18" border="0"/></a></td></tr>
			<tr><td><b><font color="white">LectureDurationTime : </td><td><input type=text name="lectureDurationTime" value="<%=form.getLectureDurationTime() %>"/></td></tr>
			<tr><td><b><font color="white">LecturerVideo : </td><td><input type=file name="lecturerVideo"/><font color="#00ff00">select .wmv File</td></tr>
			<tr><td><b><font color="white">LectureassignmentFile : </td><td><input type=file name="lectureassignmentFile"/><font color="#00ff00">select .doc File</td></tr> 
			<tr><td><b><font color="white">LectureDocumentfile : </td><td><input type=file name="lectureDocumentfile"/><font color="#00ff00">select .doc File</td></tr> 
			<tr><td><b><font color="white">LecturerPowerPoint : </td><td><input type=file name="lecturerPowerPoint"/><font color="#00ff00">select .ppt File </td></tr>
			<tr><td><b><font color="white">LecturerAudio : </td><td><input type=file name="lecturerAudio"/> <font color="#00ff00">select .wav File</td></tr>
			<tr><td></td><td><input type=submit name="Update" value="Update"/> </td></tr></table>
		</form>
       
	
		 
	 
      
      
      
      
   
     
  </table>
  <p>&nbsp;</p>
</div>









</td>   
     
    
 
</body></html> 
 
	
