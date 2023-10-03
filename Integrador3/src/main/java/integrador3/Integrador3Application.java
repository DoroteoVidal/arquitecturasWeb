package integrador3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import integrador3.utils.CargaDatos;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class Integrador3Application {
	
//	@Autowired
//	private CargaDatos datos;

	public static void main(String[] args) {
		SpringApplication.run(Integrador3Application.class, args);
	}
	
//	@PostConstruct
//	public void init() {
//		datos.cargar();
//	}

}
