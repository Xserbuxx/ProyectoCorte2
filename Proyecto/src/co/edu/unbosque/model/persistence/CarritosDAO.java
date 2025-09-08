package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Carrito;

public class CarritosDAO implements DAO<Carrito>{


	private ArrayList<Carrito> lista;
	

	public CarritosDAO() {
		lista = new ArrayList<>();
		LeerArchivoTexto("Carritos.csv");
	}

	@Override
	public void crear(Carrito nuevoDato) {
		try {
		lista.forEach((carrito)->{
			if(carrito.getNombre().equals(nuevoDato.getNombre())) {
				throw new NullPointerException();
			}
		});
		lista.add(nuevoDato);
		escribirEnArchivoTexto();
		}catch (Exception e) {
			System.out.println("puta");
		}
	}

	@Override
	public boolean actualizar(int indice, Carrito actualizarDato) {
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
			String[] columnas = filas[i].split("_");
			Carrito temp = new Carrito();
			temp.setNombre(columnas[0]+"_"+columnas[1]);

			lista.add(temp);
		}
	}
	
	public void escribirEnArchivoTexto() {
		contenido = "";

		lista.forEach((carrito) -> {
			contenido += carrito.getNombre()+"\n";
		});
		
		FileHandler.escribirEnArchivoTexto("Carritos.csv", contenido);
	}

	public ArrayList<Carrito> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Carrito> lista) {
		this.lista = lista;
	}
}
