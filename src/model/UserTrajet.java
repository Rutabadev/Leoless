package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_trajet database table.
 * 
 */
@Entity
@Table(name="user_trajet")
@NamedQuery(name="UserTrajet.findAll", query="SELECT u FROM UserTrajet u")
public class UserTrajet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private byte accepte;

	private byte attente;

	private String fonction;

	@Column(name="id_trajet")
	private int idTrajet;

	@Column(name="id_user")
	private int idUser;

	public UserTrajet() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getAccepte() {
		return this.accepte;
	}

	public void setAccepte(byte accepte) {
		this.accepte = accepte;
	}

	public byte getAttente() {
		return this.attente;
	}

	public void setAttente(byte attente) {
		this.attente = attente;
	}

	public String getFonction() {
		return this.fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public int getIdTrajet() {
		return this.idTrajet;
	}

	public void setIdTrajet(int idTrajet) {
		this.idTrajet = idTrajet;
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

}