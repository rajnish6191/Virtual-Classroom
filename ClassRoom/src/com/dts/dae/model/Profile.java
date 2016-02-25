/*
 * RegistrationBean.java
 *
 * 
 */

package com.dts.dae.model;

import java.sql.Date;

 

/**
 *
 * @author 
 */
public class Profile   {

    private String secretqid;
    
    private String photo;
    
    private String id;
    private String password;
    private String newpassword;
    private String firstname;
    private String lastname;
    private String logintype;
    private String fax;
    private String email;
    
    private String home;
    private String office;
    private String contact;
    
    
    private int status;
    private String date;
    private int roleid;
    private int flogin;
    private String timezone;
    private String courseStatus;
    private String pin;
    private String phone;
    private String city;
    private String hno;
    private String street;
    private String state;
    private String country;
    
    private String opin;
    private String ophone;
    private String ocity;
    private String ohno;
    private String ostreet;
    private String ostate;
    private String ocountry;
    
    private String cpin;
    private String cphone;
    private String ccity;
    private String chno;
    private String cstreet;
    private String cstate;
    private String ccountry;
    
    private String bdate;
    private Date birthDate1;
    private String locale;
    private String secretqans;
    private String ownsecretq;
    private String passwordmoddate;
    private String profilemoddate;
    
    private String officePhoneType;
    private String homePhoneType;
    private String personalPhoneType;
    
    private int courseid;
    private String coursenamse;
    private int userid;
    public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public String getCoursenamse() {
		return coursenamse;
	}

	public void setCoursenamse(String coursenamse) {
		this.coursenamse = coursenamse;
	}

	public String getOfficePhoneType() {
		return officePhoneType;
	}

	public void setOfficePhoneType(String officePhoneType) {
		this.officePhoneType = officePhoneType;
	}

	public String getHomePhoneType() {
		return homePhoneType;
	}

	public void setHomePhoneType(String homePhoneType) {
		this.homePhoneType = homePhoneType;
	}

	public String getPersonalPhoneType() {
		return personalPhoneType;
	}

	public void setPersonalPhoneType(String personalPhoneType) {
		this.personalPhoneType = personalPhoneType;
	}

	/** Creates a new instance of RegistrationBean */
    public Profile() {
    }
    
    public void setLoginID(String id)
    {
        this.id=id;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }
    public void setNewPassword(String newpassword)
    {
        this.newpassword=newpassword;
    }
    public void setFirstName(String firstname)
    {
        this.firstname=firstname;
    }
    public void setLastName(String lastname)
    {
        this.lastname=lastname;
    }
    public void setLoginType(String logintype)
    {
        this.logintype=logintype;
    }
    public void setStatus(int status)
    {
        this.status=status;
    }
    public void setRegDate(String date)
    {
        this.date=date;
    }
    public void setSecretQuestionID(String secretqid)
    {
        this.secretqid=secretqid;
    }
    public void setOwnSecretQuestion(String ownsecretq)
    {
        this.ownsecretq=ownsecretq;
    }
    public void setSecretAnswer(String secretqans)
    {
        this.secretqans=secretqans;
    }
    public void setFirstLogin(int flogin)
    {
        this.flogin=flogin;
    }
    public void setRoleId(int roleid)
    {
        this.roleid=roleid;
    }
    public void setBirthDate(String bdate)
    {
        this.bdate=bdate;
    }
    public void setCity(String city)
    {
        this.city=city;
    }     
    public void setState(String state)
    {
        this.state=state;
    }
    public void setCountry(String country)
    {
        this.country=country;
    }
    public void setLocale(String locale)
    {
        this.locale=locale;
    }
    public void setTimeZone(String timezone)
    {
        this.timezone=timezone;
    }
    public void setPasswordModifiedDate(String passwordmoddate) 
    {
        this.passwordmoddate=passwordmoddate;
    }
    public void setProfileModifiedDate(String profilemoddate) 
    {
        this.profilemoddate=profilemoddate;
    }    
    //Getter methods used to get the values from bean
    
