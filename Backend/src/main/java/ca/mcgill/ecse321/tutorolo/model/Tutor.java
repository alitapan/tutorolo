package ca.mcgill.ecse321.tutorolo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;

@Entity
public class Tutor extends Profile{
private Set<Review> reviewStudent;

@OneToMany(mappedBy="tutor")
public Set<Review> getReview() {
   return this.reviewStudent;
}

public void setReview(Set<Review> reviewStudents) {
   this.reviewStudent = reviewStudents;
}

private Integer id;
   
   public void setId(Integer value) {
this.id = value;
    }

@SequenceGenerator(name="")
@GeneratedValue()public Integer getId() {
return this.id;
    }
private Integer hourlyRate;

public void setHourlyRate(Integer value) {
this.hourlyRate = value;
    }
public Integer getHourlyRate() {
return this.hourlyRate;
    }
private Set<Availability> availability;

@OneToMany(mappedBy="tutor")
public Set<Availability> getAvailability() {
   return this.availability;
}

public void setAvailability(Set<Availability> availabilitys) {
   this.availability = availabilitys;
}

private Set<Notification> tutorRecieved;

@OneToMany(mappedBy="tutor")
public Set<Notification> getTutorRecieved() {
   return this.tutorRecieved;
}

public void setTutorRecieved(Set<Notification> tutorRecieveds) {
   this.tutorRecieved = tutorRecieveds;
}

private Set<ScheduledCourse> scheduledCourse;

@OneToMany(mappedBy="tutor")
public Set<ScheduledCourse> getScheduledCourse() {
   return this.scheduledCourse;
}

public void setScheduledCourse(Set<ScheduledCourse> scheduledCourses) {
   this.scheduledCourse = scheduledCourses;
}

private Set<Course> coursesOffered;

@ManyToMany(mappedBy="tutor")
public Set<Course> getCoursesOffered() {
   return this.coursesOffered;
}

public void setCoursesOffered(Set<Course> coursesOffereds) {
   this.coursesOffered = coursesOffereds;
}

public void appendCoursesOffered(Course course) {
	this.coursesOffered.add(course);
}

}
