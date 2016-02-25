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
	import com.yourcompany.struts.form.StudentCourseMasterForm;

		public class StudentCourseMasterDao extends AbstractDataAccessObject 
		{
			public boolean insertStudentCourseMaster(StudentCourseMasterForm scform)
			{
				java.sql.Connection con=null;
				boolean flag=false;
				System.out.println("StudentId"+scform.getStudentId());
				System.out.println("CourseId"+scform.getCourseId());
				System.out.println("StudentId"+scform.getFacultyId());
				try
				{
				int n=getSequenceID("StudentCourseMaster","CourseRegId");
				con=getConnection();
				PreparedStatement ps=con.prepareStatement("insert into StudentCourseMaster values(?,?,?,?,?,?)");
				ps.setInt(1,scform.getStudentId());
				ps.setInt(2,scform.getCourseId());
				ps.setInt(3,scform.getFacultyId());
				ps.setInt(4,n);
				ps.setString(5,DateWrapper.parseDate(new java.util.Date()));
				ps.setString(6,DateWrapper.parseDate(scform.getCourseEndDate()));
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

		public CoreList ViewStudentCourseMaster()
		{   CoreList v=new CoreList();
			java.sql.Connection con=null;
			StudentCourseMasterForm scform=null;
			try
			{
				con=getConnection();
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select s.Loginid,c.CNAME,f.FNAME,sc.COURSEREGID,sc.REGDATE,sc.COURSEENDDATE from StudentCourseMaster sc,userdetails s,facultymaster f,coursemaster c where sc.studentid=s.userid and sc.facultyid = f.facultyid and sc.courseid = c.courseid and s.userid=");
				 
				while(rs.next())
				{
					scform=new StudentCourseMasterForm();
					int id=rs.getInt(4);
					scform.setSname(rs.getString(1));
					scform.setCname(rs.getString(2));
					scform.setFname(rs.getString(3));
					scform.setCourseRegId(rs.getInt(4));
					scform.setRegDate(DateWrapper.parseDate(rs.getDate(5)));
					scform.setCourseEndDate(DateWrapper.parseDate(rs.getDate(6)));
					v.add(scform);
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
		public CoreList ViewStudentCourse(int studentid)
		{   CoreList v=new CoreList();
			java.sql.Connection con=null;
			StudentCourseMasterForm scform=null;
			try
			{
				con=getConnection();
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select s.Loginid,c.CNAME,f.FNAME,sc.COURSEREGID,sc.REGDATE,sc.COURSEENDDATE,f.facultyid,sc.courseid from StudentCourseMaster sc,userdetails s,facultymaster f,coursemaster c where sc.studentid=s.userid and sc.facultyid = f.facultyid and sc.courseid = c.courseid and s.userid="+studentid);
				 
				while(rs.next())
				{
					scform=new StudentCourseMasterForm();
					int id=rs.getInt(4);
					scform.setSname(rs.getString(1));
					scform.setCname(rs.getString(2));
					scform.setFname(rs.getString(3));
					scform.setCourseRegId(id);
					scform.setRegDate(DateWrapper.parseDate(rs.getDate(5)));
					scform.setCourseEndDate(DateWrapper.parseDate(rs.getDate(6)));
					scform.setFacultyId(rs.getInt(7));
					scform.setCourseId(rs.getInt(8));
					
					v.add(scform);
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

		public CoreList ViewStudentCourseDetails(int studentid)
		{   CoreList v=new CoreList();
			java.sql.Connection con=null;
			StudentCourseMasterForm scform=null;
			try
			{
				con=getConnection();
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select s.STUDENTFIRSTNAME,c.CNAME,f.FNAME,sc.COURSEREGID,sc.REGDATE,sc.COURSEENDDATE from StudentCourseMaster sc,studentmaster s,facultymaster f,coursemaster c where sc.studentid=s.studentid and sc.facultyid = f.facultyid and sc.courseid = c.courseid and sc.studentid="+studentid);
				 
				while(rs.next())
				{
					scform=new StudentCourseMasterForm();
					int id=rs.getInt(4);
					scform.setSname(rs.getString(1));
					scform.setCname(rs.getString(2));
					scform.setFname(rs.getString(3));
					scform.setCourseRegId(rs.getInt(4));
					scform.setRegDate(DateWrapper.parseDate(rs.getDate(5)));
					scform.setCourseEndDate(DateWrapper.parseDate(rs.getDate(6)));
					v.add(scform);
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

		public StudentCourseMasterForm ViewStudentCourseMasterById(int CourseRegId)
		{   StudentCourseMasterForm scform=new StudentCourseMasterForm();
			java.sql.Connection con=null;
			 
			try
			{
				 
				con=getConnection();
				 
				PreparedStatement ps=con.prepareStatement("select * from StudentCourseMaster where CourseRegId = ? ");
				ps.setInt(1,CourseRegId);
				ResultSet rs=ps.executeQuery();
				 
				if(rs.next())
				{
					scform=new StudentCourseMasterForm();
					int id=rs.getInt(4);
					scform.setStudentId(rs.getInt(1));
					scform.setCourseId(rs.getInt(2));
					scform.setFacultyId(rs.getInt(3));
					scform.setCourseRegId(rs.getInt(4));
					scform.setRegDate(DateWrapper.parseDate(rs.getDate(5)));
					scform.setCourseEndDate(DateWrapper.parseDate(rs.getDate(6)));
					 
					 
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
			return scform;
			
			
		}

		public boolean deleteStudentCourseMaster(int CourseRegId)
			{
				java.sql.Connection con=null;
				boolean flag=false;
				try
				{
					 
					con=getConnection();
					 
					PreparedStatement ps=con.prepareStatement("delete from StudentCourseMaster where CourseRegId = ? ");
					ps.setInt(1,CourseRegId);
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

		public boolean UpdateStudentCourseMaster(StudentCourseMasterForm scform)
		{
			java.sql.Connection con=null;
			boolean flag=false;
			try
			{
			 
			con=getConnection();
			PreparedStatement ps=con.prepareStatement("update StudentCourseMaster set STUDENTID = ?,COURSEID = ?,FACULTYID = ?,REGDATE = ?,COURSEENDDATE = ? where CourseRegId = ? ");
			ps.setInt(6,scform.getCourseRegId());
			ps.setInt(1,scform.getStudentId());
			ps.setInt(2,scform.getCourseId());
			ps.setInt(3,scform.getFacultyId());
			ps.setString(4,DateWrapper.parseDate(scform.getRegDate()));
			ps.setString(5,DateWrapper.parseDate(scform.getCourseEndDate()));
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






		 


		 





		 


		  

		

	 

	 


 
