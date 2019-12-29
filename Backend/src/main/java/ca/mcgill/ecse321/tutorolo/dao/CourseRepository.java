package ca.mcgill.ecse321.tutorolo.dao;

import java.util.Set;
import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.tutorolo.model.Course;
import ca.mcgill.ecse321.tutorolo.model.CourseLevel;

public interface CourseRepository extends CrudRepository<Course, Integer>{
	
	Course findByCourseName(String courseName);
	
	Set<Course> findCourseByCourseLevel(CourseLevel courseLevel);
	
	Set<Course> findCourseByCourseCode(String courseCode);
	
}
