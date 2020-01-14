import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;


public class Test_application {

	public static void main(String[] args) {
		ExamRegister examRegister = new ExamRegister();
		CourseRegister courseRegister = new CourseRegister();
		StudentRegister studentRegister = new StudentRegister();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Student s1 = new Student();
		s1.setName("Helene Schonbeck");
		s1.setStudentId("S10000");

		Student s2 = new Student();
		s2.setName("Victoria Bohnak");
		s2.setStudentId("S10001");

		Student s3 = new Student();
		s3.setName("Albin Olsson");
		s3.setStudentId("S10002");

		Student s4 = new Student();
		s4.setName("Oscar Wretling");
		s4.setStudentId("S10003");

		Student s5 = new Student();
		s5.setName("Valdemar Andersen");
		s5.setStudentId("S10004");

		Course c1 = new Course();
		c1.setCourseCode("C10000");
		c1.setCredits(10);
		c1.setName("SYSA12");

		Course c2 = new Course();
		c2.setCourseCode("C10001");
		c2.setCredits(20);
		c2.setName("SYSA13");

		WrittenExam e1 = new WrittenExam();
		e1.setExamId("E10000");

		WrittenExam e2 = new WrittenExam();
		e2.setExamId("E10001");

		WrittenExam e3 = new WrittenExam();
		e3.setExamId("E10002");

		try {
			e1.setDate(dateFormat.parse("2020-05-20"));
			e2.setDate(dateFormat.parse("2020-06-02"));
			e3.setDate(dateFormat.parse("2020-03-17"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		e1.setLocation("Room B198");
		e1.setTime(LocalTime.NOON);
	

		e2.setLocation("Room A123");
		e2.setTime(LocalTime.NOON);
	

		e3.setLocation("Room A167");
		e3.setTime(LocalTime.of(9, 00));
		

		Result r1 = new Result();
		r1.setResult(36);
		r1.setLetterGrade("F");
		r1.setExam(e1);
		r1.setStudent(s1);
		Result r2 = new Result();
		r2.setResult(68);
		r2.setLetterGrade("C");
		r2.setExam(e1);
		r2.setStudent(s2);
		Result r3 = new Result();
		r3.setResult(98);
		r3.setLetterGrade("A");
		r3.setExam(e1);
		r3.setStudent(s3);
		Result r4 = new Result();
		r4.setResult(73);
		r4.setLetterGrade("C");
		r4.setExam(e2);
		r4.setStudent(s5);
		Result r5 = new Result();
		r5.setResult(57);
		r5.setLetterGrade("D");
		r5.setExam(e2);
		r5.setStudent(s4);

		studentRegister.addStudent(s1);
		studentRegister.addStudent(s2);
		studentRegister.addStudent(s3);
		studentRegister.addStudent(s4);
		studentRegister.addStudent(s5);

		courseRegister.addCourse(c1);
		courseRegister.addCourse(c2);

		examRegister.addExam(e1);
		examRegister.addExam(e2);
		examRegister.addExam(e3);

		c1.addExam(e1);
		c2.addExam(e2);
		c1.addExam(e3);

		s1.registerExam(e1);
		s2.registerExam(e1);
		s3.registerExam(e1);
		s4.registerExam(e2);
		s5.registerExam(e2);

		e1.addResult(r1);
		e1.addResult(r2);
		e1.addResult(r3);
		e2.addResult(r4);
		e2.addResult(r5);

		s1.addResult(r1);
		s2.addResult(r2);
		s3.addResult(r3);
		s4.addResult(r5);
		s5.addResult(r4);

		StartFrame startFrame = new StartFrame(
				new ViewController(courseRegister, examRegister, studentRegister));

		startFrame.setVisible(true);

	}
}