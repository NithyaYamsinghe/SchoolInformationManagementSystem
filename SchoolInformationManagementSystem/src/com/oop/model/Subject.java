/**
 * @author IT18257328 L.G.H.V Hemalka 
 * 
 * @version 1.0
 * 
 * 
 * 
 */

package com.oop.model;


/**
 * This is the Subject model class
 * 
 * @author IT18257328 L.G.H.V Hemalka
 * @version 1.0
 */


public class Subject {

	private String SubjectID;

	private String SubjectName;

	private String TeacherID;

	private String TeacherName;

	private String Credits;

	private String DeliveringGrade;

	private String Department;
	
	/**
	 * @return the subjectID
	 */

	public String getSubjectID() {
		return SubjectID;
	}

	/**
	 * @param subjectID the subjectID to set
	 */
	
	public void setSubjectID(String subjectID) {
		SubjectID = subjectID;
	}
	
	/**
	 * @return the subjectName
	 */

	public String getSubjectName() {
		return SubjectName;
	}

	/**
	 * @param subjectName the subjectName to set
	 */
	
	public void setSubjectName(String subjectName) {
		SubjectName = subjectName;
	}

	public String getTeacherID() {
		return TeacherID;
	}

	public void setTeacherID(String teacherID) {
		TeacherID = teacherID;
	}

	public String getTeacherName() {
		return TeacherName;
	}

	public void setTeacherName(String teacherName) {
		TeacherName = teacherName;
	}

	public String getCredits() {
		return Credits;
	}

	public void setCredits(String credits) {
		Credits = credits;
	}

	public String getDeliveringGrade() {
		return DeliveringGrade;
	}

	public void setDeliveringGrade(String deliveringGrade) {
		DeliveringGrade = deliveringGrade;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	@Override
	public String toString() {
		return "Subject [SubjectID=" + SubjectID + ", SubjectName=" + SubjectName + ", TeacherID=" + TeacherID
				+ ", TeacherName=" + TeacherName + ", Credits=" + Credits + ", DeliveringGrade=" + DeliveringGrade
				+ ", Department=" + Department + "]";
	}

}
