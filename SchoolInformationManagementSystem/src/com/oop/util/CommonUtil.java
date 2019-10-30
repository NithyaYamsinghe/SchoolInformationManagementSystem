package com.oop.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.oop.service.IStudentService;
import com.oop.service.ISubjectService;
import com.oop.service.ITeacherService;
import com.oop.model.Mark;
import com.oop.service.IContactUsService;
import com.oop.service.IJoinService;
import com.oop.service.IStudentMarkService;

public class CommonUtil {

	public static final Logger log = Logger.getLogger(IStudentService.class.getName());
	public static final Logger logteacher = Logger.getLogger(ITeacherService.class.getName());
	public static final Logger logsubject = Logger.getLogger(ISubjectService.class.getName());
	public static final Logger logcontactus = Logger.getLogger(IContactUsService.class.getName());
	public static final Logger logjoin = Logger.getLogger(IJoinService.class.getName());
	public static final Logger logmark = Logger.getLogger(IStudentMarkService.class.getName());

	public static final Properties properties = new Properties();

	static {
		try {

			// Read the property only once when load the class
			properties.load(QueryUtil.class.getResourceAsStream(CommonConstants.PROPERTY_FILE));

		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	public static String generateIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.STUDENT_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.STUDENT_ID_PREFIX + next;
		}
		return id;
	}

	public static String generateteacherIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.TEACHER_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.TEACHER_ID_PREFIX + next;
		}
		return id;
	}

	public static String generatesubjectIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.SUBJECT_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.SUBJECT_ID_PREFIX + next;
		}
		return id;
	}

	public static String generatecontactusIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.CONTACTUS_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.CONTACTUS_ID_PREFIX + next;
		}
		return id;
	}

	public static String generatejoinIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.JOIN_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.JOIN_ID_PREFIX + next;
		}
		return id;
	}

	public static String generateMarksIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.MARK_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.MARK_ID_PREFIX + next;
		}
		return id;
	}

	// this will take mark object from IStudentMarkServiceImpl.java and assign/set
	// values according to the std marks
	// for mark.Grade and mark.passFail attributes
	public static Mark generateGradeAndPassFail(Mark mark) {

		double stdMarks = mark.getMarks();

		if (100 >= stdMarks && stdMarks >= 75) {

			mark.setGrade(CommonConstants.STUDENT_GRADE_A); // mark.grade is set here
			// preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN,
			// mark.getGrade());

			mark.setPassFail(CommonConstants.STUDENT_PASSED); // mark.passfail is set here
			// preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE,mark.getPassFail());
		} else if (75 > stdMarks && stdMarks >= 65) {
			/*
			 * preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, Grade =
			 * CommonConstants.STUDENT_GRADE_B);
			 * preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE,passFail=
			 * CommonConstants.STUDENT_PASSED);
			 */

			mark.setGrade(CommonConstants.STUDENT_GRADE_B); // mark.grade is set here
			// preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN,
			// mark.getGrade());

			mark.setPassFail(CommonConstants.STUDENT_PASSED); // mark.passfail is set here
			// preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE,mark.getPassFail());
		} else if (65 > stdMarks && stdMarks >= 55) {
			/*
			 * preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, Grade =
			 * CommonConstants.STUDENT_GRADE_C_PLUS);
			 * preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE,passFail=
			 * CommonConstants.STUDENT_PASSED);
			 */

			mark.setGrade(CommonConstants.STUDENT_GRADE_C_PLUS); // mark.grade is set here
			// preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN,
			// mark.getGrade());

			mark.setPassFail(CommonConstants.STUDENT_PASSED); // mark.passfail is set here
			// preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE,mark.getPassFail());
		} else if (55 > stdMarks && stdMarks >= 45) {
			/*
			 * preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, Grade =
			 * CommonConstants.STUDENT_GRADE_C_MINUS);
			 * preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE,passFail =
			 * CommonConstants.STUDENT_PASSED);
			 */

			mark.setGrade(CommonConstants.STUDENT_GRADE_C_MINUS); // mark.grade is set here
			// preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN,
			// mark.getGrade());

			mark.setPassFail(CommonConstants.STUDENT_PASSED); // mark.passfail is set here
			// preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE,mark.getPassFail());
		} else if (45 > stdMarks && stdMarks >= 35) {
			/*
			 * preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, Grade =
			 * CommonConstants.STUDENT_GRADE_S);
			 * preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE,passFail =
			 * CommonConstants.STUDENT_PASSED);
			 */

			mark.setGrade(CommonConstants.STUDENT_GRADE_S); // mark.grade is set here
			// preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN,
			// mark.getGrade());

			mark.setPassFail(CommonConstants.STUDENT_PASSED); // mark.passfail is set here
			// preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE,mark.getPassFail());
		} else if (35 > stdMarks && stdMarks >= 0) {
			/*
			 * preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, Grade =
			 * CommonConstants.STUDENT_GRADE_F);
			 * preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE, passFail =
			 * CommonConstants.STUDENT_FAILED);
			 */

			mark.setGrade(CommonConstants.STUDENT_GRADE_F); // mark.grade is set here
			// preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN,
			// mark.getGrade());

			mark.setPassFail(CommonConstants.STUDENT_FAILED); // mark.passfail is set here
			// preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE,mark.getPassFail());
		} else {
			// If some error happens
			mark.setGrade(CommonConstants.STUDENT_GRADE_UNKNOWN); // mark.grade is set here
			// preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN,
			// mark.getGrade());

			mark.setPassFail(CommonConstants.STUDENT_GRADE_UNKNOWN);

		}
		return mark;
	}

}


