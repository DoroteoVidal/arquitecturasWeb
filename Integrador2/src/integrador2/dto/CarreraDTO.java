package integrador2.dto;

import java.math.BigInteger;

public class CarreraDTO {
	private String nombre;
	private BigInteger cantidad;
	
	public CarreraDTO() {}
	
	public CarreraDTO(String nombre, BigInteger cantidad) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	public String getNombre() {
		return nombre;
	}
	
	public BigInteger getCantidad() {
		return cantidad;
	}

	@Override
	public String toString() {
		return "CarreraDTO [nombre=" + nombre + ", cantidad=" + cantidad + "]";
	}
	
}
