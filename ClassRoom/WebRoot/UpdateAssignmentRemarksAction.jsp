 
<%@page import="com.yourcompany.struts.form.AssignmentRemarksForm"%>
<%@page import="com.dts.project.dao.AssignmentRemarksDao"%> <%
 String target="ViewAssignmentRemarks.jsp?status=Updation Success";
 try
 {
 AssignmentRemarksForm form=new AssignmentRemarksForm();
 form.setAssignmentId(Integer.parseInt(request.getParameter("assignmentId")));
 form.setFacultyId(Integer.parseInt(request.getParameter("facultyId")));
 form.setRemarksToStudent(request.getParameter("remarksToStudent"));
 AssignmentRemarksDao dao=new AssignmentRemarksDao();
 boolean flag=dao.UpdateAssignmentRemarks(form);
 if(flag)
 {
 target="ViewAssignmentRemarks.jsp?status=Updation Success";
 }
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);
 %>