package ca.mcgill.ecse321.tutorolo.dao;

import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.tutorolo.model.Review;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
	
	Review findReviewById(Integer id);
	
}
