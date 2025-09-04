package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.view.*;

public class Controlador implements ActionListener{
	
	private Consola con;
	private VentanaPrincipal vp;
	private ModelFacade mf;
	
	public Controlador() {
		con = new Consola();
		mf = new ModelFacade();
		vp = new VentanaPrincipal();
	}
		
	public void runGUI() {
		agregarOyentes();
		vp.setVisible(true);
	}
	
	private void agregarOyentes() {
		
		vp.getMp().getVis().getBotonRegistrarse().addActionListener(this);
		vp.getMp().getVis().getBotonRegistrarse().setActionCommand("Boton Registrarse");
		
		vp.getMp().getReg().getBotonInicioSesion().addActionListener(this);
		vp.getMp().getReg().getBotonInicioSesion().setActionCommand("Boton Iniciar Sesion");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String boton = e.getActionCommand();
		switch (boton) {
		case "Boton Registrarse":
			vp.getMp().mostrarPanel("reg");
			break;
			
		case "Boton Iniciar Sesion":
			vp.getMp().mostrarPanel("vis");
			break;
			
		default:
			break;
		}
	}
	
	
}
