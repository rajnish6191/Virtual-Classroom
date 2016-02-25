
<%@page import="com.dts.project.dao.EmailMasterDao"%>
<%@page import="com.dts.project.dao.EmailDetailsDao"%> <%
 String target="ViewEmailDetails.jsp?status=Deletion failed";
 try
 {
 String id[]=request.getParameterValues("TypeId");
 for(int i=0;i<id.length;i++)
 {
 int Id=Integer.parseInt(id[i]);
 EmailDetailsDao dao=new EmailDetailsDao();
 boolean flag=dao.deleteEmailDetails(Id);
 if(flag)
 {
 target="ViewEmailDetails.jsp?status=Deletion Success";
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