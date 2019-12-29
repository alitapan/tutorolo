package ca.mcgill.ecse321.tutorolo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.tutorolo.model.*;
import ca.mcgill.ecse321.tutorolo.dao.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTutoringServiceService {
	
	@Autowired
	private TutoringServiceService service;
	
	@Autowired
	private CompanyManagerRepository companyManagerRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private TutorRepository tutorRepository;
	@Autowired
	private ScheduledCourseRepository scheduledCourseRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private AvailabilityRepository availabilityRepository;
	@Autowired
	private NotificationRepository notificationRepository;
	@Autowired
	private ProfileRepository profileRepository;

	
	@After
	public void clearDatabase() {
		notificationRepository.deleteAll();
		availabilityRepository.deleteAll();
		courseRepository.deleteAll();
		reviewRepository.deleteAll();
		studentRepository.deleteAll();
		tutorRepository.deleteAll();
		companyManagerRepository.deleteAll();
		profileRepository.deleteAll();
		scheduledCourseRepository.deleteAll();
	}
	
	
	@Test
	public void testCreateProfileNoName() {
		assertEquals(0, service.getNumberofProfiles());

		String email = "emma.eagles@mail.mcgill.ca ";
		String name = "";
		String password = "12341234";
		int id = 31231234;
		String error = null;

		try {
			service.createStudent(email, name, password, id);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Student name cannot be empty! ", error);

		// check no change in memory
		assertEquals(0, service.getNumberofProfiles());
	}

	@Test
	public void testCreateProfileNoEmail() {
		assertEquals(0, service.getNumberofProfiles());

		String email = "";
		String name = "Emma Eagles";
		String password = "12341234";
		int id = 31231234;
		String error = null;

		try {
			service.createStudent(email, name, password, id);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Email cannot be empty! ", error);

		// check no change in memory
		assertEquals(0, service.getNumberofProfiles());
	}


	@Test
	@SuppressWarnings("unused")
	public void testCreateStudent() {
		assertEquals(0, service.getAllStudents().size());

		String name = "Isaac Newton";
		String email = "isaacnewton@hotmail.com";
		String password = "12345";
		int id = 4444;
		String error = null;

		try {
			service.createStudent(email, name, password, id);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		List<Student> allStudents = service.getAllStudents();

		assertEquals(1, allStudents.size());
		assertEquals(name, allStudents.get(0).getName());
		
		assertEquals("Isaac Newton", service.getStudent(email).getName());
		assertEquals(null, studentRepository.findStudentByName("Ali Tapan"));
	}
	
	@Test
	public void testCreateStudentNull() {
		assertEquals(0, service.getAllStudents().size());
		
		String name = null;
		int id = -1;
		String password = null;
		String email = null;
		String error = null;

		try {
			service.createStudent(email, password, name, id);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		assertEquals("Student name cannot be empty! Email cannot be empty! Password cannot be empty! ID is inavlid!", error);
		assertEquals(0, service.getNumberofProfiles());
	}
	
	@Test
	public void testCreateStudentEmpty() {
		assertEquals(0, service.getAllStudents().size());
		
		String name = "";
		int id = -1;
		String password = "";
		String email = "";
		String error = "";

		try {
			service.createStudent(email, password, name, id);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		assertEquals("Student name cannot be empty! Email cannot be empty! Password cannot be empty! ID is inavlid!", error);
		assertEquals(0, service.getNumberofProfiles());
	}
	
	@Test
	public void testCreateStudentSpaces() {
		assertEquals(0, service.getAllStudents().size());
		
		String name = " ";
		int id = -1;
		String password = " ";
		String email = " ";
		String error = " ";

		try {
			service.createStudent(email, password, name, id);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		assertEquals("Student name cannot be empty! Email cannot be empty! Password cannot be empty! ID is inavlid!", error);
		assertEquals(0, service.getNumberofProfiles());
	}
	
	@Test
	@SuppressWarnings("unused")
	public void testCreateTutor() {
		assertEquals(0, service.getAllTutors().size());

		String name = "Isaac Newton";
		String email = "isaacnewton@hotmail.com";
		String password = "12345";
		int id = 4444;
		int hourlyRate = 15;
		String error = null;

		try {
			service.createTutor(email, name, password, id, hourlyRate);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		List<Tutor> allTutors = service.getAllTutors();

		assertEquals(1, allTutors.size());
		assertEquals(name, allTutors.get(0).getName());
		
		assertEquals("Isaac Newton", service.getTutor(email).getName());
		assertEquals(null, tutorRepository.findTutorByName("Ali Tapan"));
	}
	
	@Test
	public void testCreateTutorNull() {
		assertEquals(0, service.getAllTutors().size());
		
		String name = null;
		int id = -1;
		String password = null;
		String email = null;
		String error = null;
		int hourlyRate = -1;

		
		try {
			service.createTutor(email, name, password, id, hourlyRate);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		assertEquals("Tutor name cannot be empty! Email cannot be empty! Password cannot be empty! ID is inavlid! HourlyRate is invalid!", error);
		assertEquals(0, service.getNumberofProfiles());
	}
	
	@Test
	public void testCreateTutorEmpty() {
		assertEquals(0, service.getAllStudents().size());
		
		String name = "";
		int id = -1;
		String password = "";
		String email = "";
		String error = "";
		int hourlyRate = -1;

		
		try {
			service.createTutor(email, name, password, id, hourlyRate);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		assertEquals("Tutor name cannot be empty! Email cannot be empty! Password cannot be empty! ID is inavlid! HourlyRate is invalid!", error);
		assertEquals(0, service.getNumberofProfiles());
	}
	
	@Test
	public void testCreateTutorSpaces() {
		assertEquals(0, service.getAllTutors().size());
		
		String name = " ";
		int id = -1;
		String password = " ";
		String email = " ";
		String error = " ";
		int hourlyRate = -1;
		
		try {
			service.createTutor(email, name, password, id, hourlyRate);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		assertEquals("Tutor name cannot be empty! Email cannot be empty! Password cannot be empty! ID is inavlid! HourlyRate is invalid!", error);
		assertEquals(0, service.getNumberofProfiles());
	}
	
	@Test
	@SuppressWarnings("unused")
	public void testCreateCompanyManager() {
		assertEquals(0, service.getAllCompanyManager().size());

		String name = "Isaac Newton";
		String email = "isaacnewton@hotmail.com";
		String password = "12345";
		int id = 2223;
		String error = null;

		try {
			service.createCompanyManager(email, name, password, id);
		} catch (IllegalArgumentException e) {
			fail();
		}

		List<CompanyManager> boss = service.getAllCompanyManager();

		assertEquals(1, boss.size());
		assertEquals(name, boss.get(0).getName());
		
		assertEquals("Isaac Newton", service.getCompanyManager(email).getName());
		assertEquals(null, companyManagerRepository.findCompanyManagerByName("Ali Tapan"));
	}
	
	@Test
	public void testCreateCompanyManagerNull() {
		assertEquals(0, service.getAllCompanyManager().size());
		
		String name = null;
		int id = -1;
		String password = null;
		String email = null;
		String error = null;

		try {
			service.createCompanyManager(email, name, password, id);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		assertEquals("Manager name cannot be empty! Email cannot be empty! Password cannot be empty! ID invalid!", error);
		assertEquals(0, service.getNumberofProfiles());
	}
	
	@Test
	public void testCreateCompanyManagerEmpty() {
		assertEquals(0, service.getAllCompanyManager().size());
		
		String name = "";
		int id = -1;
		String password = "";
		String email = "";
		String error = "";
		id = -1;

		try {
			service.createCompanyManager(email, name, password, id);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		assertEquals("Manager name cannot be empty! Email cannot be empty! Password cannot be empty! ID invalid!", error);
		assertEquals(0, service.getNumberofProfiles());
	}
	
	@Test
	public void testCreateCompanyManagerSpaces() {
		assertEquals(0, service.getAllCompanyManager().size());
		
		String name = " ";
		int id = -1;
		String password = " ";
		String email = " ";
		String error = " ";

		try {
			service.createCompanyManager(email, name, password, id);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		assertEquals("Manager name cannot be empty! Email cannot be empty! Password cannot be empty! ID invalid!", error);
		assertEquals(0, service.getNumberofProfiles());
	}
	
	/*@Test
	public void testCreateScheduledCourse() {
		assertEquals(0, service.getAllScheduledCourses().size());
		
		Calendar c = Calendar.getInstance();
		c.set(2019, Calendar.OCTOBER, 16, 9, 00, 0);
		Date date = new Date(c.getTimeInMillis());
		Time startTime = new Time(c.getTimeInMillis());
		c.set(2019, Calendar.OCTOBER, 16, 10, 30, 0);
		Time endTime = new Time(c.getTimeInMillis());
		int scid = 12223;
		int roomNumber = 2;
		
		
		String tname = "Isaac Newton Jr";
		String temail = "isaacnewton@hotmail.com";
		String tpassword = "12345";
		int tid = 414244;
		int hourlyRate = 15;
		
		String sname = "Albert Einstein Jr";
		String semail = "alberteinstein@hotmail.com";
		String spassword = "13333345";
		int sid = 22441244;
		
		String courseName = "Model-Based Programming";
		CourseLevel courseLevel = CourseLevel.University;
		String courseCode = "ECSE223";
		
		Student stu = service.createStudent(semail, sname, spassword, sid);
		Tutor tut = service.createTutor(temail, tname, tpassword, tid, hourlyRate);
		Course cou = service.createCourse(courseName, courseLevel, courseCode);
		
		try {
			service.createScheduledCourse(stu, tut, cou, roomNumber, startTime, endTime, date, scid);
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		assertEquals(1, service.getAllScheduledCourses().size());
		//assertEquals(false, service.getScheduledCourseByStudent(stu).isEmpty());
	}*/
	
	@Test
	public void testCreateScheduledCourseNullStudent() {
		assertEquals(0, service.getAllScheduledCourses().size());
		
		Calendar c = Calendar.getInstance();
		c.set(2019, Calendar.OCTOBER, 16, 9, 00, 0);
		Date date = new Date(c.getTimeInMillis());
		Time startTime = new Time(c.getTimeInMillis());
		c.set(2019, Calendar.OCTOBER, 16, 10, 30, 0);
		Time endTime = new Time(c.getTimeInMillis());
		int scid = 12223;
		int roomNumber = 2;
		String error ="";
		
		String tname = "Isaac Newton";
		String temail = "isaacnewton@hotmail.com";
		String tpassword = "12345";
		int tid = 4444;
		int hourlyRate = 15;
		
		String courseName = "Operating Systems";
		CourseLevel courseLevel = CourseLevel.University;
		String courseCode = "ECSE427";
		
		Student stu = null;
		Tutor tut = service.createTutor(temail, tname, tpassword, tid, hourlyRate);
		Course cou = service.createCourse(courseName, courseLevel, courseCode);
		
		try {
			service.createScheduledCourse(stu, tut, cou, roomNumber, startTime, endTime, date, scid);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertEquals("Student is null! ", error);
		assertEquals(0, service.getAllScheduledCourses().size());

	}
	
	@Test
	public void testCreateScheduledCourseNullTutor() {
		assertEquals(0 , service.getAllScheduledCourses().size());
		
		Calendar c = Calendar.getInstance();
		c.set(2019, Calendar.OCTOBER, 16, 9, 00, 0);
		Date date = new Date(c.getTimeInMillis());
		Time startTime = new Time(c.getTimeInMillis());
		c.set(2019, Calendar.OCTOBER, 16, 10, 30, 0);
		Time endTime = new Time(c.getTimeInMillis());
		int scid = 12223;
		int roomNumber = 2;
		String error ="";
		
		
		String sname = "Albert Einstein";
		String semail = "alberteinstein@hotmail.com";
		String spassword = "13333345";
		int sid = 2244;
		
		String courseName = "Artificial Intellegence";
		CourseLevel courseLevel = CourseLevel.University;
		String courseCode = "COMP424";
		
		Student stu = service.createStudent(semail, sname, spassword, sid);
		Tutor tut = null;
		Course cou = service.createCourse(courseName, courseLevel, courseCode);
		
		try {
			service.createScheduledCourse(stu, tut, cou, roomNumber, startTime, endTime, date, scid);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertEquals("Tutor is null! ", error);
		assertEquals(null, service.getScheduledCourse(12223));
		assertEquals(0, service.getScheduledCourseByStudent(stu).size());
	}
	
	@Test
	@SuppressWarnings("unused")
	public void testCreateNotificationStudent() {
		assertEquals(0, service.getAllNotifications().size());

		String emailS = "susan@gmail.com";
		String nameS = "susan";
		String passwordS = "iloveC";
		int idS = 3354;
		Student stu;
		stu = service.createStudent(emailS, nameS, passwordS, idS);

		String emailT = "paul.hooley@gmail.com";
		String nameT = "qwefqwefq";
		String passwordT = "frisbyislife";
		int hourlyRate = 17;
		int idT = 3131;
		Tutor tut;
		tut = service.createTutor(emailT, nameT, passwordT, idT, hourlyRate);
		
		int id = 1;
		String text = "this is a notification";

		try {
			service.createNotification(text, tut, stu, null);
		} catch (IllegalArgumentException e) {
			fail();
		}


		assertEquals(1, service.getAllNotifications().size());
		assertEquals(text, service.getAllNotifications().get(0).getText());
		
		assertEquals(false, service.getNotificationStudent(stu).isEmpty());
		assertEquals(false, service.getNotificationTutor(tut).isEmpty());
	}
	
	@Test
	@SuppressWarnings("unused")
	public void testCreateNotificationBoth() {
		assertEquals(0, service.getAllNotifications().size());

		String emailS = "susan@gmail.com";
		String nameS = "susan";
		String passwordS = "iloveC";
		int idS = 3354;
		Student stu;
		stu = service.createStudent(emailS, nameS, passwordS, idS);

		String emailT = "paul.hooley@gmail.com";
		String nameT = "qwefqwefq";
		String passwordT = "frisbyislife";
		int hourlyRate = 17;
		int idT = 3131;
		Tutor tut;	
		tut = service.createTutor(emailT, nameT, passwordT, idT, hourlyRate);
		
		String emailC = "boss@boss.com";
		String nameC = "boss";
		String passwordC = "1222";
		int idC = 1223;
		CompanyManager cm;
		cm = service.createCompanyManager(emailC, nameC, passwordC, idC);
		
		int id = 1;
		String text = "this is a notification";
		String error = null;

		try {
			service.createNotification(text, tut, stu, cm);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		assertEquals("Notification can only be sent to either Tutor or Company Manager, not both! ", error);
		assertEquals(0, service.getAllNotifications().size());
	}
	
	@Test
	public void testCreateCourse() {
		assertEquals(0, service.getAllCourses().size());
		String courseName = "Economics of the Enviroment";
		CourseLevel courseLevel = CourseLevel.University;
		String courseCode = "ECON223";
		
		try {
			service.createCourse(courseName, courseLevel, courseCode);
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		assertEquals(1, service.getAllCourses().size());
		assertEquals(true, service.getCourseByCourseCode("MATH381").isEmpty());
	}
	
	@Test
	public void testCreateCourseNull() {
		assertEquals(0, service.getAllCourses().size());
		String courseName = null;
		CourseLevel courseLevel = null;
		String courseCode = null;
		String error ="";
		
		try {
			service.createCourse(courseName, courseLevel, courseCode);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertEquals("CourseCode cannot be empty! CourseLevel invalid! CourseName cannot be empty! ", error);
		assertEquals(0, service.getAllCourses().size());
	}
	
	@Test
	public void testCreateCourseEmpty() {
		assertEquals(0, service.getAllCourses().size());
		String courseName = "";
		CourseLevel courseLevel = null;
		String courseCode = "";
		String error ="";
		
		try {
			service.createCourse(courseName, courseLevel, courseCode);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertEquals("CourseCode cannot be empty! CourseLevel invalid! CourseName cannot be empty! ", error);
		assertEquals(0, service.getAllCourses().size());
	}
	
	@Test
	public void testCreateCourseSpace() {
		assertEquals(0, service.getAllCourses().size());
		String courseName = " ";
		CourseLevel courseLevel = null;
		String courseCode = " ";
		String error ="";
		
		try {
			service.createCourse(courseName, courseLevel, courseCode);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertEquals("CourseCode cannot be empty! CourseLevel invalid! CourseName cannot be empty! ", error);
		assertEquals(0, service.getAllCourses().size());
	}
	
	@Test
	public void testCreateReview() {
		assertEquals(0, service.getAllReview().size());
		
		int id = 2234;
		int rating = 4;
		String comment = "This student is awesome!";
		
		String name = "Isaac Newton";
		String email = "isaacnewton@hotmail.com";
		String password = "12345";
		int idS = 4444;
		Student stu;
		stu = service.createStudent(email, name, password, idS);
		
		try {
			service.createReview(id, rating, comment, stu, null);
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		assertEquals(1, service.getAllReview().size());

		
	}
	
	@Test
	public void testCreateReviewBoth() {
		assertEquals(0, service.getAllReview().size());
		String error ="";
		int id = 2234;
		int rating = 4;
		String comment = "This student is awesome!";
		
		String name = "Isaac Newton";
		String email = "isaacnewton@hotmail.com";
		String password = "12345";
		int idS = 4444;
		Student stu;
		stu = service.createStudent(email, name, password, idS);
		
		String emailT = "paul.hooley@gmail.com";
		String nameT = "qwefqwefq";
		String passwordT = "frisbyislife";
		int hourlyRate = 17;
		int idT = 3131;
		Tutor tut;	
		tut = service.createTutor(emailT, nameT, passwordT, idT, hourlyRate);
		
		try {
			service.createReview(id, rating, comment, stu, tut);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertEquals("Same review cannot belong to Student and Tutor at the same time! ", error);
		assertEquals(0, service.getAllReview().size());	
	}
	
	@Test
	public void testCreateReviewNullStudentAndTutor() {
		assertEquals(0, service.getAllReview().size());
		String error ="";
		int id = 2234;
		int rating = 4;
		String comment = "This student is awesome!";
	
		
		try {
			service.createReview(id, rating, comment, null, null);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertEquals("Review needs at least one profile! ", error);
		assertEquals(0, service.getAllReview().size());
	}
	
	@Test
	public void testCreateAvailability() {
		assertEquals(0, service.getAllAvailability().size());
		
		Calendar c = Calendar.getInstance();
		c.set(2019, Calendar.OCTOBER, 16, 9, 00, 0);
		Date availableDate = new Date(c.getTimeInMillis());
		Time startTime = new Time(c.getTimeInMillis());
		c.set(2019, Calendar.OCTOBER, 16, 10, 30, 0);
		Time endTime = new Time(c.getTimeInMillis());
		Integer id = 112;
		String name = "Isaac Newton";
		String email = "isaacnewton@hotmail.com";
		String password = "12345";
		int idT = 4444;
		int hourlyRate = 15;
		
		Tutor tut = service.createTutor(email, name, password, idT, hourlyRate);
		
		try {
			service.createAvailability(availableDate, startTime, endTime, tut, id);
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		assertEquals(1, service.getAllAvailability().size());
	
		
	}
	
	@Test
	@SuppressWarnings("unused")
	public void testCreateAvailabilityNull() {
		assertEquals(0, service.getAllAvailability().size());
		
		String error = "";
		Date availableDate = null;
		Time startTime = null;
		Time endTime = null;
		int roomNumber = -1;
		int id = -1;
		Tutor tut = null;
		
		try {
			service.createAvailability(availableDate, startTime, endTime, tut, id);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertEquals("Tutor is null! Available Date invalid! Start Time invalid! End Time invalid! ID invalid!", error);
		assertEquals(0, service.getAllAvailability().size());
		
	}
	

}
