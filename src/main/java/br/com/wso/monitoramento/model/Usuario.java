package br.com.wso.monitoramento.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	@Id 
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long idUser;
	
	private String usuario;
		
	private String email;
	
	private String pass;
	
	private String tipoUser;

	//CONSTRUTER
	public Usuario() {
		super();
	}
	
	public Usuario(String email, String pass, String tipoUser) {
		super();
		this.email = email;
		this.pass = pass;
		this.tipoUser = tipoUser;
	}
	
	//GET E SET
	public Long getIdUser() {
		return idUser;
	}
	
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getTipoUser() {
		return tipoUser;
	}

	public void setTipoUser(String tipoUser) {
		this.tipoUser = tipoUser;
	}
	
		
	public String getUsuario() {
		return usuario;
	}

	public void setNmUsuario(String Usuario) {
		this.usuario = usuario;
	}

	//TO - STRING 
	@Override
	public String toString() {
		return "Usuario [idUser=" + idUser + ", Usuario=" + usuario + ", email=" + email + ", pass=" + pass
				+ ", tipoUser=" + tipoUser + "]";
	}
}
