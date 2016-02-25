
<%@page import="com.dts.project.dao.CourseMasterDao"%>
 
<%
String target="adminhome.jsp?status=Course Deletion Failed";
try
{
String id[]=request.getParameterValues("TypeId");
for(int i=0;i<id.length;i++)
{
int Id=Integer.parseInt(id[i]);
CourseMasterDao dao=new CourseMasterDao();
boolean flag=dao.deleteCourseMaster(Id);
if(flag)
{
target="adminhome.jsp?status=Course Deleted Successfully";
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