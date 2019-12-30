
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ViewController {

	private Integer studentId = 9999;
	private Integer courseId = 9999;
	private Integer examID = 9999;
	private String[] locations = new String[] {"Room A123", "Room A167", "Room B198", "Room B067"};

	// Kopplar till gr�nssnitten
	CourseFrame courseFrame;
	ResultFrame resultFrame;
	StartFrame startFrame;
	StudentFrame studentFrame;

	// Kopplar till probl.-omr�deskomponenten
	CourseRegister courseRegister;
	StudentRegister studentRegister;
	ExamRegister examRegister;

	// Konstruktorer

	public ViewController() {
		this.courseRegister = new CourseRegister();
		this.studentRegister = new StudentRegister();
		this.examRegister = new ExamRegister();
		
		courseFrame = new CourseFrame(this);
		resultFrame = new ResultFrame(this);
		startFrame = new StartFrame(this);
		studentFrame = new StudentFrame(this);
	}

	public ViewController(CourseRegister courseRegister, ExamRegister examRegister, StudentRegister studentRegister) {
		this.courseRegister = courseRegister;
		this.examRegister = examRegister;
		this.studentRegister = studentRegister;
		
		courseFrame = new CourseFrame(this);
		resultFrame = new ResultFrame(this);
		startFrame = new StartFrame(this);
		studentFrame = new StudentFrame(this);
	}

	// Metoder för CourseView objekt
	public void addCourse(String courseCode, String name, String credits) throws IntegerParseException{
		Course c = new Course();
		c.setName(name);
		try {
		c.setCredits(Integer.parseInt(credits));
		}
		catch (NumberFormatException exception) {
			throw new IntegerParseException();
		}
		c.setCourseCode(courseCode);
		courseRegister.addCourse(c);
		
		courseFrame.getComboBoxCourseID().addItem(c.getName() + ", " + courseCode);
		courseFrame.getComboBoxChooseCourse().addItem(c.getName() + ", " + courseCode);
	}

	public void deleteCourse(String courseString) {
		courseFrame.getComboBoxCourseID().removeItem(courseString);
		courseFrame.getComboBoxChooseCourse().removeItem(courseString);
		int startIndex = courseString.indexOf(",") + 2;
		int endIndex = courseString.length();
		String courseCode = courseString.substring(startIndex, endIndex);
		courseRegister.removeCourse(courseCode);
		
		courseFrame.getComboBoxCourseID().removeItem(courseString);
		courseFrame.getComboBoxChooseCourse().removeItem(courseString);
	}

	public void editCourse(String courseString, String courseCredits, String name) throws IntegerParseException{
		try {
		int credits = Integer.parseInt(courseCredits);
		int startIndex = courseString.indexOf(",") + 2;
		int endIndex = courseString.length();
		String courseCode = courseString.substring(startIndex, endIndex);
		courseRegister.editCourse(courseCode, name, credits);
		
		courseFrame.getComboBoxCourseID().setModel(this.getCourses());
		courseFrame.getComboBoxChooseCourse().setModel(this.getCourses());
		}
		catch (NumberFormatException exception) {
			throw new IntegerParseException();
		}
	}
	
	public void addToCourse(String courseString, String examID) {
		int startIndex = courseString.indexOf(",") + 2;
		int endIndex = courseString.length();
		String courseCode = courseString.substring(startIndex, endIndex);
		Course c = courseRegister.findCourse(courseCode);
		
		WrittenExam e = examRegister.findExam(examID);
		c.addExam(e);
		e.setCourse(c);
	}
	public WrittenExam removeFromCourse(String courseString, String examID) {
		int startIndex = courseString.indexOf(",") + 2;
		int endIndex = courseString.length();
		String courseCode = courseString.substring(startIndex, endIndex);
		Course c = courseRegister.findCourse(courseCode);
		WrittenExam e = c.removeExam(examID);
		examRegister.removeExam(e.getExamId());
		courseFrame.getComboBoxExamID().removeItem(examID);
		courseFrame.getComboBoxExamIDRegister().removeItem(examID);
		courseFrame.getComboBoxExamIDUnregister().removeItem(examID);
		return c.removeExam(examID);
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
	
	public void addNewExamToCourse(Date date, String hours, String minutes, String location, String examID, String courseString) throws IntegerParseException{
		int startIndex = courseString.indexOf(",") + 2;
		int endIndex = courseString.length();
		String courseCode = courseString.substring(startIndex, endIndex);
		Course c = courseRegister.findCourse(courseCode);
		
		WrittenExam e = new WrittenExam();
		e.setDate(date);
		try {
		int hour = Integer.parseInt(hours);
		int minute = Integer.parseInt(minutes);
		LocalTime time = LocalTime.of(hour, minute);
		e.setTime(time);
		
		e.setLocation(location);
		e.setExamId(examID);
		
		courseFrame.getComboBoxExamID().addItem(examID);
		courseFrame.getComboBoxExamIDRegister().addItem(examID);
		courseFrame.getComboBoxExamIDUnregister().addItem(examID);
		
		examRegister.addExam(e);
		c.addExam(e);
		}
		catch (NumberFormatException exception) {
			throw new IntegerParseException();
		}
		
	}
	public void registerStudent(String studentString, String examID) {
		int startIndex = studentString.indexOf(",") + 2;
		int endIndex = studentString.length();
		String studentID = studentString.substring(startIndex, endIndex);
		
		Student s = studentRegister.findStudent(studentID);
		WrittenExam e = examRegister.findExam(examID);
		s.registerExam(e);
	}
	public WrittenExam unregisterStudent(String studentString, String examID) {
		int startIndex = studentString.indexOf(",") + 2;
		int endIndex = studentString.length();
		String studentID = studentString.substring(startIndex, endIndex);
		Student s = studentRegister.findStudent(studentID);
		WrittenExam e = s.unregisterExam(examID);
		Result result = e.getRegister().get(studentID);
		e.removeResult(result);
		return e;
	}

	public DefaultComboBoxModel<String> getLocations() {
		return new DefaultComboBoxModel<String>(locations);
	}
	
	public DefaultComboBoxModel<String> getCourses() {
		int i = 0;
		HashMap<String, Course> courseList = courseRegister.getCourseList();
		String [] courses = new String [courseList.size()];
				
		for (Map.Entry<String,Course> entry : courseList.entrySet()) {
		    courses[i] = entry.getValue().getName() + ", " + entry.getKey();
		    i++;
		}
		return new DefaultComboBoxModel<String>(courses);
	}
	public DefaultComboBoxModel<String> getExams() {
		int i = 0;
		HashMap<String, WrittenExam> examList = examRegister.getRegister();
		String [] exams = new String [examList.size()];
		
		for (String key : examList.keySet()) {
		    exams[i] = key;
		    i++;
		}
		return new DefaultComboBoxModel<String>(exams);
	}
	public void filterExams(String courseString) {
		int startIndex = courseString.indexOf(",") + 2;
		int endIndex = courseString.length();
		String courseCode = courseString.substring(startIndex, endIndex);
		
		Course course = courseRegister.findCourse(courseCode);
		HashMap<String, WrittenExam> examList = course.getExamList();
		
		String [] exams = new String [examList.size()];
		int i = 0;
		for (String key : examList.keySet()) {
			exams[i] = key;
			i++;
		}
		DefaultComboBoxModel<String> filteredExamModel = new DefaultComboBoxModel<String>(exams);
		courseFrame.getComboBoxExamIDUnregister().setModel(filteredExamModel);
		courseFrame.getComboBoxExamIDRegister().setModel(filteredExamModel);
		courseFrame.getComboBoxExamID().setModel(filteredExamModel);
	}
	public DefaultComboBoxModel<String> getStudents() {
		int i = 0;
		HashMap<String, Student> studentList = studentRegister.getStudenter();
		String[] students = new String [studentList.size()];
		
		for (Map.Entry<String, Student> entry : studentList.entrySet()) {
		    students[i] = entry.getValue().getName() + ", " + entry.getKey();
		    i++;
		}
		return new DefaultComboBoxModel<String>(students);
	}
	public void filterStudents(String examID) {
		int i = 0;
		WrittenExam e = examRegister.findExam(examID);
		HashMap<String, Result> resultList = e.getRegister();
		String [] students = new String [resultList.size()];
		
		for (Map.Entry<String, Result> entry : resultList.entrySet()) {
		    students[i] = entry.getValue().getStudent().getName() + ", " + entry.getKey();
		    i++;
		}
		
		DefaultComboBoxModel<String> filteredStudentModel = new DefaultComboBoxModel<String>(students);
		courseFrame.getComboBoxStudentIDUnregister().setModel(filteredStudentModel);
	}

	// Metoder f�r StudentFrame-objekt
	public void registerNewStudent(String studentId, String name) {
		Student tmpStudent = new Student();
		tmpStudent.setName(name);
		tmpStudent.setStudentId(studentId);
		studentRegister.addStudent(tmpStudent);
	}
	

	public Student editStudent(String studentID, String name) {
		return studentRegister.editStudent(studentID, name);
	}

	public Student deleteStudent(String studentID) {
		return studentRegister.removeStudent(studentID);
	}

	public String findStudentName(String studentID) {
		return studentRegister.findStudent(studentID).getName();

	}

	public String findStudentiD(String studentID) {
		return studentRegister.findStudent(studentID).getStudentId();

	}

	// ID-generatorer
	public String generateStudentID() {
		if (studentId < 100000) {
			do {
				studentId++;
			} while ((studentRegister.findStudent("S" + studentId.toString())) != null);
			return "S" + studentId.toString();

		} else
			return studentId.toString(); /// m�ste �ndras till n�got vettigt tex popup
	}

	public String generateCourseID() {
		if (courseId < 100000) {
			do {
				courseId++;
			} while (courseRegister.findCourse("C" + courseId.toString()) != null);

			return "C" + courseId.toString();
		} else
			return courseId.toString(); /// m�ste �ndras till n�got vettigt tex popup
	}
	public String generateExamID() {
		
		if (examID < 100000) {
			do {
				examID++;
			} while (examRegister.findExam("E" + examID.toString()) != null);

			return "E" + examID.toString();
		} else
			return examID.toString(); /// m�ste �ndras till n�got vettigt tex popup
	}

	// Vykontroller
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

	

}