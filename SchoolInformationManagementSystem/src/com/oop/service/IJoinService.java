package com.oop.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.oop.model.Join;

public interface IJoinService {

	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(IJoinService.class.getName());


	/**
	 * Add employees for employee table
	 * @param employee
	 */
	public void addJoin(Join join);
	public ArrayList<Join> getJoin();
}
