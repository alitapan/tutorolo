package ca.mcgill.ecse321.tutorolo.dao;

import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.tutorolo.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	Student findStudentByName(String name);
	
	Student findStudentByEmail(String email);
	
}
