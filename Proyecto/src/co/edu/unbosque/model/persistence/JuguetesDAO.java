package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Juguetes;

public class JuguetesDAO implements DAO<Juguetes> {

	private ArrayList<Juguetes> lista;

	public JuguetesDAO() {
		lista = new ArrayList<>();
		LeerArchivoTexto("Juguetes.csv");
	}

	@Override
	public void crear(Juguetes nuevoDato) {
		lista.add(nuevoDato);
		escribirEnArchivoTexto();
	}

	@Override
	public boolean actualizar(int indice, Juguetes actualizarDato) {
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
			Juguetes temp = new Juguetes();
			temp.setPrecio(Float.parseFloat(columnas[0]));
			temp.setNombre(columnas[1]);
			temp.setDescripcion(columnas[2]);
			temp.setUnidades(Integer.parseInt(columnas[3]));
			temp.setRutaFoto(columnas[4]);
			temp.setId(Integer.parseInt(columnas[5]));
			temp.setEdadRecomendada(Integer.parseInt(columnas[6]));
			temp.setMaterial(columnas[7]);

			lista.add(temp);
		}
	}
	
	public void escribirEnArchivoTexto() {
		contenido = "";

		lista.forEach((juguetes) -> {
			contenido += juguetes.getPrecio()+";"
						+juguetes.getNombre()+";"
						+juguetes.getDescripcion()+";"
						+juguetes.getUnidades()+";"
						+juguetes.getRutaFoto()+";"
						+juguetes.getId()+";"
						+juguetes.getEdadRecomendada()+";"
						+juguetes.getMaterial()+"\n";
		});
		
		FileHandler.escribirEnArchivoTexto("Juguetes.csv", contenido);
	}

	public ArrayList<Juguetes> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Juguetes> lista) {
		this.lista = lista;
	}
	
}
