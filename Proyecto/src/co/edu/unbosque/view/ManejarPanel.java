package co.edu.unbosque.view;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class ManejarPanel extends JPanel{
	
	private CardLayout cl;
	private InicioSesion vis;
	private Registrarse reg;
	
	public ManejarPanel() {
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		
		cl = new CardLayout();
		this.setLayout(cl);
		
		vis = new InicioSesion();
		reg = new Registrarse();
		
		this.add(vis, "vis");
		this.add(reg, "reg");
		
	}
	
	public void mostrarPanel(String nombre) {
		cl.show(this, nombre);
	}

	public CardLayout getCl() {
		return cl;
	}

	public void setCl(CardLayout cl) {
		this.cl = cl;
	}

	public InicioSesion getVis() {
		return vis;
	}

	public void setVis(InicioSesion vis) {
		this.vis = vis;
	}

	public Registrarse getReg() {
		return reg;
	}

	public void setReg(Registrarse reg) {
		this.reg = reg;
	}
	
		
}
