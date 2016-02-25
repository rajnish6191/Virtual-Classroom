
<%@page import="com.yourcompany.struts.form.ExaminationScheduleForm"%>
<%@page import="com.dts.project.dao.ExaminationScheduleDao"%>
<%
String target="CreateExamPaper.jsp?status=Exam Schdule Registeration Fail";

try{
 target="CreateExamPaper.jsp?status=Exam Schdule Registeration Fail";
int courseid=Integer.parseInt(request.getParameter("courseid"));
int facultyid=Integer.parseInt(request.getParameter("facultyid"));
int lectureid=Integer.parseInt(request.getParameter("letctureid"));
String examname=request.getParameter("examname");
int passpercentage=Integer.parseInt(request.getParameter("passpercentage"));
String startdate=request.getParameter("estartdate");
int noofquestions=Integer.parseInt(request.getParameter("noofquestions"));
ExaminationScheduleForm aform=new ExaminationScheduleForm();
aform.setCourseId(courseid);
aform.setFacultyId(facultyid);
aform.setLecturerId(lectureid);
aform.setExamname(examname);
aform.setPassPercentageDecided(passpercentage);
aform.setExaminationDate(startdate);
aform.setNoofquestions(noofquestions);
ExaminationScheduleDao adao=new ExaminationScheduleDao();
int examid=adao.insertExaminationSchedule(aform);
if(examid!=0)

{
target="QuestionPaper.jsp?examid="+examid+"&noofquestions="+noofquestions;
} 
}catch(Exception e)
{
}

RequestDispatcher rd=request.getRequestDispatcher(target);
rd.forward(request,response);
%>