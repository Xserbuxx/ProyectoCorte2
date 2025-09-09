package co.edu.unbosque.view;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class ManejarPanel extends JPanel{
	
	private CardLayout cl;
	private InicioSesion vis;
	private Registrarse reg;
	private Compra com;
	private Venta ven;
	private ProductoInfoPanel pip;
	private Carritos car;
	private AgregarACarrito aca;
	private CrearCarrito crc;
	private Factura fac;
	
	public ManejarPanel() {
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		
		cl = new CardLayout();
		this.setLayout(cl);
		
		vis = new InicioSesion();
		reg = new Registrarse();
		com = new Compra();
		ven = new Venta();
		pip = new ProductoInfoPanel();
		car = new Carritos();
		aca = new AgregarACarrito();
		crc = new CrearCarrito();
		fac = new Factura();
		
		this.add(vis, "vis");
		this.add(reg, "reg");
		this.add(com, "com");
		this.add(ven, "ven");
		this.add(pip, "pip");
		this.add(car, "car");
		this.add(fac, "fac");
		
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

	public Compra getCom() {
		return com;
	}

	public void setCom(Compra com) {
		this.com = com;
	}

	public Venta getVen() {
		return ven;
	}

	public void setVen(Venta ven) {
		this.ven = ven;
	}

	public ProductoInfoPanel getPip() {
		return pip;
	}

	public void setPip(ProductoInfoPanel pip) {
		this.pip = pip;
	}

	public Carritos getCar() {
		return car;
	}

	public void setCar(Carritos car) {
		this.car = car;
	}

	public AgregarACarrito getAca() {
		return aca;
	}

	public void setAca(AgregarACarrito aca) {
		this.aca = aca;
	}

	public CrearCarrito getCrc() {
		return crc;
	}

	public void setCrc(CrearCarrito crc) {
		this.crc = crc;
	}

	public Factura getFac() {
		return fac;
	}

	public void setFac(Factura fac) {
		this.fac = fac;
	}
	
}
