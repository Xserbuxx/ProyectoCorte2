package co.edu.unbosque.model;

public class Vehiculos extends Producto {

	private String Año;
	private String modelo;

	public Vehiculos() {
		// TODO Auto-generated constructor stub
	}

	public Vehiculos(String año, String modelo) {
		super();
		Año = año;
		this.modelo = modelo;
	}

	public Vehiculos(float precio, String nombre, String descripcion, int unidades, String rutaFoto, String año,
			String modelo) {
		super(precio, nombre, descripcion, unidades, rutaFoto);
		Año = año;
		this.modelo = modelo;
	}

	public Vehiculos(float precio, String nombre, String descripcion, int unidades, String rutaFoto) {
		super(precio, nombre, descripcion, unidades, rutaFoto);
		// TODO Auto-generated constructor stub
	}

	public String getAño() {
		return Año;
	}

	public void setAño(String año) {
		Año = año;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Vehiculos [Año=" + Año + ", modelo=" + modelo + "]";
	}

}
