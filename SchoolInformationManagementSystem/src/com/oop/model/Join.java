package com.oop.model;

public class Join {

	private String JoinID;
	
	private String Name;
	
	private String BirthDate;
	
	private String Gender;
	
	private String Email;
	
	private String PhoneNumber;
	
	private String Address;
	
	private String City;

	public String getJoinID() {
		return JoinID;
	}

	public void setJoinID(String joinID) {
		JoinID = joinID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(String birthDate) {
		BirthDate = birthDate;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
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

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	@Override
	public String toString() {
		return "Join [JoinID=" + JoinID + ", Name=" + Name + ", BirthDate=" + BirthDate + ", Gender=" + Gender
				+ ", Email=" + Email + ", PhoneNumber=" + PhoneNumber + ", Address=" + Address + ", City=" + City + "]";
	}
	
	
	
}
