
<%@page import="com.dts.project.dao.ExamQuestionsMasterDao"%> <%
 String target="ViewExamQuestionMaster.jsp?status=Deletion Failed";
 try
 {
 String id[]=request.getParameterValues("TypeId");
 for(int i=0;i<id.length;i++)
 {
 int Id=Integer.parseInt(id[i]);
 ExamQuestionsMasterDao dao=new ExamQuestionsMasterDao();
 boolean flag=dao.deleteExamQuestionMaster(Id);
 if(flag)
 {
 target="ViewExamQuestionMaster.jsp?status=Deletion Success";
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