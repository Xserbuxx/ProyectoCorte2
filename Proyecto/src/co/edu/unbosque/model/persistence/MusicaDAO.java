package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Musica;

public class MusicaDAO implements DAO<Musica> {

	private ArrayList<Musica> lista;

	public MusicaDAO() {
		lista = new ArrayList<>();
	}

	@Override
	public void crear(Musica nuevoDato) {
		lista.add(nuevoDato);
	}

	@Override
	public boolean actualizar(int indice, Musica actualizarDato) {
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

}
