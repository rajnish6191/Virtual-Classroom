
<%@page import="com.yourcompany.struts.form.StudentExaminationMasterForm"%>
<%@page import="com.dts.project.dao.StudentExaminationMasterDao"%> <%
 String target="StudentExaminationMaster.jsp?status=Registration Failed";
 try
 {
 StudentExaminationMasterForm form=new StudentExaminationMasterForm();
 form.setExamAttendedDateTime(request.getParameter("examAttendedDateTime"));
 form.setExaminationId(Integer.parseInt(request.getParameter("examinationId")));
 form.setExamResult(request.getParameter("examResult"));
 form.setExamAggregade(Integer.parseInt(request.getParameter("examAggregade")));
 form.setStudentId(Integer.parseInt(request.getParameter("studentId")));
 StudentExaminationMasterDao dao=new StudentExaminationMasterDao();
 boolean flag=dao.insertStudentExaminationMaster(form);
 if(flag)
 {
 target="StudentExaminationMaster.jsp?status=Registration success";
 }
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);
 %>