     public String getLoginID()
    {
        return id;
    }
    public String getPassword()
    {
        return password;
    }
    public String getNewPassword()
    {
        return newpassword;
    }
    public String getFirstName()
    {
        return firstname;
    }
    public String getLastName()
    {
        return lastname;
    }
    public String getLoginType()
    {
        return logintype;
    }
    public int getStatus()
    {
        return status;
    }
    public String getRegDate()
    {
        return date;
    }
    public String getSecretQuestionID()
    {
        return secretqid;
    }
    public String getOwnSecretQuestion()
    {
        return ownsecretq;
    }
    public String getSecretAnswer()
    {
        return secretqans;
    }
    public int getFirstLogin()
    {
        return flogin;
    }
    public int getRoleId()
    {
        return roleid;
    }
    public String getBirthDate()
    {
        return bdate;
    }
    public String getCity()
    {
        return city;
    }     
    public String getState()
    {
        return state;
    }
    public String getCountry()
    {
        return country;
    }
    public String getLocale()
    {
        return locale;
    }
    public String getTimeZone()
    {
        return timezone;
    }

    public String getPasswordModifiedDate() {
        return passwordmoddate;
    }

    public String getProfileModifiedDate() {
        return profilemoddate;
    }

	/**
	 * @return the birthDate1
	 */
	public Date getBirthDate1() {
		return birthDate1;
	}

	/**
	 * @param birthDate1 the birthDate1 to set
	 */
	public void setBirthDate1(Date birthDate1) {
		this.birthDate1 = birthDate1;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getHno() {
		return hno;
	}

	public void setHno(String hno) {
		this.hno = hno;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSecretqid() {
		return secretqid;
	}

	public void setSecretqid(String secretqid) {
		this.secretqid = secretqid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLogintype() {
		return logintype;
	}

	public void setLogintype(String logintype) {
		this.logintype = logintype;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public int getFlogin() {
		return flogin;
	}

	public void setFlogin(int flogin) {
		this.flogin = flogin;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getOpin() {
		return opin;
	}

	public void setOpin(String opin) {
		this.opin = opin;
	}

	public String getOphone() {
		return ophone;
	}

	public void setOphone(String ophone) {
		this.ophone = ophone;
	}

	public String getOcity() {
		return ocity;
	}

	public void setOcity(String ocity) {
		this.ocity = ocity;
	}

	public String getOhno() {
		return ohno;
	}

	public void setOhno(String ohno) {
		this.ohno = ohno;
	}

	public String getOstreet() {
		return ostreet;
	}

	public void setOstreet(String ostreet) {
		this.ostreet = ostreet;
	}

	public String getOstate() {
		return ostate;
	}

	public void setOstate(String ostate) {
		this.ostate = ostate;
	}

	public String getOcountry() {
		return ocountry;
	}

	public void setOcountry(String ocountry) {
		this.ocountry = ocountry;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getSecretqans() {
		return secretqans;
	}

	public void setSecretqans(String secretqans) {
		this.secretqans = secretqans;
	}

	public String getOwnsecretq() {
		return ownsecretq;
	}

	public void setOwnsecretq(String ownsecretq) {
		this.ownsecretq = ownsecretq;
	}

	public String getPasswordmoddate() {
		return passwordmoddate;
	}

	public void setPasswordmoddate(String passwordmoddate) {
		this.passwordmoddate = passwordmoddate;
	}

	public String getProfilemoddate() {
		return profilemoddate;
	}

	public void setProfilemoddate(String profilemoddate) {
		this.profilemoddate = profilemoddate;
	}

	public String getCpin() {
		return cpin;
	}

	public void setCpin(String cpin) {
		this.cpin = cpin;
	}

	public String getCphone() {
		return cphone;
	}

	public void setCphone(String cphone) {
		this.cphone = cphone;
	}

	public String getCcity() {
		return ccity;
	}

	public void setCcity(String ccity) {
		this.ccity = ccity;
	}

	public String getChno() {
		return chno;
	}

	public void setChno(String chno) {
		this.chno = chno;
	}

	public String getCstreet() {
		return cstreet;
	}

	public void setCstreet(String cstreet) {
		this.cstreet = cstreet;
	}

	public String getCstate() {
		return cstate;
	}

	public void setCstate(String cstate) {
		this.cstate = cstate;
	}

	public String getCcountry() {
		return ccountry;
	}

	public void setCcountry(String ccountry) {
		this.ccountry = ccountry;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}

	public String getCourseStatus() {
		return courseStatus;
	}
}
