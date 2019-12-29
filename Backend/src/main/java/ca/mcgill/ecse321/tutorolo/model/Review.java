package ca.mcgill.ecse321.tutorolo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review{
private Integer id;
   
   public void setId(Integer value) {
this.id = value;
    }
@Id
public Integer getId() {
return this.id;
    }
private Integer rating;

public void setRating(Integer value) {
this.rating = value;
    }
public Integer getRating() {
return this.rating;
    }
private String comment;

public void setComment(String value) {
this.comment = value;
    }
public String getComment() {
return this.comment;
    }
private Student student;

@ManyToOne
public Student getStudent() {
   return this.student;
}

public void setStudent(Student student) {
   this.student = student;
}

private Tutor tutor;

@ManyToOne
public Tutor getTutor() {
   return this.tutor;
}

public void setTutor(Tutor tutor) {
   this.tutor = tutor;
}

}
