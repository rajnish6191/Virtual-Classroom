
<%@page import="com.yourcompany.struts.form.CourseLecturerMasterForm"%>
<%@page import="com.dts.project.dao.CourseLecturerMasterDao"%> <%
String target="CourseLecturerMaster.jsp?status=Registration Failed";
try
{
CourseLecturerMasterForm form=new CourseLecturerMasterForm();
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
boolean flag=dao.insertCourseLecturerMaster(form);
if(flag)
{
target="CourseLecturerMaster.jsp?status=Registration Success";
}
}
catch(Exception e)
{
e.printStackTrace();
}
RequestDispatcher rd=request.getRequestDispatcher(target);
rd.forward(request,response);
%>
