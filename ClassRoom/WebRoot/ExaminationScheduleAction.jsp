
<%@page import="com.yourcompany.struts.form.ExaminationScheduleForm"%>
<%@page import="com.dts.project.dao.ExaminationScheduleDao"%> 
 <%
 String target="ExaminationSchedule.jsp?status=Registration Failed";
 try
 {
 ExaminationScheduleForm form=new ExaminationScheduleForm();
 form.setExaminationDate(request.getParameter("examinationDate"));
 form.setExaminationEndDate(request.getParameter("examinationEndDate"));
 form.setCourseId(Integer.parseInt(request.getParameter("courseId")));
 form.setLecturerId(Integer.parseInt(request.getParameter("lecturerId")));
 form.setFacultyId(Integer.parseInt(request.getParameter("facultyId")));
 form.setPassPercentageDecided(Integer.parseInt(request.getParameter("passPercentageDecided")));
 ExaminationScheduleDao dao=new ExaminationScheduleDao();
// boolean flag=dao.insertExaminationSchedule(form);
 //if(flag)
 {
 target="ExaminationSchedule.jsp?status=Registration Success";
 }
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);
 %>