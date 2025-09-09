package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import co.edu.unbosque.model.*;
import co.edu.unbosque.view.*;

public class Controlador implements ActionListener {

	private VentanaPrincipal vp;
	private ModelFacade mf;
	private String usuarioActual;
	private Producto protemp;
	private Carrito carritoTemp;

	public Controlador() {
		mf = new ModelFacade();
		vp = new VentanaPrincipal();
	}

	public void runGUI() {
		vp.setVisible(true);
		agregarOyentes();
		// cambiar \/
		vp.getMp().getCom().mostrarScroll();
	}

	private void agregarOyentes() {

		vp.getMp().getVis().getBotonRegistrarse().addActionListener(this);
		vp.getMp().getVis().getBotonRegistrarse().setActionCommand("Boton Registrarse");

		vp.getMp().getReg().getBotonInicioSesion().addActionListener(this);
		vp.getMp().getReg().getBotonInicioSesion().setActionCommand("Boton Iniciar Sesion");

		vp.getMp().getVis().getBotonInicio().addActionListener(this);
		vp.getMp().getVis().getBotonInicio().setActionCommand("Boton Inicio De Sesion");

		vp.getMp().getReg().getBotonRegistro().addActionListener(this);
		vp.getMp().getReg().getBotonRegistro().setActionCommand("Boton Registro");

		vp.getMp().getCom().getCambiarModo().addActionListener(this);
		vp.getMp().getCom().getCambiarModo().setActionCommand("Boton Cambiar Modo Venta");

		vp.getMp().getVen().getCambiarModo().addActionListener(this);
		vp.getMp().getVen().getCambiarModo().setActionCommand("Boton Cambiar Modo Compra");

		vp.getMp().getVen().getCerrarSesion().addActionListener(this);
		vp.getMp().getVen().getCerrarSesion().setActionCommand("Boton Cerrar Sesion");

		vp.getMp().getCom().getCerrarSesion().addActionListener(this);
		vp.getMp().getCom().getCerrarSesion().setActionCommand("Boton Cerrar Sesion");

		vp.getMp().getVen().getCategorias().addActionListener(this);
		vp.getMp().getVen().getCategorias().setActionCommand("ComboBox_vender");

		vp.getMp().getVen().getRegistrarProducto().addActionListener(this);
		vp.getMp().getVen().getRegistrarProducto().setActionCommand("Boton Registrar Producto");

		vp.getMp().getPip().getVolver().addActionListener(this);
		vp.getMp().getPip().getVolver().setActionCommand("Boton Cambiar Modo Compra");
		;

		vp.getMp().getPip().getAgregarCarrito().addActionListener(this);
		vp.getMp().getPip().getAgregarCarrito().setActionCommand("Boton Agregar Carrito");

		vp.getMp().getCar().getVolver().addActionListener(this);
		vp.getMp().getCar().getVolver().setActionCommand("Boton Cambiar Modo Compra");

		vp.getMp().getCom().getCarritos().addActionListener(this);
		vp.getMp().getCom().getCarritos().setActionCommand("Boton Carritos");

		vp.getMp().getCar().getCrearCarrito().addActionListener(this);
		vp.getMp().getCar().getCrearCarrito().setActionCommand("Boton Crear Carrito");

		vp.getMp().getCrc().getVolver().addActionListener(this);
		vp.getMp().getCrc().getVolver().setActionCommand("Boton Volver CRC");

		vp.getMp().getCrc().getCrearCarrito().addActionListener(this);
		vp.getMp().getCrc().getCrearCarrito().setActionCommand("Boton Crear Carrito CRC");

		vp.getMp().getAca().getVolver().addActionListener(this);
		vp.getMp().getAca().getVolver().setActionCommand("Boton Volver ACA");

		vp.getMp().getCar().getFiltrar().addActionListener(this);
		vp.getMp().getCar().getFiltrar().setActionCommand("Boton Filtrar");

		vp.getMp().getFac().getVolver().addActionListener(this);
		vp.getMp().getFac().getVolver().setActionCommand("Boton Volver FAC");

		agregarProductos();

	}

