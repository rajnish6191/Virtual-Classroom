 
<%@page import="com.yourcompany.struts.form.StudentMasterForm"%>
<%@page import="com.dts.project.dao.StudentMasterDao"%> <%
 String target="ViewStudentMaster.jsp?status=Updation failed";
 try
 {
 StudentMasterForm form=new StudentMasterForm();
 form.setStudentid(Integer.parseInt(request.getParameter("studentId")));
 form.setStudentfirstname(request.getParameter("studentfirstname"));
 form.setStudentmiddlename(request.getParameter("studentmiddlename"));
 form.setStudentlastname(request.getParameter("studentlastname"));
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
 StudentMasterDao dao=new StudentMasterDao();
 boolean flag=dao.UpdateStudentMaster(form);
 if(flag)
 {
 target="ViewStudentMaster.jsp?status=Updation success";
 }
 }catch(Exception e)
 {
 e.printStackTrace();
 }
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);
 %>