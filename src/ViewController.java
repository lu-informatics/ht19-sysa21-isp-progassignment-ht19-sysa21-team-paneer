
import java.awt.EventQueue;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;

public class ViewController {

	private Integer studentId = 9999;
	private Integer courseId = 9999;
	private Integer examId = 9999;

	// Connects to the views
	CourseFrame courseFrame = new CourseFrame(this);
	ResultFrame resultFrame = new ResultFrame(this);
	StartFrame startFrame = new StartFrame(this);
	StudentFrame studentFrame = new StudentFrame(this);

	// Connects to the data storage
	CourseRegister courseRegister;
	StudentRegister studentRegister;
	ExamRegister examRegister;

	// Constructors
	public ViewController() {
		this.courseRegister = new CourseRegister();
		this.studentRegister = new StudentRegister();
		this.examRegister = new ExamRegister();
	}

	public ViewController(CourseRegister courseRegister, ExamRegister examRegister, StudentRegister studentRegister) {
		this.courseRegister = courseRegister;
		this.studentRegister = studentRegister;
		this.examRegister = examRegister;
	}

	// Methods for CourseView
	public void addCourse(String name, String credits) {
		Course c = new Course();
		c.setName(name);
		c.setCredits(Integer.parseInt(credits));
		c.setCourseCode(this.generateCourseID());
		courseRegister.addCourse(c);
	}

	public Course deleteCourse(String courseID) {
		return courseRegister.removeCourse(courseID);
	}

	public Course editCourse(String courseID, String courseCredits, String name) {
		int credits = Integer.parseInt(courseCredits);
		return courseRegister.editCourse(courseID, name, credits);
	}

	// Methods for StudentFrame
	public void registerNewStudent(String studentId, String firstName, String lastName) {

		Student tmpStudent = new Student();
		tmpStudent.setStudentId(studentId);
		tmpStudent.setName(firstName + " " + lastName);
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

	public String findStudentName(String studentID) {
		return studentRegister.findStudent(studentID).getName();

	}

	public String findStudentiD(String studentID) {
		return studentRegister.findStudent(studentID).getStudentId();

	}

	// ID-generators 
	public String generateStudentID() {
		if (studentId < 100000) {
			do {
				studentId++;
			} while ((studentRegister.findStudent("S" + studentId.toString())) != null);
			return "S" + studentId.toString();

		} else
			return null;
	}

	public String generateCourseID() {
		if (courseId < 100000) {
			do {
				courseId++;
			} while (courseRegister.findCourse("C" + courseId.toString()) != null);

			return "C" + studentId.toString();
		} else
			return null;
	}
	
	public String generateExamID() {
		if (examId < 100000) {
			do {
				examId++;
			} while (examRegister.findExam("E" + examId.toString()) != null);

			return "E" + examId.toString();
		} else
			return null;
	}
	
	
	//ID Validation - matches the entered ID by using regular expressions set to the ID standard
	
	public boolean studentIDValidation(String id) {
		return id.matches("S[0-9]{5}");
		
	}
	
	public boolean courseIDValidation(String id) {
		return id.matches("C[0-9]{5}");
	}
	
	public boolean examIDValidation(String id) {
		return id.matches("E[0-9]{5}");
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

	public void backToMainMenu(ViewController controller) {
		startFrame.setVisible(true);
		resultFrame.setVisible(false);
		courseFrame.setVisible(false);
		studentFrame.setVisible(false);
	}

	public void editOrDeleteCourse() {
		// TODO Auto-generated method stub

	}

}