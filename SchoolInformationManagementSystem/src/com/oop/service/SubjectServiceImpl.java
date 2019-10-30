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



import com.oop.util.CommonConstants;
import com.oop.util.CommonUtil;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;
import com.oop.model.Subject;

public class SubjectServiceImpl implements ISubjectService {
	
	public static final Logger log = Logger.getLogger(SubjectServiceImpl.class.getName());
	
	private static Connection connection;

	//private static Statement statement;
	
	
	/*static{
		//create table or drop if exist
		createSubjectTable();
	}*/
	
	private static PreparedStatement preparedStatement;
	
	
	
	/*public static void createSubjectTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE_SUBJECT));
			// Create new employees table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE_SUBJECT));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}*/

	
	@Override
	public void addSubject(Subject subject) {
		
		String subjectID = CommonUtil.generatesubjectIDs(getSubjectIDs());
		
		
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in EmployeeQuery.xml file and use
			 * insert_employee key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_SUBJECTS));
			connection.setAutoCommit(false);
			
			//Generate employee IDs
			subject.setSubjectID(subjectID);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, subject.getSubjectID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO,  subject.getSubjectName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE,  subject.getTeacherID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR,  subject.getTeacherName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE,  subject.getCredits());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX,  subject.getDeliveringGrade());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN,  subject.getDepartment());
			
			
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
	public Subject getSubjectByID(String subjectID) {
		return actionOnSubject(subjectID).get(0);
	}

	@Override
	public ArrayList<Subject> getSubjects() {
		return actionOnSubject(null);
	}


	@Override
	public void removeSubject(String subjectID) {

		// Before deleting check whether employee ID is available
		if (subjectID != null && !subjectID.isEmpty()) {
			/*
			 * Remove employee query will be retrieved from EmployeeQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_SUBJECT));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, subjectID);
				preparedStatement.executeUpdate();
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
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

	}
	
	
	

	private ArrayList<Subject> actionOnSubject(String subjectID) {

		ArrayList<Subject> subjectList = new ArrayList<Subject>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching employee it checks whether employee ID is
			 * available
			 */
			if (subjectID != null && !subjectID.isEmpty()) {
				/*
				 * Get employee by ID query will be retrieved from
				 * EmployeeQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_SUBJECT));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, subjectID);
			}
			/*
			 * If employee ID is not provided for get employee option it display
			 * all employees
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_SUBJECTS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Subject subject = new Subject();
				subject.setSubjectID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				subject.setSubjectName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				subject.setTeacherID(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				subject.setTeacherName(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				subject.setCredits(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				subject.setDeliveringGrade(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				subject.setDepartment(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				
				
				subjectList.add(subject);
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
		return subjectList;
	}
	
	
	

	@Override
	public Subject updateSubject(String subjectID, Subject subject) {
		
		
		/*
		 * Before fetching employee it checks whether employee ID is available
		 */
		if (subjectID != null && !subjectID.isEmpty()) {
			/*
			 * Update employee query will be retrieved from EmployeeQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_SUBJECT));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, subject.getSubjectName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, subject.getTeacherID());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, subject.getTeacherName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, subject.getCredits());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, subject.getDeliveringGrade());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, subject.getDepartment());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, subject.getSubjectID());
				
				preparedStatement.executeUpdate();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
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
		// Get the updated employee
		return getSubjectByID(subjectID);
	}
	
	
	
	private ArrayList<String> getSubjectIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of employee IDs will be retrieved from EmployeeQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_SUBJECT_IDS));
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
	
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
public static boolean checkIDAvailable(String subjectID) {
		
		boolean status=false; 
		
			try {
				connection = DBConnectionUtil.getDBConnection();
				
				if (subjectID != null && !subjectID.isEmpty()) {
					
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_CHECK_SUBJECT_ID_AVAILABLE));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, subjectID);
				
				
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
	
	
	
	
	
	
	

}
