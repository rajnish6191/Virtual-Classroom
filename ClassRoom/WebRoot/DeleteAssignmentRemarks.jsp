
<%@page import="com.dts.project.dao.AssignmentRemarksDao"%> <%
 String target="ViewAssignmentRemarks.jsp?status=Deletion Failed";
 try
 {
 String id[]=request.getParameterValues("TypeId");
 for(int i=0;i<id.length;i++)
 {
 int Id=Integer.parseInt(id[i]);
 AssignmentRemarksDao dao=new AssignmentRemarksDao();
 boolean flag=dao.deleteAssignmentRemarks(Id);
 if(flag)
 {
 target="ViewAssignmentRemarks.jsp?status=Deletion Success";
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