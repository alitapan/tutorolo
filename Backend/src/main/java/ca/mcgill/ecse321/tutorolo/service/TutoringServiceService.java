package ca.mcgill.ecse321.tutorolo.service;

import ca.mcgill.ecse321.tutorolo.dao.*;
import ca.mcgill.ecse321.tutorolo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class TutoringServiceService {
	
	@Autowired(required = true)
	CompanyManagerRepository companyManagerRepository;
	@Autowired(required = true)
	StudentRepository studentRepository;
	@Autowired(required = true)
	TutorRepository tutorRepository;
	@Autowired(required = true)
	ScheduledCourseRepository scheduledCourseRepository;
	@Autowired(required = true)
	CourseRepository courseRepository;
	@Autowired(required = true)
	ReviewRepository reviewRepository;
	@Autowired(required = true)
	AvailabilityRepository availabilityRepository;
	@Autowired(required = true)
	NotificationRepository notificationRepository;

	/**
	 * Creates and adds Student to the database.
	 * 
	 * @param email
	 * @param name
	 * @param password
	 * @param id
	 * @return Student Object
	 * 
	 * @author Ali Tapan
	 */
	@Transactional
	public Student createStudent(String email, String name, String password, Integer id) {
		String error ="";
		if(name == null || name.trim().length() == 0 || name ==" "){
			error += "Student name cannot be empty! ";
		}
		if (email == null || email.trim().length() == 0 || email ==" ") {
			error = error + "Email cannot be empty! ";
		}
		if (password == null || password.trim().length() == 0 || password == " ") {
			error = error + "Password cannot be empty! ";
		}
		if (id < 0 ){
			error += "ID is inavlid!";
		}
		if (error.length() > 0 ){
			throw new IllegalArgumentException(error);
		}
		Student s = new Student();
		s.setEmail(email);
		s.setPassword(password);
		s.setName(name);
		s.setId(id);
		studentRepository.save(s);
		return s;
	}
	
	/**
	 * Creates and adds Tutor to the database.
	 * 
	 * @param name
	 * @param id
	 * @param hourlyRate
	 * @return Tutor Object
	 * 
	 * @author Ali Tapan
	 */
	@Transactional
	public Tutor createTutor(String email, String name, String password, Integer id, int hourlyRate) {
		String error ="";
		if(name == null || name.trim().length() == 0 || name == " "){
			error += "Tutor name cannot be empty! ";
		}
		if (email == null || email.trim().length() == 0 || email ==" ") {
			error = error + "Email cannot be empty! ";
		}
		if (password == null || password.trim().length() == 0 || password == " ") {
			error = error + "Password cannot be empty! ";
		}
		if (id < 0 ){
			error += "ID is inavlid! ";
		}
		if (hourlyRate < 0 ){
			error += "HourlyRate is invalid!";
		}
		if (error.length() > 0 ){
			throw new IllegalArgumentException(error);
		}
		Tutor t = new Tutor();
		t.setName(name);
		t.setEmail(email);
		t.setPassword(password);
		t.setId(id);
		t.setHourlyRate(hourlyRate);
		tutorRepository.save(t);
		return t;
	}
	
	/**
	 * Creates and adds CompanyManager to the database.
	 * 
	 * @param email
	 * @param name
	 * @param password
	 * @return CompanyManager Object
	 * 
	 * @author Ali Tapan
	 */
	@Transactional
	public CompanyManager createCompanyManager(String email, String name, String password, Integer id) {
		String error ="";
		if(name == null || name.trim().length() == 0 || name ==" "){
			error += "Manager name cannot be empty! ";
		}
		if (email == null || email.trim().length() == 0 || email ==" ") {
			error = error + "Email cannot be empty! ";
		}
		if (password == null || password.trim().length() == 0 || email == " ") {
			error = error + "Password cannot be empty! ";
		}
		if (id<0)
		{
			error = error + "ID invalid!";
		}
		if (error.length() > 0 ){
			throw new IllegalArgumentException(error);
		}
		CompanyManager cm = new CompanyManager();
		cm.setId(id);
		cm.setName(name);
		cm.setEmail(email);
		cm.setPassword(password);
		companyManagerRepository.save(cm);
		return cm;
	}

	/**
	 * Creates and adds Course to the database.
	 * 
	 * @param courseName
	 * @param courseLevel
	 * @param courseCode
	 * @return Course Object
	 * 
	 * @author Ali Tapan
	 */
	@Transactional
	public Course createCourse(String courseName, CourseLevel courseLevel, String courseCode) {
		String error="";
		if(courseCode ==null || courseCode.trim().length() ==0 || courseCode ==" "){
			error += "CourseCode cannot be empty! ";
		}
		if(courseLevel ==null){
			error += "CourseLevel invalid! ";
		}
		if(courseName ==null || courseName.trim().length() ==0 || courseName ==" "){
			error += "CourseName cannot be empty! ";
		}
		if (error.length() >0 ){
			throw new IllegalArgumentException(error);
		}
		Course c = new Course();
		c.setCourseCode(courseCode);
		c.setCourseLevel(courseLevel);
		c.setCourseName(courseName);
		courseRepository.save(c);
		return c;
	}
	
	
	/**
	 * Creates and adds ScheduledCourse to the database.
	 * 
	 * @param student
	 * @param tutor
	 * @param course
	 * @param room
	 * @param startTime
	 * @param endTime
	 * @param date
	 * @param id
	 * @return ScheduledCourse Object
	 * 
	 * @author Ali Tapan
	 */
	@Transactional
	public ScheduledCourse createScheduledCourse(Student student, Tutor tutor, Course course, Integer roomNumber,
			Time startTime, Time endTime, Date date, Integer id) {
		
		String error ="";
		if(student == null) {
			error += "Student is null! ";
		}
		if(tutor == null) {
			error += "Tutor is null! ";
		}
		if(course == null) {
			error += "Course is null! ";
		}
		if (error.length() > 0 ){
			throw new IllegalArgumentException(error);
		}
		
		error = "";
		if(startTime == null){
			error += "Start Time invalid! ";
		}
		if(endTime == null){
			error += "End Time invalid! ";
		}
		if (date == null){
			error += "Date invalid! ";
		}
		if (id <= 0){
			error += "ID invalid! ";
		}
		if (error.length() > 0 ){
			throw new IllegalArgumentException(error);
		}
		
		error = "";
		if(roomNumber == 0 || roomNumber > 10) {
			error += "roomNumber cannot be zero or greater than 10! ";
		}
		if (error.length() > 0 ){
			throw new IllegalArgumentException(error);
		}
		
		ScheduledCourse sc = new ScheduledCourse();
		sc.setCourse(course);
		sc.setDate(date);
		sc.setRoomNumber(roomNumber);
		sc.setStudent(student);
		sc.setTutor(tutor);
		sc.setStartTime(startTime);
		sc.setEndTime(endTime);
		sc.setId(id);
		scheduledCourseRepository.save(sc);
		return sc;
	}
	
	/**
	 * Creates a notification in the database with the specified parameters.
	 * 
	 * @param text
	 * @param t
	 * @param s
	 * @param cm
	 * @return Notification Object
	 * 
	 * @author Ali Tapan
	 */
	@Transactional
	public Notification createNotification(String text, Tutor t, Student s, CompanyManager cm)
	{
		String error = "";
		if (s == null) {
			error = error + "Student is null! ";
		}
		if (cm == null && t == null) {
			error = error + "Notification needs at least one recipient! ";
		}
		if(cm != null && t != null) {
			error = error + "Notification can only be sent to either Tutor or Company Manager, not both! ";
		}
		if (text == null || text.trim().length() == 0) {
			error = error + "Text is invalid!";
		}
		if (error.length() != 0) {
			throw new IllegalArgumentException(error);
		}

		Notification n = new Notification();
		n.setText(text);
		n.setSender(s);
		n.setTutor(t);
		n.setCompanyManager(cm);

		if (s != null) {
			Set<Notification> notifs = s.getSent();
			if (notifs == null)
				notifs = new HashSet<>();
			notifs.add(n);
			s.setSent(notifs);
			studentRepository.save(s);
		}

		if (t != null) {
			Set<Notification> notifs = t.getTutorRecieved();
			if (notifs == null)
				notifs = new HashSet<>();
			notifs.add(n);
			t.setTutorRecieved(notifs);
			tutorRepository.save(t);
		}
		
		if (cm != null) {
			Set<Notification> notifs = cm.getCompanyManagerReceived();
			if (notifs == null)
				notifs = new HashSet<>();
			notifs.add(n);
			cm.setCompanyManagerReceived(notifs);
			companyManagerRepository.save(cm);
		}
		
		notificationRepository.save(n);
		return n;	
	}
	
	/**
	 * Returns a Review in the database with the specified parameters.
	 * 
	 * @param id
	 * @param rating
	 * @param comment
	 * @param student
	 * @param tutor
	 * @return Review Object
	 * 
	 * @author Ali Tapan
	 */
	@Transactional
	public Review createReview(Integer id, Integer rating, String comment, Student student, Tutor tutor) {
		String error = "";
		if(student == null && tutor == null) {
			error = error + "Review needs at least one profile! ";
		}
		if(student != null && tutor !=null) {
			error = error + "Same review cannot belong to Student and Tutor at the same time! ";
		}
		if (error.length() != 0) {
			throw new IllegalArgumentException(error);
		}
		error = "";
		if (id < 0) {
			error = error + "ID is inavlid! ";
		}
		if (rating < 0 || rating > 5) {
			error = error + "Rating cannot be less than zero or greater than 5! ";
		}
		if (error.length() != 0) {
			throw new IllegalArgumentException(error);
		}
		
		Review r = new Review();
		r.setId(id);
		r.setRating(rating);
		r.setComment(comment);
		r.setStudent(student);
		r.setTutor(tutor);
		reviewRepository.save(r);
		return r;
	}
	
	/**
	 * Returns a Availability in the database with the specified parameters.
	 * 
	 * @param availableDate
	 * @param startTime
	 * @param endTime
	 * @param tutor
	 * @return Availability Object
	 * 
	 * @author Ali Tapan
	 */
	@Transactional
	public Availability createAvailability(Date availableDate, Time startTime, Time endTime, Tutor tutor, Integer id) {
		String error ="";
		if(tutor == null) {
			error = error + "Tutor is null! ";
		}
		if(availableDate == null)
		{
			error = error + "Available Date invalid! ";
		}
		if(startTime == null){
			error += "Start Time invalid! ";
		}
		if(endTime == null){
			error += "End Time invalid! ";
		}
		if(id < 0){
			error += "ID invalid!";
		}
		if (error.length() != 0) {
			throw new IllegalArgumentException(error);
		}
		Availability a = new Availability();
		a.setId(id);
		a.setAvailableDate(availableDate);
		a.setStartTime(startTime);
		a.setEndTime(endTime);
		a.setTutor(tutor);
		availabilityRepository.save(a);
		return a;
	}
	
	
	/**
	 * Returns the Student object if the login is successful
	 * 
	 * @param email
	 * @param password
	 * @return Logged in Student (if exists)
	 * 
	 * @author Ali Tapan
	 */
    @Transactional
    public Student login(String email, String password) {
        Student s = studentRepository.findStudentByEmail(email);
        if (s != null && s.getPassword().equals(password)) {
            return s;
        }
        throw new NullPointerException("No such user.");
    }
	
	/**
	 * Returns the Student with specified email from the database.
	 * 
	 * @param email
	 * @return Student Object
	 * 
	 * @author Ali Tapan
	 */
	@Transactional
	public Student getStudent(String email) {
		if (email == null || email.trim().length() == 0) {
			throw new IllegalArgumentException("Student email cannot be empty!");
		}

		Student s = studentRepository.findStudentByEmail(email);
		return s;
	}
	
	/**
	 * Returns the Tutor with specified email from the database.
	 * 
	 * @param email
	 * @return Tutor Object
	 * 
	 * @author Ali Tapan
	 */
	@Transactional
	public Tutor getTutor(String email) {
		if (email == null || email.trim().length() == 0) {
			throw new IllegalArgumentException("Tutor email cannot be empty!");
		}

		Tutor t = tutorRepository.findTutorByEmail(email);
		return t;
	}
	
	/**
	 * Returns the CompanyManager with specified email from the database.
	 * @param email
	 * @return CompanyManager Object
	 * 
	 * @author Ali Tapan
	 */
	@Transactional
	public CompanyManager getCompanyManager(String email) {
		if (email == null || email.trim().length() == 0) {
			throw new IllegalArgumentException("CompanyManager email cannot be empty!");
		}

		CompanyManager cm = companyManagerRepository.findCompanyManagerByEmail(email);
		return cm;
	}
	
	/**
	 * Returns all courses with specified course level from the database.
	 * @param courseLevel
	 * @return List of Course Objects
	 * 
	 * @author Ali Tapan
	 */
	@Transactional
	public List<Course> getCourseByCourseLevel(CourseLevel courseLevel)
	{
		List<Course> course = toList(courseRepository.findCourseByCourseLevel(courseLevel));
		return course;
	}
	
	/**
	 * Returns all courses with specified course name from the database.
	 * 
	 * @param courseName
	 * @return List of Course Objects
	 * 
	 * @author Ali Tapan
	 */
	@Transactional
	public Course getCourseByCourseName(String courseName)
	{
		if(courseName == null)
		{
			throw new IllegalArgumentException("Course name cannot be empty!");
		}
		Course c = courseRepository.findByCourseName(courseName);
		return c;
	}
	
	/**
	 * Returns all courses with specified course code from the database.
	 * @param courseCode
	 * @return List of Course Objects
	 * 
	 * @author Ali Tapan
	 */
	@Transactional
	public Set<Course> getCourseByCourseCode(String courseCode)
	{
		if(courseCode == null)
		{
			throw new IllegalArgumentException("Course code cannot be empty!");
		}
		Set<Course> course = courseRepository.findCourseByCourseCode(courseCode);
		return course;
	}
	
	/**
	 * Returns all tutors offering the specified course from the database.
	 * 
	 * @param course
	 * @return List of Tutor Objects
	 * 
	 * @author Ali Tapan
	 */
	@Transactional
	public List<Tutor> getTutorByCoursesOffered(Course course)
	{
		List<Tutor> tutor = toList(tutorRepository.findTutorByCoursesOffered(course));
		return tutor;
	}
	
	/**
	 * Returns all tutors with the specified hourly rate from the database.
	 * 
	 * @param hourlyRate
	 * @return List of Tutor Objects
	 * 
	 * @author Ali Tapan
	 */
	public List<Tutor> getTutorByHourlyRate(Integer hourlyRate)
	{
		List<Tutor> tutor = toList(tutorRepository.findTutorByHourlyRate(hourlyRate));
		return tutor;
	}
	
	/**
	 * Returns all Scheduled Courses with the specified room number
	 * 
	 * @param roomNumber
	 * @return List of ScheduledCourse Objects
	 * 
	 * @author Ali Tapn
	 */
	@Transactional
	public List<ScheduledCourse> getScheduledCourseByRoomNumber(Integer roomNumber)
	{
		List<ScheduledCourse> scheduledCourse = toList(scheduledCourseRepository.findScheduledCourseByRoomNumber(roomNumber));
		return scheduledCourse;
	}
	
	/**
	 * Returns the ScheduledCourse with the specified ID from the database.
	 * 
	 * @param id
	 * @return ScheduledCourse Object
	 * 
	 * @author Ali Tapan
	 */
	@Transactional
	public ScheduledCourse getScheduledCourse(Integer id) {
		if (id <=0){
			throw new IllegalArgumentException("ID invalid!");
		}
		ScheduledCourse sc = scheduledCourseRepository.findSchedueldCourseById(id);
		return sc;
	}
	
	/**
	 * Returns ScheduledCourse with the specified date from the database
	 * 
	 * @param date
	 * @return List of ScheduledCourse Objects
	 * 
	 * @author Ali Tapan
	 */
	@Transactional
	public List<ScheduledCourse> getScheduledCourseByDate(Date date) {
		if(date == null) {
			throw new IllegalArgumentException("Date invaild!");
		}
		List <ScheduledCourse> sc = toList(scheduledCourseRepository.findScheduledCourseByDate(date));
		return sc;
	}
	
	/**
	 * Returns ScheduledCourse with the specified date and roomNumber.
	 * 
	 * @param date
	 * @param roomNumber
	 * @return List of ScheduledCourse Objects
	 * 
	 * @author Ali Tapan
	 */
	@Transactional
	public List<ScheduledCourse> getScheduedCourseByDateAndRoomNumber(Date date, Integer roomNumber){
		List<ScheduledCourse> all = toList(scheduledCourseRepository.findAll());
		for (ScheduledCourse sc : all) {
			if(sc.getDate() != date && sc.getRoomNumber() != roomNumber)
			{
				all.remove(sc);
			}
		}
		return all;
	}
	
	/**
	 * Returns the set of Scheduled Course Objects belonging to a student.
	 * 
	 * @param s
	 * @return Set of ScheduledCourse Objects
	 * 
	 * @author Ali Tapan
	 */
	@Transactional
	public Set<ScheduledCourse> getScheduledCourseByStudent(Student s){
		if(s == null)
		{
			throw new IllegalArgumentException("Student is null!");
		}
		Set<ScheduledCourse> sc = scheduledCourseRepository.findScheduledCourseByStudent(s);
		return sc;
	}
	
	/**
	 * Returns the set of Scheduled Course Objects belonging to a tutor.
	 * 
	 * @param t
	 * @return Set of ScheduledCourse Objects
	 * 
	 * @author Ali Tapan
	 */
	@Transactional
	public Set<ScheduledCourse> getScheduledCourseByTutor(Tutor t){
		if(t == null)
		{
			throw new IllegalArgumentException("Tutor is null!");
		}
		Set<ScheduledCourse> sc = scheduledCourseRepository.findScheduledCourseByTutor(t);
		return sc;
	}
	
	/**
	 * Returns the set of Scheduled Course Objects belonging to a Course.
	 * 
	 * @param c
	 * @return Set of ScheduledCourse Objects
	 * 
	 * @author Ali Tapan
	 */
	@Transactional
	public Set<ScheduledCourse> getScheduledCourseByCourse(Course c){
		if(c == null)
		{
			throw new IllegalArgumentException("Course is null!");
		}
		Set<ScheduledCourse> sc = scheduledCourseRepository.findScheduledCourseByCourse(c);
		return sc;
	}
	
	/**
	 * Returns all notification for the specified Tutor in the database.
	 * @param t
	 * @return Set of Notification Objects
	 * 
	 * @author Ali Tapan
	 */
	@Transactional
	public Set<Notification> getNotificationTutor(Tutor t)
	{
		Set<Notification> n = null;
		if (t == null) {
			throw new IllegalArgumentException("Profile cannot be null!");
		} else {
			n = t.getTutorRecieved() == null ? new HashSet<>() : t.getTutorRecieved();
		}
		return n;
	}
	
	/**
	 * Returns all notification for the specified CompanyManager in the database.
	 * @param cm
	 * @return Set of Notification Objects
	 * 
	 * @author Ali Tapan
	 */
	@Transactional
	public Set<Notification> getNotificationCompanyManager(CompanyManager cm)
	{
		Set<Notification> n = null;
		if (cm == null) {
			throw new IllegalArgumentException("Profile cannot be null!");
		} else {
			n = cm.getCompanyManagerReceived() == null ? new HashSet<>() : cm.getCompanyManagerReceived();
		}
		return n;
	}
	
	/**
	 * Returns all notification for the specified Student in the database.
	 * 
	 * @param s
	 * @return Set of Notification Objects
	 * 
	 * @author Ali Tapan
	 */
	@Transactional
	public Set<Notification> getNotificationStudent(Student s)
	{
		Set<Notification> n = null;
		if (s == null) {
			throw new IllegalArgumentException("Profile cannot be null!");
		} else {
			n = s.getSent() == null ? new HashSet<>() : s.getSent();
		}
		return n;
	}
	
	/**
	 * Returns all reviews belonging to a Tutor in the database.
	 * 
	 * @param tutor
	 * @return List of Review Objects
	 * 
	 * @author Ali Tapan
	 */
	@Transactional
	public List<Review> getReviewsOfTutor(Tutor tutor){
		List<Review> all = toList(reviewRepository.findAll());
		for (Review r : all) {
			if(r.getTutor() == tutor)
			{
				all.remove(r);
			}
		}
		return all;
	}
	
	/**
	 * Returns all available times of a specified tutor.
	 * 
	 * @param tutor
	 * @return List of Availability Objects
	 * 
	 * @author Ali Tapan
	 */
	@Transactional
	public List<Availability> getAvailabilityOfTutor(Tutor tutor){
		List<Availability> all = toList(availabilityRepository.findAll());
		for(Availability a: all) {
			if(a.getTutor() == tutor)
			{
				all.remove(a);
			}
		}
		return all;
	}
	
	/**
	 * Returns the total number of profiles in the database
	 * 
	 * @return int
	 * 
	 * @author Ali Tapan
	 */
	@Transactional
	public int getNumberofProfiles() {
		int num = (int) studentRepository.count();
		num += (int) tutorRepository.count();
		num += (int) companyManagerRepository.count();
		return num;
	}
	
	
	//*******************************************************//
	//------------------   DELETE METHODS  ------------------//
	//*******************************************************//
	
    @Transactional
	public void deleteStudent(String email) {
		Student s = studentRepository.findStudentByEmail(email);
		
		while(s.getSent().size() != 0) {
			Set<Notification> notifs = s.getSent();
			Notification n = notifs.iterator().next();
			deleteNotif(n.getId());
			notificationRepository.saveAll(notifs);
		}
		
		while(getScheduledCourseByStudent(s).size() != 0) {
			Set<ScheduledCourse> sc = getScheduledCourseByStudent(s);
			ScheduledCourse c = sc.iterator().next();
			deleteScheduledCourse(c.getId());
		}
		
		while(s.getReviewTutor().size() != 0) {
			Set<Review> revs = s.getReviewTutor();
			Review r = revs.iterator().next();
			deleteReview(r.getId());
			reviewRepository.saveAll(revs);
		}
		
		studentRepository.delete(s);
	}
	
	
	@Transactional
	public void deleteTutor(String email) {
		Tutor t = tutorRepository.findTutorByEmail(email);
		
		while(t.getTutorRecieved().size() != 0) {
			Set<Notification> notifs = t.getTutorRecieved();
			Notification n = notifs.iterator().next();
			deleteNotif(n.getId());
			notificationRepository.saveAll(notifs);
		}
		
		while(getScheduledCourseByTutor(t).size() != 0) {
			Set<ScheduledCourse> sc = getScheduledCourseByTutor(t);
			ScheduledCourse c = sc.iterator().next();
			deleteScheduledCourse(c.getId());
		}
		
		while(t.getAvailability().size() != 0) {
			Set<Availability> avails = t.getAvailability();
			Availability a = avails.iterator().next();
			deleteAvailability(a.getId());
			availabilityRepository.saveAll(avails);
		}
		
		while(t.getReview().size() != 0) {
			Set<Review> revs = t.getReview();
			Review r = revs.iterator().next();
			deleteReview(r.getId());
			reviewRepository.saveAll(revs);
		}
		
		while(t.getCoursesOffered().size() !=0 ) {
			Set<Course> course = t.getCoursesOffered();
			Course co = course.iterator().next();
			deleteCourse(co.getCourseName());
			courseRepository.saveAll(course);
		}
		
		tutorRepository.delete(t);
	}
	
	@Transactional
	public void deleteCompanyManager(String email) {
		CompanyManager cm = companyManagerRepository.findCompanyManagerByEmail(email);
		
		while(cm.getCompanyManagerReceived().size() != 0) {
			Set <Notification> notifs = cm.getCompanyManagerReceived();
			Notification n = notifs.iterator().next();
			deleteNotif(n.getId());
			notificationRepository.saveAll(notifs);
		}
	}
	
	@Transactional
	public void deleteScheduledCourse(Integer id) {
		ScheduledCourse sc = scheduledCourseRepository.findSchedueldCourseById(id);
		
		Student s = sc.getStudent();
		s.getScheduledCourse().remove(sc);
		Tutor t = sc.getTutor();
		t.getScheduledCourse().remove(sc);
		Course c = sc.getCourse();
		c.getScheduledCourse().remove(sc);
		
		studentRepository.save(s);
		tutorRepository.save(t);
		courseRepository.save(c);
		scheduledCourseRepository.delete(sc);
	}
	
	@Transactional
	public void deleteCourse(String courseName) {
		Course c = courseRepository.findByCourseName(courseName);
		
		while(getTutorByCoursesOffered(c).size() != 0) {
			List<Tutor> tut = getTutorByCoursesOffered(c);
			Tutor t = tut.iterator().next();
			deleteTutor(t.getEmail());
		}
		
		while(getScheduledCourseByCourse(c).size() != 0){
			Set<ScheduledCourse> sc = getScheduledCourseByCourse(c);
			ScheduledCourse s = sc.iterator().next();
			deleteScheduledCourse(s.getId());
		}
	}
	
	@Transactional
	public void deleteAvailability(Integer id) {
		Availability a = availabilityRepository.findAvailabilityById(id);
		
		Tutor t = a.getTutor();
		Set<Availability> x = t.getAvailability();
		x.remove(a);
		t.setAvailability(x);
		availabilityRepository.delete(a);
	}
	
	@Transactional 
	public void deleteReview(Integer id){
		Review r = reviewRepository.findReviewById(id);
		
		Student s = r.getStudent();
		s.getReviewTutor().remove(r);
		Tutor t = r.getTutor();
		t.getReview().remove(r);
		reviewRepository.delete(r);
	}
	
	@Transactional
	public void deleteNotif(Integer id) {
		Notification n = notificationRepository.findNotificationById(id);
		
		// Delete from student
		Student s = n.getSender();
		Set<Notification> notifsS = s.getSent();
		notifsS.remove(n);
		s.setSent(notifsS);
		studentRepository.save(s);
		
		// Delete from tutor
		Tutor t = n.getTutor();
		if(t != null) {
			Set<Notification> notifsT = t.getTutorRecieved();
			notifsT.remove(n);
			t.setTutorRecieved(notifsT);
			tutorRepository.save(t);
		}
				
		// Delete from company manager
		CompanyManager cm = n.getCompanyManager();
		if(cm != null) {
			Set<Notification> notifsCM = cm.getCompanyManagerReceived();
			notifsCM.remove(n);
			cm.setCompanyManagerReceived(notifsCM);	
			companyManagerRepository.save(cm);
		}
		
		notificationRepository.deleteById(id);
	}
	
	
	//*******************************************************//
	//------------------   HELPER METHODS  ------------------//
	//*******************************************************//
	
	@Transactional
	public List<Student> getAllStudents() {
		return toList(studentRepository.findAll());
	}
	
	@Transactional
	public List<Tutor> getAllTutors() {
		return toList(tutorRepository.findAll());
	}
	
	@Transactional
	public List<Course> getAllCourses() {
		return toList(courseRepository.findAll());
	}
	
	@Transactional
	public List<Notification> getAllNotifications() {
		return toList(notificationRepository.findAll());
	}
	
	@Transactional
	public List<ScheduledCourse> getAllScheduledCourses() {
		return toList(scheduledCourseRepository.findAll());
	}
	
	@Transactional
	public List<CompanyManager> getAllCompanyManager(){
		return toList(companyManagerRepository.findAll());
	}
	
	@Transactional
	public List<Notification> getAllNotification(){
		return toList(notificationRepository.findAll());
	}
	
	@Transactional
	public List<Availability> getAllAvailability(){
		return toList(availabilityRepository.findAll());
	}
	
	@Transactional
	public List<Review> getAllReview(){
		return toList(reviewRepository.findAll());
	}
	
	private <T> List<T> toList(Iterable<T> iterable){
		if(iterable == null){
			throw new IllegalArgumentException("Iterable cannot be null! ");
		}
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}

	
}
