

import java.text.ParseException;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ViewController {

	private Integer studentId = 9999;

	private Integer courseId = 10000;
	private Integer examID = 10000;
	private String[] locations = new String[] {"Room A123", "Room A167", "Room B198", "Room B067"};
	private DefaultTableModel courseTableModel;
	private DefaultTableModel examTableModel;
	private DefaultComboBoxModel<String> courseModel;
	private DefaultComboBoxModel<String> examModel;
	private String[] examTableColumns = new String[]{"Exam ID", "Course Code", "Date", "Time", "Location", "Max. Points"};;
	private String[] courseTableColumns = new String[]{"Course Code", "Name", "Credits"};
	private DateLabelFormatter dateFormatter;
	private DefaultComboBoxModel<String> studentModel;
	
	public DateLabelFormatter getDateFormatter() {
		return dateFormatter;
	}

	public void setDateFormatter(DateLabelFormatter dateFormatter) {
		this.dateFormatter = dateFormatter;
	}

	public DefaultTableModel getCourseTableModel() {
		return courseTableModel;
	}

	public void setCourseTableModel(DefaultTableModel courseTableModel) {
		this.courseTableModel = courseTableModel;
	}

	public DefaultTableModel getExamTableModel() {
		return examTableModel;
	}

	public void setExamTableModel(DefaultTableModel examTableModel) {
		this.examTableModel = examTableModel;
	}
	public String[] getExamTableColumns() {
		return examTableColumns;
	}

	public void setExamTableColumns(String[] examTableColumns) {
		this.examTableColumns = examTableColumns;
	}

	public String[] getCourseTableColumns() {
		return courseTableColumns;
	}

	public void setCourseTableColumns(String[] courseTableColumns) {
		this.courseTableColumns = courseTableColumns;
	}

	public DefaultComboBoxModel<String> getCourseModel() {
		return courseModel;
	}

	public void setCourseModel(DefaultComboBoxModel<String> courseModel) {
		this.courseModel = courseModel;
	}

	public DefaultComboBoxModel<String> getExamModel() {
		return examModel;
	}

	public void setExamModel(DefaultComboBoxModel<String> examModel) {
		this.examModel = examModel;
	}

	public DefaultComboBoxModel<String> getStudentModel() {
		return studentModel;
	}

	public void setStudentModel(DefaultComboBoxModel<String> studentModel) {
		this.studentModel = studentModel;
	}

	// Connects to the views

	CourseFrame courseFrame;
	ResultFrame resultFrame;
	StartFrame startFrame;
	StudentFrame studentFrame;

	CourseData courseData;
	ExamData examData;


	// Connects to the data storage
	CourseRegister courseRegister;
	StudentRegister studentRegister;
	ExamRegister examRegister;

	// Constructors
	public ViewController() {
		this.courseRegister = new CourseRegister();
		this.studentRegister = new StudentRegister();
		this.examRegister = new ExamRegister();

		courseFrame = new CourseFrame(this);
		resultFrame = new ResultFrame(this);
		startFrame = new StartFrame(this);
		studentFrame = new StudentFrame(this);

		courseData = new CourseData(this);
		examData = new ExamData(this);
		dateFormatter = new DateLabelFormatter();

	}

	public ViewController(CourseRegister courseRegister, ExamRegister examRegister, StudentRegister studentRegister) {
		this.courseRegister = courseRegister;
		this.examRegister = examRegister;

		this.studentRegister = studentRegister;
		

		studentModel = getStudents();


		courseFrame = new CourseFrame(this);
		resultFrame = new ResultFrame(this);
		startFrame = new StartFrame(this);
		studentFrame = new StudentFrame(this);

		courseData = new CourseData(this);
		examData = new ExamData(this);
		dateFormatter = new DateLabelFormatter();
		courseModel = getCourses();

	}

	// Metoder för CourseView objekt
	public void viewBack() {
		courseFrame.getPanelCourseRegister().setVisible(false);
		courseFrame.getPanelWrittenExams().setVisible(false);
		courseFrame.getPanelWelcome().setVisible(true);
	}
	public void openCourseRegister() {
		courseFrame.getPanelCourseRegister().setVisible(true);
		courseFrame.getPanelWrittenExams().setVisible(false);
		courseFrame.getPanelWelcome().setVisible(false);
	}
	public void openExamRegister() {
		courseFrame.getPanelCourseRegister().setVisible(false);
		courseFrame.getPanelWrittenExams().setVisible(true);
		courseFrame.getPanelWelcome().setVisible(false);
	}
	public void viewNewCourse() {
		courseFrame.getPanelAdd().setVisible(true);
		courseFrame.getPanelEdit().setVisible(false);
		courseFrame.getPanelDelete().setVisible(false);
		courseFrame.getPanelCourseInfo().setVisible(true);
		courseFrame.getPanelChooseCourse().setVisible(false);
	}
	public void viewEditCourse() {
		courseFrame.getPanelAdd().setVisible(false);
		courseFrame.getPanelEdit().setVisible(true);
		courseFrame.getPanelDelete().setVisible(false);
		courseFrame.getPanelCourseInfo().setVisible(true);
		courseFrame.getPanelChooseCourse().setVisible(true);
	}
	public void viewDeleteCourse() {
		courseFrame.getPanelAdd().setVisible(false);
		courseFrame.getPanelEdit().setVisible(false);
		courseFrame.getPanelDelete().setVisible(true);
		courseFrame.getPanelCourseInfo().setVisible(false);
		courseFrame.getPanelChooseCourse().setVisible(true);
	}
	public void viewNewExam() {
		courseFrame.getPanelAddNewExam().setVisible(true);
		courseFrame.getPanelExistingExam().setVisible(false);
		courseFrame.getPanelUnregisterStudent().setVisible(false);
		courseFrame.getPanelRegisterStudent().setVisible(false);
		courseFrame.getPanelCourseForNewExam().setVisible(true);
		courseFrame.getPanelCourseForExam().setVisible(false);
	}
	public void viewRemoveExam() {
		courseFrame.getPanelAddNewExam().setVisible(false);
		courseFrame.getPanelExistingExam().setVisible(true);
		courseFrame.getPanelUnregisterStudent().setVisible(false);
		courseFrame.getPanelRegisterStudent().setVisible(false);
		courseFrame.getPanelCourseForNewExam().setVisible(false);
		courseFrame.getPanelCourseForExam().setVisible(true);
	}
	public void viewRegisterStudent() {
		courseFrame.getPanelAddNewExam().setVisible(false);
		courseFrame.getPanelExistingExam().setVisible(false);
		courseFrame.getPanelUnregisterStudent().setVisible(false);
		courseFrame.getPanelRegisterStudent().setVisible(true);
		courseFrame.getPanelCourseForNewExam().setVisible(false);
		courseFrame.getPanelCourseForExam().setVisible(true);
	}
	public void viewUnregisterStudent() {
		courseFrame.getPanelAddNewExam().setVisible(false);
		courseFrame.getPanelExistingExam().setVisible(false);
		courseFrame.getPanelUnregisterStudent().setVisible(true);
		courseFrame.getPanelRegisterStudent().setVisible(false);
		courseFrame.getPanelCourseForNewExam().setVisible(false);
		courseFrame.getPanelCourseForExam().setVisible(true);
	}
	public void viewCourseData() {
		courseData.getTableCourse().setModel(fetchCourseTableModel());
		courseData.setVisible(true);
	}
	public void goBackFromCourseData() {
		courseData.setVisible(false);
	}
	public void viewExamData() {
		examData.getTableExamData().setModel(fetchExamTableModel());
		examData.setVisible(true);
	}
	public void goBackFromExamData() {
		examData.setVisible(false);
	}

	public void showExceptionWindowForEmptyFields() {
		JOptionPane.showMessageDialog(null, 
                "Some of the fields were empty. Please fill in all the required fields.", 
                "Empty fields", 
                JOptionPane.WARNING_MESSAGE);
	}
	public void showExceptionWindowForUnlinkedExam() {
		JOptionPane.showMessageDialog(null, 
                "The exam is not part of the selected course. Please choose another exam.", 
                "Exam not part of course", 
                JOptionPane.WARNING_MESSAGE);
	}
	public void showExceptionWindowForNoExams() {
		JOptionPane.showMessageDialog(null, 
                "There are no exams on the selected course or no students registered. Please add an exam, choose another course or add a student if there are no students registered.", 
                "No exams on course/No students", 
                JOptionPane.WARNING_MESSAGE);
	}
	public void showExceptionWindowForUnlinkedStudent() {
		JOptionPane.showMessageDialog(null, 
                "The student is not registered for the selected exam. Please choose another student.", 
                "Student not registered for exam", 
                JOptionPane.WARNING_MESSAGE);
	}
	public void showExceptionWindowForCreditParseException() {
		JOptionPane.showMessageDialog(null, 
                "Please only enter integers in the field \"Credits\".", 
                "Non-integer values entered", 
                JOptionPane.WARNING_MESSAGE);
	}
	public void showExceptionWindowForTimeParseException() {
		JOptionPane.showMessageDialog(null, 
                "Please only enter integer values in the \"Time\" fields in the format hh:mm.", 
                "Non-integer values entered", 
                JOptionPane.WARNING_MESSAGE);
	}
	public void showExceptionWindowForNoCourses() {
		JOptionPane.showMessageDialog(null, 
                "There are no courses registered. Please add a course before adding any exams.", 
                "No courses registered", 
                JOptionPane.WARNING_MESSAGE);
	}
	public void showExceptionWindowForNoAvailableIdentifier() {
		JOptionPane.showMessageDialog(null, 
                "There is no memory left for adding new courses. Please delete a course to continue.", 
                "Memory has run out", 
                JOptionPane.WARNING_MESSAGE);
	}
	public String stripString(String comboBoxString) {
		int startIndex = comboBoxString.indexOf(",");
		return comboBoxString.substring(0, startIndex);
	}

	// Methods for CourseView
	public void addCourse(String name, String credits) {

		Course c = new Course();
		try {
			c.setName(name);
		}
		catch (NullPointerException exception) {
			throw new NullPointerException();
		}
		String courseCode = this.generateCourseID();
		c.setCourseCode(courseCode);
		c.setCredits(Integer.parseInt(credits));
		
		courseRegister.addCourse(c);
		
		this.updateCourses();
	}

	public void deleteCourse(String courseString) {
		String courseCode = this.stripString(courseString);
		courseRegister.removeCourse(courseCode);
		courseId = Integer.parseInt(courseCode.substring(1));
		
		this.updateCourses();
	}

	public void editCourse(String courseString, String courseCredits, String name){
		int credits = Integer.parseInt(courseCredits);
		String courseCode = this.stripString(courseString);
		System.out.println(courseString + "stripped to: " + courseCode);
		courseRegister.editCourse(courseCode, name, credits);
		this.updateCourses();
	}
	
	public void addToCourse(String courseString, String examID) {
		String courseCode = this.stripString(courseString);
		Course c = courseRegister.findCourse(courseCode);
		
		WrittenExam e = examRegister.findExam(examID);
		c.addExam(e);
		e.setCourse(c);
	}
	public void removeFromCourse(String courseString, String examID) {
		String courseCode = this.stripString(courseString);
		Course c = courseRegister.findCourse(courseCode);
		c.removeExam(examID);
		examRegister.removeExam(examID);
		this.examID = Integer.parseInt(examID.substring(1));
		
		this.filterExams(courseString);
	}
	
	
	
	public void addNewExamToCourse(Date date, String hours, String minutes, String location, String examID, String courseString) throws ParseException, IllegalArgumentException{
		String courseCode = this.stripString(courseString);
		Course c = courseRegister.findCourse(courseCode);
		WrittenExam e = new WrittenExam();
		
		if (date != null) {
			e.setDate(date);
		}
		else {
			throw new IllegalArgumentException();
		}
		e.setLocation(location);
		e.setExamId(examID);
		int hour = Integer.parseInt(hours);
		int minute = Integer.parseInt(minutes);
		LocalTime time = LocalTime.of(hour, minute);
		e.setTime(time);
		examRegister.addExam(e);
		c.addExam(e);
	}
	public void registerStudent(String studentString, String examID) {
		String studentID = this.stripString(studentString);
		
		Student s = studentRegister.findStudent(studentID);
		WrittenExam e = examRegister.findExam(examID);
		s.registerExam(e);
	}
	public void unregisterStudent(String studentString, String examID) {
		String studentID = this.stripString(studentString);
		Student s = studentRegister.findStudent(studentID);
		s.unregisterExam(examID);
		
		filterStudents(examID);
	}

	public DefaultComboBoxModel<String> getLocations() {
		return new DefaultComboBoxModel<String>(locations);
	}
	
	public DefaultComboBoxModel<String> getCourses() {
		int i = 0;
		HashMap<String, Course> courseList = courseRegister.getCourseList();
		String [] courses = new String [courseList.size()];
				
		for (Map.Entry<String,Course> entry : courseList.entrySet()) {
		    courses[i] = entry.getKey() + ", " + entry.getValue().getName();
		    i++;
		}
		Arrays.sort(courses);
		return new DefaultComboBoxModel<String>(courses);
	}
	public void updateCourses() {
		courseModel = this.getCourses();
		courseFrame.getComboBoxChooseCourse().setModel(courseModel);
		courseFrame.getComboBoxCourseForExam().setModel(courseModel);
		courseFrame.getComboBoxCourseForNewExam().setModel(courseModel);
	}
	public DefaultTableModel fetchExamTableModel() {
		HashMap<String, WrittenExam> examList = examRegister.getRegister();
		Map<String, WrittenExam> sortedExamMap = new TreeMap<String, WrittenExam>(examList);
		
		String[][] examTableData = new String[sortedExamMap.keySet().size()][examTableColumns.length];
		int i = 0;
		for (Map.Entry<String, WrittenExam> entry : sortedExamMap.entrySet()) {
			examTableData[i][0] = entry.getKey();
			examTableData[i][1] = entry.getValue().getCourse().getCourseCode();
			examTableData[i][2] = dateFormatter.valueToString(entry.getValue().getDate());
			examTableData[i][3] = entry.getValue().getTime().toString();
			examTableData[i][4] = entry.getValue().getLocation();
			examTableData[i][5] = "100";
			i++;
		}
		return new DefaultTableModel(examTableData, examTableColumns);
	}
	public DefaultTableModel fetchCourseTableModel() {
		HashMap<String, Course> courseList = courseRegister.getCourseList();
		Map<String, Course> sortedCourseMap = new TreeMap<String, Course>(courseList);
		
		String[][] courseTableData = new String[sortedCourseMap.keySet().size()][courseTableColumns.length];
		int i = 0;
		for (Map.Entry<String, Course> entry : sortedCourseMap.entrySet()) {
			courseTableData[i][0] = entry.getKey();
			courseTableData[i][1] = entry.getValue().getName();
			courseTableData[i][2] = String.valueOf(entry.getValue().getCredits());
			i++;
		}
		return new DefaultTableModel(courseTableData, courseTableColumns);
	}
	public void filterExams(String courseString) {
		String courseCode = this.stripString(courseString);
		Course course = courseRegister.findCourse(courseCode);
		HashMap<String, WrittenExam> examList = course.getExamList();
		
		String [] exams = new String [examList.size()];
		int i = 0;
		for (String key : examList.keySet()) {
			exams[i] = key;
			i++;
		}
		Arrays.sort(exams);
		examModel = new DefaultComboBoxModel<String>(exams);
		
		courseFrame.getComboBoxExamID().setModel(examModel);
		courseFrame.getComboBoxExamIDRegister().setModel(examModel);
		courseFrame.getComboBoxExamIDUnregister().setModel(examModel);
	}
	public void filterStudents(String examID) {
		int i = 0;
		WrittenExam e = examRegister.findExam(examID);
		HashMap<String, Result> resultList = e.getRegister();
		String [] students = new String [resultList.size()];
		
		for (Map.Entry<String, Result> entry : resultList.entrySet()) {
		    students[i] = entry.getKey() + ", " + entry.getValue().getStudent().getName();
		    i++;
		}
		Arrays.sort(students);
		
		DefaultComboBoxModel<String> filteredStudentModel = new DefaultComboBoxModel<String>(students);
		courseFrame.getComboBoxStudentIDUnregister().setModel(filteredStudentModel);
	}

	// Metoder f�r StudentFrame-objekt
	

	public void registerNewStudent(String firstName, String lastName) throws NullPointerException {


		Student tmpStudent = new Student();

		try {
			tmpStudent.setName(firstName + " " + lastName);

		} catch (NullPointerException exception) {
			throw new NullPointerException();
		}
		tmpStudent.setStudentId(this.generateStudentID());
		studentRegister.addStudent(tmpStudent);
	}
	

	public Student editStudent(String studentID, String firstName, String lastName) {
		String fullName = studentRegister.findStudent(studentID).getName();
		String[] split = fullName.split(" ");
		split[0] = firstName;
		split[1] = lastName;
		fullName = split[0] + " " + split[1];

		return studentRegister.editStudent(studentID, fullName);
	}

	public Student deleteStudent(String studentID) {
		return studentRegister.removeStudent(studentID);
	}

	public Student findStudent(String studentID) {
		return studentRegister.findStudent(studentID);
	}

	public String findStudentName(String studentID) {
		return studentRegister.findStudent(studentID).getName();

	}

	public String findStudentiD(String studentID) {
		return studentRegister.findStudent(studentID).getStudentId();

	}

	public DefaultComboBoxModel<String> getStudents() {
		int i = 0;
		HashMap<String, Student> studentList = studentRegister.getStudents();
		String[] students = new String[studentList.size()];

		for (Map.Entry<String, Student> entry : studentList.entrySet()) {
			students[i] = entry.getKey() + ", " + entry.getValue().getName();
			i++;
		}
		Arrays.sort(students);
		return new DefaultComboBoxModel<String>(students);
	}

	public void updateStudents() {
		studentModel = this.getStudents();
		studentFrame.getComboBoxChooseStudent().setModel(studentModel);

	}
  
  public void showExceptionWindowForNoStudent() {
		JOptionPane.showMessageDialog(null, "No Student found.", "No information", JOptionPane.WARNING_MESSAGE);
	}

	public int showConfirmWindowForDeletingStudent() {
		return JOptionPane.showConfirmDialog(null, "This will permanently delete the Student. Do you want to proceed",
				"Important message", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
	}

	public void showExceptionWindowForIDError() {
		JOptionPane.showMessageDialog(null, "Something went wrong. Error Code: ID creation", "Error",
				JOptionPane.WARNING_MESSAGE);
	}

	// ID-generators
	public String generateStudentID() {

		if (studentId < 100000) {
			do {
				studentId++;
			} while ((studentRegister.findStudent("S" + studentId.toString())) != null);
		}


		if (this.studentIDValidation("S" + studentId.toString()) == true) {
			return "S" + studentId.toString();
		} else {
			throw new NullPointerException();
		}
	}

	public synchronized String generateCourseID() {
		if (courseId < 100000) {
			if (courseRegister.findCourse("C" + courseId) == null) {
				if (this.courseIDValidation("C" + courseId)) {
					return "C" + courseId++;
				} else {
					throw new NullPointerException();
				}
			}
			else {
				while (courseRegister.findCourse("C" + courseId) != null) {
					courseId++;
				}
				if (this.courseIDValidation("C" + courseId.toString()) == true) {
					return "C" + studentId.toString();

				} else {
					throw new NullPointerException();
				}
			}
		}
		throw new NullPointerException();
	}
	public String generateExamID() {
		if (examID < 100000) {
			if (examRegister.findExam("E" + examID) == null) {
				if (this.examIDValidation("E" + examID)) {
					return "E" + examID++;
				} else {
					throw new NullPointerException();
				}
			}
			else {
				while (examRegister.findExam("E" + examID) != null) {
					examID++;
				}
				if (this.examIDValidation("E" + examID.toString())) {
					return "E" + examID.toString();
				}

				else {
					throw new NullPointerException();
				}
			}
		}
		throw new NullPointerException();
	}

		

	// ID Validation - matches the entered ID by using regular expressions set to
	// the ID standard

	public boolean studentIDValidation(String id) {
		return id.matches("S[0-9]{5}");

	}

	public boolean courseIDValidation(String id) {
		return id.matches("C[1-9]{1}[0-9]{4}");
	}

	public boolean examIDValidation(String id) {
		return id.matches("E[1-9]{1}[0-9]{4}");
	}

	// View controllers
	public void administrateStudents(ViewController controller) {
		studentFrame.setVisible(true);
		startFrame.setVisible(false);
	}

	public void administrateCourses(ViewController controller) {
		courseFrame.setVisible(true);
		startFrame.setVisible(false);
	}

	public void resultReports(ViewController controller) {
		resultFrame.setVisible(true);
		startFrame.setVisible(false);
	}

	public void returnToMain() {
		startFrame.setVisible(true);
		courseFrame.setVisible(false);
		resultFrame.setVisible(false);
		studentFrame.setVisible(false);


	}

	

	public void registerResultForStudent(String studentId, String examId, int score) {
		Student s = studentRegister.findStudent(studentId);
		 s.getResults().get(examId).setResult(score);
		
}

	public void showStatistics(String examId) {
		WrittenExam writtenExam = examRegister.findExam(examId);
		int amountOfStudentsPassed = writtenExam.calculateNumberOf();
		int median = writtenExam.calculateMedian();
		double average = writtenExam.calculateAverage();
		resultFrame.getLblAm().setText(String.valueOf(amountOfStudentsPassed));	
		resultFrame.getLblM().setText(String.valueOf(median));
		resultFrame.getLblAvg().setText(String.valueOf(average));
	}
	

}

