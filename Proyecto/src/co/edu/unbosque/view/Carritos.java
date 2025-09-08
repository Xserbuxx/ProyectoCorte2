package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Carritos extends JPanel{
	
	private JButton volver;
	private JButton crearCarrito;
	private JScrollPane scroll;
	private JPanel panelProductos;
	
	public Carritos() {
		iniciarComponente();
	}
	
	private void iniciarComponente() {
		this.setBounds(0, 0, 1280, 720);
		this.setLayout(null);

		JPanel arriba = new JPanel();
		arriba.setBounds(0, 0, 1280, 100);
		arriba.setBackground(Color.YELLOW);
		
		volver = new JButton("Volver");
		volver.setBounds(50, 25, 250, 50);
		volver.setFont(new Font("Arial", Font.BOLD, 20));
		volver.setBackground(Color.red.brighter());
		volver.setForeground(Color.WHITE);
		volver.setFocusPainted(false);
		
		crearCarrito = new JButton("Crear Carrito");
		crearCarrito.setBounds(350, 25, 250, 50);
		crearCarrito.setFont(new Font("Arial", Font.BOLD, 20));
		crearCarrito.setBackground(Color.green.brighter());
		crearCarrito.setForeground(Color.WHITE);
		crearCarrito.setFocusPainted(false);
		
		panelProductos = new JPanel();
		panelProductos.setLayout(new BoxLayout(panelProductos, BoxLayout.Y_AXIS));
		
		scroll = new JScrollPane(panelProductos, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		scroll.setBounds(0, 100, 1265, 583);
		
		this.add(crearCarrito);
		this.add(scroll);
		this.add(volver);
		this.add(arriba);
	}
	
	public void mostrarProductos(String nombre, int id, ActionListener e) {
		panelProductos.add(new CarritoPanel2(nombre,id, e));
	}
	

	public JButton getVolver() {
		return volver;
	}

	public void setVolver(JButton volver) {
		this.volver = volver;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public JPanel getPanelProductos() {
		return panelProductos;
	}

	public void setPanelProductos(JPanel panelProductos) {
		this.panelProductos = panelProductos;
	}

	public JButton getCrearCarrito() {
		return crearCarrito;
	}

	public void setCrearCarrito(JButton crearCarrito) {
		this.crearCarrito = crearCarrito;
	}
	
}
