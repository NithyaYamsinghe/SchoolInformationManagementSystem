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

import com.oop.model.Mark;
import com.oop.service.IStudentMarkService;
import com.oop.service.IStudentMarkServiceImpl;
import com.oop.util.CommonConstants;
import com.oop.util.CommonUtil;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;

public class IStudentMarkServiceImpl implements IStudentMarkService{
	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(IStudentMarkServiceImpl.class.getName());

	private static Connection connection;

	//private static Statement statement;

//	static{
//		//create table or drop if exist
//		createMarkTable();
//	}

	private PreparedStatement preparedStatement;

	/**
	 * This method initially drop existing Marks table in the database and
	 * recreate table structure to insert mark entries
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error
	 * @throws NullPointerException
	 *             - Service is not available
	 * 
	 */
//	public static void createMarkTable() {
//
//		try {
//			connection = DBConnectionUtil.getDBConnection();
//			statement = connection.createStatement();
//			// Drop table if already exists and as per SQL query available in
//			// Query.xml
//			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE));
//			// Create new marks table as per SQL query available in
//			// Query.xml
//			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE));
//
//		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
//			log.log(Level.SEVERE, e.getMessage());
//		}
//	}
//	
	
	

	@Override
	public void addMark(Mark mark) {
		// TODO Auto-generated method stub
		
		String markID = CommonUtil.generateMarksIDs(getMarkIDs());
		Mark markAll = CommonUtil.generateGradeAndPassFail(mark);
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in MarkQuery.xml file and use
			 * insert_mark key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_MARKS));
			connection.setAutoCommit(false);
			
			//Generate mark IDs
			mark.setExamID(markID);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, markAll.getExamID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, markAll.getStudentID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, markAll.getExamName());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FOUR, markAll.getYear());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, markAll.getSubjectName());
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_SIX, markAll.getMarks());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, markAll.getGrade());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, markAll.getRemark());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE,markAll.getPassFail());
			
			//Grade should be decided according to the student's marks
			//String Grade = null;
			//String passFail=null;
			
			//preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, mark.getGrade());
			//preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, mark.getRemark());
			//preparedStatement.setBoolean(CommonConstants.COLUMN_INDEX_NINE, mark.getPassFail());
			
			// Add mark
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
	public Mark updateMark(String markID, Mark mark) {

		@SuppressWarnings("unused")
		Mark markAll = CommonUtil.generateGradeAndPassFail(mark);
		/*
		 * Before fetching mark it checks whether mark ID is available
		 */
		if (markID != null && !markID.isEmpty()) {
			/*
			 * Update mark query will be retrieved from StudentQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_MARK));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, mark.getStudentID());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, mark.getExamName());
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_THREE, mark.getYear());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, mark.getSubjectName());
				preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_FIVE, mark.getMarks());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, mark.getGrade());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, mark.getRemark());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, mark.getPassFail());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE, mark.getExamID());
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
		// Get the updated mark
		return getMarkByID(markID);
	}

	@Override
	public void removeMark(String markID) {
		// TODO Auto-generated method stub
		
		// Before deleting check whether mark ID is available
				if (markID != null && !markID.isEmpty()) {
					/*
					 * Remove mark query will be retrieved from EmployeeQuery.xml
					 */
					try {
						connection = DBConnectionUtil.getDBConnection();
						preparedStatement = connection
								.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_MARK));
						preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, markID);
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
	
	
	private ArrayList<Mark> actionOnMark(String markID) {

		//create a ArrayList
		ArrayList<Mark> markList = new ArrayList<Mark>();
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching mark it checks whether mark ID is
			 * available
			 */
			if (markID != null && !markID.isEmpty()) {
				/*
				 * Get mark by ID query will be retrieved from
				 * StudentQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_MARK));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, markID);
			}
			/*
			 * If mark ID is not provided for get mark option it display
			 * all marks
			 */

			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_MARKS));
				
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Mark mark = new Mark();
				mark.setExamID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				mark.setStudentID(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				mark.setExamName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				mark.setYear(resultSet.getInt(CommonConstants.COLUMN_INDEX_FOUR));
				mark.setSubjectName(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				mark.setMarks(resultSet.getDouble(CommonConstants.COLUMN_INDEX_SIX));
				mark.setGrade(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				mark.setRemark(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				mark.setPassFail(resultSet.getString(CommonConstants.COLUMN_INDEX_NINE));
				markList.add(mark);
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
		return markList;
	}
	
	
	
	
	private ArrayList<String> getMarkIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of mark IDs will be retrieved from StudentQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_MARK_IDS));
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
	
	@Override
	public Mark getMarkByID(String markID) {

		return actionOnMark(markID).get(0);
	}
	
	
	/* this method will take all the records of the given student id 
	 * input = student ID (stdID)
	 * output = markList which is containing all matching the records
	 * */
	public ArrayList<Mark> getAllMarkByID(String stdID) {

		//create a ArrayList
		ArrayList<Mark> markList = new ArrayList<Mark>();
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching mark it checks whether mark ID is
			 * available
			 */
			if (stdID != null && !stdID.isEmpty()) {
				/*
				 * preparedStatement =
				 * connection.prepareStatement(QueryUtil.queryByID(CommonConstants.
				 * QUERY_ID_ALL_MARKS));
				 */
				  
				
				  preparedStatement =
				  connection.prepareStatement(QueryUtil.queryByID(CommonConstants.
				  QUERY_ID_GET_ALL_MARKS_RECORDS_BY_GIVEN_STUDENT_ID));
				  preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, stdID);
				 
			}
			else {
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_MARKS));

			}
			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Mark mark = new Mark();
				mark.setExamID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				mark.setStudentID(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				mark.setExamName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				mark.setYear(resultSet.getInt(CommonConstants.COLUMN_INDEX_FOUR));
				mark.setSubjectName(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				mark.setMarks(resultSet.getDouble(CommonConstants.COLUMN_INDEX_SIX));
				mark.setGrade(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				mark.setRemark(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				mark.setPassFail(resultSet.getString(CommonConstants.COLUMN_INDEX_NINE));
				markList.add(mark);
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
		return markList;

	}
	
	@Override
	public ArrayList<Mark> getMarks() {
		
		return actionOnMark(null);
	}
	

	


}
