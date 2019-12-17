
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
		
		s1.setName("Test1");
		s1.setStudentId("S10000");
		s2.setName("Test2");
		s2.setStudentId("S10001");
		
		c1.setCourseCode("E10000");
		c2.setCourseCode("E10001");
		c1.setCredits(10);
		c2.setCredits(20);
		c1.setName("SYSA12");
		c2.setName("SySa12");
		
		

	}

}
