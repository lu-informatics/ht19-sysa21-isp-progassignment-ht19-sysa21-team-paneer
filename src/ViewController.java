
import java.awt.EventQueue;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JFrame;

public class ViewController {
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
	
	public ViewController(CourseRegister courseRegister, StudentRegister studentRegister, ExamRegister examRegister) {
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

	public String generateID(int count) {

		String ALPHA_NUMERIC_STRING = "0123456789";

		StringBuffer iD = new StringBuffer();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			iD.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return iD.toString();

	}

}
