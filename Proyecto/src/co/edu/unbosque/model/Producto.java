package co.edu.unbosque.model;

public class Producto {
	private float precio;
	private String nombre;
	private String descripcion;
	private int unidades;
	private String rutaFoto;
	private int id;

	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(float precio, String nombre, String descripcion, int unidades, String rutaFoto,int id) {
		super();
		this.precio = precio;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.unidades = unidades;
		this.rutaFoto = rutaFoto;
		this.id = id;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public String getRutaFoto() {
		return rutaFoto;
	}

	public void setRutaFoto(String rutaFoto) {
		this.rutaFoto = rutaFoto;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Producto [precio=" + precio + ", nombre=" + nombre + ", descripcion=" + descripcion + ", unidades="
				+ unidades + "]";
	}
}
