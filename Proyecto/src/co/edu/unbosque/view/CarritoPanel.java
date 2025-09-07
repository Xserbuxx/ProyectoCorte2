package co.edu.unbosque.view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CarritoPanel extends JPanel{
	
	private JButton selec;
	
	public CarritoPanel(int id, ActionListener e) {
		this.setPreferredSize(new Dimension(483, 100));
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		this.setLayout(null);
		
		selec = new JButton();
		selec.setActionCommand("Carrito_"+id);
		selec.addActionListener(e);
		selec.setBounds(0, 0, 483, 100);
		selec.setContentAreaFilled(false);
		selec.setBorderPainted(false);
		selec.setFocusPainted(false);
		
		this.add(selec);
	}
	
}
