package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Compra extends JPanel {

	private JComboBox<String> Categorias;
	private JScrollPane scroll;
	private JPanel panelProductos;

	public Compra() {
		iniciarComponente();
	}

	private void iniciarComponente() {
		this.setBounds(0, 0, 1280, 720);
		this.setLayout(null);

		JPanel arriba = new JPanel();
		arriba.setBounds(0, 0, 1280, 100);
		arriba.setBackground(Color.YELLOW);

		String[] cate = { "Todo", "Belleza", "Deportes", "Hogar", "Juguetes", "Libros", "Mascotas", "Musica", "Ropa",
				"Tecnologia", "Vehiculos" };
		Categorias = new JComboBox<>(cate);
		Categorias.setBounds(320, 41, 200, 20);
		Categorias.setBackground(Color.YELLOW);

		panelProductos = new JPanel();
		panelProductos.setLayout(new BoxLayout(panelProductos, BoxLayout.X_AXIS));

		crearProducto("zazaqa zaz z qaz cde c drvft gy bhybyh bvtf cd txctf vg bcdr xdr ", "1.000.000", "prueba.png");
		crearProducto("", "", "prueba.png");
		crearProducto("", "", "prueba.png");
		crearProducto("", "", "prueba.png");
		crearProducto("", "", "prueba.png");
		crearProducto("", "", "prueba.png");

		scroll = new JScrollPane(panelProductos, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		scroll.setBounds(0, 100, 1265, 583);

		crearLabel("Categoria:", 200, 0, 100, 100, Color.BLACK, 20);

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

	public void crearProducto(String nombre, String precio, String ruta) {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(300, 470));
		panel.setBackground(Color.WHITE);
		panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		panel.setLayout(null);

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

		panel.add(icono);
		panel.add(lbnombre);
		panel.add(lbprecio);

		panelProductos.add(panel);

	}
}
