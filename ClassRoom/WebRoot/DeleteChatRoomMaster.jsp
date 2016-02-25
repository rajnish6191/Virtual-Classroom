
<%@page import="com.dts.project.dao.ChatRoomMasterDao"%> <%
 String target="ViewChatRoomMaster.jsp?status=Registration Failed";
 try
 {
 String id[]=request.getParameterValues("TypeId");
 for(int i=0;i<id.length;i++)
 {
 int Id=Integer.parseInt(id[i]);
 ChatRoomMasterDao dao=new ChatRoomMasterDao();
 boolean flag=dao.deleteChatRoomMaster(Id);
 if(flag)
 {
 target="ViewChatRoomMaster.jsp?status=Registration Success";
 }
 }
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);
 %>