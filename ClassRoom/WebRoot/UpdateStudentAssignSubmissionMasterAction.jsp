 
<%@page import="com.yourcompany.struts.form.StudentAssignSubmissionMasterForm"%>
<%@page import="com.dts.project.dao.StudentAssignSubmissionMasterDao"%> <%
 String target="FacultyHome.jsp?status=Student Assignment Updation Failed";
 try
 {
 StudentAssignSubmissionMasterForm form=new StudentAssignSubmissionMasterForm();
 form.setAssignmentId(Integer.parseInt(request.getParameter("assignmentId")));
 form.setSubmissionFile(request.getParameter("submissionFile"));
 form.setStudentId(Integer.parseInt(request.getParameter("studentId")));
 form.setLecturerId(Integer.parseInt(request.getParameter("lecturerId")));
 form.setSubmissionDate(request.getParameter("submissionDate"));
 StudentAssignSubmissionMasterDao dao=new StudentAssignSubmissionMasterDao();
 boolean flag=dao.UpdateStudentAssignSubmissionMaster(form);
 if(flag)
 {
 target="FacultyHome.jsp?status=Students Assignment Updated Successfully";
 }
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);
 %>