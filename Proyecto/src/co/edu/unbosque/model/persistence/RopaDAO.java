package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Ropa;

public class RopaDAO implements DAO<Ropa> {

	private ArrayList<Ropa> lista;

	public RopaDAO() {
		lista = new ArrayList<>();
		LeerArchivoTexto("Ropa.csv");
	}

	@Override
	public void crear(Ropa nuevoDato) {
		lista.add(nuevoDato);
		escribirEnArchivoTexto();
	}

	@Override
	public boolean actualizar(int indice, Ropa actualizarDato) {
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
			Ropa temp = new Ropa();
			temp.setPrecio(Float.parseFloat(columnas[0]));
			temp.setNombre(columnas[1]);
			temp.setDescripcion(columnas[2]);
			temp.setUnidades(Integer.parseInt(columnas[3]));
			temp.setRutaFoto(columnas[4]);
			temp.setId(Integer.parseInt(columnas[5]));
			temp.setTalla(columnas[6]);
			temp.setColor(columnas[7]);

			lista.add(temp);
		}
	}
	
	public void escribirEnArchivoTexto() {
		contenido = "";

		lista.forEach((ropa) -> {
			contenido += ropa.getPrecio()+";"
						+ropa.getNombre()+";"
						+ropa.getDescripcion()+";"
						+ropa.getUnidades()+";"
						+ropa.getRutaFoto()+";"
						+ropa.getId()+";"
						+ropa.getTalla()+";"
						+ropa.getColor()+"\n";
		});
		
		FileHandler.escribirEnArchivoTexto("Ropa.csv", contenido);
	}

	public ArrayList<Ropa> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Ropa> lista) {
		this.lista = lista;
	}
	
}
