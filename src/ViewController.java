
import java.awt.EventQueue;

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
	
	public ViewController(CourseFrame courseFrame, CourseRegister courseRegister, StudentRegister studentRegister, ExamRegister examRegister) {
		this.courseFrame = courseFrame;
		this.courseRegister = courseRegister;
		this.studentRegister = studentRegister;
		this.examRegister = examRegister;
	}
	
	public ViewController(ResultFrame resultFrame, CourseRegister courseRegister, StudentRegister studentRegister, ExamRegister examRegister) {
		this.resultFrame = resultFrame;
		this.courseRegister = courseRegister;
		this.studentRegister = studentRegister;
		this.examRegister = examRegister;
	}
	public ViewController(StartFrame startFrame, CourseRegister courseRegister, StudentRegister studentRegister, ExamRegister examRegister) {
		this.startFrame = startFrame;
		this.courseRegister = courseRegister;
		this.studentRegister = studentRegister;
		this.examRegister = examRegister;
	}
	public ViewController(StudentFrame studentFrame, CourseRegister courseRegister, StudentRegister studentRegister, ExamRegister examRegister) {
		this.studentFrame = studentFrame;
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

	public void resultReports() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultFrame frame = new ResultFrame();
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
	
	public void registerResultForStudent(String studentId, String examId, int score) {
		Student s = studentRegister.findStudent(studentId);
		 s.getResults().get(examId).setResult(score);
		
		}
	
	
}
