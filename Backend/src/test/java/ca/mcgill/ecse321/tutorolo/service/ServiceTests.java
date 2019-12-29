package ca.mcgill.ecse321.tutorolo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import ca.mcgill.ecse321.tutorolo.dao.*;
import ca.mcgill.ecse321.tutorolo.model.*;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTests {
	@Mock
	private StudentRepository stuDao;
	@Mock
	private TutorRepository tutDao;
	@Mock
	private CompanyManagerRepository cmDao;
	@Mock
	private CourseRepository cDao;
	@Mock
	private ScheduledCourseRepository scDao;
	@Mock
	private NotificationRepository notifDao;
	@Mock
	private ReviewRepository reviewDao;
	@Mock
	private AvailabilityRepository availDao;
	@Mock
	private ProfileRepository profDao;
	
	@InjectMocks
	private TutoringServiceService service;
	
	private Student student;
	private Tutor tutor;
	private CompanyManager companyManager;
	private Course course;
	private ScheduledCourse scheduledCourse;
	private Notification notification;
	private Review review;
	private Availability availability;
	
	private static final String STUDENT_KEY = "isaacnewton@gmail.com";
	private static final String NONEXISTING_KEY = "NotAStudent";
	
	@Before
	public void setMockOutput() {
		when(stuDao.findStudentByEmail((anyString()))).thenAnswer((InvocationOnMock invocation) -> {
			if(invocation.getArgument(0).equals(STUDENT_KEY)) {
				Student student = new Student();
				student.setEmail(STUDENT_KEY);
				return student;
			} else {
				return null;
			}
		});
		// Whenever anything is saved, just return the parameter object
		Answer<?> returnParameterAsAnswer = (InvocationOnMock invocation) -> {
			return invocation.getArgument(0);
		};
		when(stuDao.save(any(Student.class))).thenAnswer(returnParameterAsAnswer);
		when(tutDao.save(any(Tutor.class))).thenAnswer(returnParameterAsAnswer);
		when(cmDao.save(any(CompanyManager.class))).thenAnswer(returnParameterAsAnswer);
		when(cDao.save(any(Course.class))).thenAnswer(returnParameterAsAnswer);
		when(scDao.save(any(ScheduledCourse.class))).thenAnswer(returnParameterAsAnswer);
		when(reviewDao.save(any(Review.class))).thenAnswer(returnParameterAsAnswer);
		when(availDao.save(any(Availability.class))).thenAnswer(returnParameterAsAnswer);
		when(notifDao.save(any(Notification.class))).thenAnswer(returnParameterAsAnswer);
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
			student = service.createStudent(email, name, password, id);
		} catch (IllegalArgumentException e) {
			fail();
		}

		assertEquals(email, student.getEmail());
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
			student = service.createStudent(email, password, name, id);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		assertEquals("Student name cannot be empty! Email cannot be empty! Password cannot be empty! ID is inavlid!", error);
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
			student = service.createStudent(email, password, name, id);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		assertEquals("Student name cannot be empty! Email cannot be empty! Password cannot be empty! ID is inavlid!", error);
	}
		
	
	@Test
	public void testCreateCourse() {
		assertEquals(0, service.getAllCourses().size());
		String courseName = "Economics of the Enviroment";
		CourseLevel courseLevel = CourseLevel.University;
		String courseCode = "ECON223";
		
		try {
			course = service.createCourse(courseName, courseLevel, courseCode);
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		assertEquals(courseCode, course.getCourseCode());
	}
	
	@Test
	public void testCreateCourseNull() {
		assertEquals(0, service.getAllCourses().size());
		String courseName = null;
		CourseLevel courseLevel = null;
		String courseCode = null;
		String error ="";
		
		try {
			course = service.createCourse(courseName, courseLevel, courseCode);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertEquals("CourseCode cannot be empty! CourseLevel invalid! CourseName cannot be empty! ", error);
		
	}
	
	@Test
	public void testCreateCourseEmpty() {
		assertEquals(0, service.getAllCourses().size());
		String courseName = "";
		CourseLevel courseLevel = null;
		String courseCode = "";
		String error ="";
		
		try {
			course = service.createCourse(courseName, courseLevel, courseCode);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertEquals("CourseCode cannot be empty! CourseLevel invalid! CourseName cannot be empty! ", error);
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
			tutor = service.createTutor(email, name, password, id, hourlyRate);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}


		assertEquals(email, tutor.getEmail());
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
			tutor = service.createTutor(email, name, password, id, hourlyRate);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}


		assertEquals("Tutor name cannot be empty! Email cannot be empty! Password cannot be empty! ID is inavlid! HourlyRate is invalid!", error);
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
			tutor = service.createTutor(email, name, password, id, hourlyRate);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}


		assertEquals("Tutor name cannot be empty! Email cannot be empty! Password cannot be empty! ID is inavlid! HourlyRate is invalid!", error);
	
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
			tutor = service.createTutor(email, name, password, id, hourlyRate);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertEquals("Tutor name cannot be empty! Email cannot be empty! Password cannot be empty! ID is inavlid! HourlyRate is invalid!", error);
	}
	
	@Test
	public void testCreateScheduledCourse() {
		assertEquals(0, service.getAllScheduledCourses().size());
		
		Calendar c = Calendar.getInstance();
		c.set(2019, Calendar.OCTOBER, 16, 9, 00, 0);
		Date date = new Date(c.getTimeInMillis());
		Time startTime = new Time(c.getTimeInMillis());
		c.set(2019, Calendar.OCTOBER, 16, 10, 30, 0);
		Time endTime = new Time(c.getTimeInMillis());
		Integer scid = 12223;
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
			scheduledCourse = service.createScheduledCourse(stu, tut, cou, roomNumber, startTime, endTime, date, scid);
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		assertEquals(scid, scheduledCourse.getId());

	}
	
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
			scheduledCourse = service.createScheduledCourse(stu, tut, cou, roomNumber, startTime, endTime, date, scid);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertEquals("Student is null! ", error);
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
		
		Integer id = 1;
		String text = "this is a notification";

		try {
			notification = service.createNotification(text, tut, stu, null);
		} catch (IllegalArgumentException e) {
			fail();
		}

		assertEquals(notification.getSender().getEmail(), emailS);
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
			notification = service.createNotification(text, tut, stu, cm);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		assertEquals("Notification can only be sent to either Tutor or Company Manager, not both! ", error);
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
			companyManager = service.createCompanyManager(email, name, password, id);
		} catch (IllegalArgumentException e) {
			fail();
		}

		
		assertEquals(companyManager.getEmail(), email);
		
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
			companyManager = service.createCompanyManager(email, name, password, id);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		assertEquals("Manager name cannot be empty! Email cannot be empty! Password cannot be empty! ID invalid!", error);
	}
	
	@Test
	public void testCreateReview() {
		assertEquals(0, service.getAllReview().size());
		
		int id = 2234;
		Integer rating = 4;
		String comment = "This student is awesome!";
		
		String name = "Isaac Newton";
		String email = "isaacnewton@hotmail.com";
		String password = "12345";
		int idS = 4444;
		Student stu;
		stu = service.createStudent(email, name, password, idS);
		
		try {
			review = service.createReview(id, rating, comment, stu, null);
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		assertEquals(rating, review.getRating());

		
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
			review = service.createReview(id, rating, comment, stu, tut);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertEquals("Same review cannot belong to Student and Tutor at the same time! ", error);
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
			availability = service.createAvailability(availableDate, startTime, endTime, tut, id);
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		assertEquals(id, availability.getId());
	
		
	}
	
	@Test
	public void testCreateAvailabilityNull() {
		assertEquals(0, service.getAllAvailability().size());
		
		String error = "";
		Date availableDate = null;
		Time startTime = null;
		Time endTime = null;
		int id = -1;
		Tutor tut = null;
		
		try {
			availability = service.createAvailability(availableDate, startTime, endTime, tut, id);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertEquals("Tutor is null! Available Date invalid! Start Time invalid! End Time invalid! ID invalid!", error);
		
	}

	@Test
	public void testGetNonExistingPerson() {
		assertNull(service.getStudent(NONEXISTING_KEY));
	}
}

