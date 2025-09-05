package co.edu.unbosque.model;

public class Tecnologia extends Producto {

	private String marca;
	private String modelo;

	public Tecnologia() {
		// TODO Auto-generated constructor stub
	}

	public Tecnologia(String marca, String modelo) {
		super();
		this.marca = marca;
		this.modelo = modelo;
	}

	public Tecnologia(float precio, String nombre, String descripcion, int unidades, String rutaFoto, String marca,
			String modelo,int id) {
		super(precio, nombre, descripcion, unidades, rutaFoto,id);
		this.marca = marca;
		this.modelo = modelo;
	}

	public Tecnologia(float precio, String nombre, String descripcion, int unidades, String rutaFoto,int id) {
		super(precio, nombre, descripcion, unidades, rutaFoto,id);
		// TODO Auto-generated constructor stub
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return super.toString()+"Tecnologia [marca=" + marca + ", modelo=" + modelo + "]";
	}

}
