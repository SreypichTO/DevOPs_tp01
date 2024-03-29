package itc.midterm.Gradle_jenkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
public class GradleJenkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradleJenkinApplication.class, args);
	}
	@GetMapping("/test")
	public String hi(@RequestParam(name = "name", defaultValue = "Welcome!")String name) {
		return String.format("=>    Welcome to Gradle Project using Spring Boot %s!", name);
	}

}
