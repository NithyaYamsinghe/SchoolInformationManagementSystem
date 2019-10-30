package com.oop.service;

import com.oop.model.Admin;


import java.util.logging.Logger;


public interface IAdminService {
	
//
//	public int addAdmin(Admin admin);
//	public Admin getAdmin(String userid, String pass);
	
	public static final Logger log = Logger.getLogger(IAdminService.class.getName());
	
	public void addAdmin(Admin admin);
	public void updateAdmin(String username, Admin admin);
	public void deleteAdmin(String username);
	
	

}
