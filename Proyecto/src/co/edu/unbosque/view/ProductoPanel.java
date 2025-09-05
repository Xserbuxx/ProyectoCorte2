package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ProductoPanel extends JPanel{
	
	private JButton info;
	
	public ProductoPanel(String nombre, String precio, String ruta, String id) {
		this.setPreferredSize(new Dimension(300, 470));
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		this.setLayout(null);

		JLabel lbprecio = new JLabel("$" + precio);
		lbprecio.setFont(new Font("Arial", Font.BOLD, 30));
		lbprecio.setBounds(40, 450, 220, 50);

		JTextArea lbnombre = new JTextArea(nombre);
		lbnombre.setBounds(40, 380, 220, 50);
		lbnombre.setFont(new Font("Arial", Font.BOLD, 20));
		lbnombre.setLineWrap(true);
		lbnombre.setWrapStyleWord(true);
		lbnombre.setEditable(false);
		lbnombre.setFocusable(false);

		ImageIcon icon = new ImageIcon(ruta);
		Image iconEscalado = icon.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
		JLabel icono = new JLabel(new ImageIcon(iconEscalado));
		icono.setBounds(50, 50, 200, 300);
		
		info = new JButton();
		info.setActionCommand("Producto_"+id);
		info.setBounds(40, 500, 220, 50);
		
		this.add(info);
		this.add(icono);
		this.add(lbnombre);
		this.add(lbprecio);
	}

	public JButton getInfo() {
		return info;
	}

	public void setInfo(JButton info) {
		this.info = info;
	}
	
	
	
}
