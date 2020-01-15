
import java.util.HashMap;

public class Student {

	private String studentId;
	private String name;
	private HashMap<String, Result> resultListStudent = new HashMap<String, Result>();

	public HashMap<String, Result> getResults() {
		return resultListStudent;
	}

	public void setResults(HashMap<String, Result> results) {
		this.resultListStudent = results;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void registerExam(WrittenExam exam) {
		Result r = new Result();
		r.setExam(exam);
		r.setStudent(this);
		resultListStudent.put(exam.getExamId(), r);
		exam.addResult(r);
	}

	public WrittenExam unregisterExam(String examID) {
		WrittenExam w = resultListStudent.get(examID).getExam();
		Result r = resultListStudent.remove(examID);
		w.removeResult(r);
		return w;

	}

	public void addResult(Result r) {
		resultListStudent.put(r.getExam().getExamId(), r);
	}

	public Result removeResult(String examID) {
		return resultListStudent.remove(examID);

	}

	public WrittenExam findWrittenExam(String examID) {
		return resultListStudent.get(examID).getExam();
	}

}
