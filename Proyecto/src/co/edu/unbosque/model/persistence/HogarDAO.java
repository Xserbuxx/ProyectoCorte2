package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Hogar;

public class HogarDAO implements DAO<Hogar> {

	private ArrayList<Hogar> lista;

	public HogarDAO() {
		lista = new ArrayList<>();
		LeerArchivoTexto("Hogar.csv");
	}

	@Override
	public void crear(Hogar nuevoDato) {
		lista.add(nuevoDato);
		escribirEnArchivoTexto();
	}

	@Override
	public boolean actualizar(int indice, Hogar actualizarDato) {
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
			Hogar temp = new Hogar();
			temp.setPrecio(Float.parseFloat(columnas[0]));
			temp.setNombre(columnas[1]);
			temp.setDescripcion(columnas[2]);
			temp.setUnidades(Integer.parseInt(columnas[3]));
			temp.setRutaFoto(columnas[4]);
			temp.setId(Integer.parseInt(columnas[5]));
			temp.setMaterial(columnas[6]);
			temp.setDimensiones(columnas[7]);

			lista.add(temp);
		}
	}
	
	public void escribirEnArchivoTexto() {
		contenido = "";

		lista.forEach((belleza) -> {
			contenido += belleza.getPrecio()+";"
						+belleza.getNombre()+";"
						+belleza.getDescripcion()+";"
						+belleza.getUnidades()+";"
						+belleza.getRutaFoto()+";"
						+belleza.getId()+";"
						+belleza.getMaterial()+";"
						+belleza.getDimensiones()+"\n";
		});
		
		FileHandler.escribirEnArchivoTexto("Hogar.csv", contenido);
	}

	public ArrayList<Hogar> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Hogar> lista) {
		this.lista = lista;
	}
	
}
