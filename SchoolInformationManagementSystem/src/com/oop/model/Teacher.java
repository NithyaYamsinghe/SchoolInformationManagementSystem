/**
 * OOP 2019
 * 
 * @author IT18257182 H.D Hettihewa
 * 
 * @version 1.0
 * 
 * 
 */
package com.oop.model;

/**
 * This is the Teacher model class
 * 
 * @author IT18257182 H.D Hettihewa
 * @version 1.0
 */


public class Teacher {
	
	
	private String TeacherID;

	private String Name;

	private String DateOfRegistration;

	private String Address;

	private String DateOfBirth;

	private String Specialization;

	private String Qualification;

	private String Department;

	private String TelephoneNo;

	private String Age;

	private String Gender;
	
	private String Email;
	
	/**
	 * @return the teacherID
	 */

	public String getTeacherID() {
		return TeacherID;
	}
	

	/**
	 * @param teacherID the teacherID to set
	 */

	public void setTeacherID(String teacherID) {
		TeacherID = teacherID;
	}
	
	/**
	 * @return the teacher name
	 */

	public String getName() {
		return Name;
	}
	
	/**
	 * @param teacher name  the teacher name to set
	 */

	public void setName(String name) {
		Name = name;
	}
	
	/**
	 * @return the date of registration
	 */

	public String getDateOfRegistration() {
		return DateOfRegistration;
	}
	
	/**
	 * @param date of registration  the date of registration to set
	 */

	public void setDateOfRegistration(String dateOfRegistration) {
		DateOfRegistration = dateOfRegistration;
	}
	
	/**
	 * @return the address
	 */

	public String getAddress() {
		return Address;
	}
	
	/**
	 * @param address  the address to set
	 */


	public void setAddress(String address) {
		Address = address;
	}
	

	/**
	 * @return the date of birth
	 */

	public String getDateOfBirth() {
		return DateOfBirth;
	}
	
	/**
	 * @param date of birth  the date of birth to set
	 */


	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	
	/**
	 * @return the specialization
	 */

	public String getSpecialization() {
		return Specialization;
	}
	
	/**
	 * @param specialization  the specialization to set
	 */


	public void setSpecialization(String specialization) {
		Specialization = specialization;
	}

	/**
	 * @return the qualification
	 */

	public String getQualification() {
		return Qualification;
	}
	
	/**
	 * @param qualification  the qualification to set
	 */


	public void setQualification(String qualification) {
		Qualification = qualification;
	}
	
	/**
	 * @return the department
	 */

	public String getDepartment() {
		return Department;
	}
	
	/**
	 * @param department  the department to set
	 */

	public void setDepartment(String department) {
		Department = department;
	}

	/**
	 * @return the telephone no
	 */
	
	public String getTelephoneNo() {
		return TelephoneNo;
	}
	
	/**
	 * @param telephone no  the telephone no to set
	 */

	public void setTelephoneNo(String telephoneNo) {
		TelephoneNo = telephoneNo;
	}
	
	/**
	 * @return the age
	 */

	public String getAge() {
		return Age;
	}
	
	/**
	 * @param age  the age to set
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
		return "Teacher [TeacherID=" + TeacherID + ", Name=" + Name + ", DateOfRegistration=" + DateOfRegistration
				+ ", Address=" + Address + ", DateOfBirth=" + DateOfBirth + ", Specialization=" + Specialization
				+ ", Qualification=" + Qualification + ", Department=" + Department + ", TelephoneNo=" + TelephoneNo
				+ ", Age=" + Age + ", Gender=" + Gender + ", Email=" + Email + "]";
	}
	
	
	
	

}
