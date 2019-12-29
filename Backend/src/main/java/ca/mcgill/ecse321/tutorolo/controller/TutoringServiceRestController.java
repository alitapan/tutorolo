package ca.mcgill.ecse321.tutorolo.controller;

import ca.mcgill.ecse321.tutorolo.dto.*;
import ca.mcgill.ecse321.tutorolo.model.*;
import ca.mcgill.ecse321.tutorolo.service.TutoringServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
public class TutoringServiceRestController {
	

		@Autowired
		TutoringServiceService service;

		
		@PostMapping("/student/create/{email}")
		public StudentDto createStudent(@PathVariable("email") String email, @RequestParam String password, @RequestParam String name,
				@RequestParam Integer studentId) {
			Student student = service.createStudent(email, name, password, studentId);
			return convertToDto(student);
		}
		
		@PostMapping("/tutor/create/{email}")
		public TutorDto createTutor(@PathVariable("email") String email, @RequestParam String password, @RequestParam String name,
				@RequestParam Integer tutorId, @RequestParam Integer hourlyRate) {
			Tutor tutor = service.createTutor(email, name, password, tutorId, hourlyRate);
			return convertToDto(tutor);
			}
		
		
		@PostMapping("/companyManager/create/{email}")
		public CompanyManagerDto createCompanyManager(@PathVariable("email") String email, @RequestParam String password, @RequestParam String name,
				@RequestParam Integer companyManagerId) {
			CompanyManager companyManager = service.createCompanyManager(email, name, password, companyManagerId);
			return convertToDto(companyManager);
		}
		
		
		@PostMapping("/course/create/{courseName}")
		public CourseDto createCourse(@PathVariable("courseName") String courseName, @RequestParam CourseLevel courseLevel,
				@RequestParam String courseCode) {
			Course course = service.createCourse(courseName, courseLevel, courseCode);
			return convertToDto(course);
		}
		
		
		@PostMapping("/scheduledCourse/create/{id}")
		public ScheduledCourseDto createScheduledCourse(@PathVariable("id") Integer id, @RequestParam String stuEmail, @RequestParam String tutEmail, @RequestParam String courseName, 
				@RequestParam Integer roomNumber, @RequestParam String start, @RequestParam String end, @RequestParam String dat) {
			
			Student stu = service.getStudent(stuEmail);
			Tutor tut = service.getTutor(tutEmail);
			Course c = service.getCourseByCourseName(courseName);
			Time startTime = Time.valueOf(start);
			Time endTime = Time.valueOf(end);
			Date date = Date.valueOf(dat);
			
			ScheduledCourse scheduledCourse = service.createScheduledCourse(stu, tut, c, roomNumber,
					startTime, endTime, date, id);
			
			return convertToDto(scheduledCourse);
		}
		
		@PostMapping("/notification/create/{text}")
		public NotificationDto createNotification(@PathVariable("text") String text, @RequestParam String senderEmail,
				@RequestParam (required = false) String tutEmail, @RequestParam (required = false) String cmEmail) {
			Student s = service.getStudent(senderEmail);
			Tutor t = null;
			CompanyManager cm = null;
			if(tutEmail != null) {
				t = service.getTutor(tutEmail);
			}
			if(cmEmail != null) {
				cm = service.getCompanyManager(cmEmail);
			}
			
			Notification notif = service.createNotification(text, t, s, cm);
			return convertToDto(notif);
		}
		
		@PostMapping("/review/create/{id}")
		public ReviewDto createReview(@PathVariable("id") Integer id, @RequestParam Integer rating, @RequestParam String comment, 
				@RequestParam (required = false) String stuEmail, @RequestParam (required = false) String tutEmail) {
			Student s = null;
			Tutor t = null;
			if(stuEmail != null) {
				s = service.getStudent(stuEmail);
			}
			if(tutEmail != null) {
				t = service.getTutor(tutEmail);
			}
			
			Review r = service.createReview(id, rating, comment, s, t);
			
			if(stuEmail != null)
			{
				Set<Review> sr = s.getReviewTutor();
				sr.add(r);
				s.setReviewTutor(sr);
			}
			if(tutEmail != null)
			{
				Set<Review> tr = t.getReview();
				tr.add(r);
				t.setReview(tr);
			}
			return convertToDto(r);
		}
		
		@PostMapping("/availability/create/{id}")
		public AvailabilityDto createAvailability(@PathVariable("id") Integer id, @RequestParam String date, @RequestParam String start, 
				@RequestParam String end, @RequestParam String tutEmail) {
			Tutor t = service.getTutor(tutEmail);
			Time startTime = Time.valueOf(start);
			Time endTime = Time.valueOf(end);
			Date dat = Date.valueOf(date);
			Availability a = service.createAvailability(dat, startTime, endTime, t, id);
			return convertToDto(a);
		}
		
		
		
		@GetMapping(value = { "/students", "/students/" })
		public List<StudentDto> getAllStudents() {
			List<StudentDto> studentDtos = new ArrayList<>();
			for (Student student : service.getAllStudents()) {
				studentDtos.add(convertToDto(student));
			}
			return studentDtos;
		}
		

		
		
