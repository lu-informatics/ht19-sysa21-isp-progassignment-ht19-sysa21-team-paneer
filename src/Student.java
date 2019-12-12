package Uppg2ext;

import java.util.HashMap;

import com.sun.net.httpserver.Authenticator.Result;

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
		results.put(exam.getExamID(), r);
	}
	
	public WrittenExam unregisterExam(String examID) {
		WrittenExam w = results.get(examID).getExam();
		results.remove(examID);
		return w;
		
	}
	
	public Result registerResultsForStudent(String examID, int grade) {
		Result r = results.get(examID);
		r.setResult(grade);
		return r;
	
	
	public void addResult(Result r) {
		results.put(r.getExam().getExamID(), r);
	}

	public Result removeResult(String examID) {
		return results.remove(examID);
		
	}









}
