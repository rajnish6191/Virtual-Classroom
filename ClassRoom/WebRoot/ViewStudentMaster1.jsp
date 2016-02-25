
<%@page import="com.dts.project.dao.StudentMasterDao"%>
<%@page import="com.dts.core.util.CoreList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.yourcompany.struts.form.StudentMasterForm"%>
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
	<font color="#ffff00"><b><%=request.getParameter("status") %><%} %></b></font>
   
	<center><h3><font color="white">Student Details</h3></center>
 <span class="style13">Export to : <a href="ExportXLS" target="_blank"><font color="brown">XLS</font></a></span>
  <table width="357" height="260" border="0" style="width: 357px; height: 265px;">
    
  
   
 
<%
try
{
//String storepath=request.getRealPath("./images");
//StudentMasterDao dao=new StudentMasterDao();
//CoreList cl=dao.ViewStudentMaster(storepath);
CoreList cl=(CoreList)request.getAttribute("cl");
Enumeration en=cl.elements();
String report="";
report+="<table align='center' border=1><tr><th><font color='black'>FName</th><th><font color='black'>MName</th>";
report+="<th><font color='black'>LName</th><th><font color='black'>DOB</th><th><font color='black'>DOR</th><th><font color='black'>Address</th>";                
report+="<th><font color='black'>Email</th><th><font color='black'>Phone</th><th><font color='black'>Image</th></tr>";

%>
 
          
   
<table align="center" border=1>
<tr>
<th><font color="white">FName</th>       
<th><font color="white">MName</th>
<th><font color="white">LName</th>        
<th><font color="white">DOB</th>                    
<th><font color="white">DOR</th>                    
<th><font color="white">Address</th>                
<th><font color="white">Email</th>                  
<th><font color="white">Phone</th>                  
<th><font color="white">Image</th></tr>
<%while(en.hasMoreElements())
{
StudentMasterForm form=(StudentMasterForm)en.nextElement();
report+="<tr><td><b><font color='black'><u>"+form.getStudentfirstname()+"</td><td><b><font color='black'>"+form.getStudentmiddlename();
report+="</td><td><b><font color='black'>"+form.getStudentlastname()+"</td><td><b><font color='black'>"+form.getDob()+"</td><td><b><font color='black'>"+form.getDor()+"</td><td><b><font color='black'>"+form.getAddress();
 report+="</td><td><b><font color='black'>"+form.getEmail()+" </td><td><b><font color='black'>"+form.getPhone()+"</td>";
report+="<td><img src='images/"+form.getImage()+"' height=20 width=40></td></tr>";

%>
<tr>
<td><b><font color="#ffff00"><u><%=form.getStudentfirstname() %></td>
<td><b><font color="#ffff00"><%=form.getStudentmiddlename() %></td>
<td><b><font color="#ffff00"><%=form.getStudentlastname() %></td>
<td><b><font color="#ffff00"><%=form.getDob() %></td>
<td><b><font color="#ffff00"><%=form.getDor() %></td>
<td><b><font color="#ffff00"><%=form.getAddress() %></td>
<td><b><font color="#ffff00"><%=form.getEmail() %></td>
<td><b><font color="#ffff00"><%=form.getPhone() %></td>
<td><img src="images/<%=form.getImage() %>" height=50 width=100></td></tr>
<%}
report+="</table>";
session.setAttribute("Report",report);
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
 
	

