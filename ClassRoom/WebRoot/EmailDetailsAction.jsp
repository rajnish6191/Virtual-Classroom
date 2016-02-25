
<%@page import="com.yourcompany.struts.form.EmailDetailsForm"%>
<%@page import="com.dts.project.dao.EmailDetailsDao"%><%
String target="EmailDetails.jsp?status=Registratiopn Failed";
try
{
EmailDetailsForm form=new EmailDetailsForm();
form.setEmailId(Integer.parseInt(request.getParameter("emailId")));
form.setFromFacultyId(Integer.parseInt(request.getParameter("fromFacultyId")));
form.setToStudentId(Integer.parseInt(request.getParameter("toStudentId")));
form.setFromstudentId(Integer.parseInt(request.getParameter("fromStudentId")));
form.setToFacultyId(Integer.parseInt(request.getParameter("toFacultyId")));
EmailDetailsDao dao=new EmailDetailsDao();
boolean flag=dao.insertEmailDetails(form);
if(flag)
{
target="EmailDetails.jsp?status=Registratiopn success";
}
}
catch(Exception e)
{
e.printStackTrace();
}
RequestDispatcher rd=request.getRequestDispatcher(target);
rd.forward(request,response);
%>
