 
	 package com.dts.project.dao;
		 
		import java.sql.*; 

			import com.dts.core.dao.AbstractDataAccessObject;
			import com.dts.core.util.CoreList;
			import com.dts.core.util.DateWrapper;
			import com.dts.core.util.LoggerManager;
		import com.yourcompany.struts.form.StudentExaminationMasterForm;

			public class StudentExaminationMasterDao extends AbstractDataAccessObject 
			{
				public boolean insertStudentExaminationMaster(StudentExaminationMasterForm seform)
				{
					java.sql.Connection con=null;
					boolean flag=false;
					try
					{
					//int n=getSequenceID("StudentExaminationMaster","StudentExamId");
					con=getConnection();
					PreparedStatement ps=con.prepareStatement("insert into StudentExaminationMaster values(?,?,?,?,?,?)");
					ps.setInt(1,seform.getStudentExamId());
					ps.setString(2,DateWrapper.parseDate(seform.getExamAttendedDateTime()));
					ps.setInt(3,seform.getExaminationId());
					ps.setString(4,seform.getExamResult());
					ps.setFloat(5,seform.getExamAggregade());
					ps.setInt(6,seform.getStudentId());
					
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

			public CoreList ViewStudentExaminationMaster()
			{   CoreList v=new CoreList();
				java.sql.Connection con=null;
				StudentExaminationMasterForm seform=null;
				try
				{
					con=getConnection();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select se.STUDENTEXAMID,se.EXAMATTENDEDDATETIME,e.EXAMINATIONDATE,se.EXAMRESULT,se.EXAMAGGREGADE,s.STUDENTFIRSTNAME from StudentExaminationMaster se,EXAMINATIONSCHEDULE e,studentmaster s where se.EXAMINATIONID = e.EXAMINATIONID and se.STUDENTID = s.STUDENTID");
					 
					while(rs.next())
					{
						seform=new StudentExaminationMasterForm();
						 
						seform.setStudentExamId(rs.getInt(1));
						seform.setExamAttendedDateTime(DateWrapper.parseDate(rs.getDate(2)));
						seform.setExaminatiodate(DateWrapper.parseDate(rs.getDate(3)));
						seform.setExamResult(rs.getString(4));
						seform.setExamAggregade(rs.getInt(5));
						seform.setStudentName(rs.getString(6));
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
			public StudentExaminationMasterForm ViewStudentExaminationMasterById(int StudentExamId)
			{   StudentExaminationMasterForm seform=new StudentExaminationMasterForm();
				java.sql.Connection con=null;
				 
				try
				{
					 
					con=getConnection();
					 
					PreparedStatement ps=con.prepareStatement("select * from StudentExaminationMaster where StudentExamId = ? ");
					ps.setInt(1,StudentExamId);
					ResultSet rs=ps.executeQuery();
					 
					if(rs.next())
					{
						seform=new StudentExaminationMasterForm();
						 
						seform.setStudentExamId(rs.getInt(1));
						seform.setExamAttendedDateTime(DateWrapper.parseDate(rs.getDate(2)));
						seform.setExaminationId(rs.getInt(3));
						seform.setExamResult(rs.getString(4));
						seform.setExamAggregade(rs.getInt(5));
						seform.setStudentId(rs.getInt(6));
						 
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

			public boolean deleteStudentExaminationMaster(int StudentExamId)
				{
					java.sql.Connection con=null;
					boolean flag=false;
					try
					{
						 
						con=getConnection();
						 
						PreparedStatement ps=con.prepareStatement("delete from StudentExaminationMaster where StudentExamId = ? ");
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

			public boolean UpdateStudentExaminationMaster(StudentExaminationMasterForm seform)
			{
				java.sql.Connection con=null;
				boolean flag=false;
				try
				{
				 
				con=getConnection();
				PreparedStatement ps=con.prepareStatement("update StudentExaminationMaster set EXAMRESULT = ?,EXAMAGGREGADE = ? where StudentExamId = ? ");
				ps.setInt(3,seform.getStudentExamId());
				ps.setString(1,seform.getExamResult());
				ps.setFloat(2,seform.getExamAggregade());
				
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
			public CoreList ViewStudentExaminationDetails(int studentid)
			{   CoreList v=new CoreList();
				java.sql.Connection con=null;
				StudentExaminationMasterForm seform=null;
				try
				{
					con=getConnection();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select se.STUDENTEXAMID,se.EXAMATTENDEDDATETIME,e.EXAMINATIONDATE,se.EXAMRESULT,se.EXAMAGGREGADE,s.loginid from StudentExaminationMaster se,EXAMINATIONSCHEDULE e,userdetails s where se.EXAMINATIONID = e.EXAMINATIONID and se.STUDENTID = s.userid and s.userid="+studentid);
					 
					while(rs.next())
					{
						seform=new StudentExaminationMasterForm();
						 
						seform.setStudentExamId(rs.getInt(1));
						seform.setExamAttendedDateTime(DateWrapper.parseDate(rs.getDate(2)));
						seform.setExaminatiodate(DateWrapper.parseDate(rs.getDate(3)));
						seform.setExamResult(rs.getString(4));
						seform.setExamAggregade(rs.getInt(5));
						seform.setStudentName(rs.getString(6));
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
			
			}






			 


			 





			 


			  

			

		 

		 


	 


	 



 
