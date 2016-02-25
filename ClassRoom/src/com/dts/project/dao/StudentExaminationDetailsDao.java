 
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
		import com.yourcompany.struts.form.StudentExaminationDetailsForm;

			public class StudentExaminationDetailsDao extends AbstractDataAccessObject 
			{
				public boolean insertStudentExaminationDetails(StudentExaminationDetailsForm seform)
				{
					java.sql.Connection con=null;
					boolean flag=false;
					try
					{
					con=getConnection();
					PreparedStatement ps=con.prepareStatement("insert into STUDENTEXMAINATIONDETAILS values(?,?,?,?)");
					ps.setInt(1,seform.getStudentExamId());
					ps.setInt(2,seform.getQuestionId());
					ps.setString(3,seform.getAnswer());
					ps.setString(4,seform.getCorrect_wrong());
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

			public CoreList ViewStudentExaminationDetails()
			{   CoreList v=new CoreList();
				java.sql.Connection con=null;
				StudentExaminationDetailsForm seform=null;
				try
				{
					con=getConnection();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select d.STUDENTEXMAINATIONID,s.EXAMATTENDEDDATETIME,q.QUESTIONTEXT,d.ANSWER,d.CORRECT_WRONG from STUDENTEXMAINATIONDETAILS d,EXAMQUESTIONMASTER q,STUDENTEXAMINATIONMASTER s where d.STUDENTEXMAINATIONID = s.STUDENTEXAMID and d.QUESTIONID = q.QUESTIONID");
					 
					while(rs.next())
					{
						seform=new StudentExaminationDetailsForm();
						seform.setStudentExamId(rs.getInt(1));
						seform.setExamAttendedDateTime(DateWrapper.parseDate(rs.getDate(2)));
						seform.setQuestionText(rs.getString(3));
						seform.setAnswer(rs.getString(4));
						seform.setCorrect_wrong(rs.getString(5));
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
			public StudentExaminationDetailsForm ViewStudentExaminationDetailsById(int StudentExamId)
			{   StudentExaminationDetailsForm seform=new StudentExaminationDetailsForm();
				java.sql.Connection con=null;
				 
				try
				{
					 
					con=getConnection();
					 
					PreparedStatement ps=con.prepareStatement("select * from STUDENTEXMAINATIONDETAILS where STUDENTEXMAINATIONID = ? ");
					ps.setInt(1,StudentExamId);
					ResultSet rs=ps.executeQuery();
					 
					if(rs.next())
					{
						seform=new StudentExaminationDetailsForm();
						
						seform.setStudentExamId(rs.getInt(1));
						seform.setQuestionId(rs.getInt(2));
						seform.setAnswer(rs.getString(3));
						seform.setCorrect_wrong(rs.getString(4));
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

			public boolean deleteStudentExaminationDetails(int StudentExamId)
				{
					java.sql.Connection con=null;
					boolean flag=false;
					try
					{
						con=getConnection();						 
						PreparedStatement ps=con.prepareStatement("delete from STUDENTEXMAINATIONDETAILS where STUDENTEXMAINATIONID = ? ");
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

			public boolean UpdateStudentExaminationDetails(StudentExaminationDetailsForm seform)
			{
				java.sql.Connection con=null;
				boolean flag=false;
				try
				{
				 
				con=getConnection();
				PreparedStatement ps=con.prepareStatement("update STUDENTEXMAINATIONDETAILS set QUESTIONID = ?,ANSWER = ?,CORRECT_WRONG = ? where STUDENTEXMAINATIONID = ? ");
				ps.setInt(4,seform.getStudentExamId());
				ps.setInt(1,seform.getQuestionId());
				ps.setString(2,seform.getAnswer());
				ps.setString(3,seform.getCorrect_wrong());
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
			public float getcount(int examid)
			{
				Connection con=null;
				float count=0;
				
				try{
					con=getConnection();
					PreparedStatement pst=con.prepareStatement("select count(*) from STUDENTEXMAINATIONDETAILs where correct_wrong='yes' and STUDENTEXMAINATIONID="+examid);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				count=rs.getFloat(1);
			System.out.println("count"+count);
			}
				}catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
				return count;
			}
			}






			 


			 





			 


			  

			

		 

		 

	 








 
