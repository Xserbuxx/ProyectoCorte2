package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Musica;

public class MusicaDAO implements DAO<Musica> {

	private ArrayList<Musica> lista;

	public MusicaDAO() {
		lista = new ArrayList<>();
		LeerArchivoTexto("Musica.csv");
	}

	@Override
	public void crear(Musica nuevoDato) {
		lista.add(nuevoDato);
		escribirEnArchivoTexto();
	}

	@Override
	public boolean actualizar(int indice, Musica actualizarDato) {
		if (indice < 0 || indice >= lista.size()) {
			return false;
		} else {
			lista.set(indice, actualizarDato);
			escribirEnArchivoTexto();
			return true;
		}
	}

	@Override
	public boolean eliminar(int indice) {
		if (indice < 0 || indice >= lista.size()) {
			return false;
		} else {
			lista.remove(indice);
			escribirEnArchivoTexto();
			return true;
		}
	}

	private String contenido;
	private int n;
	
	@Override
	public String mostrarDatos() {
		contenido = "";
		n = 0;

		lista.forEach((objeto) -> {
			contenido += "\n" + n + ". " + objeto.toString();
			n++;
		});

		return contenido;
	}

	@Override
	public int contar() {
		return lista.size();
	}
	
	public void LeerArchivoTexto(String url) {
		String contenido;
		contenido = FileHandler.leerArchivoTexto(url);
		String[] filas = contenido.split("\n");
		
		for (int i = 0; i < filas.length; i++) {
			if(contenido == "" || contenido.isBlank()) {
				break;
			}
			String[] columnas = filas[i].split(";");
			Musica temp = new Musica();
			temp.setPrecio(Float.parseFloat(columnas[0]));
			temp.setNombre(columnas[1]);
			temp.setDescripcion(columnas[2]);
			temp.setUnidades(Integer.parseInt(columnas[3]));
			temp.setRutaFoto(columnas[4]);
			temp.setId(Integer.parseInt(columnas[5]));
			temp.setFormato(columnas[6]);
			temp.setArtista(columnas[7]);

			lista.add(temp);
		}
	}
	
	public void escribirEnArchivoTexto() {
		contenido = "";

		lista.forEach((musica) -> {
			contenido += musica.getPrecio()+";"
						+musica.getNombre()+";"
						+musica.getDescripcion()+";"
						+musica.getUnidades()+";"
						+musica.getRutaFoto()+";"
						+musica.getId()+";"
						+musica.getFormato()+";"
						+musica.getArtista()+"\n";
		});
		
		FileHandler.escribirEnArchivoTexto("Musica.csv", contenido);
	}

	public ArrayList<Musica> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Musica> lista) {
		this.lista = lista;
	}
	
}
