package ca.mcgill.ecse321.tutorolo.dto;

import ca.mcgill.ecse321.tutorolo.model.CourseLevel;

public class CourseDto {
	
	private String courseCode;
	private CourseLevel courseLevel;
	private String courseName;
	
	public CourseDto() {
		
	}
	
	public CourseDto(String courseName) {
		this(null, null, courseName);
	}
	
	public CourseDto(String courseCode, CourseLevel courseLevel, String courseName)
	{
		this.courseCode = courseCode;
		this.courseLevel = courseLevel;
		this.courseName = courseName;
	}
	
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	public void setCourseLevel(CourseLevel courseLevel) {
		this.courseLevel = courseLevel;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public String getCourseCode() {
		return this.courseCode;
	}
	
	public CourseLevel getCourseLevel() {
		return this.courseLevel;
	}
	
	public String getName() {
		return this.courseName;
	}
}
