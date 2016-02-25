
<%@page import="com.yourcompany.struts.form.CourseFacultyMasterForm"%>
<%@page import="com.dts.project.dao.CoursefacultyMasterDao"%><%
String target="FacultyCourseRegisterForm.jsp?status=Course Registeration Failed";
CourseFacultyMasterForm aform=new CourseFacultyMasterForm();
aform.setCourseId(Integer.parseInt(request.getParameter("courseId")));
 aform.setDescByFaculty(request.getParameter("facultydesc"));
 aform.setFacultyId(Integer.parseInt(request.getParameter("facultyid")));
CoursefacultyMasterDao adao=new CoursefacultyMasterDao();
boolean flag=adao.insertCourseFacultyMaster(aform);
if(flag)
{
target="FacultyCourseRegisterForm.jsp?status=Course Registeration Successfull";
}
RequestDispatcher rd=request.getRequestDispatcher(target);
rd.forward(request,response);%>