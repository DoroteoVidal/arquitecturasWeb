package integrador3.dto;

public class CarreraDTO {
	private String nombre;
	private int cantidad;
	
	public CarreraDTO() {}

	public CarreraDTO(String nombre, int cantidad) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	@Override
	public String toString() {
		return "CarreraDTO [nombre=" + nombre + ", cantidad=" + cantidad + "]";
	}
	
}
