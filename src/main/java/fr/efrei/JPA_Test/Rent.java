//Pour faire simple, nous avons rassemblé des classes. Celle-ci est donc en commentaire jusqu'à nouvel ordre.


/*package fr.efrei.JPA_Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class Rent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date beginRent;
	private Date endRent;	
	
	@ManyToOne
	private Person person;	
	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}	
	
	@ManyToOne
	private Vehicule vehicule;
	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	public Rent() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	public Rent(Date beginRent, Date endRent, Long id) {
		super();
		this.beginRent = beginRent;
		this.endRent = endRent;
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public Rent(String begin_date, String end_date) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateDebut = simpleDateFormat.parse(begin_date);
		setBeginRent(dateDebut);
		Date dateFin = simpleDateFormat.parse(end_date);
		setEndRent(dateFin);
	}
	public Date getBeginRent() {
		return beginRent;
	}
	public void setBeginRent(Date beginRent) {
		this.beginRent = beginRent;
	}
	public Date getEndRent() {
		return endRent;
	}
	public void setEndRent(Date endRent) {
		this.endRent = endRent;
	}
	

}
*/