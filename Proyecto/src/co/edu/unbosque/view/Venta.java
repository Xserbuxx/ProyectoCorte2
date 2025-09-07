package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Venta extends JPanel {

	private JComboBox<String> categorias;

	private JButton cambiarModo;
	private JButton cerrarSesion;
	private JTextField precio;
	private JTextField nombre;
	private JTextField descripcion;
	private JTextField unidades;
	private JTextField rutaFoto;
	private JTextField id;
	private JButton registrarProducto;

	// belleza
	private JTextField tipoProducto;
	private JTextField fechaExpiracion;
	// deportes
	private JTextField tipoDeporte;
	private JTextField materialDe;
	// hogar
	private JTextField tipoMaterial;
	private JTextField dimensiones;
	// juguetes
	private JTextField edadRecomendada;
	private JTextField materialJu;
	// libros
	private JTextField autor;
	private JTextField numeroPaginas;
	// mascotas
	private JTextField tipoAnimal;
	private JTextField tamaño;
	// musica
	private JTextField formato;
	private JTextField artista;
	// Ropa
	private JTextField talla;
	private JTextField color;
	// tecnologia
	private JTextField marca;
	private JTextField modeloTec;
	// vehiculo
	private JTextField año;
	private JTextField modeloVE;

	public Venta() {
		iniciarComponente();
	}

	private void iniciarComponente() {
		this.setBounds(0, 0, 1280, 720);
		this.setLayout(null);

		JPanel arriba = new JPanel();
		arriba.setBounds(0, 0, 1280, 100);
		arriba.setBackground(Color.YELLOW);

		cambiarModo = new JButton("Comprar");
		cambiarModo.setBounds(650, 25, 250, 50);
		cambiarModo.setFont(new Font("Arial", Font.BOLD, 20));
		cambiarModo.setBackground(new Color(52, 131, 250));
		cambiarModo.setForeground(Color.WHITE);
		cambiarModo.setFocusPainted(false);

		cerrarSesion = new JButton("Cerrar Sesion");
		cerrarSesion.setBounds(950, 25, 250, 50);
		cerrarSesion.setFont(new Font("Arial", Font.BOLD, 20));
		cerrarSesion.setBackground(Color.red.brighter());
		cerrarSesion.setForeground(Color.WHITE);
		cerrarSesion.setFocusPainted(false);
		
		registrarProducto = new JButton("Registrar Producto");
		registrarProducto.setBounds(480, 550, 300, 50);
		registrarProducto.setFont(new Font("Arial", Font.BOLD, 20));
		registrarProducto.setBackground(Color.red.brighter());
		registrarProducto.setForeground(Color.WHITE);
		registrarProducto.setFocusPainted(false);

		precio = new JTextField();
		precio.setBounds(100, 150, 380, 50);
		precio.setFont(new Font("Arial", Font.BOLD, 22));

		nombre = new JTextField();
		nombre.setBounds(100, 250, 380, 50);
		nombre.setFont(new Font("Arial", Font.BOLD, 22));

		descripcion = new JTextField();
		descripcion.setBounds(100, 350, 380, 50);
		descripcion.setFont(new Font("Arial", Font.BOLD, 22));

		unidades = new JTextField();
		unidades.setBounds(100, 450, 380, 50);
		unidades.setFont(new Font("Arial", Font.BOLD, 22));

		rutaFoto = new JTextField();
		rutaFoto.setBounds(780, 150, 380, 50);
		rutaFoto.setFont(new Font("Arial", Font.BOLD, 22));

		id = new JTextField();
		id.setBounds(780, 250, 380, 50);
		id.setFont(new Font("Arial", Font.BOLD, 22));

		String[] cate = { "Seleccione", "Belleza", "Deportes", "Hogar", "Juguetes", "Libros", "Mascotas", "Musica", "Ropa",
				"Tecnologia", "Vehiculos" };
		categorias = new JComboBox<>(cate);
		categorias.setBounds(320, 41, 200, 20);
		categorias.setBackground(Color.YELLOW);

		crearLabel("Categoria:", 200, 0, 100, 100, Color.BLACK, 20);
		
		this.add(registrarProducto);
		this.add(precio);
		this.add(nombre);
		this.add(descripcion);
		this.add(unidades);
		this.add(rutaFoto);
		this.add(id);
		this.add(cerrarSesion);
		this.add(cambiarModo);
		this.add(categorias);
		this.add(arriba);
	}

	public void mostrarBelleza() {
		tipoProducto = new JTextField();
		fechaExpiracion = new JTextField();

		tipoProducto.setBounds(780, 350, 380, 50);
		tipoProducto.setFont(new Font("Arial", Font.BOLD, 22));

		fechaExpiracion.setBounds(780, 450, 380, 50);
		fechaExpiracion.setFont(new Font("Arial", Font.BOLD, 22));

		crearLabel("tipo de producto:", 780, 275, 380, 100, Color.BLACK, 20);
		crearLabel("fecha de expiracion:", 780, 375, 380, 100, Color.BLACK, 20);

		this.add(tipoProducto);
		this.add(fechaExpiracion);

	}

	public void mostrarDeportes() {
		tipoDeporte = new JTextField();
		materialDe = new JTextField();

		tipoDeporte.setBounds(780, 350, 380, 50);
		tipoDeporte.setFont(new Font("Arial", Font.BOLD, 22));

		materialDe.setBounds(780, 450, 380, 50);
		materialDe.setFont(new Font("Arial", Font.BOLD, 22));

		crearLabel("tipo de deporte:", 780, 275, 380, 100, Color.BLACK, 20);
		crearLabel("material:", 780, 375, 380, 100, Color.BLACK, 20);

		this.add(tipoDeporte);
		this.add(materialDe);
	}

	public void mostrarHogar() {
		tipoMaterial = new JTextField();
		dimensiones = new JTextField();

		tipoMaterial.setBounds(780, 350, 380, 50);
		tipoMaterial.setFont(new Font("Arial", Font.BOLD, 22));

		dimensiones.setBounds(780, 450, 380, 50);
		dimensiones.setFont(new Font("Arial", Font.BOLD, 22));

		crearLabel("tipo de material:", 780, 275, 380, 100, Color.BLACK, 20);
		crearLabel("dimensiones:", 780, 375, 380, 100, Color.BLACK, 20);

		this.add(tipoMaterial);
		this.add(dimensiones);
	}

	public void mostrarJuguetes() {
		edadRecomendada = new JTextField();
		materialJu = new JTextField();

		edadRecomendada.setBounds(780, 350, 380, 50);
		edadRecomendada.setFont(new Font("Arial", Font.BOLD, 22));

		materialJu.setBounds(780, 450, 380, 50);
		materialJu.setFont(new Font("Arial", Font.BOLD, 22));

		crearLabel("edad recomendada:", 780, 275, 380, 100, Color.BLACK, 20);
		crearLabel("material:", 780, 375, 380, 100, Color.BLACK, 20);

		this.add(edadRecomendada);
		this.add(materialJu);
	}

	public void mostrarLibros() {
		autor = new JTextField();
		numeroPaginas = new JTextField();

		autor.setBounds(780, 350, 380, 50);
		autor.setFont(new Font("Arial", Font.BOLD, 22));

		numeroPaginas.setBounds(780, 450, 380, 50);
		numeroPaginas.setFont(new Font("Arial", Font.BOLD, 22));

		crearLabel("Autor:", 780, 275, 380, 100, Color.BLACK, 20);
		crearLabel("Numero de paginas:", 780, 375, 380, 100, Color.BLACK, 20);

		this.add(autor);
		this.add(numeroPaginas);
	}

	public void mostrarMascotas() {
		tipoAnimal = new JTextField();
		tamaño = new JTextField();

		tipoAnimal.setBounds(780, 350, 380, 50);
		tipoAnimal.setFont(new Font("Arial", Font.BOLD, 22));

		tamaño.setBounds(780, 450, 380, 50);
		tamaño.setFont(new Font("Arial", Font.BOLD, 22));

		crearLabel("tipo de mascota:", 780, 275, 380, 100, Color.BLACK, 20);
		crearLabel("tamaño:", 780, 375, 380, 100, Color.BLACK, 20);

		this.add(tipoAnimal);
		this.add(tamaño);
	}

	public void mostrarMusica() {
		formato = new JTextField();
		artista = new JTextField();

		formato.setBounds(780, 350, 380, 50);
		formato.setFont(new Font("Arial", Font.BOLD, 22));

		artista.setBounds(780, 450, 380, 50);
		artista.setFont(new Font("Arial", Font.BOLD, 22));

		crearLabel("artista:", 780, 275, 380, 100, Color.BLACK, 20);
		crearLabel("formato:", 780, 375, 380, 100, Color.BLACK, 20);

		this.add(formato);
		this.add(artista);
	}

	public void mostrarRopa() {
		talla = new JTextField();
		color = new JTextField();

		talla.setBounds(780, 350, 380, 50);
		talla.setFont(new Font("Arial", Font.BOLD, 22));

		color.setBounds(780, 450, 380, 50);
		color.setFont(new Font("Arial", Font.BOLD, 22));

		crearLabel("talla:", 780, 275, 380, 100, Color.BLACK, 20);
		crearLabel("color:", 780, 375, 380, 100, Color.BLACK, 20);

		this.add(talla);
		this.add(color);
	}

	public void mostrarTecnologia() {
		marca = new JTextField();
		modeloTec = new JTextField();

		marca.setBounds(780, 350, 380, 50);
		marca.setFont(new Font("Arial", Font.BOLD, 22));

		modeloTec.setBounds(780, 450, 380, 50);
		modeloTec.setFont(new Font("Arial", Font.BOLD, 22));

		crearLabel("marca:", 780, 275, 380, 100, Color.BLACK, 20);
		crearLabel("modelo:", 780, 375, 380, 100, Color.BLACK, 20);

		this.add(marca);
		this.add(modeloTec);
	}

	public void mostrarVehiculos() {
		año = new JTextField();
		modeloVE = new JTextField();

		año.setBounds(780, 350, 380, 50);
		año.setFont(new Font("Arial", Font.BOLD, 22));

		modeloVE.setBounds(780, 450, 380, 50);
		modeloVE.setFont(new Font("Arial", Font.BOLD, 22));

		crearLabel("año:", 780, 275, 380, 100, Color.BLACK, 20);
		crearLabel("modelo:", 780, 375, 380, 100, Color.BLACK, 20);

		this.add(año);
		this.add(modeloVE);
	}

	public void iniciarLabels() {
		crearLabel("Precio:", 100, 75, 100, 100, Color.BLACK, 20);
		crearLabel("Nombre:", 100, 175, 100, 100, Color.BLACK, 20);
		crearLabel("Descripcion:", 100, 275, 200, 100, Color.BLACK, 20);
		crearLabel("Unidades:", 100, 375, 100, 100, Color.BLACK, 20);
		crearLabel("rutaFoto:", 780, 75, 100, 100, Color.BLACK, 20);
		crearLabel("ID:", 780, 175, 100, 100, Color.BLACK, 20);
	}

	public void limpiarLabels() {
		for (Component comp : this.getComponents()) {
			if (comp instanceof JLabel && !((JLabel) comp).getText().equals("Categoria:")) {
				this.remove(comp);
			}
		}
		this.revalidate();
		this.repaint();

	}

	public void limpiarCampos() {
		try {
			this.remove(tipoProducto);
			this.remove(fechaExpiracion);
			this.remove(tipoDeporte);
			this.remove(materialDe);
			this.remove(tipoMaterial);
			this.remove(dimensiones);
			this.remove(edadRecomendada);
			this.remove(materialJu);
			this.remove(autor);
			this.remove(numeroPaginas);
			this.remove(tipoAnimal);
			this.remove(tamaño);
			this.remove(formato);
			this.remove(artista);
			this.remove(talla);
			this.remove(color);
			this.remove(marca);
			this.remove(modeloTec);
			this.remove(año);
			this.remove(modeloVE);
		} catch (Exception e) {

		}
	}

	private void crearLabel(String texto, int x, int y, int ancho, int alto, Color color, int tamañoTexto) {
		JLabel label = new JLabel(texto);
		label.setBounds(x, y, ancho, alto);
		label.setForeground(color);
		label.setFont(new Font("Arial", Font.BOLD, tamañoTexto));
		this.add(label);
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

	public JButton getRegistrarProducto() {
		return registrarProducto;
	}

	public void setRegistrarProducto(JButton registrarProducto) {
		this.registrarProducto = registrarProducto;
	}

	public JComboBox<String> getCategorias() {
		return categorias;
	}

	public void setCategorias(JComboBox<String> categorias) {
		this.categorias = categorias;
	}

	public JTextField getPrecio() {
		return precio;
	}

	public void setPrecio(JTextField precio) {
		this.precio = precio;
	}

	public JTextField getNombre() {
		return nombre;
	}

	public void setNombre(JTextField nombre) {
		this.nombre = nombre;
	}

	public JTextField getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(JTextField descripcion) {
		this.descripcion = descripcion;
	}

	public JTextField getUnidades() {
		return unidades;
	}

	public void setUnidades(JTextField unidades) {
		this.unidades = unidades;
	}

	public JTextField getRutaFoto() {
		return rutaFoto;
	}

	public void setRutaFoto(JTextField rutaFoto) {
		this.rutaFoto = rutaFoto;
	}

	public JTextField getId() {
		return id;
	}

	public void setId(JTextField id) {
		this.id = id;
	}

	public JTextField getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(JTextField tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public JTextField getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(JTextField fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public JTextField getTipoDeporte() {
		return tipoDeporte;
	}

	public void setTipoDeporte(JTextField tipoDeporte) {
		this.tipoDeporte = tipoDeporte;
	}

	public JTextField getMaterialDe() {
		return materialDe;
	}

	public void setMaterialDe(JTextField materialDe) {
		this.materialDe = materialDe;
	}

	public JTextField getTipoMaterial() {
		return tipoMaterial;
	}

	public void setTipoMaterial(JTextField tipoMaterial) {
		this.tipoMaterial = tipoMaterial;
	}

	public JTextField getDimensiones() {
		return dimensiones;
	}

	public void setDimensiones(JTextField dimensiones) {
		this.dimensiones = dimensiones;
	}

	public JTextField getEdadRecomendada() {
		return edadRecomendada;
	}

	public void setEdadRecomendada(JTextField edadRecomendada) {
		this.edadRecomendada = edadRecomendada;
	}

	public JTextField getMaterialJu() {
		return materialJu;
	}

	public void setMaterialJu(JTextField materialJu) {
		this.materialJu = materialJu;
	}

	public JTextField getAutor() {
		return autor;
	}

	public void setAutor(JTextField autor) {
		this.autor = autor;
	}

	public JTextField getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(JTextField numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public JTextField getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(JTextField tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	public JTextField getTamaño() {
		return tamaño;
	}

	public void setTamaño(JTextField tamaño) {
		this.tamaño = tamaño;
	}

	public JTextField getFormato() {
		return formato;
	}

	public void setFormato(JTextField formato) {
		this.formato = formato;
	}

	public JTextField getArtista() {
		return artista;
	}

	public void setArtista(JTextField artista) {
		this.artista = artista;
	}

	public JTextField getTalla() {
		return talla;
	}

	public void setTalla(JTextField talla) {
		this.talla = talla;
	}

	public JTextField getColor() {
		return color;
	}

	public void setColor(JTextField color) {
		this.color = color;
	}

	public JTextField getMarca() {
		return marca;
	}

	public void setMarca(JTextField marca) {
		this.marca = marca;
	}

	public JTextField getModeloTec() {
		return modeloTec;
	}

	public void setModeloTec(JTextField modeloTec) {
		this.modeloTec = modeloTec;
	}

	public JTextField getAño() {
		return año;
	}

	public void setAño(JTextField año) {
		this.año = año;
	}

	public JTextField getModeloVE() {
		return modeloVE;
	}

	public void setModeloVE(JTextField modeloVE) {
		this.modeloVE = modeloVE;
	}

}
