
<%@page import="com.dts.project.dao.VoiceMailBoxMasterDao"%> <%
 String target="adminhome.jsp?status=VoiceMail deletion Failed";
 try
 {
 String id[]=request.getParameterValues("TypeId");
 for(int i=0;i<id.length;i++)
 {
 int Id=Integer.parseInt(id[i]);
 VoiceMailBoxMasterDao dao=new VoiceMailBoxMasterDao();
 boolean flag=dao.deleteVoiceMailBoxMaster(Id);
 if(flag)
 {
 target="adminhome.jsp?status=VoiceMail Deleted Successfully";
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