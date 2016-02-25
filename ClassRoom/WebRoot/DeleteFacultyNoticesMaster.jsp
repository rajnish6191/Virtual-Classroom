
<%@page import="com.dts.project.dao.FacultyNoticesMasterDao"%> 
 <%
 
 String target="FacultyHome.jsp?status=Notice Deletion Failed";
 try
 {
 String id[]=request.getParameterValues("TypeId");
 for(int i=0;i<id.length;i++)
 {
 int Id=Integer.parseInt(id[i]);
 FacultyNoticesMasterDao dao=new FacultyNoticesMasterDao();
 boolean flag=dao.deleteFacultyNoticesMaster(Id);
 if(flag)
 {
 target="FacultyHome.jsp?status=Notice Deletion Successfully";
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