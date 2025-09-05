package co.edu.unbosque.model;

public class Belleza extends Producto {

	private String tipoProducto;
	private String fechaExpiracion;

	public Belleza() {
		// TODO Auto-generated constructor stub
	}

	public Belleza(String tipoProducto, String fechaExpiracion) {
		super();
		this.tipoProducto = tipoProducto;
		this.fechaExpiracion = fechaExpiracion;
	}

	public Belleza(float precio, String nombre, String descripcion, int unidades, String rutaFoto, String tipoProducto,
			String fechaExpiracion,int id) {
		super(precio, nombre, descripcion, unidades, rutaFoto, id);
		this.tipoProducto = tipoProducto;
		this.fechaExpiracion = fechaExpiracion;
	}

	public Belleza(float precio, String nombre, String descripcion, int unidades, String rutaFoto,int id) {
		super(precio, nombre, descripcion, unidades, rutaFoto,id);
		// TODO Auto-generated constructor stub
	}

	public String getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public String getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(String fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	@Override
	public String toString() {
		return "Belleza [tipoProducto=" + tipoProducto + ", fechaExpiracion=" + fechaExpiracion + "]";
	}
}
