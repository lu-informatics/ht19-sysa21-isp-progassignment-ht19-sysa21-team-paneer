
import java.util.HashMap;

public class StudentRegister {

	private HashMap<String, Student> studentList = new HashMap<String, Student>();

	public HashMap<String, Student> getStudentList() {
		return studentList;
	}

	
	public void setStudentList(HashMap<String, Student> studentList) {
		this.studentList = studentList;
	}

	public void addStudent(Student student) {
		studentList.put(student.getStudentId(), student);
	}

	public Student removeStudent(String studentID) {
		return studentList.remove(studentID);
	}

	public Student findStudent(String studentID) {
		return studentList.get(studentID);

	}

	public Student editStudent(String studentID, String name) {
		Student s = studentList.get(studentID);
		if (s != null) {
			s.setName(name);
		}
		return s;
	}

}