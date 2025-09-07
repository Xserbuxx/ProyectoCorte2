package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProductoInfoPanel extends JPanel{
	
	private JButton volver;
	private JButton agregarCarrito;
	
	public ProductoInfoPanel() {
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
		
		agregarCarrito = new JButton("Agregar al carrito");
		agregarCarrito.setBounds(550, 600, 250, 50);
		agregarCarrito.setFont(new Font("Arial", Font.BOLD, 20));
		agregarCarrito.setBackground(Color.green.brighter());
		agregarCarrito.setForeground(Color.WHITE);
		agregarCarrito.setFocusPainted(false);
		
		this.add(agregarCarrito);
		this.add(volver);
		this.add(arriba);
	}
	
	public void mostrarProductoInfo(float precio, String nombre,String descripcion,int unidades,String url, String atributo1, String atributo2) {
		ImageIcon icon = new ImageIcon(url);
		Image iconEscalado = icon.getImage().getScaledInstance(427, 580, Image.SCALE_SMOOTH);
		JLabel icono = new JLabel(new ImageIcon(iconEscalado));
		icono.setBounds(0, 100, 427, 580);
		
		crearLabel(nombre, 520, 80, 1000, 100, Color.BLACK, 45);
		crearLabel(descripcion, 520, 120, 1000, 100, Color.BLACK, 20);
		crearLabel("$"+precio, 520, 300, 1000, 100, Color.BLACK, 20);
		crearLabel("Unidades disponibles: "+unidades, 520, 330, 1000, 100, Color.BLACK, 20);
		crearLabel(atributo1, 520, 360, 1000, 100, Color.BLACK, 20);
		crearLabel(atributo2, 520, 390, 1000, 100, Color.BLACK, 20);
		
		this.add(icono);
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
	
	private void crearLabel(String texto, int x, int y, int ancho, int alto, Color color, int tamañoTexto) {
		JLabel label = new JLabel(texto);
		label.setBounds(x, y, ancho, alto);
		label.setForeground(color);
		label.setFont(new Font("Arial", Font.BOLD, tamañoTexto));
		this.add(label);
	}

	public JButton getVolver() {
		return volver;
	}

	public void setVolver(JButton volver) {
		this.volver = volver;
	}

	public JButton getAgregarCarrito() {
		return agregarCarrito;
	}

	public void setAgregarCarrito(JButton agregarCarrito) {
		this.agregarCarrito = agregarCarrito;
	}
	
}
