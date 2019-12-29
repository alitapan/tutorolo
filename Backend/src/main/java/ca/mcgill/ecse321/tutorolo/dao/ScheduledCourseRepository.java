package ca.mcgill.ecse321.tutorolo.dao;

import java.sql.Date;
import java.util.Set;
import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.tutorolo.model.ScheduledCourse;
import ca.mcgill.ecse321.tutorolo.model.Student;
import ca.mcgill.ecse321.tutorolo.model.Tutor;
import ca.mcgill.ecse321.tutorolo.model.Course;

public interface ScheduledCourseRepository extends CrudRepository<ScheduledCourse, Integer> {
	
	Set<ScheduledCourse> findScheduledCourseByDate(Date date);
	
	Set<ScheduledCourse> findScheduledCourseByStudent(Student student);
	
	Set<ScheduledCourse> findScheduledCourseByTutor(Tutor tutor);
	
	Set<ScheduledCourse> findScheduledCourseByCourse(Course course);
	
	ScheduledCourse findSchedueldCourseById(Integer id);
	
	Set<ScheduledCourse> findScheduledCourseByRoomNumber(Integer roomNumber);
	
}
