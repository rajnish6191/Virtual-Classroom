
<%@page import="com.yourcompany.struts.form.StudentAssignSubmissionMasterForm"%>
<%@page import="com.dts.project.dao.StudentAssignSubmissionMasterDao"%> <%
 String target="StudentAssignSubmissionMaster.jsp?status=Registration Failed";
 try
 {
 StudentAssignSubmissionMasterForm form=new StudentAssignSubmissionMasterForm();
 form.setSubmissionFile(request.getParameter("submissionFile"));
 form.setStudentId(Integer.parseInt(request.getParameter("studentId")));
 form.setLecturerId(Integer.parseInt(request.getParameter("lecturerId")));
 form.setSubmissionDate(request.getParameter("submissionDate"));
 StudentAssignSubmissionMasterDao dao=new StudentAssignSubmissionMasterDao();
 boolean flag=dao.insertStudentAssignSubmissionMaster(form);
 if(flag)
 {
 target="StudentAssignSubmissionMaster.jsp?status=Registration Success";
 }
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);
 %>