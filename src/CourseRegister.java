
import java.util.HashMap;

public class CourseRegister {
	private HashMap<String, Course> courseList = new HashMap<String, Course>();
	private IdGenerator courseIDGenerator = new IdGenerator(100000,999999,"C");
	
	public HashMap<String, Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(HashMap<String, Course> courseList) {
		this.courseList = courseList;
	}

	public IdGenerator getCourseIDGenerator() {
		return courseIDGenerator;
	}

	public void setCourseIDGenerator(IdGenerator courseIDGenerator) {
		this.courseIDGenerator = courseIDGenerator;
	}
	
	
	public void addCourse(Course course) {
		courseList.put(course.getCourseCode(), course);
	}
	
	public Course findCourse(String courseCode) {
		Course c = courseList.get(courseCode);
		return c;
	}
	
	public Course removeCourse(String courseCode) {
		Course c = courseList.get(courseCode);
		courseList.remove(courseCode);
		return c;
	}
	
	public Course editCourse(String courseCode, String name, int credits) {
	Course c = courseList.get(courseCode);
	if (c != null) {
		c.setName(name);
		c.setCredits(credits);
	}
	return c;
}
	public String getNewID() {
		return courseIDGenerator.next();
	}
	
}
