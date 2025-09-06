package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.view.*;

public class Controlador implements ActionListener {

	private VentanaPrincipal vp;
	private ModelFacade mf;

	public Controlador() {
		mf = new ModelFacade();
		vp = new VentanaPrincipal();
	}

	public void runGUI() {
		vp.setVisible(true);
		agregarOyentes();
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

		agregarProductos();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String boton = e.getActionCommand();

		if (boton.contains("Producto_")) {
			JOptionPane.showMessageDialog(vp, boton);
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
				for (Usuario usuario : mf.getUsDAO().getLista()) {
					if (usu.equals(usuario.getNickname()) && contra.equals(usuario.getContraseña())) {
						JOptionPane.showMessageDialog(vp, "inicio correcto");
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
				JOptionPane.showMessageDialog(vp, "registreo ok");
				vp.getMp().mostrarPanel("com");
				break mainloop;
			}
			break;
		case "Boton Cambiar Modo Compra":
			vp.getMp().mostrarPanel("com");
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

}
