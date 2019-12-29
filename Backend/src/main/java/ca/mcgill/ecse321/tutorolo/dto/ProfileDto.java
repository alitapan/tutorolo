package ca.mcgill.ecse321.tutorolo.dto;

import net.bytebuddy.utility.RandomString;

public class ProfileDto {
	
	private String email; //primary key
	private String password; //not empty, not null;
	private String name;
	
	public ProfileDto() {
		
	}
	
	public ProfileDto(String email) {
		this(email, RandomString.make(10), "");
	}
	
	public ProfileDto(String email, String password, String name) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public String getName() {
		return name;
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
}
