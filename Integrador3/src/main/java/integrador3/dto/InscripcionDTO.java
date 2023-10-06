package integrador3.dto;

public class InscripcionDTO {
	private Long dniEstudiante;
	private Long idCarrera;
	private Long fechaInscripcion;
	private Long fechaGraduacion;
	private int antiguedad;
	
	public InscripcionDTO() {}
	
	public InscripcionDTO(Long dniEstudiante, Long idCarrera, Long fechaInscripcion, Long fechaGraduacion,
			int antiguedad) {
		super();
		this.dniEstudiante = dniEstudiante;
		this.idCarrera = idCarrera;
		this.fechaInscripcion = fechaInscripcion;
		this.fechaGraduacion = fechaGraduacion;
		this.antiguedad = antiguedad;
	}

	public Long getDniEstudiante() {
		return dniEstudiante;
	}

	public Long getIdCarrera() {
		return idCarrera;
	}

	public Long getFechaInscripcion() {
		return fechaInscripcion;
	}

	public Long getFechaGraduacion() {
		return fechaGraduacion;
	}

	public int getAntiguedad() {
		return antiguedad;
	}
	
}
