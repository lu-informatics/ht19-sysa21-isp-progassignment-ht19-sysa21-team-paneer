package is;

import java.util.HashMap;

public class Course {
	private String courseCode;
	private String name;
	private int credits;
	private HashMap<String, WrittenExam> examList = new HashMap<String, WrittenExam>();

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

	public HashMap<String, WrittenExam> getExamList() {
		return examList;
	}

	public void setExamList(HashMap<String, WrittenExam> examList) {
		this.examList = examList;
	}

	public void addExam(WrittenExam exam) {
		examList.put(exam.getExamID, exam);
	}

	public WrittenExam removeExam(String examID) {
		WrittenExam w = examList.get(examID).getExam();
		examList.remove(examID);
		return w;
	}

	public WrittenExam findExam(String examID) {
		WrittenExam w = examList.get(examID);
		return w;
	}

}
