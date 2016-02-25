 
<%@page import="com.yourcompany.struts.form.CourseMasterForm"%>
<%@page import="com.dts.project.dao.CourseMasterDao"%> <%
 String target="adminhome.jsp?status=Course Updation Failed";
 try
 {
 CourseMasterForm form=new CourseMasterForm();
 form.setCourseId(Integer.parseInt(request.getParameter("courseId")));
 form.setCourseName(request.getParameter("courseName"));
 form.setCourseDesc(request.getParameter("courseDesc"));
 form.setCourseDuration(request.getParameter("courseDuration"));
 form.setCoursecontent(request.getParameter("coursecontent"));
 form.setNoOfLecturers(Integer.parseInt(request.getParameter("noOfLecturers")));
 CourseMasterDao dao=new CourseMasterDao();
 boolean flag=dao.UpdateCourseMaster(form);
 if(flag)
 {
 target="adminhome.jsp?status=Course Updated sucecess";
 }
 }catch(Exception e)
 {
 e.printStackTrace();
 }
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);
 %>
 
 