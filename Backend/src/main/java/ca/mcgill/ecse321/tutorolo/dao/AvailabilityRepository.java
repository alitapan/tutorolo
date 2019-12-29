package ca.mcgill.ecse321.tutorolo.dao;

import java.util.Set;
import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.tutorolo.model.Availability;
import ca.mcgill.ecse321.tutorolo.model.Tutor;

public interface AvailabilityRepository extends CrudRepository<Availability, Integer> {
	
	Availability findAvailabilityById(Integer id);
	Set<Availability> findByTutor(Tutor tutor);
}
