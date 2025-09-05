package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Compra extends JPanel {

	private JComboBox<String> Categorias;
	private JScrollPane scroll;
	private JPanel panelProductos;
	private JButton cambiarModo;

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
		cambiarModo.setBounds(850, 25, 250, 50);
		cambiarModo.setFont(new Font("Arial", Font.BOLD, 20));
		cambiarModo.setBackground(new Color(52,131,250));
		cambiarModo.setForeground(Color.WHITE);
		cambiarModo.setFocusPainted(false);

		String[] cate = { "Todo", "Belleza", "Deportes", "Hogar", "Juguetes", "Libros", "Mascotas", "Musica", "Ropa",
				"Tecnologia", "Vehiculos" };
		Categorias = new JComboBox<>(cate);
		Categorias.setBounds(320, 41, 200, 20);
		Categorias.setBackground(Color.YELLOW);

		panelProductos = new JPanel();
		panelProductos.setLayout(new BoxLayout(panelProductos, BoxLayout.X_AXIS));

		scroll = new JScrollPane(panelProductos, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		scroll.setBounds(0, 100, 1265, 583);

		crearLabel("Categoria:", 200, 0, 100, 100, Color.BLACK, 20);
		
		this.add(cambiarModo);
		this.add(scroll);
		this.add(Categorias);
		this.add(arriba);
	}

	private void crearLabel(String texto, int x, int y, int ancho, int alto, Color color, int tamañoTexto) {
		JLabel label = new JLabel(texto);
		label.setBounds(x, y, ancho, alto);
		label.setForeground(color);
		label.setFont(new Font("Arial", Font.BOLD, tamañoTexto));
		this.add(label);
	}
	
	public void actualizarCompra(Venta ven) {
		if (ven.getPp() != null) {
			for (ProductoPanel panel : ven.getPp()) {
				panelProductos.add(panel);
			}
		}
	}

	public JComboBox<String> getCategorias() {
		return Categorias;
	}

	public void setCategorias(JComboBox<String> categorias) {
		Categorias = categorias;
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
	

}
