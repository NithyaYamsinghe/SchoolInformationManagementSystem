package com.oop.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.oop.model.ContactUs;
import com.oop.util.CommonConstants;
//import com.oop.util.CommonUtilContactUs;
//import com.oop.util.DBConnectionUtilContactUs;
//import com.oop.util.QueryUtilContactUs

import com.oop.util.CommonUtil;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;


public class ContactUsServiceImpl implements IContactUsService {
	
	
	public static final Logger log = Logger.getLogger(ContactUsServiceImpl.class.getName());

	private static Connection connection;

	//private static Statement statement;
	

	private PreparedStatement preparedStatement;
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public void addContactUs(ContactUs contactus) {
	
		
		
		String contactusID = CommonUtil.generatecontactusIDs(getContactUsIDs());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in EmployeeQuery.xml file and use
			 * insert_employee key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_CONTACTUS));
			connection.setAutoCommit(false);
			
			//Generate employee IDs
			contactus.setContactUsID(contactusID);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, contactus.getContactUsID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, contactus.getName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, contactus.getEmail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, contactus.getPhoneNumber());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, contactus.getMessage());
			
			// Add employee
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
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

	@Override
	public ArrayList<ContactUs> getContactUs() {
		return actionOnContactUs(null);
	}
	
	
	
	
	private ArrayList<ContactUs> actionOnContactUs(String contactusID) {

		ArrayList<ContactUs> contactusList = new ArrayList<ContactUs>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching employee it checks whether employee ID is
			 * available
			 */
			if (contactusID != null && !contactusID.isEmpty()) {
				/*
				 * Get employee by ID query will be retrieved from
				 * EmployeeQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CONTACTUS));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, contactusID);
			}
			/*
			 * If employee ID is not provided for get employee option it display
			 * all employees
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_CONTACTUS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ContactUs contactus = new ContactUs();
				contactus.setContactUsID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				contactus.setName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				contactus.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				contactus.setPhoneNumber(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				contactus.setMessage(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				
				contactusList.add(contactus);
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
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
		return contactusList;
	}
	
	
	private ArrayList<String> getContactUsIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of employee IDs will be retrieved from EmployeeQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CONTACTUS_IDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException
				| ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
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
		return arrayList;
	}
	
	
	

}
