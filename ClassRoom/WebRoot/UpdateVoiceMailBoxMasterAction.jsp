 
<%@page import="com.yourcompany.struts.form.VoiceMailBoxMasterForm"%>
<%@page import="com.dts.project.dao.VoiceMailBoxMasterDao"%> <%
 String target="adminhome.jsp?status=Voice MailBox Updation Failed";
 try
 {
 VoiceMailBoxMasterForm form=new VoiceMailBoxMasterForm();
 form.setVoiceMailBoxId(Integer.parseInt(request.getParameter("voiceMailBoxId")));
 form.setVoiceMailBoxText(request.getParameter("voiceMailBoxText"));
 form.setStudentId(Integer.parseInt(request.getParameter("studentId")));
 form.setAudioFile(request.getParameter("audioFile"));
 VoiceMailBoxMasterDao dao=new VoiceMailBoxMasterDao();
 boolean flag=dao.UpdateVoiceMailBoxMaster(form);
 if(flag)
 {
 target="adminhome.jsp?status=VoiceMail updated Successfully";
 }
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
 RequestDispatcher rd=request.getRequestDispatcher(target);
 rd.forward(request,response);%> 