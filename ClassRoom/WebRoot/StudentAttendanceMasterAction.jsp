
<%@page import="com.yourcompany.struts.form.StudentAttendanceMasterForm"%>
<%@page import="com.dts.project.dao.StudentAttendenceMasterDao"%> <%
 String target="StudentAttandenceMaster.jsp?status=Registration Failed";
 try
 {
 StudentAttendanceMasterForm form=new StudentAttendanceMasterForm();
 form.setAttendanceDateTime(request.getParameter("attendenceDateTime"));
 form.setDisconnectedDateTime(request.getParameter("disconnectedDateTime"));
 form.setStudentId(Integer.parseInt(request.getParameter("studentId")));
 form.setCourseId(Integer.parseInt(request.getParameter("courseId")));
 form.setLecturerId(Integer.parseInt(request.getParameter("lecturerId")));
 StudentAttendenceMasterDao dao=new StudentAttendenceMasterDao();
 boolean flag=dao.insertStudentAttendenceMaster(form);
 if(flag)
 {
 target="StudentAttendanceMaster.jsp?status=Registration success";
 }
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);
 %>