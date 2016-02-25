 
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
import com.yourcompany.struts.form.ExamQuestionMasterForm;
import com.yourcompany.struts.form.ExaminationScheduleForm;

			public class ExamQuestionsMasterDao extends AbstractDataAccessObject 
			{
				public boolean insertExamQuestionsMaster(ExamQuestionMasterForm eqform)
				{
					java.sql.Connection con=null;
					boolean flag=false;
					try
					{
					int n=getSequenceID("ExamQuestionMaster","QuestionId");
					con=getConnection();
					PreparedStatement ps=con.prepareStatement("insert into ExamQuestionMaster values(?,?,?,?,?,?,?,?,?,?)");
					ps.setInt(1,n);
					ps.setString(2,eqform.getQuestionText());
					ps.setString(3,eqform.getAnswer1());
					ps.setString(4,eqform.getAnswer2());
					ps.setString(5,eqform.getAnswer3());
					ps.setString(6,eqform.getAnswer4());
					ps.setString(7,eqform.getAnswer5());
					ps.setString(8,eqform.getCorrectAnswer());
					ps.setInt(9,eqform.getExaminationId());
					ps.setInt(10,eqform.getMarks());
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

			public CoreList ViewExamQuestionMaster(int examid)
			{   CoreList v=new CoreList();
				java.sql.Connection con=null;
				ExamQuestionMasterForm eqform=null;
				try
				{
					con=getConnection();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select q.QUESTIONID,q.QUESTIONTEXT,q.ANSWER1,q.ANSWER2,q.ANSWER3,q.ANSWER4,q.ANSWER5,q.CORRECTANSWER,e.EXAMINATIONDATE,q.MARKS from ExamQuestionMaster q,examinationschedule e where q.EXAMINATIONID = e.EXAMINATIONID and q.examinationid="+examid);
					 
					while(rs.next())
					{
						eqform=new ExamQuestionMasterForm();
						eqform.setQuestionId(rs.getInt(1));
						eqform.setQuestionText(rs.getString(2));
						eqform.setAnswer1(rs.getString(3));
						eqform.setAnswer2(rs.getString(4));
						eqform.setAnswer3(rs.getString(5));
						eqform.setAnswer4(rs.getString(6));
						eqform.setAnswer5(rs.getString(7));
						eqform.setCorrectAnswer(rs.getString(8));
						eqform.setExamDate(DateWrapper.parseDate(rs.getDate(9)));
						eqform.setMarks(rs.getInt(10));
						v.add(eqform);
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
			public CoreList ViewExamQuestionsMaster(int examid)
			{   CoreList v=new CoreList();
				java.sql.Connection con=null;
				ExamQuestionMasterForm eqform=null;
				try
				{
					con=getConnection();
					System.out.println("examid"+examid);
					//System.out.println("questionid"+questionid);
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select q.QUESTIONID,q.QUESTIONTEXT,q.ANSWER1,q.ANSWER2,q.ANSWER3,q.ANSWER4,q.ANSWER5,q.CORRECTANSWER,e.EXAMINATIONDATE,q.MARKS from ExamQuestionMaster q,examinationschedule e where q.EXAMINATIONID = e.EXAMINATIONID and q.examinationid="+examid);
					System.out.println("asdfasdfasdf");
					while(rs.next())
					{
						eqform=new ExamQuestionMasterForm();
						eqform.setQuestionId(rs.getInt(1));
						eqform.setQuestionText(rs.getString(2));
						eqform.setAnswer1(rs.getString(3));
						eqform.setAnswer2(rs.getString(4));
						eqform.setAnswer3(rs.getString(5));
						eqform.setAnswer4(rs.getString(6));
						eqform.setAnswer5(rs.getString(7));
						eqform.setCorrectAnswer(rs.getString(8));
						eqform.setExamDate(DateWrapper.parseDate(rs.getDate(9)));
						eqform.setMarks(rs.getInt(10));
						v.add(eqform);
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

			public ExamQuestionMasterForm ViewExamQuestionMasterById(int QuestionId)
			{   ExamQuestionMasterForm eqform=new ExamQuestionMasterForm();
				java.sql.Connection con=null;
				 
				try
				{
					 
					con=getConnection();
					 
					PreparedStatement ps=con.prepareStatement("select * from ExamQuestionMaster where QuestionId = ? ");
					ps.setInt(1,QuestionId);
					ResultSet rs=ps.executeQuery();
					 
					if(rs.next())
					{
						eqform=new ExamQuestionMasterForm();
						eqform.setQuestionId(rs.getInt(1));
						eqform.setQuestionText(rs.getString(2));
						eqform.setAnswer1(rs.getString(3));
						eqform.setAnswer2(rs.getString(4));
						eqform.setAnswer3(rs.getString(5));
						eqform.setAnswer4(rs.getString(6));
						eqform.setAnswer5(rs.getString(7));
						eqform.setCorrectAnswer(rs.getString(8));
						eqform.setExaminationId(rs.getInt(9));
						eqform.setMarks(rs.getInt(10));
						 
						 
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
				return eqform;
				
				
			}

			public boolean deleteExamQuestionMaster(int QuestionId)
				{
					java.sql.Connection con=null;
					boolean flag=false;
					try
					{
						 
						con=getConnection();
						 
						PreparedStatement ps=con.prepareStatement("delete from ExamQuestionMaster where QuestionId = ? ");
						ps.setInt(1,QuestionId);
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

			public boolean UpdateExamQuestionMaster(ExamQuestionMasterForm eqform)
			{
				java.sql.Connection con=null;
				boolean flag=false;
				try
				{
				 
				con=getConnection();
				PreparedStatement ps=con.prepareStatement("update ExamQuestionMaster set QUESTIONTEXT = ?, ANSWER1 = ?,ANSWER2 = ?, ANSWER3 = ?,ANSWER4 = ?,ANSWER5 = ?,CORRECTANSWER = ?, MARKS = ? where QuestionId = ? ");
				ps.setInt(10,eqform.getQuestionId());
				ps.setString(1,eqform.getQuestionText());
				ps.setString(2,eqform.getAnswer1());
				ps.setString(3,eqform.getAnswer2());
				ps.setString(4,eqform.getAnswer3());
				ps.setString(5,eqform.getAnswer4());
				ps.setString(6,eqform.getAnswer5());
				ps.setString(7,eqform.getCorrectAnswer());
				ps.setInt(8,eqform.getMarks());
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
			
			public CoreList viewQuestions(int facultyid)
			{
				CoreList acorelist=new CoreList();
			Connection con=null;
			ExaminationScheduleForm aform=null;
			try{
				con=getConnection();
				PreparedStatement pst=con.prepareStatement("select Examinationid,examdesc from examinationschedule where facultyid="+facultyid);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				aform=new ExaminationScheduleForm();
				aform.setExaminationId(rs.getInt(1));
				aform.setExamname(rs.getString(2));
				acorelist.add(aform);
			}
			}catch (Exception e) {
				// TODO: handle exception
			}
			return acorelist;
			}
			public String getAnswer(int examid,int questionid)
			{
				Connection con=null;
				String correctanswer="";
				try{
					
					con=getConnection();
					PreparedStatement pst=con.prepareStatement("select correctanswer from examquestionmaster where examinationid=? and questionid=?");
				pst.setInt(1,examid);
				pst.setInt(2,questionid);
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					correctanswer=rs.getString(1);
				}
				}catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
				return correctanswer;
			}
			public float getResult(int examid)
			{
				Connection con=null;
				float correctanswer=0;
				try{
					
					con=getConnection();
					PreparedStatement pst=con.prepareStatement("select PASSPERCENTAGEDECIDED from ExaminationSchedule where examinationid=? ");
				pst.setInt(1,examid);
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					correctanswer=rs.getInt(1);
				}
				}catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
				return correctanswer;
			}

			}






			 


			 





			 


			  

			

		 

		 

	 


 
