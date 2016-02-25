
<%@page import="com.yourcompany.struts.form.FacultyNoticesMasterForm"%>
<%@page import="com.dts.project.dao.FacultyNoticesMasterDao"%> <%
 String target="FacultyNoticesMaster.jsp?status=Registration Failed";
 try
 {
 FacultyNoticesMasterForm form=new FacultyNoticesMasterForm();
 form.setNoticeDate(request.getParameter("noticeDate"));
 form.setFacultyId(Integer.parseInt(request.getParameter("facultyId")));
 form.setNoticeText(request.getParameter("noticeText"));
 form.setNoticeFile(request.getParameter("noticeFile"));
 FacultyNoticesMasterDao dao=new FacultyNoticesMasterDao();
 boolean flag=dao.insertFacultyNoticesMaster(form);
 if(flag)
 {
 target="FacultyNoticesMaster.jsp?status=Registration Success";
 }
 }
 catch(Exception e)
 {
 e.printStackTrace();

}
 
RequestDispatcher rd=request.getRequestDispatcher(target);
rd.forward(request,response);
%>