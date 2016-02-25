
<br><br><%@page import="com.dts.project.dao.CourseMasterDao"%>
<%@page import="com.dts.core.util.CoreList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.yourcompany.struts.form.CourseMasterForm"%> 
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
        	 
        	<center><jsp:include page="GeneralOptions.jsp"/></center> </td></tr>
    
    
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
	<font color="#ffff00"><b><%=request.getParameter("status") %><%} %></b></font>
   
	<center><h3><font color="white">Course Details</h3></center>
  <table width="357" height="260" border="0" style="width: 357px; height: 265px;">
    
  
   
       
<%
try
{
 //String storepath=request.getRealPath("/images");
 //CourseMasterDao dao=new CourseMasterDao();
 //CoreList cl=dao.ViewCourseMaster(storepath);
 CoreList cl=(CoreList)request.getAttribute("c1");
 Enumeration en=cl.elements();
 %>
 
<table align="center" border=1>
<tr>
<th><font color="white">Cname</th>          
<th><font color="white">CourseDesc</th>     
<th><font color="white">CourseDuration</th>
<th><font color="white">CourseContentFile</th>  
<th><font color="white">NoOfLecturers</th></tr>
<%while(en.hasMoreElements())
{
CourseMasterForm form=(CourseMasterForm)en.nextElement();
%>
<tr>
<td align="center"><b><u><font color="#ffff00"><%=form.getCourseName() %></td>
<td><b><font color="#ffff00"><%=form.getCourseDesc() %></td>
<td align="center"><b><font color="#ffff00"><%=form.getCourseDuration() %></td>
<td align="center"><b><a href="images/<%=form.getCoursecontent() %>"><font color="#ffff00">Click Here</a></td>
<td align="center"><b><font color="#ffff00"><%=form.getNoOfLecturers() %></td></tr>
<%
}
}catch(Exception e)
{
e.printStackTrace();
}
%>  
</table>

		 
	 
      
      
      
      
   
     
  </table>
  <p>&nbsp;</p>
</div>









</td>   
     
    
 
</body></html> 
 
	

