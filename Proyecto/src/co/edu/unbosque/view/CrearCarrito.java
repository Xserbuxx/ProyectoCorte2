package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CrearCarrito extends JPanel{
	
	private JButton volver;
	private JButton crearCarrito;
	private JTextField nombreC;
	
	public CrearCarrito() {
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		this.setBounds(0, 0, 1280, 720);
		this.setLayout(null);
		this.setBackground(new Color(211,211,211,200));
		
		JPanel arriba = new JPanel();
		arriba.setBounds(400,175,500,250);
		arriba.setBackground(Color.WHITE);
		
		volver = new JButton("Volver");
		volver.setBounds(50, 25, 250, 50);
		volver.setFont(new Font("Arial", Font.BOLD, 20));
		volver.setBackground(Color.red.brighter());
		volver.setForeground(Color.WHITE);
		volver.setFocusPainted(false);
		
		crearCarrito = new JButton("Crear Carrito");
		crearCarrito.setBounds(420, 350, 460, 50);
		crearCarrito.setFont(new Font("Arial", Font.BOLD, 20));
		crearCarrito.setBackground(Color.green.brighter());
		crearCarrito.setForeground(Color.WHITE);
		crearCarrito.setFocusPainted(false);
		
		nombreC = new JTextField();
		nombreC.setBounds(420, 270, 460, 50);
		nombreC.setFont(new Font("Arial", Font.BOLD, 22));
		
		crearLabel("Nombre:", 420, 200, 460, 50, Color.black, 20);
		
		this.add(crearCarrito);
		this.add(nombreC);
		this.add(volver);
		this.add(arriba);
	}
	
	private void crearLabel(String texto, int x, int y, int ancho, int alto, Color color, int tamañoTexto) {
		JLabel label = new JLabel(texto);
		label.setBounds(x, y, ancho, alto);
		label.setForeground(color);
		label.setFont(new Font("Arial", Font.BOLD, tamañoTexto));
		this.add(label);
	}

	public JButton getVolver() {
		return volver;
	}

	public void setVolver(JButton volver) {
		this.volver = volver;
	}

	public JButton getCrearCarrito() {
		return crearCarrito;
	}

	public void setCrearCarrito(JButton crearCarrito) {
		this.crearCarrito = crearCarrito;
	}

	public JTextField getNombreC() {
		return nombreC;
	}

	public void setNombreC(JTextField nombreC) {
		this.nombreC = nombreC;
	}
	
}
