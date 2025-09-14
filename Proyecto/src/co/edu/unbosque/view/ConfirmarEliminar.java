package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ConfirmarEliminar extends JPanel{
	
	private JButton volver;
	private JButton eliminar;
	
	public ConfirmarEliminar() {
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		this.setBounds(0, 0, 1280, 720);
		this.setLayout(null);
		this.setBackground(new Color(211,211,211,200));
		
		JPanel arriba = new JPanel();
		arriba.setBounds(400,225,500,200);
		arriba.setBackground(Color.WHITE);
		
		JLabel titulo = new JLabel("¿Está seguro de eliminar el carrito?");
		titulo.setBounds(425, 260, 460, 50);
		titulo.setForeground(Color.black);
		titulo.setFont(new Font("Arial", Font.BOLD, 26));
		
		volver = new JButton("Volver");
		volver.setBounds(50, 25, 250, 50);
		volver.setFont(new Font("Arial", Font.BOLD, 20));
		volver.setBackground(Color.red.brighter());
		volver.setForeground(Color.WHITE);
		volver.setFocusPainted(false);
		
		eliminar = new JButton("Eliminar Carrito");
		eliminar.setBounds(420, 350, 460, 50);
		eliminar.setFont(new Font("Arial", Font.BOLD, 20));
		eliminar.setBackground(Color.green.brighter());
		eliminar.setForeground(Color.WHITE);
		eliminar.setFocusPainted(false);
		
		this.add(eliminar);
		this.add(volver);
		this.add(titulo);
		this.add(arriba);
	}

	public JButton getVolver() {
		return volver;
	}

	public void setVolver(JButton volver) {
		this.volver = volver;
	}

	public JButton getEliminar() {
		return eliminar;
	}

	public void setEliminar(JButton eliminar) {
		this.eliminar = eliminar;
	}
	
}
