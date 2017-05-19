package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the trajet database table.
 * 
 */
@Entity
@NamedQuery(name="Trajet.findAll", query="SELECT t FROM Trajet t")
public class Trajet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private float distance;

	@Column(name="horaire_depart")
	private Time horaireDepart;

	@Column(name="id_param")
	private int idParam;

	@Column(name="lat_depart")
	private float latDepart;

	@Column(name="long_depart")
	private float longDepart;

	@Column(name="nb_places")
	private int nbPlaces;

	private String nom;

	public Trajet() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getDistance() {
		return this.distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public Time getHoraireDepart() {
		return this.horaireDepart;
	}

	public void setHoraireDepart(Time horaireDepart) {
		this.horaireDepart = horaireDepart;
	}

	public int getIdParam() {
		return this.idParam;
	}

	public void setIdParam(int idParam) {
		this.idParam = idParam;
	}

	public float getLatDepart() {
		return this.latDepart;
	}

	public void setLatDepart(float latDepart) {
		this.latDepart = latDepart;
	}

	public float getLongDepart() {
		return this.longDepart;
	}

	public void setLongDepart(float longDepart) {
		this.longDepart = longDepart;
	}

	public int getNbPlaces() {
		return this.nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public static List<Trajet> getTrajetByUser() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Covoit");
		EntityManager em = factory.createEntityManager();
		Query qParam = em.createQuery("Select p FROM ParamTrajet p where p.idUser = 1");
		List<ParamTrajet> params = (List<ParamTrajet>)qParam.getResultList();
		List<Trajet> trajets = new ArrayList<Trajet>();
		for (ParamTrajet p : params) {
			Query qTrajet= em.createQuery("SELECT t FROM Trajet t WHERE t.idParam = :id");
			qTrajet.setParameter("id", p.getId());
			trajets.add((Trajet)qTrajet.getSingleResult());
		}
		em.close();
		factory.close();
		return trajets;
	}
	
	
}