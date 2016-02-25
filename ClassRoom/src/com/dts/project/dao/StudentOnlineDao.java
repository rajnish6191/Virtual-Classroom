 
 
	 
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
		import com.yourcompany.struts.form.StudentOnlineForm;

			public class StudentOnlineDao extends AbstractDataAccessObject 
			{
				public boolean insertStudentOnline(StudentOnlineForm soform)
				{
					java.sql.Connection con=null;
					int n=getSequenceID("StudentOnline","OnlineId");
					boolean flag=false;
					try
					{
					con=getConnection();
					PreparedStatement ps=con.prepareStatement("insert into StudentOnline values(?,?,?)");
					ps.setInt(1,n);
					ps.setString(2,DateWrapper.parseDate(soform.getOnlineDateAndTime()));
					ps.setInt(3,soform.getStudentId());
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

			public CoreList ViewStudentOnline()
			{   CoreList v=new CoreList();
				java.sql.Connection con=null;
				StudentOnlineForm soform=null;
				try
				{
					con=getConnection();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select o.ONLINEID,o.ONLINEDATEANDTIME,s.STUDENTFIRSTNAME from StudentOnline o,studentmaster s where s.studentid = o.studentid");
					 
					while(rs.next())
					{
						soform=new StudentOnlineForm();
					
						soform.setOnlineId(rs.getInt(1));
						soform.setOnlineDateAndTime(DateWrapper.parseDate(rs.getDate(2)));
						soform.setStudentName(rs.getString(3));
						v.add(soform);
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
			public StudentOnlineForm ViewStudentOnlineById(int StudentExamId)
			{   StudentOnlineForm soform=new StudentOnlineForm();
				java.sql.Connection con=null;
				 
				try
				{
					 
					con=getConnection();
					 
					PreparedStatement ps=con.prepareStatement("select * from StudentOnline where OnlineId = ? ");
					ps.setInt(1,StudentExamId);
					ResultSet rs=ps.executeQuery();
					 
					if(rs.next())
					{
						soform=new StudentOnlineForm();
						
						soform.setOnlineId(rs.getInt(1));
						soform.setOnlineDateAndTime(DateWrapper.parseDate(rs.getDate(2)));
						soform.setStudentId(rs.getInt(3));
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
				return soform;
				
				
			}

			public boolean deleteStudentOnline(int StudentExamId)
				{
					java.sql.Connection con=null;
					boolean flag=false;
					try
					{
						con=getConnection();						 
						PreparedStatement ps=con.prepareStatement("delete from StudentOnline where OnlineId = ? ");
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

			public boolean UpdateStudentOnline(StudentOnlineForm soform)
			{
				java.sql.Connection con=null;
				boolean flag=false;
				try
				{
				 
				con=getConnection();
				PreparedStatement ps=con.prepareStatement("update StudentOnline set   ONLINEDATEANDTIME = ?,STUDENTID = ? where OnlineId = ? ");
				ps.setInt(3,soform.getOnlineId());
				ps.setString(1,DateWrapper.parseDate(soform.getOnlineDateAndTime()));
				ps.setInt(2,soform.getStudentId());
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






			 


			 





			 


			  

			

		 

		 

	 














 
