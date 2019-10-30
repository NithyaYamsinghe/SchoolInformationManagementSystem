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
 * This is the Admin model class
 * 
 * @author IT18233704 N.R Yamasinghe
 * @version 1.0
 */

public class Admin {
	
	
	private String AdminID;
	
	private String UserName;

	private String Password;

	private String ConfirmPassword;
	
    private String Email;
    
    /**
	 * @return the adminID
	 */

	public String getAdminID() {
		return AdminID;
	}
	
	/**
	 * @param adminID the adminID to set
	 */
	

	public void setAdminID(String adminID) {
		AdminID = adminID;
	}
	
	/**
	 * @return the user name
	 */

	public String getUserName() {
		return UserName;
	}
	
	/**
	 * @param user name the user name to set
	 */

	public void setUserName(String userName) {
		UserName = userName;
	}

	/**
	 * @return the password
	 */
	
	public String getPassword() {
		return Password;
	}
	
	/**
	 * @param password the password to set
	 */

	public void setPassword(String password) {
		Password = password;
	}

	public String getConfirmPassword() {
		return ConfirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		ConfirmPassword = confirmPassword;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@Override
	public String toString() {
		return "Admin [AdminID=" + AdminID + ", UserName=" + UserName + ", Password=" + Password + ", ConfirmPassword="
				+ ConfirmPassword + ", Email=" + Email + "]";
	}
    
    
    

}
