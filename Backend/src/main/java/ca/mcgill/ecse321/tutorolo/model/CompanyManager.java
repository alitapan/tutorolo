package ca.mcgill.ecse321.tutorolo.model;

import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class CompanyManager extends Profile{
private Set<Notification> companyManagerReceived;

@OneToMany(mappedBy="companyManager")
public Set<Notification> getCompanyManagerReceived() {
   return this.companyManagerReceived;
}

public void setCompanyManagerReceived(Set<Notification> companyManagerReceiveds) {
   this.companyManagerReceived = companyManagerReceiveds;
}

private Integer id;

public void setId(Integer value) {
this.id = value;
    }

@GeneratedValue()public Integer getId() {
return this.id;
       }
   }
