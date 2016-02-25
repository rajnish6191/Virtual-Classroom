
<%@page import="com.yourcompany.struts.form.NewsLetterMasterForm"%>
<%@page import="com.dts.project.dao.NewsLetterMasterDao"%> <%
 String target="ViewNewsLetterMaster.jsp?status=Updation Failed";
 try
 {
 NewsLetterMasterForm form=new NewsLetterMasterForm();
 form.setNewsLetterId(Integer.parseInt(request.getParameter("newsLetterId")));
 form.setLetterUploadedFile(request.getParameter("letterUploadedFile"));
 form.setNewsdate(request.getParameter("newsDate"));
 form.setFacultyId(Integer.parseInt(request.getParameter("facultyId")));
 NewsLetterMasterDao dao=new NewsLetterMasterDao();
 boolean flag=dao.UpdateNewsLetterMaster(form);
 if(flag)
 {
 target="ViewNewsLetterMaster.jsp?status=Updation success";
 }
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);
 %>