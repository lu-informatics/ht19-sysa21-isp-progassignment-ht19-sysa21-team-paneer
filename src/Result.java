
public class Result {
	private int result;
	private char letterGrade;
	private WrittenExam exam;
	private Student student;
	
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public char getLetterGrade() {
		return letterGrade;
	}
	public void setLetterGrade(char letterGrade) {
		this.letterGrade = letterGrade;
	}
	public WrittenExam getExam() {
		return exam;
	}
	public void setExam(WrittenExam exam) {
		this.exam = exam;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public char gradeCalculator() {
		if (result >= 0 && result < 50) {
			return 'F';
		}
		else if (result < 55) {
			return 'E';
		}
		else if (result < 65) {
			return 'D';
		}
		else if (result < 75) {
			return 'C';
		}
		else if (result < 85) {
			return 'B';
		}
		else if (result <= 100) {
			return 'A';
		}
	}
}
