package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Usuario;

public class UsuariosDAO extends DAO<Usuario>{
	private ArrayList<Usuario> usuarios;
	
	public UsuariosDAO() {
		usuarios = new ArrayList<>();
		FileHandler.escribirEnArchivoTexto("Usuarios.csv", "");
	}
	
}
