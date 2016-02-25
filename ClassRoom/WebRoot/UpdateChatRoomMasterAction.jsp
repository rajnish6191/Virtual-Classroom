 
<%@page import="com.yourcompany.struts.form.ChatRoomMasterForm"%>
<%@page import="com.dts.project.dao.ChatRoomMasterDao"%> 
 <%
 String target="ViewChatRoomMaster.jsp?status=Updation Failed";
 try
 {
 ChatRoomMasterForm form=new ChatRoomMasterForm();
 form.setChatRoomId(Integer.parseInt(request.getParameter("chatRoomId")));
 form.setChatRoomName(request.getParameter("chatRoomName"));
 form.setCourseId(Integer.parseInt(request.getParameter("courseId")));
 form.setFacultyId(Integer.parseInt(request.getParameter("facultyId")));
 ChatRoomMasterDao dao=new ChatRoomMasterDao();
 boolean flag=dao.UpdateChatRoomMaster(form);
 if(flag)
 {
 target="ViewChatRoomMaster.jsp?status=Updation Success";
 }
 }
 catch(Exception e)
 {
e.printStackTrace();
}
RequestDispatcher rd=request.getRequestDispatcher(target);
rd.forward(request,response);
%>