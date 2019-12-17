
import java.awt.EventQueue;

import javax.swing.JFrame;



public class ViewController {
	
	Integer studentId = 999;
	Integer courseId = 999;

	//Kopplar till gränssnitten
	CourseFrame courseFrame;
	ResultFrame resultFrame;
	StartFrame startFrame;
	StudentFrame studentFrame;
	
	//Kopplar till probl.-områdeskomponenten
	CourseRegister courseRegister;
	StudentRegister studentRegister;
	ExamRegister examRegister;
	
	//Konstruktorer
	
	public ViewController() {
		this.courseRegister = new CourseRegister();
		this.studentRegister = new StudentRegister();
		this.examRegister = new ExamRegister();
	}

	public ViewController(StartFrame startFrame, CourseRegister courseRegister, StudentRegister studentRegister, ExamRegister examRegister) {
		this.startFrame = startFrame;
		this.courseRegister = courseRegister;
		this.studentRegister = studentRegister;
		this.examRegister = examRegister;
	}
	
	//Metoder för StudentFrame-objekt
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

	public String generateStudentID() {
		if (studentId < 100000) {
			do {
				studentId++;
			} while ((studentRegister.findStudent("S" + studentId.toString())) != null);
			return "S" + studentId.toString();

		} else
			return studentId.toString(); ///måste ändras till något vettigt tex popup
	}

	public String generateCourseID() {
		if (courseId < 100000) {
		do {
			courseId++;
		} while (courseRegister.findCourse("C" + courseId.toString()) != null);

		return "C" + studentId.toString();
	}
		else 
			return courseId.toString(); ///måste ändras till något vettigt tex popup
	}

	public void administrateStudents(ViewController controller) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentFrame frame = new StudentFrame(controller);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	public void administrateCourses(ViewController controller) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseFrame frame = new CourseFrame(controller);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	public void resultReports(ViewController controller) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentFrame frame = new StudentFrame(controller);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void editOrDeleteCourse() {
		// TODO Auto-generated method stub
		
	}
	

}