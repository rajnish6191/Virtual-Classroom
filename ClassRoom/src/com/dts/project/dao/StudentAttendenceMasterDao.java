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
	import com.yourcompany.struts.form.StudentAttendanceMasterForm;

		public class StudentAttendenceMasterDao extends AbstractDataAccessObject 
		{
			public boolean insertStudentAttendenceMaster(StudentAttendanceMasterForm saform)
			{
				java.sql.Connection con=null;
				boolean flag=false;
				try
				{
				int n=getSequenceID("StudentAttendenceMaster","AttendenceId");
				con=getConnection();
				PreparedStatement ps=con.prepareStatement("insert into StudentAttendenceMaster values(?,?,?,?,?,?)");
				ps.setInt(1,n);
				ps.setString(2,DateWrapper.parseDate(saform.getAttendanceDateTime()));
				ps.setString(3,DateWrapper.parseDate(saform.getDisconnectedDateTime()));
				ps.setInt(4,saform.getStudentId());
				ps.setInt(5,saform.getCourseId());
				ps.setInt(6,saform.getLecturerId());
				
				
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

		public CoreList ViewStudentAttendenceMaster()
		{   CoreList v=new CoreList();
			java.sql.Connection con=null;
			StudentAttendanceMasterForm saform=null;
			try
			{
				con=getConnection();
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select a.ATTENDENCEID,a.ATTENDENCEDATETIME,a.DISCONNECTEDDATETIME,s.STUDENTFIRSTNAME,c.CNAME,l.LECTURERDATE from StudentAttendenceMaster a,Studentmaster s,coursemaster c,courselecturermaster l where a.studentid = s.studentid and a.courseid = c.courseid and a.LECTURERID=l.LECTURERID");
				 
				while(rs.next())
				{
					saform=new StudentAttendanceMasterForm();
					 
					saform.setAttendanceId(rs.getInt(1));
					saform.setAttendanceDateTime(DateWrapper.parseDate(rs.getDate(2)));
					saform.setDisconnectedDateTime(DateWrapper.parseDate(rs.getDate(3)));
					saform.setSname(rs.getString(4));
					saform.setCname(rs.getString(5));
					saform.setLdate(DateWrapper.parseDate(rs.getDate(6)));
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
		public StudentAttendanceMasterForm ViewStudentAttendenceMasterById(int AttendenceId)
		{   StudentAttendanceMasterForm saform=new StudentAttendanceMasterForm();
			java.sql.Connection con=null;
			 
			try
			{
				 
				con=getConnection();
				 
				PreparedStatement ps=con.prepareStatement("select * from StudentAttendenceMaster where AttendenceId = ? ");
				ps.setInt(1,AttendenceId);
				ResultSet rs=ps.executeQuery();
				 
				if(rs.next())
				{
					saform=new StudentAttendanceMasterForm();
					int id=rs.getInt(1);
					saform.setAttendanceId(rs.getInt(1));
					saform.setAttendanceDateTime(DateWrapper.parseDate(rs.getDate(2)));
					saform.setDisconnectedDateTime(DateWrapper.parseDate(rs.getDate(3)));
					saform.setStudentId(rs.getInt(4));
					saform.setCourseId(rs.getInt(5));
					saform.setLecturerId(rs.getInt(6));
					 
					 
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

		public boolean deleteStudentAttendenceMaster(int AttendenceId)
			{
				java.sql.Connection con=null;
				boolean flag=false;
				try
				{
					 
					con=getConnection();
					 
					PreparedStatement ps=con.prepareStatement("delete from StudentAttendenceMaster where AttendenceId = ? ");
					ps.setInt(1,AttendenceId);
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

		public boolean UpdateStudentAttendenceMaster(StudentAttendanceMasterForm saform)
		{
			java.sql.Connection con=null;
			boolean flag=false;
			try
			{
			 
			con=getConnection();
			PreparedStatement ps=con.prepareStatement("update StudentAttendenceMaster set ATTENDENCEDATETIME = ?,DISCONNECTEDDATETIME = ?,STUDENTID = ?,COURSEID = ?,LECTURERID = ? where AttendenceId = ? ");
			ps.setInt(1,saform.getAttendanceId());
			ps.setString(2,DateWrapper.parseDate(saform.getAttendanceDateTime()));
			ps.setString(3,DateWrapper.parseDate(saform.getDisconnectedDateTime()));
			ps.setInt(4,saform.getStudentId());
			ps.setInt(5,saform.getCourseId());
			ps.setInt(6,saform.getLecturerId());
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






		 


		 





		 


		  

		

	 

	 


 


 