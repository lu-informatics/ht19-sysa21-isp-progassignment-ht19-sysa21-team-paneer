import java.sql.Date;
import java.time.LocalTime;
import java.util.Map;

public class Test_application {

	public static void main(String[] args) {

		Student s1 = new Student();
		Student s2 = new Student();
		Course c1 = new Course();
		Course c2 = new Course();
		WrittenExam e1 = new WrittenExam();
		WrittenExam e2 = new WrittenExam();
		StudentRegister studentRegister = new StudentRegister();
		ExamRegister examRegister = new ExamRegister();
		CourseRegister courseRegister = new CourseRegister();

		s1.setName("Helene Sch�nbeck");
		s1.setStudentId("S10000");
		studentRegister.addStudent(s1);
		s2.setName("Joakim Henriksson");
		s2.setStudentId("S10001");
		studentRegister.addStudent(s2);

		for (Map.Entry<String, Student> entry : studentRegister.getStudenter().entrySet()) {
			Student tmp = entry.getValue();
			System.out.println(tmp.getName());
			System.out.println(tmp.getStudentId());
		}
		
		
		
		c1.setCourseCode("C10000");
		c2.setCourseCode("C10001");
		c1.setCredits(10);
		c2.setCredits(20);
		c1.setName("SYSA12");
		c2.setName("SySa12");
		e1.setExamId("E10000");
		e2.setExamId("E10001");
		e1.setDate(Date.valueOf("2020-05-20"));
		e2.setDate(Date.valueOf("2020-06-02"));
		e1.setLocation("Room A123");
		e2.setLocation("Room A123");
		e1.setTime(LocalTime.NOON);
		e2.setTime(LocalTime.NOON);
		e1.setMaxPoints(100);
		e2.setMaxPoints(100);
		courseRegister.addCourse(c1);
		courseRegister.addCourse(c2);
		examRegister.addExam(e1);
		examRegister.addExam(e2);
		c1.addExam(e1);
		c2.addExam(e2);
		s1.registerExam(e1);
		s1.registerExam(e2);
		s2.registerExam(e1);
		s2.registerExam(e2);
		
		ViewController viewController = new ViewController(courseRegister, examRegister, studentRegister);
		viewController.setCourseModel(viewController.getCourses());
		
		StartFrame startFrame = new StartFrame(viewController);
		startFrame.setVisible(true);

	}
}
