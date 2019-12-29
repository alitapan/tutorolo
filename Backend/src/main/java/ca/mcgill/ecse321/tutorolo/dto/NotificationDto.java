package ca.mcgill.ecse321.tutorolo.dto;

public class NotificationDto {
	private Integer id;
	private String text;
	private StudentDto sender;
	private TutorDto tutor;
	private CompanyManagerDto companyManager;
	
	public NotificationDto() {
	}
	
	public NotificationDto (Integer id) {
		this(id, "", null, null, null);
	}
	
	public NotificationDto(Integer id, String text, StudentDto student, TutorDto tutor, CompanyManagerDto companyManager) {
		this.id = id;
		this.text = text;
		this.sender = student;
		this.tutor = tutor;
		this.companyManager = companyManager;
	}
	
	public Integer getID() {
		return id;
	}

	public StudentDto getSender() {
		return sender;
	}

	public TutorDto getTutor() {
		return tutor;
	}

	public void setSender(StudentDto sender) {
		this.sender = sender;
	}

	public void setTutor(TutorDto tutor) {
		this.tutor = tutor;
	}

	public CompanyManagerDto getCompanyManager() {
		return companyManager;
	}
	
	public void setCompanyManager(CompanyManagerDto companyManager) {
		this.companyManager = companyManager;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
