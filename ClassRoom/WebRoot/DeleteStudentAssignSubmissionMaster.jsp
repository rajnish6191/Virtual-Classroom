
<%@page import="com.dts.project.dao.StudentAssignSubmissionMasterDao"%> <%
 String target="ViewStudentAssignSubmissionMaster.jsp?status=Deletion Failed";
 try
 {
  
 String id[]=request.getParameterValues("TypeId");
 for(int i=0;i<id.length;i++)
 {
 int Id=Integer.parseInt(id[i]);
 StudentAssignSubmissionMasterDao dao=new StudentAssignSubmissionMasterDao();
 boolean flag=dao.deleteStudentAssignSubmissionMaster(Id);
 if(flag)
 {
 target="ViewStudentAssignSubmissionMaster.jsp?status=Deletion Success";
 }
 }
 }catch(Exception e)
 {
 e.printStackTrace();
 }
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);
 %>