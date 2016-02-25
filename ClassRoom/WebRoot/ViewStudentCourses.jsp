<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.dts.project.dao.StudentCourseMasterDao"%>
<%@page import="com.dts.core.util.CoreList"%>
<%@page import="com.yourcompany.struts.form.StudentCourseMasterForm"%>
<%@page import="java.util.Enumeration"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%try{
int studentid=((Integer)session.getAttribute("userid")).intValue();

StudentCourseMasterDao adao=new StudentCourseMasterDao();
CoreList acorelist=adao.ViewStudentCourseDetails(studentid);
 Enumeration aenumeration=acorelist.elements();
 %>
 <table align="center" border=1>
 <tr><th><input type=checkbox name="TypeId"></th>
 <th><font color="white">SName</th>      
<th><font color="white">CName</th>       
<th><font color="white">FName</th>      
<th><font color="white">RegDate</th>        
<th><font color="white">CourseEndDate</th></tr>

 <%while(aenumeration.hasMoreElements())
 {
 StudentCourseMasterForm form=(StudentCourseMasterForm)aenumeration.nextElement();
  %>
  <tr><td align="center"><input type="checkbox" name="TypeId" value="<%=form.getCourseRegId() %>"></td>
<td align="center"><b><a href="UpdateStudentCourseMaster.jsp?Id=<%=form.getCourseRegId() %>"><font color="#ffff00"><u><%=form.getSname() %></a></td>
<td align="center"><b><font color="#ffff00"><%=form.getCname()%></td>
<td align="center"><b><font color="#ffff00"><%=form.getFname()%></td>
<td align="center"><b><font color="#ffff00"><%=form.getRegDate()%></td>
<td align="center"><b><font color="#ffff00"><%=form.getCourseEndDate()%></td></tr>
<%}}catch(Exception e)
{
e.printStackTrace();
}
%>
  
   
</body>
</html>