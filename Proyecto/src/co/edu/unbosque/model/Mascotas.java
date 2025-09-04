package co.edu.unbosque.model;

public class Mascotas extends Producto {

	private String tipoAnimal;
	private String tamaño;

	public Mascotas() {
		// TODO Auto-generated constructor stub
	}

	public Mascotas(String tipoAnimal, String tamaño) {
		super();
		this.tipoAnimal = tipoAnimal;
		this.tamaño = tamaño;
	}

	public Mascotas(float precio, String nombre, String descripcion, int unidades, String rutaFoto, String tipoAnimal,
			String tamaño) {
		super(precio, nombre, descripcion, unidades, rutaFoto);
		this.tipoAnimal = tipoAnimal;
		this.tamaño = tamaño;
	}

	public Mascotas(float precio, String nombre, String descripcion, int unidades, String rutaFoto) {
		super(precio, nombre, descripcion, unidades, rutaFoto);
		// TODO Auto-generated constructor stub
	}

	public String getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(String tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	public String getTamaño() {
		return tamaño;
	}

	public void setTamaño(String tamaño) {
		this.tamaño = tamaño;
	}

	@Override
	public String toString() {
		return "Mascotas [tipoAnimal=" + tipoAnimal + ", tamaño=" + tamaño + "]";
	}

}
