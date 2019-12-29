package ca.mcgill.ecse321.tutorolo.dto;

import java.sql.Date;
import java.sql.Time;

public class ScheduledCourseDto {
	private Time startTime;
	private Time endTime;
	private Date date;
	private Integer id;
	private StudentDto student;
	private TutorDto tutor;
	private CourseDto course;
	
	
	public ScheduledCourseDto() {
	}
	
	public ScheduledCourseDto(Integer id) {
		this(id, null, null, null, null, null, null);
	}
	
	
	public ScheduledCourseDto(Integer id, Time startTime, Time endTime, Date date, StudentDto student, TutorDto tutor, CourseDto course) {
		this.startTime= startTime;
		this.endTime = endTime;
		this.date = date;
		this.id = id;
		this.student = student;
		this.tutor = tutor;
		this.course = course;
	}
	
	public Time getStartTime() {
		return this.startTime;
	}
	
	public Time getEndTime() {
		return this.endTime;
	}
	
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	
	public StudentDto getStudent() {
		return student;
	}
	
	public void setStudent(StudentDto student)
	{
		this.student = student;
	}
	
	public TutorDto getTutor() {
		return tutor;
	}
	
	public void setTutor(TutorDto tutor) {
		this.tutor = tutor;
	}
	
	public CourseDto getCourse() {
		return course;
	}
	
	public void setCourse(CourseDto course) {
		this.course = course;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
}
