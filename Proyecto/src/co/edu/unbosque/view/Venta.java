package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Venta extends JPanel{
	
	private JButton cambiarModo;
	
	public Venta() {
		iniciarComponente();
	}

	private void iniciarComponente() {
		this.setBounds(0, 0, 1280, 720);
		this.setLayout(null);

		JPanel arriba = new JPanel();
		arriba.setBounds(0, 0, 1280, 100);
		arriba.setBackground(Color.YELLOW);
		
		cambiarModo = new JButton("Comprar");
		cambiarModo.setBounds(850, 25, 250, 50);
		cambiarModo.setFont(new Font("Arial", Font.BOLD, 20));
		cambiarModo.setBackground(new Color(52,131,250));
		cambiarModo.setForeground(Color.WHITE);
		cambiarModo.setFocusPainted(false);
		
		this.add(cambiarModo);
		this.add(arriba);
	}

	private void crearLabel(String texto, int x, int y, int ancho, int alto, Color color, int tamañoTexto) {
		JLabel label = new JLabel(texto);
		label.setBounds(x, y, ancho, alto);
		label.setForeground(color);
		label.setFont(new Font("Arial", Font.BOLD, tamañoTexto));
		this.add(label);
	}

	public JButton getCambiarModo() {
		return cambiarModo;
	}

	public void setCambiarModo(JButton cambiarModo) {
		this.cambiarModo = cambiarModo;
	}
	
}
