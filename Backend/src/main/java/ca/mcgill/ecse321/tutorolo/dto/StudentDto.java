package ca.mcgill.ecse321.tutorolo.dto;

import ca.mcgill.ecse321.tutorolo.model.Review;
import net.bytebuddy.utility.RandomString;

public class StudentDto {
	private String email;
	private String name;
	private String password;
	private int id;
	private Review review;


	public StudentDto() {
	}
	
	
	public StudentDto(String email) {
		
		this(email, RandomString.make(10), "", 1);
	}
	
	
	public StudentDto(String email, String password, String name, Integer id) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	
	public void setID(Integer id) {
		this.id = id;
	}
	
	public int getID() {
		return id;
	}
	
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Review getReview() {
		return this.review;
	}
	
	public void setReview(Review review) {
		this.review = review;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

}