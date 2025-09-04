package co.edu.unbosque.model;

public class Deportes extends Producto {

	private String tipoDeporte;
	private String material;

	public Deportes() {
		// TODO Auto-generated constructor stub
	}

	public Deportes(String tipoDeporte, String material) {
		super();
		this.tipoDeporte = tipoDeporte;
		this.material = material;
	}

	public Deportes(float precio, String nombre, String descripcion, int unidades, String rutaFoto, String tipoDeporte,
			String material) {
		super(precio, nombre, descripcion, unidades, rutaFoto);
		this.tipoDeporte = tipoDeporte;
		this.material = material;
	}

	public Deportes(float precio, String nombre, String descripcion, int unidades, String rutaFoto) {
		super(precio, nombre, descripcion, unidades, rutaFoto);
		// TODO Auto-generated constructor stub
	}

	public String getTipoDeporte() {
		return tipoDeporte;
	}

	public void setTipoDeporte(String tipoDeporte) {
		this.tipoDeporte = tipoDeporte;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "Deportes [tipoDeporte=" + tipoDeporte + ", material=" + material + "]";
	}

}
