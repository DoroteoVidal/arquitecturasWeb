package integrador3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import integrador3.utils.DataUpload;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class Integrador3Application {
	
	@Autowired
	private DataUpload dataUpload;

	public static void main(String[] args) {
		SpringApplication.run(Integrador3Application.class, args);
	}
	
	@PostConstruct
	public void init() {
		dataUpload.upload();
	}

}
