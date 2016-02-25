
<%@page import="com.yourcompany.struts.form.FacultyOnlineMasterForm"%>
<%@page import="com.dts.project.dao.FacultyOnlineMasterDao"%> <%
String target="ViewFacultyOnlineMaster.jsp?status=Updation Failed";
try
{
 FacultyOnlineMasterForm form=new FacultyOnlineMasterForm();
 form.setOnlineId(Integer.parseInt(request.getParameter("onlineId")));
 form.setOnlineDateTime(request.getParameter("onlineDateTime"));
 form.setFacultyId(Integer.parseInt(request.getParameter("facultyId")));
 FacultyOnlineMasterDao dao=new FacultyOnlineMasterDao();
 boolean flag=dao.UpdateFacultyOnlineMaster(form);
 if(flag)
 {
 target="ViewFacultyOnlineMaster.jsp?status=Updation Success";
 }
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);
 %>