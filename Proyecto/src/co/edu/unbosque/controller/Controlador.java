package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
		vp.setVisible(true);
		vp.getMp().getCom().actualizarCompra(vp.getMp().getVen());
		agregarOyentes();
	}
	
	private void agregarOyentes() {
		
		vp.getMp().getVis().getBotonRegistrarse().addActionListener(this);
		vp.getMp().getVis().getBotonRegistrarse().setActionCommand("Boton Registrarse");
		
		vp.getMp().getReg().getBotonInicioSesion().addActionListener(this);
		vp.getMp().getReg().getBotonInicioSesion().setActionCommand("Boton Iniciar Sesion");
		
		vp.getMp().getVis().getBotonInicio().addActionListener(this);
		vp.getMp().getVis().getBotonInicio().setActionCommand("Boton Inicio De Sesion");
		
		vp.getMp().getCom().getCambiarModo().addActionListener(this);
		vp.getMp().getCom().getCambiarModo().setActionCommand("Boton Cambiar Modo Venta");
		
		vp.getMp().getVen().getCambiarModo().addActionListener(this);
		vp.getMp().getVen().getCambiarModo().setActionCommand("Boton Cambiar Modo Compra");
		
		for (ProductoPanel producto : vp.getMp().getVen().getPp()) {
			producto.getInfo().addActionListener(this);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String boton = e.getActionCommand();
		
		if(boton.contains("Producto_")) {
			JOptionPane.showMessageDialog(vp, boton);
		}
		
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
		case "Boton Cambiar Modo Compra":
			vp.getMp().mostrarPanel("com");
			break;
		case "Boton Cambiar Modo Venta":
			vp.getMp().mostrarPanel("ven");
			break;
		default:
			break;
		}
	}
	
	
}
