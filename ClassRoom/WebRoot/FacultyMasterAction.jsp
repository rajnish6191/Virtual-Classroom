
<%@page import="com.yourcompany.struts.form.FacultyMasterForm"%>
<%@page import="com.dts.project.dao.FacultyMasterDao"%> <%
 String target="FacultyMaster.jsp?status=Registration Failed";
 try
 {
 FacultyMasterForm form=new FacultyMasterForm();
 form.setFacultyfirstname(request.getParameter("facultyfirstname"));
 form.setDob(request.getParameter("dob"));
 form.setDor(request.getParameter("dor"));
 form.setAddress(request.getParameter("address"));
 form.setEmail(request.getParameter("email"));
 form.setPhone(request.getParameter("phone"));
 form.setImage(request.getParameter("image"));
 form.setSpecialRemarks(request.getParameter("specialRemarks"));
 form.setExperience(Integer.parseInt(request.getParameter("experience")));
 FacultyMasterDao dao=new FacultyMasterDao();
 boolean flag=dao.insertFacultyMaster(form);
 if(flag)
 {
 target="FacultyMaster.jsp?status=Registration success";
 }
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);
 %>