package integrador2.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EstudianteCarrera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "fk_estudiante")
	private Estudiante estudiante;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "fk_carrera")
	private Carrera carrera;
	
	@Column(name = "fecha_inscripcion")
	private Long fechaInscripcion;
	
	@Column(name = "fecha_graduacion")
	private Long fechaGraduacion;
	
	@Column
	private int antiguedad;
	
	public EstudianteCarrera() {}

	public EstudianteCarrera(Estudiante estudiante, Carrera carrera, Long fechaInscripcion, Long fechaGraduacion, int antiguedad) {
		super();
		this.estudiante = estudiante;
		this.carrera = carrera;
		this.fechaInscripcion = fechaInscripcion;
		this.fechaGraduacion = fechaGraduacion;
		this.antiguedad = antiguedad;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Long getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(Long fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public Long getFechaGraduacion() {
		return fechaGraduacion;
	}

	public void setFechaGraduacion(Long fechaGraduacion) {
		this.fechaGraduacion = fechaGraduacion;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	@Override
	public String toString() {
		return "EstudianteCarrera [estudiante=" + estudiante + ", carrera=" + carrera + ", fechaInscripcion="
				+ fechaInscripcion + ", fechaGraduacion=" + fechaGraduacion + ", antiguedad=" + antiguedad + "]";
	}

}
