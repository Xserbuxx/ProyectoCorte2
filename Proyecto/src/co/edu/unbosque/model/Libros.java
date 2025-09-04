package co.edu.unbosque.model;

public class Libros extends Producto {

	private String autor;
	private int numeroPaginas;

	public Libros() {
		// TODO Auto-generated constructor stub
	}

	public Libros(String autor, int numeroPaginas) {
		super();
		this.autor = autor;
		this.numeroPaginas = numeroPaginas;
	}

	public Libros(float precio, String nombre, String descripcion, int unidades, String rutaFoto, String autor,
			int numeroPaginas) {
		super(precio, nombre, descripcion, unidades, rutaFoto);
		this.autor = autor;
		this.numeroPaginas = numeroPaginas;
	}

	public Libros(float precio, String nombre, String descripcion, int unidades, String rutaFoto) {
		super(precio, nombre, descripcion, unidades, rutaFoto);
		// TODO Auto-generated constructor stub
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	@Override
	public String toString() {
		return "Libros [autor=" + autor + ", numeroPaginas=" + numeroPaginas + "]";
	}

}
