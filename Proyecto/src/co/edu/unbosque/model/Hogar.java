package co.edu.unbosque.model;

public class Hogar extends Producto {
	
	//arreglar mayuscula
	private String Material;
	private String dimensiones;

	public Hogar() {
		// TODO Auto-generated constructor stub
	}

	public Hogar(String material, String dimensiones) {
		super();
		Material = material;
		this.dimensiones = dimensiones;
	}

	public Hogar(float precio, String nombre, String descripcion, int unidades, String rutaFoto, String material,
			String dimensiones,int id) {
		super(precio, nombre, descripcion, unidades, rutaFoto,id);
		Material = material;
		this.dimensiones = dimensiones;
	}

	public Hogar(float precio, String nombre, String descripcion, int unidades, String rutaFoto,int id) {
		super(precio, nombre, descripcion, unidades, rutaFoto,id);
		// TODO Auto-generated constructor stub
	}

	public String getMaterial() {
		return Material;
	}

	public void setMaterial(String material) {
		Material = material;
	}

	public String getDimensiones() {
		return dimensiones;
	}

	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
	}

	@Override
	public String toString() {
		return "Hogar [Material=" + Material + ", dimensiones=" + dimensiones + "]";
	}

}
