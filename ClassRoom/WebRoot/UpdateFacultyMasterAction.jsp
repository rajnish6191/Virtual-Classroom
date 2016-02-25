
<%@page import="com.yourcompany.struts.form.FacultyMasterForm"%>
<%@page import="com.dts.project.dao.FacultyMasterDao"%> <%
 String target="ViewFacultyMaster.jsp?status=Updation Failed";
 try
 {
 FacultyMasterForm form=new FacultyMasterForm();
 form.setFacultyId(Integer.parseInt(request.getParameter("facultyId")));
 form.setFacultyfirstname(request.getParameter("facultyfirstname"));
 form.setDob(request.getParameter("dob"));
 form.setDor(request.getParameter("dor"));
 form.setAddress(request.getParameter("address"));
 form.setEmail(request.getParameter("email"));
 form.setPhone(request.getParameter("phone"));
 if(request.getParameter("image")!=null)
 {
 form.setImage(request.getParameter("image"));
 }
 else
 {
 form.setImage(request.getParameter("image1"));
 }
 form.setSpecialRemarks(request.getParameter("specialRemarks"));
 form.setExperience(Integer.parseInt(request.getParameter("experience")));
 FacultyMasterDao dao=new FacultyMasterDao();
 boolean flag=dao.UpdateFacultyMaster(form);
 if(flag)
 {
 target="ViewFacultyMaster.jsp?status=Updation success";
 }
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);
 %>