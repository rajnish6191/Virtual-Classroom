 
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
		import com.yourcompany.struts.form.AssignmentRemarksForm;

			public class AssignmentRemarksDao extends AbstractDataAccessObject 
			{
				public boolean insertAssignmentRemarks(AssignmentRemarksForm arform)
				{
					java.sql.Connection con=null;
					boolean flag=false;
					try
					{
					con=getConnection();
					PreparedStatement ps=con.prepareStatement("insert into AssignmentRemarks values(?,?,?)");
					ps.setInt(1,arform.getAssignmentId());
					ps.setInt(2,arform.getFacultyId());
					ps.setString(3,arform.getRemarksToStudent());
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

			public CoreList ViewAssignmentRemarks()
			{   CoreList v=new CoreList();
				java.sql.Connection con=null;
				AssignmentRemarksForm arform=null;
				try
				{
					con=getConnection();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select a.ASSIGNMENTID,s.SUBMISSIONDATE,f.fname,a.REMARKSTOSTUDENT from AssignmentRemarks a,STUDENTASSIGNSUBMISSIONMASTER s,FacultyMaster f where a.ASSIGNMENTID =s. ASSIGNMENTID and a.FACULTYID = f.FACULTYID");
					 
					while(rs.next())
					{
						arform=new AssignmentRemarksForm();
					
						arform.setAssignmentId(rs.getInt(1));
						arform.setSubmissionDate(DateWrapper.parseDate(rs.getDate(2)));
						arform.setFname(rs.getString(3));
						arform.setRemarksToStudent(rs.getString(4));
						v.add(arform);
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
			public CoreList ViewAssignmentRemarks(int assignmentid)
			{   CoreList v=new CoreList();
				java.sql.Connection con=null;
				AssignmentRemarksForm arform=null;
				try
				{
					con=getConnection();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select a.ASSIGNMENTID,s.SUBMISSIONDATE,f.fname,a.REMARKSTOSTUDENT from AssignmentRemarks a,STUDENTASSIGNSUBMISSIONMASTER s,FacultyMaster f where a.ASSIGNMENTID =s. ASSIGNMENTID and a.FACULTYID = f.FACULTYID and a.assignmentid="+assignmentid);
					 
					while(rs.next())
					{
						arform=new AssignmentRemarksForm();
					
						arform.setAssignmentId(rs.getInt(1));
						arform.setSubmissionDate(DateWrapper.parseDate(rs.getDate(2)));
						arform.setFname(rs.getString(3));
						arform.setRemarksToStudent(rs.getString(4));
						v.add(arform);
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

			public AssignmentRemarksForm ViewAssignmentRemarksById(int StudentExamId)
			{   AssignmentRemarksForm arform=new AssignmentRemarksForm();
				java.sql.Connection con=null;
				 
				try
				{
					 
					con=getConnection();
					 
					PreparedStatement ps=con.prepareStatement("select * from AssignmentRemarks where ASSIGNMENTID = ? ");
					ps.setInt(1,StudentExamId);
					ResultSet rs=ps.executeQuery();
					 
					if(rs.next())
					{
						arform=new AssignmentRemarksForm();
						
						arform.setAssignmentId(rs.getInt(1));
						arform.setFacultyId(rs.getInt(2));
						arform.setRemarksToStudent(rs.getString(3));
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
				return arform;
				
				
			}

			public boolean deleteAssignmentRemarks(int StudentExamId)
				{
					java.sql.Connection con=null;
					boolean flag=false;
					try
					{
						con=getConnection();						 
						PreparedStatement ps=con.prepareStatement("delete from AssignmentRemarks where ASSIGNMENTID = ? ");
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

			public boolean UpdateAssignmentRemarks(AssignmentRemarksForm arform)
			{
				java.sql.Connection con=null;
				boolean flag=false;
				try
				{
				 
				con=getConnection();
				PreparedStatement ps=con.prepareStatement("update AssignmentRemarks set STUDENTID = ?,REMARKSTOSTUDENT = ? where ASSIGNMENTID = ? ");
				ps.setInt(3,arform.getAssignmentId());
				ps.setInt(1,arform.getFacultyId());
				ps.setString(2,arform.getRemarksToStudent());
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






			 


			 





			 


			  

			

		 

		 

	 











 
