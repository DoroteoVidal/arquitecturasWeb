package integrador3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import integrador3.model.Carrera;

public interface CarreraRepository extends JpaRepository<Carrera, Long> {
	
	@Query("SELECT c.nombre, COUNT(ec.estudiante) "
			+ "FROM Carrera c JOIN c.estudiantes ec ON (c.id = ec.carrera.id) "
			+ "GROUP BY c.nombre ORDER BY COUNT(ec.estudiante) DESC")
	public List<Object[]> obtenerCarrerasConEstudiantesInscriptos();
	
	@Query(value = "SELECT nombre, fecha_inscripcion, COUNT(fecha_inscripcion) as inscriptos, 0 as graduados "
			+ "FROM carrera c JOIN inscripcion ec ON (c.id = ec.fk_carrera) "
			+ "GROUP BY nombre, fecha_inscripcion "
			+ "UNION "
			+ "SELECT nombre, fecha_graduacion, 0 as inscriptos, COUNT(fecha_graduacion) as graduados "
			+ "FROM carrera c JOIN inscripcion ec ON (c.id = ec.fk_carrera) "
			+ "GROUP BY nombre, fecha_graduacion "
			+ "HAVING fecha_graduacion != 0 "
			+ "ORDER BY nombre, fecha_inscripcion ASC", nativeQuery = true)
	public List<Object[]> obtenerReportes();
	
	@Query("SELECT c FROM Carrera c WHERE c.id = :id")
	public Optional<Carrera> buscarPorId(Long id);
	
}
