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
import com.yourcompany.struts.form.FacultyMasterForm;

	public class FacultyMasterDao extends AbstractDataAccessObject 
	{
		public boolean insertFacultyMaster(FacultyMasterForm fmform)
		{
			java.sql.Connection con=null;
			StringBuffer sql1=null;
			StringBuffer sql2=null;
			PreparedStatement ps1=null;
			PreparedStatement ps2=null;
			boolean flag=false;
			try
			{
			int n=getSequenceID("FacultyMaster","FacultyId");
			con=getConnection();
			con.setAutoCommit(false);
			PreparedStatement ps=con.prepareStatement("insert into FacultyMaster values(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1,n);
			ps.setString(2,fmform.getFacultyfirstname());
			ps.setString(3,DateWrapper.parseDate(fmform.getDob()));
			ps.setString(4,DateWrapper.parseDate(fmform.getDor()));
			ps.setString(5,fmform.getAddress());
			ps.setString(6,fmform.getEmail());
			ps.setString(7,fmform.getPhone());
			File afile=new File(fmform.getImage());
	        FileInputStream fs=new FileInputStream(afile);
	        ps.setBinaryStream(8,fs,(int)afile.length());			
			ps.setString(9,fmform.getSpecialRemarks());
			ps.setInt(10,fmform.getExperience());
			ps.setString(11,fmform.getUsername());
			ps.setString(12,fmform.getPassword());
			int i=ps.executeUpdate();
			if(i>0){
					 sql2=new StringBuffer("insert into COURSEFACULTYMASTER values(?,?,?)");
					Connection con2=getConnection();
					 ps2=con.prepareStatement(sql2.toString());
					 
					 ps2.setInt(1,fmform.getCourseId());
ps2.setInt(2,n);
					 ps2.setString(3,fmform.getDescByDFaculty());
					 int count1=ps2.executeUpdate();
					 if(count1>0){
				flag=true;
				con.commit();
				}
			
			}	
		}
		catch(Exception e)
		{   
			try {
                   con.rollback();				
					e.printStackTrace();
			} catch(Exception e2){
				e2.printStackTrace();
			}
		}finally
		{
			try{
				con.close();
			}
		catch(Exception e1)
		{
			e1.printStackTrace();
			LoggerManager.writeLogInfo(e1);
		}
		}
		return flag;
		
		
			}

	public CoreList ViewFacultyMaster(String storepath)
	{   CoreList v=new CoreList();
		java.sql.Connection con=null;
		FacultyMasterForm fmform=null;
		try
		{
			con=getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from FacultyMaster");
			 
			while(rs.next())
			{
				fmform=new FacultyMasterForm();
				int id=rs.getInt(1);
				fmform.setFacultyId(rs.getInt(1));
				fmform.setFacultyfirstname(rs.getString(2));
				fmform.setDob(DateWrapper.parseDate(rs.getDate(3)));
				fmform.setDor(DateWrapper.parseDate(rs.getDate(4)));
				fmform.setAddress(rs.getString(5));
				fmform.setEmail(rs.getString(6));
				fmform.setPhone(rs.getString(7));
				Blob b=rs.getBlob(8);
				byte b1[]=b.getBytes(1,(int)b.length()); 
				OutputStream fout=new FileOutputStream(storepath+"/"+id+".gif");
				fout.write(b1);
				fmform.setImage(id+".gif");	
				System.out.println("image is"+storepath);
				fmform.setSpecialRemarks(rs.getString(9));
				fmform.setExperience(rs.getInt(10));
				
				v.add(fmform);
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
	public FacultyMasterForm ViewFacultyMasterById(String storepath,int FacultyId)
	{   FacultyMasterForm fmform=new FacultyMasterForm();
		java.sql.Connection con=null;
		 
		try
		{
			 
			con=getConnection();
			 
			PreparedStatement ps=con.prepareStatement("select * from FacultyMaster where FacultyId = ? ");
			ps.setInt(1,FacultyId);
			ResultSet rs=ps.executeQuery();
			 
			if(rs.next())
			{
				fmform=new FacultyMasterForm();
				int id=rs.getInt(1);
				fmform.setFacultyId(rs.getInt(1));
				fmform.setFacultyfirstname(rs.getString(2));
				fmform.setDob(DateWrapper.parseDate(rs.getDate(3)));
				fmform.setDor(DateWrapper.parseDate(rs.getDate(4)));
				fmform.setAddress(rs.getString(5));
				fmform.setEmail(rs.getString(6));
				fmform.setPhone(rs.getString(7));
				Blob b=rs.getBlob(8);
				byte b1[]=b.getBytes(1,(int)b.length()); 
				OutputStream fout=new FileOutputStream(storepath+"/"+id+".gif");
				fout.write(b1);
				fmform.setImage(id+".gif");	
				fmform.setSpecialRemarks(rs.getString(9));
				fmform.setExperience(rs.getInt(10));
				 
				 
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
		return fmform;
		
		
	}

	public boolean deleteFacultyMaster(int FacultyId)
		{
			java.sql.Connection con=null;
			boolean flag=false;
			try
			{
				 
				con=getConnection();
				 
				PreparedStatement ps=con.prepareStatement("delete from FacultyMaster where FacultyId = ? ");
				ps.setInt(1,FacultyId);
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

	public boolean UpdateFacultyMaster(FacultyMasterForm fmform)
	{
		java.sql.Connection con=null;
		//StringBuffer sql1=null;
		boolean flag=false;
		try
		{
		 
		con=getConnection();
		con.setAutoCommit(false);
		PreparedStatement ps=con.prepareStatement("update FacultyMaster set FNAME = ?,dob = ?,dor = ?,address = ?,email = ?,phone = ?,image = ?,SPECIALREMARKS = ?,EXPERIENCE = ? where FacultyId = ? ");
		ps.setInt(10,fmform.getFacultyId());
		ps.setString(1,fmform.getFacultyfirstname());
		ps.setString(2,DateWrapper.parseDate(fmform.getDob()));
		ps.setString(3,DateWrapper.parseDate(fmform.getDor()));
		ps.setString(4,fmform.getAddress());
		ps.setString(5,fmform.getEmail());
		ps.setString(6,fmform.getPhone());
		File afile=new File(fmform.getImage());
        FileInputStream fs=new FileInputStream(afile);
        ps.setBinaryStream(7,fs,(int)afile.length());			
		ps.setString(8,fmform.getSpecialRemarks());
		ps.setInt(9,fmform.getExperience());		
		int i=ps.executeUpdate();
		if(i>0)
		{
			//sql1=new StringBuffer("update userdetails set loginid=?,password=?")
			flag=true;
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
	return flag;


		}
	
	public int  validateFaculty(String username,String password)
	{
		boolean flag=false;
		Connection con=null;
		int facultyid=0;
		try{
			con=getConnection();
			PreparedStatement pst=con.prepareStatement("select facultyid from facultymaster where fname=? and password=?");
			pst.setString(1,username);
			pst.setString(2,password);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				facultyid=rs.getInt(1);
			}
			con.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return facultyid;
	}
	public CoreList ViewFacultyMaster(int courseid)
	{   CoreList v=new CoreList();
		java.sql.Connection con=null;
		FacultyMasterForm fmform=null;
		try
		{
			con=getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select fm.facultyid,fm.fname from FacultyMaster fm,COURSEFACULTYMASTER cm where cm.facultyid=fm.facultyid and cm.courseid="+courseid);
			 
			while(rs.next())
			{
				fmform=new FacultyMasterForm();
				int id=rs.getInt(1);
				fmform.setFacultyId(rs.getInt(1));
				fmform.setFacultyfirstname(rs.getString(2));
								
				v.add(fmform);
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






	 


	 





	 


	  

	

 

 
