package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the param_trajet database table.
 * 
 */
@Entity
@Table(name="param_trajet")
@NamedQuery(name="ParamTrajet.findAll", query="SELECT p FROM ParamTrajet p")
public class ParamTrajet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="age_max")
	private byte ageMax;

	@Column(name="age_min")
	private byte ageMin;

	private boolean fumeur;

	@Column(name="id_user")
	private int idUser;

	public ParamTrajet() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getAgeMax() {
		return this.ageMax;
	}

	public void setAgeMax(byte ageMax) {
		this.ageMax = ageMax;
	}

	public byte getAgeMin() {
		return this.ageMin;
	}

	public void setAgeMin(byte ageMin) {
		this.ageMin = ageMin;
	}

	public boolean getFumeur() {
		return this.fumeur;
	}

	public void setFumeur(boolean fumeur) {
		this.fumeur = fumeur;
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

}