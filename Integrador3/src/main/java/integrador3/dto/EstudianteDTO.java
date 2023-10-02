package integrador3.dto;

public class EstudianteDTO {
	private Long dni;
	private String nombre;
	private String apellido;
	private int edad;
	private String genero;
	private String ciudadResidencia;
	private Long numLibretaUni;
	
	public EstudianteDTO() {}
	
	public EstudianteDTO(Long dni, String nombre, String apellido, int edad, String genero, String ciudadResidencia,
			Long numLibretaUni) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.ciudadResidencia = ciudadResidencia;
		this.numLibretaUni = numLibretaUni;
	}

	public Long getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getEdad() {
		return edad;
	}

	public String getGenero() {
		return genero;
	}

	public String getCiudadResidencia() {
		return ciudadResidencia;
	}

	public Long getNumLibretaUni() {
		return numLibretaUni;
	}

	@Override
	public String toString() {
		return "EstudianteDTO [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+ ", genero=" + genero + ", ciudadResidencia=" + ciudadResidencia + ", numLibretaUni=" + numLibretaUni
				+ "]";
	}
	
}
