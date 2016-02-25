 
<%@page import="com.yourcompany.struts.form.StudentAttendanceMasterForm"%>
<%@page import="com.dts.project.dao.StudentAttendenceMasterDao"%> <%
 String target="FacultyHome.jsp?status=Attendence Updation Failed";
 try
 {
 StudentAttendanceMasterForm form=new StudentAttendanceMasterForm();
 form.setAttendanceId(Integer.parseInt(request.getParameter("attendenceId")));
 form.setAttendanceDateTime(request.getParameter("attendenceDateTime"));
 form.setDisconnectedDateTime(request.getParameter("disconnectedDateTime"));
 form.setStudentId(Integer.parseInt(request.getParameter("studentId")));
 form.setCourseId(Integer.parseInt(request.getParameter("courseId")));
 form.setLecturerId(Integer.parseInt(request.getParameter("lecturerId")));
 StudentAttendenceMasterDao dao=new StudentAttendenceMasterDao();
 boolean flag=dao.UpdateStudentAttendenceMaster(form);
 if(flag)
 {
 target="FacultyHome.jsp?status= Attendence Updated successfully";
 }
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);
 %>