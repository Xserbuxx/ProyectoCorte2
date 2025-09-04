package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Juguetes;

public class JuguetesDAO implements DAO<Juguetes> {

	private ArrayList<Juguetes> lista;

	public JuguetesDAO() {
		lista = new ArrayList<>();
	}

	@Override
	public void crear(Juguetes nuevoDato) {
		lista.add(nuevoDato);
	}

	@Override
	public boolean actualizar(int indice, Juguetes actualizarDato) {
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
