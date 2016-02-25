
<%@page import="com.dts.project.dao.FacultyMasterDao"%> <%
 String target="adminhome.jsp?status=Faculty Deletion Failed";
 try
 {
 String id[]=request.getParameterValues("TypeId");
 for(int i=0;i<id.length;i++)
 {
 int Id=Integer.parseInt(id[i]);
 FacultyMasterDao dao=new  FacultyMasterDao();
 boolean flag=dao.deleteFacultyMaster(Id);
 if(flag)
 {
 target="adminhome.jsp?status=Faculty Deleted Successfully";
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