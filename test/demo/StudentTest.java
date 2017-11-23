package demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentTest {

	@Test
	void testEnroll() {
	// Test to ensure that student is not allowed to enroll in more than the course limit
		
	// Setting input
		Student student = new Student("batsi", "male");
		Course course = new Course(1, "chemistry", null);
		student.enroll(course);
		assertTrue( student.getEnrolledCourses().size() <= Student.COURSE_ENROLL_LIMIT,"Enrollment limit exceeded.");
		student.enroll(course);
		assertTrue( student.getEnrolledCourses().size() <= Student.COURSE_ENROLL_LIMIT,"Enrollment limit exceeded.");
		student.enroll(course);
		assertTrue( student.getEnrolledCourses().size() <= Student.COURSE_ENROLL_LIMIT,"Enrollment limit exceeded.");
		student.enroll(course);
		assertTrue( student.getEnrolledCourses().size() <= Student.COURSE_ENROLL_LIMIT,"Enrollment limit exceeded.");
	}

}
