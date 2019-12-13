

import java.util.HashMap;

public class Course {
	private String courseCode;
	private String name;
	private int credits;
	private HashMap<String, Result> examList = new HashMap<String, Result>();

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public HashMap<String, Result> getExamList() {
		return examList;
	}

	public void setExamList(HashMap<String, Result> examList) {
		this.examList = examList;
	}

	public void addExam(WrittenExam exam) {
		Result r = new Result();
		r.setExam(exam);
		examList.put(exam.getExamId(), r);
	}

	public WrittenExam removeExam(String examID) {
		WrittenExam w = examList.get(examID).getExam();
		examList.remove(examID);
		return w;
	}

	public WrittenExam findExam(String examID) {
		WrittenExam w = examList.get(examID).getExam();
		return w;
	}

}
