 
<%@page import="com.yourcompany.struts.form.CourseLecturerMasterForm"%>
<%@page import="com.dts.project.dao.CourseLecturerMasterDao"%> <%
String target="ViewCourseLecturerMaster.jsp?status=Updation Failed";
try
{
CourseLecturerMasterForm form=new CourseLecturerMasterForm();
form.setLecturerId(Integer.parseInt(request.getParameter("lecturerId")));
form.setLecturerDate(request.getParameter("lecturerDate"));
form.setCourseId(Integer.parseInt(request.getParameter("courseId")));
form.setFacultyId(Integer.parseInt(request.getParameter("facultyId")));
form.setLecturerAudio(request.getParameter("lecturerAudio"));
form.setLecturerVideo(request.getParameter("lecturerVideo"));
form.setLecturerPowerPoint(request.getParameter("lecturerPowerPoint"));
form.setLectureDocumentfile(request.getParameter("lectureDocumentfile"));
form.setLectureassignmentFile(request.getParameter("lectureassignmentFile"));
form.setLectureDurationTime(Integer.parseInt(request.getParameter("lectureDurationTime")));
CourseLecturerMasterDao dao=new CourseLecturerMasterDao();
boolean flag=dao.UpdateCourseLecturerMaster(form);
if(flag)
{
target="ViewCourseLecturerMaster.jsp?status=Updation Success";
}
}
catch(Exception e)
{
e.printStackTrace();
}
RequestDispatcher rd=request.getRequestDispatcher(target);
rd.forward(request,response);
%>
 