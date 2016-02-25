
<%@page import="com.dts.project.dao.FacultyOnlineMasterDao"%>
<%
String target="ViewFacultyOnlineMaster.jsp?status=Deletion failed";
try
{
String id[]=request.getParameterValues("TypeId");
for(int i=0;i<id.length;i++)
{
int Id=Integer.parseInt(id[i]);
FacultyOnlineMasterDao dao=new FacultyOnlineMasterDao();
boolean flag=dao.deleteFacultyOnlineMaster(Id);
if(flag)
{
target="ViewFacultyOnlineMaster.jsp?status=Deletion Success";
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

