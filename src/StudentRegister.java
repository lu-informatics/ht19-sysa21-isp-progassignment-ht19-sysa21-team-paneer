
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class StudentRegister {

	private HashMap<String, Student> studenter = new HashMap<String, Student>();

	public HashMap<String, Student> getStudenter() {
		return studenter;
	}
	public Collection<Student> getStudenterForCombo() {
		return studenter.values();}

	public void setStudenter (HashMap<String, Student> studenter) {
		this.studenter = studenter;
	}

	public void addStudent(Student student) {
		studenter.put(student.getStudentId(), student);
	}

	public Student removeStudent(String studentID) {
		return studenter.remove(studentID);
	}

	public Student findStudent(String studentID) {
		return studenter.get(studentID);

	}
	
	
	public Student editStudent(String studentID, String name) {
		Student s = studenter.get(studentID);
		if (s != null) {
			s.setName(name);
		}
		return s;
	}
	


}