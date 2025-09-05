package co.edu.unbosque.model;

public class Ropa extends Producto {

	private String talla;
	private String color;

	public Ropa() {
		// TODO Auto-generated constructor stub
	}

	public Ropa(String talla, String color) {
		super();
		this.talla = talla;
		this.color = color;
	}

	public Ropa(float precio, String nombre, String descripcion, int unidades, String rutaFoto, String talla,
			String color,int id) {
		super(precio, nombre, descripcion, unidades, rutaFoto,id);
		this.talla = talla;
		this.color = color;
	}

	public Ropa(float precio, String nombre, String descripcion, int unidades, String rutaFoto,int id) {
		super(precio, nombre, descripcion, unidades, rutaFoto,id);
		// TODO Auto-generated constructor stub
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Ropa [talla=" + talla + ", color=" + color + "]";
	}

}
