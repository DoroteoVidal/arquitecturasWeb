package integrador3.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Carrera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column
	private int duracion;
	
	@OneToMany(mappedBy = "carrera", fetch = FetchType.LAZY)
	private List<Inscripcion> estudiantes;

	public Carrera() {}

	public Carrera(String nombre, int duracion) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.estudiantes = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public List<Inscripcion> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Inscripcion> estudiantes) {
		this.estudiantes = estudiantes;
	}

	@Override
	public String toString() {
		return "Carrera [id=" + id + ", nombre=" + nombre + ", duracion=" + duracion + "]";
	}

}
