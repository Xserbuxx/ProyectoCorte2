package co.edu.unbosque.model;

public class Usuario {

	private String nickname;
	private String contraseña;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(String nickname, String contraseña) {
		super();
		this.nickname = nickname;
		this.contraseña = contraseña;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Usuario [nickname=" + nickname + ", contraseña=" + contraseña + "]";
	}

}
