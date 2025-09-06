package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Belleza;

public class BellezaDAO implements DAO<Belleza> {

	private ArrayList<Belleza> lista;
	

	public BellezaDAO() {
		lista = new ArrayList<>();
		LeerArchivoTexto("Belleza.csv");
	}

	@Override
	public void crear(Belleza nuevoDato) {
		lista.add(nuevoDato);
		escribirEnArchivoTexto();
	}

	@Override
	public boolean actualizar(int indice, Belleza actualizarDato) {
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
			Belleza temp = new Belleza();
			temp.setPrecio(Float.parseFloat(columnas[0]));
			temp.setNombre(columnas[1]);
			temp.setDescripcion(columnas[2]);
			temp.setUnidades(Integer.parseInt(columnas[3]));
			temp.setRutaFoto(columnas[4]);
			temp.setId(Integer.parseInt(columnas[5]));
			temp.setTipoProducto(columnas[6]);
			temp.setFechaExpiracion(columnas[7]);

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
						+belleza.getTipoProducto()+";"
						+belleza.getFechaExpiracion()+"\n";
		});
		
		FileHandler.escribirEnArchivoTexto("Belleza.csv", contenido);
	}

	public ArrayList<Belleza> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Belleza> lista) {
		this.lista = lista;
	}
	
}
