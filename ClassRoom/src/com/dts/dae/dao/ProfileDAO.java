/*
 * ProfileDAO.java
 *
 * 
 * 
 */

package com.dts.dae.dao;

import oracle.jdbc.driver.*;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.CoreHash;
import com.dts.core.util.CoreList;
import com.dts.core.util.DateWrapper;
import com.dts.core.util.LoggerManager;
import com.yourcompany.struts.form.ProfileForm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.OutputStream;
import java.sql.*;
import java.util.Date;
import java.util.Properties;

/**
 *
 * @author 
 */
/**
 * @author user
 * 
 */
public class ProfileDAO extends AbstractDataAccessObject {

	public Connection con;

	private boolean flag;

	/** Creates a new instance of ProfileDAO */
	public ProfileDAO() {
		// getting Database Connection

	}

	// User Registration
	public boolean registration(ProfileForm regbean) {

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
		String photo = regbean.getPhoto();
		String newdate = DateWrapper.parseDate(new Date());
		try {
			File f = new File(photo);
			FileInputStream fis = new FileInputStream(f);
			con = getConnection();
			CallableStatement cstmt = con
					.prepareCall("call insertprocedure(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			cstmt.setString(1, firstname);
			cstmt.setString(2, lastname);
			cstmt.setString(3, bdate);

			cstmt.setString(4, loginid);
			cstmt.setString(5, password);

			cstmt.setString(6, secretquest);
			cstmt.setString(7, secretans);
			cstmt.setBinaryStream(8, fis, (int) f.length());
			System.out.println("length of the image---------->>>>"+f.length());
			cstmt.setString(9, email);
			cstmt.setString(10, fax);

			cstmt.setString(11, home);
			cstmt.setString(12, hno);
			cstmt.setString(13, street);
			cstmt.setString(14, city);
			cstmt.setString(15, state);
			cstmt.setString(16, country);
			cstmt.setString(17, pin);

			cstmt.setString(18, office);
			cstmt.setString(19, ohno);
			cstmt.setString(20, ostreet);
			cstmt.setString(21, ocity);
			cstmt.setString(22, ostate);
			cstmt.setString(23, ocountry);
			cstmt.setString(24, opin);
			cstmt.setString(25, contact);
			cstmt.setString(26, phno);
			cstmt.setString(27, pstreet);
			cstmt.setString(28, pcity);
			cstmt.setString(29, pstate);
			cstmt.setString(30, pcountry);
			cstmt.setString(31, ppin);

			cstmt.setString(32, Phonetype);
			cstmt.setString(33, phone);
			cstmt.setString(34, oPhonetype);
			cstmt.setString(35, ophone);
			cstmt.setString(36, pPhonetype);
			cstmt.setString(37, pphone);
			cstmt.setString(38, middlename);
			cstmt.setString(39, firstname);
			cstmt.setString(40, middlename);
			cstmt.setString(41, lastname);
			cstmt.setString(42, bdate);
			cstmt.setString(43, city);
			cstmt.setString(44, email);
			cstmt.setString(45, phone);
			cstmt.setBinaryStream(46, fis, (int) f.length());
			cstmt.execute();
			
			con.commit();

			con.close();
		} catch (SQLException e) {

			System.out.println(e);
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return flag;
	}

	// Getting profile
	public ProfileForm getProfile(String loginname, String storepath) {
		ProfileForm rb = new ProfileForm();
		try {
			con = getConnection();
			CallableStatement cs = con
					.prepareCall("{call showprofile(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			System.out.println(cs);
			cs.setString(1, loginname);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.VARCHAR);
			cs.registerOutParameter(8, Types.VARCHAR);
			cs.registerOutParameter(9, Types.VARCHAR);
			cs.registerOutParameter(10, Types.VARCHAR);
			cs.registerOutParameter(11, Types.VARCHAR);
			cs.registerOutParameter(12, Types.VARCHAR);
			cs.registerOutParameter(13, Types.VARCHAR);
			cs.registerOutParameter(14, Types.VARCHAR);
			cs.registerOutParameter(15, Types.VARCHAR);
			cs.registerOutParameter(16, Types.VARCHAR);
			cs.registerOutParameter(17, Types.VARCHAR);
			cs.registerOutParameter(18, Types.VARCHAR);
			cs.registerOutParameter(19, Types.VARCHAR);
			cs.registerOutParameter(20, Types.VARCHAR);
			cs.registerOutParameter(21, Types.VARCHAR);
			cs.registerOutParameter(22, Types.VARCHAR);
			cs.registerOutParameter(23, Types.VARCHAR);
			cs.registerOutParameter(24, Types.VARCHAR);
			cs.registerOutParameter(25, Types.VARCHAR);
			cs.registerOutParameter(26, Types.VARCHAR);
			cs.registerOutParameter(27, Types.VARCHAR);
			cs.registerOutParameter(28, Types.VARCHAR);
			cs.registerOutParameter(29, Types.VARCHAR);
			cs.registerOutParameter(30, Types.VARCHAR);
			cs.registerOutParameter(31, Types.VARCHAR);
			cs.registerOutParameter(32, Types.VARCHAR);
			cs.registerOutParameter(33, Types.VARCHAR);
			cs.registerOutParameter(34, Types.VARCHAR);
			cs.registerOutParameter(35, Types.BLOB);
			cs.execute();
			rb.setPassword(cs.getString(2));
			rb.setFirstname(cs.getString(3));
			rb.setLastname(cs.getString(4));

			rb.setBdate(cs.getString(5));
			// rb.setPhoto(cs.getString());
			rb.setEmail(cs.getString(6));
			rb.setFax(cs.getString(7));
			rb.setHome(cs.getString(8));
			rb.setHno(cs.getString(9));
			rb.setStreet(cs.getString(10));
			rb.setCity(cs.getString(11));
			rb.setState(cs.getString(12));
			// rb.setPin(cs.getString(13));
			rb.setCountry(cs.getString(13));
			rb.setPin(cs.getString(14));
			rb.setOffice(cs.getString(15));
			rb.setOhno(cs.getString(16));
			rb.setOstreet(cs.getString(17));
			rb.setOcity(cs.getString(18));

			rb.setOstate(cs.getString(19));
			// rb.setOpin(cs.getString(20));
			rb.setOcountry(cs.getString(20));
			rb.setOpin(cs.getString(21));
			rb.setContact(cs.getString(22));
			rb.setChno(cs.getString(23));
			rb.setCstreet(cs.getString(24));
			rb.setCcity(cs.getString(25));
			rb.setCstate(cs.getString(26));
			// rb.setCpin(cs.getString(27));
			rb.setCcountry(cs.getString(27));
			rb.setCpin(cs.getString(28));
			rb.setHomePhoneType(cs.getString(29));
			rb.setPhone(cs.getString(30));
			rb.setOfficePhoneType(cs.getString(31));
			rb.setOphone(cs.getString(32));
			rb.setPersonalPhoneType(cs.getString(33));
			String s = cs.getString(34);
			rb.setCphone(s);
			/*
			 * FileOutputStream fs = null; InputStream is = null; fs = new
			 * FileOutputStream("photo.jpg");
			 * 
			 * is = cs.getBlob(35).getBinaryStream(); byte[] buf = new
			 * byte[16384]; int bytes; while ((bytes = is.read(buf)) != -1) {
			 * fs.write(buf, 0, bytes);
			 * 
			 * }
			 */
			Blob b = cs.getBlob(35);
			byte b1[] = b.getBytes(1, (int) b.length());
			System.out.println(storepath + "" + loginname);
			OutputStream fout = new FileOutputStream(storepath + "/"
					+ loginname + ".jpg");
			fout.write(b1);

		}

		catch (Exception e) {
			e.printStackTrace();
			LoggerManager.writeLogSevere(e);
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				LoggerManager.writeLogSevere(e);
			}

		}
		return rb;
	} // Modify Profile

	public boolean modifyProfile(ProfileForm regbean) {
		String loginid = regbean.getLoginid();
		String firstname = regbean.getFirstname();
		String lastname = regbean.getLastname();
		// String bdate=DateWrapper.parseDate(regbean.getBirthDate());
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
		String photo = regbean.getPhoto();
		String newdate = DateWrapper.parseDate(new Date());
		try {
			System.out.println("photo=" + photo);
			File f = new File(photo);
			FileInputStream fis = new FileInputStream(f);
			System.out.println("fole=" + f.length());

			con = getConnection();
			// con.setAutoCommit(false);
			CallableStatement cs = con
					.prepareCall(" call changeprofile(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			cs.setString(1, firstname);
			cs.setString(2, lastname);
			cs.setString(3, loginid);
			// cs.setBinaryStream(4, fis,(int)f.length());
			cs.setBinaryStream(4, fis, 999);
			cs.setString(5, email);
			cs.setString(6, fax);
			cs.setString(7, home);
			cs.setString(8, hno);
			cs.setString(9, street);
			cs.setString(10, city);
			cs.setString(11, state);
			cs.setString(12, country);
			cs.setString(13, pin);
			cs.setString(14, office);

			cs.setString(15, ohno);
			cs.setString(16, ostreet);
			cs.setString(17, ocity);
			cs.setString(18, ostate);
			cs.setString(19, ocountry);
			cs.setString(20, opin);
			cs.setString(21, contact);

			cs.setString(22, phno);
			cs.setString(23, pstreet);
			cs.setString(24, pcity);
			cs.setString(25, pstate);

			cs.setString(26, pcountry);
			cs.setString(27, ppin);
			cs.setString(28, Phonetype);
			cs.setString(29, phone);
			cs.setString(30, oPhonetype);
			cs.setString(31, ophone);
			cs.setString(32, pPhonetype);
			cs.setString(33, pphone);
			cs.registerOutParameter(34, Types.INTEGER);
			cs.execute();
			int n1 = cs.getInt(34);
			PreparedStatement pst = con
					.prepareStatement("Update userdetails set photograph=? where loginid=?");
			File afile = new File(photo);
			FileInputStream fis1 = new FileInputStream(afile);
			pst.setBinaryStream(1, fis1, (int) afile.length());

			pst.setString(2, loginid);
			int n = pst.executeUpdate();
			if (n > 0) {
				flag = true;
			}
			/*
			 * firstname varchar2, lastname varchar2, dob date, loginid
			 * varchar2, password varchar2, forgotpwquestion varchar2,
			 * forgotpwanswer varchar2, photograph blob, emailId varchar2, faxno
			 * varchar2, addresstypehome varchar2, addresstypeoffice varchar2,
			 * addresstypepersonal varchar2, housenohome varchar2, housenooffice
			 * varchar2, housenopersonal varchar2, streethome varchar2,
			 * streetoffice varchar2, streetpersonal varchar2, cityhome
			 * varchar2, cityoffice varchar2, citypersonal varchar2, statehome
			 * varchar2, stateoffice varchar2, statepersonal varchar2,
			 * countryhome varchar2, countryoffice varchar2, countrypersonal
			 * varchar2, pincodehome varchar2, pincodeoffice varchar2,
			 * pincodepersonal varchar2, phonenumberhome varchar2,
			 * phonenumberoffice varchar2, phonenumberpersonal varchar2,
			 * phonetypehome varchar2, phonetypeoffice varchar2,
			 * phonetypepersonal varchar2, flag out number
			 */

			else {
				flag = false;
				con.rollback();
			}
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException sex) {
				sex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return flag;
	}

	// getreport fromdate todate
	public CoreHash getReportFromTo(String sdate, String edate) {

		Properties p = getProperties();
		String pattern = "";
		if (p.getProperty("dbname").equals("access"))
			pattern = "#";
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println(" aCoreHash--" + aCoreHash.isEmpty());
		int sno = 1;
		Statement st;
		ProfileForm aProfile = null;
		try {
			con = getConnection();

			st = con.createStatement();
			ResultSet rs = st
					.executeQuery("SELECT DISTINCT(UD.LOGINID ),UD.FIRSTNAME,UD.LASTNAME,UD.DOB,UD.DOR,UD.EMAILID FROM USERDETAILS UD,LOGINMASTER LM WHERE UD.USERID=LM.USERID AND TO_CHAR(LOGINDATE,'DD-MM-YYYY')>='"
							+ sdate
							+ "' AND TO_CHAR(LOGINDATE,'DD-MM-YYYY')<='"
							+ edate + "'");
			while (rs.next()) {
				aProfile = new ProfileForm();

				aProfile.setLoginid(rs.getString(1));
				aProfile.setFirstname(rs.getString(2));
				aProfile.setLastname(rs.getString(3));
				String date = DateWrapper.parseDate(rs.getDate(4)).trim();
				aProfile.setBdate(date);
				aProfile.setDate(DateWrapper.parseDate(rs.getDate(5)).trim());
				aProfile.setEmail(rs.getString(6));

				aCoreHash.put(new Integer(sno), aProfile);
				sno++;

			}
		} catch (Exception e) {
			e.printStackTrace();
			LoggerManager.writeLogWarning(e);
		} finally {
			try {
				if (con != null)
					con.close();

			} catch (Exception e) {
			}
		}
		return aCoreHash;
	}

	// presentloginuser getting

	public CoreHash getReportPresent() {

		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--" + aCoreHash.isEmpty());
		int sno = 1;
		CallableStatement cstmt;
		ProfileForm aProfile = null;
		try {
			con = getConnection();

			cstmt = con
					.prepareCall("{call REF_CURSOR_TEST.GET_ACCOUNTS_PROCEDURE(?)}");
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.executeUpdate();
			ResultSet rs = ((OracleCallableStatement) cstmt).getCursor(1);
			while (rs.next()) {
				aProfile = new ProfileForm();

				aProfile.setLoginid(rs.getString(1));
				aProfile.setFirstname(rs.getString(2));
				aProfile.setLastname(rs.getString(3));
				String date = DateWrapper.parseDate(rs.getDate(4)).trim();
				aProfile.setBdate(date);
				aProfile.setDate(DateWrapper.parseDate(rs.getDate(5)).trim());
				aProfile.setEmail(rs.getString(6));

				aCoreHash.put(new Integer(sno), aProfile);
				sno++;

			}
		} catch (Exception e) {
			e.printStackTrace();
			LoggerManager.writeLogWarning(e);
		} finally {
			try {
				if (con != null)
					con.close();

			} catch (Exception e) {
			}
		}
		return aCoreHash;
	}

	public boolean changeAccountStatus(String loginid, int status) {
		try {
			con = getConnection();
			con.setAutoCommit(false);
			PreparedStatement cstmt = con
					.prepareStatement("UPDATE logindetails SET loginstatus=? WHERE loginid=?");

			cstmt.setInt(1, status);
			cstmt.setString(2, loginid);
			int i = cstmt.executeUpdate();

			if (i == 1) {
				flag = true;
				con.commit();
			} else {
				flag = false;
				con.rollback();
			}
			con.close();
		} catch (SQLException ex) {
			LoggerManager.writeLogSevere(ex);
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				LoggerManager.writeLogSevere(se);
			}
		} catch (Exception e) {
			LoggerManager.writeLogSevere(e);
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				LoggerManager.writeLogSevere(se);
			}
		}
		return flag;

	}

	public CoreList getuserdetails() {
		CoreList v = new CoreList();
		java.sql.Connection con = null;
		ProfileForm profile = null;
		try {
			con = getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery("select userid,loginid from userdetails");

			while (rs.next()) {
				profile = new ProfileForm();
				profile.setUserid(rs.getInt(1));
				profile.setLoginid(rs.getString(2));
				v.add(profile);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				LoggerManager.writeLogInfo(e);
			}
		}
		return v;
	}
}
/*
 * public boolean getImage(int userid,String storepath) { Connection con=null;
 * try{ con=getConnection(); Statement s=con.createStatement(); ResultSet
 * rs=s.executeQuery("select photograph from userdetails where userid="+userid);
 * if(rs.next()){ Blob b =rs.getBlob(1); byte
 * b1[]=b.getBytes(1,(int)b.length());//new byte[(int)b.length()]; //InputStream
 * in=photo.getBinaryStream(); OutputStream fout=new
 * FileOutputStream("e:/hanuma1.wmv"); fout.write(b1); // int k=0;
 * //System.out.println(k); while((k=in.read())!=-1){ fout.write(k);
 * k=in.read(); } } if(rs.next()){ System.out.println(""+rs.getString(1)); } }
 * 
 * catch(Exception e){ e.printStackTrace(); } } } }
 */