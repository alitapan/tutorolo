package ca.mcgill.ecse321.tutorolo.dao;

import java.util.Set;
import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.tutorolo.model.Tutor;
import ca.mcgill.ecse321.tutorolo.model.Course;

public interface TutorRepository extends CrudRepository<Tutor, Integer> {

	Tutor findTutorByName(String name);
	
	Tutor findTutorByEmail(String email);
	
	Set<Tutor> findTutorByHourlyRate(Integer hourlyRate);
	
	Set<Tutor> findTutorByCoursesOffered(Course course);
}
