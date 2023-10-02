package integrador3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import integrador3.model.Carrera;
import integrador3.dto.CarreraDTO;

public interface CarreraRepository extends JpaRepository<Carrera, Long> {
	
	@Query("SELECT c.nombre, COUNT(ec.estudiante) "
			+ "FROM Carrera c JOIN c.estudiantes ec ON (c.id = ec.carrera.id) "
			+ "GROUP BY c.nombre ORDER BY COUNT(ec.estudiante) ASC")
	public List<CarreraDTO> obtenerCarrerasConEstudiantesInscriptos();
}
