
<%@page import="com.yourcompany.struts.form.ExamQuestionMasterForm"%>
<%@page import="com.dts.project.dao.ExamQuestionsMasterDao"%>
<%
String target="QuestionPaper.jsp?status= Question Registeration Failed";
int examid=Integer.parseInt(request.getParameter("examid"));
//int questionid=Integer.parseInt(request.getParameter("questionid"));
String queestiontext=request.getParameter("questiontext");
//int nofoquestions=Integer.parseInt(request.getParameter("noofquestions"));
String answer1=request.getParameter("answer1");
String answer2=request.getParameter("answer2");
String answer3=request.getParameter("answer3");
String answer4=request.getParameter("answer4");
String answer5=request.getParameter("answer5");
String correctanswer=request.getParameter("correctanswer");
String marks=request.getParameter("marks");
ExamQuestionMasterForm aform=new ExamQuestionMasterForm();
aform.setExaminationId(examid);
//aform.setQuestionId(questionid);
aform.setQuestionText(queestiontext);
aform.setAnswer1(answer1);
aform.setAnswer2(answer2);
aform.setAnswer3(answer3);
aform.setAnswer4(answer4);
aform.setAnswer5(answer5);
aform.setCorrectAnswer(correctanswer);
aform.setMarks(Integer.parseInt(marks));
ExamQuestionsMasterDao adao=new ExamQuestionsMasterDao();
boolean flag=adao.insertExamQuestionsMaster(aform);
int id=1;
if(flag)
{
target="QuestionPaper.jsp?status= Enter a Next Question&examid="+examid;
}
RequestDispatcher rd=request.getRequestDispatcher(target);
rd.forward(request,response);



%>