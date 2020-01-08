
import java.awt.EventQueue;
import java.util.Map;
import java.util.Arrays;

import java.util.HashMap;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ViewController {

	private Integer studentId = 9999;
	private Integer courseId = 9999;
	private Integer examId = 9999;
	private DefaultComboBoxModel<String> studentModel;

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
	}

	public ViewController(CourseRegister courseRegister, ExamRegister examRegister, StudentRegister studentRegister) {
		this.courseRegister = courseRegister;
		this.studentRegister = studentRegister;
		this.examRegister = examRegister;
		studentModel = getStudents();

		courseFrame = new CourseFrame(this);
		resultFrame = new ResultFrame(this);
		startFrame = new StartFrame(this);
		studentFrame = new StudentFrame(this);
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

	public String generateCourseID() {
		if (courseId < 100000) {
			do {
				courseId++;
			} while (courseRegister.findCourse("C" + courseId.toString()) != null);

		}

		if (this.courseIDValidation("C" + courseId.toString()) == true) {
			return "C" + studentId.toString();

		} else {
			throw new NullPointerException();
		}
	}

	public String generateExamID() {
		if (examId < 100000) {
			do {
				examId++;
			} while (examRegister.findExam("E" + examId.toString()) != null);
		}

		if (this.examIDValidation("E" + examId.toString())) {
			return "E" + examId.toString();
		}

		else {
			throw new NullPointerException();
		}
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