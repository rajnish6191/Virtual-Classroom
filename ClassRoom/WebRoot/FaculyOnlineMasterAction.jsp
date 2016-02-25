
<%@page import="com.yourcompany.struts.form.FacultyOnlineMasterForm"%>
<%@page import="com.dts.project.dao.FacultyOnlineMasterDao"%> <%
String target="FacultyOnlineMaster.jsp?status=Registration Failed";
try
{
 FacultyOnlineMasterForm form=new FacultyOnlineMasterForm();
 form.setOnlineDateTime(request.getParameter("onlineDateTime"));
 form.setFacultyId(Integer.parseInt(request.getParameter("facultyId")));
 FacultyOnlineMasterDao dao=new FacultyOnlineMasterDao();
 boolean flag=dao.insertFacultyOnlineMaster(form);
 if(flag)
 {
 target="FacultyOnlineMaster.jsp?status=Registration Success";
 }
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);
 %>