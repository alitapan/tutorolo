package ca.mcgill.ecse321.tutorolo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;

@Entity
public class Notification{
private Integer id;
   
   public void setId(Integer value) {
this.id = value;
    }
@Id
@SequenceGenerator(name="")
@GeneratedValue()public Integer getId() {
return this.id;
    }
private String text;

public void setText(String value) {
this.text = value;
    }
public String getText() {
return this.text;
    }
private Student sender;

@ManyToOne(optional=false)
public Student getSender() {
   return this.sender;
}

public void setSender(Student sender) {
   this.sender = sender;
}

private Tutor tutor;

@ManyToOne
public Tutor getTutor() {
   return this.tutor;
}

public void setTutor(Tutor tutor) {
   this.tutor = tutor;
}

private CompanyManager companyManager;

@ManyToOne
public CompanyManager getCompanyManager() {
   return this.companyManager;
}

public void setCompanyManager(CompanyManager companyManager) {
   this.companyManager = companyManager;
}

}
