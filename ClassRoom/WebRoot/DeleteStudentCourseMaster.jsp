
<%@page import="com.dts.project.dao.StudentCourseMasterDao"%>
<%
String target="ViewStudentCourseMaster.jsp?status=Deletion failed";
try
{
String id[]=request.getParameterValues("TypeId");
for(int i=0;i<id.length;i++)
{
int Id=Integer.parseInt(id[i]);
StudentCourseMasterDao dao=new StudentCourseMasterDao();
boolean flag=dao.deleteStudentCourseMaster(Id);
if(flag)
{
target="ViewStudentCourseMaster.jsp?status=Deletion Success";
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