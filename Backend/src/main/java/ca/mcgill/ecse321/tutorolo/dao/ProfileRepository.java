package ca.mcgill.ecse321.tutorolo.dao;

import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.tutorolo.model.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Integer> {
	
	Profile findPorifleByEmail(String email);
	
	Profile findProfileByName(String name);
	
}
