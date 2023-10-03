package integrador3.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import integrador3.model.Carrera;
import integrador3.model.Estudiante;
import integrador3.model.Inscripcion;
import integrador3.repository.CarreraRepository;
import integrador3.repository.EstudianteRepository;
import integrador3.repository.InscripcionRepository;

@Component
public class CargaDatos {
	private final EstudianteRepository estudianteRepository;
	private final CarreraRepository carreraRepository;
	private final InscripcionRepository inscripcionRepository;
	
	@Autowired
	public CargaDatos(EstudianteRepository estudianteRepository, CarreraRepository carreraRepository, InscripcionRepository inscripcionRepository) {
		this.estudianteRepository = estudianteRepository;
		this.carreraRepository = carreraRepository;
		this.inscripcionRepository = inscripcionRepository;
	}
	
	public void cargar() {
		
		Estudiante e1 = new Estudiante(41402756L, "Juan", "Perez", 24, "Male", "Pehuajo", 287913L);
		Estudiante e2 = new Estudiante(40287619L, "Pedro", "Garcia", 25, "Male", "Tandil", 329171L);
		Estudiante e3 = new Estudiante(41893710L, "Maria", "Gomez", 24, "Female", "Rauch", 983710L);
		Estudiante e4 = new Estudiante(44987619L, "Violeta", "Alanis", 21, "Female", "Azul", 391720L);
		
		estudianteRepository.save(e1);
		estudianteRepository.save(e2);
		estudianteRepository.save(e3);
		estudianteRepository.save(e4);
		
		
		Carrera c1 = new Carrera("Tudai", 3);
        Carrera c2 = new Carrera("Ingenieria", 5);
        Carrera c3 = new Carrera("Matematicas", 3);
        
        carreraRepository.save(c1);
        carreraRepository.save(c2);
        carreraRepository.save(c3);
        
        Inscripcion i1 = new Inscripcion(e1, c1, 2020L, 0L, 3);
        Inscripcion i2 = new Inscripcion(e2, c1, 2020L, 2023L, 1);
        Inscripcion i3 = new Inscripcion(e3, c2, 2019L, 0L, 4);
        Inscripcion i4 = new Inscripcion(e4, c2, 2019L, 2020L, 2);
        Inscripcion i5 = new Inscripcion(e1, c2, 2021L, 2023L, 2);
        
        inscripcionRepository.save(i1);
        inscripcionRepository.save(i2);
        inscripcionRepository.save(i3);
        inscripcionRepository.save(i4);
        inscripcionRepository.save(i5);
	}
}
