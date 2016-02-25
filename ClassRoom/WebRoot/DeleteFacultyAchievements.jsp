
<%@page import="com.dts.project.dao.FacultyAchievementsDao"%>
 
 <%
String target="FacultyOptions.jsp?status=Achievement Deletion Failed";
try
{
String id[]=request.getParameterValues("TypeId");
for(int i=0;i<id.length;i++)
{
 int Id=Integer.parseInt(id[i]);
 FacultyAchievementsDao dao=new FacultyAchievementsDao();
 boolean flag=dao.deleteFacultyAchievements(Id);
 if(flag)
 {
 target="FacultyOptions.jsp?status=Achievement Deleted Successfully";
 }
 }
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);
 %>
 
 