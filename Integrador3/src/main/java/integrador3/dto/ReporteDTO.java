package integrador3.dto;

public class ReporteDTO {
	private String carrera;
	private Long anio;
	private Long inscriptos;
	private Long graduados;
	
	public ReporteDTO() {}

	public ReporteDTO(String carrera, Long anio, Long inscriptos, Long graduados) {
		super();
		this.carrera = carrera;
		this.anio = anio;
		this.inscriptos = inscriptos;
		this.graduados = graduados;
	}

	public String getCarrera() {
		return carrera;
	}

	public Long getAnio() {
		return anio;
	}

	public Long getInscriptos() {
		return inscriptos;
	}

	public Long getGraduados() {
		return graduados;
	}

	@Override
	public String toString() {
		return "ReporteDTO [carrera=" + carrera + ", anio=" + anio + ", inscriptos=" + inscriptos + ", graduados="
				+ graduados + "]";
	}
}
