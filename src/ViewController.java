
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JComboBox;
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
	
	public ViewController(CourseRegister courseRegister, StudentRegister studentRegister, ExamRegister examRegister) {
		this.courseRegister = courseRegister;
		this.studentRegister = studentRegister;
		this.examRegister = examRegister;
	}
	
	
	
	
	//Metoder för StudentFrame-objekt
	public void registerNewStudent(String studentId, String name) {
		if(!name.equals("")) {
		Student tmpStudent = new Student();
		tmpStudent.setName(name);
		tmpStudent.setStudentId(studentId);		
		studentRegister.addStudent(tmpStudent);		
	}
		else
			studentFrame.getLblResponse().setText("error");
	}
	
	public Student editStudent(String studentID, String name) {
		return studentRegister.editStudent(studentID, name);
	}
	
	public Student deleteStudent(String studentID) {
		return studentRegister.removeStudent(studentID);
	}

	public String generateStudentID() {	
		if(studentId < 100000){
		do {studentId++;
		}
		while ((studentRegister.findStudent("S" + studentId.toString())) != null);
		return "S" + studentId.toString();
		
		
	}else
		return studentId.toString();		
				
	}
		
		
	public String generateCourseID() {		
		do {courseId++;
		} while (courseRegister.findCourse("C" + courseId.toString()) != null);
		
		return "C" + studentId.toString();
	}
	
	
	

}

