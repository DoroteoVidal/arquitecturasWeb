package integrador3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import integrador3.model.Estudiante;
import integrador3.dto.EstudianteDTO;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
	
	@Query("SELECT e FROM Estudiante e ORDER BY e.apellido")
	public List<EstudianteDTO> obtenerEstudiantesOrdenadosPorApellido();
	
	@Query("SELECT e FROM Estudiante e WHERE e.numLibretaUni = :lu")
	public Optional<EstudianteDTO> obtenerEstudiantePorLibUni(Long lu);
	
	@Query("SELECT e FROM Estudiante e WHERE e.genero = :genero")
	public List<EstudianteDTO> obtenerEstudiantePorGenero(String genero);
	
	@Query("SELECT e FROM Estudiante e "
			+ "JOIN e.carreras ec ON (e.id = ec.estudiante.id) "
			+ "WHERE ec.carrera.id = :idCarrera "
			+ "AND e.ciudadResidencia = :ciudad")
	public List<EstudianteDTO> obtenerEstudiantesDeCarreraPorCiudad(Long idCarrera, String ciudad);
}
