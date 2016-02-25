 
<%@page import="com.dts.project.dao.StudentOnlineDao"%>
<%
String target="ViewStudentOnline.jsp?status=Deletion failed";
try
{
String id[]=request.getParameterValues("TypeId");
for(int i=0;i<id.length;i++)
{
int Id=Integer.parseInt(id[i]);
StudentOnlineDao dao=new StudentOnlineDao();
boolean flag=dao.deleteStudentOnline(Id);
if(flag)
{
target="ViewStudentOnline.jsp?status=Deletion Success";
}
}
}
catch(Exception e)
{
e.printStackTrace();
}
RequestDispatcher rd=request.getRequestDispatcher(target);
rd.forward(request,response);
%>

 