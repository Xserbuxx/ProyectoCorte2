package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Deportes;

public class DeportesDAO implements DAO<Deportes> {

	private ArrayList<Deportes> lista;

	public DeportesDAO() {
		lista = new ArrayList<>();
		LeerArchivoTexto("Deportes.csv");
	}

	@Override
	public void crear(Deportes nuevoDato) {
		lista.add(nuevoDato);
		escribirEnArchivoTexto();
	}

	@Override
	public boolean actualizar(int indice, Deportes actualizarDato) {
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
			Deportes temp = new Deportes();
			temp.setPrecio(Float.parseFloat(columnas[0]));
			temp.setNombre(columnas[1]);
			temp.setDescripcion(columnas[2]);
			temp.setUnidades(Integer.parseInt(columnas[3]));
			temp.setRutaFoto(columnas[4]);
			temp.setId(Integer.parseInt(columnas[5]));
			temp.setTipoDeporte(columnas[6]);
			temp.setMaterial(columnas[7]);;

			lista.add(temp);
		}
	}
	
	public void escribirEnArchivoTexto() {
		contenido = "";

		lista.forEach((deportes) -> {
			contenido += deportes.getPrecio()+";"
						+deportes.getNombre()+";"
						+deportes.getDescripcion()+";"
						+deportes.getUnidades()+";"
						+deportes.getRutaFoto()+";"
						+deportes.getId()+";"
						+deportes.getTipoDeporte()+";"
						+deportes.getMaterial()+"\n";
		});
		
		FileHandler.escribirEnArchivoTexto("Deportes.csv", contenido);
	}

	public ArrayList<Deportes> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Deportes> lista) {
		this.lista = lista;
	}
	
}
