package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Usuario;

public class UsuariosDAO implements DAO<Usuario> {

	private ArrayList<Usuario> lista;

	public UsuariosDAO() {
		lista = new ArrayList<>();
		LeerArchivoTexto("Usuarios.csv");
	}

	@Override
	public void crear(Usuario nuevoDato) {
		lista.add(nuevoDato);
		actualizarlist();
	}

	@Override
	public boolean actualizar(int indice, Usuario actualizarDato) {
		if (indice < 0 || indice >= lista.size()) {
			return false;
		} else {
			lista.set(indice, actualizarDato);
			return true;
		}
	}

	@Override
	public boolean eliminar(int indice) {
		if (indice < 0 || indice >= lista.size()) {
			return false;
		} else {
			lista.remove(indice);
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
			Usuario temp = new Usuario();
			temp.setNickname(columnas[0]);
			temp.setContraseña(columnas[1]);

			lista.add(temp);
		}
	}
	
	public void actualizarlist() {
		contenido = "";

		lista.forEach((usuario) -> {
			contenido += usuario.getNickname()+";"+usuario.getContraseña()+"\n";
		});

		escribirEnArchivoTexto("Usuarios.csv", contenido);
	}
	
	public void escribirEnArchivoTexto(String url, String contenido) {
		FileHandler.escribirEnArchivoTexto(url, contenido);
	}

	public ArrayList<Usuario> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Usuario> lista) {
		this.lista = lista;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
}
