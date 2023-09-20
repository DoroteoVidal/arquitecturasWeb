package integrador2.main;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import integrador2.csv.CSVReader;
import integrador2.dto.CarreraDTO;
import integrador2.dto.EstudianteDTO;
import integrador2.entidades.Carrera;
import integrador2.entidades.Estudiante;
import integrador2.entidades.EstudianteCarrera;
import integrador2.factory.*;
import integrador2.repository.*;

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Integrador2");
		
		RepositoryFactoryImpl rfi = RepositoryFactoryImpl.getInstance();
		
		EstudianteRepository estudianteRepo = rfi.getEstudianteRepository(emf);
		
		CarreraRepository carreraRepo = rfi.getCarreraRepository(emf);
		
		EstudianteCarreraRepository estudianteCarreraRepo = rfi.getEstudianteCarreraRepository(emf);
		
		CSVReader csv = CSVReader.getInstance();
		
		
		//csv.insertar("resources/estudiantes.csv", estudianteRepo);
		
		//csv.insertar("resources/carreras.csv", carreraRepo);
		
		//csv.insertar("resources/estudianteCarrera.csv", estudianteCarreraRepo);
		
		List<EstudianteDTO> lista = estudianteRepo.obtenerEstudiantePorGenero("Male");
		lista.forEach(p -> System.out.println(p));
	}

}
