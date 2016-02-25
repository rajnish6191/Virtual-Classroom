<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.yourcompany.struts.form.ExamQuestionMasterForm"%>
<%@page import="com.yourcompany.struts.form.StudentExaminationDetailsForm"%>
<%@page import="com.dts.project.dao.ExamQuestionsMasterDao"%>
<%@page import="com.dts.project.dao.StudentExaminationDetailsDao"%>
<%@page import="com.dts.project.dao.StudentExaminationMasterDao"%>
<%@page import="com.yourcompany.struts.form.StudentExaminationMasterForm"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>&nbsp; 
<% 
//int questionid=Integer.parseInt(request.getParameter("q1")); 
int examid=Integer.parseInt(request.getParameter("examid"));

float noofquestions=Float.parseFloat(request.getParameter("noofquestions"));
int studentexmid=Integer.parseInt(request.getParameter("studentexmid"));
StudentExaminationDetailsForm aform=new StudentExaminationDetailsForm();

String correct="No";
String answer2[]=request.getParameterValues("q1"); 
String questionid1[]=request.getParameterValues("questionid");
for(int i=0;i<answer2.length;i++)
{
String answer=request.getParameter(answer2[i]);

System.out.println("this is answer"+answer);
int questionid=Integer.parseInt(questionid1[i]);
System.out.println("this is Question no"+questionid1[i]);
System.out.println("examid"+examid);
//String answer=answer2[i];
String answer1=new ExamQuestionsMasterDao().getAnswer(examid,questionid);
if(answer.equalsIgnoreCase(answer1))
{
correct="yes";
}
aform.setStudentExamId(studentexmid);
aform.setQuestionId(questionid);
aform.setAnswer(answer);
aform.setCorrect_wrong(correct);
StudentExaminationDetailsDao adao=new StudentExaminationDetailsDao();
boolean flag=adao.insertStudentExaminationDetails(aform);
if(flag)
{
StudentExaminationMasterDao adao1=new StudentExaminationMasterDao();
StudentExaminationMasterForm aform1=new StudentExaminationMasterForm();
aform1.setStudentExamId(studentexmid);
System.out.println("studentexamid"+studentexmid);
 float n1=new StudentExaminationDetailsDao().getcount(studentexmid);

float percentage=(n1/noofquestions)*100;
System.out.println("Count details"+n1);
System.out.println("Count no of questions"+noofquestions);
aform1.setExamAggregade(percentage);
float result=new ExamQuestionsMasterDao().getResult(examid);
System.out.println("Percentage"+percentage);
System.out.println("result"+result);

if(result<=percentage)
{
aform1.setExamResult("pass");
}else{
aform1.setExamResult("Fail");

}
boolean flag1=adao1.UpdateStudentExaminationMaster(aform1);

}
}
RequestDispatcher rd=request.getRequestDispatcher("Success.jsp");
rd.forward(request,response);

%>


</body>
</html>