	private float total = 0;

	@Override
	public void actionPerformed(ActionEvent e) {
		String boton = e.getActionCommand();

		if (boton.contains("Producto_")) {
			vp.getMp().getPip().limpiarLabels();
			vp.getMp().mostrarPanel("pip");
			int id = Integer.parseInt(boton.split("_")[1]);
			Producto producto = encontrarProducto(id);
			String atributo1 = producto.toString().split(";")[6];
			String atributo2 = producto.toString().split(";")[7];

			vp.getMp().getPip().mostrarProductoInfo(producto.getPrecio(), producto.getNombre(),
					producto.getDescripcion(), producto.getUnidades(), producto.getRutaFoto(), atributo1, atributo2);
		}

		if (boton.contains("CarritoSele-")) {
			JOptionPane.showMessageDialog(vp, boton.split("-")[1]);

			encontrarCarritoAca(boton.split("-")[1]);

			String id = "";

			for (Producto producto : encontrarCarritoCar(boton.split("-")[1]).getProductos()) {
				id += producto.getId() + "\n";
			}

			mf.escribir("Carrito_" + boton.split("-")[1] + ".csv", id);
		}

		if (boton.contains("CarritoCom-")) {
			encontrarCarritoCar(boton.split("-")[1]);

			mf.getCaDAO().getLista().forEach((carrito) -> {
				if (carrito == carritoTemp) {
					carrito.getProductos().removeAll(carrito.getProductos());
				}
			});

			String[] ids = mf.getCaDAO().devolverIDS("Carrito_" + boton.split("-")[1] + ".csv").split(";");

			for (int i = 0; i < ids.length; i++) {
				if (!ids[i].equals("")) {
					mf.getCaDAO().LeerProductos(boton.split("-")[1], encontrarProducto(Integer.parseInt(ids[i])));
				}
			}

			vp.getMp().getCar().add(vp.getMp().getFac());
			vp.getMp().getFac().setEnabled(true);
			vp.getMp().getFac().setVisible(true);
			vp.getMp().getCar().getVolver().setEnabled(false);
			vp.getMp().getCar().getCrearCarrito().setEnabled(false);
			vp.getMp().getCar().getFiltro().setEnabled(false);
			vp.getMp().getCar().getFiltrar().setEnabled(false);
			vp.getMp().getCar().limpiarBotones();
			vp.getMp().getCar().setComponentZOrder(vp.getMp().getFac(), 0);

			total = 0;

			vp.getMp().getFac().getPanelProductos().removeAll();
			mf.getCaDAO().getLista().forEach((carrito) -> {
				if (carrito.getNombre().equals(boton.split("-")[1])) {
					carrito.getProductos().forEach((producto) -> {
						vp.getMp().getFac().mostrarProductos(producto.getNombre(), producto.getPrecio(),
								producto.getRutaFoto());
						total += producto.getPrecio();
					});
				}
			});

			vp.getMp().getFac().mostrarTotal(total + "");
			SwingUtilities.invokeLater(() -> {
				vp.getMp().getFac().getScroll().revalidate();
				vp.getMp().getFac().getScroll().repaint();
				vp.getMp().getCar().revalidate();
				vp.getMp().getCar().repaint();
			});

		}

		switch (boton) {
		case "Boton Registrarse":
			vp.getMp().mostrarPanel("reg");
			vp.revalidate();
			vp.repaint();
			break;

		case "Boton Iniciar Sesion":
			vp.getMp().mostrarPanel("vis");
			vp.revalidate();
			vp.repaint();
			break;

		case "Boton Inicio De Sesion":
			mainloop: while (true) {
				String usu = vp.getMp().getVis().getUsuario().getText();
				String contra = vp.getMp().getVis().getContraseña().getText();
				// cambiar joption pane por exception
				if (usu == null || contra == null) {
					JOptionPane.showMessageDialog(vp, "Digite un usuario o contraseña");
					break mainloop;
				}
				for (Usuario usuario : mf.getUsDAO().getLista()) {
					if (usu.equals(usuario.getNickname()) && contra.equals(usuario.getContraseña())) {
						usuarioActual = usuario.getNickname();
						vp.getMp().mostrarPanel("com");
						break mainloop;

					}
				}

				JOptionPane.showMessageDialog(vp, "usuario no existe");
				break mainloop;
			}
			break;
		case "Boton Registro":
			mainloop: while (true) {
				String usu = vp.getMp().getReg().getUsuario().getText();
				String contra = vp.getMp().getReg().getContraseña().getText();
				// cambiar joption pane por exception
				for (Usuario usuario : mf.getUsDAO().getLista()) {
					if (usu.equals(usuario.getNickname())) {
						JOptionPane.showMessageDialog(vp, "usuario ya existe");
						break mainloop;
					}
				}

				mf.getUsDAO().crear(new Usuario(usu, contra));
				usuarioActual = usu;
				vp.getMp().mostrarPanel("com");
				break mainloop;
			}
			break;
		case "Boton Cambiar Modo Compra":
			vp.getMp().getCom().limpiarProductos();
			agregarProductos();
			vp.getMp().mostrarPanel("com");
			vp.getMp().getAca().setEnabled(false);
			vp.getMp().getAca().setVisible(false);
			vp.getMp().getCrc().setVisible(false);
			vp.getMp().getCrc().setEnabled(false);
			vp.getMp().getCar().getCrearCarrito().setEnabled(true);
			vp.revalidate();
			vp.repaint();
			break;
		case "Boton Cambiar Modo Venta":
			vp.getMp().mostrarPanel("ven");
			vp.revalidate();
			vp.repaint();
			break;
		case "Boton Cerrar Sesion":
			vp.getMp().mostrarPanel("vis");
			vp.getMp().getVis().getUsuario().setText("");
			vp.getMp().getVis().getContraseña().setText("");
			vp.getMp().getReg().getUsuario().setText("");
			vp.getMp().getReg().getContraseña().setText("");
			break;
		case "ComboBox_vender":

			///////////////////////////////////////////////////////////////////////////////

			String selec = (String) vp.getMp().getVen().getCategorias().getSelectedItem();

			switch (selec) {

			case "Seleccione":
				vp.getMp().getVen().limpiarLabels();
				vp.getMp().getVen().limpiarCampos();
				break;

			case "Belleza":
				vp.getMp().getVen().limpiarLabels();
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().iniciarLabels();
				vp.getMp().getVen().mostrarBelleza();
				break;

			case "Deportes":
				vp.getMp().getVen().limpiarLabels();
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().iniciarLabels();
				vp.getMp().getVen().mostrarDeportes();
				break;

			case "Hogar":
				vp.getMp().getVen().limpiarLabels();
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().iniciarLabels();
				vp.getMp().getVen().mostrarHogar();
				break;

			case "Juguetes":
				vp.getMp().getVen().limpiarLabels();
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().iniciarLabels();
				vp.getMp().getVen().mostrarJuguetes();
				break;

			case "Libros":
				vp.getMp().getVen().limpiarLabels();
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().iniciarLabels();
				vp.getMp().getVen().mostrarLibros();
				break;

			case "Mascotas":
				vp.getMp().getVen().limpiarLabels();
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().iniciarLabels();
				vp.getMp().getVen().mostrarMascotas();
				break;

			case "Musica":
				vp.getMp().getVen().limpiarLabels();
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().iniciarLabels();
				vp.getMp().getVen().mostrarMusica();
				break;

			case "Ropa":
				vp.getMp().getVen().limpiarLabels();
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().iniciarLabels();
				vp.getMp().getVen().mostrarRopa();
				break;

			case "Tecnologia":
				vp.getMp().getVen().limpiarLabels();
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().iniciarLabels();
				vp.getMp().getVen().mostrarTecnologia();
				break;

			case "Vehiculos":
				vp.getMp().getVen().limpiarLabels();
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().iniciarLabels();
				vp.getMp().getVen().mostrarVehiculos();
				break;

			default:
				break;
			}

			//////////////////////////////////////////////////////////////////////////////

			vp.revalidate();
			vp.repaint();

			break;

		case "Boton Registrar Producto":

			/////////////////////////////////////////////////////////////////////////////////

			String selecc = (String) vp.getMp().getVen().getCategorias().getSelectedItem();

			switch (selecc) {

			case "Seleccione":

				JOptionPane.showMessageDialog(vp, "Debe ingresar una categoria");

				break;

			case "Belleza":
				mf.getBeDAO().crear(new Belleza(Float.parseFloat(vp.getMp().getVen().getPrecio().getText()),
						vp.getMp().getVen().getNombre().getText(), vp.getMp().getVen().getDescripcion().getText(),
						Integer.parseInt(vp.getMp().getVen().getUnidades().getText()),
						vp.getMp().getVen().getRutaFoto().getText(), vp.getMp().getVen().getTipoProducto().getText(),
						vp.getMp().getVen().getFechaExpiracion().getText(),
						Integer.parseInt(vp.getMp().getVen().getId().getText())));
				break;

			case "Deportes":
				mf.getDeDAO().crear(new Deportes(Float.parseFloat(vp.getMp().getVen().getPrecio().getText()),
						vp.getMp().getVen().getNombre().getText(), vp.getMp().getVen().getDescripcion().getText(),
						Integer.parseInt(vp.getMp().getVen().getUnidades().getText()),
						vp.getMp().getVen().getRutaFoto().getText(), vp.getMp().getVen().getTipoDeporte().getText(),
						vp.getMp().getVen().getMaterialDe().getText(),
						Integer.parseInt(vp.getMp().getVen().getId().getText())));
				break;

			case "Hogar":
				mf.getHoDAO().crear(new Hogar(Float.parseFloat(vp.getMp().getVen().getPrecio().getText()),
						vp.getMp().getVen().getNombre().getText(), vp.getMp().getVen().getDescripcion().getText(),
						Integer.parseInt(vp.getMp().getVen().getUnidades().getText()),
						vp.getMp().getVen().getRutaFoto().getText(), vp.getMp().getVen().getTipoMaterial().getText(),
						vp.getMp().getVen().getDimensiones().getText(),
						Integer.parseInt(vp.getMp().getVen().getId().getText())));
				break;

			case "Juguetes":
				mf.getJuDAO().crear(new Juguetes(Float.parseFloat(vp.getMp().getVen().getPrecio().getText()),
						vp.getMp().getVen().getNombre().getText(), vp.getMp().getVen().getDescripcion().getText(),
						Integer.parseInt(vp.getMp().getVen().getUnidades().getText()),
						vp.getMp().getVen().getRutaFoto().getText(),
						Integer.parseInt(vp.getMp().getVen().getEdadRecomendada().getText()),
						vp.getMp().getVen().getMaterialJu().getText(),
						Integer.parseInt(vp.getMp().getVen().getId().getText())));
				break;

			case "Libros":
				mf.getLiDAO().crear(new Libros(Float.parseFloat(vp.getMp().getVen().getPrecio().getText()),
						vp.getMp().getVen().getNombre().getText(), vp.getMp().getVen().getDescripcion().getText(),
						Integer.parseInt(vp.getMp().getVen().getUnidades().getText()),
						vp.getMp().getVen().getRutaFoto().getText(), vp.getMp().getVen().getAutor().getText(),
						Integer.parseInt(vp.getMp().getVen().getNumeroPaginas().getText()),
						Integer.parseInt(vp.getMp().getVen().getId().getText())));
				break;

			case "Mascotas":
				mf.getMaDAO().crear(new Mascotas(Float.parseFloat(vp.getMp().getVen().getPrecio().getText()),
						vp.getMp().getVen().getNombre().getText(), vp.getMp().getVen().getDescripcion().getText(),
						Integer.parseInt(vp.getMp().getVen().getUnidades().getText()),
						vp.getMp().getVen().getRutaFoto().getText(), vp.getMp().getVen().getTipoAnimal().getText(),
						vp.getMp().getVen().getTamaño().getText(),
						Integer.parseInt(vp.getMp().getVen().getId().getText())));
				break;

			case "Musica":
				mf.getMuDAO().crear(new Musica(Float.parseFloat(vp.getMp().getVen().getPrecio().getText()),
						vp.getMp().getVen().getNombre().getText(), vp.getMp().getVen().getDescripcion().getText(),
						Integer.parseInt(vp.getMp().getVen().getUnidades().getText()),
						vp.getMp().getVen().getRutaFoto().getText(), vp.getMp().getVen().getFormato().getText(),
						vp.getMp().getVen().getArtista().getText(),
						Integer.parseInt(vp.getMp().getVen().getId().getText())));
				break;

			case "Ropa":
				mf.getRoDAO().crear(new Ropa(Float.parseFloat(vp.getMp().getVen().getPrecio().getText()),
						vp.getMp().getVen().getNombre().getText(), vp.getMp().getVen().getDescripcion().getText(),
						Integer.parseInt(vp.getMp().getVen().getUnidades().getText()),
						vp.getMp().getVen().getRutaFoto().getText(), vp.getMp().getVen().getTalla().getText(),
						vp.getMp().getVen().getColor().getText(),
						Integer.parseInt(vp.getMp().getVen().getId().getText())));
				break;

			case "Tecnologia":
				mf.getTeDAO().crear(new Tecnologia(Float.parseFloat(vp.getMp().getVen().getPrecio().getText()),
						vp.getMp().getVen().getNombre().getText(), vp.getMp().getVen().getDescripcion().getText(),
						Integer.parseInt(vp.getMp().getVen().getUnidades().getText()),
						vp.getMp().getVen().getRutaFoto().getText(), vp.getMp().getVen().getMarca().getText(),
						vp.getMp().getVen().getModeloTec().getText(),
						Integer.parseInt(vp.getMp().getVen().getId().getText())));
				break;

			case "Vehiculos":
				mf.getVeDAO().crear(new Vehiculos(Float.parseFloat(vp.getMp().getVen().getPrecio().getText()),
						vp.getMp().getVen().getNombre().getText(), vp.getMp().getVen().getDescripcion().getText(),
						Integer.parseInt(vp.getMp().getVen().getUnidades().getText()),
						vp.getMp().getVen().getRutaFoto().getText(), vp.getMp().getVen().getAño().getText(),
						vp.getMp().getVen().getModeloVE().getText(),
						Integer.parseInt(vp.getMp().getVen().getId().getText())));
				break;

			default:
				break;
			}

			///////////////////////////////////////////////////////////////////

			vp.revalidate();
			vp.repaint();

			break;

		case "Boton Agregar Carrito":
			vp.getMp().getAca().setVisible(true);
			vp.getMp().getAca().setEnabled(true);
			vp.getMp().getPip().add(vp.getMp().getAca());

			vp.getMp().getPip().getVolver().setEnabled(false);
			vp.getMp().getPip().getAgregarCarrito().setEnabled(false);

			vp.getMp().getPip().setComponentZOrder(vp.getMp().getAca(), 0);

			agregarCarritosPip();

			SwingUtilities.invokeLater(() -> {
				vp.getMp().getPip().revalidate();
				vp.getMp().getPip().repaint();
			});

			break;
		case "Boton Carritos":
			vp.getMp().mostrarPanel("car");
			agregarCarritos();
			break;
		case "Boton Crear Carrito":

			vp.getMp().getCrc().setVisible(true);
			vp.getMp().getCrc().setEnabled(true);
			vp.getMp().getCar().add(vp.getMp().getCrc());

			vp.getMp().getCar().getVolver().setEnabled(false);
			vp.getMp().getCar().getCrearCarrito().setEnabled(false);
			vp.getMp().getCar().limpiarBotones();

			vp.getMp().getCar().setComponentZOrder(vp.getMp().getCrc(), 0);

			SwingUtilities.invokeLater(() -> {
				vp.getMp().getCar().revalidate();
				vp.getMp().getCar().repaint();
			});
			break;

		case "Boton Volver CRC":
			vp.getMp().getCar().remove(vp.getMp().getCrc());

			vp.getMp().getCar().getVolver().setEnabled(true);
			vp.getMp().getCar().getCrearCarrito().setEnabled(true);

			agregarCarritos();

			SwingUtilities.invokeLater(() -> {
				vp.getMp().getCar().revalidate();
				vp.getMp().getCar().repaint();
			});
			break;
		case "Boton Crear Carrito CRC":
			mf.getCaDAO().crear(
					new Carrito(vp.getMp().getCrc().getNombreC().getText() + "_" + usuarioActual, new ArrayList<>()));

			vp.getMp().getCar().remove(vp.getMp().getCrc());

			vp.getMp().getCar().getVolver().setEnabled(true);
			vp.getMp().getCar().getCrearCarrito().setEnabled(true);

			agregarCarritos();

			SwingUtilities.invokeLater(() -> {
				vp.getMp().getCar().revalidate();
				vp.getMp().getCar().repaint();
			});
			break;
		case "Boton Volver ACA":
			vp.getMp().getAca().setVisible(false);
			vp.getMp().getAca().setEnabled(false);

			vp.getMp().getPip().remove(vp.getMp().getAca());

			vp.getMp().getPip().getVolver().setEnabled(true);
			vp.getMp().getPip().getAgregarCarrito().setEnabled(true);

			SwingUtilities.invokeLater(() -> {
				vp.getMp().getPip().revalidate();
				vp.getMp().getPip().repaint();
			});

			break;
		case "Boton Filtrar":
			vp.getMp().getCar().getPanelProductos().removeAll();
			mf.getCaDAO().getLista().forEach((carrito) -> {
				if (carrito.getNombre().split("_")[1].equals(usuarioActual)
						&& carrito.getNombre().split("_")[0].contains(vp.getMp().getCar().getFiltro().getText())) {
					vp.getMp().getCar().mostrarProductos(carrito.getNombre(), this);
				}
			});

			vp.getMp().getCar().getScroll().revalidate();
			vp.getMp().getCar().getScroll().repaint();
			break;
		case "Boton Volver FAC":
			vp.getMp().getFac().setVisible(false);
			vp.getMp().getFac().setEnabled(false);
			vp.getMp().getCar().remove(vp.getMp().getFac());

			vp.getMp().getCar().getPanelProductos().removeAll();
			mf.getCaDAO().getLista().forEach((carrito) -> {
				if (carrito.getNombre().split("_")[1].equals(usuarioActual)
						&& carrito.getNombre().split("_")[0].contains(vp.getMp().getCar().getFiltro().getText())) {
					vp.getMp().getCar().mostrarProductos(carrito.getNombre(), this);
				}
			});

			vp.getMp().getCar().getVolver().setEnabled(true);
			vp.getMp().getCar().getCrearCarrito().setEnabled(true);
			vp.getMp().getCar().getFiltro().setEnabled(true);
			vp.getMp().getCar().getFiltrar().setEnabled(true);

			vp.getMp().getCar().getScroll().revalidate();
			vp.getMp().getCar().getScroll().repaint();
			vp.getMp().getFac().revalidate();
			vp.getMp().getFac().repaint();
			break;
		default:
			break;
		}

	}

