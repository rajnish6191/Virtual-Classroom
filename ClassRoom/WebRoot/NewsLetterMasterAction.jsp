
<%@page import="com.yourcompany.struts.form.NewsLetterMasterForm"%>
<%@page import="com.dts.project.dao.NewsLetterMasterDao"%> <%
 String target="NewsLetterMaster.jsp?status=Registration Failed";
 try
 {
 NewsLetterMasterForm form=new NewsLetterMasterForm();
 form.setLetterUploadedFile(request.getParameter("letterUploadedFile"));
 form.setNewsdate(request.getParameter("newsDate"));
 form.setFacultyId(Integer.parseInt(request.getParameter("facultyId")));
 NewsLetterMasterDao dao=new NewsLetterMasterDao();
 boolean flag=dao.insertNewsLetterMaster(form);
 if(flag)
 {
 target="NewsLetterMaster.jsp?status=Registration success";
 }
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);
 %>