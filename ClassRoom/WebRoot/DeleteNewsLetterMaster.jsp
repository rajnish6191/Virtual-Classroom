
<%@page import="com.dts.project.dao.NewsLetterMasterDao"%> <%
 String target="FacultyHome.jsp?status=News Letter Deletion Failed";
 try
 {
 String id[]=request.getParameterValues("TypeId");
 for(int i=0;i<id.length;i++)
 {
 int Id=Integer.parseInt(id[i]);
 NewsLetterMasterDao dao=new NewsLetterMasterDao();
 boolean flag=dao.deleteNewsLetterMaster(Id);
 if(flag)
 {
 target="FacultyHome.jsp?status=News Letter Deleteted Successfully";
 }
 }
 }catch(Exception e)
 {
 e.printStackTrace();
 }
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);
 %>