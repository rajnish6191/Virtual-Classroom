/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.yourcompany.struts.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 12-11-2008
 * 
 * XDoclet definition:
 * @struts.form name="CourseFacultyMasterForm"
 */
public class CourseFacultyMasterForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/** facultyId property */
	private int facultyId;

	/** descByFaculty property */
	private String descByFaculty;
private String fname;
private String cname;
	/** courseId property */
	private int courseId;

	/*
	 * Generated Methods
	 */

	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request ) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}

	/** 
	 * Returns the facultyId.
	 * @return int
	 */
	public int getFacultyId() {
		return facultyId;
	}

	/** 
	 * Set the facultyId.
	 * @param facultyId The facultyId to set
	 */
	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	/** 
	 * Returns the descByFaculty.
	 * @return String
	 */
	public String getDescByFaculty() {
		return descByFaculty;
	}

	/** 
	 * Set the descByFaculty.
	 * @param descByFaculty The descByFaculty to set
	 */
	public void setDescByFaculty(String descByFaculty) {
		this.descByFaculty = descByFaculty;
	}

	/** 
	 * Returns the courseId.
	 * @return int
	 */
	public int getCourseId() {
		return courseId;
	}

	/** 
	 * Set the courseId.
	 * @param courseId The courseId to set
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
}