		@GetMapping(value = { "/tutors", "/tutors/" })
		public List<TutorDto> getAllTutors() {
			List<TutorDto> tutorDtos = new ArrayList<>();
			for (Tutor tutor : service.getAllTutors()) {
				tutorDtos.add(convertToDto(tutor));
			}
			return tutorDtos;
		}
		
		
		@GetMapping(value = { "/courses", "/courses/" })
		public List<CourseDto> getAllCourses() {
			List<CourseDto> courseDtos = new ArrayList<>();
			for (Course course : service.getAllCourses()) {
				courseDtos.add(convertToDto(course));
			}
			return courseDtos;
		}
		
		
		@GetMapping(value = { "/scheduledCourses", "/scheduledCourses/" })
		public List<ScheduledCourseDto> getAllScheduledCourses() {
			List<ScheduledCourseDto> scheduledCourseDtos = new ArrayList<>();
			for (ScheduledCourse scheduledCourse : service.getAllScheduledCourses()) {
				scheduledCourseDtos.add(convertToDto(scheduledCourse));
			}
			return scheduledCourseDtos;
		}
		
		@GetMapping(value = { "/scheduledCourses/tutor/{email}" })
		public Integer getAllScheduledCoursesWithTutors(@PathVariable("email") String tutEmail, @RequestParam String stuEmail) {
			Tutor tutor = service.getTutor(tutEmail);
			Student student = service.getStudent(stuEmail);
			List<ScheduledCourseDto> scheduledCourseDtos = new ArrayList<>();
			for (ScheduledCourse scheduledCourse : service.getAllScheduledCourses()) {
				if(scheduledCourse.getTutor() == tutor && scheduledCourse.getStudent() == student)
				{
					scheduledCourseDtos.add(convertToDto(scheduledCourse));
				}
			}
			return scheduledCourseDtos.size();
		}
		
		@GetMapping(value = { "/scheduledCourses/student/{email}" })
		public List<ScheduledCourseDto> getAllScheduledCoursesWithStudents(@PathVariable("email") String stuEmail) {
			Student student = service.getStudent(stuEmail);
			List<ScheduledCourseDto> scheduledCourseDtos = new ArrayList<>();
			for (ScheduledCourse scheduledCourse : service.getAllScheduledCourses()) {
				if(scheduledCourse.getStudent() == student)
				{
					scheduledCourseDtos.add(convertToDto(scheduledCourse));
				}
			}
			return scheduledCourseDtos;
		}
		
		@GetMapping(value = { "/students/{email}"})
		public StudentDto getAStudent(@PathVariable("email") String email) {
			Student s = service.getStudent(email);
			StudentDto studentDto = convertToDto(s);
			return studentDto;
		}
		
		@GetMapping(value = { "/tutors/find/{email}"})
		public TutorDto getATutor(@PathVariable("email") String tutEmail) {
			Tutor t = service.getTutor(tutEmail);
			TutorDto tutorDto= convertToDto(t);
			return tutorDto;
		}
		
		@GetMapping(value = { "/companyManager/"})
		public CompanyManagerDto getTheBoss() {
			CompanyManager cm = service.getAllCompanyManager().get(0);
			return convertToDto(cm);
		}
		
		
		@PostMapping(value = { "/tutors/add/course/{courseName}"})
		public TutorDto addCourseToTutor(@PathVariable("courseName") String courseName, @RequestParam String tutEmail) {
			Tutor t = service.getTutor(tutEmail);
			Course course = service.getCourseByCourseName(courseName);
			Set<Course> c = t.getCoursesOffered();
			c.add(course);
			t.setCoursesOffered(c);
			return convertToDto(t);
		}

		
		@GetMapping(value = { "/tutors/courses/{course}"})
		public List<TutorDto> getTutorByCourses(@PathVariable("course") String courseName) {
			Course c = service.getCourseByCourseName(courseName);
			List<TutorDto> td = new ArrayList<>();
			for(Tutor tutor : service.getTutorByCoursesOffered(c)) {
				td.add(convertToDto(tutor));
			}
			return td;
		}
		
		
		@GetMapping(value = { "/tutors/reviews/{email}"})
		public Integer getAllTutorReviewNumber(@PathVariable("email") String tutEmail) {
			Tutor t = service.getTutor(tutEmail);
			List<ReviewDto> r = new ArrayList<>();
			for(Review review : service.getAllReview()) {
				if(review.getTutor()==t)
					{
						r.add(convertToDto(review));
					}	
			}
			return r.size();
		}

		
		@GetMapping(value = { "scheduledCourse/{id}"})
		public ScheduledCourseDto getScheduedCourseById(@PathVariable("id") Integer id) {
			ScheduledCourse sc = service.getScheduledCourse(id);
			ScheduledCourseDto scheduledCourseDto = convertToDto(sc);
			return scheduledCourseDto;
		}
		
		
		@GetMapping(value = { "tutors/availabilities/{email}"})
		public List<AvailabilityDto> getAvailabilitiesOfTutor(@PathVariable("email") String tutEmail) {
			Tutor tutor = service.getTutor(tutEmail);
			List<AvailabilityDto> availabilities = new ArrayList<>();
			for(Availability a : service.getAllAvailability())
			{
				if(a.getTutor() == tutor) {
					availabilities.add(convertToDto(a));
				}
			}
			return availabilities;
		}
		
