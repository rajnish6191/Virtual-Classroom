
<%@page import="com.yourcompany.struts.form.StudentCourseMasterForm"%>
<%@page import="com.dts.project.dao.StudentCourseMasterDao"%> <%
 String target="StudentCourseMaster.jsp?status=Registration Failed";
 try
 {
 StudentCourseMasterForm form=new StudentCourseMasterForm();
 form.setStudentId(Integer.parseInt(request.getParameter("studentId")));
 form.setCourseId(Integer.parseInt(request.getParameter("courseId")));
 form.setFacultyId(Integer.parseInt(request.getParameter("facultyId")));
 form.setRegDate(request.getParameter("regDate"));
 form.setCourseEndDate(request.getParameter("courseEndDate"));
 StudentCourseMasterDao dao=new StudentCourseMasterDao();
 boolean flag=dao.insertStudentCourseMaster(form);
 if(flag)
 {
 target="StudentCourseMaster.jsp?status=Registration Success";
 }
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);
 %>