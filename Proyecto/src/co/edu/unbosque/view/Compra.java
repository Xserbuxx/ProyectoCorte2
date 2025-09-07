package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Compra extends JPanel {

	private JComboBox<String> categorias;
	private JScrollPane scroll;
	private JPanel panelProductos;
	private JButton cambiarModo;
	private JButton cerrarSesion;

	public Compra() {
		iniciarComponente();
	}

	private void iniciarComponente() {
		this.setBounds(0, 0, 1280, 720);
		this.setLayout(null);

		JPanel arriba = new JPanel();
		arriba.setBounds(0, 0, 1280, 100);
		arriba.setBackground(Color.YELLOW);
		
		cambiarModo = new JButton("Vender");
		cambiarModo.setBounds(650, 25, 250, 50);
		cambiarModo.setFont(new Font("Arial", Font.BOLD, 20));
		cambiarModo.setBackground(new Color(52,131,250));
		cambiarModo.setForeground(Color.WHITE);
		cambiarModo.setFocusPainted(false);

		String[] cate = { "Todo", "Belleza", "Deportes", "Hogar", "Juguetes", "Libros", "Mascotas", "Musica", "Ropa",
				"Tecnologia", "Vehiculos" };
		categorias = new JComboBox<>(cate);
		categorias.setBounds(320, 41, 200, 20);
		categorias.setBackground(Color.YELLOW);

		panelProductos = new JPanel();
		panelProductos.setLayout(new BoxLayout(panelProductos, BoxLayout.X_AXIS));
		
		cerrarSesion = new JButton("Cerrar Sesion");
		cerrarSesion.setBounds(950, 25, 250, 50);
		cerrarSesion.setFont(new Font("Arial", Font.BOLD, 20));
		cerrarSesion.setBackground(Color.red.brighter());
		cerrarSesion.setForeground(Color.WHITE);
		cerrarSesion.setFocusPainted(false);

		crearLabel("Categoria:", 200, 0, 100, 100, Color.BLACK, 20);
		
		this.add(cerrarSesion);
		this.add(cambiarModo);
		this.add(categorias);
		this.add(arriba);
	}

	private void crearLabel(String texto, int x, int y, int ancho, int alto, Color color, int tamañoTexto) {
		JLabel label = new JLabel(texto);
		label.setBounds(x, y, ancho, alto);
		label.setForeground(color);
		label.setFont(new Font("Arial", Font.BOLD, tamañoTexto));
		this.add(label);
	}
	
	public void mostrarProductos(String nombre, float precio, String ruta, int id, ActionListener e) {
		panelProductos.add(new ProductoPanel(nombre, precio, ruta, id, e));
	}
	
	public void limpiarProductos() {
		panelProductos.removeAll();
	}
	
	public void mostrarScroll() {
		scroll = new JScrollPane(panelProductos, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		scroll.setBounds(0, 100, 1265, 583);
		this.add(scroll);
	}

	public JComboBox<String> getCategorias() {
		return categorias;
	}

	public void setCategorias(JComboBox<String> categorias) {
		categorias = categorias;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public JPanel getPanelProductos() {
		return panelProductos;
	}

	public void setPanelProductos(JPanel panelProductos) {
		this.panelProductos = panelProductos;
	}

	public JButton getCambiarModo() {
		return cambiarModo;
	}

	public void setCambiarModo(JButton cambiarModo) {
		this.cambiarModo = cambiarModo;
	}

	public JButton getCerrarSesion() {
		return cerrarSesion;
	}

	public void setCerrarSesion(JButton cerrarSesion) {
		this.cerrarSesion = cerrarSesion;
	}
	

}
