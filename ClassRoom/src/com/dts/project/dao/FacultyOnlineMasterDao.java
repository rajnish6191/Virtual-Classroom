 
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
		import com.yourcompany.struts.form.FacultyOnlineMasterForm;

			public class FacultyOnlineMasterDao extends AbstractDataAccessObject 
			{
				public boolean insertFacultyOnlineMaster(FacultyOnlineMasterForm foform)
				{
					java.sql.Connection con=null;
					int n=getSequenceID("facultyonlinemaster","OnlineId");
					boolean flag=false;
					try
					{
					con=getConnection();
					PreparedStatement ps=con.prepareStatement("insert into FacultyOnlineMaster values(?,?,?)");
					ps.setInt(1,n);
					ps.setString(2,DateWrapper.parseDate(foform.getOnlineDateTime()));
					ps.setInt(3,foform.getFacultyId());
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

			public CoreList ViewFacultyOnlineMaster()
			{   CoreList v=new CoreList();
				java.sql.Connection con=null;
				FacultyOnlineMasterForm foform=null;
				try
				{
					con=getConnection();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select o.ONLINEID,o.ONLINEDATEANDTIME,f.FNAME from FacultyOnlineMaster o,FacultyMaster f where f.facultyid = o.facltyid");
					 
					while(rs.next())
					{
						foform=new FacultyOnlineMasterForm();
					
						foform.setOnlineId(rs.getInt(1));
						foform.setOnlineDateTime(DateWrapper.parseDate(rs.getDate(2)));
						foform.setFname(rs.getString(3));
						v.add(foform);
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
			public FacultyOnlineMasterForm ViewFacultyOnlineMasterById(int StudentExamId)
			{   FacultyOnlineMasterForm foform=new FacultyOnlineMasterForm();
				java.sql.Connection con=null;
				 
				try
				{
					 
					con=getConnection();
					 
					PreparedStatement ps=con.prepareStatement("select * from FacultyOnlineMaster where OnlineId = ? ");
					ps.setInt(1,StudentExamId);
					ResultSet rs=ps.executeQuery();
					 
					if(rs.next())
					{
						foform=new FacultyOnlineMasterForm();
						
						foform.setOnlineId(rs.getInt(1));
						foform.setOnlineDateTime(DateWrapper.parseDate(rs.getDate(2)));
						foform.setFacultyId(rs.getInt(3));
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
				return foform;
				
				
			}

			public boolean deleteFacultyOnlineMaster(int StudentExamId)
				{
					java.sql.Connection con=null;
					boolean flag=false;
					try
					{
						con=getConnection();						 
						PreparedStatement ps=con.prepareStatement("delete from FacultyOnlineMaster where OnlineId = ? ");
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

			public boolean UpdateFacultyOnlineMaster(FacultyOnlineMasterForm foform)
			{
				java.sql.Connection con=null;
				boolean flag=false;
				try
				{
				 
				con=getConnection();
				PreparedStatement ps=con.prepareStatement("update FacultyOnlineMaster set   ONLINEDATEANDTIME = ?,FACLTYID = ? where OnlineId = ? ");
				ps.setInt(3,foform.getOnlineId());
				ps.setString(1,DateWrapper.parseDate(foform.getOnlineDateTime()));
				ps.setInt(2,foform.getFacultyId());
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






			 


			 





			 


			  

			

		 

		 

	 













 