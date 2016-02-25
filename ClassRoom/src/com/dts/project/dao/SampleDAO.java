package com.dts.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.CoreHash;
import com.dts.core.util.LoggerManager;
import com.dts.project.model.Sample;

public class SampleDAO extends AbstractDataAccessObject
{
	Connection con;
	Sample sample;
	public SampleDAO()
	{
		//con = getConnection();
	}
	//
	public boolean addSample(Sample aSample)
	{
		PreparedStatement st;
		boolean flag = false;
		try {
			 con = getConnection();
			 st = con.prepareStatement("insert into test values(?,?,?,?)");
             st.setInt(1,aSample.getSno());
             st.setString(2,aSample.getSname());
             st.setInt(3,aSample.getAge());
             st.setString(4,aSample.getAddress());
             int i = st.executeUpdate();
             con.commit();
             if(i>0)
            	 flag = true;
             con.close();
		}
		catch(Exception e)
		{
			LoggerManager.writeLogWarning(e);
		}
		return flag;
	}
	
	//
	public void updateSample(Sample aSample)
	{
		
	}
	
	//
	public boolean deleteSample(String s)
	{
		boolean flag = false;
		try{
			con = getConnection();
            PreparedStatement st = con.prepareStatement("delete from test where sno=?");
            st.setString(1,s);
            int i = st.executeUpdate();
            
            if(i>0)
           	 flag = true;
            con.close();
            }
		catch(Exception e)
		{
			LoggerManager.writeLogWarning(e);
		}
		return flag;
	}
	
	//
	public Sample viewSample(String s)
	{
		Statement st;
		try {
			con = getConnection();
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from test where sno = "+s);
			while(rs.next())
			{
				sample = new Sample();
				sample.setSno(rs.getInt(1));
				sample.setSname(rs.getString(2));
				sample.setAge(rs.getInt(3));
				sample.setAddress(rs.getString(4));
				
			}
			
			con.close();
		} catch (SQLException e) {
			LoggerManager.writeLogWarning(e);
		}
        
		return sample;
	}
	
	//
	public CoreHash listSample()
	{
		
		System.out.println("in list sample");
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno;
		Statement st;
		try {
			con = getConnection();
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from test");
			while(rs.next())
			{
				sno = rs.getInt(1);
				sample = new Sample();
				sample.setSno(sno);
				sample.setSname(rs.getString(2));
				sample.setAge(rs.getInt(3));
				sample.setAddress(rs.getString(4));
				
				aCoreHash.put(new Integer(sno), sample);
			}
			
			con.close();
		} catch (SQLException e) {
			LoggerManager.writeLogWarning(e);
		}
        
		return aCoreHash;
	}
	
}
