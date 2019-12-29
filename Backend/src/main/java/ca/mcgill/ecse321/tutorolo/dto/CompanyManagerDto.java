package ca.mcgill.ecse321.tutorolo.dto;

public class CompanyManagerDto {
	private String email;
	private String password;
	private String name;
	private Integer id;
	
	public CompanyManagerDto() {
	}
	
	public CompanyManagerDto(String email) {
		this(email, null, null, 1);
	}
	
	public CompanyManagerDto(String email, String password, String name, Integer id) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
