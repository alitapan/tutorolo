package ca.mcgill.ecse321.tutorolo.model;

import javax.persistence.Entity;
import java.sql.Time;
import java.sql.Date;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ScheduledCourse{
private Time startTime;
   
   public void setStartTime(Time value) {
this.startTime = value;
    }
public Time getStartTime() {
return this.startTime;
    }
private Time endTime;

public void setEndTime(Time value) {
this.endTime = value;
    }
public Time getEndTime() {
return this.endTime;
    }
private Date date;

public void setDate(Date value) {
this.date = value;
    }
public Date getDate() {
return this.date;
    }
private Integer id;

public void setId(Integer value) {
this.id = value;
    }
@Id
public Integer getId() {
return this.id;
    }
private Course course;

@ManyToOne(optional=false)
public Course getCourse() {
   return this.course;
}

public void setCourse(Course course) {
   this.course = course;
}

private Tutor tutor;

@ManyToOne(optional=false)
public Tutor getTutor() {
   return this.tutor;
}

public void setTutor(Tutor tutor) {
   this.tutor = tutor;
}

private Student student;

@ManyToOne(optional=false)
public Student getStudent() {
   return this.student;
}

public void setStudent(Student student) {
   this.student = student;
}

private Integer roomNumber;

public void setRoomNumber(Integer value) {
this.roomNumber = value;
    }
public Integer getRoomNumber() {
return this.roomNumber;
       }
   }
