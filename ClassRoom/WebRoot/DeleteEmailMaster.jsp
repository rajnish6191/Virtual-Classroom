
<%@page import="com.dts.project.dao.EmailMasterDao"%> <%
 String target="adminhome.jsp?status=Deletion failed";
 try
 {
 String id[]=request.getParameterValues("TypeId");
 for(int i=0;i<id.length;i++)
 {
 int Id=Integer.parseInt(id[i]);
 EmailMasterDao dao=new EmailMasterDao();
 boolean flag=dao.deleteEmailMaster(Id);
 if(flag)
 {
 target="adminhome.jsp?status=Deletion Success";
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