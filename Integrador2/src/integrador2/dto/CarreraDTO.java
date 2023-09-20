package integrador2.dto;

public class CarreraDTO {
	private Long id;
	private String nombre;
	private int duracion;
	
	public CarreraDTO() {}
	
	public CarreraDTO(Long id, String nombre, int duracion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.duracion = duracion;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}
	
	public int getDuracion() {
		return duracion;
	}

	@Override
	public String toString() {
		return "CarreraDTO [id=" + id + ", nombre=" + nombre + ", duracion=" + duracion + "]";
	}
	
}
