package integrador3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import integrador3.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
	
	@Query("SELECT e FROM Estudiante e ORDER BY e.apellido")
	public List<Estudiante> obtenerEstudiantesOrdenadosPorApellido();
	
	@Query("SELECT e FROM Estudiante e WHERE e.numLibretaUni = :lu")
	public Estudiante obtenerEstudiantePorNroLibreta(Long lu);
	
	@Query("SELECT e FROM Estudiante e WHERE e.genero = :genero")
	public List<Estudiante> obtenerEstudiantePorGenero(String genero);
		
	@Query("SELECT e FROM Estudiante e "
			+ "JOIN e.carreras ec ON (e.dni = ec.estudiante.dni) "
			+ "WHERE ec.carrera.id = :idCarrera "
			+ "AND e.ciudadResidencia = :ciudad")
	public List<Estudiante> obtenerEstudiantesDeCarreraPorCiudad(Long idCarrera, String ciudad);
	
	@Query("SELECT e FROM Estudiante e WHERE e.dni = :dni")
	public Optional<Estudiante> buscarPorDni(Long dni);
}
