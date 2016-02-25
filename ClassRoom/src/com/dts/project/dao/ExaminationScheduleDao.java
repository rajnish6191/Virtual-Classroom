 
	 package com.dts.project.dao;
		 
		import java.sql.*; 

			import com.dts.core.dao.AbstractDataAccessObject;
			import com.dts.core.util.CoreList;
			import com.dts.core.util.DateWrapper;
			import com.dts.core.util.LoggerManager;
		import com.yourcompany.struts.form.ExaminationScheduleForm;

			public class ExaminationScheduleDao extends AbstractDataAccessObject 
			{
				public int  insertExaminationSchedule(ExaminationScheduleForm esform)
				{
					java.sql.Connection con=null;
					int examid=0;
					boolean flag = false;
					try
					{
					int n=getSequenceID("ExaminationSchedule","ExaminationId");
					con=getConnection();
					PreparedStatement ps=con.prepareStatement("insert into ExaminationSchedule values(?,?,?,?,?,?,?,?,?)");
					ps.setInt(1,n);
					ps.setString(2,DateWrapper.parseDate(esform.getExaminationDate()));
					ps.setString(3,DateWrapper.parseDate(esform.getExaminationDate()));
					ps.setInt(4,esform.getCourseId());
					ps.setInt(5,esform.getLecturerId());
					ps.setInt(6,esform.getFacultyId());
					ps.setInt(7,esform.getPassPercentageDecided());
					ps.setString(8,esform.getExamname());
					ps.setInt(9,esform.getNoofquestions());
					int i=ps.executeUpdate();
					if(i>0)
						examid=n;
					 
						
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
				return examid;
				
				
					}

			public CoreList ViewExaminationSchedule()
			{   CoreList v=new CoreList();
				java.sql.Connection con=null;
				ExaminationScheduleForm esform=null;
				try
				{
					con=getConnection();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select e.EXAMINATIONID,e.EXAMINATIONDATE,e.EXAMINATIONENDDATE,c.CNAME,l.LECTURERDATE,f.FNAME,e.PASSPERCENTAGEDECIDED from ExaminationSchedule e,facultymaster f,coursemaster c,courselecturermaster l where e.courseid = c.courseid and l.LECTURERID = e.LECTURERID and f.facultyid = e.FACULTYID");
					 
					while(rs.next())
					{
						esform=new ExaminationScheduleForm();
						 
						esform.setExaminationId(rs.getInt(1));
						esform.setExaminationDate(DateWrapper.parseDate(rs.getDate(2)));
						esform.setExaminationEndDate(DateWrapper.parseDate(rs.getDate(3)));
						esform.setCname(rs.getString(4));
						esform.setLectureDate(DateWrapper.parseDate(rs.getDate(5)));
						esform.setFname(rs.getString(6));
						esform.setPassPercentageDecided(rs.getInt(7));
						v.add(esform);
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
			public ExaminationScheduleForm ViewExaminationScheduleById(int ExaminationId)
			{   ExaminationScheduleForm esform=new ExaminationScheduleForm();
				java.sql.Connection con=null;
				 
				try
				{
					 
					con=getConnection();
					 
					PreparedStatement ps=con.prepareStatement("select * from ExaminationSchedule where ExaminationId = ? ");
					ps.setInt(1,ExaminationId);
					ResultSet rs=ps.executeQuery();
					 
					if(rs.next())
					{
						esform=new ExaminationScheduleForm();
						 
						esform.setExaminationId(rs.getInt(1));
						esform.setExaminationDate(DateWrapper.parseDate(rs.getDate(2)));
						esform.setExaminationEndDate(DateWrapper.parseDate(rs.getDate(3)));
						esform.setCourseId(rs.getInt(4));
						esform.setLecturerId(rs.getInt(5));
						esform.setLecturerId(rs.getInt(6));
						esform.setPassPercentageDecided(rs.getInt(7));
						 
						 
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
				return esform;
				
				
			}

			public boolean deleteExaminationSchedule(int ExaminationId)
				{
					java.sql.Connection con=null;
					boolean flag=false;
					try
					{
						 
						con=getConnection();
						 
						PreparedStatement ps=con.prepareStatement("delete from ExaminationSchedule where ExaminationId = ? ");
						ps.setInt(1,ExaminationId);
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

			public boolean UpdateExaminationSchedule(ExaminationScheduleForm esform)
			{
				java.sql.Connection con=null;
				boolean flag=false;
				try
				{
				 
				con=getConnection();
				PreparedStatement ps=con.prepareStatement("update ExaminationSchedule set EXAMINATIONDATE = ?,EXAMINATIONENDDATE = ?,COURSEID = ?,LECTURERID = ?,FACULTYID = ?,PASSPERCENTAGEDECIDED = ? where ExaminationId = ? ");
				ps.setInt(7,esform.getExaminationId());
				ps.setString(1,DateWrapper.parseDate(esform.getExaminationDate()));
				ps.setString(2,DateWrapper.parseDate(esform.getExaminationEndDate()));
				ps.setInt(3,esform.getCourseId());
				ps.setInt(4,esform.getLecturerId());
				ps.setInt(5,esform.getFacultyId());
				ps.setInt(6,esform.getPassPercentageDecided());
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
			
			public int noofquestiong(int examid)
			{
				int noofquestions=0;
				Connection con=null;
				try{
					con=getConnection();
					PreparedStatement pst=con.prepareStatement("Select noofquestions from EXAMINATIONSCHEDULE where examinationid="+examid);
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					noofquestions=rs.getInt(1);
				
				}
				}catch (Exception e) {
					// TODO: handle exception
				}return noofquestions;
				}
			public int countquestions(int examid)
			{
				int noofquestions=0;
				Connection con=null;
				try{
					con=getConnection();
					PreparedStatement pst=con.prepareStatement("Select count(*) from examquestionmaster where examinationid="+examid);
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					noofquestions=rs.getInt(1);
				}
				}catch (Exception e) {
					// TODO: handle exception
				}return noofquestions;
				}
			
			public CoreList ViewExaminationSchedule(int courseid,int facultyid,int lectureid)
			{   CoreList v=new CoreList();
				java.sql.Connection con=null;
				ExaminationScheduleForm esform=null;
				try
				{
					con=getConnection();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select e.EXAMINATIONID,e.EXAMINATIONDATE,e.examdesc,c.CNAME,l.LECTURERDATE,f.FNAME,e.PASSPERCENTAGEDECIDED,e.noofquestions from ExaminationSchedule e,facultymaster f,coursemaster c,courselecturermaster l where e.courseid = c.courseid and l.LECTURERID = e.LECTURERID and f.facultyid = e.FACULTYID and e.facultyid="+facultyid+" and e.courseid="+courseid+" and e.LECTURERID="+lectureid);
					 
					while(rs.next())
					{
						esform=new ExaminationScheduleForm();
						 
						esform.setExaminationId(rs.getInt(1));
						esform.setExaminationDate(DateWrapper.parseDate(rs.getDate(2)));
						esform.setExaminationEndDate(rs.getString(3));
						esform.setCname(rs.getString(4));
						esform.setLectureDate(DateWrapper.parseDate(rs.getDate(5)));
						esform.setFname(rs.getString(6));
						esform.setPassPercentageDecided(rs.getInt(7));
						esform.setNoofquestions(rs.getInt(8));
						v.add(esform);
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






			 


			 





			 


			  

			

		 

		 


	 


	 

 