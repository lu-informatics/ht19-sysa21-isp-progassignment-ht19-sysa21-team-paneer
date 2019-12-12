import java.util.HashMap;
public class examRegister {
	
	HashMap<String, WrittenExam> register = new HashMap<>();
	
	public void addExam(WrittenExam exam) {
		register.put(exam.getExamId(), exam);
	}
	public WrittenExam findExam(String id) {
		return register.get(id);
	}
	public WrittenExam removeExam(String id) {
		return register.remove(id);
	}
	public WrittenExam editExam(String id, WrittenExam exam) {
		return register.replace(id, exam);
	}
}
