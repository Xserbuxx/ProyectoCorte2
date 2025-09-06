package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Tecnologia;

public class TecnologiaDAO implements DAO<Tecnologia> {

	private ArrayList<Tecnologia> lista;

	public TecnologiaDAO() {
		lista = new ArrayList<>();
		LeerArchivoTexto("Tecnologia.csv");
	}

	@Override
	public void crear(Tecnologia nuevoDato) {
		lista.add(nuevoDato);
		escribirEnArchivoTexto();
	}

	@Override
	public boolean actualizar(int indice, Tecnologia actualizarDato) {
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
			Tecnologia temp = new Tecnologia();
			temp.setPrecio(Float.parseFloat(columnas[0]));
			temp.setNombre(columnas[1]);
			temp.setDescripcion(columnas[2]);
			temp.setUnidades(Integer.parseInt(columnas[3]));
			temp.setRutaFoto(columnas[4]);
			temp.setId(Integer.parseInt(columnas[5]));
			temp.setMarca(columnas[6]);
			temp.setModelo(columnas[7]);

			lista.add(temp);
		}
	}
	
	public void escribirEnArchivoTexto() {
		contenido = "";

		lista.forEach((tecnologia) -> {
			contenido += tecnologia.getPrecio()+";"
						+tecnologia.getNombre()+";"
						+tecnologia.getDescripcion()+";"
						+tecnologia.getUnidades()+";"
						+tecnologia.getRutaFoto()+";"
						+tecnologia.getId()+";"
						+tecnologia.getMarca()+";"
						+tecnologia.getModelo()+"\n";
		});
		
		FileHandler.escribirEnArchivoTexto("Tecnologia.csv", contenido);
	}

	public ArrayList<Tecnologia> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Tecnologia> lista) {
		this.lista = lista;
	}	
}
