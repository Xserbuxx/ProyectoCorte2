package co.edu.unbosque.controller;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.view.Consola;

public class Controlador {
	
	private Consola con;
	private ModelFacade mf;
	
	public Controlador() {
		con = new Consola();
		mf = new ModelFacade();
	}
		
	public void run() {
		con.escribirConSalto("inicio de sesion\n");
		System.out.println("Digite su usuario");
		String usuario = con.leerLineaCompleta();
		System.out.println("Digite su contraseña");
		String contraseña = con.leerLineaCompleta();
		
		mf.getUsDAO();
		
		
		
	}
	
	
}
