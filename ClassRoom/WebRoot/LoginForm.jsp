<html><head>


<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">

<title>VirtualClassRoom</title>
<script type="text/javascript">
function validate()
{
var form =document.register
if(form.username.value=="")
{
alert("User Name is Required");
return false;
}
else if(form.password.value=="")
{
alert("Pass Word is Required");
return false;
}  
return true;
}
</script>



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

<br><font size="4" color="#950000"><b> &nbsp; &nbsp;<% if(request.getParameter("status")!=null){%>
	<%=request.getParameter("status") %><%} %>
<div align="right">
  <p>&nbsp;</p>
  
  &nbsp;&nbsp;&nbsp;<table width="357" height="260" border="0" style="width: 357px; height: 265px;">
    
  
   
      <form action="./LoginAction" method="post" name="register" onsubmit="return validate()">
         <table width="200" border="0" align="center">
          <tr>
             <td>
<center><h2><font color="white">Login Form</font></h2></center>             <table  border="0" align="center">
               <tr>
                 <td height="120" align="right"></td>
                 <td><table border="0" align="center">
                   <tr>
                     <td ><font color="white"><b>UserName</b></font></td>
                      <td ><input type="text" name="username">                      </td>
                      </tr>
                   <tr>
                     <td><font color="white"><b>Password</b></td>
                      <td>
                        <input type="password" name="password">                      </td>
                      </tr>
                   <tr>
                     <td colspan="2">
                       <div align="center">
                         <input type="submit" name="Submit" value="Sign In">
                          &nbsp;
                          <input name="Input2" type="reset" value="Clear">
                         </div>                        </td>
                      </tr>
                 </table></td>
                 <td>&nbsp;</td>
               </tr>
               <tr>
                 <td >&nbsp;</td>
                 <td valign="baseline">
                 <div align="center"><a href="Recoverpassword.jsp"><font color="white">Forgot Password ! !......</a></div></td>
                 <td>&nbsp;</td>
               </tr>
               <tr>
                 <td >&nbsp;</td>
                 <td valign="baseline">
                 <div align="center"><a href="Registerform.jsp"><font color="white">New User....?</a></div></td>
                 <td>&nbsp;</td>
               </tr>
               
             </table></td>
           </tr>
           </table>
                    </form> 
      
      
      
      
      
   
    
  </table>
  <p>&nbsp;</p>
</div>









</td>   
     
    
 
</body></html>