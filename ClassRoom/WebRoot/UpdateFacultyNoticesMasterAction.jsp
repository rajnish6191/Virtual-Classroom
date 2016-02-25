 
<%@page import="com.yourcompany.struts.form.FacultyNoticesMasterForm"%>
<%@page import="com.dts.project.dao.FacultyNoticesMasterDao"%> <%
 String target="FacultyHome.jsp?status=Notice Updation Failed";
 try
 {
 FacultyNoticesMasterForm form=new FacultyNoticesMasterForm();
 form.setNoticeId(Integer.parseInt(request.getParameter("noticeId")));
 form.setNoticeDate(request.getParameter("noticeDate"));
 form.setFacultyId(Integer.parseInt(request.getParameter("facultyId")));
 form.setNoticeText(request.getParameter("noticeText"));
 form.setNoticeFile(request.getParameter("noticeFile"));
 FacultyNoticesMasterDao dao=new FacultyNoticesMasterDao();
 boolean flag=dao.UpdateFacultyNoticesMaster(form);
 if(flag)
 {
 target="FacultyHome.jsp?status=Notice Updated Successfully";
 }
 }
 catch(Exception e)
 {
 e.printStackTrace();

}
 
RequestDispatcher rd=request.getRequestDispatcher(target);
rd.forward(request,response);
%>