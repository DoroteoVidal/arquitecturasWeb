package integrador3.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import integrador3.model.Estudiante;
import integrador3.repository.EstudianteRepository;

@Component
public class DataUpload {
	private final EstudianteRepository estudianteRepository;
	
	@Autowired
	public DataUpload(EstudianteRepository estudianteRepository) {
		this.estudianteRepository = estudianteRepository;
	}
	
	public void upload() {
		Estudiante e1 = new Estudiante(41402756L, "Doroteo", "Vidal", 24, "Male", "Tandil", 287913L);
		Estudiante e2 = new Estudiante(40287619L, "Fabian", "Crespo", 25, "Male", "Tandil", 329171L);
		Estudiante e3 = new Estudiante(41893710L, "Lucia", "Mendez", 24, "Female", "Rauch", 983710L);
		Estudiante e4 = new Estudiante(44987619L, "Maria", "Urquiza", 21, "Female", "Azul", 391720L);
		Estudiante e5 = new Estudiante(43018911L, "Manuel", "Fubel", 22, "Male", "Trenque Lauquen", 239817L);
		Estudiante e6 = new Estudiante(44913028L, "Federico", "Martinez", 21, "Male", "Tandil", 491830L);
		Estudiante e7 = new Estudiante(43871920L, "Agustina", "Ayala", 22, "Female", "Tandil", 127812L);
		
		estudianteRepository.save(e1);
		estudianteRepository.save(e2);
		estudianteRepository.save(e3);
		estudianteRepository.save(e4);
		estudianteRepository.save(e5);
		estudianteRepository.save(e6);
		estudianteRepository.save(e7);
	}
}
