package com.oop.service;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//import com.oop.model.Admin;
//import com.oop.util.MyConnectionProvider;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import com.oop.model.Admin;
import java.sql.ResultSet;
//import java.util.ArrayList;
import com.oop.util.CommonConstants;
//import com.oop.util.CommonUtil;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;




public class AdminServiceImpl implements IAdminService {
	
	
	public static final Logger log = Logger.getLogger(AdminServiceImpl.class.getName());

	private static Connection connection;

	//private static Statement statement;

	private static PreparedStatement preparedStatement;

	
public void addAdmin(Admin admin) {

		
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_ADMIN));
			connection.setAutoCommit(false);
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, admin.getUserName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, admin.getEmail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE,admin.getPassword());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, admin.getConfirmPassword());
			

			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {

			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}



public static String[] getname(String username) {
	//String[] n={"s1", "s2","s3"}; 
	String[] n={"s1", "s2","s3", "s4", "s5"}; 
	try {
		connection = DBConnectionUtil.getDBConnection();
		
				preparedStatement = connection
				.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ADMIN));
	preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, username);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while (resultSet.next()) {
		 n[0]=resultSet.getString(CommonConstants.COLUMN_INDEX_ONE);	
		 n[1]=resultSet.getString(CommonConstants.COLUMN_INDEX_TWO);
		 n[2]=resultSet.getString(CommonConstants.COLUMN_INDEX_THREE);	
		 n[3]=resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR);
		
		
		 
		}
	
	}
	catch (SQLException | SAXException | IOException | ParserConfigurationException
			| ClassNotFoundException e) {
		log.log(Level.SEVERE, e.getMessage());
	}
	finally {
		
		try {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	return n;
}




public static boolean validateLogin(String username , String password) {
	
	boolean status=false; 
	
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
				
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_VALIDATE_GET_ADMIN));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, username);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			status = resultSet.next();
			
			}

			else {
				
			}
		}	
		catch (SQLException | SAXException | IOException | ParserConfigurationException
				| ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		finally {
			
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			}
			catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	return status;
}

	
	
	public static boolean checkUserNameAvailable(String username) {
	
	boolean status=false; 
	
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			if (username != null && !username.isEmpty()) {
				
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_USERNAME_GET_ADMIN));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, username);
			
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			status = resultSet.next();
			
			}

			else {
				
			}
		}	
		catch (SQLException | SAXException | IOException | ParserConfigurationException
				| ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		finally {
			
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			}
			catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	return status;
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void updateAdmin(String username, Admin admin) {
		 
		if (username != null && !username.isEmpty()) {
			
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_UPDATE_ADMIN));
				
				
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, admin.getEmail());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, admin.getPassword());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, admin.getConfirmPassword());


				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, admin.getUserName());
				
				
				preparedStatement.executeUpdate();
               
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
	
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	

	
public void deleteAdmin(String username) {
		
		if (username != null && !username.isEmpty()) {
			
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_ADMIN));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, username);
				preparedStatement.executeUpdate();
			}
			catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				}
				catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	static Connection con;
//	static PreparedStatement ps;
//
//	@Override
//	public int addAdmin(Admin admin) {
//		
//		
//		@SuppressWarnings("unused")
//		int status = 0;
//		try {
//			
//			
//			
//			
//			con = MyConnectionProvider.getCon();
//			ps = con.prepareStatement("INSERT INTO admin VALUES(?,?,?,?)");
//			ps.setString(1,admin.getUserName() );
//			ps.setString(2, admin.getEmail());
//			ps.setString(3, admin.getPassword());
//			ps.setString(4, admin.getConfirmPassword());
//			
//			status = ps.executeUpdate();
//			con.close();
//			
//		}catch(Exception e)
//		{
//			
//			System.out.println(e);
//		}
//		
//		
//		return 0;
//	}
//
//	@Override
//	public Admin getAdmin(String userid, String pass) {
//		Admin admin = new Admin();
//		
//		
//		try {
//			
//			con = MyConnectionProvider.getCon();
//			ps = con.prepareStatement("SELECT * FROM admin WHERE adminUserName=? AND password=?");
//			ps.setString(1,userid);
//			ps.setString(2, pass);
//			
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next())
//			{
//				
//				admin.setUserName(rs.getString(1));
//				admin.setEmail(rs.getString(2));
//				admin.setPassword(rs.getString(3));
//				admin.setConfirmPassword(rs.getString(4));
//				
//			}
//			
//	
//		}catch(Exception e)
//		{
//			
//			System.out.println(e);
//		}
//		return admin;
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
