
<%@page import="com.yourcompany.struts.form.ExamQuestionMasterForm"%>
<%@page import="com.dts.project.dao.ExamQuestionsMasterDao"%> <%
 String target="ExamQuestionMaster.jsp?status=Registration Failed";
 try
 {
 ExamQuestionMasterForm form=new ExamQuestionMasterForm();
 form.setQuestionText(request.getParameter("questionText"));
 form.setAnswer1(request.getParameter("answer1"));
 form.setAnswer2(request.getParameter("answer2"));
 form.setAnswer3(request.getParameter("answer3"));
 form.setAnswer4(request.getParameter("answer4"));
 form.setAnswer5(request.getParameter("answer5"));
 form.setCorrectAnswer(request.getParameter("correctAnswer"));
 form.setExaminationId(Integer.parseInt(request.getParameter("examinationId")));
 form.setMarks(Integer.parseInt(request.getParameter("marks")));
 ExamQuestionsMasterDao dao=new ExamQuestionsMasterDao();
 boolean flag=dao.insertExamQuestionsMaster(form);
 if(flag)
 {
 target="ExamQuestionMaster.jsp?status=Registration Success";
 }
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
 
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);
 %>