package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.*;

public class ModelFacade {

	private UsuariosDAO usDAO;
	private BellezaDAO beDAO;
	private DeportesDAO deDAO;
	private HogarDAO hoDAO;
	private JuguetesDAO juDAO;
	private LibrosDAO liDAO;
	private MascotasDAO maDAO;
	private MusicaDAO muDAO;
	private RopaDAO roDAO;
	private TecnologiaDAO teDAO;
	private VehiculosDAO veDAO;

	public ModelFacade() {
		usDAO = new UsuariosDAO();
		beDAO = new BellezaDAO();
		deDAO = new DeportesDAO();
		hoDAO = new HogarDAO();
		juDAO = new JuguetesDAO();
		liDAO = new LibrosDAO();
		maDAO = new MascotasDAO();
		muDAO = new MusicaDAO();
		roDAO = new RopaDAO();
		teDAO = new TecnologiaDAO();
		veDAO = new VehiculosDAO();
	}
	
	public UsuariosDAO getUsDAO() {
		return usDAO;
	}

	public void setUsDAO(UsuariosDAO usDAO) {
		this.usDAO = usDAO;
	}

	public BellezaDAO getBeDAO() {
		return beDAO;
	}

	public void setBeDAO(BellezaDAO beDAO) {
		this.beDAO = beDAO;
	}

	public DeportesDAO getDeDAO() {
		return deDAO;
	}

	public void setDeDAO(DeportesDAO deDAO) {
		this.deDAO = deDAO;
	}

	public HogarDAO getHoDAO() {
		return hoDAO;
	}

	public void setHoDAO(HogarDAO hoDAO) {
		this.hoDAO = hoDAO;
	}

	public JuguetesDAO getJuDAO() {
		return juDAO;
	}

	public void setJuDAO(JuguetesDAO juDAO) {
		this.juDAO = juDAO;
	}

	public LibrosDAO getLiDAO() {
		return liDAO;
	}

	public void setLiDAO(LibrosDAO liDAO) {
		this.liDAO = liDAO;
	}

	public MascotasDAO getMaDAO() {
		return maDAO;
	}

	public void setMaDAO(MascotasDAO maDAO) {
		this.maDAO = maDAO;
	}

	public MusicaDAO getMuDAO() {
		return muDAO;
	}

	public void setMuDAO(MusicaDAO muDAO) {
		this.muDAO = muDAO;
	}

	public RopaDAO getRoDAO() {
		return roDAO;
	}

	public void setRoDAO(RopaDAO roDAO) {
		this.roDAO = roDAO;
	}

	public TecnologiaDAO getTeDAO() {
		return teDAO;
	}

	public void setTeDAO(TecnologiaDAO teDAO) {
		this.teDAO = teDAO;
	}

	public VehiculosDAO getVeDAO() {
		return veDAO;
	}

	public void setVeDAO(VehiculosDAO veDAO) {
		this.veDAO = veDAO;
	}
	
}
