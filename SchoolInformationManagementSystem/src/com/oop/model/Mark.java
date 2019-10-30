package com.oop.model;


public class Mark {
	
	private String ExamID;
	
	private String StudentID;

	private String ExamName;

	private int Year;

	private String SubjectName;

	private double Marks;
	
	private String Grade;
	
	private String Remark;
	
	private String passFail;

	/**
	 * @return the examID
	 */
	public String getExamID() {
		return ExamID;
	}

	/**
	 * @param examID the examID to set
	 */
	public void setExamID(String examID) {
		ExamID = examID;
	}

	/**
	 * @return the studentID
	 */
	public String getStudentID() {
		return StudentID;
	}

	/**
	 * @param studentID the studentID to set
	 */
	public void setStudentID(String studentID) {
		StudentID = studentID;
	}

	/**
	 * @return the examName
	 */
	public String getExamName() {
		return ExamName;
	}

	/**
	 * @param examName the examName to set
	 */
	public void setExamName(String examName) {
		ExamName = examName;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return Year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		Year = year;
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

	/**
	 * @return the marks
	 */
	public double getMarks() {
		return Marks;
	}

	/**
	 * @param marks the marks to set
	 */
	public void setMarks(double marks) {
		Marks = marks;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return Grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		Grade = grade;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return Remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		Remark = remark;
	}

	/**
	 * @return the passFail
	 */
	public String getPassFail() {
		return passFail;
	}

	/**
	 * @param passFail the passFail to set
	 */
	public void setPassFail(String passFail) {
		this.passFail = passFail;
	}

	@Override
	public String toString() {
		return "ExamID=" + ExamID + ", StudentID=" + StudentID + ", ExamName=" + ExamName + ", Year=" + Year
				+ ", SubjectName=" + SubjectName + ", Marks=" + Marks + ", Grade=" + Grade + ", Remark=" + Remark
				+ ", passFail=" + passFail;
	}

	
	
	

}
