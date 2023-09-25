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
		
		
		//2) Implementar consultas para:
		//a) dar de alta un estudiante
		
		//Estudiante e  = new Estudiante(44873623L, "Federico", "Ortega", 21, "Male", "Tandil", 1234354L);		
		//estudianteRepo.crear(e);
		
		//b) matricular un estudiante en una carrera
		
		//Carrera c = carreraRepo.obtenerPorId(1L);
		
		//EstudianteCarrera ec = new EstudianteCarrera(e, c, 2021L, 0L, 1);
		//estudianteCarreraRepo.crear(ec);
		
		//c) recuperar todos los estudiantes, y especificar algun criterio de ordenamiento simple.
		
		//List<EstudianteDTO> estudiantes = estudianteRepo.obtenerEstudiantesPorCriterio("nombre");		
		//estudiantes.forEach(est -> System.out.println(est));
		
		//d) recuperar un estudiante, en base a su numero de libreta universitaria.
		
		//System.out.println(estudianteRepo.obtenerEstudiantePorLibUni(1234354L));
		
		//e) recuperar todos los estudiantes, en base a su genero.
		
		//List<EstudianteDTO> estudiantes = estudianteRepo.obtenerEstudiantePorGenero("Female");
		//estudiantes.forEach(est -> System.out.println(est));
		
		//f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
		
		//List<CarreraDTO> carreras = carreraRepo.obtenerCarrerasConEstudiantesInscriptos();	
		//carreras.forEach(carrera -> System.out.println(carrera));
		
		//g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
		
		//List<EstudianteDTO> estudiantesCarre = estudianteRepo.obtenerEstudiantesDeCarreraPorCiudad(c, "Tandil");		
		//estudiantesCarre.forEach(es -> System.out.println(es));
		
		//3) Generar un reporte de las carreras, que para cada carrera incluya información de los
		//inscriptos y egresados por año. Se deben ordenar las carreras alfabeticamente, y presentar
		//los años de manera cronologica.
		
		List<ReporteDTO> reporte = carreraRepo.obtenerReporte();		
		reporte.forEach(re -> System.out.println(re));
	}

}
