package ca.mcgill.ecse321.tutorolo.dto;

import java.util.List;
import net.bytebuddy.utility.RandomString;
import ca.mcgill.ecse321.tutorolo.model.Review;

public class TutorDto {
	private String email;
	private String password;
	private String name;
	private Integer id;
	private Integer hourlyRate;
	private List<CourseDto> course;
	private List<Review> review;
	private Integer index;
	private Integer indexR;
	
	public TutorDto() {
		
	}
	
	public TutorDto(String email) {
		this(email, RandomString.make(10), "", 1, 1);
	}
	
	public TutorDto(String email, String password, String name, Integer id, Integer hourlyRate)
	{
		this.email = email;
		this.password = password;
		this.name = name;
		this.id = id;
		this.hourlyRate = hourlyRate;
	}
	
	public CourseDto getCourse(Integer i) {
		return course.get(i);
	}
	
	public void setCourse(CourseDto course) {
		this.course.set(index, course);
		this.index = this.index + 1;
	}
	
	public Review getReview(Integer i) {
		return review.get(i);
	}
	
	public void setReview(Review review) {
		this.review.set(index, review);
		this.indexR = this.indexR + 1;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getHourlyRate() {
		return this.hourlyRate;
	}
	
	public void setHourlyRate(Integer hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
}
