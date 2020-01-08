import java.util.HashMap;
public class ExamRegister {
	
	private HashMap<String, WrittenExam> register = new HashMap<String, WrittenExam>();
	
	public HashMap<String, WrittenExam> getRegister() {
		return register;
	}
	public void setRegister(HashMap<String, WrittenExam> register) {
		this.register = register;
	}
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
