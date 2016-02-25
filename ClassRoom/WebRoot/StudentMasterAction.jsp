
<%@page import="com.yourcompany.struts.form.StudentMasterForm"%>
<%@page import="com.dts.project.dao.StudentMasterDao"%>  
  
 <%
 String target="StudentMaster.jsp?status=Registration failed";
 
 try
 {
 StudentMasterForm form=new StudentMasterForm();
 form.setStudentfirstname(request.getParameter("studentfirstname"));
 form.setStudentmiddlename(request.getParameter("studentmiddlename"));
 form.setStudentlastname(request.getParameter("studentlastname"));
 form.setDob(request.getParameter("dob"));
 form.setDor(request.getParameter("dor"));
 form.setAddress(request.getParameter("address"));
 form.setEmail(request.getParameter("email"));
 form.setPhone(request.getParameter("phone"));
 form.setImage(request.getParameter("image"));
 StudentMasterDao dao=new StudentMasterDao();
 boolean flag=dao.insertStudentMaster(form);
 if(flag)
 {
 
 target="StudentMaster.jsp?status=Registration success";
 }
 }catch(Exception e)
 {
 e.printStackTrace();
 }
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);
 %>