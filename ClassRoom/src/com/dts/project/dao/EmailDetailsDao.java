 
	 
	 package com.dts.project.dao;
		
		import java.sql.*; 

			import com.dts.core.dao.AbstractDataAccessObject;
			import com.dts.core.util.CoreList;
			import com.dts.core.util.LoggerManager;
		import com.yourcompany.struts.form.EmailDetailsForm;

			public class EmailDetailsDao extends AbstractDataAccessObject 
			{
				public boolean insertEmailDetails(EmailDetailsForm edform)
				{
					java.sql.Connection con=null;
					boolean flag=false;
					try
					{
					con=getConnection();
			 
					PreparedStatement ps=con.prepareStatement("insert into EmailDetails values(?,?,?,?,?)");
					ps.setInt(1,edform.getEmailId());
					ps.setInt(2,edform.getFromstudentId());
					ps.setInt(3,edform.getToFacultyId());
					ps.setInt(4,edform.getFromFacultyId());
					ps.setInt(5,edform.getToStudentId());
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

			public CoreList ViewEmailDetails()
			{   CoreList v=new CoreList();
				java.sql.Connection con=null;
				EmailDetailsForm edform=null;
				try
				{
					con=getConnection();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from EmailDetails");
					 
					while(rs.next())
					{
						edform=new EmailDetailsForm();
					
						edform.setEmailId(rs.getInt(1));
						edform.setFromstudentId(rs.getInt(2));
						edform.setToFacultyId(rs.getInt(3));
						edform.setFromFacultyId(rs.getInt(4));
						edform.setToStudentId(rs.getInt(5));
						v.add(edform);
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
			public EmailDetailsForm ViewEmailDetailsById(String storepath,int StudentExamId)
			{   EmailDetailsForm edform=new EmailDetailsForm();
				java.sql.Connection con=null;
				 
				try
				{
					 
					con=getConnection();
					 
					PreparedStatement ps=con.prepareStatement("select * from EmailDetails where EmailId = ? ");
					ps.setInt(1,StudentExamId);
					ResultSet rs=ps.executeQuery();
					 
					if(rs.next())
					{
						edform=new EmailDetailsForm();
						
						edform.setEmailId(rs.getInt(1));
						edform.setFromstudentId(rs.getInt(2));
						edform.setToFacultyId(rs.getInt(3));
						edform.setFromFacultyId(rs.getInt(4));
						edform.setToStudentId(rs.getInt(5));
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
				return edform;
				
				
			}

			public boolean deleteEmailDetails(int StudentExamId)
				{
					java.sql.Connection con=null;
					boolean flag=false;
					try
					{
						con=getConnection();						 
						PreparedStatement ps=con.prepareStatement("delete from EmailDetails where EmailId = ? ");
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

			public boolean UpdateEmailDetails(EmailDetailsForm edform)
			{
				java.sql.Connection con=null;
				boolean flag=false;
				try
				{
				 
				con=getConnection();
				PreparedStatement ps=con.prepareStatement("update EmailDetails set FROMSTUDENTID = ?,TOFACULTYID = ?,FROMFACULTYID   = ?,TOSTUDENTID = ? where EmailId = ? ");
				ps.setInt(5,edform.getEmailId());
				ps.setInt(1,edform.getFromstudentId());
				ps.setInt(2,edform.getToFacultyId());
				ps.setInt(3,edform.getFromFacultyId());
				ps.setInt(4,edform.getToStudentId());
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






			 


			 





			 


			  

			

		 

		 

	 













 