	private void agregarProductos() {
		mf.getBeDAO().getLista().forEach((belleza) -> {
			vp.getMp().getCom().mostrarProductos(belleza.getNombre(), belleza.getPrecio(), belleza.getRutaFoto(),
					belleza.getId(), this);
		});

		mf.getDeDAO().getLista().forEach((deporte) -> {
			vp.getMp().getCom().mostrarProductos(deporte.getNombre(), deporte.getPrecio(), deporte.getRutaFoto(),
					deporte.getId(), this);
		});

		mf.getHoDAO().getLista().forEach((hogar) -> {
			vp.getMp().getCom().mostrarProductos(hogar.getNombre(), hogar.getPrecio(), hogar.getRutaFoto(),
					hogar.getId(), this);
		});

		mf.getJuDAO().getLista().forEach((juguete) -> {
			vp.getMp().getCom().mostrarProductos(juguete.getNombre(), juguete.getPrecio(), juguete.getRutaFoto(),
					juguete.getId(), this);
		});

		mf.getLiDAO().getLista().forEach((libro) -> {
			vp.getMp().getCom().mostrarProductos(libro.getNombre(), libro.getPrecio(), libro.getRutaFoto(),
					libro.getId(), this);
		});

		mf.getMaDAO().getLista().forEach((mascota) -> {
			vp.getMp().getCom().mostrarProductos(mascota.getNombre(), mascota.getPrecio(), mascota.getRutaFoto(),
					mascota.getId(), this);
		});

		mf.getMuDAO().getLista().forEach((musica) -> {
			vp.getMp().getCom().mostrarProductos(musica.getNombre(), musica.getPrecio(), musica.getRutaFoto(),
					musica.getId(), this);
		});

		mf.getRoDAO().getLista().forEach((ropa) -> {
			vp.getMp().getCom().mostrarProductos(ropa.getNombre(), ropa.getPrecio(), ropa.getRutaFoto(), ropa.getId(),
					this);
		});

		mf.getTeDAO().getLista().forEach((tecnologia) -> {
			vp.getMp().getCom().mostrarProductos(tecnologia.getNombre(), tecnologia.getPrecio(),
					tecnologia.getRutaFoto(), tecnologia.getId(), this);
		});

		mf.getVeDAO().getLista().forEach((vehiculo) -> {
			vp.getMp().getCom().mostrarProductos(vehiculo.getNombre(), vehiculo.getPrecio(), vehiculo.getRutaFoto(),
					vehiculo.getId(), this);
		});
	}

