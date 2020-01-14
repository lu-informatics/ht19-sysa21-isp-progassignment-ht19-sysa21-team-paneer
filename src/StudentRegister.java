
import java.util.HashMap;

public class StudentRegister {

	private HashMap<String, Student> students = new HashMap<String, Student>();

	public HashMap<String, Student> getStudents() {
		return students;
	}

	
	public void setStudenter(HashMap<String, Student> studenter) {
		this.students = studenter;
	}

	public void addStudent(Student student) {
		students.put(student.getStudentId(), student);
	}

	public Student removeStudent(String studentID) {
		return students.remove(studentID);
	}

	public Student findStudent(String studentID) {
		return students.get(studentID);

	}

	public Student editStudent(String studentID, String name) {
		Student s = students.get(studentID);
		if (s != null) {
			s.setName(name);
		}
		return s;
	}

}