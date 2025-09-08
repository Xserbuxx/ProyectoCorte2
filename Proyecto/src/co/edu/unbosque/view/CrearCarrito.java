package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JPanel;

public class CrearCarrito extends JPanel{
	
	public CrearCarrito() {
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		this.setBounds(0, 0, 1280, 720);
		this.setLayout(null);
		this.setBackground(new Color(211,211,211,200));
		
		JPanel arriba = new JPanel();
		arriba.setBounds(420,20,500,50);
		arriba.setBackground(Color.GREEN.brighter());
		
		this.add(arriba);
	}
	
}
