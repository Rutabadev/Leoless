package model;

import java.sql.Time;


/**
 * The persistent class for the trajet database table.
 * 
 */
public class TrajetShort {
	private static final long serialVersionUID = 1L;


	private float latDepart;

	private float longDepart;
	
	public TrajetShort(float latDepart, float longDepart) {
		super();
		this.latDepart = latDepart;
		this.longDepart = longDepart;
	}

	public float getLatDepart() {
		return latDepart;
	}

	public void setLatDepart(float latDepart) {
		this.latDepart = latDepart;
	}

	public float getLongDepart() {
		return longDepart;
	}

	public void setLongDepart(float longDepart) {
		this.longDepart = longDepart;
	}
}