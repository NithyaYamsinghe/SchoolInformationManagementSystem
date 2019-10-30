/**
 * OOP 2019
 * 
 * @author IT18257182 H.D Hettihewa
 * @version 1.0
 * 
 * 
 */
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


import com.oop.model.Teacher;
import com.oop.util.CommonConstants;
import com.oop.util.CommonUtil;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;

/**
 * Contract for the implementation of Teacher Service .
 * 
 * @author IT18257182 H.D Hettihewa
 * @version 1.0
 */

public class TeacherServiceImpl implements ITeacherService {
	
	/** Initialize logger */
	
public static final Logger log = Logger.getLogger(TeacherServiceImpl.class.getName());
	
	private static Connection connection;
	
	private static PreparedStatement preparedStatement;

	//private static Statement statement;
	
	
	/*static{
		//create table or drop if exist
		createTeacherTable();
	}*/
	
	/*public static void createTeacherTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE_TEACHER));
			// Create new employees table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE_TEACHER));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}*/
	
	/**
	 * Add set of teachers for as a batch from the selected teachers List
	 * 
	 * @throws SQLException                 - Thrown when database access error
	 *                                      occurs or this method is called on a
	 *                                      closed connection
	 * @throws SAXException                 - Encapsulate a general SAX error or
	 *                                      warning
	 * @throws IOException                  - Exception produced by failed or
	 *                                      interrupted I/O operations.
	 * @throws ParserConfigurationException - Indicates a serious configuration
	 *                                      error.
	 * 
	 */
	

	@Override
	public void addTeacher(Teacher teacher) {
		
		
		String teacherID = CommonUtil.generateteacherIDs(getTeacherIDs());
		
		
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in SchoolQuery.xml file and use
			 * insert_teacher key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_TEACHERS));
			connection.setAutoCommit(false);
			
			//Generate teacher IDs
			teacher.setTeacherID(teacherID);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, teacher.getTeacherID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO,  teacher.getName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE,  teacher.getDateOfRegistration());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR,  teacher.getAddress());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, teacher.getDateOfBirth());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX,  teacher.getSpecialization());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, teacher.getQualification());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT,  teacher.getDepartment());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE,  teacher.getTelephoneNo());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TEN,  teacher.getAge());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ELEVEN, teacher.getGender());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWELVE, teacher.getEmail());
			
			// Add teacher
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
	
	/**
	 * Teacher details can be retrieved based on the provided teacher ID
	 * 
	 * @param teacherID - Teacher details are filtered based on the ID
	 * 
	 * @see #actionOnTeacher()
	 */

	@Override
	public Teacher getTeacherByID(String teacherID) {
		return actionOnTeacher(teacherID).get(0);
	}

	@Override
	public ArrayList<Teacher> getTeachers() {
		return actionOnTeacher(null);
	}

	

	@Override
	public void removeTeacher(String teacherID) {

		// Before deleting check whether employee ID is available
		if (teacherID != null && !teacherID.isEmpty()) {
			/*
			 * Remove employee query will be retrieved from EmployeeQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_TEACHER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, teacherID);
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
	
	
	
	
	
	private ArrayList<Teacher> actionOnTeacher(String teacherID) {

		ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching employee it checks whether employee ID is
			 * available
			 */
			if (teacherID != null && !teacherID.isEmpty()) {
				/*
				 * Get employee by ID query will be retrieved from
				 * EmployeeQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_TEACHER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, teacherID);
			}
			/*
			 * If employee ID is not provided for get employee option it display
			 * all employees
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_TEACHERS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Teacher teacher = new Teacher();
				teacher.setTeacherID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				teacher.setName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				teacher.setDateOfRegistration(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				teacher.setAddress(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				teacher.setDateOfBirth(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				teacher.setSpecialization(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				teacher.setQualification(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				teacher.setDepartment(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				teacher.setTelephoneNo(resultSet.getString(CommonConstants.COLUMN_INDEX_NINE));
				teacher.setAge(resultSet.getString(CommonConstants.COLUMN_INDEX_TEN));
				teacher.setGender(resultSet.getString(CommonConstants.COLUMN_INDEX_ELEVEN));
				teacher.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_TWELVE));
				
				teacherList.add(teacher);
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
		return teacherList;
	}
	
	
	@Override
	public Teacher updateTeacher(String teacherID, Teacher teacher) {
		/*
		 * Before fetching employee it checks whether employee ID is available
		 */
		if (teacherID != null && !teacherID.isEmpty()) {
			/*
			 * Update employee query will be retrieved from EmployeeQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_TEACHER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, teacher.getName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, teacher.getDateOfRegistration());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, teacher.getAddress());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, teacher.getDateOfBirth());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, teacher.getSpecialization());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, teacher.getQualification());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, teacher.getDepartment());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, teacher.getTelephoneNo());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE,teacher.getAge());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TEN, teacher.getGender());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ELEVEN, teacher.getEmail());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWELVE, teacher.getTeacherID());
				
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
		return getTeacherByID(teacherID);
	}
	
	
	private ArrayList<String> getTeacherIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of employee IDs will be retrieved from EmployeeQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_TEACHER_IDS));
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
	

	public static boolean checkIDAvailable(String teacherID) {
		
		boolean status=false; 
		
			try {
				connection = DBConnectionUtil.getDBConnection();
				
				if (teacherID != null && !teacherID.isEmpty()) {
					
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_CHECK_TEACHER_ID_AVAILABLE));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, teacherID);
				
				
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
