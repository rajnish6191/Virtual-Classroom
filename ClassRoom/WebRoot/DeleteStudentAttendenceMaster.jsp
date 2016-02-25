
<%@page import="com.dts.project.dao.StudentAttendenceMasterDao"%> <%
 String target="ViewStudentAttendenceMaster.jsp?status=Deletion Failed";
 try
 {
 String id[]=request.getParameterValues("TypeId");
 for(int i=0;i<id.length;i++)
 {
 int Id=Integer.parseInt(id[i]);
 StudentAttendenceMasterDao dao=new StudentAttendenceMasterDao();
 boolean flag=dao.deleteStudentAttendenceMaster(Id);
 if(flag)
 {
 target="ViewStudentAttendenceMaster.jsp?status=Deletion Success";
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