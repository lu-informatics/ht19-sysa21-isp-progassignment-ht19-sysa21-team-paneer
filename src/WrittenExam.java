import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

public class WrittenExam {

	private HashMap<String, Result> resultListExam = new HashMap<>();
	private String examId;
	private Date date;
	private String location;
	private LocalTime time;
	private final int MAXPOINTS = 100;
	private Course course;

	public HashMap<String, Result> getResultListExam() {
		return resultListExam;
	}

	public void setResultListExam(HashMap<String, Result> register) {
		this.resultListExam = register;
	}

	public String getExamId() {
		return examId;
	}

	public void setExamId(String examId) {
		this.examId = examId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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

	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getMaxPoints() {
		return MAXPOINTS;
	}



	public void addResult(Result result) {
		resultListExam.put(result.getStudent().getStudentId(), result);
		
	}

	public Result removeResult(Result result) {
		
		return resultListExam.remove(result.getStudent().getStudentId());
	}

//Help Function
	private int[] getResultAsArraySorted(boolean sort) {
		int size = resultListExam.values().size();
		int[] result = new int[size];
		int i = 0;
		for (Result asd : resultListExam.values()) {
			result[i++] = asd.getResult();
		}
		if (sort) {
			Arrays.sort(result);

		}
		return result;
	}

	// returns -1 if there is no median 
	public double calculateMedian() {
		int[] result = getResultAsArraySorted(true);
		int size = result.length;
		// if result is empty
		if (size == 0) {
			return -1;
		}

		// used only if there is only 1 number in the Array 
		if (size == 1) {
			return result[0];
		}
		//is it's an uneven number
		if (size % 2 == 1) {
			int medianIndex = (size - 1) / 2;
			return result[medianIndex];
		}
		
		else {
			int medianIndex = (size - 2) / 2;
			int firstNumber = result[medianIndex];
			int secondNumber = result[medianIndex + 1];
			double median = (double)(firstNumber + secondNumber) / 2;
			return median;
		}
	}

	public double calculateAverage() {
		int[] result = getResultAsArraySorted(false);
		int size = result.length;
		int sum = 0;
		for (int score : result) {
			sum += score;
		}
		double average = (double)sum / size;
		return average;
	}

	// number of student who passed the exam
	public int calculateNumberOfPassed() {
		int passed = 0;

		for (Result result : resultListExam.values()) {
			if (result.getResult() > 49) {
				passed++;
			}

		}
		return passed;
	}

}
