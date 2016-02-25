
	 package com.dts.project.dao;
		import java.io.File;
		 
		import java.sql.*; 

			import com.dts.core.dao.AbstractDataAccessObject;
			import com.dts.core.util.CoreList;
			 
			import com.dts.core.util.LoggerManager;
		import com.yourcompany.struts.form.CourseFacultyMasterForm;

			public class CoursefacultyMasterDao extends AbstractDataAccessObject 
			{
				public boolean insertCourseFacultyMaster(CourseFacultyMasterForm cfform)
				{
					java.sql.Connection con=null;
					boolean flag=false;
					try
					{
					con=getConnection();
					PreparedStatement ps=con.prepareStatement("insert into CourseFacultyMaster values(?,?,?)");
					ps.setInt(1,cfform.getCourseId()); 
					ps.setInt(2,cfform.getFacultyId());
					ps.setString(3,cfform.getDescByFaculty());
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

			public CoreList ViewCourseFacultyMaster()
			{   CoreList v=new CoreList();
				java.sql.Connection con=null;
				CourseFacultyMasterForm cfform=null;
				try
				{
					con=getConnection();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select c.cname,f.fname,cf.DESCBYFACULTY from CourseFacultyMaster cf,coursemaster c,facultymaster f where cf.FACULTYID = f.FACULTYID and cf.courseid = c.courseid");
					 
					while(rs.next())
					{
						cfform=new CourseFacultyMasterForm();
						int id=rs.getInt(1);
						cfform.setCname(rs.getString(1));
						cfform.setFname(rs.getString(2));
						cfform.setDescByFaculty(rs.getString(3));
						v.add(cfform);
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
			public CourseFacultyMasterForm ViewCourseFacultyMasterById(int AchievementId)
			{   CourseFacultyMasterForm cfform=new CourseFacultyMasterForm();
				java.sql.Connection con=null;
				 
				try
				{
					 
					con=getConnection();
					 
					PreparedStatement ps=con.prepareStatement("select * from CourseFacultyMaster where facultyid = ? ");
					ps.setInt(1,AchievementId);
					ResultSet rs=ps.executeQuery();
					 
					if(rs.next())
					{
						cfform=new CourseFacultyMasterForm();
						int id=rs.getInt(1);
						cfform.setCourseId(rs.getInt(1));
						cfform.setFacultyId(rs.getInt(2));
						cfform.setDescByFaculty(rs.getString(3));
						 
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
				return cfform;
				
				
			}

			public boolean deleteCourseFacultyMaster(int AchievementId)
				{
					java.sql.Connection con=null;
					boolean flag=false;
					try
					{
						con=getConnection();						 
						PreparedStatement ps=con.prepareStatement("delete from CourseFacultyMaster where FacultyId = ? ");
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

			public boolean UpdateCourseFacultyMaster(CourseFacultyMasterForm cfform)
			{
				java.sql.Connection con=null;
				boolean flag=false;
				try
				{
				 
				con=getConnection();
				PreparedStatement ps=con.prepareStatement("update CourseFacultyMaster set   COurseID = ?,DESCBYFACULTY = ? where FacultyId = ? ");
				ps.setInt(1,cfform.getCourseId()); 
				ps.setInt(3,cfform.getFacultyId());
				ps.setString(2,cfform.getDescByFaculty());
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






			 


			 





			 


			  

			

		 

		 

	 







 
