
<%@page import="com.yourcompany.struts.form.StudentOnlineForm"%>
<%@page import="com.dts.project.dao.StudentOnlineDao"%> <%
String target="ViewStudentOnline.jsp?status=Updation Failed";
try
{
 StudentOnlineForm form=new StudentOnlineForm();
 form.setOnlineId(Integer.parseInt(request.getParameter("onlineId")));
 form.setOnlineDateAndTime(request.getParameter("onlineDateTime"));
 form.setStudentId(Integer.parseInt(request.getParameter("StudentId")));
 StudentOnlineDao dao=new StudentOnlineDao();
 boolean flag=dao.UpdateStudentOnline(form);
 if(flag)
 {
 target="ViewStudentOnline.jsp?status=Updation Success";
 }
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);
 %>