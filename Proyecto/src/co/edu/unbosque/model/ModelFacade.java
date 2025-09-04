	package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.UsuariosDAO;

public class ModelFacade {
	
	private UsuariosDAO usDAO;
	
	public ModelFacade() {
		usDAO = new UsuariosDAO();
	}
	
	public UsuariosDAO getUsDAO() {
		return usDAO;
	}

	public void setUsDAO(UsuariosDAO usDAO) {
		this.usDAO = usDAO;
	}	
}