	private void agregarCarritos() {
		vp.getMp().getCar().getPanelProductos().removeAll();
		mf.getCaDAO().getLista().forEach((carrito) -> {
			if (carrito.getNombre().split("_")[1].equals(usuarioActual)) {
				vp.getMp().getCar().mostrarProductos(carrito.getNombre(), this);
			}
		});

		vp.getMp().getCar().getScroll().revalidate();
		vp.getMp().getCar().getScroll().repaint();
	}

	private void agregarCarritosPip() {
		vp.getMp().getAca().getPanelProductos().removeAll();
		mf.getCaDAO().getLista().forEach((carrito) -> {
			if (carrito.getNombre().split("_")[1].equals(usuarioActual)) {
				vp.getMp().getAca().mostrarProductos(carrito.getNombre(), this);
			}
		});

		vp.getMp().getAca().getScroll().revalidate();
		vp.getMp().getAca().getScroll().repaint();

	}

	private Producto encontrarProducto(int id) {
		mf.agregarProductos();
		mf.getProductos().forEach((producto) -> {
			if (producto.getId() == id) {
				protemp = new Producto();
				protemp = producto;
			}
		});
		return protemp;
	}

	private void encontrarCarritoAca(String nombre) {
		mf.getCaDAO().getLista().forEach((carrito) -> {
			if (carrito.getNombre().equals(nombre)) {
				carrito.getProductos().add(protemp);
			}
		});
	}

	private Carrito encontrarCarritoCar(String nombre) {
		mf.getCaDAO().getLista().forEach((carrito) -> {
			if (carrito.getNombre().equals(nombre)) {
				carritoTemp = new Carrito();
				carritoTemp = carrito;
			}
		});

		return carritoTemp;
	}

}
