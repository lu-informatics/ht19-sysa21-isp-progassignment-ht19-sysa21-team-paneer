
import java.awt.EventQueue;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.jdatepicker.DateModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class ViewController {

	private Integer studentId = 9999;
	private Integer courseId = 9999;
	private Integer examID = 9999;
	private String[] locations = new String[] {"Room A123", "Room A167", "Room B198", "Room B067"};

	// Kopplar till gr�nssnitten
	CourseFrame courseFrame = new CourseFrame(this);
	ResultFrame resultFrame = new ResultFrame(this);
	StartFrame startFrame = new StartFrame(this);
	StudentFrame studentFrame = new StudentFrame(this);

	// Kopplar till probl.-omr�deskomponenten
	CourseRegister courseRegister;
	StudentRegister studentRegister;
	ExamRegister examRegister;

	// Konstruktorer

	public ViewController() {
		this.courseRegister = new CourseRegister();
		this.studentRegister = new StudentRegister();
		this.examRegister = new ExamRegister();
	}

	public ViewController(CourseRegister courseRegister, ExamRegister examRegister, StudentRegister studentRegister) {
		this.courseFrame = courseFrame;
		this.resultFrame = resultFrame;
		this.startFrame = startFrame;
		this.studentFrame = studentFrame;
		this.courseRegister = courseRegister;
		this.studentRegister = studentRegister;
		this.examRegister = examRegister;
	}

	// Metoder för CourseView objekt
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
	
	public void addToCourse(String courseID, String examID) {
		Course c = courseRegister.findCourse(courseID);
		WrittenExam e = examRegister.findExam(examID);
		c.addExam(e);
	}
	public WrittenExam removeFromCourse(String courseID, String examID) {
		Course c = courseRegister.findCourse(courseID);
		return c.removeExam(examID);
	}
	public void addNewExamToCourse(DateModel model, String hours, String minutes, String location) {
		WrittenExam e = new WrittenExam();
		e.setDate(model);
		
		int hour = Integer.parseInt(hours);
		int minute = Integer.parseInt(minutes);
		LocalTime time = LocalTime.of(hour, minute);
		e.setTime(time);
		
		e.setLocation(location);
		e.setExamId(this.generateExamID());
	}
	public void registerStudent(String studentID, String examID) {
		Student s = studentRegister.findStudent(studentID);
		WrittenExam e = examRegister.findExam(examID);
		s.registerExam(e);
	}
	public WrittenExam unregisterStudent(String studentID, String examID) {
		Student s = studentRegister.findStudent(studentID);
		WrittenExam e = examRegister.findExam(examID);
		return s.unregisterExam(examID);
	}

	// Metoder f�r StudentFrame-objekt
	public void registerNewStudent(String studentId, String name) {
		Student tmpStudent = new Student();
		tmpStudent.setName(name);
		tmpStudent.setStudentId(studentId);
		studentRegister.addStudent(tmpStudent);
	}
	public String[] getLocations() {
		
		return locations;
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

			return "C" + examID.toString();
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

	

}