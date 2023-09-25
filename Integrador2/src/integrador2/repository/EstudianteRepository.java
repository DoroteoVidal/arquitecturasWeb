package integrador2.repository;

import java.util.List;

import integrador2.dto.EstudianteDTO;
import integrador2.entidades.Carrera;
import integrador2.entidades.Estudiante;

public interface EstudianteRepository extends Repository<Estudiante> {
	
	public List<EstudianteDTO> obtenerEstudiantesDeCarreraPorCiudad(Carrera c, String ciudad);
	
	public List<EstudianteDTO> obtenerEstudiantesOrdenadosPorCriterio();
	
	public List<EstudianteDTO> obtenerEstudiantePorGenero(String genero);
	
	public EstudianteDTO obtenerEstudiantePorLibUni(Long libreta);
	
	
}
