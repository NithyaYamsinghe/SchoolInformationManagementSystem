/**
 * 
 */
package com.oop.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.oop.model.Mark;

/**
 * @author R.A.D.B.S.PERERA
 *
 */
public interface IStudentMarkService {
	
	public static final Logger log = Logger.getLogger(IStudentMarkService.class.getName());
	
	public void addMark(Mark mark);
	
	public Mark getMarkByID(String markID);
	
	public ArrayList<Mark> getAllMarkByID(String stdID);
	
	public ArrayList<Mark> getMarks();
	
	public Mark updateMark(String markID, Mark mark);
	
	public void removeMark(String markID);

	
	

}
