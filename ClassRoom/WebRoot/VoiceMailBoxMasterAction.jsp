
<%@page import="com.yourcompany.struts.form.VoiceMailBoxMasterForm"%>
<%@page import="com.dts.project.dao.VoiceMailBoxMasterDao"%> <%
 String target="VoiceMailBoxMaster.jsp?status=Registration Failed";
 try
 {
 VoiceMailBoxMasterForm form=new VoiceMailBoxMasterForm();
 form.setVoiceMailBoxText(request.getParameter("voiceMailBoxText"));
 form.setStudentId(Integer.parseInt(request.getParameter("studentId")));
 form.setAudioFile(request.getParameter("audioFile"));
 VoiceMailBoxMasterDao dao=new VoiceMailBoxMasterDao();
 boolean flag=dao.insertVoiceMailBoxMaster(form);
 if(flag)
 {
 target="VoiceMailBoxMaster.jsp?status=Registration Succes";
 }
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);%> 