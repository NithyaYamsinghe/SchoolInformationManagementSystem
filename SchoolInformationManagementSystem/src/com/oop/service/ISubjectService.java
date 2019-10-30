/**
 * OOP 2019
 * 
 * @author IT18257328 L.G.H.V Hemalka
 * 
 * @version 1.0
 * 
 * 
 */
package com.oop.service;

import java.util.ArrayList;
import java.util.logging.Logger;


import com.oop.model.Subject;

public interface ISubjectService {
	

	public static final Logger log = Logger.getLogger(ISubjectService.class.getName());
	
	public void addSubject(Subject subject);
	
	public Subject getSubjectByID(String subjectID);
	
	public ArrayList<Subject> getSubjects();
	
	public Subject updateSubject(String subjectID, Subject subject);
	
	public void removeSubject(String subjectID);
	
	

}
