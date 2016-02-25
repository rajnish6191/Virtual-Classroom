 
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
	import com.yourcompany.struts.form.CourseLecturerMasterForm;

		public class CourseLecturerMasterDao extends AbstractDataAccessObject 
		{
			public boolean insertCourseLecturerMaster(CourseLecturerMasterForm clform)
			{
				java.sql.Connection con=null;
				boolean flag=false;
				try
				{
				int n=getSequenceID("CourseLecturerMaster","LecturerId");
				con=getConnection();
				PreparedStatement ps=con.prepareStatement("insert into CourseLecturerMaster values(?,?,?,?,?,?,?,?,?,?)");
				ps.setInt(1,n);
				ps.setString(2,DateWrapper.parseDate(clform.getLecturerDate()));
				ps.setInt(3,clform.getCourseId());
				ps.setInt(4,clform.getFacultyId());
				File afile=new File(clform.getLecturerAudio());
		        FileInputStream fs=new FileInputStream(afile);
		        ps.setBinaryStream(5,fs,(int)afile.length());
		        File afile1=new File(clform.getLecturerVideo());
		        FileInputStream fs1=new FileInputStream(afile);
		        ps.setBinaryStream(6,fs1,(int)afile1.length());
		        ps.setInt(7,clform.getLectureDurationTime());
		        File afile4=new File(clform.getLecturerPowerPoint());
		        FileInputStream fs4=new FileInputStream(afile);
		        ps.setBinaryStream(8,fs4,(int)afile4.length());			
		        File afile2=new File(clform.getLectureDocumentfile());
		        FileInputStream fs2=new FileInputStream(afile);
		        ps.setBinaryStream(9,fs2,(int)afile2.length());			
		        File afile3=new File(clform.getLectureassignmentFile());
		        FileInputStream fs3=new FileInputStream(afile);
		        ps.setBinaryStream(10,fs3,(int)afile3.length());	
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

		public CoreList ViewCourseLecturerMaster(String storepath)
		{   CoreList v=new CoreList();
			java.sql.Connection con=null;
			CourseLecturerMasterForm clform=null;
			try
			{
				con=getConnection();
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select l.LECTURERID,l.LECTURERDATE,c.Cname,f.fname,l.LECTUREAUDIO,l.LECTUREVIDEO,l.LECTURERDURATIONTIME,l.LECTURERPOWERPOINT,l.LECTUREDOCUMENTFILE,l.LECTURERASSIGNMENTFILE from CourseLecturerMaster l,coursemaster c,facultymaster f where l.courseid = c.courseid and l.facultyid = f.facultyid");
				 
				while(rs.next())
				{
					 
					clform=new CourseLecturerMasterForm();
					int id=rs.getInt(1);
					clform.setLecturerId(rs.getInt(1));
					clform.setLecturerDate(DateWrapper.parseDate(rs.getDate(2)));
					clform.setCname(rs.getString(3));
					clform.setFname(rs.getString(4));
					Blob b=rs.getBlob(5);
					byte b1[]=b.getBytes(1,(int)b.length()); 
					OutputStream fout=new FileOutputStream(storepath+"/"+id+".wav");
					fout.write(b1);
					clform.setLecturerAudio(id+".wav");
					Blob b2=rs.getBlob(6);
					byte b3[]=b2.getBytes(1,(int)b2.length()); 
					OutputStream fout1=new FileOutputStream(storepath+"/"+id+".wmv");
					fout1.write(b3);
					clform.setLecturerVideo(id+".wmv");	
					
					clform.setLectureDurationTime(rs.getInt(7));
					Blob b8=rs.getBlob(8);
					byte b9[]=b8.getBytes(1,(int)b8.length()); 
					OutputStream fout4=new FileOutputStream(storepath+"/"+id+".ppt");
					fout4.write(b9);	
					clform.setLecturerPowerPoint(id+".ppt");	
					Blob b4=rs.getBlob(9);
					byte b5[]=b4.getBytes(1,(int)b4.length()); 
					OutputStream fout2=new FileOutputStream(storepath+"/"+id+".doc");
					fout2.write(b5);
					clform.setLectureDocumentfile(id+".doc");	
					Blob b6=rs.getBlob(10);
					byte b7[]=b6.getBytes(1,(int)b6.length()); 
					OutputStream fout3=new FileOutputStream(storepath+"/"+id+".doc");
					fout3.write(b7);
					clform.setLectureassignmentFile(id+".doc");	
					
					v.add(clform);
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
		public CoreList ViewCourseLecturerMaster1(String storepath,int facultyid)
		{   CoreList v=new CoreList();
			java.sql.Connection con=null;
			CourseLecturerMasterForm clform=null;
			try
			{
				con=getConnection();
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select l.LECTURERID,l.LECTURERDATE,c.Cname,f.fname,l.LECTUREAUDIO,l.LECTUREVIDEO,l.LECTURERDURATIONTIME,l.LECTURERPOWERPOINT,l.LECTUREDOCUMENTFILE,l.LECTURERASSIGNMENTFILE,l.courseid from CourseLecturerMaster l,coursemaster c,facultymaster f where l.courseid = c.courseid and l.facultyid = f.facultyid and l.facultyid="+facultyid);
				 
				while(rs.next())
				{
					 
					clform=new CourseLecturerMasterForm();
					int id=rs.getInt(1);
					clform.setLecturerId(rs.getInt(1));
					clform.setLecturerDate(DateWrapper.parseDate(rs.getDate(2)));
					clform.setCname(rs.getString(3));
					clform.setFname(rs.getString(4));
					Blob b=rs.getBlob(5);
					byte b1[]=b.getBytes(1,(int)b.length()); 
					OutputStream fout=new FileOutputStream(storepath+"/"+id+".wav");
					fout.write(b1);
					clform.setLecturerAudio(id+".wav");
					Blob b2=rs.getBlob(6);
					byte b3[]=b2.getBytes(1,(int)b2.length()); 
					OutputStream fout1=new FileOutputStream(storepath+"/"+id+".wmv");
					fout1.write(b3);
					clform.setLecturerVideo(id+".wmv");	
					
					clform.setLectureDurationTime(rs.getInt(7));
					Blob b8=rs.getBlob(8);
					byte b9[]=b8.getBytes(1,(int)b8.length()); 
					OutputStream fout4=new FileOutputStream(storepath+"/"+id+".ppt");
					fout4.write(b9);	
					clform.setLecturerPowerPoint(id+".ppt");	
					Blob b4=rs.getBlob(9);
					byte b5[]=b4.getBytes(1,(int)b4.length()); 
					OutputStream fout2=new FileOutputStream(storepath+"/"+id+".doc");
					fout2.write(b5);
					clform.setLectureDocumentfile(id+".doc");	
					Blob b6=rs.getBlob(10);
					byte b7[]=b6.getBytes(1,(int)b6.length()); 
					OutputStream fout3=new FileOutputStream(storepath+"/"+id+".doc");
					fout3.write(b7);
					clform.setLectureassignmentFile(id+".doc");	
					clform.setCourseId(rs.getInt(11));	
					
					v.add(clform);
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

		public CourseLecturerMasterForm ViewCourseLecturerMasterById(String storepath,int LecturerId)
		{   CourseLecturerMasterForm clform=new CourseLecturerMasterForm();
			java.sql.Connection con=null;
			 
			try
			{
				 
				con=getConnection();
				 
				PreparedStatement ps=con.prepareStatement("select * from CourseLecturerMaster where LecturerId = ? ");
				ps.setInt(1,LecturerId);
				ResultSet rs=ps.executeQuery();            
				 
				if(rs.next())
				{
					clform=new CourseLecturerMasterForm();
					int id=rs.getInt(1);
					clform.setLecturerId(rs.getInt(1));
					clform.setLecturerDate(DateWrapper.parseDate(rs.getDate(2)));
					clform.setCourseId(rs.getInt(3));
					clform.setFacultyId(rs.getInt(4));
					Blob b=rs.getBlob(5);
					byte b1[]=b.getBytes(1,(int)b.length()); 
					OutputStream fout=new FileOutputStream(storepath+"/"+id+".wav");
					fout.write(b1);
					clform.setLecturerAudio(id+".wav");
					Blob b2=rs.getBlob(6);
					byte b3[]=b2.getBytes(1,(int)b2.length()); 
					OutputStream fout1=new FileOutputStream(storepath+"/"+id+".wmv");
					fout1.write(b3);
					clform.setLecturerVideo(id+".wmv");	
					
					clform.setLectureDurationTime(rs.getInt(7));
					Blob b8=rs.getBlob(8);
					byte b9[]=b8.getBytes(1,(int)b8.length()); 
					OutputStream fout4=new FileOutputStream(storepath+"/"+id+".ppt");
					fout4.write(b9);	
					clform.setLecturerPowerPoint(id+".ppt");	
					Blob b4=rs.getBlob(9);
					byte b5[]=b4.getBytes(1,(int)b4.length()); 
					OutputStream fout2=new FileOutputStream(storepath+"/"+id+".doc");
					fout2.write(b5);
					clform.setLectureDocumentfile(id+".doc");	
					Blob b6=rs.getBlob(10);
					byte b7[]=b6.getBytes(1,(int)b6.length()); 
					OutputStream fout3=new FileOutputStream(storepath+"/"+id+".doc");
					fout3.write(b7);
					clform.setLectureassignmentFile(id+".doc");	
					 
					 
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
			return clform;
			
			
		}

		public boolean deleteCourseLecturerMaster(int LecturerId)
			{
				java.sql.Connection con=null;
				boolean flag=false;
				try
				{
					 
					con=getConnection();
					 
					PreparedStatement ps=con.prepareStatement("delete from CourseLecturerMaster where LecturerId = ? ");
					ps.setInt(1,LecturerId);
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

		public boolean UpdateCourseLecturerMaster(CourseLecturerMasterForm clform)
		{
			java.sql.Connection con=null;
			boolean flag=false;
			try
			{
			 
			con=getConnection();
			PreparedStatement ps=con.prepareStatement("update CourseLecturerMaster set LECTURERDATE = ?,COURSEID = ?,FACULTYID = ?,LECTUREAUDIO = ?,LECTUREVIDEO = ?,LECTURERDURATIONTIME = ?,LECTURERPOWERPOINT = ?,LECTUREDOCUMENTFILE = ?,LECTURERASSIGNMENTFILE = ? where LecturerId = ? ");
			ps.setInt(10,clform.getLecturerId());
			ps.setString(1,DateWrapper.parseDate(clform.getLecturerDate()));
			ps.setInt(2,clform.getCourseId());
			ps.setInt(3,clform.getFacultyId());
			File afile=new File(clform.getLecturerAudio());
	        FileInputStream fs=new FileInputStream(afile);
	        ps.setBinaryStream(4,fs,(int)afile.length());
	        File afile1=new File(clform.getLecturerVideo());
	        FileInputStream fs1=new FileInputStream(afile);
	        ps.setBinaryStream(5,fs1,(int)afile1.length());
	        ps.setInt(6,clform.getLectureDurationTime());
	        File afile4=new File(clform.getLecturerPowerPoint() );
	        FileInputStream fs4=new FileInputStream(afile);
	        ps.setBinaryStream(7,fs4,(int)afile4.length());			
	        File afile2=new File(clform.getLectureDocumentfile());
	        FileInputStream fs2=new FileInputStream(afile);
	        ps.setBinaryStream(8,fs2,(int)afile2.length());			
	        File afile3=new File(clform.getLectureassignmentFile());
	        FileInputStream fs3=new FileInputStream(afile);
	        ps.setBinaryStream(9,fs3,(int)afile3.length());	
	        
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
		
		public CoreList ViewCourseLecturerMaster(String storepath,int facultyid,int courseid)
		{   CoreList v=new CoreList();
			java.sql.Connection con=null;
			CourseLecturerMasterForm clform=null;
			try
			{
				con=getConnection();
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select l.LECTURERID,l.LECTURERDATE,c.Cname,f.fname,l.LECTUREAUDIO,l.LECTUREVIDEO,l.LECTURERDURATIONTIME,l.LECTURERPOWERPOINT,l.LECTUREDOCUMENTFILE,l.LECTURERASSIGNMENTFILE,l.courseid,l.facultyid from CourseLecturerMaster l,coursemaster c,facultymaster f where l.courseid = c.courseid and l.facultyid = f.facultyid and l.courseid="+courseid+" and l.facultyid="+facultyid+"");
				 
				while(rs.next())
				{
					 
					clform=new CourseLecturerMasterForm();
					int id=rs.getInt(1);
					clform.setLecturerId(rs.getInt(1));
					clform.setLecturerDate(DateWrapper.parseDate(rs.getDate(2)));
					clform.setCname(rs.getString(3));
					clform.setFname(rs.getString(4));
					Blob b=rs.getBlob(5);
					byte b1[]=b.getBytes(1,(int)b.length()); 
					OutputStream fout=new FileOutputStream(storepath+"/"+id+".wav");
					fout.write(b1);
					clform.setLecturerAudio(id+".wav");
					Blob b2=rs.getBlob(6);
					byte b3[]=b2.getBytes(1,(int)b2.length()); 
					OutputStream fout1=new FileOutputStream(storepath+"/"+id+".wmv");
					fout1.write(b3);
					clform.setLecturerVideo(id+".wmv");	
					
					clform.setLectureDurationTime(rs.getInt(7));
					Blob b8=rs.getBlob(8);
					byte b9[]=b8.getBytes(1,(int)b8.length()); 
					OutputStream fout4=new FileOutputStream(storepath+"/"+id+".ppt");
					fout4.write(b9);	
					clform.setLecturerPowerPoint(id+".ppt");	
					Blob b4=rs.getBlob(9);
					byte b5[]=b4.getBytes(1,(int)b4.length()); 
					OutputStream fout2=new FileOutputStream(storepath+"/"+id+".doc");
					fout2.write(b5);
					clform.setLectureDocumentfile(id+".doc");	
					Blob b6=rs.getBlob(10);
					byte b7[]=b6.getBytes(1,(int)b6.length()); 
					OutputStream fout3=new FileOutputStream(storepath+"/"+id+".doc");
					fout3.write(b7);
					clform.setLectureassignmentFile(id+".doc");	
					clform.setCourseId(rs.getInt(11));
					clform.setFacultyId(rs.getInt(12));
					v.add(clform);
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






		 


		 





		 


		  

		

	 

	 


 
