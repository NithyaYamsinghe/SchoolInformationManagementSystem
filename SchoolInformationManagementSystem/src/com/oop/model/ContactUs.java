package com.oop.model;

public class ContactUs {
	
	private String ContactUsID;
	
	private String Name;
	
	private String Email;

	private String PhoneNumber;

	private String Message;
	
	
	public String getContactUsID() {
		return ContactUsID;
	}

	public void setContactUsID(String contactUsID) {
		ContactUsID = contactUsID;
	}


	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	@Override
	public String toString() {
		return "ContactUs [ContactUsID=" + ContactUsID + ", Name=" + Name + ", Email=" + Email + ", PhoneNumber="
				+ PhoneNumber + ", Message=" + Message + "]";
	}

	
	
	

}
