/**
 * OOP 2019
 * 
 * @author IT18233704 N.R Yamasinghe
 * 
 * @version 1.0
 * 
 * 
 */

package com.oop.service;

import com.oop.model.Student;
import java.util.ArrayList;
import java.util.logging.Logger;


/**
 * Contract for the implementation of Student Service .
 * 
 * @author IT18233704 N.R Yamasinghe
 * @version 1.0
 */



public interface IStudentService {
	
	/** Initialize logger */
	
	public static final Logger log = Logger.getLogger(IStudentService.class.getName());
	

	/**
	 * Add students for students table
	 * @param students
	 */
	
	public void addStudent(Student student);
	
	/**
	 * Get a particular Student
	 * 
	 * @param studentID
	 * @return Student
	 */
	
	public Student getStudentByID(String studentID);
	
	/**
	 * Get all list of students
	 * 
	 * @return ArrayList<Student>
	 */
	
	public ArrayList<Student> getStudents();
	
	/**
	 * Update existing student
	 * @param studentID
	 * @param student
	 * 
	 * @return
	 */
	
	public Student updateStudent(String studentID, Student student);
	
	/**
	 * Remove existing student
	 * 
	 * @param studentID
	 */
	
	public void removeStudent(String studentID);
	
	
}
