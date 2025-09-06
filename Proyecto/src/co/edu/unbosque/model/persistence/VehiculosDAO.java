package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Vehiculos;

public class VehiculosDAO implements DAO<Vehiculos> {

	private ArrayList<Vehiculos> lista;

	public VehiculosDAO() {
		lista = new ArrayList<>();
		LeerArchivoTexto("Vehiculos.csv");
	}

	@Override
	public void crear(Vehiculos nuevoDato) {
		lista.add(nuevoDato);
		escribirEnArchivoTexto();
	}

	@Override
	public boolean actualizar(int indice, Vehiculos actualizarDato) {
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
			Vehiculos temp = new Vehiculos();
			temp.setPrecio(Float.parseFloat(columnas[0]));
			temp.setNombre(columnas[1]);
			temp.setDescripcion(columnas[2]);
			temp.setUnidades(Integer.parseInt(columnas[3]));
			temp.setRutaFoto(columnas[4]);
			temp.setId(Integer.parseInt(columnas[5]));
			temp.setAño(columnas[6]);
			temp.setModelo(columnas[7]);

			lista.add(temp);
		}
	}
	
	public void escribirEnArchivoTexto() {
		contenido = "";

		lista.forEach((vehiculo) -> {
			contenido += vehiculo.getPrecio()+";"
						+vehiculo.getNombre()+";"
						+vehiculo.getDescripcion()+";"
						+vehiculo.getUnidades()+";"
						+vehiculo.getRutaFoto()+";"
						+vehiculo.getId()+";"
						+vehiculo.getAño()+";"
						+vehiculo.getModelo()+"\n";
		});
		
		FileHandler.escribirEnArchivoTexto("Vehiculos.csv", contenido);
	}

	public ArrayList<Vehiculos> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Vehiculos> lista) {
		this.lista = lista;
	}
	
}
