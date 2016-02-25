
<%@page import="com.yourcompany.struts.form.EmailMasterForm"%>
<%@page import="com.dts.project.dao.EmailMasterDao"%><%
String target="EmailMaster.jsp?status=Registration Failed";
try
{
EmailMasterForm form=new EmailMasterForm();
form.setEmailText(request.getParameter("emailText"));
form.setDateAndTime(request.getParameter("dateAndTime"));
EmailMasterDao dao=new EmailMasterDao();
boolean flag=dao.insertEmailMaster(form);
if(flag)
{
target="EmailMaster.jsp?status=Registration success";
}
}catch(Exception e)
{
e.printStackTrace();
}
RequestDispatcher rd=request.getRequestDispatcher(target);
rd.forward(request,response);
%>
