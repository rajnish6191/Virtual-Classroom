/*
 * SecurityDAO.java
 *
 * 
 */

package com.dts.dae.dao;

import com.dts.dae.model.Profile;
import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.CoreList;
import com.dts.core.util.DateWrapper;
import com.dts.core.util.LoggerManager;
import com.yourcompany.struts.form.NewsLetterMasterForm;
import com.yourcompany.struts.form.ProfileForm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Date;
import java.util.Vector;

/**
 * 
 * @author
 */
public class SecurityDAO extends AbstractDataAccessObject {
	Connection con;
	private String desc;
	private boolean flag;

	/** Creates a new instance of SecurityDAO */
	public SecurityDAO() {

		// getting Database Connection

	}

	// Compare Password
	public boolean checkPassword(Profile regbean) {
		String loginid = regbean.getLoginID();
		String oldpassword = regbean.getPassword();

		try {
			con = getConnection();
			con.setAutoCommit(true);
			PreparedStatement pst = con
					.prepareStatement("select * from logindetails where password=? and loginname=?");
			pst.setString(1, oldpassword);
			pst.setString(2, loginid);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				flag = true;
				LoggerManager.writeLogInfo("Login Success");
			} else {
				flag = false;
			}
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
			LoggerManager.writeLogSevere(ex);
			LoggerManager.writeLogInfo("Database Connection problem");
			flag = false;
		}
		return flag;
	}

	// Compare Password
	public int checkFirstLogin(String loginname) {
		int fstatus = 2;
		try {
			con = getConnection();
			con.setAutoCommit(true);
			PreparedStatement pst = con
					.prepareStatement("select firstlogin from logindetails where loginname=?");
			pst.setString(1, loginname);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				fstatus = rs.getInt(1);
			}
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
			LoggerManager.writeLogSevere(ex);
			LoggerManager.writeLogInfo("Database Connection problem");
			flag = false;
		}
		return fstatus;
	}

	public CoreList viewResults(String storepath) {
		CoreList v = new CoreList();
		java.sql.Connection con = null;
		ProfileForm nlform = null;
		try {
			con = getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery("select n.resultid,n.results,n.resultname from result n");

			while (rs.next()) {
				nlform = new ProfileForm();
				int id = rs.getInt(1);
				nlform.setResultid(rs.getInt(1));
				Blob b = rs.getBlob(2);
				byte b1[] = b.getBytes(1, (int) b.length());
				OutputStream fout = new FileOutputStream(storepath + "/" + id
						+ ".doc");
				fout.write(b1);
				nlform.setResult(id + ".doc");
				nlform.setResultname(rs.getString(3));
				v.add(nlform);
			}

		} catch (Exception e) {
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

	// Login Check
	public String loginCheck(ProfileForm regbean) {
		String loginid = regbean.getLoginid();
		String password = regbean.getPassword();
		String role = "ee";
		try {
			con = getConnection();
			con.setAutoCommit(true);
			CallableStatement cstmt = con
					.prepareCall("{call logincheck(?,?,?)}");
			cstmt.setString(1, loginid);
			cstmt.setString(2, password);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			cstmt.execute();
			role = cstmt.getString(3);
			System.out.println("logintype=" + role);

		} catch (SQLException ex) {
			ex.printStackTrace();
			LoggerManager.writeLogSevere(ex);
			desc = "Database Connection problem";
			flag = false;
		}
		// loginaudit(loginid,desc);
		return role;
	}

	// checkuser action
	public String checkUser(String userName) {
		String user = null;
		System.out.println("username" + userName);
		try

		{
			con = getConnection();
			con.setAutoCommit(true);
			PreparedStatement pstmt = con
					.prepareStatement("select loginid from userdetails where loginid=?");
			pstmt.setString(1, userName);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
				user = rs.getString(1);
			con.close();
		} catch (SQLException ex) {
			LoggerManager.writeLogSevere(ex);
			user = null;
		} catch (Exception e) {
			LoggerManager.writeLogSevere(e);
			user = null;
		}
		return user;
	}

	// Method for login audit
	public void loginaudit(String loginid, String desc) {
		try {
			con = getConnection();
			String newdate = DateWrapper.parseDate(new Date());
			PreparedStatement cstmt = con
					.prepareStatement("insert into loginaudit values(?,?,?)");
			cstmt.setString(1, loginid);
			cstmt.setString(2, newdate);
			cstmt.setString(3, desc);
			int i = cstmt.executeUpdate();
			if (i == 1)
				con.commit();
			else
				con.rollback();
			con.close();
		} catch (Exception e) {
			try {
				e.printStackTrace();
				con.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
				LoggerManager.writeLogSevere(ex);
			}
			e.printStackTrace();
		}
	}

	public boolean postFeedback(ProfileForm regbean) {
		String feedback = regbean.getFeedback();
		String loginid = regbean.getLoginid();
		try {
			con = getConnection();
			con.setAutoCommit(false);
			String newdate = DateWrapper.parseDate(new Date());
			PreparedStatement cstmt = con
					.prepareStatement("insert into feedback values(?,?)");
			cstmt.setString(1, loginid);
			cstmt.setString(2, feedback);
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
			ex.printStackTrace();
			LoggerManager.writeLogSevere(ex);
			flag = false;
			try {
				con.rollback();
			} catch (SQLException sex) {
				LoggerManager.writeLogSevere(sex);
			}

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException sex) {
				sex.printStackTrace();
				LoggerManager.writeLogSevere(sex);
			}
		}
		return flag;
	}
	public CoreList viewFeedbacks() {
		CoreList v = new CoreList();
		java.sql.Connection con = null;
		ProfileForm nlform = null;
		try {
			con = getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery("select * from feedback");

			while (rs.next()) {
				nlform = new ProfileForm();
				//int loginid = rs.getInt(1);
				nlform.setLoginid(rs.getString(1));
				
				nlform.setFeedback(rs.getString(2));
				v.add(nlform);
			}

		} catch (Exception e) {
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

	// Change Password
	public boolean changePassword(ProfileForm regbean) {
		String loginid = regbean.getLoginid();
		String oldpassword = regbean.getPassword();
		String newpassword = regbean.getNewpassword();
		try {
			con = getConnection();
			con.setAutoCommit(false);
			String newdate = DateWrapper.parseDate(new Date());
			PreparedStatement cstmt = con
					.prepareStatement("UPDATE userdetails SET password=? WHERE loginid=? and password=?");

			cstmt.setString(1, newpassword);

			cstmt.setString(2, loginid);
			cstmt.setString(3, oldpassword);

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
			ex.printStackTrace();
			LoggerManager.writeLogSevere(ex);
			flag = false;
			try {
				con.rollback();
			} catch (SQLException sex) {
				LoggerManager.writeLogSevere(sex);
			}

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException sex) {
				sex.printStackTrace();
				LoggerManager.writeLogSevere(sex);
			}
		}
		return flag;
	}

	// faculty changePassword
	// Change Password
	public boolean changeFacultyPassword(ProfileForm regbean) {
		String loginid = regbean.getLoginid();
		String oldpassword = regbean.getPassword();
		String newpassword = regbean.getNewpassword();
		try {
			con = getConnection();
			con.setAutoCommit(false);
			String newdate = DateWrapper.parseDate(new Date());
			PreparedStatement cstmt = con
					.prepareStatement("UPDATE facultymaster SET password=? WHERE fname=? and password=?");

			cstmt.setString(1, newpassword);

			cstmt.setString(2, loginid);
			cstmt.setString(3, oldpassword);

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
			ex.printStackTrace();
			LoggerManager.writeLogSevere(ex);
			flag = false;
			try {
				con.rollback();
			} catch (SQLException sex) {
				LoggerManager.writeLogSevere(sex);
			}

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException sex) {
				sex.printStackTrace();
				LoggerManager.writeLogSevere(sex);
			}
		}
		return flag;
	}

	// Change Secret Question
	public boolean changeQuestion(Profile regbean) {
		String loginid = regbean.getLoginID();
		String password = regbean.getPassword();
		String secretquestid = regbean.getSecretQuestionID();
		String ownsecretquest = regbean.getOwnSecretQuestion();
		String secretans = regbean.getSecretAnswer();

		PreparedStatement cstmt;
		int i = 0;
		try {
			if (checkPassword(regbean)) {
				con = getConnection();
				con.setAutoCommit(false);

				cstmt = con
						.prepareStatement("UPDATE logindetails SET squestionid=?,sanswer=? WHERE loginname=? and password=?");

				cstmt.setString(1, secretquestid);
				cstmt.setString(2, secretans);
				cstmt.setString(3, loginid);
				cstmt.setString(4, password);

				i = cstmt.executeUpdate();
				if (i == 1) {
					flag = true;
					con.commit();
				} else {
					flag = false;
					con.rollback();
				}
			}
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
			LoggerManager.writeLogSevere(ex);
			flag = false;
			try {
				con.rollback();
			} catch (SQLException sex) {
				LoggerManager.writeLogSevere(sex);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LoggerManager.writeLogSevere(e);
			flag = false;
			try {
				con.rollback();
			} catch (SQLException sex) {
				LoggerManager.writeLogSevere(sex);
			}
		}
		return flag;
	}

	// Recover Password using Existed Question
	public String recoverPasswordByExistQuestion(Profile regbean) {
		String password;
		String loginid = regbean.getLoginID();
		String secretquestid = regbean.getSecretQuestionID();
		String secretans = regbean.getSecretAnswer();
		System.out.println(loginid);
		System.out.println(secretquestid);
		System.out.println(secretans);
		try {
			con = getConnection();
			con.setAutoCommit(true);
			PreparedStatement cstmt = con
					.prepareStatement("SELECT password FROM userdetails  WHERE loginid=? and FORGOTPWQUESTION=? and FORGOTPWANSWER=?");

			cstmt.setString(1, loginid);
			cstmt.setString(2, secretquestid);
			cstmt.setString(3, secretans);

			ResultSet rs = cstmt.executeQuery();

			if (rs.next())
				password = rs.getString(1);
			else
				password = "";
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
			LoggerManager.writeLogSevere(ex);
			password = "";
		} catch (Exception e) {
			LoggerManager.writeLogSevere(e);
			password = "";
		}
		return password;
	}

	// Recover Password using OWN Question
	public String recoverPasswordByOWNQuestion(Profile regbean) {
		System.out.println("recoverPasswordByOWNQuestion(Profile regbean)"
				+ regbean.getOwnSecretQuestion());
		String password;
		String loginid = regbean.getLoginID();
		String ownsecretquest = regbean.getOwnSecretQuestion();
		String secretans = regbean.getSecretAnswer();
		try {
			con = getConnection();
			con.setAutoCommit(true);
			PreparedStatement cstmt = con
					.prepareStatement("SELECT password FROM logindetails  WHERE loginname=? and squestionid=(select questionid from questionbase where questiondetail=?) and sanswer=?");

			cstmt.setString(1, loginid);
			cstmt.setString(2, ownsecretquest);
			cstmt.setString(3, secretans);

			ResultSet rs = cstmt.executeQuery();

			if (rs.next())

				password = rs.getString(1);

			else
				password = "";
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
			LoggerManager.writeLogSevere(ex);
			password = "";
		} catch (Exception e) {
			e.printStackTrace();
			LoggerManager.writeLogSevere(e);
			password = "";
		}
		return password;
	}

	public int getUserID(ProfileForm regbean) {
		String loginid = regbean.getLoginid();
		String password = regbean.getPassword();
		int userid = 0;
		try {
			con = getConnection();

			PreparedStatement cstmt = con
					.prepareStatement("select userid from userdetails where Loginid=? and password=?");
			cstmt.setString(1, loginid);
			cstmt.setString(2, password);
			ResultSet rs = cstmt.executeQuery();
			while (rs.next()) {
				userid = rs.getInt(1);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			LoggerManager.writeLogSevere(ex);
			desc = "Database Connection problem";
			flag = false;
		}
		// loginaudit(loginid,desc);
		return userid;
	}

	public boolean addResult(ProfileForm regbean) {
		String result = regbean.getResult();
		String loginid = regbean.getLoginid();
		System.out.println(regbean.getResult());
		System.out.println(regbean.getResult());
		boolean flag = false;
		try {
			con = getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into result values((select nvl(max(resultid),100)+1 from result),?,?,?)");
			File afile = new File(regbean.getResult());
			FileInputStream fs = new FileInputStream(afile);
			ps.setBinaryStream(1, fs, (int) afile.length());
			ps.setString(2, regbean.getLoginid());
			ps.setString(3, regbean.getResultname());
			int i = ps.executeUpdate();
			if (i > 0)
				flag = true;
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				LoggerManager.writeLogInfo(e);
			}
		}
		return flag;

	}

	public String getUsername(int userid) {
		String username = "";
		Connection con = null;
		try {
			con = getConnection();

			PreparedStatement pst = con
					.prepareStatement("select loginid from userdetails where userid="
							+ userid);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				username = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return username;
	}
}
