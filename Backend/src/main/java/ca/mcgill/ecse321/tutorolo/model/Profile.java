package ca.mcgill.ecse321.tutorolo.model;

import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@SuppressWarnings("deprecation")
public class Profile{
private String email;
   
   public void setEmail(String value) {
this.email = value;
    }
@Id
public String getEmail() {
return this.email;
    }
private String password;

public void setPassword(String value) {
this.password = value;
    }
@NotEmpty
public String getPassword() {
return this.password;
    }
private String name;

public void setName(String value) {
this.name = value;
    }
public String getName() {
return this.name;
       }
   }
