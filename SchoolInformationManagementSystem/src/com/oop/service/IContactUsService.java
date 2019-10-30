package com.oop.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.oop.model.ContactUs;


public interface IContactUsService {
	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(IContactUsService.class.getName());


	/**
	 * Add employees for employee table
	 * @param employee
	 */
	public void addContactUs(ContactUs contactus);
	public ArrayList<ContactUs> getContactUs();

}
