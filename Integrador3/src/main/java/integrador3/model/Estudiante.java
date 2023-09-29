package integrador3.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Estudiante {
	
	@Id
	private Long dni;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private String apellido;
	
	@Column
	private int edad;
	
	@Column
	private String genero;
	
	@Column(name = "ciudad_residencia")
	private String ciudadResidencia;
	
	@Column(name = "num_libreta_uni")
	private Long numLibretaUni;
	
	@OneToMany(mappedBy = "estudiante", fetch = FetchType.LAZY)
	private List<Inscripcion> carreras;
	
	public Estudiante() {}

	public Estudiante(Long dni, String nombre, String apellido, int edad, String genero, String ciudadResidencia, Long numLibretaUni) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.ciudadResidencia = ciudadResidencia;
		this.numLibretaUni = numLibretaUni;
		this.carreras = new ArrayList<>();
	}
	
	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCiudadResidencia() {
		return ciudadResidencia;
	}

	public void setCiudadResidencia(String ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
	}

	public Long getNumLibretaUni() {
		return numLibretaUni;
	}

	public void setNumLibretaUni(Long numLibretaUni) {
		this.numLibretaUni = numLibretaUni;
	}

	public List<Inscripcion> getInscriptas() {
		return carreras;
	}

	public void setInscriptas(List<Inscripcion> carreras) {
		this.carreras = carreras;
	}

	@Override
	public String toString() {
		return "Estudiante [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+ ", genero=" + genero + ", ciudadResidencia=" + ciudadResidencia + ", numLibretaUni=" + numLibretaUni
				+ "]";
	}

}
