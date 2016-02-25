
<%@page import="com.dts.project.dao.StudentExaminationMasterDao"%> 
 <%
 String target="ViewStudentExaminationMaster.jsp?status=Deletion failed";
 try
 {
 String id[]=request.getParameterValues("TypeId");
 for(int i=0;i<id.length;i++)
 {
 int Id=Integer.parseInt(id[i]);
 StudentExaminationMasterDao dao=new StudentExaminationMasterDao();
boolean flag=dao.deleteStudentExaminationMaster(Id);
if(flag)
{
target="ViewStudentExaminationMaster.jsp?status=Deletion Sucess";
}
}
}catch(Exception e)
{
e.printStackTrace();
}
RequestDispatcher rd=request.getRequestDispatcher(target);
rd.forward(request,response);
%>