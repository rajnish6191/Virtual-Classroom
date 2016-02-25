
<%@page import="com.dts.project.dao.AssignmentRemarksDao"%>
<%@page import="com.dts.core.util.CoreList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.yourcompany.struts.form.AssignmentRemarksForm"%><html><head>
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
  
  <table width="357" height="260" border="0" style="width: 357px; height: 265px;">
 <tr><td><center>View Remarks</center>
 <%try{
 int assignmentid=Integer.parseInt(request.getParameter("assignmentid"));
  AssignmentRemarksDao adao=new AssignmentRemarksDao();
  CoreList acorelist=adao.ViewAssignmentRemarks(assignmentid); 
 Enumeration en=acorelist.elements();
  %>
 
 <table align="center" border=1>
 <tr><th><input type=checkbox name="TypeId"></th>
 <th><font color="white">AssinSubDt</th>           
<th><font color="white">Fname</th>              
<th><font color="white">RemarksToStudent</th></tr>
<%while(en.hasMoreElements())
{
AssignmentRemarksForm form=(AssignmentRemarksForm)en.nextElement();
%>
<tr><td><input type="checkbox" name="TypeId" value="<%=form.getAssignmentId() %>"></td>
<td><b><a href="UpdateAssignmentRemarks.jsp?Id=<%=form.getAssignmentId() %>"><u><font color="#ffff00"><%=form.getSubmissionDate()%></a></td>
<td align="center"><b><font color="#ffff00"><%=form.getFname()%></td>
<td align="center"><b><font color="#ffff00"><%=form.getRemarksToStudent()%></td>
</tr>
<%}}catch(Exception e)
{
e.printStackTrace();
}
%>
</table>
 
  </body>
 

      
      
      
      
   
   
   
  <p>&nbsp;</p>










 
     
    
 
 </html>