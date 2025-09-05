package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Producto;

public class ProductosDAO implements DAO<Producto>{
	
	ArrayList<Producto> lista;
	
	public ProductosDAO() {
		lista = new ArrayList<>();
	}

	@Override
	public void crear(Producto nuevoDato) {
		lista.add(nuevoDato);
	}

	@Override
	public boolean actualizar(int indice, Producto actualizarDato) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int indice) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String mostrarDatos() {
		return lista.toString();
	}

	@Override
	public int contar() {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<Producto> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Producto> lista) {
		this.lista = lista;
	}
}
