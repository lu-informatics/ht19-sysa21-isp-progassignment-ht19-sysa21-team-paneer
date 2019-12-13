
import java.util.HashMap;

public class CourseRegister {
	private HashMap<String, Course> courseList = new HashMap<String, Course>();

	public void addCourse(Course course) {
		courseList.put(course.getCourseCode(), course);
	}
	
	public Course findCourse(String courseCode) {
		Course c = courseList.get(courseCode);
		return c;
	}
	
	public Course removeCourse(String courseCode) {
		Course c = courseList.get(courseCode).getCourse();
		courseList.remove(courseCode);
		return c;
	}
	
	public Course editCourse(String CourseCode, String name, int credits) {
	Course c = courseList.get(courseCode);
	if (c != null) {
		c.setName(name);
		c.setCredits(credits);
	}
	return c;
}}
