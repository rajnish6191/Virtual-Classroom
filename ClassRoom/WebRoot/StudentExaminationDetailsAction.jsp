
<%@page import="com.yourcompany.struts.form.StudentExaminationDetailsForm"%>
<%@page import="com.dts.project.dao.StudentExaminationDetailsDao"%> <%
 String target="StudentExaminationDetails.jsp?status=Registration Failed";
 try
 {
 StudentExaminationDetailsForm form=new StudentExaminationDetailsForm();
 form.setQuestionId(Integer.parseInt(request.getParameter("questionId")));
 form.setStudentExamId(Integer.parseInt(request.getParameter("studentExamId")));
 form.setAnswer(request.getParameter("answer"));
 form.setCorrect_wrong(request.getParameter("correct_wrong"));
 StudentExaminationDetailsDao dao=new StudentExaminationDetailsDao();
 boolean flag=dao.insertStudentExaminationDetails(form);
 if(flag)
 {
 target="StudentExaminationDetails.jsp?status=Registration Success";
 }
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);
 %>