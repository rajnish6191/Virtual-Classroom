package com.dts.project.dao;
	import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.*; 
import java.util.Date;

	import com.dts.core.dao.AbstractDataAccessObject;
	import com.dts.core.util.CoreList;
	import com.dts.core.util.DateWrapper;
	import com.dts.core.util.LoggerManager;
import com.dts.dae.model.Profile;
import com.yourcompany.struts.form.ProfileForm;
import com.yourcompany.struts.form.StudentMasterForm;

	public class StudentMasterDao extends AbstractDataAccessObject 
	{
		public boolean insertStudentMaster(StudentMasterForm smform)
		{
			java.sql.Connection con=null;
			StringBuffer sql1=null;
			PreparedStatement ps1=null;
			boolean flag=false;
			try
			{
			int n=getSequenceID("StudentMaster","StudentId");
			con=getConnection();
			//con.setAutoCommit(false);
			PreparedStatement ps=con.prepareStatement("insert into StudentMaster values(?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1,n);
			ps.setString(2,smform.getStudentfirstname());
			ps.setString(3,smform.getStudentmiddlename());
			ps.setString(4,smform.getStudentlastname());
			ps.setString(5,DateWrapper.parseDate(smform.getDob()));
			ps.setString(6,DateWrapper.parseDate(smform.getDor()));
			ps.setString(7,smform.getAddress());
			ps.setString(8,smform.getEmail());
			ps.setString(9,smform.getPhone());
			File afile=new File(smform.getImage());
	        FileInputStream fs=new FileInputStream(afile);
	        ps.setBinaryStream(10,fs,(int)afile.length());			
			 
			int i=ps.executeUpdate();
			if(i>0) {
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

	public CoreList ViewStudentMaster(String storepath)
	{   CoreList v=new CoreList();
		java.sql.Connection con=null;
		StudentMasterForm smform=null;
		try
		{
			con=getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from StudentMaster");
			 
			while(rs.next())
			{
				//String path=storepath;
				smform=new StudentMasterForm();
				int id=rs.getInt(1);
				smform.setStudentid(rs.getInt(1));
				smform.setStudentfirstname(rs.getString(2));
				smform.setStudentmiddlename(rs.getString(3));
				smform.setStudentlastname(rs.getString(4));
				smform.setDob(DateWrapper.parseDate(rs.getDate(5)));
				smform.setDor(DateWrapper.parseDate(rs.getDate(6)));
				smform.setAddress(rs.getString(7));
				smform.setEmail(rs.getString(8));
				smform.setPhone(rs.getString(9));
				Blob b=rs.getBlob(10);
				
				
				if(b!=null){
					System.out.println("blob issssssss----->>>>"+b);
				byte b1[]=b.getBytes(1,(int)b.length()); 
				OutputStream fout=new FileOutputStream(storepath+"/"+id+".jpg");
				System.out.println("images--->><<<<<<+"+storepath+"/"+id+".jpg");
				fout.write(b1);
				smform.setImage(id+".jpg");	
				System.out.println("image is"+storepath);
				}
				
				/*Blob b = rs.getBlob(7);
				byte b1[] = b.getBytes(1, (int) b.length());
				path = path + "/" + rs.getInt(1) + ".jpg";
				System.out.println("path  :" + path);
				OutputStream fout = new FileOutputStream(path);
				fout.write(b1);
				pro.setPhoto(path);*/
				v.add(smform);
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
	public StudentMasterForm ViewStudentMasterById(String storepath,int StudentId)
	{   StudentMasterForm smform=new StudentMasterForm();
		java.sql.Connection con=null;
		 
		try
		{
			 
			con=getConnection();
			 
			PreparedStatement ps=con.prepareStatement("select * from StudentMaster where StudentId = ? ");
			ps.setInt(1,StudentId);
			ResultSet rs=ps.executeQuery();
			 
			if(rs.next())
			{
				smform=new StudentMasterForm();
				int id=rs.getInt(1);
				smform.setStudentid(rs.getInt(1));
				smform.setStudentfirstname(rs.getString(2));
				smform.setStudentmiddlename(rs.getString(3));
				smform.setStudentlastname(rs.getString(4));
				smform.setDob(DateWrapper.parseDate(rs.getDate(5)));
				smform.setDor(DateWrapper.parseDate(rs.getDate(6)));
				smform.setAddress(rs.getString(7));
				smform.setEmail(rs.getString(8));
				smform.setPhone(rs.getString(9));
				Blob b=rs.getBlob(10);
				byte b1[]=b.getBytes(1,(int)b.length()); 
				OutputStream fout=new FileOutputStream(storepath+"/"+id+".gif");
				fout.write(b1);
				smform.setImage(id+".gif");
				 
				 
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
		return smform;
		
		
	}

	public boolean deleteStudentMaster(int StudentId)
		{
			java.sql.Connection con=null;
			boolean flag=false;
			try
			{
				 
				con=getConnection();
				 
				PreparedStatement ps=con.prepareStatement("delete from StudentMaster where StudentId = ? ");
				ps.setInt(1,StudentId);
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

	public boolean UpdateStudentMaster(StudentMasterForm smform)
	{
		java.sql.Connection con=null;
		boolean flag=false;
		try
		{
		 
		con=getConnection();
		PreparedStatement ps=con.prepareStatement("update StudentMaster set STUDENTFIRSTNAME = ?,STUDENTMIDDLENAME = ?, STUDENTLASTNAME = ?,dob = ?,dor = ?,address = ?,email = ?,phone = ?,image = ? where StudentId = ? ");
		ps.setInt(10,smform.getStudentid());
		ps.setString(1,smform.getStudentfirstname());
		ps.setString(2,smform.getStudentmiddlename());
		ps.setString(3,smform.getStudentlastname());
		ps.setString(4,DateWrapper.parseDate(smform.getDob()));
		ps.setString(5,DateWrapper.parseDate(smform.getDor()));
		ps.setString(6,smform.getAddress());
		ps.setString(7,smform.getEmail());
		ps.setString(8,smform.getPhone());
		File afile=new File(smform.getImage());
        FileInputStream fs=new FileInputStream(afile);
        ps.setBinaryStream(9,fs,(int)afile.length());		
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
	
	
public boolean insertNewUser(ProfileForm regbean) throws FileNotFoundException
    
    {
	PreparedStatement pstmt,pstmt1,pstmt2,pstmt3;
		boolean flag=true;
    	int insert=0;	
    	int userid=0;
    	int k=0;
    	int j=0;
    	try{	
    		Connection con=getConnection();
    		
    		con.setAutoCommit(false);
    		
    		System.out.println("in registerDAO connection is ."+con);	          	
            pstmt=con.prepareStatement("insert into userdetails values((select nvl(max(userid),1000)+1 from userdetails),?,?,?,sysdate,?,?,?,?,?,?,?,?,?)");	            		    		
    		System.out.println();
    		String photo =regbean.getPhoto();
    		
    		String dob=DateWrapper.parseDate(regbean.getBdate());
    		System.out.println(" in dao dob"+dob);
    		
    		String loginid = regbean.getLoginid();
    		String password = regbean.getPassword();
    		String firstname = regbean.getFirstname();
    		String middlename = regbean.getMiddlename();
    		String lastname = regbean.getLastname();
    		String logintype = regbean.getLogintype();
    		String regdate = regbean.getDate();
    		String secretquest = regbean.getSecretqid();
    		String ownsecretquest = regbean.getOwnsecretq();
    		String secretans = regbean.getSanswer();
    		String bdate = DateWrapper.parseDate(regbean.getBdate());
    		
    		
    		
    		// home
    		String hno = regbean.getHno();
    		String home = regbean.getHome();
    		String street = regbean.getStreet();
    		String city = regbean.getCity();
    		String state = regbean.getState();
    		String country = regbean.getCountry();
    		String pin = regbean.getPin();
    		String Phonetype = regbean.getHomePhoneType();
    		String phone = regbean.getPhone();
    		// office
    		String ohno = regbean.getOhno();
    		String office = regbean.getOffice();
    		String ostreet = regbean.getOstreet();
    		String ocity = regbean.getOcity();
    		String ostate = regbean.getOstate();
    		String ocountry = regbean.getOcountry();
    		String opin = regbean.getOpin();
    		String oPhonetype = regbean.getOfficePhoneType();
    		String ophone = regbean.getOphone();
    		// personal
    		String phno = regbean.getChno();
    		String contact = regbean.getContact();
    		String pstreet = regbean.getCstreet();
    		String pcity = regbean.getCcity();
    		String pstate = regbean.getCstate();
    		String pcountry = regbean.getCcountry();
    		String ppin = regbean.getCpin();
    		String pPhonetype = regbean.getPersonalPhoneType();
    		String pphone = regbean.getCphone();

    		String fax = regbean.getFax();
    		String email = regbean.getEmail();
    		
    		
            pstmt.setString(1, firstname);
            pstmt.setString(2, lastname);
            pstmt.setString(3, dob);
            pstmt.setString(4, loginid);
            pstmt.setString(5, password);
            pstmt.setString(6, "student");
            pstmt.setString(7, secretquest);
            pstmt.setString(8, secretans);
          
            File f=new File(photo);
        	FileInputStream fis=new FileInputStream(f); 
        	System.out.println("fole="+f.length());	 
          
         pstmt.setBinaryStream(9, fis,(int)f.length());
        
          pstmt.setString(10, email);
          pstmt.setString(11, fax);
          pstmt.setString(12, middlename);
         
        
      
          int i=pstmt.executeUpdate();
         
          
         
       
         if(i>0)
          {	        	  
        	  pstmt1=con.prepareStatement("insert into addresses values((select max(userid) from userdetails),(select nvl(max(addressid),101)+1 from addresses),?,?,?,?,?,?,?)");	        	  	        	  
        	  
        	  pstmt1.setString(1, "home");
        	  pstmt1.setString(2, hno);
        	  pstmt1.setString(3, street);
        	  pstmt1.setString(4, city);
        	  pstmt1.setString(5, state);
        	  pstmt1.setString(6, country);
        	  pstmt1.setString(7,pin);
        	
        	  insert=pstmt1.executeUpdate();
        	  }	     
          if(insert>0)
	         {
        	  
        	  pstmt2=con.prepareStatement("insert into phones values((select max(userid) from userdetails),?,?)");
        	  
        	  pstmt2.setString(1, phone);
        	  pstmt2.setString(2, "Home");
        	  
        	   j=pstmt2.executeUpdate();
        	  
	         }
        	  if(j>0){
        		  
        		  pstmt3=con.prepareStatement("insert into studentmaster values((select nvl(max(studentid),100)+1 from studentmaster),?,?,?,?,sysdate,?,?,?,?)");
        		  
        		  pstmt3.setString(1, firstname);
        		  pstmt3.setString(2, middlename);
        		  pstmt3.setString(3, lastname);
        		  pstmt3.setString(4, dob);
        		  pstmt3.setString(5, "Ameerpet");
        		  pstmt3.setString(6, email);
        		  pstmt3.setString(7, phone);
        		  
        		  File f1=new File(photo);
              	FileInputStream fis1=new FileInputStream(f1); 
              	System.out.println("fole="+f1.length());	 
              	pstmt3.setBinaryStream(8, fis1,(int)f1.length());
              	
              	
              	 k=pstmt3.executeUpdate();
              	
        		  
        	  }
        	  if(k>0){
	         
	          con.commit();
	         }
	         else
	         {
	        	 flag=false;
	        	 con.rollback();
	         }
	    } 
	    catch (SQLException e) 
	    {
	        e.printStackTrace();
	        flag=false;
	        
	    }
	   
	return flag;
}
	}






	 


	 





	 


	  

	

 