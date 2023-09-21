package integrador2.dto;

import java.math.BigInteger;

public class ReporteDTO {
	private String carrera;
	private BigInteger anio;
	private BigInteger inscriptos;
	private BigInteger graduados;
	
	public ReporteDTO() {}

	public ReporteDTO(String carrera, BigInteger anio, BigInteger inscriptos, BigInteger graduados) {
		super();
		this.carrera = carrera;
		this.anio = anio;
		this.inscriptos = inscriptos;
		this.graduados = graduados;
	}

	public String getCarrera() {
		return carrera;
	}

	public BigInteger getAnio() {
		return anio;
	}

	public BigInteger getInscriptos() {
		return inscriptos;
	}

	public BigInteger getGraduados() {
		return graduados;
	}

	@Override
	public String toString() {
		return "ReporteDTO [carrera=" + carrera + ", anio=" + anio + ", inscriptos=" + inscriptos + ", graduados="
				+ graduados + "]";
	}
}
