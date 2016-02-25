 
<%@page import="com.yourcompany.struts.form.StudentExaminationMasterForm"%>
<%@page import="com.dts.project.dao.StudentExaminationMasterDao"%> <%
 String target="ViewStudentExaminationMaster.jsp?status=Updation Failed";
 try
 {
 StudentExaminationMasterForm form=new StudentExaminationMasterForm();
 form.setStudentExamId(Integer.parseInt(request.getParameter("studentExamId")));
 form.setExamAttendedDateTime(request.getParameter("examAttendedDateTime"));
 form.setExaminationId(Integer.parseInt(request.getParameter("examinationId")));
 form.setExamResult(request.getParameter("examResult"));
 form.setExamAggregade(Integer.parseInt(request.getParameter("examAggregade")));
 form.setStudentId(Integer.parseInt(request.getParameter("studentId")));
 StudentExaminationMasterDao dao=new StudentExaminationMasterDao();
 boolean flag=dao.UpdateStudentExaminationMaster(form);
 if(flag)
 {
 target="ViewStudentExaminationMaster.jsp?status=Updation success";
 }
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);
 %>