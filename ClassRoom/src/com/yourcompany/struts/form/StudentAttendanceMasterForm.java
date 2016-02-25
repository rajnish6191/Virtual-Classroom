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
 * @struts.form name="studentAttendanceMasterForm"
 */
public class StudentAttendanceMasterForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/** studentId property */
	private int studentId;
	private String sname;
	private String cname;
	private String ldate;

	/** attendanceDateTime property */
	private String attendanceDateTime;

	/** attendanceId property */
	private int attendanceId;

	/** courseId property */
	private int courseId;

	/** disconnectedDateTime property */
	private String disconnectedDateTime;

	/** lecturerId property */
	private int lecturerId;

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
			HttpServletRequest request) {
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
	 * Returns the studentId.
	 * @return int
	 */
	public int getStudentId() {
		return studentId;
	}

	/** 
	 * Set the studentId.
	 * @param studentId The studentId to set
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	/** 
	 * Returns the attendanceDateTime.
	 * @return String
	 */
	public String getAttendanceDateTime() {
		return attendanceDateTime;
	}

	/** 
	 * Set the attendanceDateTime.
	 * @param attendanceDateTime The attendanceDateTime to set
	 */
	public void setAttendanceDateTime(String attendanceDateTime) {
		this.attendanceDateTime = attendanceDateTime;
	}

	/** 
	 * Returns the attendanceId.
	 * @return int
	 */
	public int getAttendanceId() {
		return attendanceId;
	}

	/** 
	 * Set the attendanceId.
	 * @param attendanceId The attendanceId to set
	 */
	public void setAttendanceId(int attendanceId) {
		this.attendanceId = attendanceId;
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

	/** 
	 * Returns the disconnectedDateTime.
	 * @return String
	 */
	public String getDisconnectedDateTime() {
		return disconnectedDateTime;
	}

	/** 
	 * Set the disconnectedDateTime.
	 * @param disconnectedDateTime The disconnectedDateTime to set
	 */
	public void setDisconnectedDateTime(String disconnectedDateTime) {
		this.disconnectedDateTime = disconnectedDateTime;
	}

	/** 
	 * Returns the lecturerId.
	 * @return int
	 */
	public int getLecturerId() {
		return lecturerId;
	}

	/** 
	 * Set the lecturerId.
	 * @param lecturerId The lecturerId to set
	 */
	public void setLecturerId(int lecturerId) {
		this.lecturerId = lecturerId;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getLdate() {
		return ldate;
	}

	public void setLdate(String ldate) {
		this.ldate = ldate;
	}
}