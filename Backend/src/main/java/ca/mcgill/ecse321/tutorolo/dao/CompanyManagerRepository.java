package ca.mcgill.ecse321.tutorolo.dao;

import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.tutorolo.model.CompanyManager;

public interface CompanyManagerRepository extends CrudRepository<CompanyManager, Integer>{
	
	CompanyManager findCompanyManagerByName(String name);
	
	CompanyManager findCompanyManagerByEmail(String email);

}
