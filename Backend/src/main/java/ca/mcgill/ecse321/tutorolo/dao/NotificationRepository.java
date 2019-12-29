package ca.mcgill.ecse321.tutorolo.dao;

import java.util.Set;
import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.tutorolo.model.Notification;
import ca.mcgill.ecse321.tutorolo.model.Student;
import ca.mcgill.ecse321.tutorolo.model.Tutor;

public interface NotificationRepository extends CrudRepository<Notification, Integer>{
	Notification findNotificationById(Integer id);
	Set<Notification> findBySender(Student student);
	Set<Notification> findByTutor(Tutor tutor);
}
