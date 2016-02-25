
<%@page import="com.dts.project.dao.FacultyMasterDao"%><%
String target="FacultyLoginForm.jsp?status=Invalid UserName and Password";
String username=request.getParameter("username");
String password=request.getParameter("password");
FacultyMasterDao adao=new FacultyMasterDao();
int facultyid=adao.validateFaculty(username,password);
if(facultyid!=0)
{
session.setAttribute("facultyid",facultyid);
session.setAttribute("user",username);
session.setAttribute("role","faculty");
target="FacultyHome.jsp?status=Welcome To The Faculty Home";
}
RequestDispatcher rd=request.getRequestDispatcher(target);
rd.forward(request,response);

%>