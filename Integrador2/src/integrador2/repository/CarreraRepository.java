package integrador2.repository;

import java.util.List;

import integrador2.dto.CarreraDTO;
import integrador2.dto.ReporteDTO;
import integrador2.entidades.Carrera;

public interface CarreraRepository extends Repository<Carrera> {
	
	public List<ReporteDTO> obtenerReporte();
	
	public List<CarreraDTO> obtenerCarrerasConEstudiantesInscriptos();

	public void crearCarrera(Carrera c);
	
}
