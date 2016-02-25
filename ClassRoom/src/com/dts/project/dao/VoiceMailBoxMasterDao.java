 
	 
	 package com.dts.project.dao;
		 
		import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.*; 

			import com.dts.core.dao.AbstractDataAccessObject;
			import com.dts.core.util.CoreList;
			import com.dts.core.util.DateWrapper;
			import com.dts.core.util.LoggerManager;
import com.yourcompany.struts.form.VoiceMailBoxMasterForm;

			public class VoiceMailBoxMasterDao extends AbstractDataAccessObject 
			{
				public boolean insertVoiceMailBoxMaster(VoiceMailBoxMasterForm vmform)
				{
					java.sql.Connection con=null;
					boolean flag=false;
					try
					{
					int n=getSequenceID("VoiceMailBoxMaster","VoiceMailBoxId");
					con=getConnection();
					PreparedStatement ps=con.prepareStatement("insert into VoiceMailBoxMaster values(?,?,?,?)");
					ps.setInt(1,n);
					ps.setString(2,vmform.getVoiceMailBoxText());
					ps.setInt(3,vmform.getStudentId());
					File afile=new File(vmform.getAudioFile());
			        FileInputStream fs=new FileInputStream(afile);
			        ps.setBinaryStream(4,fs,(int)afile.length());			
					
					int i=ps.executeUpdate();
					if(i>0)
						flag=true;
					 
						
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}finally
				{
					try{
						con.close();
					}
				catch(Exception e)
				{
					LoggerManager.writeLogInfo(e);
				}
				}
				return flag;
				
				
					}

			public CoreList ViewVoiceMailBoxMaster(String storepath)
			{   CoreList v=new CoreList();
				java.sql.Connection con=null;
				VoiceMailBoxMasterForm vmform=null;
				try
				{
					con=getConnection();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select v.VOICEMAILBOXID,v.VOICEMAILBOXTEXT,v.AUDIO,s.loginid from VoiceMailBoxMaster v,userdetails s where v.studentid = s.userid");
					 
					while(rs.next())
					{
						vmform=new VoiceMailBoxMasterForm();
						int id=rs.getInt(1); 
						vmform.setVoiceMailBoxId(rs.getInt(1));
						vmform.setVoiceMailBoxText(rs.getString(2));
						
						Blob b=rs.getBlob(3);
						byte b1[]=b.getBytes(1,(int)b.length()); 
						OutputStream fout=new FileOutputStream(storepath+"/"+id+".wav");
						fout.write(b1);
						vmform.setAudioFile(id+".wav");	
						vmform.setStudentName(rs.getString(4));
						v.add(vmform);
					}

					 
				}
					catch(Exception e)
				{
					e.printStackTrace();
				}
					finally
					{
						try{
							con.close();
						}
					catch(Exception e)
					{
						LoggerManager.writeLogInfo(e);
					}
					}
					return v;
					
				
			}
			public VoiceMailBoxMasterForm ViewVoiceMailBoxMasterById(String storepath,int VoiceMailBoxId)
			{   VoiceMailBoxMasterForm vmform=new VoiceMailBoxMasterForm();
				java.sql.Connection con=null;
				 
				try
				{
					 
					con=getConnection();
					 
					PreparedStatement ps=con.prepareStatement("select * from VoiceMailBoxMaster where VOICEMAILBOXID = ? ");
					ps.setInt(1,VoiceMailBoxId);
					ResultSet rs=ps.executeQuery();
					 
					if(rs.next())
					{
						vmform=new VoiceMailBoxMasterForm();
						int id=rs.getInt(1); 
						vmform.setVoiceMailBoxId(rs.getInt(1));
						vmform.setVoiceMailBoxText(rs.getString(2));
						vmform.setStudentId(rs.getInt(3));
						Blob b=rs.getBlob(4);
						byte b1[]=b.getBytes(1,(int)b.length()); 
						OutputStream fout=new FileOutputStream(storepath+"/"+id+".wav");
						fout.write(b1);
						vmform.setAudioFile(id+".wav");		
					}

					 
				}
					catch(Exception e)
				{
				e.printStackTrace();	
				}finally
				{
					try{
						con.close();
					}
				catch(Exception e)
				{
					LoggerManager.writeLogInfo(e);
				}
				}
				return vmform;
				
				
			}

			public boolean deleteVoiceMailBoxMaster(int VoiceMailBoxId)
				{
					java.sql.Connection con=null;
					boolean flag=false;
					try
					{
						 
						con=getConnection();
						 
						PreparedStatement ps=con.prepareStatement("delete from VoiceMailBoxMaster where VOICEMAILBOXID = ? ");
						ps.setInt(1,VoiceMailBoxId);
						int i=ps.executeUpdate();
						if(i>0)
							flag=true;
						
						          
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					finally
					{
						try{
							con.close();
						}
					catch(Exception e)
					{
						LoggerManager.writeLogInfo(e);
					}
					}
					return flag;
					
					}

			public boolean UpdateVoiceMailBoxMaster(VoiceMailBoxMasterForm vmform)
			{
				java.sql.Connection con=null;
				boolean flag=false;
				try
				{
				 
				con=getConnection();
				PreparedStatement ps=con.prepareStatement("update VoiceMailBoxMaster set voicemailboxtext = ?,studentid = ?,audiofile = ? where VOICEMAILBOXID = ? ");
				ps.setInt(4,vmform.getVoiceMailBoxId());
				ps.setString(1,vmform.getVoiceMailBoxText());
				ps.setInt(2,vmform.getStudentId());
				File afile=new File(vmform.getAudioFile());
		        FileInputStream fs=new FileInputStream(afile);
		        ps.setBinaryStream(3,fs,(int)afile.length());				
				int i=ps.executeUpdate();	
				if(i>0)
					flag=true;
				 
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}finally
			{
				try{
					con.close();
				}
			catch(Exception e)
			{
				LoggerManager.writeLogInfo(e);
			}
			}
			return flag;


				}
			}






			 


			 





			 


			  

			

		 

		 


	 


	 








 
