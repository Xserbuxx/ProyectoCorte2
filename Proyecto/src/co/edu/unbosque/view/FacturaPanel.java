package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FacturaPanel extends JPanel{
	public FacturaPanel(String nombre, float precio, String ruta) {
		this.setPreferredSize(new Dimension(500, 100));
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		this.setLayout(null);

		JLabel lbprecio = new JLabel("$" + precio);
		lbprecio.setFont(new Font("Arial", Font.BOLD, 25));
		lbprecio.setBounds(70, 50, 220, 50);

		JLabel lbnombre = new JLabel(nombre);
		lbnombre.setBounds(70, 10, 220, 50);
		lbnombre.setFont(new Font("Arial", Font.BOLD, 35));

		ImageIcon icon = new ImageIcon(ruta);
		Image iconEscalado = icon.getImage().getScaledInstance(50, 80, Image.SCALE_SMOOTH);
		JLabel icono = new JLabel(new ImageIcon(iconEscalado));
		icono.setBounds(10, 10, 50, 80);

		this.add(icono);
		this.add(lbnombre);
		this.add(lbprecio);
	}
}
