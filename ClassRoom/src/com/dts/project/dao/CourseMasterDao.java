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
import com.yourcompany.struts.form.CourseFacultyMasterForm;
import com.yourcompany.struts.form.CourseMasterForm;

		public class CourseMasterDao extends AbstractDataAccessObject 
		{
			public boolean insertCourseMaster(CourseMasterForm cmform)
			{
				java.sql.Connection con=null;
				boolean flag=false;
				try
				{
				int n=getSequenceID("CourseMaster","CourseId");
				con=getConnection();
				PreparedStatement ps=con.prepareStatement("insert into CourseMaster values(?,?,?,?,?,?)");
				ps.setInt(1,n);
				ps.setString(2,cmform.getCourseName());
				ps.setString(3,cmform.getCourseDesc());
				ps.setString(4,cmform.getCourseDuration());
				File afile=new File(cmform.getCoursecontent());
		        FileInputStream fs=new FileInputStream(afile);
		        ps.setBinaryStream(5,fs,(int)afile.length());			
				ps.setInt(6,cmform.getNoOfLecturers());
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

		public CoreList ViewCourseMaster(String storepath)
		{   CoreList v=new CoreList();
			java.sql.Connection con=null;
			CourseMasterForm cmform=null;
			try
			{
				con=getConnection();
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from CourseMaster");
				 
				while(rs.next())
				{
					
					cmform=new CourseMasterForm();
					int id=rs.getInt(1);
					cmform.setCourseId(rs.getInt(1));
					cmform.setCourseName(rs.getString(2));
					cmform.setCourseDesc(rs.getString(3));
					cmform.setCourseDuration(rs.getString(4));
					Blob b=rs.getBlob(5);
					byte b1[]=b.getBytes(1,(int)b.length()); 
					OutputStream fout=new FileOutputStream(storepath+"/"+id+".doc");
					fout.write(b1);
					cmform.setCoursecontent(id+".doc");	
					cmform.setNoOfLecturers(rs.getInt(6));
					
					v.add(cmform);
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
		public CourseMasterForm ViewCourseMasterById(String storepath,int CourseId)
		{   CourseMasterForm cmform=new CourseMasterForm();
			java.sql.Connection con=null;
			 
			try
			{
				 
				con=getConnection();
				 
				PreparedStatement ps=con.prepareStatement("select * from CourseMaster where CourseId = ? ");
				ps.setInt(1,CourseId);
				ResultSet rs=ps.executeQuery();
				 
				if(rs.next())
				{
					cmform=new CourseMasterForm();
					int id=rs.getInt(1);
					cmform.setCourseId(rs.getInt(1));
					cmform.setCourseName(rs.getString(2));
					cmform.setCourseDesc(rs.getString(3));
					cmform.setCourseDuration(rs.getString(4));
					Blob b=rs.getBlob(5);
					byte b1[]=b.getBytes(1,(int)b.length()); 
					OutputStream fout=new FileOutputStream(storepath+"/"+id+".gif");
					fout.write(b1);
					cmform.setCoursecontent(id+".gif");	
					cmform.setNoOfLecturers(rs.getInt(6));
					 
					 
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
			return cmform;
			
			
		}

		public boolean deleteCourseMaster(int CourseId)
			{
				java.sql.Connection con=null;
				boolean flag=false;
				try
				{
					 
					con=getConnection();
					 
					PreparedStatement ps=con.prepareStatement("delete from CourseMaster where CourseId = ? ");
					ps.setInt(1,CourseId);
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

		public boolean UpdateCourseMaster(CourseMasterForm cmform)
		{
			java.sql.Connection con=null;
			boolean flag=false;
			try
			{
			 
			con=getConnection();
			PreparedStatement ps=con.prepareStatement("update CourseMaster set CNAME = ?,COURSEDESC = ?,COURSEDURATION = ?, COURSECONTENT = ?,NOOFLETURERES = ? where CourseId = ? ");
			ps.setInt(6,cmform.getCourseId());
			ps.setString(1,cmform.getCourseName());
			ps.setString(2,cmform.getCourseDesc());
			ps.setString(3,cmform.getCourseDuration());
			File afile=new File(cmform.getCoursecontent());
	        FileInputStream fs=new FileInputStream(afile);
	        ps.setBinaryStream(4,fs,(int)afile.length());			
			ps.setInt(5,cmform.getNoOfLecturers());
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
		
		public CoreList viewFacultyCourses(int facultyid)
		{
			CoreList acorelist=new CoreList();
			Connection con=null;
			CourseFacultyMasterForm aform=null;
			try{
				con=getConnection();
				PreparedStatement pst=con.prepareStatement("select fm.fname,cm.cname,cf.DESCBYFACULTY from facultymaster fm,coursemaster cm,COURSEFACULTYMASTER cf where cf.courseid=cm.courseid and cf.facultyid=fm.facultyid and cf.facultyid=?");
			pst.setInt(1,facultyid);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				aform=new CourseFacultyMasterForm();
				aform.setFname(rs.getString(1));
				aform.setCname(rs.getString(2));
				aform.setDescByFaculty(rs.getString(3));
				acorelist.add(aform);
			}
			}catch (Exception e) {
				// TODO: handle exception
			}
			return acorelist;
		}
		public CoreList ViewCourses(int facultyid)
		{   CoreList v=new CoreList();
			java.sql.Connection con=null;
			CourseMasterForm cmform=null;
			try
			{
				con=getConnection();
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from CourseMaster");
				 
				while(rs.next())
				{
					cmform=new CourseMasterForm();
					int id=rs.getInt(1);
					cmform.setCourseId(rs.getInt(1));
					cmform.setCourseName(rs.getString(2));
	            	v.add(cmform);
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
public String getCoursename(int courseid)
{
	String coursename="";
	Connection con=null;
	try{
		con=getConnection();
		PreparedStatement pst=con.prepareStatement("select cname from coursemaster where courseid="+courseid);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			coursename=rs.getString(1);
		}
		
	}catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}
	return coursename;
}
		}






		 


		 





		 


		  

		

	 

	 

 
