package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Registrarse extends JPanel{
	
	private JTextField usuario;
	private JTextField contraseña;
	private JButton botonInicioSesion;
	private JButton botonRegistro;
	
	public Registrarse() {
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
		
		botonInicioSesion = new JButton("Iniciar Sesion");
		botonInicioSesion.setBounds(590, 450, 120, 30);
		botonInicioSesion.setForeground(Color.BLUE);
		botonInicioSesion.setContentAreaFilled(false);
		botonInicioSesion.setBorderPainted(false);
		botonInicioSesion.setFocusPainted(false);
		
		botonRegistro = new JButton("Registrarse");
		botonRegistro.setBounds(450, 530, 380, 50);
		botonRegistro.setFont(new Font("Arial", Font.BOLD, 25));
		Color azul = new Color(52,131,250);
		botonRegistro.setBackground(azul);
		botonRegistro.setForeground(Color.WHITE);
		botonRegistro.setFocusPainted(false);
		
		crearLabel("Registro", 520, 0, 381, 100, Color.BLACK,50);
		crearLabel("Usuario:", 450, 215,138,30,Color.BLACK,35);
		crearLabel("Contraseña:", 450, 365,200,30,Color.BLACK,35);
		crearLabel("¿Ya tiene una cuenta?", 450, 450,200,30,Color.BLACK,15);
		
		this.add(arriba);
		this.add(usuario);
		this.add(contraseña);
		this.add(botonInicioSesion);
		this.add(botonRegistro);
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

	public JButton getBotonInicioSesion() {
		return botonInicioSesion;
	}

	public void setBotonInicioSesion(JButton botonInicioSesion) {
		this.botonInicioSesion = botonInicioSesion;
	}

	public JButton getBotonRegistro() {
		return botonRegistro;
	}

	public void setBotonRegistro(JButton botonRegistro) {
		this.botonRegistro = botonRegistro;
	}
	
	
}
