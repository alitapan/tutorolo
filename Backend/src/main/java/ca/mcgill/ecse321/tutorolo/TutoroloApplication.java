package ca.mcgill.ecse321.tutorolo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@SpringBootApplication
public class TutoroloApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutoroloApplication.class, args);
	}

	@RequestMapping("/")
  	public String greeting() {
    	return "Welcome to Tutorolo: A tutoring service!";
  	}

}
