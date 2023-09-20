package integrador2.comparadores;

import java.util.Comparator;

import integrador2.dto.EstudianteDTO;

public class ComparadorApellido implements Comparator<EstudianteDTO>{

	@Override
	public int compare(EstudianteDTO e1, EstudianteDTO e2) {
		return e1.getApellido().compareTo(e2.getApellido());
	}
	
}
