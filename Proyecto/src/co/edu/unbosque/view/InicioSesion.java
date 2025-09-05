package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InicioSesion extends JPanel{
	
	private JTextField usuario;
	private JTextField contraseña;
	private JButton botonRegistrarse;
	private JButton botonInicio;
	
	public InicioSesion() {
		iniciarComponente();
	}
	
	private void iniciarComponente() {
		this.setBounds(0, 0, 1280, 720);
		this.setLayout(null);
		
		JPanel arriba = new JPanel();
		arriba.setBounds(0, 0, 1280, 100);
		arriba.setBackground(Color.YELLOW);
		
		usuario = new JTextField();
		usuario.setBounds(450, 250, 380, 50);
		usuario.setFont(new Font("Arial", Font.BOLD, 22));
		
		contraseña = new JTextField();
		contraseña.setBounds(450, 400, 380, 50);
		contraseña.setFont(new Font("Arial", Font.BOLD, 22));
		
		botonRegistrarse = new JButton("Registrarse");
		botonRegistrarse.setBounds(590, 450, 110, 30);
		botonRegistrarse.setForeground(Color.BLUE);
		botonRegistrarse.setContentAreaFilled(false);
		botonRegistrarse.setBorderPainted(false);
		botonRegistrarse.setFocusPainted(false);
		
		botonInicio = new JButton("Iniciar Sesion");
		botonInicio.setBounds(450, 530, 380, 50);
		botonInicio.setFont(new Font("Arial", Font.BOLD, 25));
		Color azul = new Color(52,131,250);
		botonInicio.setBackground(azul);
		botonInicio.setForeground(Color.WHITE);
		botonInicio.setFocusPainted(false);
		
		crearLabel("Inicio de Sesion", 450, 0, 381, 100, Color.BLACK,50);
		crearLabel("Usuario:", 450, 215,138,30,Color.BLACK,35);
		crearLabel("Contraseña:", 450, 365,200,30,Color.BLACK,35);
		crearLabel("¿No tiene una cuenta?", 450, 450,200,30,Color.BLACK,15);
		
		this.add(arriba);
		this.add(usuario);
		this.add(contraseña);
		this.add(botonRegistrarse);
		this.add(botonInicio);
	}
	
	private void crearLabel(String texto, int x, int y, int ancho, int alto, Color color, int tamañoTexto) {
		JLabel label = new JLabel(texto);
		label.setBounds(x, y, ancho, alto);
		label.setForeground(color);
		label.setFont(new Font("Arial", Font.BOLD, tamañoTexto));
		this.add(label);
	}

	public JTextField getUsuario() {
		return usuario;
	}

	public void setUsuario(JTextField usuario) {
		this.usuario = usuario;
	}

	public JTextField getContraseña() {
		return contraseña;
	}

	public void setContraseña(JTextField contraseña) {
		this.contraseña = contraseña;
	}

	public JButton getBotonRegistrarse() {
		return botonRegistrarse;
	}

	public void setBotonRegistrarse(JButton botonRegistrarse) {
		this.botonRegistrarse = botonRegistrarse;
	}

	public JButton getBotonInicio() {
		return botonInicio;
	}

	public void setBotonInicio(JButton botonInicio) {
		this.botonInicio = botonInicio;
	}
	
	
	
}
