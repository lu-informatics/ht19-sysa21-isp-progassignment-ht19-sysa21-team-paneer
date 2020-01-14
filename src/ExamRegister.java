import java.util.HashMap;
public class ExamRegister {
	
	private HashMap<String, WrittenExam> examList = new HashMap<String, WrittenExam>();
	
	public HashMap<String, WrittenExam> getRegister() {
		return examList;
	}
	public void setRegister(HashMap<String, WrittenExam> register) {
		this.examList = register;
	}
	public void addExam(WrittenExam exam) {
		examList.put(exam.getExamId(), exam);		
	}
	public WrittenExam findExam(String id) {
		return examList.get(id);
	}
	public WrittenExam removeExam(String id) {
		return examList.remove(id);
	}
}
