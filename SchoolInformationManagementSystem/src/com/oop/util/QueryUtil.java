/**
 * OOP 2019
 * 
 * @author IT18233704 N.R Yamasinghe 
 * 
 * @version 1.0
 *
 * 
 */
package com.oop.util;



import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



/**
 * This load Sql queries available in the SchoolQuery.xml
 * 
 * @author IT18233704 N.R Yamasinghe
 * @version 1.0
 * @see #CommonUtil
 */

public class QueryUtil extends CommonUtil {
	

	/**
	 * This method read the SchoolQuery.xml file and retrieve the query by
	 * query id.
	 * 
	 * @param id
	 *            QueryID to retrieve elements
	 * 
	 * @return String formatted query will be returned as output
	 * 
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 * @throws IOException
	 *             - This class is the general class of exceptions produced by
	 *             failed or interrupted I/O operations.
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning.
	 * 
	 * @see StudentServiceImpl#addStudents()
	 * @see StudentServiceImpl#createStudentTable()
	 * @see StudentServiceImpl#displayAllStudents()
	 * @see StudentServiceImpl#removeStudent(String)
	 * @see TeacherServiceImpl#addTeachers()
	 * @see TeacherServiceImpl#createTeacherTable()
	 * @see TeacherServiceImpl#displayAllTeachers()
	 * @see TeacherServiceImpl#removeTeacher(String)
	 * @see SubjectServiceImpl#addSubjects()
	 * @see SubjectServiceImpl#createSubjectTable()
	 * @see SubjectServiceImpl#displayAllSubjects()
	 * @see SubjectServiceImpl#removeSubject(String)
	 * @see MarksServiceImpl#addMarks()
	 * @see MarksServiceImpl#createMarksTable()
	 * @see MarksServiceImpl#displayAllMarks()
	 * @see MarksServiceImpl#removeMarks(String)
	 */
	
	
	public static String queryByID(String id) throws SAXException, IOException, ParserConfigurationException {

		NodeList nodeList;
		Element element = null;
		/*
		 * Read the SchoolQuery.xml file and read each query node into node
		 * list. It refers tag name query
		 */
		nodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(System.getProperty("catalina.base") + "\\wtpwebapps\\SchoolInformationManagementSystem\\WEB-INF\\SchoolQuery.xml"))
				.getElementsByTagName(CommonConstants.TAG_NAME);

		/*
		 * Extract the node from node list using query id query id is taken from
		 * query node attribute
		 */
		for (int value = 0; value < nodeList.getLength(); value++) {
			element = (Element) nodeList.item(value);
			if (element.getAttribute(CommonConstants.ATTRIB_ID).equals(id))
				break;
		}
		return element.getTextContent().trim();
	}

}
