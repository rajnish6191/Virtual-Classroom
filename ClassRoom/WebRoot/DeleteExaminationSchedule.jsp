
<%@page import="com.dts.project.dao.ExaminationScheduleDao"%> <%
 String target="ViewExaminationSchedule.jsp?status=Deletion Failed";
 try
 {
 String id[]=request.getParameterValues("TypeId");
 for(int i=0;i<id.length;i++)
 {
 int Id=Integer.parseInt(id[i]);
 ExaminationScheduleDao dao=new ExaminationScheduleDao();
 boolean flag=dao.deleteExaminationSchedule(Id);
 if(flag)
 {
 target="ViewExaminationSchedule.jsp?status=Deletion Success";
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