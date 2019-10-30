/**
 * OOP 2019
 * 
 * @author IT18233704 N.R Yamasinghe
 * 
 * @version 1.0
 * 
 * 
 */
package com.oop.model;


/**
 * This is the Student model class
 * 
 * @author IT18233704 N.R Yamasinghe
 * @version 1.0
 */



public class Student {

	private String StudentID;

	private String Name;

	private String DateOfAdmission;

	private String Address;

	private String DateOfBirth;

	private String GuardianName;

	private String Stream;

	private String Grade;

	private String Division;

	private String Age;

	private String Gender;
	
	private String Email;
	
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
	 * @return the name
	 */

	public String getName() {
		return Name;
	}
	
	/**
	 * @param name the name to set
	 */

	public void setName(String name) {
		Name = name;
	}
	
	/**
	 * @return the dateOdAdmission
	 */

	public String getDateOfAdmission() {
		return DateOfAdmission;
	}
	
	/**
	 * @param dateOdAdmission the dateOdAdmission to set
	 */

	public void setDateOfAdmission(String dateOfAdmission) {
		DateOfAdmission = dateOfAdmission;
	}
	
	/**
	 * @return the address
	 */

	public String getAddress() {
		return Address;
	}
	
	/**
	 * @param address the address to set
	 */

	public void setAddress(String address) {
		Address = address;
	}
	
	/**
	 * @return the dateOfBirth
	 */

	public String getDateOfBirth() {
		return DateOfBirth;
	}
	
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */

	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	
	/**
	 * @return the guardianName
	 */

	public String getGuardianName() {
		return GuardianName;
	}
	
	/**
	 * @param guardianName the guardianName to set
	 */

	public void setGuardianName(String guardianName) {
		GuardianName = guardianName;
	}
	
	/**
	 * @return the stream
	 */

	public String getStream() {
		return Stream;
	}
	
	/**
	 * @param stream the stream to set
	 */

	public void setStream(String stream) {
		Stream = stream;
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
	 * @return the division
	 */

	public String getDivision() {
		return Division;
	}
	
	/**
	 * @param division the division to set
	 */

	public void setDivision(String division) {
		Division = division;
	}
	
	/**
	 * @return the age
	 */

	public String getAge() {
		return Age;
	}
	
	/**
	 * @param age the age to set
	 */


	public void setAge(String age) {
		Age = age;
	}

	/**
	 * @return the gender
	 */
	
	public String getGender() {
		return Gender;
	}
	
	/**
	 * @param gender the gender to set
	 */

	public void setGender(String gender) {
		Gender = gender;
	}

	/**
	 * @return the email
	 */
	
	public String getEmail() {
		return Email;
	}
	

	/**
	 * @param email the email to set
	 */

	public void setEmail(String email) {
		Email = email;
	}

	@Override
	public String toString() {
		return "Student [StudentID=" + StudentID + ", Name=" + Name + ", DateOfAdmission=" + DateOfAdmission
				+ ", Address=" + Address + ", DateOfBirth=" + DateOfBirth + ", GuardianName=" + GuardianName
				+ ", Stream=" + Stream + ", Grade=" + Grade + ", Division=" + Division + ", Age=" + Age + ", Gender="
				+ Gender + ", Email=" + Email + "]";
	}

	
}
