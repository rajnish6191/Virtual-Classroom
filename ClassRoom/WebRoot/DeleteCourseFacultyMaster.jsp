
<%@page import="com.dts.project.dao.CoursefacultyMasterDao"%> <%
 String target="ViewCourseFacultyMaster.jsp?status=Deletion Failed";
 try
 {
 String id[]=request.getParameterValues("TypeId");
 for(int i=0;i<id.length;i++)
 {
 int Id=Integer.parseInt(id[i]);
 CoursefacultyMasterDao dao=new CoursefacultyMasterDao();
 boolean flag=dao.deleteCourseFacultyMaster(Id);
 if(flag)
 {
 target="ViewCourseFacultyMaster.jsp?status=Deletion Success";
 }
 }
 }catch(Exception e)
 {
 e.printStackTrace();
 }
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);
 %>