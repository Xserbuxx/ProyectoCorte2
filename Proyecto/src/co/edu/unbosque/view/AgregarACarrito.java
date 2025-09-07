package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class AgregarACarrito extends JPanel {
	
	private JPanel panelProductos;
	private JScrollPane scroll;

	public AgregarACarrito() {
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		
		this.setBounds(0, 0, 1280, 720);
		this.setLayout(null);
		this.setBackground(new Color(211,211,211,200));
		
		JPanel arriba = new JPanel();
		arriba.setBounds(420,20,500,50);
		arriba.setBackground(Color.GREEN.brighter());
		
		panelProductos = new JPanel();
		panelProductos.setLayout(new BoxLayout(panelProductos, BoxLayout.Y_AXIS));
		
		scroll = new JScrollPane(panelProductos, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		scroll.setBounds(420, 70, 500, 550);
		scroll.setBorder(null);
		
		this.add(scroll);
		this.add(arriba);
	}
	
	public void mostrarProductos(int id, ActionListener e) {
		panelProductos.add(new CarritoPanel(id, e));
	}
	
	public void limpiarProductos() {
		panelProductos.removeAll();
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
