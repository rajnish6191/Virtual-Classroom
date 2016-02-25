<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.yourcompany.struts.form.AssignmentRemarksForm"%>
<%@page import="com.dts.project.dao.AssignmentRemarksDao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String target="Remarks.jsp?status=Remarks Added is Failed";
try{

 int assignmentid=Integer.parseInt(request.getParameter("assignmentid"));
int facultyid=Integer.parseInt(request.getParameter("facultyid"));
String remarks=request.getParameter("remarks");
AssignmentRemarksForm form= new AssignmentRemarksForm();
form.setAssignmentId(assignmentid);
form.setFacultyId(facultyid);
form.setRemarksToStudent(remarks);
AssignmentRemarksDao adao=new AssignmentRemarksDao();
boolean flag=adao.insertAssignmentRemarks(form);
if(flag)
{
target="FacultyAssignmentMaster.jsp?status=Remarks Added Successfully";
}
}catch(Exception e)
{
}
RequestDispatcher rd=request.getRequestDispatcher(target);
rd.forward(request,response);

%>
</body>
</html>