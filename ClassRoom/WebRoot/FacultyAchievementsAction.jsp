
<%@page import="com.yourcompany.struts.form.FacultyAchievementsForm"%>
<%@page import="com.dts.project.dao.FacultyAchievementsDao"%> <%
 String target="FacultyAchievements.jsp?status=Registration Failed";
 try
 {
 FacultyAchievementsForm form=new FacultyAchievementsForm();
 form.setFacultyId(Integer.parseInt(request.getParameter("facultyId")));
 form.setAchievementDesc(request.getParameter("achievementDesc"));
 form.setSpecialRemarks(request.getParameter("specialRemarks"));
 FacultyAchievementsDao dao=new FacultyAchievementsDao();
 boolean flag=dao.insertFacultyAchievements(form);
 if(flag)
 {
 target="FacultyAchievements.jsp?status=Registration Success";
 }
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);
 %>