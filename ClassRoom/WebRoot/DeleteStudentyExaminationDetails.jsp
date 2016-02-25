
<%@page import="com.dts.project.dao.StudentExaminationDetailsDao"%>
<%
String target="ViewStudentExaminationDetails.jsp?status=Deletion failed";
try
{
String id[]=request.getParameterValues("TypeId");

for(int i=0;i<id.length;i++)
{
int Id=Integer.parseInt(id[i]);
StudentExaminationDetailsDao dao=new StudentExaminationDetailsDao();
boolean flag=dao.deleteStudentExaminationDetails(Id);
if(flag)
{
target="ViewStudentExaminationDetails.jsp?status=Deletion Success";
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
