package itc.gic.i4gic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
@RestController
public class I4GicApplication {

	public static void main(String[] args) {
		SpringApplication.run(I4GicApplication.class, args);
	}
	@GetMapping("/hello")
	public String hi(@RequestParam(name = "name", defaultValue = "Welcome!")String name) {
		return String.format("=>    Welcome to Gradle Project using Spring Boot %s!", name);
	}
	

}
