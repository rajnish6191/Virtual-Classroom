
<%@page import="com.yourcompany.struts.form.CourseMasterForm"%>
<%@page import="com.dts.project.dao.CourseMasterDao"%> <%
 String target="CourseMaster.jsp?status=Registration Failed";
 try
 {
 CourseMasterForm form=new CourseMasterForm();
 form.setCourseName(request.getParameter("courseName"));
 form.setCourseDesc(request.getParameter("courseDesc"));
 form.setCourseDuration(request.getParameter("courseDuration"));
 form.setCoursecontent(request.getParameter("coursecontent"));
 form.setNoOfLecturers(Integer.parseInt(request.getParameter("noOfLecturers")));
 CourseMasterDao dao=new CourseMasterDao();
 boolean flag=dao.insertCourseMaster(form);
 if(flag)
 {
 target="CourseMaster.jsp?status=Registration sucecess";
 }
 }catch(Exception e)
 {
 e.printStackTrace();
 }
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);
 %>
 
 