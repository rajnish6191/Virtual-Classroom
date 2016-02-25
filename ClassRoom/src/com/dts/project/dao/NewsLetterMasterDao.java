 
	 
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
import com.yourcompany.struts.form.NewsLetterMasterForm;

			public class NewsLetterMasterDao extends AbstractDataAccessObject 
			{
				public boolean insertNewsLetterMaster(NewsLetterMasterForm nlform)
				{
					java.sql.Connection con=null;
					boolean flag=false;
					try
					{
						
					int n=getSequenceID("NewsLetterMaster","NewsLetterId");
					con=getConnection();
					PreparedStatement ps=con.prepareStatement("insert into NewsLetterMaster values(?,?,?,?)");
					ps.setInt(1,n);
					File afile=new File(nlform.getLetterUploadedFile());
			        FileInputStream fs=new FileInputStream(afile);
			        ps.setBinaryStream(2,fs,(int)afile.length());	
					ps.setString(3,DateWrapper.parseDate(new java.util.Date()));
					ps.setInt(4,nlform.getFacultyId());
							
					
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

			public CoreList ViewNewsLetterMaster(String storepath)
			{   CoreList v=new CoreList();
				java.sql.Connection con=null;
				NewsLetterMasterForm nlform=null;
				try
				{
					con=getConnection();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select n.newsletterid,n.LETTER,n.NEWSDATE,f.fname from NewsLetterMaster n,facultymaster f where n.facultyid = f.facultyid");
					 
					while(rs.next())
					{
						nlform=new NewsLetterMasterForm();
						int id=rs.getInt(1);
						nlform.setNewsLetterId(rs.getInt(1));
						Blob b=rs.getBlob(2);
						byte b1[]=b.getBytes(1,(int)b.length()); 
						OutputStream fout=new FileOutputStream(storepath+"/"+id+".doc");
						fout.write(b1);
						nlform.setLetterUploadedFile(id+".doc");		
						nlform.setNewsdate(DateWrapper.parseDate(rs.getDate(3)));
						nlform.setFacultyName(rs.getString(4));
						v.add(nlform);
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
			public NewsLetterMasterForm ViewNewsLetterMasterById(String storepath,int NewsLetterId)
			{   NewsLetterMasterForm nlform=new NewsLetterMasterForm();
				java.sql.Connection con=null;
				 
				try
				{
					 
					con=getConnection();
					 
					PreparedStatement ps=con.prepareStatement("select n.newsletterid,n.LETTER,n.NEWSDATE,f.fname from NewsLetterMaster n,facultymaster f where n.NewsLetterId = ? ");
					ps.setInt(1,NewsLetterId);
					ResultSet rs=ps.executeQuery();
					 
					if(rs.next())
					{
						 
						nlform=new NewsLetterMasterForm();
						int id=rs.getInt(1);
						nlform.setNewsLetterId(rs.getInt(1));
						Blob b=rs.getBlob(2);
						byte b1[]=b.getBytes(1,(int)b.length()); 
						OutputStream fout=new FileOutputStream(storepath+"/"+id+".doc");
						fout.write(b1);
						nlform.setLetterUploadedFile(id+".doc");		
						nlform.setNewsdate(DateWrapper.parseDate(rs.getDate(3)));
						nlform.setFacultyName(rs.getString(4));	
						 
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
				return nlform;
				
				
			}

			public boolean deleteNewsLetterMaster(int NewsLetterId)
				{
					java.sql.Connection con=null;
					boolean flag=false;
					try
					{
						 
						con=getConnection();
						 
						PreparedStatement ps=con.prepareStatement("delete from NewsLetterMaster where NewsLetterId = ? ");
						ps.setInt(1,NewsLetterId);
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

			public boolean UpdateNewsLetterMaster(NewsLetterMasterForm nlform)
			{
				java.sql.Connection con=null;
				boolean flag=false;
				try
				{
				 
				con=getConnection();
				PreparedStatement ps=con.prepareStatement("update NewsLetterMaster set letter = ?,NEWSDATE = ?,FACULTYID = ? where NewsLetterId = ? ");
				ps.setInt(4,nlform.getNewsLetterId());
				File afile=new File(nlform.getLetterUploadedFile());
		        FileInputStream fs=new FileInputStream(afile);
		        ps.setBinaryStream(1,fs,(int)afile.length());	
				ps.setString(2,DateWrapper.parseDate(nlform.getNewsdate()));
				ps.setInt(3,nlform.getFacultyId());		
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






			 


			 





			 


			  

			

		 

		 


	 


	 









 