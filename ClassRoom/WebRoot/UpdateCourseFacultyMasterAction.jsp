
<%@page import="com.yourcompany.struts.form.CourseFacultyMasterForm"%>
<%@page import="com.dts.project.dao.CoursefacultyMasterDao"%> <%
String target="ViewCourseFacultyMaster.jsp?status=Updation Failed";
 try
 {
  CourseFacultyMasterForm form=new CourseFacultyMasterForm();
 form.setCourseId(Integer.parseInt(request.getParameter("courseId")));
 form.setFacultyId(Integer.parseInt(request.getParameter("facultyId")));
 form.setDescByFaculty(request.getParameter("descByFaculty"));
 CoursefacultyMasterDao dao=new CoursefacultyMasterDao();
 boolean flag=dao.UpdateCourseFacultyMaster(form);
 if(flag)
 {
 target="ViewCourseFacultyMaster.jsp?status=Updation sucess";
 }
 }catch(Exception e)
 {
 e.printStackTrace();
 }
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);
 %>