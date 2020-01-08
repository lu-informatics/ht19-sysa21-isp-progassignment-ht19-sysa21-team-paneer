import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Map;

public class Test_application {
	


	public static void main(String[] args) {
		ExamRegister examRegister = new ExamRegister();
		CourseRegister courseRegister = new CourseRegister();
		StudentRegister studentRegister = new StudentRegister();
		
		
		Student s1 = new Student();
		s1.setName("Helene Sch�nbeck");
		s1.setStudentId("S10000");
		
		Student s2 = new Student();
		s2.setName("Joakim Henriksson");
		s2.setStudentId("S10001");

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Student s3 = new Student();
		s3.setName("Albin Olsson");
		s3.setStudentId("S10002");
		
		Course c1 = new Course();		

		c1.setCourseCode("C10000");
		c1.setCredits(10);
		c1.setName("SYSA12");
		
		Course c2 = new Course();
		c2.setCourseCode("C10001");
		c2.setCredits(20);
		c2.setName("SySa12");
		
		WrittenExam e1 = new WrittenExam();
		e1.setExamId("E10000");

		WrittenExam e2 = new WrittenExam();
		e2 .setExamId("E10001");
		try {
			e1.setDate(dateFormat.parse("2020-05-20"));
			e2.setDate(dateFormat.parse("2020-06-02"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		e1.setLocation("Room A123");
		e1.setTime(LocalTime.NOON);
		e1.setMaxPoints(100);
		
		e2.setTime(LocalTime.NOON);
		e2.setMaxPoints(100);
		
		Result r1 = new Result();
		r1.setResult(50);
		r1.setExam(e1);
		Result r2 = new Result();
		r2.setResult(75);
		r1.setExam(e1);
		Result r3 = new Result();
		r3.setResult(100);
		r3.setExam(e1);
		
		//Lägger till student i register
		studentRegister.addStudent(s1);
		studentRegister.addStudent(s2);
		studentRegister.addStudent(s3);
		
		//Lägger till kurs i register
		courseRegister.addCourse(c1);
		courseRegister.addCourse(c2);
		
		//lägger till tenta i register
		examRegister.addExam(e1);
		examRegister.addExam(e2);
		
		//Lägger till tenta till kurs
		c1.addExam(e1);
		c2.addExam(e2);
		
		e1.addResult(r1);
		e1.addResult(r2);
		e1.addResult(r3);
		
		s1.addResult(r1);
		s2.addResult(r2);
		s3.addResult(r3);
		
		
		for (Map.Entry<String, Student> entry : studentRegister.getStudents().entrySet()) {
			Student tmp = entry.getValue();
			System.out.println(tmp.getName());
			System.out.println(tmp.getStudentId());
		}
		
		for (Course register : courseRegister.getCourseList().values()) {
			System.out.println(register.getName());
		}
		
		
		
		


		StartFrame startFrame = new StartFrame(new ViewController(courseRegister, examRegister, studentRegister));

		startFrame.setVisible(true);
		
		
		
	}
}
