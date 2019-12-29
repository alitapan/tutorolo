package ca.mcgill.ecse321.tutorolo.model;

import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;

@Entity
public class Course{
private String courseName;
   
   public void setCourseName(String value) {
this.courseName = value;
    }
@Id
public String getCourseName() {
return this.courseName;
    }
private String courseCode;

public void setCourseCode(String value) {
this.courseCode = value;
    }
@NotNull
@NotEmpty
public String getCourseCode() {
return this.courseCode;
    }
private CourseLevel courseLevel;

public void setCourseLevel(CourseLevel value) {
this.courseLevel = value;
    }
public CourseLevel getCourseLevel() {
return this.courseLevel;
    }
private Set<ScheduledCourse> scheduledCourse;

@OneToMany(mappedBy="course")
public Set<ScheduledCourse> getScheduledCourse() {
   return this.scheduledCourse;
}

public void setScheduledCourse(Set<ScheduledCourse> scheduledCourses) {
   this.scheduledCourse = scheduledCourses;
}

private Set<Tutor> tutor;

@ManyToMany
public Set<Tutor> getTutor() {
   return this.tutor;
}

public void setTutor(Set<Tutor> tutors) {
   this.tutor = tutors;
}

}
