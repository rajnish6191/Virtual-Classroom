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
		import com.yourcompany.struts.form.FacultyAchievementsForm;

			public class FacultyAchievementsDao extends AbstractDataAccessObject 
			{
				public boolean insertFacultyAchievements(FacultyAchievementsForm faform)
				{
					java.sql.Connection con=null;
					boolean flag=false;
					try
					{
					int n=getSequenceID("FacultyAchievements","AchievementId");
					System.out.println("n value in dao is.........."+n);
					con=getConnection();
					PreparedStatement ps=con.prepareStatement("insert into FacultyAchievements values(?,?,?,?)");
					ps.setInt(1,n);
					System.out.println("faform.getFacultyId()----"+faform.getFacultyId());
					ps.setInt(2,faform.getFacultyId());
					ps.setString(3,faform.getAchievementDesc());
					ps.setString(4,faform.getSpecialRemarks());
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
					e.printStackTrace();
					LoggerManager.writeLogInfo(e);
				}
				}
				return flag;
				
				
					}

			public CoreList ViewFacultyAchievements()
			{   CoreList v=new CoreList();
				java.sql.Connection con=null;
				FacultyAchievementsForm faform=null;
				try
				{
					con=getConnection();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select f1.fname,f.ACHIEVEMENTID,f.ACHIEVEMENTDESC,f.SPECIALREMARKS from facultymaster f1,FacultyAchievements f where f1.FACULTYID = f.FACULTYID");
					 
					while(rs.next())
					{
						faform=new FacultyAchievementsForm();
						
						faform.setAchievementId(rs.getInt(2));
						faform.setFacultyName(rs.getString(1));
						faform.setAchievementDesc(rs.getString(3));
						faform.setSpecialRemarks(rs.getString(4));
						v.add(faform);
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
						e.printStackTrace();
						LoggerManager.writeLogInfo(e);
					}
					}
					return v;
					
				
			}
			public FacultyAchievementsForm ViewFacultyAchievementsById(int AchievementId)
			{   FacultyAchievementsForm faform=new FacultyAchievementsForm();
				java.sql.Connection con=null;
				 
				try
				{
					 
					con=getConnection();
					 
					PreparedStatement ps=con.prepareStatement("select * from FacultyAchievements where AchievementId = ? ");
					ps.setInt(1,AchievementId);
					ResultSet rs=ps.executeQuery();
					 
					if(rs.next())
					{
						faform=new FacultyAchievementsForm();
						int id=rs.getInt(1);
						faform.setAchievementId(rs.getInt(1));
						faform.setFacultyId(rs.getInt(2));
						faform.setAchievementDesc(rs.getString(3));
						faform.setSpecialRemarks(rs.getString(4));
						 
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
				return faform;
				
				
			}

			public boolean deleteFacultyAchievements(int AchievementId)
				{
					java.sql.Connection con=null;
					boolean flag=false;
					try
					{
						con=getConnection();						 
						PreparedStatement ps=con.prepareStatement("delete from FacultyAchievements where AchievementId = ? ");
						ps.setInt(1,AchievementId);
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

			public boolean UpdateFacultyAchievements(FacultyAchievementsForm faform)
			{
				java.sql.Connection con=null;
				boolean flag=false;
				try
				{
				 
				con=getConnection();
				PreparedStatement ps=con.prepareStatement("update FacultyAchievements set   FACULTYID = ?,ACHIEVEMENTDESC = ?,SPECIALREMARKS = ? where AchievementId = ? ");
				ps.setInt(4,faform.getAchievementId());
				ps.setInt(1,faform.getFacultyId());
				ps.setString(2,faform.getAchievementDesc());
				ps.setString(3,faform.getSpecialRemarks());
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






			 


			 





			 


			  

			

		 

		 

	 





 
