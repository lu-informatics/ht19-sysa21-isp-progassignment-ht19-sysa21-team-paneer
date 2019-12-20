import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import org.jdatepicker.DateModel;

public class WrittenExam {

	private HashMap<Integer, Result> register2 = new HashMap<>();
	private String examId;
	private DateModel date;
	private String location;
	private LocalTime time;
	private int maxPoints = 100;
	private Course course;

	public String getExamId() {
		return examId;
	}

	public void setExamId(String examId) {
		this.examId = examId;
	}

	public DateModel getDate() {
		return date;
	}

	public void setDate(DateModel date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public HashMap<Integer, Result> getRegister2() {
		return register2;
	}

	public void setRegister2(HashMap<Integer, Result> register2) {
		this.register2 = register2;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getMaxPoints() {
		return maxPoints;
	}

	public void setMaxPoints(int maxPoints) {
		this.maxPoints = maxPoints;
	}

	public void addResult(Result result) {
		register2.put(result.getResult(), result);
	}

	public Result removeResult(Result result) {
		return register2.remove(result.getResult());
	}
	//Hjälpfunktion 
	private int[] getResultAsArraySorted(boolean sort) {
		int size = register2.values().size();
		int[] result = new int[size];
		int i = 0;
		for (Result asd : register2.values()) {
			result[i++] = asd.getResult();
		}
		if (sort) {
			Arrays.sort(result);

		}
		return result;
	}

	// returnerar -1 om det inte finns en median
	public int calculateMedian() {
		int[] result = getResultAsArraySorted(true);
		int size = result.length;
		// specialfall om resultat är tom
		if (size == 0) {
			return -1;
		}

		// specialfall om det bara finns ett tal i Arrayen blir det medianen
		if (size == 1) {
			return result[0];
		}

		if (size % 2 == 1) {
			int medianIndex = (size - 1) / 2;
			return result[medianIndex];
		}
		// divisionen kan ej hantera flyttal ändra till float?
		else {
			int medianIndex = (size - 2) / 2;
			int firstNumber = result[medianIndex];
			int secondNumber = result[medianIndex + 1];
			int median = (firstNumber + secondNumber) / 2;
			return median;
		}
	}
	public double calculateAverage() {
		int[] result = getResultAsArraySorted(false);
		int size = result.length;
		int sum = 0;
		for (int i : result) {
			sum = sum + i;
		}
		double average = sum/size;
		return average;
	}
	//returnerar antal resultat
	public int calculateNumberOf() {
		return register2.values().size();
	}
}
//TODO Ta bort och byt till riktiga klassen
//class Student {
//	private String studentId;
//
//	public String getStudentId() {
//		return studentId;
//	}
//
//	public void setStudentId(String studentId) {
//		this.studentId = studentId;
//	}
//}
