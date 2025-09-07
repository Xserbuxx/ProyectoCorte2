package co.edu.unbosque.model;

public class Musica extends Producto {

	private String formato;
	private String artista;

	public Musica() {
		// TODO Auto-generated constructor stub
	}

	public Musica(String formato, String artista) {
		super();
		this.formato = formato;
		this.artista = artista;
	}

	public Musica(float precio, String nombre, String descripcion, int unidades, String rutaFoto, String formato,
			String artista,int id) {
		super(precio, nombre, descripcion, unidades, rutaFoto,id);
		this.formato = formato;
		this.artista = artista;
	}

	public Musica(float precio, String nombre, String descripcion, int unidades, String rutaFoto,int id) {
		super(precio, nombre, descripcion, unidades, rutaFoto,id);
		// TODO Auto-generated constructor stub
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	@Override
	public String toString() {
		return super.toString()+formato+";"+artista;
	}

}
