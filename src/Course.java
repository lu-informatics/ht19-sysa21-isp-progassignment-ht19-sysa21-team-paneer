

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
		if (!name.equals("")) {
			this.name = name;
		}
		else {
			throw new IllegalArgumentException();
		}
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
		exam.setCourse(this);
		examList.put(exam.getExamId(), exam);

	}

	public WrittenExam removeExam(String examID) {
		WrittenExam w = examList.get(examID);
		examList.remove(examID);
		return w;
	}

	public WrittenExam findExam(String examID) {
		WrittenExam w = examList.get(examID);
		return w;
	}

}
