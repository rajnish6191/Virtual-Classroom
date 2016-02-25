
<%@page import="com.yourcompany.struts.form.EmailMasterForm"%>
<%@page import="com.dts.project.dao.EmailMasterDao"%><%
String target="ViewEmailMaster.jsp?status=Updation Failed";
try
{
EmailMasterForm form=new EmailMasterForm();
form.setEmailId(Integer.parseInt(request.getParameter("emailId")));
form.setEmailText(request.getParameter("emailText"));
form.setDateAndTime(request.getParameter("dateAndTime"));
EmailMasterDao dao=new EmailMasterDao();
boolean flag=dao.UpdateEmailMaster(form);
if(flag)
{
target="ViewEmailMaster.jsp?status=Updation success";
}
}catch(Exception e)
{
e.printStackTrace();
}
RequestDispatcher rd=request.getRequestDispatcher(target);
rd.forward(request,response);
%>
