package ca.mcgill.ecse321.tutorolo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Set;
import javax.persistence.OneToMany;

@Entity
public class Student extends Profile{
private Integer id;
   
   public void setId(Integer value) {
this.id = value;
    }

public Integer getId() {
return this.id;
    }
private Set<Notification> sent;

@OneToMany(mappedBy="sender")
public Set<Notification> getSent() {
   return this.sent;
}

public void setSent(Set<Notification> sents) {
   this.sent = sents;
}

private Set<ScheduledCourse> scheduledCourse;

@OneToMany(mappedBy="student")
public Set<ScheduledCourse> getScheduledCourse() {
   return this.scheduledCourse;
}

public void setScheduledCourse(Set<ScheduledCourse> scheduledCourses) {
   this.scheduledCourse = scheduledCourses;
}

private Set<Review> reviewTutor;

@OneToMany(mappedBy="student")
public Set<Review> getReviewTutor() {
   return this.reviewTutor;
}

public void setReviewTutor(Set<Review> reviews) {
   this.reviewTutor = reviews;
}

}
