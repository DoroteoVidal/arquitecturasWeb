package integrador3.dto;

public class CarreraDTO {
	private String nombre;
	private Long cantidad;
	
	public CarreraDTO() {}

	public CarreraDTO(String nombre, Long cantidad) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public Long getCantidad() {
		return cantidad;
	}

	@Override
	public String toString() {
		return "CarreraDTO [nombre=" + nombre + ", cantidad=" + cantidad + "]";
	}
	
}
