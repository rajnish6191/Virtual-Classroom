 
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
import com.yourcompany.struts.form.StudentAssignSubmissionMasterForm;

			public class StudentAssignSubmissionMasterDao extends AbstractDataAccessObject 
			{
				public boolean insertStudentAssignSubmissionMaster(StudentAssignSubmissionMasterForm saform)
				{
					java.sql.Connection con=null;
					boolean flag=false;
					
					try
					{
						System.out.println("student Id"+saform.getStudentId());
						System.out.println("Lecturer Id"+saform.getLecturerId());
					 
						int n=getSequenceID("StudentAssignSubmissionMaster","AssignmentId");
					con=getConnection();
					PreparedStatement ps=con.prepareStatement("insert into StudentAssignSubmissionMaster values(?,?,?,?,?)");
					ps.setInt(1,n);
					ps.setInt(2,saform.getStudentId());
					ps.setString(3,DateWrapper.parseDate(new java.util.Date()));
					
					ps.setInt(4,saform.getLecturerId());
					File afile=new File(saform.getSubmissionFile());
			        FileInputStream fs=new FileInputStream(afile);
			        ps.setBinaryStream(5,fs,(int)afile.length());			
					
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

			public CoreList ViewStudentAssignSubmissionMaster(String storepath)
			{   CoreList v=new CoreList();
				java.sql.Connection con=null;
				StudentAssignSubmissionMasterForm saform=null;
				try
				{
					con=getConnection();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select a.ASSIGNMENTID,s.STUDENTFIRSTNAME,a.SUBMISSIONDATE,l.LECTURERDATE,a.SUBMISSIONFILE from STUDENTASSIGNSUBMISSIONMASTER a,STUDENTMASTER s,COURSELECTURERMASTER l where a.studentid = s.studentid and l.lecturerid = a.lecturerid");
					 
					while(rs.next())
					{
						saform=new StudentAssignSubmissionMasterForm();
						int id=rs.getInt(1); 
						saform.setAssignmentId(rs.getInt(1));
						
						saform.setStudentName(rs.getString(2));
						saform.setSubmissionDate(DateWrapper.parseDate(rs.getDate(3)));
						saform.setLecturDate(DateWrapper.parseDate(rs.getDate(4)));
						Blob b=rs.getBlob(5);
						byte b1[]=b.getBytes(1,(int)b.length()); 
						OutputStream fout=new FileOutputStream(storepath+"/"+id+".doc");
						fout.write(b1);
						saform.setSubmissionFile(id+".doc");		
						v.add(saform);
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
			public CoreList ViewAssignSubmissionMaster(String storepath,int studentid)
			{   CoreList v=new CoreList();
				java.sql.Connection con=null;
				StudentAssignSubmissionMasterForm saform=null;
				try
				{
					con=getConnection();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select a.ASSIGNMENTID,s.loginid,a.SUBMISSIONDATE,l.LECTURERDATE,a.SUBMISSIONFILE from STUDENTASSIGNSUBMISSIONMASTER a,userdetails s,COURSELECTURERMASTER l where a.studentid = s.userid and l.lecturerid = a.lecturerid and a.studentid="+studentid);
					 
					while(rs.next())
					{
						saform=new StudentAssignSubmissionMasterForm();
						int id=rs.getInt(1); 
						saform.setAssignmentId(rs.getInt(1));
						
						saform.setStudentName(rs.getString(2));
						saform.setSubmissionDate(DateWrapper.parseDate(rs.getDate(3)));
						saform.setLecturDate(DateWrapper.parseDate(rs.getDate(4)));
						Blob b=rs.getBlob(5);
						byte b1[]=b.getBytes(1,(int)b.length()); 
						OutputStream fout=new FileOutputStream(storepath+"/"+id+".doc");
						fout.write(b1);
						saform.setSubmissionFile(id+".doc");		
						v.add(saform);
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

			public CoreList ViewFacultyAssignments(String storepath,int facultyid)
			{   CoreList v=new CoreList();
				java.sql.Connection con=null;
				StudentAssignSubmissionMasterForm saform=null;
				try
				{
					con=getConnection();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select a.ASSIGNMENTID,s.loginid,a.SUBMISSIONDATE,l.LECTURERDATE,a.SUBMISSIONFILE from STUDENTASSIGNSUBMISSIONMASTER a,userdetails s,COURSELECTURERMASTER l where a.studentid = s.userid and l.lecturerid = a.lecturerid and a.lecturerid in (select lecturerid from courselecturermaster where facultyid="+facultyid+")");
					 
					while(rs.next())
					{
						saform=new StudentAssignSubmissionMasterForm();
						int id=rs.getInt(1); 
						saform.setAssignmentId(rs.getInt(1));
						
						saform.setStudentName(rs.getString(2));
						saform.setSubmissionDate(DateWrapper.parseDate(rs.getDate(3)));
						saform.setLecturDate(DateWrapper.parseDate(rs.getDate(4)));
						Blob b=rs.getBlob(5);
						byte b1[]=b.getBytes(1,(int)b.length()); 
						OutputStream fout=new FileOutputStream(storepath+"/"+id+".doc");
						fout.write(b1);
						saform.setSubmissionFile(id+".doc");		
						v.add(saform);
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

			public StudentAssignSubmissionMasterForm ViewStudentAssignSubmissionMasterById(String storepath,int AssignmentId)
			{   StudentAssignSubmissionMasterForm saform=new StudentAssignSubmissionMasterForm();
				java.sql.Connection con=null;
				 
				try
				{
					 
					con=getConnection();
					 
					PreparedStatement ps=con.prepareStatement("select * from StudentAssignSubmissionMaster where AssignmentId = ? ");
					ps.setInt(1,AssignmentId);
					ResultSet rs=ps.executeQuery();
					 
					if(rs.next())
					{
						saform=new StudentAssignSubmissionMasterForm();
						int id=rs.getInt(1); 
						saform.setAssignmentId(rs.getInt(1));
						
						saform.setStudentId(rs.getInt(2));
						saform.setSubmissionDate(DateWrapper.parseDate(rs.getDate(3)));
						saform.setLecturerId(rs.getInt(4));
						Blob b=rs.getBlob(5);
						byte b1[]=b.getBytes(1,(int)b.length()); 
						OutputStream fout=new FileOutputStream(storepath+"/"+id+".doc");
						fout.write(b1);
						saform.setSubmissionFile(id+".doc");		
						 
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
				return saform;
				
				
			}

			public boolean deleteStudentAssignSubmissionMaster(int AssignmentId)
				{
					java.sql.Connection con=null;
					boolean flag=false;
					try
					{
						 
						con=getConnection();
						 
						PreparedStatement ps=con.prepareStatement("delete from StudentAssignSubmissionMaster where AssignmentId = ? ");
						ps.setInt(1,AssignmentId);
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

			public boolean UpdateStudentAssignSubmissionMaster(StudentAssignSubmissionMasterForm saform)
			{
				java.sql.Connection con=null;
				boolean flag=false;
				try
				{
				 
				con=getConnection();
				PreparedStatement ps=con.prepareStatement("update StudentAssignSubmissionMaster set STUDENTID = ?,SUBMISSIONDATE = ?,LECTURERID = ?,SUBMISSIONFILE = ? where AssignmentId = ? ");
				ps.setInt(5,saform.getAssignmentId());
				ps.setInt(1,saform.getStudentId());
				ps.setString(2,DateWrapper.parseDate(saform.getSubmissionDate()));				
				ps.setInt(3,saform.getLecturerId());
				File afile=new File(saform.getSubmissionFile());
		        FileInputStream fs=new FileInputStream(afile);
		        ps.setBinaryStream(4,fs,(int)afile.length());			
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






			 


			 





			 


			  

			

		 

		 


	 


	 






 
