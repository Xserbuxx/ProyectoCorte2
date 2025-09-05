package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.view.*;

public class Controlador implements ActionListener{
	
	private VentanaPrincipal vp;
	private ModelFacade mf;
	
	public Controlador() {
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
		
		vp.getMp().getVis().getBotonInicio().addActionListener(this);
		vp.getMp().getVis().getBotonInicio().setActionCommand("Boton Inicio De Sesion");
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
			
		case "Boton Inicio De Sesion":
			vp.getMp().mostrarPanel("com");
			break;
			
		default:
			break;
		}
	}
	
	
}
