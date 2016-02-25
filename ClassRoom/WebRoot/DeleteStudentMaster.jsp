
<%@page import="com.dts.project.dao.StudentMasterDao"%> <%
 String target="StudentHome.jsp?status=Student Deletion Failed";
 try
 {
 String id[]=request.getParameterValues("TypeId");
 for(int i=0;i<id.length;i++)
 {
 int Id=Integer.parseInt(id[i]);
 StudentMasterDao dao=new StudentMasterDao();
 boolean flag=dao.deleteStudentMaster(Id);
 if(flag)
 {
  target="StudentHome.jsp?status=Student Deletion Success";
  }
  }
  }catch(Exception e)
  {
  e.printStackTrace();
  }
  RequestDispatcher rd=request.getRequestDispatcher(target);
  rd.forward(request,response);
  %>
  