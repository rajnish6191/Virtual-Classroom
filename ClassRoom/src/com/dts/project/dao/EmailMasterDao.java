 
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
		import com.yourcompany.struts.form.EmailMasterForm;

			public class EmailMasterDao extends AbstractDataAccessObject 
			{
				public boolean insertEmailMaster(EmailMasterForm seform)
				{
					java.sql.Connection con=null;
					int n=getSequenceID("emailmaster","emailid");
					boolean flag=false;
					try
					{
					con=getConnection();
					PreparedStatement ps=con.prepareStatement("insert into EmailMaster values(?,?,?,?,?)");
					ps.setInt(1,n);
					ps.setString(2,DateWrapper.parseDate(new java.util.Date()));
					ps.setString(3,seform.getEmailText());
					ps.setInt(4,seform.getTostudentid());
					ps.setInt(5,1);
					
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

			public CoreList ViewEmailMaster()
			{   CoreList v=new CoreList();
				java.sql.Connection con=null;
				EmailMasterForm seform=null;
				try
				{
					con=getConnection();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from EmailMaster");
					 
					while(rs.next())
					{
						seform=new EmailMasterForm();
					
						seform.setEmailId(rs.getInt(1));
						seform.setDateAndTime(DateWrapper.parseDate(rs.getDate(2)));
						seform.setEmailText(rs.getString(3));
						seform.setFromstudentid(rs.getInt(4));
						v.add(seform);
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
			public EmailMasterForm ViewEmailMasterById(int StudentExamId)
			{   EmailMasterForm seform=new EmailMasterForm();
				java.sql.Connection con=null;
				 
				try
				{
					 
					con=getConnection();
					 
					PreparedStatement ps=con.prepareStatement("select * from EmailMaster where EmailId = ? ");
					ps.setInt(1,StudentExamId);
					ResultSet rs=ps.executeQuery();
					 
					if(rs.next())
					{
						seform=new EmailMasterForm();
						
						seform.setEmailId(rs.getInt(1));
						seform.setDateAndTime(DateWrapper.parseDate(rs.getDate(2)));
						seform.setEmailText(rs.getString(3));
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
				return seform;
				
				
			}

			public boolean deleteEmailMaster(int StudentExamId)
				{
					java.sql.Connection con=null;
					boolean flag=false;
					try
					{
						con=getConnection();						 
						PreparedStatement ps=con.prepareStatement("delete from EmailMaster where EmailId = ? ");
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

			public boolean UpdateEmailMaster(EmailMasterForm seform)
			{
				java.sql.Connection con=null;
				boolean flag=false;
				try
				{
				 
				con=getConnection();
				PreparedStatement ps=con.prepareStatement("update EmailMaster set   DATEANDTIME = ?,EMAILTEXT = ? where EmailId = ? ");
				ps.setInt(3,seform.getEmailId());
				ps.setString(1,DateWrapper.parseDate(seform.getDateAndTime()));
				ps.setString(2,seform.getEmailText());
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






			 


			 





			 


			  

			

		 

		 

	 










 
