package integrador2.main;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import integrador2.csv.CSVReader;
import integrador2.dto.CarreraDTO;
import integrador2.dto.EstudianteDTO;
import integrador2.dto.ReporteDTO;
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
		
		/*Carrera c = carreraRepo.obtenerPorId(1L);
		
		Estudiante e1 = new Estudiante(41402756L, "Doroteo", "Vidal", 24, "Male", "Tandil", 2705293L);
		Estudiante e2 = new Estudiante(42048312L, "Helvio", "Vidal", 28, "Male", "Puerto Deseado", 2398763L);
		
		estudianteRepo.crear(e1);
		
		estudianteRepo.crear(e2);
		
		EstudianteCarrera ec1 = new EstudianteCarrera(e1, c, 2021L, 2023L, 2);
		EstudianteCarrera ec2 = new EstudianteCarrera(e2, c, 2021L, 0L, 2);
		
		estudianteCarreraRepo.crear(ec1);
		estudianteCarreraRepo.crear(ec2);
		*/
		List<ReporteDTO> lista = carreraRepo.obtenerReporte();
		
		lista.forEach(r -> System.out.println(r));
	}

}
