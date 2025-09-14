package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ConfirmarCompra extends JPanel {

	private JButton volver;
	private JButton comprar;

	public ConfirmarCompra() {
		this.setBounds(0, 0, 1280, 720);
		this.setLayout(null);
		this.setBackground(new Color(211, 211, 211, 200));

		JPanel arriba = new JPanel();
		arriba.setBounds(400, 225, 500, 200);
		arriba.setBackground(Color.WHITE);

		volver = new JButton("Volver");
		volver.setBounds(50, 25, 250, 50);
		volver.setFont(new Font("Arial", Font.BOLD, 20));
		volver.setBackground(Color.red.brighter());
		volver.setForeground(Color.WHITE);
		volver.setFocusPainted(false);

		comprar = new JButton("Comprar Carrito");
		comprar.setBounds(420, 350, 460, 50);
		comprar.setFont(new Font("Arial", Font.BOLD, 20));
		comprar.setBackground(Color.green.brighter());
		comprar.setForeground(Color.WHITE);
		comprar.setFocusPainted(false);

		this.add(comprar);
		this.add(volver);
		this.add(arriba);
	}

	public void mostrarTitulo(float precio) {
		JLabel titulo = new JLabel("Estas a punto de realizar una compra por:");
		titulo.setBounds(435, 260, 460, 50);
		titulo.setForeground(Color.black);
		titulo.setFont(new Font("Arial", Font.BOLD, 22));

		JLabel precioLabel = new JLabel("$" + precio);
		precioLabel.setBounds(610, 290, 200, 50);
		precioLabel.setForeground(Color.black);
		precioLabel.setFont(new Font("Arial", Font.BOLD, 22));

		this.add(precioLabel);
		this.add(titulo);
		this.setComponentZOrder(titulo, 0);
		this.setComponentZOrder(precioLabel, 0);
	}

	public void setVolver(JButton volver) {
		this.volver = volver;
	}

	public void setComprar(JButton comprar) {
		this.comprar = comprar;
	}

	public JButton getVolver() {
		return volver;
	}

	public JButton getComprar() {
		return comprar;
	}
	
}
