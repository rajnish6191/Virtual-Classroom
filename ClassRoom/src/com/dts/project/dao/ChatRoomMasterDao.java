 
	 
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
		import com.yourcompany.struts.form.ChatRoomMasterForm;

			public class ChatRoomMasterDao extends AbstractDataAccessObject 
			{
				public boolean insertChatRoomMaster(ChatRoomMasterForm crform)
				{
					java.sql.Connection con=null;
					boolean flag=false;
					try
					{
					con=getConnection();
					int n=getSequenceID("ChatRoomMaster","ChatRoomId");
					PreparedStatement ps=con.prepareStatement("insert into ChatRoomMaster values(?,?,?,?)");
					ps.setInt(1,n);
					ps.setString(2,crform.getChatRoomName());
					ps.setInt(3,crform.getCourseId());
					ps.setInt(4,crform.getFacultyId());
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

			public CoreList ViewChatRoomMaster()
			{   CoreList v=new CoreList();
				java.sql.Connection con=null;
				ChatRoomMasterForm crform=null;
				try
				{
					con=getConnection();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select c.CHATROOMID,c.CHATROOMNAME,r.CNAME,f.FNAME from ChatRoomMaster c,coursemaster r,facultymaster f where c.courseid = r.courseid and c.facultyid = f.facultyid");
					 
					while(rs.next())
					{
						crform=new ChatRoomMasterForm();
					
						crform.setChatRoomId(rs.getInt(1));
						crform.setChatRoomName(rs.getString(2));
						crform.setCoursename(rs.getString(3));
						crform.setFname(rs.getString(4));
						v.add(crform);
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
			public ChatRoomMasterForm ViewChatRoomMasterById(int StudentExamId)
			{   ChatRoomMasterForm crform=new ChatRoomMasterForm();
				java.sql.Connection con=null;
				 
				try
				{
					 
					con=getConnection();
					 
					PreparedStatement ps=con.prepareStatement("select * from ChatRoomMaster where ChatRoomId = ? ");
					ps.setInt(1,StudentExamId);
					ResultSet rs=ps.executeQuery();
					 
					if(rs.next())
					{
						crform=new ChatRoomMasterForm();
						
						crform.setChatRoomId(rs.getInt(1));
						crform.setChatRoomName(rs.getString(2));
						crform.setCourseId(rs.getInt(3));
						crform.setFacultyId(rs.getInt(4));
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
				return crform;
				
				
			}

			public boolean deleteChatRoomMaster(int StudentExamId)
				{
					java.sql.Connection con=null;
					boolean flag=false;
					try
					{
						con=getConnection();						 
						PreparedStatement ps=con.prepareStatement("delete from ChatRoomMaster where ChatRoomId = ? ");
						ps.setInt(1,StudentExamId);
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

			public boolean UpdateChatRoomMaster(ChatRoomMasterForm crform)
			{
				java.sql.Connection con=null;
				boolean flag=false;
				try
				{
				 
				con=getConnection();
				PreparedStatement ps=con.prepareStatement("update ChatRoomMaster set   chatroomname = ?,courseid = ?,facultyid   = ? where chatroomid = ? ");
				ps.setInt(4,crform.getChatRoomId());
				ps.setString(1,crform.getChatRoomName());
				ps.setInt(2,crform.getCourseId());
				ps.setInt(3,crform.getFacultyId());
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






			 


			 





			 


			  

			

		 

		 

	 











 
