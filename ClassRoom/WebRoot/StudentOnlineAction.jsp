
<%@page import="com.yourcompany.struts.form.StudentOnlineForm"%>
<%@page import="com.dts.project.dao.StudentOnlineDao"%> <%
String target="StudentOnline.jsp?status=Registration failed";
try
{
 StudentOnlineForm form=new StudentOnlineForm();
 form.setStudentId(Integer.parseInt(request.getParameter("studentId")));
 form.setOnlineDateAndTime(request.getParameter("onlineDateTime"));
 
 StudentOnlineDao dao=new StudentOnlineDao();
 boolean flag=dao.insertStudentOnline(form);
 if(flag)
 {
 target="StudentOnline.jsp?status=Registration success";
 }
 }
 catch(Exception e)
 
 {
 e.printStackTrace();
 }
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);
 %>