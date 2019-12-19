
import java.awt.EventQueue;

import javax.swing.JFrame;



public class ViewController {
	
	Integer studentId = 999;
	Integer courseId = 999;

	//Kopplar till gr�nssnitten
	CourseFrame courseFrame;
	ResultFrame resultFrame;
	StartFrame startFrame;
	StudentFrame studentFrame;
	
	//Kopplar till probl.-omr�deskomponenten
	CourseRegister courseRegister;
	StudentRegister studentRegister;
	ExamRegister examRegister;
	
	//Konstruktorer
	
	public ViewController() {
		this.courseRegister = new CourseRegister();
		this.studentRegister = new StudentRegister();
		this.examRegister = new ExamRegister();
	}

	public ViewController(CourseFrame courseFrame, ResultFrame resultFrame, StartFrame startFrame, StudentFrame studentFrame, CourseRegister courseRegister,  ExamRegister examRegister, StudentRegister studentRegister) {
		this.courseFrame = courseFrame;
		this.resultFrame = resultFrame;
		this.startFrame = startFrame;
		this.studentFrame = studentFrame;
		this.courseRegister = courseRegister;
		this.studentRegister = studentRegister;
		this.examRegister = examRegister;
	}
	
	//Metoder för CourseView objekt
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
	
	//Metoder f�r StudentFrame-objekt
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
	
	
	//ID-generatorer
	public String generateStudentID() {
		if (studentId < 100000) {
			do {
				studentId++;
			} while ((studentRegister.findStudent("S" + studentId.toString())) != null);
			return "S" + studentId.toString();

		} else
			return studentId.toString(); ///m�ste �ndras till n�got vettigt tex popup
	}

	public String generateCourseID() {
		if (courseId < 100000) {
		do {
			courseId++;
		} while (courseRegister.findCourse("C" + courseId.toString()) != null);

		return "C" + studentId.toString();
	}
		else 
			return courseId.toString(); ///m�ste �ndras till n�got vettigt tex popup
	}
	
	
	//Vykontroller
	public void administrateStudents(ViewController controller) {
		
		
	}

	public void administrateCourses(ViewController controller) {
		
		
	}

	public void resultReports(ViewController controller) {
		
	}

	public void editOrDeleteCourse() {
		// TODO Auto-generated method stub
		
	}
	

}