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


import com.oop.model.Join;
import com.oop.util.CommonConstants;
//import com.oop.util.CommonUtilJoin;
//import com.oop.util.DBConnectionUtilJoin;
//import com.oop.util.QueryUtilJoin;

import com.oop.util.CommonUtil;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;


public class JoinServiceImpl implements IJoinService {
	
	
	

	public static final Logger log = Logger.getLogger(JoinServiceImpl.class.getName());

	private static Connection connection;

	//private static Statement statement;
	

	private PreparedStatement preparedStatement;
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public void addJoin(Join join) {
		
		
		String joinID = CommonUtil.generatejoinIDs(getJoinIDs());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in EmployeeQuery.xml file and use
			 * insert_employee key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_JOIN));
			connection.setAutoCommit(false);
			
			//Generate employee IDs
			join.setJoinID(joinID);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, join.getJoinID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, join.getName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, join.getBirthDate());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, join.getGender());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, join.getEmail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, join.getPhoneNumber());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, join.getAddress());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, join.getCity());
			
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
	public ArrayList<Join> getJoin() {
		return actionOnJoin(null);
	}
	
	
	
	private ArrayList<Join> actionOnJoin(String joinID) {

		ArrayList<Join> joinList = new ArrayList<Join>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching employee it checks whether employee ID is
			 * available
			 */
			if (joinID != null && !joinID.isEmpty()) {
				/*
				 * Get employee by ID query will be retrieved from
				 * EmployeeQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_JOIN));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, joinID);
			}
			/*
			 * If employee ID is not provided for get employee option it display
			 * all employees
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_JOIN));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Join join = new Join();
				join.setJoinID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				join.setName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				join.setBirthDate(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				join.setGender(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				join.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				join.setPhoneNumber(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				join.setAddress(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				join.setCity(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				
				joinList.add(join);
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
		return joinList;
	}
	
	
	
private ArrayList<String> getJoinIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of employee IDs will be retrieved from EmployeeQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_JOIN_IDS));
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
