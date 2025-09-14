package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CarritoPanel2 extends JPanel {

	private JButton selec;
	private JButton eliminar;

	public CarritoPanel2(String nombre, ActionListener e) {
		this.setPreferredSize(new Dimension(483, 100));
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		this.setLayout(null);

		selec = new JButton();
		selec.setActionCommand("CarritoCom-" + nombre);
		selec.addActionListener(e);
		selec.setBounds(0, 0, 1100, 100);
		selec.setContentAreaFilled(false);
		selec.setBorderPainted(false);
		selec.setFocusPainted(false);
		
		eliminar = new JButton("❌");
		eliminar.setActionCommand("EliminarCarrito-" + nombre);
		eliminar.addActionListener(e);
		eliminar.setBounds(1100, 0, 160, 100);
		eliminar.setBackground(Color.RED);
		eliminar.setForeground(Color.WHITE);
		eliminar.setFocusPainted(false);

		crearLabel(nombre.split("_")[0], 50, 0, 453, 100, Color.black, 50);

		this.setName(nombre);
		
		this.add(eliminar);
		this.add(selec);
	}

	private void crearLabel(String texto, int x, int y, int ancho, int alto, Color color, int tamañoTexto) {
		JLabel label = new JLabel(texto);
		label.setBounds(x, y, ancho, alto);
		label.setForeground(color);
		label.setFont(new Font("Arial", Font.BOLD, tamañoTexto));
		this.add(label);
	}

}
