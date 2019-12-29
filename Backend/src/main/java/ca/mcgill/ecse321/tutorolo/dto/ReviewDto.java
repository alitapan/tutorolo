package ca.mcgill.ecse321.tutorolo.dto;

public class ReviewDto {
	
	private Integer rating;
	private String comment;
	private Integer id;
	private StudentDto student;
	private TutorDto tutor;
	
	public ReviewDto() {
		
	}

	public ReviewDto(Integer id) {
		this(id, 1, null, null, null);
	}
	
	public ReviewDto(Integer id , Integer rating, String comment, StudentDto student, TutorDto tutor) {
		this.rating = rating;
		this.student = student;
		this.tutor = tutor;
		this.comment = comment;
		this.id = id;
	}
	
	public Integer getRating() {
		return this.rating;
	}
	
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	
	public StudentDto getStudent() {
		return student;
	}
	
	public void setStudent(StudentDto student) {
		this.student = student;
	}
	
	public TutorDto getTutor() {
		return tutor;
	}
	
	public void setTutor(TutorDto tutor) {
		this.tutor = tutor;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public long getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
