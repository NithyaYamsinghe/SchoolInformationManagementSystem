/**
 * OOP 2019
 * 
 * @author IT18257182 H.D Hettihewa
 * 
 * @version 1.0
 * 
 * 
 */
package com.oop.service;

import com.oop.model.Teacher;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Contract for the implementation of Teacher Service .
 * 
 * @author IT18257182 H.D Hettihewa
 * @version 1.0
 */

public interface ITeacherService {

	/** Initialize logger */

	public static final Logger log = Logger.getLogger(ITeacherService.class.getName());

	/**
	 * Add students for teachers table
	 * 
	 * @param teachers
	 */

	public void addTeacher(Teacher teacher);

	/**
	 * Get a particular teacher
	 * 
	 * @param teacherID
	 * @return teacher
	 */

	public Teacher getTeacherByID(String teacherID);

	/**
	 * Get all list of teachers
	 * 
	 * @return ArrayList<Teacher>
	 */

	public ArrayList<Teacher> getTeachers();

	/**
	 * Update existing teacher
	 * 
	 * @param teacherID
	 * @param teacher
	 * 
	 * @return
	 */

	public Teacher updateTeacher(String teacherID, Teacher teacher);

	/**
	 * Remove existing teacher
	 * 
	 * @param teacherID
	 */

	public void removeTeacher(String teacherID);

}
