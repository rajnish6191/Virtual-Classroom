
<%@page import="com.dts.project.dao.CourseLecturerMasterDao"%> <%
 String target="FacultyHome.jsp?status=Course Lecture Deletion Failed";
 try
 {
 String id[]=request.getParameterValues("TypeId");
 for(int i=0;i<id.length;i++)
 {
 int Id=Integer.parseInt(id[i]);
 CourseLecturerMasterDao dao=new CourseLecturerMasterDao();
 boolean flag=dao.deleteCourseLecturerMaster(Id);
 if(flag)
 {
 target="FacultyHome.jsp?status=Course Lecture Deleted Successfully";
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