 
<%@page import="com.yourcompany.struts.form.StudentCourseMasterForm"%>
<%@page import="com.dts.project.dao.StudentCourseMasterDao"%> <%
 String target="ViewStudentCourseMaster.jsp?status=Updation Failed";
 try
 {
 StudentCourseMasterForm form=new StudentCourseMasterForm();
 form.setCourseRegId(Integer.parseInt(request.getParameter("courseRegId")));
 form.setStudentId(Integer.parseInt(request.getParameter("studentId")));
 form.setCourseId(Integer.parseInt(request.getParameter("courseId")));
 form.setFacultyId(Integer.parseInt(request.getParameter("facultyId")));
 form.setRegDate(request.getParameter("regDate"));
 form.setCourseEndDate(request.getParameter("courseEndDate"));
 StudentCourseMasterDao dao=new StudentCourseMasterDao();
 boolean flag=dao.UpdateStudentCourseMaster(form);
 if(flag)
 {
 target="ViewStudentCourseMaster.jsp?status=Updation Success";
 }
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);
 %>