		@GetMapping(value = { "scheduledCourse/getNum/"})
		public Integer getScNum() {
			return service.getAllScheduledCourses().size();
		}
		
		@PostMapping(value = { "availabilities/remove/{start}"})
		public void removeSelectedAv(@PathVariable("start") String start, @RequestParam String tutEmail) {
			Tutor t = service.getTutor(tutEmail);
			for(Availability a: service.getAllAvailability())
			{
				if(a.getTutor().getEmail() == tutEmail && a.getStartTime() == Time.valueOf(start))
				{
					int id = a.getId();
					service.deleteAvailability(id);
				}
			}
		}
		
		
		@GetMapping(value = { "/login/{email}", "/login/{email}/" })
		public StudentDto login(@PathVariable("email") String email, @RequestParam("password") String password) {
			List<StudentDto> students = new ArrayList<>();
			for(Student student : service.getAllStudents()) {
				if(student.getEmail().equals(email)) {
					if(student.getPassword().equals(password)) {
						students.add(convertToDto(student));
					} else {
						throw new IllegalArgumentException("Incorrect password! Try again!");
					}
				}
			}
			
			if(students.isEmpty()) {
				throw new IllegalArgumentException("This email is not registered! Please use our web browser to sign up!");
				}
			
			return students.get(0);
			}
		
		
		private StudentDto convertToDto(Student s) {
			if (s == null) 
			{
				throw new IllegalArgumentException("There is no such Student!");
			}
			StudentDto studentDto = new StudentDto(s.getEmail(), s.getPassword(), s.getName(), s.getId());
			return studentDto;
		}

		
		private TutorDto convertToDto(Tutor t) {
			if (t == null) 
			{
				throw new IllegalArgumentException("There is no such Tutor!");
			}
			TutorDto tutorDto = new TutorDto(t.getEmail(), t.getPassword(), t.getName(), t.getId(), t.getHourlyRate());
			return tutorDto;
		}
		
		private CourseDto convertToDto(Course c) {
			if (c == null) 
			{
				throw new IllegalArgumentException("There is no such Course!");
			}
			CourseDto courseDto = new CourseDto(c.getCourseCode(), c.getCourseLevel(), c.getCourseName());
			return courseDto;
		}
		
		private AvailabilityDto convertToDto(Availability at) {
			if (at == null) 
			{
				throw new IllegalArgumentException("There is no such Availability!");
			}
			AvailabilityDto availabilityDto = new AvailabilityDto(at.getId(), at.getAvailableDate(), at.getStartTime(), at.getEndTime(), convertToDto(at.getTutor()));
			return availabilityDto;
		}
		
		private CompanyManagerDto convertToDto(CompanyManager m) {
			if (m == null) 
			{
				throw new IllegalArgumentException("Invalid Company Manager!");
			}
			CompanyManagerDto companymanagerDto = new CompanyManagerDto(m.getEmail(), m.getPassword(), m.getPassword(), m.getId());
			return companymanagerDto;
		}
		

		private ScheduledCourseDto convertToDto(ScheduledCourse sc) {
			if(sc == null) {
				throw new IllegalArgumentException("Invalid ScheduledCourse");
			}
			ScheduledCourseDto scheduledCourseDto = new ScheduledCourseDto(sc.getId(), sc.getStartTime(), sc.getEndTime(), sc.getDate(), convertToDto(sc.getStudent()), convertToDto(sc.getTutor()), convertToDto(sc.getCourse()));
			return scheduledCourseDto;
		}
		
		private ReviewDto convertToDto(Review r) {
			if(r == null) {
				throw new IllegalArgumentException("Invalid Review");
			}
			ReviewDto reviewDto = null;
			if(r.getStudent() == null)
			{
				reviewDto = new ReviewDto(r.getId(), r.getRating(), r.getComment(), null, convertToDto(r.getTutor()));
			}
			else
			{
				reviewDto = new ReviewDto(r.getId(), r.getRating(), r.getComment(), convertToDto(r.getStudent()), null);
			}
			return reviewDto;
		}
		
		private NotificationDto convertToDto(Notification n) {
			if(n == null) {
				throw new IllegalArgumentException("Invalid Notification");
			}
			NotificationDto notifDto = null;
			if(n.getTutor() == null)
			{
				notifDto = new NotificationDto(n.getId(), n.getText(), convertToDto(n.getSender()),  null, convertToDto(n.getCompanyManager()));
			}
			else
			{
				notifDto = new NotificationDto(n.getId(), n.getText(), convertToDto(n.getSender()), convertToDto(n.getTutor()), null);
			}
			
			return notifDto;
		}
	

}
