
<%@page import="com.yourcompany.struts.form.ChatRoomMasterForm"%>
<%@page import="com.dts.project.dao.ChatRoomMasterDao"%> 
 <%
 String target="ChatRoomMaster.jsp?status=Registration Failed";
 try
 {
 ChatRoomMasterForm form=new ChatRoomMasterForm();
 form.setChatRoomName(request.getParameter("chatRoomName"));
 form.setCourseId(Integer.parseInt(request.getParameter("courseId")));
 form.setFacultyId(Integer.parseInt(request.getParameter("facultyId")));
 ChatRoomMasterDao dao=new ChatRoomMasterDao();
 boolean flag=dao.insertChatRoomMaster(form);
 if(flag)
 {
 target="ChatRoomMaster.jsp?status=Registration Success";
 }
 }
 catch(Exception e)
 {
e.printStackTrace();
}
RequestDispatcher rd=request.getRequestDispatcher(target);
rd.forward(request,response);
%>