 
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
		import com.yourcompany.struts.form.FacultyNoticesMasterForm;

			public class FacultyNoticesMasterDao extends AbstractDataAccessObject 
			{
				public boolean insertFacultyNoticesMaster(FacultyNoticesMasterForm fnform)
				{
					java.sql.Connection con=null;
					boolean flag=false;
					try
					{
					int n=getSequenceID("FacultyNoticesMaster","NoticeId");
					con=getConnection();
					PreparedStatement ps=con.prepareStatement("insert into FacultyNoticesMaster values(?,?,?,?,?)");
					ps.setInt(1,n);
					ps.setString(2,DateWrapper.parseDate(fnform.getNoticeDate()));
					ps.setInt(3,fnform.getFacultyId());
					
					System.out.println("TEST"+fnform.getFacultyId());
					ps.setString(4,fnform.getNoticeText());
					
					File afile=new File(fnform.getNoticeFile());
			        System.out.println("this is file URL"+afile);
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

			public CoreList ViewFacultyNoticesMaster(String storepath,int facultyid)
			{   CoreList v=new CoreList();
				java.sql.Connection con=null;
				FacultyNoticesMasterForm fnform=null;
				try
				{
					con=getConnection();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from facultyNoticesMaster where facultyid="+facultyid);
					 
					while(rs.next())
					{
						fnform=new FacultyNoticesMasterForm();
						int id=rs.getInt(1);
						fnform.setNoticeId(rs.getInt(1));
						fnform.setNoticeDate(DateWrapper.parseDate(rs.getDate(2)));
						//fnform.setFname(rs.getString(3));
						fnform.setFacultyId(rs.getInt(3));
						fnform.setNoticeText(rs.getString(4));
						Blob b=rs.getBlob(5);
						byte b1[]=b.getBytes(1,(int)b.length()); 
						OutputStream fout=new FileOutputStream(storepath+"/"+id+".doc");
						fout.write(b1);
						fnform.setNoticeFile(id+".doc");	
						v.add(fnform);
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
			public CoreList ViewALLFacultyNoticesMaster(String storepath)
			{   CoreList v=new CoreList();
				java.sql.Connection con=null;
				FacultyNoticesMasterForm fnform=null;
				try
				{
					con=getConnection();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select n.NOTICEID,n.NOTICEDATE,f.FNAME,n.NOTICETEXT,n.NOTICEFILE from FacultyNoticesMaster n,facultymaster f where n.facultyid = f.facultyid");
					 
					while(rs.next())
					{
						fnform=new FacultyNoticesMasterForm();
						int id=rs.getInt(1);
						fnform.setNoticeId(rs.getInt(1));
						fnform.setNoticeDate(DateWrapper.parseDate(rs.getDate(2)));
						fnform.setFname(rs.getString(3));
						fnform.setNoticeText(rs.getString(4));
						Blob b=rs.getBlob(5);
						byte b1[]=b.getBytes(1,(int)b.length()); 
						OutputStream fout=new FileOutputStream(storepath+"/"+id+".doc");
						fout.write(b1);
						fnform.setNoticeFile(id+".doc");	
						v.add(fnform);
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

			public FacultyNoticesMasterForm ViewFacultyNoticesMasterById(String storepath,int NoticeId)
			{   FacultyNoticesMasterForm fnform=new FacultyNoticesMasterForm();
				java.sql.Connection con=null;
				 
				try
				{
					 
					con=getConnection();
					 
					PreparedStatement ps=con.prepareStatement("select * from FacultyNoticesMaster where NoticeId = ? ");
					ps.setInt(1,NoticeId);
					ResultSet rs=ps.executeQuery();
					 
					if(rs.next())
					{
						fnform=new FacultyNoticesMasterForm();
						int id=rs.getInt(1);
						fnform.setNoticeId(rs.getInt(1));
						fnform.setNoticeDate(DateWrapper.parseDate(rs.getDate(2)));
						fnform.setFacultyId(rs.getInt(3));
						fnform.setNoticeText(rs.getString(4));
						Blob b=rs.getBlob(5);
						byte b1[]=b.getBytes(1,(int)b.length()); 
						OutputStream fout=new FileOutputStream(storepath+"/"+id+".doc");
						fout.write(b1);
						fnform.setNoticeFile(id+".doc");	
						 
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
				return fnform;
				
				
			}

			public boolean deleteFacultyNoticesMaster(int NoticeId)
				{
					java.sql.Connection con=null;
					boolean flag=false;
					try
					{
						 
						con=getConnection();
						 
						PreparedStatement ps=con.prepareStatement("delete from FacultyNoticesMaster where NoticeId = ? ");
						ps.setInt(1,NoticeId);
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

			public boolean UpdateFacultyNoticesMaster(FacultyNoticesMasterForm fnform)
			{
				java.sql.Connection con=null;
				boolean flag=false;
				try
				{
				 
				con=getConnection();
				PreparedStatement ps=con.prepareStatement("update FacultyNoticesMaster set  NOTICEDATE = ?,FACULTYID = ?,NOTICETEXT = ?, NOTICEFILE = ? where NoticeId = ? ");
				ps.setInt(5,fnform.getNoticeId());
				ps.setString(1,DateWrapper.parseDate(fnform.getNoticeDate()));
				ps.setInt(2,fnform.getFacultyId());
				ps.setString(3,fnform.getNoticeText());
				File afile=new File(fnform.getNoticeFile());
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






			 


			 





			 


			  

			

		 

		 

	 


 
