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

public class Factura extends JPanel {
	private JButton volver;
	private JPanel panelProductos;
	private JScrollPane scroll;

	public Factura() {
		iniciarComponentes();
	}

	private void iniciarComponentes() {

		this.setBounds(0, 0, 1280, 720);
		this.setLayout(null);
		this.setBackground(new Color(211, 211, 211, 200));

		JPanel arriba = new JPanel();
		arriba.setBounds(420, 20, 500, 50);
		arriba.setBackground(Color.GREEN.brighter());

		panelProductos = new JPanel();
		panelProductos.setLayout(new BoxLayout(panelProductos, BoxLayout.Y_AXIS));

		volver = new JButton("Volver");
		volver.setBounds(50, 25, 250, 50);
		volver.setFont(new Font("Arial", Font.BOLD, 20));
		volver.setBackground(Color.red.brighter());
		volver.setForeground(Color.WHITE);
		volver.setFocusPainted(false);

		scroll = new JScrollPane(panelProductos, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		scroll.setBounds(420, 70, 500, 550);
		scroll.setBorder(null);
		
		this.add(volver);
		this.add(scroll);
		this.add(arriba);
	}
	
	public void mostrarTotal(String total) {
		limpiarLabels();
		JLabel ltotal = new JLabel("Precio total de los productos: $" + total);
		ltotal.setBounds(490, 20, 500, 50);
		ltotal.setFont(new Font("Arial", Font.BOLD, 20));
		
		this.add(ltotal);
		this.setComponentZOrder(ltotal, 0);
	}
	
	public void limpiarLabels() {
		for (Component comp : this.getComponents()) {
			if (comp instanceof JLabel) {
				this.remove(comp);
			}
		}
		this.revalidate();
		this.repaint();

	}
	
	public void limpiarBotones() {
		
		for (Component comp : panelProductos.getComponents()) {
			for (Component com : ((JPanel) comp).getComponents()) {
				if(com instanceof JButton) {
					com.setEnabled(false);
				}
			}
		}
		scroll.revalidate();
		scroll.repaint();
	}

	public void mostrarProductos(String nombre,float precio,String ruta) {
		panelProductos.add(new FacturaPanel(nombre,precio,ruta));
	}

	public void limpiarProductos() {
		panelProductos.removeAll();
	}

	public JButton getVolver() {
		return volver;
	}

	public void setVolver(JButton volver) {
		this.volver = volver;
	}

	public JPanel getPanelProductos() {
		return panelProductos;
	}

	public void setPanelProductos(JPanel panelProductos) {
		this.panelProductos = panelProductos;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}
	
}
