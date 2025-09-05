package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.Producto;
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

		for (Producto producto : mf.getPrDAO().getLista()) {
			vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
					producto.getId(), this);
		}

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
					else {
						JOptionPane.showMessageDialog(vp, "usuario no existe");
						break mainloop;
					}
				}
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
		default:
			break;
		}
	}

}
