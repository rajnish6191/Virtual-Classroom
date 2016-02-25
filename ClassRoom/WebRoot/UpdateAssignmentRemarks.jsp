
<%@page import="com.dts.project.dao.AssignmentRemarksDao"%>
<%@page import="com.yourcompany.struts.form.AssignmentRemarksForm"%>
<%@page import="com.dts.project.dao.FacultyMasterDao"%>
<%@page import="com.dts.core.util.CoreList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.yourcompany.struts.form.FacultyMasterForm"%>
<%@page import="com.dts.project.dao.StudentAssignSubmissionMasterDao"%>
<%@page import="com.yourcompany.struts.form.StudentAssignSubmissionMasterForm"%> <%
 int id=Integer.parseInt(request.getParameter("Id"));
 AssignmentRemarksDao dao=new AssignmentRemarksDao();
 AssignmentRemarksForm form=dao.ViewAssignmentRemarksById(id);%>
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
  <% if(request.getParameter("status")!=null){%>
	<font color="#ffff00"><b><%=request.getParameter("status") %><%} %>
	<center><h3><font color="white">Update Assignment Remarks</h3></center>
  <table width="357" height="260" border="0" style="width: 357px; height: 265px;">
    
  
   
       <form action="UpdateAssignmentRemarksAction.jsp"><table align="center">
			<tr><td><b><font color="white">FacultyId : </td><td><select name="facultyId"/>
			<%
			String storepath=request.getRealPath("/images");
			FacultyMasterDao dao2=new FacultyMasterDao();
			CoreList cl2=dao2.ViewFacultyMaster(storepath);
			Enumeration en2=cl2.elements();
			 while(en2.hasMoreElements())
			 {
			 FacultyMasterForm form2=(FacultyMasterForm)en2.nextElement();
			 %>
			 <option value="<%=form2.getFacultyId() %>"><%=form2.getFacultyfirstname() %></option>
			 <%} %></select>
			<tr><td><b><font color="white">RemarksToStudent : </td><td><input type=text name="remarksToStudent" value="<%=form.getRemarksToStudent() %>"/></td></tr> 
			<tr><td><b><font color="white">AssignmentId : </td><td><select name="assignmentId"/>
			<%StudentAssignSubmissionMasterDao dao1=new StudentAssignSubmissionMasterDao();
			CoreList cl1=dao1.ViewStudentAssignSubmissionMaster(storepath);
			Enumeration en1=cl1.elements();
			while(en1.hasMoreElements())
			{
			StudentAssignSubmissionMasterForm form1=(StudentAssignSubmissionMasterForm)en1.nextElement();
			 %><option value="<%=form1.getAssignmentId() %>"><%=form1.getSubmissionDate() %></option>
			 <%} %></select></td></tr>
			<tr><td></td><td><input type=submit name="Update" value="Update"/> </td></tr></table>
		</form>
 
 
	
		 
	 
      
      
      
      
   
     
  </table>
  <p>&nbsp;</p>
</div>









</td>   
     
    
 
</body></html> 
 
	
 
 