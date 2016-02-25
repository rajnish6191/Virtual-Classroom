 
<%@page import="com.yourcompany.struts.form.FacultyAchievementsForm"%>
<%@page import="com.dts.project.dao.FacultyAchievementsDao"%> <%
 String target="ViewFacultyAchievements.jsp?status=Updation Failed";
 try
 {
 FacultyAchievementsForm form=new FacultyAchievementsForm();
 form.setAchievementId(Integer.parseInt(request.getParameter("achievementId")));
 form.setFacultyId(Integer.parseInt(request.getParameter("facultyId")));
 form.setAchievementDesc(request.getParameter("achievementDesc"));
 form.setSpecialRemarks(request.getParameter("specialRemarks"));
 FacultyAchievementsDao dao=new FacultyAchievementsDao();
 boolean flag=dao.UpdateFacultyAchievements(form);
 if(flag)
 {
 target="ViewFacultyAchievements.jsp?status=Updation Success";
 }
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);
 %>