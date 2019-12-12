
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
	
	//Metoder för StartFrame-objekt
	public void administrateStudents(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentFrame frame = new StudentFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void administrateCourses(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseFrame frame = new CourseFrame();
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
	
	//
	

}
