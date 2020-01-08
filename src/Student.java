
import java.util.HashMap;


public class Student {

	private String studentId;
	private String name;
	private HashMap <String,Result> results = new HashMap<String,Result>(); 
	
	public HashMap<String,Result> getResults() {
		return results;
	}
	public void setResults(HashMap<String, Result> results) {
		this.results = results;
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
		results.put(exam.getExamId(), r);
		exam.addResult(r);
	}
	
	public WrittenExam unregisterExam(String examID) {
		WrittenExam w = results.get(examID).getExam();
		Result r = results.remove(examID);
		w.removeResult(r);
		return w;
		
	}
	
	public Result registerResultsForStudent(String examID, int grade) {
		Result r = results.get(examID);
		r.setResult(grade);
		return r;
	
	}
	
	public void addResult(Result r) {
		results.put(r.getExam().getExamId(), r);
	}

	public Result removeResult(String examID) {
		return results.remove(examID);
		
	}

	public WrittenExam findWrittenExam(String examID) {
		 return results.get(examID).getExam();
	}







}
