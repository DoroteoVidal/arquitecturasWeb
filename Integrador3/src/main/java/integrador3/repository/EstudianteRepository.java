package integrador3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import integrador3.model.Estudiante;
import integrador3.dto.EstudianteDTO;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
	
	@Query("SELECT e FROM Estudiante e WHERE e.apellido = :apellido")
	public List<EstudianteDTO> findAllBySurname(String apellido);
	
	@Query("SELECT e FROM Estudiante e WHERE e.numLibretaUni = :lu")
	public Optional<EstudianteDTO> findByNumLibreta(Long lu);
	
	@Query("SELECT e FROM Estudiante e WHERE e.genero = :genero")
	public List<EstudianteDTO> findAllByGenero(String genero);
}
