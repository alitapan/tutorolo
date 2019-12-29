package ca.mcgill.ecse321.tutorolo.dto;

import java.sql.Date;
import java.sql.Time;

public class AvailabilityDto {
	private Date availableDate;
	private Time startTime;
	private Time endTime;
	private Integer id;
	private TutorDto tutor;
	
	public AvailabilityDto() {
		
	}
	
	public AvailabilityDto(Integer id) {
		this(id, null, null, null, null);
	}
	
	public AvailabilityDto(Integer id, Date availableDate, Time startTime, Time endTime, TutorDto tutor)
	{
		this.availableDate = availableDate;
		this.endTime = endTime;
		this.startTime = startTime;
		this.id = id;
		this.tutor = tutor;
	}
	
	public TutorDto getTutor() {
		return this.tutor;
	}
	
	public void setTutorDto(TutorDto tutor) {
		this.tutor = tutor;
	}
	
	public Date getAvailableDate() {
		return availableDate;
	}
	
	public void setAvailableDate(Date availableDate) {
		this.availableDate = availableDate;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Time getStartTime() {
		return startTime;
	}
	
	public Time getEndTime() {
		return endTime;
	}
	
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
}


