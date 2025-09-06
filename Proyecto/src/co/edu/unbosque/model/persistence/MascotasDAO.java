package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Mascotas;

public class MascotasDAO implements DAO<Mascotas> {

	private ArrayList<Mascotas> lista;

	public MascotasDAO() {
		lista = new ArrayList<>();
		LeerArchivoTexto("Mascotas.csv");
	}

	@Override
	public void crear(Mascotas nuevoDato) {
		lista.add(nuevoDato);
		escribirEnArchivoTexto();
	}

	@Override
	public boolean actualizar(int indice, Mascotas actualizarDato) {
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
			Mascotas temp = new Mascotas();
			temp.setPrecio(Float.parseFloat(columnas[0]));
			temp.setNombre(columnas[1]);
			temp.setDescripcion(columnas[2]);
			temp.setUnidades(Integer.parseInt(columnas[3]));
			temp.setRutaFoto(columnas[4]);
			temp.setId(Integer.parseInt(columnas[5]));
			temp.setTipoAnimal(columnas[6]);
			temp.setTamaño(columnas[7]);

			lista.add(temp);
		}
	}
	
	public void escribirEnArchivoTexto() {
		contenido = "";

		lista.forEach((mascota) -> {
			contenido += mascota.getPrecio()+";"
						+mascota.getNombre()+";"
						+mascota.getDescripcion()+";"
						+mascota.getUnidades()+";"
						+mascota.getRutaFoto()+";"
						+mascota.getId()+";"
						+mascota.getTipoAnimal()+";"
						+mascota.getTamaño()+"\n";
		});
		
		FileHandler.escribirEnArchivoTexto("Mascotas.csv", contenido);
	}

	public ArrayList<Mascotas> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Mascotas> lista) {
		this.lista = lista;
	}
	
}
