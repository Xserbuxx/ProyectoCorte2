package co.edu.unbosque.model;

public class Juguetes extends Producto {

	private int edadRecomendada;
	private String material;

	public Juguetes() {
		// TODO Auto-generated constructor stub
	}

	public Juguetes(int edadRecomendada, String material) {
		super();
		this.edadRecomendada = edadRecomendada;
		this.material = material;
	}

	public Juguetes(float precio, String nombre, String descripcion, int unidades, String rutaFoto, int edadRecomendada,
			String material) {
		super(precio, nombre, descripcion, unidades, rutaFoto);
		this.edadRecomendada = edadRecomendada;
		this.material = material;
	}

	public Juguetes(float precio, String nombre, String descripcion, int unidades, String rutaFoto) {
		super(precio, nombre, descripcion, unidades, rutaFoto);
		// TODO Auto-generated constructor stub
	}

	public int getEdadRecomendada() {
		return edadRecomendada;
	}

	public void setEdadRecomendada(int edadRecomendada) {
		this.edadRecomendada = edadRecomendada;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "Juguetes [edadRecomendada=" + edadRecomendada + ", material=" + material + "]";
	}

}
